import java.util.HashMap;
import java.util.Scanner;
import tools.*;
import users.Admin;
import users.User;
public class bankingSystem {
    private static HashMap<String,Account> bankAccounts=new HashMap<>();
    static HashMap<String,String> admins=new HashMap<>();
    public static void main(String[] args){
        admins.put("admin1", "123");
        admins.put("admin2","321");    
        boolean run=true;
        while(run){
            Scanner sc=new Scanner(System.in);
            System.out.println("choose your character: ");
            System.out.println("1- Admin");
            System.out.println("2- User");
            System.out.println("3- Exit");
            int x=sc.nextInt();
            sc.nextLine();
            switch(x){
                case 1:
                    String login;
                    String password=new String();
                    int k=0;
                    System.out.println("enter your login:");
                    login=sc.nextLine();
                    if(admins.containsKey(login)){
                        while(!(admins.get(login).equals(password)) && k<5){
                            System.out.println("enter your password: ");
                            password=sc.nextLine();
                            k++;
                        }
                        if(admins.get(login).equals(password)){
                            adminMenu(new Admin(login, password),sc);
                        }
                        else{
                            System.out.println("WRONG password please try again later");
                        }
                    }
                    else{
                        System.out.println("sorry there is no admin with this login...");
                    }
                break;
                case 2:
                    if(!bankAccounts.isEmpty()){
                        String username=new String();
                        int i=0;
                        while(!bankAccounts.containsKey(username) && i<6){
                            System.out.println("ENTER YOUR USERNAME: ");
                            username=sc.nextLine();
                            i++;
                        }
                        if(bankAccounts.containsKey(username)){
                            i=0;
                            String passs =new String();
                            while(!bankAccounts.get(username).GetPassword().equals(passs) && i<5){
                                System.out.println("ENTER YOUR PASSWORD: ");
                                passs=sc.nextLine();
                                i++;
                            }
                            if(bankAccounts.get(username).GetPassword().equals(passs)){
                                User user=new User(bankAccounts.get(username));
                                userMenu(user,sc);
                                username=user.acc.GetUserName();
                            }
                            else{
                                System.out.println("IT SEEMS LIKE YOU DON'T KNOW THE PASSWORD:>");
                            }
                            System.out.println(bankAccounts.get(username).GetPassword());
                        }
                        else{
                            System.out.println("THIS USERNAME DOES NOT EXIST YOU CAN ASK AN ADMIN TO MAKE AN ACCOUNT FOR YOU...");
                        }
                    }
                    else{
                        System.out.println("ASK AN ADMIN TO MAKE AN ACCOUNT FOR YOU:>");
                    }
                    break;
                case 3:
                    System.out.println("Exiting the system...");
                    run=false;
                    break;
            }
        }
    }
    private static void adminMenu(Admin admin,Scanner sc){
        boolean run=true;
        while(run){
            System.out.println("what do you want: ");
            System.out.println("1- add account");
            System.out.println("2- remove account");
            System.out.println("3- show balance");
            System.out.println("4- add operation");
            System.out.println("5- delete operation");
            System.out.println("6- logout");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    if (bankAccounts==null){
                        bankAccounts=new HashMap<>();
                    }
                    System.out.println("username: ");
                    String user=sc.nextLine();
                    System.out.println("pass: ");
                    String pass=sc.nextLine();
                    admin.AddAccount(bankAccounts,user,pass);
                    break;
                case 2:
                    if(!bankAccounts.isEmpty()){
                        System.out.println("ENTER the username of the account you want to remove:");
                        user=sc.nextLine();
                        admin.deleteAccount(bankAccounts, user);
                    }
                    else{
                        System.out.println("there is no account in the system");
                    }
                    break;
                case 3:
                    if(!bankAccounts.isEmpty()){
                        System.out.println("Enter the username of the account you want to check it's balance:");
                        user=sc.nextLine();
                        if(bankAccounts.containsKey(user)){ 
                            admin.viewBalance(bankAccounts.get(user));
                        }
                        else{
                            System.out.println("there is no account with this username");
                        }
                    }
                    else{
                        System.out.println("there is no account in the system");
                    }
                    break;
                case 4:
                    System.out.println("Enter the username of the account you want to add an operation to: ");
                    user=sc.nextLine();
                    if(!bankAccounts.isEmpty() && bankAccounts.containsKey(user)){
                        System.out.println("1- deposit \n 2-withdraw");
                        int type=sc.nextInt();
                        sc.nextLine();
                        System.out.println("ENTER the ammount: ");
                        double ammount=sc.nextDouble();
                        sc.nextLine();
                        switch (type){
                            case 1:
                                admin.addOperation(bankAccounts.get(user), ammount, "deposit");
                                break;
                            case 2:
                                admin.addOperation(bankAccounts.get(user), ammount, "withdraw");
                    }}
                    else{
                        System.out.println("there is no account with the user name "+user);
                    }
                    break;
                case 5:
                    if(!bankAccounts.isEmpty()){
                        System.out.println("Enter the username of the account you want to delete an operation from : ");
                        user=sc.nextLine();
                        if(bankAccounts.containsKey(user)){
                            System.out.println("ENTER the operation ID: ");
                            int id=sc.nextInt();
                            if(bankAccounts.get(user).getOperationsIds().contains(id)){
                                admin.deleteOperation(bankAccounts.get(user),id);
                            }
                            else{
                                System.out.println("operation doesn't exist");
                            }
                        }
                        else{
                            System.out.println("username doesn't exist");
                        }
                    }
                    else{
                        System.out.println("there is no account in the system:)");
                    }
                    break;
                case 6:
                    admin.logout();
                    run=false;
                    break;
            }
        }
    }
    private static void userMenu(User user,Scanner sc){
        boolean run=true;
        while(run){
            System.out.println("WHAT DO YOU WANT: \n 1- VIEW BALANCE \n 2- VIEW PERSONAL INFORMATION \n 3- MODIFY PERSONAL INFORMATION \n 4- LIST OPERATIONS \n 5-EXIT");
            int choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1:
                    user.viewBalance();
                    break;
                case 2:
                    user.viewInformation();
                    break;
                case 3:
                    System.out.println("1- USERNAME \n 2-PASSWORD \n 3-BOTH");
                    int choice2=sc.nextInt();
                    sc.nextLine();
                    switch(choice2){
                        case 1:
                            System.out.print("NEW USERNAME:");
                            user.editUserName(bankAccounts,sc.nextLine());
                            break;
                        case 2:
                            System.out.print("NEW PASSWORD:");
                            user.editPassword(sc.nextLine());
                            break;
                        case 3:
                            System.out.print("NEW USERNAME:");
                            user.editUserName(bankAccounts,sc.nextLine());
                            System.out.print("NEW PASSWORD:");
                            user.editPassword(sc.nextLine());
                            break;
                    }
                    break;
                case 4:
                    user.listOperations();
                    break;
                case 5:
                    System.out.println("GOOD BYE...");
                    run=false;
            }
        }
    }
}