package tools;
import java.util.ArrayList;
public class Account {
    private String username;
    private String password;
    private static int counter=1000;
    private ArrayList<Operation> operations;
    private Double balance;
    public Account(String name,String pass){
        username=name;
        password=pass;
        balance=0.0;
        operations=new ArrayList<>();
    }
    public void SetUserName(String name){
        username=name;
    }
    public void SetPassword(String pass){
        password=pass;
    }
    public void setBalance(double value){
        balance=value;
    }
    public String GetUserName(){
        return username.toString();
    }
    public String GetPassword(){
        return password.toString();
    }
    public double getBalance(){
        return balance;
    }
    public void addOperation(Operation x){
        if("deposit".equals(x.getType())){
            balance+=x.getAmmount();
            operations.add(x);
        }
        else{
            if(balance>x.getAmmount()){
                balance-=x.getAmmount();
                operations.add(x);
            }
            else{
                System.out.println("Balance is insufusant");
            }
        }
    }
    public void rmOperation(int x){
        int i=0;
        boolean test=false;
        while(i<operations.size() && test==false){
            if(operations.get(i).getId()==x){
                test=true;
            }
            i++;
        }
        if (test==true){
            operations.remove(i-1);
        }
    }
    public void listOperations(){
        for (Operation x : operations) {
            System.out.println(x.toString());
        }
    }
    public ArrayList<Integer> getOperationsIds(){
        ArrayList<Integer> res=new ArrayList<>();
        for(Operation x:operations){
            res.add(x.getId());
        }
        return res;
    }
}

