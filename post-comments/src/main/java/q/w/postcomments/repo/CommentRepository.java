package q.w.postcomments.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import q.w.postcomments.model.Comment;

import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Comment findDistinctByIdAndPostId(Long id, Long postId);
    Set<Comment> findByPostId(Long postId);

}
