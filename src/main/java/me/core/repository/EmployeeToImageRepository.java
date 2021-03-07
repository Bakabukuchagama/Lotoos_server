package me.core.repository;

import me.core.entity.Employee;
import me.core.entity.EmployeeToImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface EmployeeToImageRepository extends JpaRepository<EmployeeToImage, UUID> {

    List<EmployeeToImage> findAllByEmployee_Id(UUID id);

}
