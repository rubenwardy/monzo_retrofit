# MonzoAPI Retrofit

License: MIT.  
Created by rubenwardy

## Installation

Coming soon, I'm not very good with Java Libraries.

## Aquiring a Retrofit Interface

Use MonzoAPIBuilder to create MonzoAPI instances.

```Java
MonzoAPI monzo_unauthorized = MonzoAPIBuilder.createService();
MonzoAPI monzo_authorized = MonzoAPIBuilder.createService("accesstoken");
```

MonzoAPI is an interface which specifies MonzoAPI endpoints.


## Endpoints


### Exchange Auth Token for AccessToken

Get an access token. The first parameter must be "authorization_code".

```Java
monzo_unauthorized.getAccessTokenFromAuthCode("authorization_code", BuildConfig.CLIENT_ID,
		BuildConfig.CLIENT_SECRET, redirectUri, code).enqueue(new Callback<AccessToken>() {
	@Override
	public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
		AccessToken token = response.body();
		if (token != null) {
			// success
		} else {
			// failure
		}
	}

	@Override
	public void onFailure(Call<AccessToken> call, Throwable t) {
		// failure
	}
});
```

### Getting list of accounts

```Java
monzo_authorized.getAccounts().enqueue(new Callback<MonzoAPIService.AccountList>() {
	@Override
	public void onResponse(Call<MonzoAPIService.AccountList> call, Response<MonzoAPIService.AccountList> response) {
		MonzoAPIService.AccountList accountList = response.body();
		if (accountList != null && accountList.accounts.size() > 0) {
			List<Account> accounts = accountList.accounts;
			// success
		} else {
			// failure
		}
	}

	@Override
	public void onFailure(Call<MonzoAPIService.AccountList> call, Throwable t) {
		// failure
	}
});
```

### Getting transactions

The second parameter must be "merchant" - the future we'll make this optional.

```Java
monzo_authorized.getTransactions(account_id, "merchant").enqueue(new Callback<MonzoAPIService.TransactionList>() {
	@Override
	public void onResponse(Call<MonzoAPIService.TransactionList> call, Response<MonzoAPIService.TransactionList> response) {
		if (response.body() != null) {
			List<Transactions> full_transactions = response.body().transactions;
			// success
		} else {
			// failure
		}
	}

	@Override
	public void onFailure(Call<MonzoAPIService.TransactionList> call, Throwable t) {
		// failure
	}
});
```

### Get Balance

```Java
monzo_authorized.getBalance(account_id).enqueue(new Callback<Balance>() {
	@Override
	public void onResponse(Call<Balance> call, Response<Balance> response) {
		Balance balance = response.body();
		if (balance != null) {
			// success
		} else {
			// failure
		}
	}

	@Override
	public void onFailure(Call<Balance> call, Throwable t) {
		// failure
	}
});
```

### Coming Soon (PRs accepted)

* Ping
* Token refresh
* Pagination support
* Retrieve single transaction from id
* Annotate transaction
* Create feed item
* Webhooks
	* create
	* list
	* delete
* Attachments
	* upload
	* register
	* deregister
