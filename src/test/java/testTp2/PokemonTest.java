package com.montaury.pokebagarre.metier;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {

    @Test
    void test1_premierVainqueurAvecMeilleureAttaque() {
        // Arrange
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 30));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(40, 30));

        // Act
        boolean resultat = p1.estVainqueurContre(p2);

        // Assert
        assertTrue(resultat, "Le premier devrait gagner car son attaque est supérieure");
    }

    @Test
    void test2_secondVainqueurAvecMeilleureAttaque() {
        // Arrange
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(40, 30));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 30));

        // Act
        boolean resultat = p1.estVainqueurContre(p2);

        // Assert
        assertFalse(resultat, "Le second devrait gagner car son attaque est supérieure");
    }

    @Test
    void test3_premierVainqueurAvecAttaqueEtDefenseEgale() {
        // Arrange
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 50));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 50));

        // Act
        boolean resultat = p1.estVainqueurContre(p2);

        // Assert
        assertTrue(resultat, "Le premier devrait gagner en cas d'égalité parfaite");
    }

    @Test
    void test4_premierVainqueurAvecAttaqueEgaleEtMeilleureDefense() {
        // Arrange
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 60));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 40));

        // Act
        boolean resultat = p1.estVainqueurContre(p2);

        // Assert
        assertTrue(resultat, "Le premier devrait gagner avec une meilleure défense à attaque égale");
    }

    @Test
    void test5_secondVainqueurAvecAttaqueEgaleEtMeilleureDefense() {
        // Arrange
        Pokemon p1 = new Pokemon("Pikachu", "url1", new Stats(50, 40));
        Pokemon p2 = new Pokemon("Bulbizarre", "url2", new Stats(50, 60));

        // Act
        boolean resultat = p1.estVainqueurContre(p2);

        // Assert
        assertFalse(resultat, "Le second devrait gagner avec une meilleure défense à attaque égale");
    }
}