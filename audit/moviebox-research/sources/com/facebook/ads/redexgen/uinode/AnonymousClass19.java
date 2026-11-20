package com.facebook.ads.redexgen.uinode;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.ads.AdError;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.19, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class AnonymousClass19 extends BroadcastReceiver {
    public static String[] A03 = {"JgmY627JJ4fVvMUsUI7dBJzvca", "2Fivc7ze9Y6M7vLBAhVCw66dd2zEUTp", "oqNyJxLxp23hnAfKGRpFUMlaCTnSy4au", "HRO7fC4J0U3bXqsrOiWljP6J940cuLTJ", "rhEs9JkkityiMJcgD18RNPKtdGmllPs6", "c8I5EiJJKjWgwuyghylYWruaZ4nXJiut", "YeKDqRnNq5JcEGU0HYsnt6sxK1D4K6hE", "zIQMBMVVQmczFglCifMrZtV9RNUhKeCf"};
    public AbstractC1902b9 A00;
    public AnonymousClass18 A01;
    public String A02;

    public AnonymousClass19(String str, AbstractC1902b9 abstractC1902b9, AnonymousClass18 anonymousClass18) {
        this.A00 = abstractC1902b9;
        this.A01 = anonymousClass18;
        this.A02 = str;
    }

    public final IntentFilter A00() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(QP.A06.A03(this.A02));
        intentFilter.addAction(QP.A09.A03(this.A02));
        intentFilter.addAction(QP.A04.A03(this.A02));
        intentFilter.addAction(QP.A0A.A03(this.A02));
        intentFilter.addAction(QP.A05.A03(this.A02));
        intentFilter.addAction(QP.A0C.A03(this.A02));
        intentFilter.addAction(QP.A0B.A03(this.A02));
        intentFilter.addAction(QP.A03.A03(this.A02));
        return intentFilter;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (QP.A06.A03(this.A02).equals(action)) {
            AnonymousClass18 anonymousClass18 = this.A01;
            AbstractC1902b9 abstractC1902b9 = this.A00;
            if (A03[1].length() != 11) {
                A03[0] = "z37hhVYNur1y5njE4t22VYTMbB";
                anonymousClass18.AD0(abstractC1902b9);
                return;
            }
        } else {
            if (!QP.A09.A03(this.A02).equals(action)) {
                if (QP.A04.A03(this.A02).equals(action)) {
                    this.A01.ACx(this.A00);
                    return;
                }
                if (QP.A0A.A03(this.A02).equals(action)) {
                    this.A01.ACz(this.A00);
                    return;
                }
                if (QP.A05.A03(this.A02).equals(action)) {
                    this.A01.onRewardedVideoClosed();
                    return;
                }
                if (QP.A0B.A03(this.A02).equals(action)) {
                    this.A01.ACv(this.A00);
                    return;
                } else if (QP.A0C.A03(this.A02).equals(action)) {
                    this.A01.ACw(this.A00);
                    return;
                } else {
                    if (QP.A03.A03(this.A02).equals(action)) {
                        this.A01.onRewardedVideoActivityDestroyed();
                        return;
                    }
                    return;
                }
            }
            boolean zA1V = C1384Ih.A1V(context);
            String[] strArr = A03;
            if (strArr[3].charAt(16) != strArr[4].charAt(16)) {
                A03[0] = "a2nbOp8yH430aeg70B0MHQFnwN";
                if (!zA1V) {
                    this.A01.AD1(this.A00, AdError.INTERNAL_ERROR);
                    return;
                }
                AnonymousClass18 anonymousClass19 = this.A01;
                AbstractC1902b9 abstractC1902b10 = this.A00;
                AdError adError = AdError.AD_PRESENTATION_ERROR;
                String[] strArr2 = A03;
                if (strArr2[3].charAt(16) != strArr2[4].charAt(16)) {
                    String[] strArr3 = A03;
                    strArr3[2] = "Smm3aT6IchFgLH9ob00fwQqxHFnPPG6O";
                    strArr3[5] = "wzZfDEncWZ9M4YUYJFr8Gzf2lfnMb6hd";
                    anonymousClass19.AD1(abstractC1902b10, adError);
                    return;
                }
                String[] strArr4 = A03;
                strArr4[6] = "douVyTcHxmEKv1YyJqQbVTsvWWCOpXBn";
                strArr4[7] = "x6yn97aV8hj96Z0WREVv4HAdEeLr9VIY";
                anonymousClass19.AD1(abstractC1902b10, adError);
                return;
            }
        }
        throw new RuntimeException();
    }
}
