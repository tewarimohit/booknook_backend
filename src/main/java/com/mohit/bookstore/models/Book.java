package com.mohit.bookstore.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "books")
public class Book {
 private String title;
 private String author;
 private String imageProduct;
 private int price;
 private String categoryName;
 private int rating;
 private int discount;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", imageProduct='" + imageProduct + '\'' +
                ", price=" + price +
                ", categoryName='" + categoryName + '\'' +
                ", rating=" + rating +
                ", discount=" + discount +
                '}';
    }
}
