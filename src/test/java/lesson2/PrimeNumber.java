package lesson2;


import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class PrimeNumber {
    //public static void main(String[] args){
    //    System.out.println(primeNumber(3));
    //}



    @Test
    public void isPrimeTest(){
        Assert.assertEquals(primeNumber(3), true);
    }

    @Test(enabled = false)
    public void methodToTestTest(){
        //Assert.assertEquals();
    }

    public static boolean primeNumber(int numb){
        for (int i=2;i<numb;i++){
            if (numb%i==0){
                 return false;
            }
        }
        return true;
    }
          /*
        1.precondition
        2.test steps
        3.verification
        4.post condition
         */
}
