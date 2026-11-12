package tn.esprit.autolocapi.domain;
import jakarta.persistence.*;     // les annotations JPA (@Entity, @Id, @Column…)
import lombok.AllArgsConstructor; // les annotations Lombok
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;      // type pour les montants


@Entity                       // JPA : "cette classe = une table"
@Table(name = "vehicule")     // JPA : nom de la table en base
@Getter                       // Lombok : génère getIdVehicule(), getMarque()…
@Setter                       // Lombok : génère setMarque(…), setStatut(…)…
@NoArgsConstructor            // Lombok : génère  public Vehicule() {}
@AllArgsConstructor           // Lombok : génère  public Vehicule(Long id, String immat, …)

public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVehicule;
    @Column(nullable = false, unique = true, length = 20)
    private String immatriculation;
    @Column(nullable = false, length = 50)
    private String marque;
    @Column(nullable = false, length = 50)
    private String modele;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private CategorieVehicule categorie;
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatutVehicule statut;
}
