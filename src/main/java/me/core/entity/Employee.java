package me.core.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "employee_t")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {

  @Id
  @GeneratedValue

  private UUID id;

  private String name;
  private String job;
  private String where;
  private String description;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
  private List<EmployeeToImage> employeeToImages;



}
