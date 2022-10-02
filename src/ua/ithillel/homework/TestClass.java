package ua.ithillel.homework;

public class TestClass {

    @BeforeSuite
    public void test1 (){
        System.out.println(this.getClass().getName() + " beforeSuite");
    }

    @Test
    public void test2 (){
        System.out.println(this.getClass().getName() + " Test with priority 1");
    }

    @Test (priority = 3)
    public void test3 (){
        System.out.println(this.getClass().getName() + " Test with priority 3");
    }
    @Test(priority = 2)
    public void test4 (){
        System.out.println(this.getClass().getName() + " Test with priority 2");
    }

    @AfterSuite
    public void test5 (){
        System.out.println(this.getClass().getName() + " afterSuite");
    }
}
