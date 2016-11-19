package com.rubenwardy.monzo_retrofit;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by ruben on 17/11/16.
 */

public class DummyTransactionBuilder {
    List<Merchant> merchants = new ArrayList<>();

    private void addMerchant(Merchant merchant) {
        merchant.id = merchant.name;
        merchant.group_id = "main";
        merchant.created = new Date();
        merchant.updated = merchant.created;
        merchant.metadata = new HashMap<>();
        merchant.emoji = "";
        merchant.logo = "";
        merchants.add(merchant);
    }

    private void fillMeta() {
        merchants.clear();

        Merchant merchant = new Merchant();
        merchant.name = "Bakery";
        merchant.category = "eating_out";
        merchant.online = false;
        merchant.abm = false;
        addMerchant(merchant);
    }


    public List<Transaction> build() {
        fillMeta();

        List<Transaction> transactions = new ArrayList<>();

        Calendar calendar = GregorianCalendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.MONTH, -2);
        Date earliest = calendar.getTime();

        Date date = new Date();
        int balance = 20;
        while (date.getTime() > earliest.getTime()) {
            {
                int cost = ThreadLocalRandom.current().nextInt(500, 2000 + 1);
                Transaction transaction = new Transaction();
                transaction.id = date.getTime() + ":" + cost + ":" + balance;
                transaction.account_balance = balance;
                transaction.amount = -cost;
                transaction.created = new Date(date.getTime());
                transaction.merchant = merchants.get(0);
                balance += cost;
                transactions.add(transaction);
            }


            if (balance > 10000) {
                Transaction transaction = new Transaction();
                transaction.id = date.getTime() + ":" + 10000 + ":" + balance;
                transaction.account_balance = balance;
                transaction.amount = 10000;
                transaction.created = new Date(date.getTime());
                transaction.merchant = merchants.get(0);
                balance -= 10000;
            }


            calendar.setTime(date);
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            date = calendar.getTime();
        }

        Collections.reverse(transactions);
        return transactions;
    }
}
