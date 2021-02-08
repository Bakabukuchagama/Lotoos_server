package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.UUID;

@Entity
@Table(name = "employee_image_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeToImage {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn(name="id_employee")
    private Employee employee;
    private Blob image;
}
