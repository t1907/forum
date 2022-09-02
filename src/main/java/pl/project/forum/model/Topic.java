package pl.project.forum.model;

import lombok.*;

import javax.persistence.*;

@Entity(name = "topic")
@Table(name = "topic")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Topic {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
