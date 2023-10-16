package com.dataarchiver.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dataarchiver.entity.ArchivalDeletionStrategy;
import com.dataarchiver.entity.Student;
import com.dataarchiver.entity.TimeUnit;
import com.dataarchiver.repository.ArchivalDeletionStrategyRepository;
import com.dataarchiver.repository.StudentRepository;

@Service
public class DataArchivingService {

	private static final String STUDENT = "student";

	@Autowired
	ArchivalDeletionStrategyRepository archivalStrategyService;

	@Autowired
	StudentRepository studentRepository;

	/**
	 * TODO: Use a factory pattern here
	 */
	public void deleteArchivedData() {

		System.out.println("Deleting the archived data by reading the archival strategies.");
		System.out.println();
		System.out.println();
		
		List<ArchivalDeletionStrategy> archivalStrategies = archivalStrategyService.findAll();
		System.out.println(String.format("ArchivalStratgies : %s", archivalStrategies));
		System.out.println();
		System.out.println();

		for (ArchivalDeletionStrategy archivalStrategy : archivalStrategies) {
			if (archivalStrategy.getTableName().equalsIgnoreCase(STUDENT)) {
				handleStudentArchival(archivalStrategy);
			}
		}
		return;

	}

	private void handleStudentArchival(ArchivalDeletionStrategy archivalStrategy) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());

		if (archivalStrategy.getArchiveUnit().equals(TimeUnit.MONTHS)) {
			calendar.add(Calendar.MONTH, -1 * archivalStrategy.getArchiveValue());
		} else if (archivalStrategy.getArchiveUnit().equals(TimeUnit.YEARS)) {
			calendar.add(Calendar.YEAR, -1 * archivalStrategy.getArchiveValue());
		}

		Date expectedDate = calendar.getTime();
		List<Student> students = studentRepository.findByCreatedAtBefore(expectedDate);
		studentRepository.deleteAll(students);

	}
}
