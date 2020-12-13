package spring.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Table(name = "nhanvien")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "thamnien")
    private int thamNien;

    @Column(name = "masonv")
    @NotNull(message = "Employee code is require")
    private String idEmployee;

    @ManyToOne
    @JoinColumn(name = "bacngheid", referencedColumnName = "id")
    private Level level;

    @ManyToOne
    @JoinColumn(name = "vitricvid", referencedColumnName = "id")
    private Position position;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "nguoiid", referencedColumnName = "id")
    private Person person;
}
