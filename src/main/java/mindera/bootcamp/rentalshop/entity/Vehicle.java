package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Builder
@AllArgsConstructor
@Table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "vehicle", cascade = CascadeType.ALL)

    private List<Rental> rentals;

    private String brand;

    @Column(unique = true)

    private String plateNumber;

    private String color;

    private Double cubicCapacity;

    private Integer horsePower;

    private Integer numberOfSeats;

    private Long mileage;

    private LocalDate plateRegistrationDate;

    private boolean available;

    private Long dailyPrice;

    public Vehicle() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public void setRentals(List<Rental> rentals) {
        this.rentals = rentals;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getCubicCapacity() {
        return cubicCapacity;
    }

    public void setCubicCapacity(Double cubicCapacity) {
        this.cubicCapacity = cubicCapacity;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public LocalDate getPlateRegistrationDate() {
        return plateRegistrationDate;
    }

    public void setPlateRegistrationDate(LocalDate plateRegistrationDate) {
        this.plateRegistrationDate = plateRegistrationDate;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Long getDailyPrice() {
        return dailyPrice;
    }

    public void setDailyPrice(Long dailyPrice) {
        this.dailyPrice = dailyPrice;
    }
}
