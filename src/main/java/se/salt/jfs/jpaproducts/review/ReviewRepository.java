package se.salt.jfs.jpaproducts.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReviewRepository implements IProductReviewRepository {

    @Autowired
    private JpaReviewRepository jpaReviewRepository;


    @Override
    public Review saveProductReview(Review review) {
        return jpaReviewRepository.save(review);
    }

    @Override
    public List<Review> listReviews() {
        return jpaReviewRepository.findAll();
    }

    @Override
    public List<Review> getReviewsForGroups(String[] productGroups) {
        return jpaReviewRepository.findReviewByProductGroupIn(productGroups);
    }

    @Override
    public List<Review> getReviewsForProductIds(String[] ids) {
        return jpaReviewRepository.findReviewsByProductIdIn(ids);

    }

    @Override
    public Review getReviewById(String reviewId) {
        return jpaReviewRepository.findById(reviewId).orElseThrow();
    }



}
