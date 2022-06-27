package com.example.test_task_json_to_xml.dto;

import com.example.test_task_json_to_xml.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UserCreationDto {

    private String name;

    private String surname;

    private String patronymic;

    private LocalDate birthDate;

    private String gender;

    private DocumentDto document;
}
