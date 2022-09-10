package com.example.file_upload_example;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Builder
@Entity
@Data
public class Board {

//    @Id
    private Long id;

    private String user;

    private String content;

    private List<MultipartFile> pictures;


    public Board() {

    }
}
