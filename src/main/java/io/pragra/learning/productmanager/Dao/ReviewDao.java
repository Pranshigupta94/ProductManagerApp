package io.pragra.learning.productmanager.Dao;

import io.pragra.learning.productmanager.Entity.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewDao {
private final JdbcTemplate jdbcTemplate;

public ReviewDao(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
}

public Review addReview(int productId, Review review) {
    String sql = "INSERT INTO REVIEW VALUES(?, ?, ?, ?)";
    Integer integer = jdbcTemplate.queryForObject("Select next value for review_id_seq", Integer.class);
    review.setId(integer);

   int update = jdbcTemplate.update(sql, review.getId(),productId, review.getReview(), review.getReviewDate());
    return review;
}
}





