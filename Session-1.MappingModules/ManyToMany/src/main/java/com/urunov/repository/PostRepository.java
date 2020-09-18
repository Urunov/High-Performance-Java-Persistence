package com.urunov.repository;

import com.urunov.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: apple
 * @created on 18/09/2020
 * @Project is ManyMapping
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
