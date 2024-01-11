package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
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


    public Rental(Vehicle vehicle, Client client) {
        this.vehicle = vehicle;
        this.client = client;
    }
}
