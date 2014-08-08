package com.konduto.sdk.models;
import com.google.gson.annotations.SerializedName;
import com.konduto.sdk.annotations.Required;
import java.util.Arrays;
/**
 *
 * Order model.
 *
 * @see <a href="http://docs.konduto.com">Konduto API Spec</a>
 *
 */
public final class KondutoOrder extends KondutoModel {
	/* Attributes */
	@Required
	private String id;

	private String visitor;

	private Long timestamp;

	@Required
	private Double totalAmount;

	private Double shippingAmount;
	private Double taxAmount;

	@Required
	private KondutoCustomer customer;

	private String currency;

	private Integer installments;

	private String ip;

	private Double score;

	@SerializedName("shipping")
	private KondutoAddress shippingAddress;

	@SerializedName("billing")
	private KondutoAddress billingAddress;

	private KondutoRecommendation recommendation;

	private KondutoOrderStatus status;

	private KondutoGeolocation geolocation;

	@SerializedName("payment")
	private KondutoPayment[] payments;

	private KondutoDevice device;

	@SerializedName("navigation")
	private KondutoNavigationInfo navigationInfo;

	/* Constructors */
	public KondutoOrder() {}

	/* equals */
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof KondutoOrder)) return false;
		KondutoOrder order = (KondutoOrder) o;
		if (billingAddress != null ? !billingAddress.equals(order.billingAddress) : order.billingAddress != null)
			return false;
		if (currency != null ? !currency.equals(order.currency) : order.currency != null) return false;
		if (!customer.equals(order.customer)) return false;
		
		if (geolocation != null ? !geolocation.equals(order.geolocation) : order.geolocation != null) return false;
		
		if (!id.equals(order.id)) return false;
		
		if (installments != null ? !installments.equals(order.installments) : order.installments != null) return false;
		
		if (ip != null ? !ip.equals(order.ip) : order.ip != null) return false;
		
		if (recommendation != order.recommendation) return false;
		
		if (score != null ? !score.equals(order.score) : order.score != null) return false;
		
		if (shippingAddress != null ? !shippingAddress.equals(order.shippingAddress) : order.shippingAddress != null)
			return false;

		if (shippingAmount != null ? !shippingAmount.equals(order.shippingAmount) : order.shippingAmount != null)
			return false;

		if (status != order.status) return false;

		if (taxAmount != null ? !taxAmount.equals(order.taxAmount) : order.taxAmount != null) return false;

		if (timestamp != null ? !timestamp.equals(order.timestamp) : order.timestamp != null) return false;

		if (!totalAmount.equals(order.totalAmount)) return false;

		if (visitor != null ? !visitor.equals(order.visitor) : order.visitor != null) return false;

		if (payments != null ? !Arrays.equals(payments, order.payments) : order.payments != null)
			return false;

		if (device != null ? !device.equals(order.device) : order.device != null) return false;

		if (navigationInfo != null ? !navigationInfo.equals(order.navigationInfo) : order.navigationInfo != null)
			return false;

		return true;
	}
	/* getters and setters */
	public KondutoNavigationInfo getNavigationInfo() {
		return navigationInfo;
	}
	public void setNavigationInfo(KondutoNavigationInfo navigationInfo) {
		this.navigationInfo = navigationInfo;
	}
	public KondutoDevice getDevice() {
		return device;
	}
	public void setDevice(KondutoDevice device) {
		this.device = device;
	}
	public KondutoPayment[] getPayments() {
		return payments;
	}
	public void setPayments(KondutoPayment[] payments) {
		this.payments = payments;
	}
	public KondutoOrderStatus getStatus() {
		return status;
	}
	public void setStatus(KondutoOrderStatus status) {
		this.status = status;
	}
	public KondutoGeolocation getGeolocation() {
		return geolocation;
	}
	public void setGeolocation(KondutoGeolocation geolocation) {
		this.geolocation = geolocation;
	}
	public KondutoAddress getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(KondutoAddress shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public KondutoAddress getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(KondutoAddress billingAddress) {
		this.billingAddress = billingAddress;
	}
	public KondutoRecommendation getRecommendation() {
		return recommendation;
	}
	public Double getScore() {
		return score;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVisitor() {
		return visitor;
	}
	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getShippingAmount() {
		return shippingAmount;
	}
	public void setShippingAmount(Double shippingAmount) {
		this.shippingAmount = shippingAmount;
	}
	public Double getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(Double taxAmount) {
		this.taxAmount = taxAmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public Integer getInstallments() {
		return installments;
	}
	public void setInstallments(Integer installments) {
		this.installments = installments;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public KondutoCustomer getCustomer() {
		return customer;
	}
	public void setCustomer(KondutoCustomer customer) {
		this.customer = customer;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public void setRecommendation(KondutoRecommendation recommendation) {
		this.recommendation = recommendation;
	}
}
