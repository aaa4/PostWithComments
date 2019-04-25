package q.w.postcomments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import q.w.postcomments.model.Comment;
import q.w.postcomments.model.Post;
import q.w.postcomments.repo.CommentRepository;
import q.w.postcomments.repo.PostRepository;


@SpringBootApplication
public class PostCommentsApplication implements CommandLineRunner {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;


    public static void main(String[] args) {
        SpringApplication.run(PostCommentsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Post p = new Post("post", "some post");
        Post p1 = new Post("post", "post1");
        Post p2 = new Post("post", "post2");
        Post p3 = new Post("post", "post3");


        Comment c0 = new Comment("c0");
        Comment c1 = new Comment("c1");
        Comment c2 = new Comment("c2");


        //how to delete comment
       /* Comment cX = commentRepository.findDistinctByIdAndPostId(2l,1l) ;
        System.out.println(cX);
        commentRepository.delete(cX);*/

       //how to delete post with comments
        Post pX = postRepository.findById(1l).get();
        commentRepository.findByPostId(pX.getId()).forEach(comment -> {
            comment.setPost(null);
            commentRepository.delete(comment);
        });
        postRepository.delete(pX);

        //how to save post with comments
/*     Post pX = postRepository.findById(1l).get();
     postRepository.delete(pX);*/

      /*  postRepository.save(p);
         c0.setPost(p);
         c1.setPost(p);
         c2.setPost(p);

         commentRepository.save(c0);
         commentRepository.save(c1);
         commentRepository.save(c2);*/

    }
}
