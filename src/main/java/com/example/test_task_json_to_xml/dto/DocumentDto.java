package com.example.test_task_json_to_xml.dto;

import com.example.test_task_json_to_xml.entity.DocumentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
public class DocumentDto {

    private String series;

    private String number;

    private LocalDate issueDate;

    private String type;

}
