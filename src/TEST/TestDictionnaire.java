package TEST;

import static org.junit.Assert.*;

import org.junit.Test;
public class TestDictionnaire {
    @Test
    public void testVider() {
        Dictionnaire d = new Dictionnaire();
        d[0] = "a";
        d[1] = "b";
        d.vider();
        assertEquals(  0, d.taille);
    }
    @Test
    public void testVider2() {
        Dictionnaire d = new Dictionnaire();
        d.vider();
        assertEquals(  0, d.taille);
    }
    @Test 
    public void testAjouterMot() {
        Dictionnaire d = new Dictionnaire();
        d.ajouterMot("a");
        assertEquals(  1, d.taille);
    }

}
