package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.nill.basiskomponenten.gemeinsam.DoubleB�ndelMap;
import org.nill.basiskomponenten.mathe.b�ndel.GruppenB�ndel;


public class DoubleB�ndelTest {

    @Test
    public void anlegen() {
        DoubleB�ndelMap<String> x = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Assert.assertEquals(2.0d, x.getBetrag("test2").doubleValue(), 0.0001d);
    }

    @Test
    public void keys() {
        DoubleB�ndelMap<String> x = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Set<String> s = new HashSet<>();
        s.add("test1");
        s.add("test2");
        s.add("test3");
        Assert.assertEquals(x.getKeys(), s);
    }

    @Test
    public void isunit() {
        DoubleB�ndelMap<String> x = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Assert.assertFalse(x.isUnit(x));
        x = new DoubleB�ndelFabrik().create("test", 0.0d, 0, 0d, 0, 0d);
        Assert.assertTrue(x.isUnit(x));
        x = new DoubleB�ndelFabrik().create("test");
        Assert.assertTrue(x.isUnit(x));
        Assert.assertTrue(x.isUnit(x.unit()));
    }

    @Test
    public void equals() {
        DoubleB�ndelMap<String> a = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        DoubleB�ndelMap<String> b = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Assert.assertTrue(a.equals(b));
        Assert.assertEquals(a.hashCode(), b.hashCode());
        b = new DoubleB�ndelFabrik().create("test", 2.0d, 2.0d, 3.0d);
        Assert.assertFalse(a.equals(b));
        b = new DoubleB�ndelFabrik().create("t", 1.0d, 2.0d, 3.0d);
        Assert.assertFalse(a.equals(b));
        b = new DoubleB�ndelFabrik().create("t", 0.0d, 0.0d, 0.0d);
        Assert.assertTrue(a.unit().equals(b));
        Assert.assertEquals(a.unit().hashCode(), b.hashCode());
    }

    @Test
    public void addAundB() {
        DoubleB�ndelMap<String> a = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        DoubleB�ndelMap<String> b = new DoubleB�ndelFabrik().create("test",
                3.0d, 2.0d, 1.0d);
        GruppenB�ndel<String, Double> c = a.add(a, b);
        Assert.assertEquals(4.0d, c.getBetrag("test1").doubleValue(), 0.0001d);
        Assert.assertEquals(4.0d, c.getBetrag("test2").doubleValue(), 0.0001d);
    }

    @Test
    public void substractAvonB() {
        DoubleB�ndelMap<String> a = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        DoubleB�ndelMap<String> b = new DoubleB�ndelFabrik().create("test",
                3.0d, 2.0d, 1.0d);
        GruppenB�ndel<String, Double> c = a.subtract(a, b);
        Assert.assertEquals(-2.0d, c.getBetrag("test1").doubleValue(), 0.0001d);
        Assert.assertEquals(0.0d, c.getBetrag("test2").doubleValue(), 0.0001d);
    }

    @Test
    public void summe() {
        DoubleB�ndelMap<String> a = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Assert.assertEquals(6.0d, a.getSumme().doubleValue(), 0.0001d);
    }

    @Test
    public void teilsumme() {
        DoubleB�ndelMap<String> a = new DoubleB�ndelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Assert.assertEquals(5.0d, a.getSumme("test2", "test3").doubleValue(),
                0.0001d);
    }

}
