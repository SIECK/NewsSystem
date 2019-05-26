package com.newssystem.NewsSystem.repository;

import com.aylien.newsapi.*;
import com.aylien.newsapi.auth.*;
import com.aylien.newsapi.models.*;
import com.aylien.newsapi.parameters.*;
import com.aylien.newsapi.api.DefaultApi;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class NewsApiRepository {
    static String APP_ID = "28d1adbd";
    static String API_KEY = "d2ca139d125b9040e52c1ea8039a59aa";

    private DefaultApi apiInstance;

    {
        ApiClient defaultClient = Configuration.getDefaultApiClient();

        // Configure API key authorization: app_id
        ApiKeyAuth app_id = (ApiKeyAuth) defaultClient.getAuthentication("app_id");
        app_id.setApiKey(APP_ID);

        // Configure API key authorization: app_key
        ApiKeyAuth app_key = (ApiKeyAuth) defaultClient.getAuthentication("app_key");
        app_key.setApiKey(API_KEY);

        apiInstance = new DefaultApi();
    }

    public List<Story> findAll() {
        StoriesParams.Builder storiesBuilder = StoriesParams.newBuilder();

        storiesBuilder.setSortBy("social_shares_count.facebook");
        storiesBuilder.setLanguage(Arrays.asList("en"));
        storiesBuilder.setPublishedAtStart("NOW-7DAYS");
        storiesBuilder.setPublishedAtEnd("NOW");

        try {
            Stories result = apiInstance.listStories(storiesBuilder.build());
            return result.getStories();
        } catch (ApiException e) {
            return null;
        }
    }

}

