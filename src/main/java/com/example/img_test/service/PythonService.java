package com.example.img_test.service;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Service
public class PythonService {
    public String runPythonScript(String scriptPath, String imagePath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", scriptPath, imagePath);
        Process process = processBuilder.start();

        // 파이썬 스크립트 실행 완료까지 대기
        if (process.waitFor(5, TimeUnit.MINUTES)) {
            // 스크립트 실행이 정상적으로 완료됨
            return readOutput(process.getInputStream());
        } else {
            // 스크립트 실행 시간 초과 또는 오류 발생
            return "파이썬 스크립트 실행 실패";
        }
    }

    //파이썬에서 값을 읽어들이는 함수
    private String readOutput(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line);
            }
        }
        return output.toString();
    }
}

