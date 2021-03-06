package com;

import java.util.Scanner;
import java.util.List;

import com.client.Loan;

public class Run {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank bank = new Bank();
        Integer i,x,c;
        Double d, e;
        while(true) {
            try {
                String s = input.nextLine();
                switch (s) {
                    case "q":
                        return;
                    case "listAccounts":
                        System.out.println(bank.database.listAccounts());
                        break;
                    case "listClients":
                        System.out.println(bank.database.listClients());
                        break;
                    case "addAccount":
                        System.out.println("Input ClientID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.addAccount(i, "");
                        break;
                    case "calculateInterest":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.calculateInterest(i);
                        break;
                    case "cancelRecurringPayment":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input rpID");
                        s = input.nextLine();
                        c = Integer.parseInt(s);
                        bank.cancelRecurringPayment(i, c);
                        break;
                    case "changeDebitPin":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input currentPin");
                        s = input.nextLine();
                        x = Integer.parseInt(s);
                        System.out.println("Input requestedPin");
                        s = input.nextLine();
                        c = Integer.parseInt(s);
                        bank.changeDebitPin(i, x, c);
                        break;
                    case "checkBalance":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.checkBalance(i);
                        break;
                    case "createClient":
                        System.out.println("Input name");
                        s = input.nextLine();
                        bank.createClient(s);
                        break;
                    case "deleteAccount":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.deleteAccount(i);
                        break;
                    case "deleteClient":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.deleteClient(i);
                        break;
                    case "deleteDebit":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.deleteDebit(i);
                        break;
                    case "depositFunds":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input ammount");
                        s = input.nextLine();
                        d = Double.parseDouble(s);
                        bank.depositFunds(i, d);
                        break;
                    case "getStatement":
                        System.out.println("Input ClientID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.getStatement(i);
                        break;
                    case "issueDebitCard":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.issueDebitCard(i);
                        break;
                    case "setDebitPin":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input new pin");
                        s = input.nextLine();
                        c = Integer.parseInt(s);
                        bank.setDebitPin(i, c);
                        break;
                    case "setRecurringPayment":
                        System.out.println("Input first AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input ammount");
                        s = input.nextLine();
                        d = Double.parseDouble(s);
                        System.out.println("Input second AccountID");
                        s = input.nextLine();
                        c = Integer.parseInt(s);
                        bank.setRecurringPayment(i, d, c);
                        break;
                    case "toggleFreeze":
                        System.out.println("Input first ClientID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        bank.toggleFreeze(i);
                        break;
                    case "transferFunds":
                        System.out.println("Input first AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input ammount");
                        s = input.nextLine();
                        x = Integer.parseInt(s);
                        System.out.println("Input second AccountID");
                        s = input.nextLine();
                        c = Integer.parseInt(s);
                        bank.transferFunds(i, c, x);
                        break;
                    case "withdrawFunds":
                        System.out.println("Input AccountID");
                        s = input.nextLine();
                        i = Integer.parseInt(s);
                        System.out.println("Input ammount");
                        s = input.nextLine();
                        d = Double.parseDouble(s);
                        bank.withdrawFunds(i, d);
                        break;
		    case "addLoan":
		    	System.out.println("Input AccountID");
			s = input.nextLine();
			i = Integer.parseInt(s);
			System.out.println("Input loan amount");
			s = input.nextLine();
			d = Double.parseDouble(s);
			System.out.println("Input interest rate");
			s = input.nextLine();
			e = Double.parseDouble(s);
			bank.addLoan(d, e, i);
			break;
		    case "payLoan":
		    	System.out.println("Input ClientID");
			s = input.nextLine();
			i = Integer.parseInt(s);
			System.out.println("Input LoanID");
			s = input.nextLine();
			x = Integer.parseInt(s);
			System.out.println("Input payment amount");
			s = input.nextLine();
			d = Double.parseDouble(s);
			bank.payLoan(i, x, d);
			break;
		    case "viewLoans":
		    	System.out.println("Input ClientID");
			s = input.nextLine();
			i = Integer.parseInt(s);
			List<Loan> loans = bank.viewLoans(i);
			for (Loan l : loans) {
				System.out.println("LoanID: " + l.getLoanID() + "  Amount: " + l.getLoanAmount());
			}
			break;
		    case "calculateInterestOnLoan":
		    	System.out.println("Input ClientID");
			s = input.nextLine();
			i = Integer.parseInt(s);
			System.out.println("Input LoanID");
			s = input.nextLine();
			x = Integer.parseInt(s);
			bank.calculateInterestOnLoan(i, s);
			break;
                }
            } catch (Exception e) {
                System.out.println("Error in input");
            }
        }
    }

}
