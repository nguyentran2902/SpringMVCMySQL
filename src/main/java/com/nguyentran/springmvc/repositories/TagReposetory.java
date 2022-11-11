package com.nguyentran.springmvc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nguyentran.springmvc.models.Tag;

@Repository
public interface TagReposetory extends JpaRepository<Tag, Integer>{

}
