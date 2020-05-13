package com.livefox.clientui.controller;

import com.livefox.clientui.bean.VideoBean;
import com.livefox.clientui.proxies.VideoProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ClientController {

    @Autowired
    VideoProxy videoProxy;

    Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String home(Model model){
        List<VideoBean> videos= videoProxy.listVideo();
        model.addAttribute("videos", videos);
        log.info("Request home page");
        return "Home";
    }
}
