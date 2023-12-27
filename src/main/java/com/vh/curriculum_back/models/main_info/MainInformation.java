package com.vh.curriculum_back.models.main_info;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "main_information")
@Entity(name = "MainInformation")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class MainInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String city;
    private String description;
}
