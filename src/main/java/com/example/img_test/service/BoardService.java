package com.example.img_test.service;

import com.example.img_test.controller.FileHandler;
import com.example.img_test.entity.Board;
import com.example.img_test.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    private final FileHandler fileHandler;
    private final PythonService pythonService;


    @Autowired
    public BoardService(BoardRepository boardRepository, PythonService pythonService) {
        this.boardRepository = boardRepository;
        this.fileHandler = new FileHandler();
        this.pythonService = pythonService;
    }

    public String addBoard(
            Board board,
            List<MultipartFile> files
    ) throws Exception {
        // 파일을 저장하고 그 Board 에 대한 list 를 가지고 있는다
        List<Board> list = fileHandler.parseFileInfo(board.getId(), files);
        if (list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            List<Board> pictureBeans = new ArrayList<>();
            for (Board boards : list) {
                pictureBeans.add(boardRepository.save(boards));
            }
        }
        boardRepository.save(board);
        System.out.println("--------------------------------------");
        System.out.println(list.get(0).getStoredFileName());
        System.out.println(list.get(0).getBoardIdx());
        System.out.println(list.get(0).getFileSize());
        System.out.println("--------------------------------------");
        String address = pythonService.runPythonScript(list.get(0).getStoredFileName());
        System.out.println(address);
        return address;
    }

    public List<Board> findBoards() {
        return boardRepository.findAll();
    }

    public Optional<Board> findBoard(Long id) {
        return boardRepository.findById(id);
    }

}
