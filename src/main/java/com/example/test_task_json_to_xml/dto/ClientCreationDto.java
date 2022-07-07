package com.example.test_task_json_to_xml.dto;

import com.example.test_task_json_to_xml.entity.Gender;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class ClientCreationDto {

    private String name;

    private String surname;

    private String patronymic;

    private LocalDate birthDate;

    private Gender gender;

    private DocumentDto document;

    @Override
    public String toString() {
        return "{" +
                "name :" + name +
                ", surname :" + surname +
                ", patronymic :" + patronymic +
                ", birthDate :" + birthDate +
                ", gender : " + gender +
                ", document :" + document +
                '}';
    }
}
