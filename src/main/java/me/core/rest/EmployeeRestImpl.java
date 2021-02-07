package me.core.rest;

import lombok.RequiredArgsConstructor;
import me.core.dto.EmployeeDto;
import me.core.mapper.EmployeeMapper;
import me.core.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmployeeRestImpl implements EmployeeRest {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;

  @Override
  public ResponseEntity<EmployeeDto> getByName(String name) {
    return ResponseEntity.ok(employeeMapper.toDto(employeeRepository.getByName(name)));


  }

  @Override
  public void addEmployee(EmployeeDto employee) {
    employeeRepository.save(employeeMapper.toEntity(employee));
  }
}
