package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (mappedBy = "client", cascade = CascadeType.ALL)
    private List<Rental> rentals;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dateOfBirth;
    @Column(unique = true)
    private Long nif;
    @Column(unique = true)
    private Long driverLicense;

    public Client() {
    }

    public Client(String firstName, String lastName, String email, LocalDate dateOfBirth, Long nif, Long driverLicense) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.nif = nif;
        this.driverLicense = driverLicense;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public Long getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(Long driverLicense) {
        this.driverLicense = driverLicense;
    }

}
