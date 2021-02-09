package me.core.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.core.entity.Service;
import java.sql.Blob;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDto {

    private UUID id;

    private String name;
    private Service service;
    private String description;
    private Blob image;
}
