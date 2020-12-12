package spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Table(name = "Khachhang")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "masokh")
    @NotNull(message = "Customer code is require")
    private String idCustomer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="nguoiid",referencedColumnName = "id")
    private Person person ;
}