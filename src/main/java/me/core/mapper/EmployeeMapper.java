package me.core.mapper;

import me.core.dto.EmployeeDto;
import me.core.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  Employee toEntity(EmployeeDto dto);

  //@Mapping(target = "id", ignore = true)
  EmployeeDto toDto(Employee dto);

}
