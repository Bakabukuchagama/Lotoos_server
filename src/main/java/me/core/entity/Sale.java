package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.UUID;

@Entity
@Table(name = "sales_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sale {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_services")
    private Service service;
    private String description;
    private Blob image;
}