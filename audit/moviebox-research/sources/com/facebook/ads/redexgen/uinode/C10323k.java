package com.facebook.ads.redexgen.uinode;

import android.os.Build;
import android.view.WindowInsets;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.3k, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C10323k {
    public static String[] A01 = {"el7YtyQobuGYp8qUnEWwGAo9eb5IMR8f", "BjlmtcQqBka41jhChDLZKaESgBphWA9m", "aKAY7r1GVGPP18xn5ioe", "SajdHZC8", "nRs3vifuwuv", "vQYmc1GWKj3CI1v3wMvKFH0VmcpB3A8S", "tuFyi1rHy9z46G0g3HP9J8Pe4WgIo7s9", "jDUjvWDGqsgivCcWfJbzlnhujFfNRoy6"};
    public final Object A00;

    public C10323k(Object obj) {
        this.A00 = obj;
    }

    public static C10323k A00(Object obj) {
        if (obj == null) {
            return null;
        }
        return new C10323k(obj);
    }

    public static Object A01(C10323k c10323k) {
        if (c10323k == null) {
            return null;
        }
        return c10323k.A00;
    }

    public final int A02() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetBottom();
        }
        return 0;
    }

    public final int A03() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetLeft();
        }
        return 0;
    }

    public final int A04() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetRight();
        }
        return 0;
    }

    public final int A05() {
        if (Build.VERSION.SDK_INT >= 20) {
            return ((WindowInsets) this.A00).getSystemWindowInsetTop();
        }
        return 0;
    }

    public final C10323k A06(int i11, int i12, int i13, int i14) {
        if (Build.VERSION.SDK_INT >= 20) {
            return new C10323k(((WindowInsets) this.A00).replaceSystemWindowInsets(i11, i12, i13, i14));
        }
        return null;
    }

    public final boolean A07() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        Object obj = this.A00;
        if (A01[7].charAt(25) != 'F') {
            throw new RuntimeException();
        }
        A01[7] = "MrGsAgnRdViYEdRwgZNSAOYKXFurzaLs";
        return ((WindowInsets) obj).isConsumed();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C10323k c10323k = (C10323k) obj;
        Object obj2 = this.A00;
        if (obj2 == null) {
            return c10323k.A00 == null;
        }
        return obj2.equals(c10323k.A00);
    }

    public final int hashCode() {
        Object obj = this.A00;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
