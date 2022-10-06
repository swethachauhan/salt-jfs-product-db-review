package se.salt.jfs.jpaproducts.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    ResponseEntity<List<Review>> askServiceToGetAllReviews() {
        System.out.println("Hello controller here");
        return ResponseEntity.ok().body(reviewService.getAllReviews());
    }

    @GetMapping("/reviews/:{reviewId}")
    ResponseEntity<Review> getReview(@PathVariable String reviewId) {
        Review review = reviewService.getReviewById(reviewId);
        return ResponseEntity.ok(review);
    }

    @GetMapping("/reviews")
    ResponseEntity<List<Review>> getReviewsByProductId(@RequestParam String[] productId) {
        System.out.println("this is the request param: " + productId[0]);
        List<Review> listOfReview = reviewService.getReviewsByProductId(productId);

        return ResponseEntity.ok(listOfReview);
    }

    @GetMapping("/review")
    ResponseEntity<List<Review>> getReviewsByGroupName(@RequestParam String... group) {
        System.out.println("this is the request param: " + group[0]);
        List<Review> listOfReviewsByGroupName = reviewService.getReviewsByGroupName(group);
        return ResponseEntity.ok(listOfReviewsByGroupName);
    }

    @PostMapping("/review")
    ResponseEntity<Review> addReview(@RequestBody Review body) {
        Review review = reviewService.addReview(body);
        return ResponseEntity.ok(review);
    }

    @PostMapping("/review/:{reviewId}/upvote")
    ResponseEntity<Review> addUpvotes(@PathVariable String reviewId, @RequestBody Upvote upvotes) {
        Review review = reviewService.getReviewById(reviewId);
        review.setUpVotes(upvotes.getUpvotes());
        review = reviewService.updateReview(review);
        return ResponseEntity.ok(review);
    }

    @DeleteMapping("/review/:{reviewId}/upvote")
    ResponseEntity<Review> removeUpvotes(@PathVariable String reviewId, @RequestBody Upvote upvotes) {
        Review review = reviewService.getReviewById(reviewId);
        String[] beforeRemoving = review.getUpVotes();
        String[] arrayAfterRemoving;
        List<String> beforeStrings = Arrays.asList(beforeRemoving);
        List<String> upvoteList = Arrays.asList(upvotes.getUpvotes());
        beforeStrings.removeAll(upvoteList);
        arrayAfterRemoving = beforeStrings.toArray(String[]::new);
        review.setUpVotes(arrayAfterRemoving);
        review = reviewService.updateReview(review);
        return ResponseEntity.ok(review);

    }
}
