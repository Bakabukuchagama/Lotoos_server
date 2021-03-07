package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.util.UUID;

@Entity
@Table(name = "services_image_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ServiceToImage {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_services")
    private Service service;
    @Lob
    private Blob image;
}
