package se.salt.jfs.jpaproducts.review;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface JpaReviewRepository extends MongoRepository <Review, String> {

    //List<Review> findReviewByProductGroupIn(String[] productGroup);
    List<Review> findReviewByProductGroupIn(String[] productGroup);

    List<Review> findReviewsByProductIdIn(String[] longs);





}
