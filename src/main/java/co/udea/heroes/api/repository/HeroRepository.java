package co.udea.heroes.api.repository;

import co.udea.heroes.api.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String>{

    public Optional<Hero> findByName(String name);
    public List<Hero> findAllByNameContains(String name);
    public void deleteById(String id);

}