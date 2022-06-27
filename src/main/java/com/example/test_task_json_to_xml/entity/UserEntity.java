package com.example.test_task_json_to_xml.entity;

import com.example.test_task_json_to_xml.dto.UserCreationDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users", schema = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "gender", nullable = false)
    private String gender;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "document_id", nullable = false, referencedColumnName = "id")
    private DocumentEntity document;

    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;

    public UserEntity(UserCreationDto dto) {
        surname = dto.getSurname();
        name = dto.getName();
        patronymic = dto.getPatronymic();
        birthDate = dto.getBirthDate();
        gender = dto.getGender();
        document = new DocumentEntity(dto.getDocument());
    }
}
