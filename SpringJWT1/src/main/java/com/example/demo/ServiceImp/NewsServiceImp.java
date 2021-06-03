package com.example.demo.ServiceImp;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.News;
import com.example.demo.Repository.NewsRepository;
import com.example.demo.Service.NewsService;

@Service
public class NewsServiceImp implements NewsService{
	
	@Autowired
	private NewsRepository newsRepo;
	
	@Override
	public News createNews(News news) throws IOException {
		// TODO Auto-generated method stub
		News savenew=new News();
		savenew.setTitle(news.getTitle());
		savenew.setShortDescription(news.getShortDescription());
		savenew.setLongDescription(news.getLongDescription());
		return newsRepo.save(savenew);
	}

	@Override
	public List<News> getAllNews() {
		// TODO Auto-generated method stub
		return newsRepo.findAll();
	}

	@Override
	public News updateProduct(News news) {
		// TODO Auto-generated method stub
		return newsRepo.save(news);
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		newsRepo.deleteById(id);
	}
	
}
