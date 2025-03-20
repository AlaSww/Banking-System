package tools;

public class Operation {
    private Double ammount;
    private String type;
    private static int counter=1000;
    private Integer OperationId;
    public Operation(String typ,double x){
        type=typ;
        OperationId=counter++;
        ammount=x;
    }
    public double getAmmount(){
        return ammount;
    }
    public String getType(){
        return type;
    }
    public int getId(){
        return OperationId;
    }
    public String toString(){
        return OperationId.toString()+": "+type+" "+ammount.toString();
    }
}

