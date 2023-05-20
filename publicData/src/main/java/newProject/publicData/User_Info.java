package newProject.publicData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private String user_id;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_num")
    private String phone_num;

    @Column(name = "favorite_place")
    private String favorite_place;

    @Column(name = "residence")
    private String residence;

    @Column(name = "favorite_genre")
    private String favorite_genre;
}
