package se.salt.jfs.jpaproducts.review;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Upvote {
    public String[] getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String[] upvotes) {
        this.upvotes = upvotes;
    }

    @JsonProperty
    private String[] upvotes;
}
