package mindera.bootcamp.rentalshop.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)

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


    public Vehicle() {}

    public Vehicle(Long id, String brand, String plateNumber, String color, Double cubicCapacity, Integer horsePower, Integer numberOfSeats, Long mileage, LocalDate plateRegistrationDate, Long dailyPrice) {
        this.id = id;
        this.brand = brand;
        this.plateNumber = plateNumber;
        this.color = color;
        this.cubicCapacity = cubicCapacity;
        this.horsePower = horsePower;
        this.numberOfSeats = numberOfSeats;
        this.mileage = mileage;
        this.plateRegistrationDate = plateRegistrationDate;
        this.dailyPrice = dailyPrice;
        this.available = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
