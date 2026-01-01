package SmartHealthCareDiagnosis.example.SmartHealthCareDiagnosis.model;

import jakarta.persistence.*;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String city;
    private String phone;
    private String specialty;
    private Double latitude;
    private Double longitude;

    @Column(length = 1000)
    private String services;

    // 🚀 Transient field for real-time distance (not stored in DB)
    @Transient
    private Double distanceFromUser;

    // Constructors
    public Hospital() {}

    public Hospital(String name, String address, String city, String phone, String specialty) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.phone = phone;
        this.specialty = specialty;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public Double getLatitude() { return latitude; }
    public void setLatitude(Double latitude) { this.latitude = latitude; }

    public Double getLongitude() { return longitude; }
    public void setLongitude(Double longitude) { this.longitude = longitude; }

    public String getServices() { return services; }
    public void setServices(String services) { this.services = services; }

    public Double getDistanceFromUser() { return distanceFromUser; }
    public void setDistanceFromUser(Double distanceFromUser) { this.distanceFromUser = distanceFromUser; }
}
