package com.example.memberboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public String listPosts(Model model) {
        List<Post> posts = postService.findAllPosts();
        model.addAttribute("posts", posts);
        return "post-list";
    }

    @GetMapping("/post/new")
    public String showNewPostForm(Model model) {
        model.addAttribute("post", new Post());
        return "post-form";
    }

    @PostMapping("/post/new")
    public String savePost(Post post, Principal principal) {
        // 로그인된 사용자를 가져오는 로직 필요 (Spring Security 연동 필요)
        // User user = userService.findByUsername(principal.getName());
        // post.setUser(user);
        postService.savePost(post);
        return "redirect:/posts";
    }
}
