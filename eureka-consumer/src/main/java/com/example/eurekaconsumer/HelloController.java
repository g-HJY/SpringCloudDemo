package com.example.eurekaconsumer;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @Resource
    HelloRemote helloRemote;

    @GetMapping("/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.hello(name + "!");
    }

    @PostMapping( "/upload/file")
    public String fileUpload(@RequestPart(value = "file") MultipartFile file){
        return helloRemote.handleFileUpload(file);
    }
}