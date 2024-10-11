import org.junit.*;

public class Vector2DTest {
    private final double accuracy = 1e-9;
    private static Vector2D v1;

    @BeforeClass
    public static void initializeVector(){
        v1  = new Vector2D(); // action
        System.out.println("Initializing Vector2D: " + v1);
    }

    @Before
    public void createNewVector(){
        v1  = new Vector2D(); // action
        System.out.println("New Vector2D: " + v1);
    }

    @Test
    public void newVectorHasLengthZero(){
//        Vector2D v1  = new Vector2D(); // action || in @Before now!

        //assertion
        Assert.assertEquals(0, v1.length(), accuracy);
    }
//    @Test
//    public void newVectorHasLengthZeroX(){
//        Assert.assertEquals(0, v1.getX(), accuracy);
//    }                                               // new generalized method below!
//    @Test
//    public void newVectorHasLengthZeroY(){
//        Assert.assertEquals(0, v1.getY(), accuracy);
//    }

    @Test
    public void newVectorHasLengthZeroXAndY(){
        Assert.assertEquals(0, v1.getX(), accuracy);
        Assert.assertEquals(0, v1.getY(), accuracy);
    }

    @After
    public void afterTest(){
        System.out.println("Test ended");
    }

    @AfterClass
    public static void afterTesting(){
        System.out.println("Testing is over!");
    }
}
