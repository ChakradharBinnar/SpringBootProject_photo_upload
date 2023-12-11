package com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.Images;

@Repository
public interface UploadRepo extends JpaRepository<Images, Integer> {

}
