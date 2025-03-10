package tracratselenium.aruna.page;

public class TestNew {

    TestAruna ta = new TestAruna();

    public void testing(){


        ta.multiplication(10,20);

    }
    public void testAnother(){

    }

    public static void main(String[] args){
        TestAruna ta1 = new TestAruna();
        System.out.println(ta1.getCar());
        ta1.assignCar();
        System.out.println(ta1.getCar());

        TestAruna ta2 = new TestAruna();
        System.out.println(ta2.getCar());
    }
}
