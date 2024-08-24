package com.sree.app.sreeSimpleApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
public class AppController {

    // receive content as a json and save the json in a local file

    @PostMapping("/content")
    public String postContent(@RequestBody String content) throws IOException {
        // save the content in a file
        File file = new File("content.txt");
        // write the content to the file
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(content.getBytes());

        return "Content saved successfully";


    }

    @GetMapping("/content")
    public String getContent() throws IOException {
        File file = new File("content.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] data = new byte[(int) file.length()];
        fileInputStream.read(data);
        return new String(data);
    }
}
