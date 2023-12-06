package com.rating.service.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private long ratingId;

     private int userId;
     private int hotelId;
     private int rating;
     private String feedback;



}
