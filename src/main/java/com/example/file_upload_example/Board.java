package com.example.file_upload_example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="BOARD_TABLE")
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue
    private Long id;

    private String users;

    private String contents;

    private String reportedDate;

    @OneToMany(mappedBy = "board")
    private List<BoardPicture> pictures;

}
