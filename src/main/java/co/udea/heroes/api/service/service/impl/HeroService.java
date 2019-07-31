package co.udea.heroes.api.service.service.impl;

import co.udea.heroes.api.model.Hero;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService implements HeroServiceInt{

    public List<Hero>getHeroes(){
        List<Hero> heroes = new ArrayList<Hero>();
        heroes.add(new Hero("1","Spideman"));
        heroes.add(new Hero("2", "Ironman"));
        heroes.add(new Hero("3", "Hulk"));
        return heroes;
    }
}