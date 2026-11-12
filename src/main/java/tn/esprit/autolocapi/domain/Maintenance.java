package tn.esprit.autolocapi.domain;

import java.time.LocalDate;   // à ajouter aux imports
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table( name = "maintenance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Maintenance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaintenance;

    @Column(nullable = false)
    private LocalDate dateDebut;

    private LocalDate dateFin;

    @Column(length = 500)
    private String description;
}
