package com.trainningapps.forex.reportms.dto;

/**
 * Class for sending the Transaction Details in the report
 * @author harii
 *
 */

public class TransactionDetails {

	private Long transactionId;
	private String senderName;
	private String receipientName;
	private int receipientAcc;
	private String exchangeFrom;
	private String exchangeTo;
	private int transactionFee;
	private int amount;

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long id) {
		this.transactionId = id;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getReceipientName() {
		return receipientName;
	}

	public void setReceipientName(String receipientName) {
		this.receipientName = receipientName;
	}

	public int getReceipientAcc() {
		return receipientAcc;
	}

	public void setReceipientAcc(int receipientAcc) {
		this.receipientAcc = receipientAcc;
	}

	public String getExchangeFrom() {
		return exchangeFrom;
	}

	public void setExchangeFrom(String exchangeFrom) {
		this.exchangeFrom = exchangeFrom;
	}

	public String getExchangeTo() {
		return exchangeTo;
	}

	public void setExchangeTo(String exchangeTo) {
		this.exchangeTo = exchangeTo;
	}

	public int getTransactionFee() {
		return transactionFee;
	}

	public void setTransactionFee(int transactionFee) {
		this.transactionFee = transactionFee;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
		result = prime * result + ((exchangeFrom == null) ? 0 : exchangeFrom.hashCode());
		result = prime * result + ((exchangeTo == null) ? 0 : exchangeTo.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + receipientAcc;
		result = prime * result + ((receipientName == null) ? 0 : receipientName.hashCode());
		result = prime * result + ((senderName == null) ? 0 : senderName.hashCode());
		result = prime * result + transactionFee;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDetails other = (TransactionDetails) obj;
		if (amount != other.amount)
			return false;
		if (exchangeFrom == null) {
			if (other.exchangeFrom != null)
				return false;
		} else if (!exchangeFrom.equals(other.exchangeFrom))
			return false;
		if (exchangeTo == null) {
			if (other.exchangeTo != null)
				return false;
		} else if (!exchangeTo.equals(other.exchangeTo))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (receipientAcc != other.receipientAcc)
			return false;
		if (receipientName == null) {
			if (other.receipientName != null)
				return false;
		} else if (!receipientName.equals(other.receipientName))
			return false;
		if (senderName == null) {
			if (other.senderName != null)
				return false;
		} else if (!senderName.equals(other.senderName))
			return false;
		if (transactionFee != other.transactionFee)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TransactionDetails [id=" + transactionId + ", senderName=" + senderName + ", receipientName=" + receipientName
				+ ", receipientAcc=" + receipientAcc + ", exchangeFrom=" + exchangeFrom + ", exchangeTo=" + exchangeTo
				+ ", transactionFee=" + transactionFee + ", amount=" + amount + "]";
	}
	
	

}
