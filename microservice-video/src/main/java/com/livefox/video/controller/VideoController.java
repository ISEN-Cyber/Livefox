package com.livefox.video.controller;

import com.livefox.video.exception.VideoNotFoundException;
import com.livefox.video.model.Video;
import com.livefox.video.repository.VideoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @GetMapping(value = "/video")
    public List<Video> listVideo(){
        List<Video> video = videoRepository.findAll();
        if(video.isEmpty()) throw new VideoNotFoundException("Aucune video disponible");

        log.info("Find all videos");
        return video ;
    }

    @GetMapping(value = "/video/{id}")
    public Video showVideo(@PathVariable int id){
        Video video = videoRepository.findById(id);

        if(video == null) throw new VideoNotFoundException("Cette video n'existe pas");
        log.info("Request video by id: " + video.getId());
        return video;
    }

    @PostMapping(value = "/video/add")
    public void addVideo (@RequestBody Video video){
        videoRepository.save(video);
        log.info("add a video: " + video.toString());
    }

    @GetMapping(value = "/video/delete/{id]")
    public void deleteVideo(@PathVariable int id){
        log.info("delete the video id: " + id);
        videoRepository.deleteById(id);
    }

    @PostMapping(value = "/video/update/{id}")
    public void updateVideo (@RequestBody Video video){
        log.info("update a video: " + video.toString());
        videoRepository.save(video);
    }

}
