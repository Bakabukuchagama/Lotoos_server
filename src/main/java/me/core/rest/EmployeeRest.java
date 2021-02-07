package me.core.rest;

import me.core.dto.EmployeeDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public interface EmployeeRest {

  @GetMapping("/api/user/{name}")
  ResponseEntity<EmployeeDto> getByName(@PathVariable("name") String name);

  @PostMapping("/api/user/")
  void addEmployee(@RequestBody EmployeeDto employee);

}
