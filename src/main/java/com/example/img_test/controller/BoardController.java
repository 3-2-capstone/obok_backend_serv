package com.example.img_test.controller;
import com.example.img_test.entity.Board;
import com.example.img_test.entity.Data;
import com.example.img_test.service.BoardService;
import com.example.img_test.service.PythonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;
    private final PythonService pythonService;


    @PostMapping("/image_learn")
    public String createBoard(
            @Validated @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        String ret = boardService.addBoard(Board.builder()
                .build(), files);
        System.out.println(ret);
        //return ResponseEntity.ok().body(ret); // 추후 수정 필요 deep_images
        return ret;
    }

    @GetMapping("/location_data")
    public Data getData() {
        return new Data();
    }


    @GetMapping("/board")
    public String getBoard(@RequestParam long id) {
        Board board = boardService.findBoard(id).orElseThrow(RuntimeException::new);
        String imgPath = board.getStoredFileName();
        log.info(imgPath);
        return "<img src="+ imgPath + ">";
    }

    @GetMapping("/return_img/{id}")
    public ResponseEntity<byte[]> getBoardImage(@PathVariable long id) throws IOException {
        String imagePath = "/home/mooner92/obok/deep_images/" + id + ".jpg";
        // 이미지 파일을 읽어 바이트 배열로 변환
        File imageFile = new File(imagePath);
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
        return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    }
    @GetMapping("/return_txt")
    public String getBoard2(@RequestParam long id) {
        try {
            String txtValue = readTextFile("/home/mooner92/obok/deep_images/labels/" + id + ".txt"); // 텍스트 내용 가져오기
            return txtValue;
        } catch (IOException e) {
            // 예외 처리
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/return_txt/{id}")
    public String getBoardTxt(@PathVariable String id) throws IOException {
        try {
            String txtValue = readTextFile("/home/mooner92/obok/deep_images/labels/" + id + ".txt"); // 텍스트 내용 가져오기
            System.out.println("/home/mooner92/obok/deep_images/labels/" + id + ".txt");
            System.out.println("-------------------------");
            System.out.println(txtValue);
            return txtValue;
        } catch (IOException e) {
            // 예외 처리
            return "Error: " + e.getMessage();
        }
    }

    private String readTextFile(String filePath) throws IOException {
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
