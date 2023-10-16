package com.dataarchiver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dataarchiver.entity.ArchivalDeletionStrategy;

public interface ArchivalDeletionStrategyRepository extends JpaRepository<ArchivalDeletionStrategy, Long> {

}
