package com.example.demo.Service;

import java.io.IOException;
import java.util.List;

import com.example.demo.Model.News;

public interface NewsService {
	News createNews(News news) throws IOException;
	List<News> getAllNews();
	News updateProduct(News news);
	void delete(long id);
}
