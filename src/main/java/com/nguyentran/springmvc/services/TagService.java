package com.nguyentran.springmvc.services;

import java.util.List;
import java.util.Optional;

import com.nguyentran.springmvc.models.Tag;



public interface TagService {

	List<Tag> getAllTags();

	Optional<Tag> getTagById(int id);

}
