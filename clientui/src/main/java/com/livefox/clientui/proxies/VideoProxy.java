package com.livefox.clientui.proxies;


import com.livefox.clientui.bean.VideoBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "microservice-video")
@RibbonClient(name = "microservice-video")
public interface VideoProxy {

    @GetMapping(value = "/video")
    List<VideoBean> listVideo();

    @GetMapping(value = "/video/{id}")
    VideoBean showVideo(@PathVariable("id") int id);

    @PostMapping(value = "/video/add")
    public void addVideo (@Valid @RequestBody VideoBean video);

    @DeleteMapping(value = "/video/delete/{id]")
    public void deleteVideo(@PathVariable int id);

    @PutMapping(value = "/video/update/{id}")
    public void updateVideo (@RequestBody VideoBean video);


}
