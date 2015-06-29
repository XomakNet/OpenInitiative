package net.xomak.openinitiative.repository;

import net.xomak.openinitiative.model.Comment;
import net.xomak.openinitiative.model.Commentable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
    /**
     * Find comments by comments' root (e.g. find all initiative's comments)
     * @param root
     * @return
     */
    Page<Comment> findByRoot(Commentable root, Pageable pageable);
}
