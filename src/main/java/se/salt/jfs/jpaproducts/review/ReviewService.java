package se.salt.jfs.jpaproducts.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    ReviewRepository reviewRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.listReviews();
    }


    public Review getReviewById(String reviewId) {
        return reviewRepository.getReviewById(reviewId);
    }

    public List<Review> getReviewsByProductId(String[] productId) {
        return reviewRepository.getReviewsForProductIds(productId);
    }

    public List<Review> getReviewsByGroupName(String[] groupname) {
        return reviewRepository.getReviewsForGroups(groupname);
    }

    public Review addReview(Review review) {
        return reviewRepository.saveProductReview(review);
    }

    public Review updateReview(Review review) {
        return reviewRepository.saveProductReview(review);
    }
}
