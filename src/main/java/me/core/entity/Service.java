package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "services_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Service {
    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private Integer cost;
    private String where;
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private List<ServiceToImage> serviceToImages = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "service")
    private List<Sale> sales = new ArrayList<>();
}
