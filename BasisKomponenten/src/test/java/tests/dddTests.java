package tests;
import static org.junit.Assert.*;

import org.junit.Test;
import org.nill.basiskomponenten.ddd.Entity;
import org.nill.basiskomponenten.ddd.EntitySpecification;
import org.nill.basiskomponenten.ddd.Fabric;
import org.nill.basiskomponenten.ddd.FabricSpecification;
import org.nill.basiskomponenten.ddd.ReporitorySpecification;
import org.nill.basiskomponenten.ddd.Repository;
import org.nill.basiskomponenten.ddd.Service;
import org.nill.basiskomponenten.ddd.ServiceSpecification;
import org.nill.basiskomponenten.ddd.StaticAssertion;
import org.nill.basiskomponenten.ddd.Value;
import org.nill.basiskomponenten.ddd.ValueSpecification;


public class dddTests {

    
    @Test
    public void test() {
        assertTrue(EntitySpecification.staticTest(new TEntity()));
        assertTrue(ValueSpecification.staticTest(new TValue()));
        assertTrue(ServiceSpecification.staticTest(new TService()));
        assertTrue(ReporitorySpecification.staticTest(new TRepository()));
        assertTrue(FabricSpecification.staticTest(new TFabric()));

        StaticAssertion<Value> s = new StaticAssertion<>(ValueSpecification.class,"message");
        assertTrue(s.test(new TValue()));
        
        
        assertTrue(ServiceSpecification.staticTest(new TService()));

    }
    
    class TEntity implements Entity {

        @Override
        public Object getId() {
            return null;
        }
        
    }
    
    class TValue implements Value {

        
    }

    class TService implements Service {

        
    }


    class TRepository implements Repository {

        
    }



    class TFabric implements Fabric {

        @Override
        public Object create() {
            return null;
        }

        
    }

}
