package com.example.file_upload_example;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BoardPictureRepository extends CrudRepository<BoardPicture, Integer> {
    BoardPicture save(BoardPicture boardPicture);

    List<BoardPicture> findAllByBoardIdx(Integer boardIdx);
}
