package com.shubhamshinde.contentcalendar.repository;

import com.shubhamshinde.contentcalendar.model.Content;
import com.shubhamshinde.contentcalendar.model.Status;
import com.shubhamshinde.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository() {
    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        if (contentList.removeIf((c) -> c.id().equals(content.id())))
            ;
        contentList.add(content);
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init() {
        Content c = new Content(1,
                "My first project",
                "Description to my first project",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "https://shubhamshinde.com");
        contentList.add(c);
    }
}
