package me.core.rest;

import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import me.core.dto.EmployeeDto;
import me.core.entity.Employee;
import me.core.entity.EmployeeToImage;
import me.core.mapper.EmployeeMapper;
import me.core.repository.EmployeeRepository;
import me.core.repository.EmployeeToImageRepository;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.rmi.server.UID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeRestImpl implements EmployeeRest {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;
  private final EmployeeToImageRepository employeeToImageRepository;

  @Override
  public ResponseEntity<EmployeeDto> getByName(String name) {
    return ResponseEntity.ok(employeeMapper.toDto(employeeRepository.getByName(name)));
  }

  @Override
  public void addEmployee(EmployeeDto employee) {
    employeeRepository.save(employeeMapper.toEntity(employee));
  }

    @Override
    public ResponseEntity uploadImage(MultipartFile file, UUID id) throws IOException {
      EmployeeToImage employeeToImage = new EmployeeToImage();
      Employee employee = employeeRepository.getOne(id);
      employeeToImage.setImage(file.getBytes());
      employeeToImage.setEmployee(employee);
      employeeToImageRepository.save(employeeToImage);
        return ResponseEntity.ok().build();
    }

  @Override
  public ResponseEntity<Resource> getImage(UUID id) throws IOException {

    EmployeeToImage employeeToImage = employeeToImageRepository.getOne(id);
    System.out.println("image");
    File tempFile = File.createTempFile("egor", ".jpeg", null);
    FileOutputStream fos = new FileOutputStream(tempFile);
    fos.write(employeeToImage.getImage());
    Resource resource = new InputStreamResource(new FileInputStream(tempFile));

    return ResponseEntity.ok()
            .contentType(MediaType.IMAGE_JPEG)
            .contentLength(tempFile.length())
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename="+tempFile.getName())
            .body(resource);
  }

  @Override
  public ResponseEntity<List<UUID>> findById_Employee(UUID id) {
    List<EmployeeToImage> employeeToImageOptional = employeeToImageRepository.findAllByEmployee_Id(id);
   List<UUID> uuidList = employeeToImageOptional.stream().map(EmployeeToImage::getId).collect(Collectors.toList());

    return ResponseEntity.ok(uuidList);
  }
}
