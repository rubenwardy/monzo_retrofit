package com.rubenwardy.monzo_retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface MonzoAPI {
    @FormUrlEncoded
    @POST("oauth2/token")
    Call<AccessToken> getAccessTokenFromAuthCode(
            @Field("grant_type")    String grant_type,
            @Field("client_id")     String client_id,
            @Field("client_secret") String client_secret,
            @Field("redirect_uri")  String redirect_uri,
            @Field("code")          String code);

    @GET("accounts")
    Call<AccountList> getAccounts();
    class AccountList {
        public List<Account> accounts;
    }

    @GET("balance")
    Call<Balance> getBalance(@Query("account_id") String account_id);

    @GET("transactions")
    Call<TransactionList> getTransactions(@Query("account_id") String account_id, @Query("expand[]") String expand);
    class TransactionList {
        public List<Transaction> transactions;
    }
}
