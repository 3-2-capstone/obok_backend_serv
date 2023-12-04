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
        //ProcessBuilder processBuilder = new ProcessBuilder("python3", scriptPath, imagePath);
        //Process process = processBuilder.start();
        String pythonScriptPath = "/home/mooner92/obok/yolov5/detect.py";
        String weightsPath = "/home/mooner92/obok/pyfile/best.pt";
        String imgPath = imagePath;
        String command = String.format("python3 %s --weights %s --img 640 --conf 0.01 --source %s --save-conf --line-thickness 4", pythonScriptPath, weightsPath, imgPath);
        Process process = Runtime.getRuntime().exec(command);

        // 파이썬 스크립트 실행 완료까지 대기
        if (process.waitFor(20, TimeUnit.MINUTES)) {
            // 스크립트 실행이 정상적으로 완료됨
            String path = readOutput(process.getInputStream());
            System.out.println(path);
            /*
            String[] paths = path.split("Results saved to");
            if (paths.length > 1) {
                String resultPath = paths[1].trim(); // 분할된 두 번째 부분 가져오기
                return resultPath;
            }
             */
            return path;
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

