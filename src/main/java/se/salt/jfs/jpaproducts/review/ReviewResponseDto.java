package se.salt.jfs.jpaproducts.review;

public record ReviewResponseDto(

        String id,
        String productId,
        String productName,
        String productGroup,
        String title,
        String description,
        String reviewer,
        String[] upVotes,
        int numberOfUpVotes
) {
}
