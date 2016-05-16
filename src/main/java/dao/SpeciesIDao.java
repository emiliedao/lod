package dao;

import entity.Family;
import entity.Species;

import java.util.List;

/**
 * Created by emiliedao on 5/4/16.
 */
public interface SpeciesIDao extends GenericIDao<Species> {
    Species findByName(String name);
    List<Species> findByFamily(Family family);
    List<Species> findByLetterAndFamily(Character lettre, Family family);
    int countByLetterAndFamily(Character letter, Family family);
}
