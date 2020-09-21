package com.urunov.repository;

import com.urunov.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 18/09/2020
 * @Project is ManyMapping
 */
public interface TagRepository  extends JpaRepository<Tag, Long> {
}
