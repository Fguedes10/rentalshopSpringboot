package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table
@Data
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (fetch = FetchType.EAGER, mappedBy = "client", cascade = CascadeType.ALL)
    private Set<Rental> rentals = new HashSet<>();

    private String firstName;

    private String lastName;

    @Column(unique = true)

    private String email;

    private LocalDate dateOfBirth;

    @Column(unique = true)

    private Long nif;

    @Column(unique = true)

    private Long driverLicense;



}
