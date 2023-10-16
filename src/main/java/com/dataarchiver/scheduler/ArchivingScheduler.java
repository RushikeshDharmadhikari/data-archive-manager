package com.dataarchiver.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.dataarchiver.service.DataArchivingService;

@Service
public class ArchivingScheduler {

	@Autowired
	private DataArchivingService dataArchivingService;

	@Scheduled(cron = "*/55 * * * * *") // Run every day at 1 AM
	public void archiveData() {
		System.out.println();
		System.out.println("Calling the archival service for data archival.");
		System.out.println();
		System.out.println();
		dataArchivingService.deleteArchivedData();
	}

}
