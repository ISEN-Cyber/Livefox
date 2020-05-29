package com.example.uploadingfiles;

import java.io.IOException;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.uploadingfiles.storage.StorageFileNotFoundException;
import com.example.uploadingfiles.storage.StorageService;
import com.example.uploadingfiles.bean.VideoBean;
import com.example.uploadingfiles.proxies.VideoProxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class FileUploadController {

	private final StorageService storageService;

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public FileUploadController(StorageService storageService) {
		this.storageService = storageService;
	}

	

	@Autowired
	private VideoProxy videoProxy;

	@GetMapping("/upload")
	public String listUploadedFiles(Model model) throws IOException {

		return "upload";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			RedirectAttributes redirectAttributes) {

		storageService.store(file);
		String fileTitle = file.getOriginalFilename().substring(0, file.getOriginalFilename().lastIndexOf('.'));
		String fileNamePict = fileTitle + ".jpg";
		log.info("####### UPLOAD Name: "+fileTitle);
		log.info("####### UPLOAD Video: "+file.getOriginalFilename());
		log.info("####### UPLOAD Pict: "+fileNamePict);

		String path = "/livefox/video/"+file.getOriginalFilename();
		String pathEnc ="/livefox/enc/"+fileTitle;
		String pict = "/livefox/img/"+fileNamePict;
		

		Process process;
		try {
			
			ProcessBuilder processBuilder = new ProcessBuilder();
			processBuilder.command("/bin/bash","/encoding.sh",path,pathEnc,pict);

			process = processBuilder.start();

			log.info("waiting end of encoding...");
			int exitcode = process.waitFor();
			log.info("encoding finish");
			videoProxy.addVideo(fileTitle, path, pict);
			return "sucess";

		}catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

		return "error";
	}


	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}

}
   
        