package dojeneric;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DoJenericTest {

    @Test
    public void putStringCheckGetter(){
        String firstGen = "It's String";
        DoJeneric<String> doJeneric=new DoJeneric<String>(firstGen);
        assertTrue(firstGen.equals(doJeneric.getObjectGen()));
    }

    @Test
    public void putIntegerCheckSetter(){
        Integer scuma=5;
        DoJeneric<Integer> doJeneric=new DoJeneric<Integer>(scuma);
        Integer checkScuma=7;
        doJeneric.setObjectGen(checkScuma);
        assertTrue(checkScuma.equals(doJeneric.getObjectGen()));
    }
}
