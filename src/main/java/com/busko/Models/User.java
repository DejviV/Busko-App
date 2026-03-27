package com.busko.Models;

import com.busko.Models.Enums.Roles;
import com.busko.Models.Enums.Ticket;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.lang.Nullable;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String NameAndSurname;
    private String Username;
    private String Password;
    private Roles Role;
    @Nullable
    private String Description = null;
    private List<Ticket> tickets;
    @Nullable
    private String CompanyID = null;
    @Nullable
    private String ProfileImage = null;

    public User() {}

    public User(String nameAndSurname, String username, String password, Roles role) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
    }

    public User(String nameAndSurname, String username, String password, Roles role, String description, List<Ticket> tickets, String companyID) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
        this.Description = description;
        this.tickets = tickets;
        this.CompanyID = companyID;
    }

    public User(String nameAndSurname, String username, String password, Roles role, String description, List<Ticket> tickets, String companyID, String profileImage) {
        this.NameAndSurname = nameAndSurname;
        this.Username = username;
        this.Password = password;
        this.Role = role;
        this.Description = description;
        this.tickets = tickets;
        this.CompanyID = companyID;
        this.ProfileImage = profileImage;
    }
}
