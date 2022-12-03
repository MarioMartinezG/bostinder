package co.edu.unbosque.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CRUDTestCase.class, EnvioCorreoTest.class, OrdenamientoTestCase.class })
public class AllTests {

}
