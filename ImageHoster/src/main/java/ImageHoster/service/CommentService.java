package ImageHoster.service;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    //Call the addComment() method in the Repository to add all the comments in the database
    public void addComment(Comment addComment) {
        commentRepository.addComment(addComment);
    }

    //public List<Comment> getComment(Integer imageId) {
      //  return commentRepository.getComment(imageId);
//    }
}
