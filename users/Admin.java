package users;
import java.util.HashMap;
import tools.*;

public class Admin{
    private String login;
    private String password;

    public Admin(String log , String pass){
        this.login=log;
        this.password=pass;
    }
    public void logout(){
        System.out.println("An admin logged out");
    }
    public void AddAccount(HashMap<String,Account> accounts,String user,String pass){
        Account acc=new Account(user,pass);
        accounts.put(user,acc);
    }
    public void addOperation(Account acc,double ammount,String type){
        Operation x=new Operation(type, ammount);
        acc.addOperation(x);
    }
    public void deleteOperation(Account acc,int id){
        acc.rmOperation(id);
    }
    public void viewBalance(Account acc){
        System.out.println(acc.getBalance());
    }
    public void deleteAccount(HashMap<String,Account> accounts,String user){
        accounts.remove(user);}
}