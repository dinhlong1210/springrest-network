package com.example.demo.Admin;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.News;
import com.example.demo.Repository.NewsRepository;
import com.example.demo.Security.Payload.Response.MessageResponse;
import com.example.demo.Service.NewsService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/")
public class NewsAPI {
	
	@Autowired
	private NewsRepository newsRepo;
	
	@Autowired
	private NewsService newsService;
	
	@RequestMapping(value = "/news/addnew",method = RequestMethod.POST)
	public ResponseEntity<?> createNews(@RequestBody News news) throws IOException{
		newsService.createNews(news);
		return ResponseEntity.ok(new MessageResponse("Add News success"));
	}
	
	@RequestMapping(value = "/news",method=RequestMethod.GET)
	public List<News> getAllNews(){
		return newsService.getAllNews();
	}
	
}
