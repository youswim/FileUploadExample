package com.example.file_upload_example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

//@CrossOrigin
@RestController
public class BoardController {
    @Autowired
    private BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> createBoard(
            @Valid @RequestParam("user") String User,
            @Valid @RequestParam("content") String content,
            @Valid @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        Board board = boardService.addBoard(Board.builder()
                .user(user)
                .content(content)
                .build(), files);

        URI uriLocation = new URI("/board/" + board.getID());
        return ResponseEntity.created(uriLocation).body("{}");
    }
}
