# Reviews API - Mongo

## The purpose

Learn how to access and store data in a MongoDB database using Spring-Data 

This document contains quite a lot of information and help. You'd be wise to read all of it before starting.

## The Lab

We want you to extend your API to handle reviews for products.

A review is quite simply a title, description, name of the review, and a list of upvotes. The review also has a `productId` property to link it to a product. This `productId` is the id of the product stored in Postgres, but it's not a "hard" connection.

In this lab, you will get to set up just about everything, around the MongoDb, from scratch; building out the collections, writing the API to manage the data, etc.

We have not supplied you with tests for this exercise, so you will write them yourselves, but also use a tool like Postman to do tests manually.

### The data for a review

Reviews should be stored in a collection called `reviews` and should have the following properties:

* `id` - an id, (this is _not_ the Mongo automatically generated _id)
* `productId`- the id of the product the review is for.
* `productName` - the name of the product
* `productGroup` - the name of the group the product belongs to
* `title` - a title for the review
* `description` - a text for the review
* `reviewer` - (a string) - the name of the person that did the review
* `upvotes` - (an array) - a list of names of the people that have upvoted the review.
* `numberOfUpvotes` - a calculated value of the number of names in the `upvote` array

In JSON the data will look something like this

```json
{
  "id": "135",
  "productId": "1225226",
  "productName": "The Salt bootcamp",
  "productGroup": "Courses",
  "title": "This product will rock your socks off!",
  "description": "I bought this and now I cannot think about anything else",
  "reviewer": "Johan",
  "upvotes" : [
    "The Zarah", "Mieselito", "Adamsan", "ZachAttack", "Danjelovic", "Levis Jeans"
  ],
  "numberOfUpvotes": 6
}
```

### The API endpoints

The API should be implemented in a `@RestController` and have the following endpoints, listed here in the suggested implementation order:

* `GET` `/api/reviews/:reviewId` - return a review by id
* `POST` `/api/review/` - add new review with all data needed
    * Id should be generated
    * product data should be looked up from the productId field
    * upvotes should start empty so are not needed
    * All other fields can be made up in the interest of time.
* `POST` `/api/review/:reviewId/upvote` - add a name (in body) to the list of upvotes
* `DEL` `/api/review/:reviewId/upvote` - remove a name (in body) to the list of upvotes
* `GET` `/api/reviews/?productId=[productId]` - return all reviews for a product, there can be more than one
* `GET` `/api/review/?group=[groupName]` - get all reviews for all products in a product group

### The help

* Create an account at [MongoDB Atlas](https://www.mongodb.com/pricing)
* Create your first project
    * From the start this project is empty
        * Remember that Mongo creates the collection and data when you store the first document
    * Click the "Connect" button to set up the first connection
    * You can seed your database with the example data if you like. It can be done from code or from Mongo Compass (see the "Connection" dialogue)
* We have supplied you with a solution based on yesterday's lab, but feel free to work off your code as well 
    * It is a good idea to create a separate package for the reviews managed by mongo so you can package scan for that.
    * You will have to set up and manage the connection as we talked about in the lecture.
* We have not supplied you with tests this time. Tests are a great way to get faster feedback on your code
    * But you can also use Postman to test your API manually

    
---

Good luck and have fun!
