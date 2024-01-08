package com.escolago.storage;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private String LocalPath;
    private String RemotePath;

}