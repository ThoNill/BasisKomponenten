package tests;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Test;
import org.nill.basiskomponenten.gemeinsam.DoubleBündelMap;
import org.nill.basiskomponenten.mathe.bündel.Bündel;
import org.nill.basiskomponenten.mathe.bündel.GruppenBündel;
import org.nill.basiskomponenten.predicates.Predicate;


public class BündelTest {

    @Test
    public void filterKeys() {
        Bündel<String,Double> x = new DoubleBündelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Bündel<String, Double> y = x.filterKeys(new ErsterBuchstabeIstT());
        Assert.assertEquals(1.0d, y.getValue("test1"), 0.0001d);
     
        y = x.forgetKeys(new ErsterBuchstabeIstT());
        Assert.assertNull(y.getValue("test1"));     
        
        x = new DoubleBündelFabrik().create("super",
                1.0d, 2.0d, 3.0d);
        y = x.filterKeys(new ErsterBuchstabeIstT());
        Assert.assertNull(y.getValue("super1"));
    }

    
    @Test
    public void filterValues() {
        Bündel<String,Double> x = new DoubleBündelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Bündel<String, Double> y = x.filterValues(new Gt2());
        Assert.assertEquals(3.0d, y.getValue("test3"), 0.0001d);
    }
  

    @Test
    public void transformKeys() {
        Bündel<String,Double> x = new DoubleBündelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Bündel<String, Double> y = x.transformKeys(new PrefixX(),new DoubleBündelFabrik());
        Assert.assertEquals(3.0d, y.getValue("Xtest3"), 0.0001d);
    }
  
    
    @Test
    public void transformValues() {
        Bündel<String,Double> x = new DoubleBündelFabrik().create("test",
                1.0d, 2.0d, 3.0d);
        Bündel<String, Double> y = x.transformElements(new Quadrat(),new DoubleBündelFabrik());
        Assert.assertEquals(9.0d, y.getValue("test3"), 0.0001d);
    }
  
    

    @Test
    public void erweitern() {
        Bündel<String,Double> a = new DoubleBündelFabrik().create("a",
                1.0d, 2.0d, 3.0d);
        Bündel<String,Double> b = new DoubleBündelFabrik().create("b",
                1.0d, 2.0d, 3.0d);
        Bündel<String, Double> x = a.erweitern(new DoubleBündelMap<String>(),b);
        Assert.assertEquals(3.0d, x.getValue("a3"), 0.0001d);
        Assert.assertEquals(2.0d, x.getValue("b2"), 0.0001d);
        
         x = a.erweitern(b);
        Assert.assertEquals(3.0d, x.getValue("a3"), 0.0001d);
        Assert.assertEquals(2.0d, x.getValue("b2"), 0.0001d);
        
    }
  
  
    
    class ErsterBuchstabeIstT implements Predicate<String> {

        @Override
        public boolean test(String t) {
            return t != null && t.length()>0 && t.charAt(0) == 't';
        }
     }
    
    class PrefixX implements Function<String,String> {

        @Override
        public String apply(String t) {
            return "X" + t;
        }
     }

    
    class Gt2 implements Predicate<Double> {

        @Override
        public boolean test(Double t) {
            return t != null && t > 2.0;
        }
     }

    

    class Quadrat implements Function<Double,Double> {

        @Override
        public Double apply(Double t) {
            return t.doubleValue() * t.doubleValue();
        }
     }

}