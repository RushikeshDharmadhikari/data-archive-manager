package com.dataarchiver.controller;

import java.util.List;

import javax.persistence.EntityListeners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dataarchiver.dto.StudentDto;
import com.dataarchiver.entity.ArchivalDeletionStrategy;
import com.dataarchiver.entity.Student;
import com.dataarchiver.repository.ArchivalDeletionStrategyRepository;
import com.dataarchiver.repository.StudentRepository;

@RestController
@EntityListeners(AuditingEntityListener.class)
public class ArchiverController {
	
	@Autowired
	ArchivalDeletionStrategyRepository archivalDeletionStrategyRepository;

	@Autowired
	StudentRepository studentRepository;

	@PostMapping("/student-archives")
	List<Student> addStudent(@RequestBody StudentDto studentDto) {
		return studentRepository.saveAll(studentDto.getStudents());
	}

	@GetMapping("/student-archives")
	List<Student> all() {
		return studentRepository.findAll();
	}
	
	@PostMapping(path = "/deletion-strategies")
	ArchivalDeletionStrategy createArchivalDeletionStrategy(@RequestBody ArchivalDeletionStrategy archivalStrategy) {
		return archivalDeletionStrategyRepository.save(archivalStrategy);
	}

	@GetMapping(path = "/deletion-strategies")
	List<ArchivalDeletionStrategy> getAllArchivalDeletionStrategies() {
		return archivalDeletionStrategyRepository.findAll();
	}
	

}
