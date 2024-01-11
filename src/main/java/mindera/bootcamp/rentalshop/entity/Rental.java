package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
@Entity
@Table
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private final Client client;
    @ManyToOne
    @JoinColumn(name = "vehicle_Id")
    private final Vehicle vehicle;
    private LocalDate rentalStartDate;
    private LocalDate rentalEndDate;
    private Long totalRentalCost;



}
