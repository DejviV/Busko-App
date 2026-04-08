package com.busko.Models;

import com.busko.Models.Enums.Roles;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameAndSurname;
    private String username;
    private String password;
    @Enumerated(EnumType.STRING)
    private Roles role;
    @Nullable
    private String description = null;
    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = true)
    private User company;
    @Nullable
    private String companyProfileImage = null;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Ticket> tickets;


    public static User createTraveler(String nameAndSurname, String username, String password) {
        User user = new User();
        user.nameAndSurname = nameAndSurname;
        user.username = username;
        user.password = password;
        user.role = Roles.TRAVELER;
        return user;
    }

    public static User createCompany(String nameAndSurname, String username, String password, String description, String companyProfileImage) {
        User user = new User();
        user.nameAndSurname = nameAndSurname;
        user.username = username;
        user.password = password;
        user.role = Roles.COMPANY;
        user.description = description;
        user.companyProfileImage = companyProfileImage;
        return user;
    }

    public static User createDriver(String nameAndSurname, String username, String password, User company) {
        User user = new User();
        user.nameAndSurname = nameAndSurname;
        user.username = username;
        user.password = password;
        user.company = company;
        user.role = Roles.DRIVER; // DRIVER
        return user;
    }

    public static User createInspector(String nameAndSurname, String username, String password, User company) {
        User user = new User();
        user.nameAndSurname = nameAndSurname;
        user.username = username;
        user.password = password;
        user.company = company;
        user.role = Roles.INSPECTOR; // INSPECTOR
        return user;
    }

}
