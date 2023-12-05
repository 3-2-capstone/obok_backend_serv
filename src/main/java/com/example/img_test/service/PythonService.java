package com.example.img_test.service;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

@Service
public class PythonService {
    private static final String PYTHON_SCRIPT_PATH = "/home/mooner92/obok/pyfile/pyolo.py";

    public String runPythonScript(String imagePath) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("python3", PYTHON_SCRIPT_PATH, "/home/mooner92/obok/" + imagePath);
            System.out.println("/home/obok/" + imagePath);
            Process process = processBuilder.start();

            if (process.waitFor(20, TimeUnit.MINUTES)) {
                String pythonOutput = readOutput(process.getInputStream());
                System.out.println(pythonOutput);
                return pythonOutput;
            } else {
                return "파이썬 스크립트 실행 실패";
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "파이썬 스크립트 실행 중 오류 발생";
        }
    }

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
