package ImageHoster.controller;

import ImageHoster.model.Comment;
import ImageHoster.model.Image;
import ImageHoster.model.User;
import ImageHoster.service.CommentService;
import ImageHoster.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Date;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private ImageService imageService;


    //This method is called to get the comment values from User and insert it into 'Comments' table
    @RequestMapping(value = "/image/{imageId}/{imageTitle}/comments", method = RequestMethod.POST)
    public String commentImage(@RequestParam("comment") String comment, Comment addComment,
                               @PathVariable("imageId") Integer imageId, HttpSession session, Model model) {

        Image image = imageService.getImage(imageId);
        User user = (User) session.getAttribute("loggeduser");

        addComment.setUser(user);
        addComment.setImage(image);
        addComment.setText(comment);
        addComment.setDate(new Date());
        commentService.addComment(addComment);

        model.addAttribute("image", image);
        model.addAttribute("tags", image.getTags());
        model.addAttribute("comments", addComment);
        return "images/image";
    }
}
