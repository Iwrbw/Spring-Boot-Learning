package com.web.filter.configuration;

import org.springframework.beans.factory.annotation.Value;

/**
 * Create by yangshunfan
 * 2018/2/9 14:34
 */
public class filterProperties {
    @Value("${com.web.filter.title}")
    public String title;

    @Value("${com.web.filter.description}")
    public String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
