package com.example.img_test.controller;
import com.example.img_test.entity.Board;
import com.example.img_test.entity.Data;
import com.example.img_test.service.BoardService;
import com.example.img_test.service.PythonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {
    
    private final BoardService boardService;
    private final PythonService pythonService;

/*
    @PostMapping("/board")
    public ResponseEntity<?> createBoard(
            @Validated @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        boardService.addBoard(Board.builder()
                .build(), files);

        return ResponseEntity.ok().build();
    }
 */

    @PostMapping("/image_learn")
    public ResponseEntity<String> createBoard(
            @Validated @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        String ret = boardService.addBoard(Board.builder()
                .build(), files);

        return ResponseEntity.ok().body("home/"+ret); // 추후 수정 필요 deep_images
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



}
