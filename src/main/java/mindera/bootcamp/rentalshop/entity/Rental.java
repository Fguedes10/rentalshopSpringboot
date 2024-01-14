package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.DAYS;


@AllArgsConstructor
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

    public Rental() {
    }

    public Rental(Client client, Vehicle vehicle) {
        this.client = client;
        this.vehicle = vehicle;
    }


    public void setTotalRentalCost(Long totalRentalCost) {
        long daysBetween = DAYS.between(rentalStartDate, rentalEndDate);
        this.totalRentalCost = daysBetween * vehicle.getDailyPrice();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public void setRentalStartDate(LocalDate rentalStartDate) {
        this.rentalStartDate = rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }

    public void setRentalEndDate(LocalDate rentalEndDate) {
        this.rentalEndDate = rentalEndDate;
    }

    public Long getTotalRentalCost() {
        return totalRentalCost;
    }
}
