package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private long nif;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private long licenseCard;

    public Client(){

    }

    public Client(long nif, String name, String email, long licenseCard){
        this.nif = nif;
        this.name = name;
        this.email = email;
        this.licenseCard = licenseCard;
    }

}
