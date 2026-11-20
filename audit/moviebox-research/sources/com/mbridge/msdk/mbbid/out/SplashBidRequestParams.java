package com.mbridge.msdk.mbbid.out;

import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.z;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class SplashBidRequestParams extends BannerBidRequestParams {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f45450b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f45451c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f45452d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f45453a;

    public SplashBidRequestParams(String str, String str2) {
        this(str, str2, "");
    }

    public SplashBidRequestParams(String str, String str2, String str3) {
        this(str, str2, str3, false, f45450b, f45452d, f45451c);
    }

    public SplashBidRequestParams(String str, String str2, String str3, boolean z11, int i11, int i12, int i13) {
        super(str, str2, str3, 0, 0);
        this.f45453a = false;
        f45450b = i11;
        int i14 = z.i(c.m().c());
        int iG = z.g(c.m().c());
        int i15 = f45450b;
        if (i15 == 1) {
            if (iG > i13 * 4) {
                setHeight(iG - i13);
                setWidth(i14);
            } else {
                setHeight(0);
                setWidth(0);
            }
        } else if (i15 == 2) {
            if (i14 > i12 * 4) {
                setWidth(i14 - i12);
                setHeight(iG);
            } else {
                setHeight(0);
                setWidth(0);
            }
        }
        this.f45453a = z11;
    }

    public SplashBidRequestParams(String str, String str2, boolean z11, int i11, int i12, int i13) {
        this(str, str2, "", z11, i11, i13, i12);
    }

    public final boolean a() {
        return this.f45453a;
    }

    public int getOrientation() {
        return f45450b;
    }
}
