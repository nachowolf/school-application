package faculty;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Wallet implements Person {

    List<Subject> qualified = new ArrayList<Subject>();
    private String name;
    private String surname;
    private String email;

//############# Constructor #############

    public Teacher(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

//#####################################


//########## Identity Methods ##########

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getSurname() {
        return this.surname;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

//####################################

    //########## Token Methods ##########

    //    GET TOKEN BALANCE FROM WALLET
    public int getTokenBalance() {
        return getBalance();
    }

    //    WITHDRAW TOKENS FROM WALLET
    public void withdrawTokens(int amt) {
        withdraw(amt);
    }

    //    DEPOSIT TOKENS INTO WALLET
    public void depositTokens(int amt) {
        deposit(amt);
    }

//#################################

// ########## Teacher Subject Methods ##########

//    ADD A SUBJECT THAT TEACHER CAN TEACH
    public void qualifySubject(Subject subject){
        qualified.add(subject);
    }

//    RETURN A LIST OF ALL SUBJECTS THE TEACHER IS QUALIFIED FOR
    public List getQualifiedSubjects(){
        return qualified;
    }

//    CHECKS IF A TEACHER IS QUALIFIED FOR A CERTAIN SUBJECT
    public boolean isQualified(Subject subject){
        if(qualified.contains(subject)){
            return true;
        }
        else{
            return false;
        }
    }

// ###########################################
}
