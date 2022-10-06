package se.salt.jfs.jpaproducts.review;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Review {

    @Id
    @JsonProperty
    private String id;
    @JsonProperty
    private String productId;
    @JsonProperty
    private String productName;
    @JsonProperty
    private String productGroup;
    @JsonProperty
    private String title;
    @JsonProperty
    private String description;
    @JsonProperty
    private String reviewer;
    @JsonProperty
    private String[] upVotes;
    @JsonProperty
    private int numberOfUpVotes;

    public String[] getUpVotes() {
        return upVotes;
    }

    public void setUpVotes(String[] upVotes) {
        this.upVotes = upVotes;
    }
}

