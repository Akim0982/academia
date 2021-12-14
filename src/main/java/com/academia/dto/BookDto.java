package com.academia.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class BookDto {
    private Long id;
    private String title;
    private String imageUrl;
    private Double price;
    private Date createdAt;
    private Date updatedAt;

}
