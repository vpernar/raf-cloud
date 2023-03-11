package rs.raf.domaci3.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
@Getter
@Setter
public class ErrorMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String message;

    @Enumerated(EnumType.STRING)
    private Operation status;

    @Column
    private Date date;

    //    @ManyToOne
//    @JoinColumn(name = "NODE_ID", referencedColumnName = "id")
//    @JsonBackReference
    @Column
    private Long nodeId;

    @ManyToOne
    private User user;

}
