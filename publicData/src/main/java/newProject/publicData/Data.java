package newProject.publicData;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODENAME")
    private String codeName;

    @Column(name = "GUNAME")
    private String guName;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "PLACE")
    private String place;

    @Column(name = "ORG_NAME")
    private String org_name;

    @Column(name = "USE_TRGT")
    private String use_trgt;

    @Column(name = "USE_FEE")
    private String use_fee;

    @Column(name = "PLAYER")
    private String player;

    @Column(name = "PROGRAM")
    private String program;

    @Column(name = "ORG_LINK")
    private String org_link;

    @Column(name = "MAIN_IMG")
    private String main_img;

    @Column(name = "RGSTDATE")
    private LocalDateTime rgstDate;

    @Column(name = "STRDATE")
    private LocalDateTime strDate;

    @Column(name = "END_DATE")
    private LocalDateTime end_date;
}
