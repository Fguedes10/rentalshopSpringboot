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
@NoArgsConstructor
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

}
