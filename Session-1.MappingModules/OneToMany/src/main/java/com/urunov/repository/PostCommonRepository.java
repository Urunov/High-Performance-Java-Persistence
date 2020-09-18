package com.urunov.repository;

import com.urunov.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: apple
 * @created on 13/09/2020
 * @Project is EssentialDB
 */
@Repository
public interface PostCommonRepository extends JpaRepository<PostComment, Long> {
}
