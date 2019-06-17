package com.newssystem.NewsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.NewsSystem.repository.NewsRepository;
import com.newssystem.NewsSystem.domain.News;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)

public class NewsSystemApplicationTests {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private NewsRepository newsRepository;

	@BeforeClass
	public static void setUpBefore() throws Exception{
		//przed testami
	}

	@AfterClass
	public static void setUpAfter() throws Exception{
		//po testach
	}

	@Before
	public void setUp() throws Exception{
		//przed kazdym testem
	}

	@After
	public void after() throws Exception{
		//po kazdym tescie
	}

	@Test
	public void testCreateNews() throws IOException {
		/*
		Map<String, Object> requestBody = new HashMap<>();
		requestBody.put("title", "Tytul");
		requestBody.put("text", "Tresc");
		requestBody.put("data", "01.01.2001");
		requestBody.put("author", "Autor");
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> httpEntity =
				new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

		Map<String, Object>apiResponse =
				restTemplate.postForObject("http://localhost:8080/api/news/saveNews", httpEntity, Map.class, Collections.emptyMap());

		assertNotNull(apiResponse);

		String message = apiResponse.get("message").toString();
		assertEquals("News created", message);

		String newsId = ((Map<String,Object>)apiResponse.get("news")).get("id").toString();

		assertNotNull(newsId);

		News news = newsRepository.findById(newsId).get();
		assertEquals("Tytul", news.getTitle());
		assertEquals("Tresc", news.getText());
		assertEquals("01.01.2001", news.getData());
		assertEquals("Autor", news.getAuthor());
		*/
	}

	@Test
	public void contextLoads() {
	}

}
