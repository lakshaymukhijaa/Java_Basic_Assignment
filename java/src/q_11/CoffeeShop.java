/*Q11. Design classes having attributes and methods (only skeleton) for a coffee shop. There are three different actors in our scenario and I have listed the different actions they do also below

* Customer
  - Pays the cash to the cashier and places his order, get a token number back
  - Waits for the intimation that order for his token is ready
  - Upon intimation/notification he collects the coffee and enjoys his drink
  ( Assumption:  Customer waits till the coffee is done, he won’t timeout and cancel the order. The customer always likes the drink served. Exceptions like he not liking his coffee, he got wrong coffee are not considered to keep the design simple.)

* Cashier
  - Takes order and payment from the customer
  - Upon payment, creates an order and places it into the order queue
  - Intimates the customer that he has to wait for his token and gives him his token
  ( Assumption: Token returned to the customer is the order id. Order queue is unlimited. With a simple modification, we can design for a limited queue size)

* Barista
 - Gets the next order from the queue
 - Prepares the coffee
 - Places the coffee in the completed order queue
 - Places a notification that order for token is ready */
package q_11;
import java.util.Scanner;
import java.lang.Math;
class Customer{
    int amount;
    public void balance(int cash)
    {
        System.out.println("Available Cash is: "+ cash);
        amount=cash;
    }
    Cashier place=new Cashier();
    public void placeOrder()
    {

        Barista barista = new Barista();
        if(amount > place.min)
        {
            System.out.println("Yes, Place The Order Please!!");
            place.getOrder(amount,"Barista");
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {

                            barista.confirm();
                            System.exit(0);
                        }
                    },
                    4000
            );


        }
        else
        {
            System.out.println("No, Please Add Some More Cash!!");
        }
    }

}

class Cashier{
    int min=70;
    Barista barista= new Barista();
    public int getOrder(int rupi,String ordstr)
    {
        System.out.println("Order For "+ ordstr +" Is Placed!! Please Wait Sometime Until Order Get Ready");
        barista.orderQueue(1);
        System.out.println("Your Token Number Is:" +  barista.getId());
        return barista.getId();
    }
}
class Barista
{
    public void orderQueue(int amount )
    {
        if(amount ==1)
        {
            System.out.println("Order For Barista Is Being Prepared!!");
            amount =0;
        }
    }
    public int getId()
    {
        int min=1;
        int max=10;
        int range=max-min+1;

        //for generation of randomly generated token
        int random = (int)(Math.random() * range) + min;
        return random;
    }
    public void confirm()
    {
        System.out.println("Hurrree ! Order Is Ready!!");
    }
}

public class CoffeeShop{
    public static void main(String[] args)
    {   int rupee;
        Customer cus= new Customer();
        Scanner ic = new Scanner(System.in);
        System.out.println("Enter cash!");
        try{
            rupee=ic.nextInt();
        }
        finally{
            ic.close();
        }

        cus.balance(rupee);
        cus.placeOrder();
    }
}