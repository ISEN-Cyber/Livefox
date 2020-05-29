package com.example.uploadingfiles.proxies;


import com.example.uploadingfiles.bean.VideoBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "mvideo-client", url = "mvideo-client:9001")
public interface VideoProxy {

    @GetMapping(value = "/video")
    public @ResponseBody Iterable<VideoBean> listVideo();

    @PostMapping(path = "/video/add")
    public @ResponseBody String addVideo (@RequestParam String fileTitle,@RequestParam String videoPath,@RequestParam String pictPath);

}
