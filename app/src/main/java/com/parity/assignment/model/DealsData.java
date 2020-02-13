
package com.parity.assignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DealsData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("fpd_flag")
    @Expose
    private Boolean fpdFlag;
    @SerializedName("off_percent")
    @Expose
    private String offPercent;
    @SerializedName("current_price")
    @Expose
    private Double currentPrice;
    @SerializedName("original_price")
    @Expose
    private Double originalPrice;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("comments_count")
    @Expose
    private Integer commentsCount;
    @SerializedName("all_posts_count")
    @Expose
    private Integer allPostsCount;
    @SerializedName("created_at")
    @Expose
    private Long createdAt;
    @SerializedName("score")
    @Expose
    private Integer score;
    @SerializedName("vote_value")
    @Expose
    private Integer voteValue;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("share_url")
    @Expose
    private String shareUrl;
    @SerializedName("deal_url")
    @Expose
    private String dealUrl;
    @SerializedName("view_count")
    @Expose
    private Integer viewCount;
    @SerializedName("vote_down_reason")
    @Expose
    private VoteDownReason voteDownReason;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("fpd_suggestted")
    @Expose
    private Boolean fpdSuggestted;
    @SerializedName("front_page_suggestions_count")
    @Expose
    private Integer frontPageSuggestionsCount;
    @SerializedName("merchant")
    @Expose
    private Merchant merchant;
    @SerializedName("user")
    @Expose
    private User user;

    public DealsData(int id, String title, int voteCount, int commentsCount, long createdAt, String image){
        this.id = id;
        this.title = title;
        this.voteCount = voteCount;
        this.commentsCount = commentsCount;
        this.createdAt = createdAt;
        this.image = image;
    }

    public DealsData(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getFpdFlag() {
        return fpdFlag;
    }

    public void setFpdFlag(Boolean fpdFlag) {
        this.fpdFlag = fpdFlag;
    }

    public String getOffPercent() {
        return offPercent;
    }

    public void setOffPercent(String offPercent) {
        this.offPercent = offPercent;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCommentsCount() {
        return commentsCount;
    }

    public void setCommentsCount(Integer commentsCount) {
        this.commentsCount = commentsCount;
    }

    public Integer getAllPostsCount() {
        return allPostsCount;
    }

    public void setAllPostsCount(Integer allPostsCount) {
        this.allPostsCount = allPostsCount;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getVoteValue() {
        return voteValue;
    }

    public void setVoteValue(Integer voteValue) {
        this.voteValue = voteValue;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public String getShareUrl() {
        return shareUrl;
    }

    public void setShareUrl(String shareUrl) {
        this.shareUrl = shareUrl;
    }

    public String getDealUrl() {
        return dealUrl;
    }

    public void setDealUrl(String dealUrl) {
        this.dealUrl = dealUrl;
    }

    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }

    public VoteDownReason getVoteDownReason() {
        return voteDownReason;
    }

    public void setVoteDownReason(VoteDownReason voteDownReason) {
        this.voteDownReason = voteDownReason;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Boolean getFpdSuggestted() {
        return fpdSuggestted;
    }

    public void setFpdSuggestted(Boolean fpdSuggestted) {
        this.fpdSuggestted = fpdSuggestted;
    }

    public Integer getFrontPageSuggestionsCount() {
        return frontPageSuggestionsCount;
    }

    public void setFrontPageSuggestionsCount(Integer frontPageSuggestionsCount) {
        this.frontPageSuggestionsCount = frontPageSuggestionsCount;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
