package pl.project.forum.model;

import lombok.*;

import javax.persistence.*;
import javax.xml.crypto.Data;

@Entity(name = "post")
@Table(name = "post")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Post {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String context;
}
