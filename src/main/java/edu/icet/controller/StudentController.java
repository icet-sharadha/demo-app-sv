package edu.icet.controller;

import edu.icet.dto.StudentDto;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService service;

    @PostMapping("/add")
    public void addStudent(@RequestBody StudentDto studentDto){
        service.addStudent(studentDto);
    }
    @PutMapping("/update")
    public void updateStudent(@RequestBody StudentDto studentDto){
        service.updateStudent(studentDto);
    }

    @DeleteMapping("/delete-by-id/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteStudent(id);
    }

    @GetMapping("/get-all")
    public List<StudentDto> getAll(){
       return service.getAll();
    }


}
