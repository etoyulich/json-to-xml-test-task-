package com.example.test_task_json_to_xml.dto;

import com.example.test_task_json_to_xml.entity.Gender;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserCreationDto {

    private String name;

    private String surname;

    private String patronymic;

    private LocalDate birthDate;

    private Gender gender;

    private DocumentDto document;
}
