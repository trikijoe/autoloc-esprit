package tn.esprit.autolocapi.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autolocapi.domain.Equipement;
import tn.esprit.autolocapi.service.IEquipementService;

import java.util.List;

@Tag(name = "Equipements", description = "Gestion des équipements des véhicules")
@RestController
@RequestMapping("/equipements")
@RequiredArgsConstructor
public class EquipementController {

    private final IEquipementService equipementService;

    @Operation(summary = "Lister les équipements")
    @ApiResponses({@ApiResponse(responseCode = "200", description = "Liste des équipements")})
    @GetMapping
    public List<Equipement> findAll() {
        return equipementService.findAll();
    }

    @Operation(summary = "Consulter un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Équipement trouvé"),
            @ApiResponse(responseCode = "404", description = "Équipement introuvable")})
    @GetMapping("/{id}")
    public Equipement findById(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id) {
        return equipementService.findById(id);
    }

    @Operation(summary = "Créer un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Équipement créé"),
            @ApiResponse(responseCode = "400", description = "Libellé manquant")})
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Equipement create(@RequestBody Equipement equipement) {
        return equipementService.create(equipement);
    }

    @Operation(summary = "Modifier un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Équipement modifié"),
            @ApiResponse(responseCode = "400", description = "Libellé manquant"),
            @ApiResponse(responseCode = "404", description = "Équipement introuvable")})
    @PutMapping("/{id}")
    public Equipement update(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id,
                             @RequestBody Equipement equipement) {
        return equipementService.update(id, equipement);
    }

    @Operation(summary = "Supprimer un équipement")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Équipement supprimé"),
            @ApiResponse(responseCode = "404", description = "Équipement introuvable")})
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Parameter(description = "Identifiant de l'équipement") @PathVariable Long id) {
        equipementService.deleteById(id);
    }
}