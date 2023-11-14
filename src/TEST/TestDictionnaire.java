package TEST;

import static org.junit.Assert.*;

import inf353.DictionnaireNaif;
import org.junit.Test;
public class TestDictionnaire {
    @Test
    public void testVider() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.dictionnaire[0][0] = 'a';
        d.dictionnaire[0][1] = '0';
        d.dictionnaire[1][0] = 'b';
        d.dictionnaire[1][1] = '0';
        d.vider();
        assertEquals(  0, d.taille);
    }
    @Test
    public void testVider2() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.vider();
        assertEquals(  0, d.taille);
    }
    @Test 
    public void testAjouterMot() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("a");
        assertEquals(  1, d.taille);
    }
    @Test 
    public void testAjouterMot2() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.dictionnaire[0][0] = 'a';
        d.dictionnaire[0][1] = '0';
        d.taille = 1;
        d.ajouterMot("a");
        assertEquals(  1, d.taille);
    }
    public void testAjouterMot3() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("abcdefghijklmnopqrstuvwxyz12345678912345");
        assertEquals(0, d.taille);
    }
    public void testAjouterMot4() {
        DictionnaireNaif d = new DictionnaireNaif();
        String s = "";
        d.ajouterMot(s);
        assertEquals(0, d.taille);
    }
    public void testAjouterMot5() {
        DictionnaireNaif d = new DictionnaireNaif(1);
        d.dictionnaire[0][0] = 'a';
        d.dictionnaire[0][1] = '0';
        String s = "a";
        d.ajouterMot(s);
        assertEquals(1, d.taille);
    }
    @Test
    public void testIndiceMotExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        d.ajouterMot("orange");
        
        assertEquals(0, d.indiceMot("apple"));
        assertEquals(1, d.indiceMot("banana"));
        assertEquals(2, d.indiceMot("orange"));
    }
    
    @Test
    public void testIndiceMotNonExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        d.ajouterMot("orange");
        
        assertEquals(-1, d.indiceMot("grape"));
        assertEquals(-1, d.indiceMot("kiwi"));
    }
    
    @Test
    public void testIndiceMotNullOrEmpty() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        
        assertEquals(-1, d.indiceMot(null));
        assertEquals(-1, d.indiceMot(""));
    }
    
    @Test
    public void testIndiceMotNonConforming() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        
        assertEquals(0, d.indiceMot("AppLe")); // Case-sensitive, should not find
        assertEquals(0, d.indiceMot("applE")); // Case-sensitive, should not find
        assertEquals(-1, d.indiceMot("ap ple")); // Non-matching format
    }
    @Test
    public void testMotIndiceExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        d.ajouterMot("orange");
        
        assertEquals("apple", d.motIndice(0));
        assertEquals("banana", d.motIndice(1));
        assertEquals("orange", d.motIndice(2));
    }
    
    @Test
    public void testMotIndiceNonExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        
        assertEquals("erreur : l'indice dépasse la taille", d.motIndice(2));
        assertEquals("erreur : l'indice dépasse la taille", d.motIndice(3));
    }
    
    @Test
    public void testMotIndiceOutOfRange() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        
        assertEquals("erreur : l'indice dépasse la taille", d.motIndice(-1));
    }
    @Test
    public void testContientExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        d.ajouterMot("orange");
        
        assertTrue(d.contient("apple"));
        assertTrue(d.contient("banana"));
        assertTrue(d.contient("orange"));
    }
    
    @Test
    public void testContientNonExisting() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        
        assertFalse(d.contient("grape"));
        assertFalse(d.contient("kiwi"));
    }
    
    @Test
    public void testContientNullOrEmpty() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        d.ajouterMot("banana");
        
        assertFalse(d.contient(null));
        assertFalse(d.contient(""));
    }
    
    @Test
    public void testContientNonConforming() {
        DictionnaireNaif d = new DictionnaireNaif();
        d.ajouterMot("apple");
        
        assertTrue(d.contient("AppLe")); // Case-sensitive, should not contain
        assertTrue(d.contient("applE")); // Case-sensitive, should not contain
        assertFalse(d.contient("ap ple")); // Non-matching format
    }
}



