package com.hrishikesh.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kwabenaberko.newsapilib.NewsApiClient
import com.kwabenaberko.newsapilib.models.request.EverythingRequest
import com.kwabenaberko.newsapilib.models.response.ArticleResponse
import kotlinx.android.synthetic.main.activity_news_feed.*

class NewsFeed : AppCompatActivity() {
    val newsInfoList = arrayListOf<NewsModel>()
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var recyclerAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        layoutManager = LinearLayoutManager(this)

        val newsApiClient = NewsApiClient("e8fee1a6daf541348676a1d46d66d280")
        newsApiClient.getEverything(
            EverythingRequest.Builder()
                .q("tesla")
                .language("en")
                .build(),
            object : NewsApiClient.ArticlesResponseCallback{
                override fun onSuccess(response: ArticleResponse?) {
                    if (response != null) {
                        for(i in 0 until response.articles.size){
                            val newsObject = NewsModel(
                                response.articles[i].title,
                                response.articles[i].description,
                                response.articles[i].publishedAt,
                                response.articles[i].source,
                                response.articles[i].urlToImage,
                            )
                            newsInfoList.add(newsObject)
                            recyclerAdapter= NewsAdapter(this@NewsFeed,newsInfoList)
                            recyclerView.adapter=recyclerAdapter
                            recyclerView.layoutManager=layoutManager
                        }
                    }
                }

                override fun onFailure(throwable: Throwable?) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}