package TEST;

import static org.junit.Assert.*;

import inf353.Dictionnaire;
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


}
