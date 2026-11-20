package com.facebook.biddingkit.auction;

import com.facebook.biddingkit.facebook.bidder.FacebookBidder;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
class Auction$1 implements Runnable {
    final /* synthetic */ a this$0;
    final /* synthetic */ c val$listener;
    final /* synthetic */ yf.a val$waterfall;

    /* JADX INFO: renamed from: com.facebook.biddingkit.auction.Auction$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            Auction$1.this.getClass();
            boolean z11 = false;
            for (sf.b bVar : a.b(null)) {
                if (bVar instanceof sf.d) {
                    Auction$1.this.getClass();
                    String strD = a.d(null);
                    Auction$1.this.getClass();
                    Auction$1.this.getClass();
                    ((sf.d) bVar).a(strD, null, a.a(null));
                }
                if (bVar instanceof FacebookBidder) {
                    z11 = true;
                }
            }
            if (z11) {
                return;
            }
            Auction$1.this.getClass();
            sf.e eVarE = FacebookBidder.e(a.a(null));
            Auction$1.this.getClass();
            String strD2 = a.d(null);
            Auction$1.this.getClass();
            eVarE.a(strD2, null);
        }
    }

    public Auction$1(a aVar, yf.a aVar2, c cVar) {
    }

    @Override // java.lang.Runnable
    public void run() {
        System.currentTimeMillis();
        throw null;
    }
}
