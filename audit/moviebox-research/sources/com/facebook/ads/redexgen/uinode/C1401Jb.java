package com.facebook.ads.redexgen.uinode;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Jb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1401Jb {
    public final AdErrorType A00;
    public final String A01;

    public C1401Jb(int i11, String str) {
        this(AdErrorType.adErrorTypeFromCode(i11), str);
    }

    public C1401Jb(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C1401Jb A00(AdErrorType adErrorType) {
        return new C1401Jb(adErrorType, (String) null);
    }

    public static C1401Jb A01(AdErrorType adErrorType, String str) {
        return new C1401Jb(adErrorType, str);
    }

    public static C1401Jb A02(C1402Jc c1402Jc) {
        return new C1401Jb(c1402Jc.A00(), c1402Jc.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
