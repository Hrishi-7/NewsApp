package com.hrishikesh.newsapp

import com.kwabenaberko.newsapilib.models.Source

data class NewsModel(
    val newsTitle: String,
    val newsDescription: String,
    val publishedAt: String,
    val source: Source,
    val newsImage: String?
){

}