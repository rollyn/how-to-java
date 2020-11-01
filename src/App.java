import com.wisphil.exception.AccountException;
import com.wisphil.model.Account;
import com.wisphil.model.CheckingAccount;
import com.wisphil.model.SavingAccount;
import com.wisphil.service.Banking;
import com.wisphil.service.BankingService;

public class App {

    public static void main(String[] args) {

        SavingAccount account = new SavingAccount();
        account.setAccountID("001");

        System.out.println( account.getAccountID() );
        Account account1 = new Account();


//       SavingAccount saving = new SavingAccount();
//       saving.setAccountID("01");
//       saving.setName("JOHN");
//       saving.setBalance(100d);
//       saving.setInterest(0.006);
//
//       CheckingAccount checking = new CheckingAccount();
//       checking.setAccountID("02");
//       checking.setName("JOHN");
//       checking.setBalance(100d);
//       checking.setInterest(0.006);
//       checking.setTerm("12");
//
//
//       BankingService bankingService = new BankingService();
//
//       try {
//
//           bankingService.createAccount(checking);
//       } catch (AccountException e) {
//           System.out.println("Account creation not successful");
//       }
        App app = new App();

        int total = app.add(1,2);
        System.out.println( total );
        int floatTotal = app.add(1.2f, 4.2f);
        System.out.println( floatTotal );

    }

    public int add(int a, int b) {
        return a + b;
    }
    public int add(float a, float b) {
        return  (int)(a + b);
    }

    public String add(double a, double b) {
        return String.valueOf(a + b);
    }

}
