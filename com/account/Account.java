package com.account;

import com.client.Client;
import com.db.Database;
import com.account.RecurringPayment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Account {
    private Double Balance;
    private int accountID;
    private List<Integer> clientList;
    private List<RecurringPayment> rpList;
    private boolean freezeStatus;
    private int pin;
    private double interest;

    public Account(double balance) {
        Balance = balance;
        Random random = new Random();
        accountID = random.nextInt();
	System.out.println("\n  Account ID: " + accountID + "\n");
        clientList = new ArrayList<Integer>();
        rpList = new ArrayList<RecurringPayment>();
        freezeStatus = false;
        interest = 1.01;
    }

    public Account() {
        Balance = 0.0;
        Random random = new Random();
        accountID = random.nextInt();
	System.out.println("\n  Account ID: " + accountID + "\n");
        clientList = new ArrayList<Integer>();
        rpList = new ArrayList<RecurringPayment>();
        freezeStatus = false;
        interest = 1;
    }

    public double getBalance() {
        return Balance;
    }

    public int getAccountID() {
        return accountID;
    }


    public boolean addClient(Client client) {
        if (freezeStatus) return false;
        clientList.add(client.getClientID());
        return true;
    }

    public List<Integer> getClientList() {
        return clientList;
    }

    public boolean deposit(double ammount) {
        if (freezeStatus) return false;
        Balance += ammount;
        return true;
    }

    public boolean withdraw(double ammount) {
        if (freezeStatus) return false;
        Balance -= ammount;
        return true;
    }

    public boolean addRecurringPayment(double amount, int aID) {
        if (freezeStatus) return false;
        int size = rpList.size();
        int i = 0;
        if (size > 0) i = rpList.get(size - 1).getID();
        i++;
        RecurringPayment r = new RecurringPayment(aID, amount, i);
        rpList.add(r);
        return true;
    }

    public boolean deleteRecurringPayment(int rpID) {
        if (freezeStatus) return false;
        int s = rpList.size();
        int n = 0;
        int ID = 0;
        boolean done = false;
        while (n < s && !done) {
            ID = rpList.get(n).getID();
            if (ID == rpID) {
                rpList.remove(n);
                done = true;
            } else n++;
        }
        if (n == s) {
            return false;
        }
        return true;
    }

    public double calculatePayments() {
        int i = 0;
        int sum = 0;
        while (i < rpList.size()) {
            sum += rpList.get(i).getPayment();
            i++;
        }
        return sum;
    }

    public int issueDebitCard() {
        if (freezeStatus) return -1;
        pin = 0; //sets pin to invalid call setDebit to make valid
        return pin;
    }

    public boolean setDebitPin(int pinToSet) {
        if (freezeStatus) return false;
        if (pinToSet >= 1000 && pinToSet <= 9999) {
            pin = pinToSet;
            return true;
        } else {
            return false;
        }
    }

    public boolean changeDebitPin(int currentPin, int pinToSet) {
        if (freezeStatus) return false;
        if (currentPin == pin) {
            pin = pinToSet;
            return true;
        } else {
            return false;
        }
    }

    public void calculateInterest() {
        Balance *= interest;
    }

    public boolean deleteDebit() {
        if (freezeStatus) return false;
        pin = 0;
        return true;
    }

    public boolean setFreeze(boolean f) {
        freezeStatus = f;
        return true;
    }


}
