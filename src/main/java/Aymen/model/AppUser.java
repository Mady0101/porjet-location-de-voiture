package Aymen.model;

import lombok.*;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
 // Create getters and setters
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class AppUser {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
  @Column(unique = true, nullable = false)
  private String username;

  @Column(unique = true, nullable = false)
  private String email;

  @Size(min = 8, message = "Minimum password length: 8 characters")
  private String password;

  @OneToMany(cascade = CascadeType.ALL
          , mappedBy = "user")
  private Set<Location> locations;



  @ElementCollection(fetch = FetchType.EAGER)
  List<AppUserRole> appUserRoles;

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Set<Location> getLocations() {
    return locations;
  }

  public List<AppUserRole> getAppUserRoles() {
    return appUserRoles;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setLocations(Set<Location> locations) {
    this.locations = locations;
  }

  public void setAppUserRoles(List<AppUserRole> appUserRoles) {
    this.appUserRoles = appUserRoles;
  }
}
