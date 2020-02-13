
package com.parity.assignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VoteDownReason {

    @SerializedName("Referral link")
    @Expose
    private Integer referralLink;
    @SerializedName("Better price elsewhere")
    @Expose
    private Integer betterPriceElsewhere;
    @SerializedName("Product not good/not worth the price")
    @Expose
    private Integer productNotGoodNotWorthThePrice;
    @SerializedName("Other reasons")
    @Expose
    private Integer otherReasons;
    @SerializedName("Invalid/User Specific Coupon/Deal")
    @Expose
    private Integer invalidUserSpecificCouponDeal;
    @SerializedName("Repost")
    @Expose
    private Integer repost;
    @SerializedName("Self Promotion")
    @Expose
    private Integer selfPromotion;

    public Integer getReferralLink() {
        return referralLink;
    }

    public void setReferralLink(Integer referralLink) {
        this.referralLink = referralLink;
    }

    public Integer getBetterPriceElsewhere() {
        return betterPriceElsewhere;
    }

    public void setBetterPriceElsewhere(Integer betterPriceElsewhere) {
        this.betterPriceElsewhere = betterPriceElsewhere;
    }

    public Integer getProductNotGoodNotWorthThePrice() {
        return productNotGoodNotWorthThePrice;
    }

    public void setProductNotGoodNotWorthThePrice(Integer productNotGoodNotWorthThePrice) {
        this.productNotGoodNotWorthThePrice = productNotGoodNotWorthThePrice;
    }

    public Integer getOtherReasons() {
        return otherReasons;
    }

    public void setOtherReasons(Integer otherReasons) {
        this.otherReasons = otherReasons;
    }

    public Integer getInvalidUserSpecificCouponDeal() {
        return invalidUserSpecificCouponDeal;
    }

    public void setInvalidUserSpecificCouponDeal(Integer invalidUserSpecificCouponDeal) {
        this.invalidUserSpecificCouponDeal = invalidUserSpecificCouponDeal;
    }

    public Integer getRepost() {
        return repost;
    }

    public void setRepost(Integer repost) {
        this.repost = repost;
    }

    public Integer getSelfPromotion() {
        return selfPromotion;
    }

    public void setSelfPromotion(Integer selfPromotion) {
        this.selfPromotion = selfPromotion;
    }

}
