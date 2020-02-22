package com.example.demo.CRUD.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.CRUD.Blog;
import com.example.demo.CRUD.BlogService;

@RestController
@RequestMapping("blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable("id") Long id) {
        return blogService.find(id).get();
    }

    @GetMapping
    public List<Blog> getAllBlogs(@RequestParam("title") Optional<String> title) {
        return blogService.findAll(title);
    }

    @PostMapping
    public Blog addBlog(@RequestBody Blog blog) {
        blogService.addBlog(blog);
        return blog;
    }

    @PutMapping
    public Blog updateBlog(@RequestBody Blog blog) {
        blogService.updateBlog(blog);
        return blog;
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable("id") Long id) {
        blogService.deleteBlog(id);
    }
}
