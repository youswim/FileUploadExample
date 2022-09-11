package com.example.file_upload_example;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<?> createBoard(
            @Valid @RequestParam("user") String user,
            @Valid @RequestParam("content") String content,
            @Valid @RequestParam("files") List<MultipartFile> files
    ) throws Exception {
        Board board = boardService.addBoard(Board.builder()
                .users(user)
                .contents(content)
                .build(), files);

        URI uriLocation = new URI("/board/" + board.getId());
        return ResponseEntity.created(uriLocation).body("{}");
    }
}
