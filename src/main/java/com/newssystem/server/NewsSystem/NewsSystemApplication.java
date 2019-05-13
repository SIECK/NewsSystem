package com.newssystem.server.NewsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.service.CommentService;
import com.newssystem.server.NewsSystem.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

//@SpringBootApplication//(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration};
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class NewsSystemApplication implements CommandLineRunner {

	@Autowired
	public NewsService newsService;

	@Autowired
	public CommentService commentService;
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RestTemplate restTemplate = new RestTemplate();
	public static void main(String[] args) {
		SpringApplication.run(NewsSystemApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

	    // ADDING NEWS
//		requestBody.put("title", "Oddam jamnika");
//		requestBody.put("text", "To sympatyczny jamnik");
//		requestBody.put("date", "11.12.13");
//		requestBody.put("author", "Oldzi");
//		HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody),requestHeaders);
//		restTemplate.postForObject("http://localhost:8080/api/news/saveNews", httpEntity, Map.class, Collections.emptyMap());
//		// ADDING COMMENT
//		Map<String, Object> requestBody2 = new HashMap();
//		HttpHeaders requestHeaders2 = new HttpHeaders();
//		requestBody2.put("newsId", "4938298");
//		requestBody2.put("comment", "Czy tem jamnik schodzi po schodach?");
//		requestBody2.put("author", "Oldzi2");
//		requestBody2.put("date", "11.12.13");
//		HttpEntity<String> httpEntity2 = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody2),requestHeaders2);
//		restTemplate.postForObject("http://localhost:8080/api/news/saveComment", httpEntity, Map.class, Collections.emptyMap());

		News object = new News("Sprzedam opla", "To dobry opel", "20.03.2019", "Oldzi");
		newsService.create(object);
		Comment object2 = new Comment("1a2b3c4d", "Chetnie kupie", "XXX", "20.03.2019");
		commentService.create(object2);
	}
}
