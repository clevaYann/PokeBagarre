package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {

    @Test
    void test1_premierVainqueurAvecMeilleureAttaque() {
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 30));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(40, 30));

        boolean resultat = p1.estVainqueurContre(p2);

        assertTrue(resultat, "Le premier devrait gagner car son attaque est supérieure");
    }

    @Test
    void test2_secondVainqueurAvecMeilleureAttaque() {
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(40, 30));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 30));

        boolean resultat = p1.estVainqueurContre(p2);

        assertFalse(resultat, "Le second devrait gagner car son attaque est supérieure");
    }

    @Test
    void test3_premierVainqueurAvecAttaqueEtDefenseEgale() {
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 50));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 50));

        boolean resultat = p1.estVainqueurContre(p2);

        assertTrue(resultat, "Le premier devrait gagner en cas d'égalité parfaite");
    }

    @Test
    void test4_premierVainqueurAvecAttaqueEgaleEtMeilleureDefense() {
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 60));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 40));

        boolean resultat = p1.estVainqueurContre(p2);

        assertTrue(resultat, "Le premier devrait gagner avec une meilleure défense à attaque égale");
    }

    @Test
    void test5_secondVainqueurAvecAttaqueEgaleEtMeilleureDefense() {
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 40));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 60));

        boolean resultat = p1.estVainqueurContre(p2);

        assertFalse(resultat, "Le second devrait gagner avec une meilleure défense à attaque égale");
    }
}