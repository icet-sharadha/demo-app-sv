package edu.icet.service.impl;

import edu.icet.dto.StudentDto;
import edu.icet.entity.StudentEntity;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;
    @Autowired
    ModelMapper mapper;

    @Override
    public void addStudent(StudentDto student) {
        StudentEntity entity = mapper.map(student, StudentEntity.class);
        repository.save(entity);
    }

    @Override
    public void updateStudent(StudentDto student) {
        repository.save(mapper.map(student,StudentEntity.class));
    }

    @Override
    public void deleteStudent(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public StudentDto searchById(Integer id) {
        StudentEntity studentEntity = repository.findById(id).get();
        StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);
        return studentDto;
    }

    @Override
    public List<StudentDto> getAll() {
        List<StudentEntity> studentEntities = repository.findAll();
        ArrayList<StudentDto> studentDtoArrayList = new ArrayList<>();
        studentEntities.forEach(studentEntity -> {
            StudentDto studentDto = mapper.map(studentEntity, StudentDto.class);
            studentDtoArrayList.add(studentDto);
        });

        return studentDtoArrayList;

    }
}
