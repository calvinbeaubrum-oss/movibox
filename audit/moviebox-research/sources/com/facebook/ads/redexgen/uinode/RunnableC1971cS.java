package com.facebook.ads.redexgen.uinode;

import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.cS, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class RunnableC1971cS implements Runnable {
    public static String[] A03 = {"dpzU5luUOUHn3PWLQSytUkpXF5uf76Gb", "OIXAlbgxv8lxL6Dw2D3vNQ6xborOE6Ab", "016lHYH9eT2TKwrcc2bnFjN8P1e", "T3DTHKpc", "xtrZuPGJxZVhMxMYehMPzz7RP9cUVZ", "GHqsJR2NBv7dmhvhUyJ2cgs96CqPd5ri", "JC4MWKMVQLy9m", "a7WpfUfSeSK3qdCMwJm40hXORQEICpVd"};
    public final /* synthetic */ int A00;
    public final /* synthetic */ C1970cR A01;
    public final /* synthetic */ Exception A02;

    public RunnableC1971cS(C1970cR c1970cR, int i11, Exception exc) {
        this.A01 = c1970cR;
        this.A00 = i11;
        this.A02 = exc;
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x004e */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A01.A01) {
                C1970cR c1970cR = this.A01;
                c1970cR.A04(c1970cR.A05.AAY());
                this.A01.A04.postDelayed(this.A01.A09, this.A00);
                return;
            }
            return;
        } catch (Exception e11) {
            StackTraceElement[] stackTrace = e11.getStackTrace();
            StackTraceElement[] stackTrace2 = this.A02.getStackTrace();
            StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) Arrays.copyOf(stackTrace, stackTrace.length + stackTrace2.length);
            System.arraycopy(stackTrace2, 0, stackTraceElementArr, stackTrace.length, stackTrace2.length);
            e11.setStackTrace(stackTraceElementArr);
            throw e11;
        }
        if (A03[4].length() == 16) {
            throw new RuntimeException();
        }
        A03[3] = "b6O1Nd";
        KL.A00(th, this);
    }
}
