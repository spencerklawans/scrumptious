package com.scrumptious.logic.backend.repository;

import com.scrumptious.logic.backend.entity.Project;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
	Project findByNameAndDescription(String name, String description);
}
