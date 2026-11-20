package com.applovin.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.WindowManager;
import com.applovin.sdk.AppLovinSdkUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class yg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f24667a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f24668b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24669c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f24670d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f24671e;

    public yg(Activity activity) {
        this.f24667a = activity;
        int iC = yp.c(activity);
        this.f24669c = iC;
        boolean zIsTablet = AppLovinSdkUtils.isTablet(activity);
        this.f24670d = zIsTablet;
        this.f24668b = a(iC, zIsTablet);
        this.f24671e = zIsTablet && 2 == a(activity);
    }

    private int a(int i11, boolean z11) {
        if (z11 && this.f24671e) {
            if (i11 == 0) {
                return 0;
            }
            if (i11 == 1) {
                return 9;
            }
            if (i11 == 2) {
                return 8;
            }
            return i11 == 3 ? 1 : -1;
        }
        if (i11 == 0) {
            return 1;
        }
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 9;
        }
        return i11 == 3 ? 8 : -1;
    }

    private static int a(Context context) {
        Configuration configuration = context.getResources().getConfiguration();
        int rotation = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
        return (((rotation == 0 || rotation == 2) && configuration.orientation == 2) || ((rotation == 1 || rotation == 3) && configuration.orientation == 1)) ? 2 : 1;
    }

    private void a(int i11) {
        try {
            this.f24667a.setRequestedOrientation(i11);
        } catch (Throwable unused) {
        }
    }

    private void a(com.applovin.impl.sdk.ad.b.c cVar) {
        if (cVar != com.applovin.impl.sdk.ad.b.c.ACTIVITY_PORTRAIT) {
            if (cVar == com.applovin.impl.sdk.ad.b.c.ACTIVITY_LANDSCAPE) {
                if (this.f24670d && this.f24671e) {
                    int i11 = this.f24669c;
                    if (i11 == 0 || i11 == 2) {
                        a(i11 != 2 ? 0 : 8);
                        return;
                    } else {
                        a(0);
                        return;
                    }
                }
                int i12 = this.f24669c;
                if (i12 == 1 || i12 == 3) {
                    a(i12 == 1 ? 0 : 8);
                    return;
                } else {
                    a(0);
                    return;
                }
            }
            return;
        }
        if (!this.f24670d || !this.f24671e) {
            int i13 = this.f24669c;
            if (i13 == 0 || i13 == 2) {
                a(i13 != 0 ? 9 : 1);
                return;
            } else {
                a(1);
                return;
            }
        }
        int i14 = this.f24669c;
        if (i14 != 1 && i14 != 3) {
            a(1);
        } else if (i14 == 1) {
            a(9);
        } else {
            a(1);
        }
    }

    public void a(com.applovin.impl.sdk.ad.b bVar) {
        int i11;
        if (!bVar.D0() || (i11 = this.f24668b) == -1) {
            a(bVar.d0());
        } else {
            a(i11);
        }
    }
}
