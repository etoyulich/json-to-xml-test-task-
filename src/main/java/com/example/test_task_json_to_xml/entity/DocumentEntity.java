package com.example.test_task_json_to_xml.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "documents", schema = "user")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "issueDate", nullable = false)
    private LocalDate issueDate;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private DocumentType documentType;
}
