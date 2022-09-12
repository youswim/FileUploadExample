package com.example.file_upload_example;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardPictureRepository boardPictureRepository;
    private final FileHandler fileHandler;

    public Board addBoard(Board board, List<MultipartFile> files)
            throws Exception {

        // 파일을 저장하고, 파일들에 대한 정보가 담긴 List<BoardPicture>를 받는다.
        List<BoardPicture> list = fileHandler.parseFileInfo(board, files);

        if(list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }

        else{
            boardRepository.save(board);
            boardPictureRepository.saveAll(list);
            board.setPictures(list);
        }

        board.setReportedDate(new Date().toString());

        return boardRepository.save(board);
    }
}