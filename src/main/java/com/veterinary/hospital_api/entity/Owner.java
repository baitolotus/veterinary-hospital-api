package com.veterinary.hospital_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres")
    private String name;

    @NotBlank(message = "El teléfono es obligatorio")
    @Pattern(regexp = "^[0-9\\-]+$", message = "El teléfono solo puede contener números y guiones")
    private String phone;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "El email debe tener formato válido")
    private String email;

    //Relación, un dueño puede tener muchas mascotas
    @OneToMany(mappedBy = "owner")
    private List<Pet> pets = new ArrayList<>();

    //Constructores
    public Owner() {} //Vacio obligatorio para JPA

    public Owner(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    //Getter y Setters
    public Long getId() { return  id; }
    public void setId(Long id) { this.id = id; }

    public String getName() {return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<Pet> getPets() { return pets; }
    public void setPets(List<Pet> pets) { this.pets = pets; }
}