package com.example.test_task_json_to_xml.entity;

import com.example.test_task_json_to_xml.dto.DocumentDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "documents", schema = "client")
public class DocumentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "series", nullable = false)
    private String series;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "issue_date", nullable = false)
    private LocalDate issueDate;

    @Column(name = "type", nullable = false)
    private String documentType;

    public DocumentEntity(DocumentDto dto) {
        series = dto.getSeries();
        number = dto.getNumber();
        issueDate = dto.getIssueDate();
        documentType = dto.getType();
    }
}
