package com.rubenwardy.monzo_retrofit;

import java.util.Date;
import java.util.Map;

public class Transaction {
	public int account_balance;
	public int amount;
	public String currency;
	public String description;
	public String id;
	public String notes;

	public enum DeclineReason {
		NOT_DECLINED,
		INSUFFICIENT_FUNDS,
		CARD_INACTIVE,
		CARD_BLOCKED,
		OTHER;

		public String toString() {
			switch (this) {
				case NOT_DECLINED:
					return "NOT_DECLINED";
				case INSUFFICIENT_FUNDS:
					return "INSUFFICIENT_FUNDS";
				case CARD_INACTIVE:
					return "CARD_INACTIVE";
				case CARD_BLOCKED:
					return "CARD_BLOCKED";
				default:
					return "OTHER";
			}
		}
	}

	// This is only present on declined transactions
	public DeclineReason decline_reason = DeclineReason.NOT_DECLINED;

	// Top-ups to an account are represented as transactions with a positive amount and is_load = true.
	// Other transactions such as refunds, reversals or chargebacks may have a positive amount
	// but is_load = false
	public boolean is_load;

	public Date created;

	// The timestamp at which the transaction settled. In most cases, this happens 24-48 hours after
	// created. If this field is not present, the transaction is authorised but not yet “complete.”
	public Date settled;

	public String category;

	// This contains the merchant_id of the merchant that this transaction was made at.
	public Merchant merchant;

	public Map<String, String> metadata;
}
