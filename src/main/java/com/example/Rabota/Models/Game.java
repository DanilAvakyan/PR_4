package com.example.Rabota.Models;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty (message = "Поле не может быть пустым")
    @Size(max = 30, message = "Поле не может содержать более 30 символов")
    private String name;

    @Min(value = 0, message = "Цена не может быть отрицательной!")
    private float price;
    @NotEmpty (message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Поле не может содержать менее 2 символов. Максимум символов: 30")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Поле не может содержать спецсимволы и цифры")
    private String developer;
    @NotEmpty (message = "Поле не может быть пустым")
    @Size(max = 50, message = "Поле не может содержать более 50 символов")
    @Pattern(regexp = "^[а-яА-Я]+$", message = "Поле должно содержать буквы кириллицы")
    private String genre;
    @NotEmpty (message = "Поле не может быть пустым")
    @Size(min = 2, max = 30, message = "Поле не может содержать менее 2 символов. Максимум символов: 30")
    @Pattern(regexp = "^[а-яА-Яa-zA-Z]+$", message = "Поле не может содержать спецсимволы и цифры")
    private String publisher;
    @NotEmpty (message = "Поле не может быть пустым")
    @Size(min = 30, message = "Поле не может содержать менее 30 символов")
    private String specifications;

    public long getId() {return id;}

    public void setId(long id) {this.id = id;}


    public String getName() {return name;}

    public void setName(String name) {this.name = name;}


    public float getPrice() {return price;}

    public void setPrice(float price) {this.price = price;}


    public String getDeveloper() {return developer;}

    public void setDeveloper(String developer) {this.developer = developer;}


    public String getGenre() {return genre;}

    public void setGenre(String genre) {this.genre = genre;}


    public String getPublisher() {return publisher;}

    public void setPublisher(String publisher) {this.publisher = publisher;}


    public String getSpecifications() {return specifications;}

    public void setSpecifications(String specifications) {this.specifications = specifications;}


    public Game() {}

    public Game(String name, float price, String developer, String genre, String publisher, String specifications) {
        this.name = name;
        this.price = price;
        this.developer = developer;
        this.genre = genre;
        this.publisher = publisher;
        this.specifications = specifications;
    }


}
