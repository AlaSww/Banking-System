package users;
import java.util.HashMap;
import tools.*;

public class User {
    public Account acc;
    public User(Account acc){
        this.acc=acc;
    }
    public void viewInformation(){
        System.out.println("username: "+(acc.GetUserName()));
        System.out.println("password: "+(acc.GetPassword()));
    }
    public void viewBalance(){
        System.out.println(acc.getBalance());
    }
    public void editUserName(HashMap<String,Account> accounts,String newUserName){
        accounts.remove(acc.GetUserName());
        this.acc.SetUserName(newUserName);
        accounts.put(newUserName,this.acc);
    }
    public void editPassword(String newPassword){
        acc.SetPassword(newPassword);
    }
    public void listOperations(){
        acc.listOperations();
    }
}