package com.example.file_upload_example;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardPictureRepository boardPictureRepository;
    private final FileHandler fileHandler;

    public Board addBoard(
            Board board,
            List<MultipartFile> files
    ) throws Exception {
        // 파일을 저장하고 그 BoardPicture 에 대한 list 를 가지고 있는다
        List<BoardPicture> list = fileHandler.parseFileInfo(board.getId(), files);

        if(list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            List<BoardPicture> pictureBeans = new ArrayList<>();
            for(BoardPicture boardPicture : list) {
                pictureBeans.add(boardPictureRepository.save(boardPicture));
            }
            board.setPictures(pictureBeans);
        }

        board.setReported_date(new Date().toString());

        return boardRepository.save(board);
    }
}