package faculty;


public class Wallet {

private int tokensBalance = 0;

    public boolean withdraw(int token){
        if(token > 0 && this.tokensBalance >= token){
            this.tokensBalance -= token;
            return true;
        }
        else{
            return false;
        }

    }

    public boolean deposit(int token){
        if(token > 0){
            this.tokensBalance += token;
            return true;
        }
        else{
            return false;
        }

    }

    public int getBalance(){
        return this.tokensBalance;
    }

}
