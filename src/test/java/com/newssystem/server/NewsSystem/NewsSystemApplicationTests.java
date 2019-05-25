package com.newssystem.server.NewsSystem;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.server.NewsSystem.domain.Comment;
import com.newssystem.server.NewsSystem.domain.News;
import com.newssystem.server.NewsSystem.repository.CommentRepository;
import com.newssystem.server.NewsSystem.repository.NewsRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;



@RunWith(SpringJUnit4ClassRunner.class)
//@SpringBootApplication(NewsSystemApplication.class)
@ContextConfiguration(classes = NewsSystemApplication.class)
@WebAppConfiguration
@SpringBootTest
public class NewsSystemApplicationTests {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	private static final RestTemplate restTemplate = new RestTemplate();
	@Autowired
	private NewsRepository newsRepository;
	@Autowired
	private CommentRepository commentRepository;

	@BeforeClass
	public static void setUpBefore() throws Exception{
		// wywoływane raz przed wszystkimi testami
	}

	@AfterClass
	public static void setUpAfter() throws Exception{
		// wywoływane raz po wszystkich testach
	}

	@Before
	public void setUp() throws Exception{
		// wywoływane przed każdym testem
	}

	@After
	public void after() throws Exception{
		// wywoływane po każdym teście
	}

	@Test
	public void testCreateNews() throws JsonProcessingException {
		Map<String, Object> requestBody = new HashMap();
		requestBody.put("title", "Oddam jamnika");
		requestBody.put("text", "To sympatyczny jamnik");
		requestBody.put("date", "11.12.13");
		requestBody.put("author", "Oldzi");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody),requestHeaders);

		Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/api/news/saveNews", httpEntity, Map.class, Collections.emptyMap());

		assertNotNull(apiResponse);

		String message = apiResponse.get("message").toString();
		assertEquals("News created successfully", message);
		String newsId = ((Map<String,Object>)apiResponse.get("news")).get("id").toString();
		assertNotNull(newsId);

		Optional<News> news = newsRepository.findById(newsId);
		assertEquals("Oddam jamnika", news.get().getTitle());
		assertEquals("To sympatyczny jamnik", news.get().getText());
		assertEquals("11.12.13", news.get().getDate());
		assertEquals("Oldzi", news.get().getAuthor());

	}

	@Test
	public void testCreateComment() throws JsonProcessingException {
		Map<String, Object> requestBody = new HashMap();
		requestBody.put("newsId", "123456789");
		requestBody.put("comment", "Czy tem jamnik schodzi po schodach?");
		requestBody.put("author", "Oldzi2");
		requestBody.put("date", "11.12.13");

		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> httpEntity = new HttpEntity<>(OBJECT_MAPPER.writeValueAsString(requestBody),requestHeaders);

		Map<String, Object> apiResponse = restTemplate.postForObject("http://localhost:8080/api/news/saveComment", httpEntity, Map.class, Collections.emptyMap());

		assertNotNull(apiResponse);

		String message = apiResponse.get("message").toString();
		assertEquals("Comment created successfully", message);
		String commentId = ((Map<String,Object>)apiResponse.get("comment")).get("id").toString();
		assertNotNull(commentId);

		Optional<Comment> comment = commentRepository.findById(commentId);
		assertEquals("123456789", comment.get().getNewsId());
		assertEquals("Czy tem jamnik schodzi po schodach?", comment.get().getComment());
		assertEquals("Oldzi2", comment.get().getAuthor());
		assertEquals("11.12.13", comment.get().getDate());

	}

}
