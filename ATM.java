
import java.util.HashMap;
import java.util.Scanner;
public class ATM{
    public static void main(String[] args) {
        HashMap<Integer , Integer > map = new HashMap<>();
        map.put(1234,12345);
        map.put(12345 , 54321);

        Details p1 = new Details();
        p1.name = "Rohit Verma";
        p1.age = 19;
        p1.ph_no = 999888777;
        p1.mail = "Galgotias.22SCSE@gmail.com";
        p1.adress = "Plot No. 2 , Gautum Budha Nagar , Greater Noida , Uttar Pradesh 203201";

        Details p2 = new Details();
        p2.name = "Namrata Pandey";
        p2.age = 25;
        p2.ph_no = 99887766;
        p2.mail = "Galgotias.22SCSE@gmail.com";
        p2.adress = "Plot No. 2 , Gautum Budha Nagar , Greater Noida , Uttar Pradesh 203201";
        
        HashMap<Integer , Integer> balance = new HashMap<>();
        balance.put(1234,10000);
        balance.put(12345,15000);

        HashMap<Integer , Details> info = new HashMap<>();
        info.put(1234,p1);
        info.put(12345,p2);
        

        Scanner in  = new Scanner(System.in);
        int acc_No , pass ;
        
        System.out.println("\n\t******************************************");
        System.out.println("\t\t   __    ______  ________\t\t");
        System.out.println("\t\t  //\\\\   ||||||  ||\\\\//||\t\t");
        System.out.println("\t\t //--\\\\    ||    || \\/ ||\t\t");
        System.out.println("\t\t//    \\\\   ||    ||    ||\t\t\n");
        System.out.println("\t******************************************\n");

        System.out.println("\t\t  Login into your Account\n");
        System.out.print("\tEnter Yout Account Number : " );
        acc_No = in.nextInt();
        System.out.print(("\tEnter Your Password : "));
        pass = in.nextInt();

        if(map.get(acc_No)!=pass){
            System.out.println("\n\t---Incorrect Information---");
            return ;
        }

        System.out.println("\n\t\t-----Your Details-----\n");
        info.get(acc_No).details();

        System.out.println("\n\t1. Check Balance");
        System.out.println("\t2. Deposite");
        System.out.println("\t3. Withdraw");
        System.out.println("\t4. ATM information");
        System.out.println("\t5. Exit");

        int choice , bal = balance.get(acc_No);

        System.out.print("\n\tEnter Your Choice : ");
        choice = in.nextInt();
        
        switch (choice) {
            case 1:
                System.out.println("Your current balance is $" + bal);
                break;
                
            case 2:
                System.out.print("\n\tEnter the amount to deposit : $");
                int depositAmount = in.nextInt();
                bal += depositAmount;
                System.out.println("\n\t\t----Request Granted----");
                System.out.println("\tYour new balance is $" + bal);
                break;
                
            case 3:
                System.out.print("\n\tEnter the amount to withdrawal : $");
                int withdrawAmount = in.nextInt();
                
                if (withdrawAmount > bal) {
                    System.out.println("\n\t---Insufficient Balance---");
                } else {
                    bal -= withdrawAmount;
                    System.out.println("\n\t\t----Request Granted----");
                    System.out.println("\tYour new balance is $" + bal);
                }
                
                break;

            case 4:
                System.out.println("\n\tAn ATM (Automated Teller Machine) is an electronic device thatenables bank \n\tcustomers to perform financial transactions without  the need for a bank teller or a branch.\n\t Here are some key pieces of information about ATMs:\n\t.  History: The first ATM was introduced in 1967 by Barclays Bank in the UK. Since then,\n\tATMs have become ubiquitous and are available in almost every part of the world.\n\t.  Functionality: ATMs allow bank customers to withdraw cash, deposit money, transfer \n\tfunds between accounts, check account balances, and perform other banking tasks.\n\t.  Security: ATMs use a range of security measures to ensure the safety of customer\n\ttransactions, such as PIN authentication, encryption, and biometric authentication.\n\t.  Types of ATMs: There are several types of ATMs available, including bank-owned ATMs,\n\tstandalone ATMs, and network ATMs.");
                
            case 5:
                System.out.println("Thank you for using the ATM.");
                System.exit(0);
                break;
                
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }
    
    }

}

class Details{
    String name;
    String adress;
    int age;
    long ph_no;
    String mail;

    void details(){
        System.out.println("\tAccount Holder's Name : "+name);
        System.out.println("\tAge : "+age);
        System.out.println("\tMobile Number : "+ph_no);
        System.out.println("\tEmail ID : "+mail);
        System.out.println("\tAdress : "+adress);
    }
}


