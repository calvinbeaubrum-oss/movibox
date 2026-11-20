package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class F1 {
    public static String[] A04 = {"XHo", "ubtbrXFiKU0aMD9WZdFFXMvL5SNCKhBD", "k9cdhOGQS1oEdCdR21VeueSE4nGT", "BZNadIlHUT8LbNbZ8qdMYncW4fXCJJFh", "22DNreJXUwzG5I9t9ymbmjKefjfUTWMr", "OkM0GcBH5aVjMNZagw1JqhxPR8ijdnHI", "ik3Hzc9el9B7KCBCFVHKN4tCPL2D2JGF", "0FgMGgJ2UsG2ZcXwt2m5OtQLezKmVI44"};
    public final int A00;
    public final C1291Eo A01;
    public final long A02;
    public final CopyOnWriteArrayList<F0> A03;

    public F1() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public F1(CopyOnWriteArrayList<F0> copyOnWriteArrayList, int i11, C1291Eo c1291Eo, long j11) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i11;
        this.A01 = c1291Eo;
        this.A02 = j11;
    }

    private long A00(long j11) {
        long jA01 = C9W.A01(j11);
        return jA01 == C.TIME_UNSET ? C.TIME_UNSET : this.A02 + jA01;
    }

    private void A01(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    public final F1 A02(int i11, C1291Eo c1291Eo, long j11) {
        return new F1(this.A03, i11, c1291Eo, j11);
    }

    public final void A03() {
        AbstractC1351Ha.A04(this.A01 != null);
        for (F0 f11 : this.A03) {
            A01(f11.A00, new RunnableC1294Er(this, f11.A01));
        }
    }

    public final void A04() {
        AbstractC1351Ha.A04(this.A01 != null);
        String[] strArr = A04;
        if (strArr[4].charAt(4) != strArr[1].charAt(4)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[4] = "rYA4ryMG3XFm73cnSWA4HWNW3HUxv7KC";
        strArr2[1] = "1YJ2rSWw51hvYcz1kikUBhJeKIWd76IZ";
        for (F0 f11 : this.A03) {
            A01(f11.A00, new RunnableC1295Es(this, f11.A01));
        }
    }

    public final void A05() {
        AbstractC1351Ha.A04(this.A01 != null);
        for (F0 f11 : this.A03) {
            A01(f11.A00, new RunnableC1300Ex(this, f11.A01));
        }
    }

    public final void A06(int i11, Format format, int i12, Object obj, long j11) {
        A0C(new F3(1, i11, format, i12, obj, A00(j11), C.TIME_UNSET));
    }

    public final void A07(Handler handler, F4 f11) {
        AbstractC1351Ha.A03((handler == null || f11 == null) ? false : true);
        this.A03.add(new F0(handler, f11));
    }

    public final void A08(F2 f11, F3 f12) {
        for (F0 f13 : this.A03) {
            A01(f13.A00, new RunnableC1298Ev(this, f13.A01, f11, f12));
        }
    }

    public final void A09(F2 f11, F3 f12) {
        for (F0 f13 : this.A03) {
            A01(f13.A00, new RunnableC1297Eu(this, f13.A01, f11, f12));
        }
    }

    public final void A0A(F2 f11, F3 f12) {
        for (F0 f13 : this.A03) {
            A01(f13.A00, new RunnableC1296Et(this, f13.A01, f11, f12));
        }
    }

    public final void A0B(F2 f11, F3 f12, IOException iOException, boolean z11) {
        for (F0 f13 : this.A03) {
            A01(f13.A00, new RunnableC1299Ew(this, f13.A01, f11, f12, iOException, z11));
        }
    }

    public final void A0C(F3 f11) {
        for (F0 f12 : this.A03) {
            A01(f12.A00, new RunnableC1302Ez(this, f12.A01, f11));
        }
    }

    public final void A0D(F4 f11) {
        for (F0 f12 : this.A03) {
            if (f12.A01 == f11) {
                this.A03.remove(f12);
            }
        }
    }

    public final void A0E(C1350Gy c1350Gy, int i11, int i12, Format format, int i13, Object obj, long j11, long j12, long j13) {
        A0A(new F2(c1350Gy, j13, 0L, 0L), new F3(i11, i12, format, i13, obj, A00(j11), A00(j12)));
    }

    public final void A0F(C1350Gy c1350Gy, int i11, int i12, Format format, int i13, Object obj, long j11, long j12, long j13, long j14, long j15) {
        A08(new F2(c1350Gy, j13, j14, j15), new F3(i11, i12, format, i13, obj, A00(j11), A00(j12)));
    }

    public final void A0G(C1350Gy c1350Gy, int i11, int i12, Format format, int i13, Object obj, long j11, long j12, long j13, long j14, long j15) {
        A09(new F2(c1350Gy, j13, j14, j15), new F3(i11, i12, format, i13, obj, A00(j11), A00(j12)));
    }

    public final void A0H(C1350Gy c1350Gy, int i11, int i12, Format format, int i13, Object obj, long j11, long j12, long j13, long j14, long j15, IOException iOException, boolean z11) {
        A0B(new F2(c1350Gy, j13, j14, j15), new F3(i11, i12, format, i13, obj, A00(j11), A00(j12)), iOException, z11);
    }
}
