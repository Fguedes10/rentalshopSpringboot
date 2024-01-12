package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "vehicle_Id")

    private Vehicle vehicle;

    private LocalDate rentalStartDate;

    private LocalDate rentalEndDate;

    private Long totalRentalCost;


    public Rental(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }


    public void setTotalRentalCost(Long totalRentalCost) {
        long daysBetween = DAYS.between(rentalStartDate, rentalEndDate);
        this.totalRentalCost = daysBetween * vehicle.getDailyPrice();
    }
}
