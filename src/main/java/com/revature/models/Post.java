package com.revature.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Data
@ToString(exclude = {"comments"})
@EqualsAndHashCode(exclude = {"comments"})
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Type(type = "text")
    private String postText;

    @Type(type = "text")
    private String contentInfo;

    @ManyToOne
    @JoinColumn(name="author", referencedColumnName="uid")
    private User author;
    //Convene with Team one to add their annotation here
    //will use the first name and last name for a poster or a commenter

    @JsonIgnore
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Post(String postText, String contentInfo)
    {
       this.postText = postText;
       this.contentInfo = contentInfo;
    }
}
