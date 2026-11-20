package com.facebook.biddingkit.gen;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public enum FBAdBidAuctionType {
    FIRST_PRICE(1),
    SECOND_PRICE(2);

    private final int mValue;

    FBAdBidAuctionType(int i11) {
        this.mValue = i11;
    }

    public int getValue() {
        return this.mValue;
    }
}
