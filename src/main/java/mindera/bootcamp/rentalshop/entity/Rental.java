package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

    public Rental(Client client, Vehicle vehicle, LocalDate rentalStartDate, LocalDate rentalEndDate) {
        this.client = client;
        this.vehicle = vehicle;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
        setTotalRentalCost();
    }


    public void setTotalRentalCost() {
        Long totalDays = rentalStartDate.until(rentalEndDate, DAYS);
        this.totalRentalCost = totalDays * vehicle.getDailyPrice();
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
