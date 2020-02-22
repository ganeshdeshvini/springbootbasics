package com.example.demo.CRUD;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    public void addBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Optional<Blog> find(Long id) {
        // uncomment for checking AOP Global Exception handling
//		int a = 5 / 0;
        return blogRepository.findById(id);
    }

    public List<Blog> findAll(Optional<String> title) {
        return !title.isPresent() ? blogRepository.findAll() : blogRepository.findByTitle(title.get());
    }

    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }

    public void updateBlog(Blog blog) {
        blogRepository.save(blog);
    }
}
