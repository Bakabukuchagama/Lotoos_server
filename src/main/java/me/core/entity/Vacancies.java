package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.UUID;

@Entity
@Table(name = "vacancies_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacancies {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String description;
    private Blob image;
}
