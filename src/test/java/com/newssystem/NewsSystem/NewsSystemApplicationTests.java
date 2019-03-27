package com.newssystem.NewsSystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.newssystem.NewsSystem.repository.NewsRepository;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.lang.reflect.Executable;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NewsSystemApplicationTests {

	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
	public void testCreateNews(){
		//Map<String, Object> requestBody = new HashMap<>();
		//requestBody.put("title", "Tytul");
		//requestBody.put("text", "Tresc");
		//requestBody.put("data", "01.01.2001");
		//requestBody.put("author", "Autor");
		//HttpHeaders requestHeaders = new HttpHeaders();


	}

	@Test
	public void contextLoads() {
	}

}
