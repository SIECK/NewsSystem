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

    private static StoriesParams.Builder getDefaultStoriesParams() {
        StoriesParams.Builder storiesBuilder = StoriesParams.newBuilder();

        storiesBuilder.setSortBy("social_shares_count.facebook");
        storiesBuilder.setPublishedAtStart("NOW-7DAYS");
        storiesBuilder.setPublishedAtEnd("NOW");

        return storiesBuilder;
    }

    public List<Story> findAll() {
        StoriesParams.Builder storiesBuilder = getDefaultStoriesParams();

        try {
            Stories result = apiInstance.listStories(storiesBuilder.build());
            return result.getStories();
        } catch (ApiException e) {
            return null;
        }
    }

    public List<Story> findByLang(String lang) {
        StoriesParams.Builder storiesBuilder = getDefaultStoriesParams();

        storiesBuilder.setLanguage(Arrays.asList(lang));

        try {
            Stories result = apiInstance.listStories(storiesBuilder.build());
            return result.getStories();
        } catch (ApiException e) {
            return null;
        }
    }

    public List<Story> findByParameters(String lang, String categoryId, String sourceLocationsState) {
        StoriesParams.Builder storiesBuilder = getDefaultStoriesParams();
        String categoriesTaxonomy = "iab-qag";

        storiesBuilder.setLanguage(Arrays.asList(lang));
        storiesBuilder.setCategoriesTaxonomy(categoriesTaxonomy);
        storiesBuilder.setCategoriesId(Arrays.asList(categoryId));
        storiesBuilder.setSourceLocationsState(Arrays.asList(sourceLocationsState));

        try {
            Stories result = apiInstance.listStories(storiesBuilder.build());
            return result.getStories();
        } catch (ApiException e) {
            return null;
        }
    }
}

