package com.example.testtaskjsontoxml.dto;

import com.example.testtaskjsontoxml.entity.DocumentType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@NoArgsConstructor
@Getter
@Setter
public class DocumentDto {

    @NotBlank(message = "Series is mandatory")
    private String series;

    @NotBlank(message = "Number is mandatory")
    private String number;

    @NotNull(message = "Issue date is mandatory")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate issueDate;

    @NotNull(message = "Document type is mandatory")
    private DocumentType type;

    @Override
    public String toString() {
        return "{" +
                "series :" + series +
                ", number :" + number +
                ", issueDate :" + issueDate +
                ", type :" + type +
                '}';
    }
}
