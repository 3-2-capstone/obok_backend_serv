package com.example.img_test.service;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
public class ReturnService {
    public String returnImage(Long id){
        return "/home/mooner92/obok/deep_images/"+id+".jpg";
    }
    public String returnTxt(Long id) throws IOException {
        String learn_img_path = "/home/mooner92/obok/deep_images/labels/"+id+".txt";
        String p = readTextFile(learn_img_path);
        return p;
    }

    public String readTextFile(String filePath) throws IOException {
        File file = new File(filePath);

        if (!file.exists()) {
            // 파일이 존재하지 않는 경우 처리
            return "File not found";
        }

        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] data = new byte[(int) file.length()];
            fis.read(data);
            return new String(data, StandardCharsets.UTF_8);
        }
    }
}
