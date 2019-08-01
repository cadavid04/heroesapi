package co.udea.heroes.api.service;

import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.repository.HeroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HeroService implements HeroServiceInt{

    private HeroRepository heroRepository;

    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> getHeroes(){
        return heroRepository.findAll();
    }

    @Override
    public Hero getHero(String id) {
        Optional<Hero> posibleHero = heroRepository.findById(id);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            return null;
        }
    }

    @Override
    public Hero getHeroByName(String name) {
        Optional<Hero> posibleHero = heroRepository.findByName(name);
        if(posibleHero.isPresent()){
            return posibleHero.get();
        }else {
            return null;
        }
    }
}
