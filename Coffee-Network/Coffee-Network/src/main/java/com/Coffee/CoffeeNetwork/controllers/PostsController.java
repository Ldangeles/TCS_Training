package com.Coffee.CoffeeNetwork.controllers;

import com.Coffee.CoffeeNetwork.models.Post;
import com.Coffee.CoffeeNetwork.repositories.PostRepository;
import com.Coffee.CoffeeNetwork.requests.CreatePostRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/posts")
@CrossOrigin
public class PostsController {

    private PostRepository postRepository;

    public PostsController(@Autowired PostRepository postRepository){
            this.postRepository = postRepository;
    }

    @GetMapping("")
    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    @PostMapping("")
    public void createPost(@RequestBody CreatePostRequest request){
        Post post = new Post();
        post.setContent(request.getContent());
        postRepository.save(post);
    }

    @GetMapping("{id}")
    public Post getPost(@PathVariable("id") int id){
        Post post = postRepository.findById(id).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        return post;
    }

    @PutMapping("{id}")
    public void updatePost(@PathVariable("id") int id,@RequestBody CreatePostRequest request){
        Post post = postRepository.findById(id).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        post.setContent(request.getContent());
        postRepository.save(post);
    }

    @DeleteMapping("{id}")
    public void deletePost(@PathVariable("id") int id){
        Post post = postRepository.findById(id).orElseThrow( () ->
                new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        postRepository.delete(post);
    }

}

