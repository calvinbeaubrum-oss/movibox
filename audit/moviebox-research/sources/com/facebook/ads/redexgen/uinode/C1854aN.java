package com.facebook.ads.redexgen.uinode;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.applovin.exoplayer2.common.base.Ascii;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.facebook.ads.RewardedAdListener;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aN, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1854aN implements C2D {
    public static byte[] A05;
    public static String[] A06 = {"PyT2XUnl", "3EmvKqRjFYzRkizxlD8eotggUBC8U5J9", "Ib6uyfMRsh5ysHZ3i8ryXk3sO16qq9Ys", "q2kkzr74cnXMazMYxmC9c", "9U931lGThJH7Qz6wctlm6EKEWHFtvDAV", "f15MquYM06llw3BWZWASFwAp5egI2HKX", "yMUgiPhi", "t3xZZPMR"};
    public final AbstractC1867aa A00;
    public final AnonymousClass21 A01;
    public final AnonymousClass26 A02;
    public final AnonymousClass29 A03;
    public final C1795Yn A04;

    static {
        A01();
    }

    public C1854aN(C1795Yn c1795Yn, AnonymousClass26 anonymousClass26, AnonymousClass21 anonymousClass21, AbstractC1867aa abstractC1867aa, AnonymousClass29 anonymousClass29) {
        this.A04 = c1795Yn;
        this.A02 = anonymousClass26;
        this.A01 = anonymousClass21;
        this.A00 = abstractC1867aa;
        this.A03 = anonymousClass29;
    }

    public static String A00(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A05 = new byte[]{-77, -42, -110, -31, -44, -36, -41, -43, -26, -110, -37, -27, -110, -32, -25, -34, -34, -115, -96, -103, -113, -105, -112, -86, -112, -93, -97, -99, -116, -98, -86, -106, -112, -92, -74, -78, -79, -27, -44, -39, -43, -34, -45, -43, -66, -43, -28, -25, -33, -30, -37, -87, -82, -76, -65, -91, -78, -78, -81, -78, -65, -93, -81, -92, -91, -65, -85, -91, -71, 4, 7, 6, -1, Ascii.ETB, 1, 6, Ascii.SO, -7, 4, 1, -4, -7, Ascii.FF, 1, 7, 6, Ascii.ETB, Ascii.FF, 1, 5, -3, Ascii.ETB, 3, -3, 17, -61, -37, -23, -23, -41, -35, -37, -80, -106, -66, -38, -28, -28, -38, -33, -40, -111, -45, -26, -33, -43, -35, -42, -111, -41, -32, -29, -111, -34, -42, -28, -28, -46, -40, -42, -97, -95, -94, -96, -83, -109, -96, -96, -99, -96, -83, -101, -109, -95, -95, -113, -107, -109, -83, -103, -109, -89, 4, 19, Ascii.FF};
    }

    @Override // com.facebook.ads.redexgen.uinode.C2D
    public final Bundle A4e(String str) {
        return C2L.A02(str, this.A02);
    }

    @Override // com.facebook.ads.redexgen.uinode.C2D
    public final void A56() {
        this.A03.A0F(1012, null);
        this.A03.A0C();
        this.A02.A0D(null);
    }

    @Override // com.facebook.ads.redexgen.uinode.C2D
    public final int A7J() {
        return 1010;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:21:0x00b5 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:27:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:29:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:31:0x0100 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:32:0x0101  */
    /* JADX WARN: Code duplicated, block: B:33:0x010b  */
    /* JADX WARN: Code duplicated, block: B:35:0x0120  */
    /* JADX WARN: Code duplicated, block: B:37:0x0130  */
    /* JADX WARN: Code duplicated, block: B:39:0x0134  */
    @Override // com.facebook.ads.redexgen.uinode.C2D
    public final void A8W(Message message) {
        int i11;
        String[] strArr;
        RewardedAdListener rewardedAdListenerA04;
        InterstitialAd interstitialAdA01 = this.A02.A01();
        String strA00 = A00(152, 3, 106);
        if (interstitialAdA01 == null) {
            this.A04.A07().A9a(strA00, C8A.A0K, new C8B(A00(0, 17, 57)));
            return;
        }
        int i12 = message.what;
        String strA01 = A00(95, 9, 61);
        String strA02 = A00(104, 27, 56);
        String strA03 = A00(17, 17, 18);
        switch (i12) {
            case 10:
            case 1023:
                Bundle bundle = message.getData().getBundle(strA03);
                if (bundle != null) {
                    int i13 = bundle.getInt(A00(51, 18, 39));
                    String string = bundle.getString(A00(131, 21, 21));
                    AdError adError = new AdError(i13, string);
                    this.A01.AG0(adError);
                    if (this.A02.A02() != null) {
                        this.A02.A02().onError(interstitialAdA01, adError);
                    } else {
                        Log.e(A00(34, 17, 55), string);
                    }
                } else {
                    this.A01.AFw(AnonymousClass20.A05);
                    this.A04.A07().A9a(strA00, C8A.A0V, new C8B(strA02, strA01 + message));
                }
                this.A02.A0D(null);
                return;
            case PointerIconCompat.TYPE_GRAB /* 1020 */:
                this.A01.AG5();
                Bundle bundle2 = message.getData().getBundle(strA03);
                if (bundle2 != null) {
                    this.A02.A0C(bundle2.getLong(A00(69, 26, 127)));
                } else {
                    this.A04.A07().A9a(strA00, C8A.A0V, new C8B(strA02, strA01 + message));
                }
                this.A02.A0D(null);
                break;
            case 1022:
                this.A01.AGF();
                break;
        }
        if (this.A02.A02() == null) {
            return;
        }
        switch (message.what) {
            case PointerIconCompat.TYPE_GRAB /* 1020 */:
                this.A02.A02().onAdLoaded(interstitialAdA01);
                return;
            case PointerIconCompat.TYPE_GRABBING /* 1021 */:
                this.A02.A02().onInterstitialDisplayed(interstitialAdA01);
                if (A06[2].charAt(18) != 'n') {
                    String[] strArr2 = A06;
                    strArr2[1] = "IMuRostxJ5htnzhiOcsxYcu1iidsGUgj";
                    strArr2[5] = "ubJ4M5GxN6FfPval4rtOnbhl8vPUgGKC";
                    return;
                }
                throw new RuntimeException();
            case 1022:
                this.A02.A02().onInterstitialDismissed(interstitialAdA01);
                return;
            case 1023:
            default:
                if (this.A02.A04() == null) {
                    return;
                }
                i11 = message.what;
                strArr = A06;
                if (strArr[3].length() != strArr[7].length()) {
                    A06[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                    switch (i11) {
                        case AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS /* 3000 */:
                            this.A02.A04().onRewardedAdCompleted();
                            return;
                        case 3001:
                            rewardedAdListenerA04 = this.A02.A04();
                            if (A06[2].charAt(18) == 'n') {
                                rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                return;
                            }
                            String[] strArr3 = A06;
                            strArr3[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                            strArr3[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                            rewardedAdListenerA04.onRewardedAdServerSucceeded();
                            return;
                        case 3002:
                            this.A02.A04().onRewardedAdServerFailed();
                            return;
                        default:
                            return;
                    }
                }
                throw new RuntimeException();
            case 1024:
                this.A02.A02().onAdClicked(interstitialAdA01);
                return;
            case InputDeviceCompat.SOURCE_GAMEPAD /* 1025 */:
                this.A02.A02().onLoggingImpression(interstitialAdA01);
                return;
            case 1026:
                if (this.A02.A02() instanceof InterstitialAdExtendedListener) {
                    AnonymousClass26 anonymousClass26 = this.A02;
                    if (A06[2].charAt(18) != 'n') {
                        A06[2] = "QiAUsDkapNh1fTZA9J8Gsz0JLC17Ghy8";
                        ((InterstitialAdExtendedListener) anonymousClass26.A02()).onInterstitialActivityDestroyed();
                        if (this.A02.A04() == null) {
                            return;
                        }
                        i11 = message.what;
                        strArr = A06;
                        if (strArr[3].length() != strArr[7].length()) {
                            A06[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                            switch (i11) {
                                case AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS /* 3000 */:
                                    this.A02.A04().onRewardedAdCompleted();
                                    return;
                                case 3001:
                                    rewardedAdListenerA04 = this.A02.A04();
                                    if (A06[2].charAt(18) == 'n') {
                                        rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                        return;
                                    }
                                    String[] strArr4 = A06;
                                    strArr4[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                                    strArr4[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                                    rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                    return;
                                case 3002:
                                    this.A02.A04().onRewardedAdServerFailed();
                                    return;
                                default:
                                    return;
                            }
                        }
                    }
                } else {
                    if (this.A02.A04() == null) {
                        return;
                    }
                    i11 = message.what;
                    strArr = A06;
                    if (strArr[3].length() != strArr[7].length()) {
                        A06[4] = "YO9dGq40ZDljeOjTjHA4uB3VVKU9R56I";
                        switch (i11) {
                            case AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS /* 3000 */:
                                this.A02.A04().onRewardedAdCompleted();
                                return;
                            case 3001:
                                rewardedAdListenerA04 = this.A02.A04();
                                if (A06[2].charAt(18) == 'n') {
                                    rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                    return;
                                }
                                String[] strArr5 = A06;
                                strArr5[1] = "4ubpoteMIucGsWyTMsTtOH4ZOdBl9bHr";
                                strArr5[5] = "Xxx4qDjyhZoijrhiIp4u1mFMOEMCLZoL";
                                rewardedAdListenerA04.onRewardedAdServerSucceeded();
                                return;
                            case 3002:
                                this.A02.A04().onRewardedAdServerFailed();
                                return;
                            default:
                                return;
                        }
                    }
                }
                throw new RuntimeException();
        }
    }
}
