package com.facebook.biddingkit.auction;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Auction$3 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ yf.b val$displayWinnerEntry;

    public Auction$3(a aVar, yf.b bVar) {
        this.val$displayWinnerEntry = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        a.e(null);
        a.f(null, this.val$displayWinnerEntry);
    }
}
