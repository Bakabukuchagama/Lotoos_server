package me.core.rest;

import me.core.dto.EmployeeDto;
import me.core.entity.Employee;
import me.core.entity.EmployeeToImage;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping
public interface EmployeeRest {

  @GetMapping("/api/user/{name}")
  ResponseEntity<EmployeeDto> getByName(@PathVariable("name") String name);

  @PostMapping("/api/user/")
  void addEmployee(@RequestBody EmployeeDto employee);

  @PostMapping("/api/user/{id}/uploadimage")
  ResponseEntity uploadImage(@RequestBody MultipartFile file, @PathVariable("id") UUID id) throws IOException;

  @GetMapping("/api/user/image/{id}")
  ResponseEntity<Resource> getImage(@PathVariable("id") UUID id) throws IOException;

  @GetMapping("/api/user/images/{id}")
  ResponseEntity<List<UUID>> findById_Employee(@PathVariable("id") UUID id) throws Exception;
}
