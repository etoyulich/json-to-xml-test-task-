package com.example.testtaskjsontoxml.dto;

import com.example.testtaskjsontoxml.entity.Gender;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@JsonRootName(value = "person")
public class ClientCreationDto {
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Surname is mandatory")
    private String surname;

    private String patronymic;

    @NotNull(message = "Birthdate is mandatory")
    private LocalDate birthDate;

    @NotNull(message = "Gender is mandatory")
    private Gender gender;

    @NotNull(message = "Document is mandatory")
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
