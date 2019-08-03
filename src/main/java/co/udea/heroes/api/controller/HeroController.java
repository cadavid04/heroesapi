package co.udea.heroes.api.controller;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.service.HeroServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tour-heroes")
public class HeroController {

    private HeroServiceInt heroService;

    public HeroController(HeroServiceInt heroService) {
        this.heroService = heroService;
    }

    @GetMapping
    @ApiOperation(value = "Buscar todos los heroes", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los heroes fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Hero>> getHeroes() {
        return ResponseEntity.ok(heroService.getHeroes());
    }

    @GetMapping ("/buscar/{name}")
    @ApiOperation(value = "Buscar todos los heroes", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los heroes fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})
    public ResponseEntity<List<Hero>> earchHeroesTerm(@PathVariable("name") String name) {
        return ResponseEntity.ok(heroService.searchHeroes(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") String id) {
        return ResponseEntity.ok(heroService.getHero(id));
    }

    @PostMapping()
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.addHero(hero));
    }

    @PutMapping()
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.updateHero(hero));
    }


    @GetMapping("consultar404/{id}")
    public ResponseEntity<Hero> getHeroNo404(@PathVariable("id") String id) {
        return ResponseEntity.ok(heroService.getHeroNo404(id));
    }

    @GetMapping("name/{name}")
    public ResponseEntity<Hero> getHeroByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(heroService.getHeroByName(name));
    }

    @DeleteMapping("borrar/{id}")
    public void deleteHero(@PathVariable("id") String id) {
        heroService.deleteHero(id);
    }
}
