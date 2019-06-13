package faculty;


public class Wallet {

private double tokensBalance = 0.00;

    public boolean withdraw(double token){
        if(token > 0 && this.tokensBalance >= token){
            this.tokensBalance -= Math.round(token * 100.0)/100.0;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean deposit(double token){
        if(token > 0){
            this.tokensBalance += Math.round(token * 100.0)/100.0;
            return true;
        }
        else{
            return false;
        }

    }

    public double getBalance(){
        return Math.round(this.tokensBalance * 100.0)/100.0;
    }

}
