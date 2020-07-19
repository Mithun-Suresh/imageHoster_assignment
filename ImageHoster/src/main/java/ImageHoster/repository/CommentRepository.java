package ImageHoster.repository;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import org.springframework.stereotype.Repository;
import org.thymeleaf.standard.expression.SelectionVariableExpression;

import javax.persistence.*;
import java.util.List;

@Repository
public class CommentRepository {
    @PersistenceUnit(unitName = "imageHoster")
    private EntityManagerFactory emf;

    public Comment addComment(Comment addComment) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();
            em.persist(addComment);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        return addComment;
    }


//    public List<Comment> getComment(Integer imageId) {
//        EntityManager em = emf.createEntityManager();
//        try {
//            TypedQuery<Comment> query = em.createQuery("SELECT i from Comment i where i.image =:imageId", Comment.class).setParameter("imageId", imageId);
//            List<Comment> comments = query.getResultList();
//            return comments;
//        } catch (NoResultException nre) {
//            return null;
//        }
//
//    }
}
