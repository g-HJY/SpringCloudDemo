package com.example.eurekaconsumer;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Component
public class HelloRemoteHystrix implements HelloRemote {

    @Override
    public String hello(@RequestParam(value = "name") String name) {
        return "服务已经挂掉";
    }

    @Override
    public String handleFileUpload(MultipartFile file) {
        return "出错了";
    }
}