package q.w.postcomments.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import q.w.postcomments.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
