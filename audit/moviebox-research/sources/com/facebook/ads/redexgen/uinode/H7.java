package com.facebook.ads.redexgen.uinode;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.facebook.ads.redexgen.uinode.H8;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network.dex */
public final class H7<T extends H8> extends Handler implements Runnable {
    public static byte[] A0A;
    public int A00;
    public H6<T> A01;
    public IOException A02;
    public final int A03;
    public final long A04;
    public final T A05;
    public volatile Thread A06;
    public volatile boolean A07;
    public volatile boolean A08;
    public final /* synthetic */ C1723Vq A09;

    static {
        A04();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public H7(C1723Vq c1723Vq, Looper looper, T t11, H6<T> h11, int i11, long j11) {
        super(looper);
        this.A09 = c1723Vq;
        this.A05 = t11;
        this.A01 = h11;
        this.A03 = i11;
        this.A04 = j11;
    }

    private long A00() {
        return Math.min((this.A00 - 1) * 1000, 5000);
    }

    public static String A01(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 25);
        }
        return new String(bArrCopyOfRange);
    }

    private void A02() {
        this.A02 = null;
        this.A09.A02.execute(this.A09.A00);
    }

    private void A03() {
        this.A09.A00 = null;
    }

    public static void A04() {
        A0A = new byte[]{-124, 119, -85, -76, -69, -122, -70, -35, -49, -46, -62, -49, -31, -39, -80, -42, -43, -80, -57, -82, -58, -50, -48, -45, -38, -127, -58, -45, -45, -48, -45, -127, -51, -48, -62, -59, -54, -49, -56, -127, -44, -43, -45, -58, -62, -50, -29, -4, -13, 6, -2, -13, -15, 2, -13, -14, -82, -13, 0, 0, -3, 0, -82, -6, -3, -17, -14, -9, -4, -11, -82, 1, 2, 0, -13, -17, -5, 118, -113, -122, -103, -111, -122, -124, -107, -122, -123, 65, -122, -103, -124, -122, -111, -107, -118, -112, -113, 65, -119, -126, -113, -123, -115, -118, -113, -120, 65, -115, -112, -126, -123, 65, -124, -112, -114, -111, -115, -122, -107, -122, -123, 120, -111, -120, -101, -109, -120, -122, -105, -120, -121, 67, -120, -101, -122, -120, -109, -105, -116, -110, -111, 67, -113, -110, -124, -121, -116, -111, -118, 67, -106, -105, -107, -120, -124, -112, -4, -1, -15, -12, -54, -52, -13, -4, 3, -50};
    }

    public final void A05(int i11) throws IOException {
        IOException iOException = this.A02;
        if (iOException != null && this.A00 > i11) {
            throw iOException;
        }
    }

    public final void A06(long j11) {
        AbstractC1351Ha.A04(this.A09.A00 == null);
        this.A09.A00 = this;
        if (j11 > 0) {
            sendEmptyMessageDelayed(0, j11);
        } else {
            A02();
        }
    }

    public final void A07(boolean z11) {
        this.A08 = z11;
        this.A02 = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z11) {
                sendEmptyMessage(1);
            }
        } else {
            this.A07 = true;
            this.A05.A4A();
            if (this.A06 != null) {
                this.A06.interrupt();
            }
        }
        if (z11) {
            A03();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A01.ABz(this.A05, jElapsedRealtime, jElapsedRealtime - this.A04, true);
            this.A01 = null;
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A08) {
                return;
            }
            if (message.what == 0) {
                A02();
                return;
            }
            if (message.what == 4) {
                throw ((Error) message.obj);
            }
            A03();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j11 = jElapsedRealtime - this.A04;
            if (this.A07) {
                this.A01.ABz(this.A05, jElapsedRealtime, j11, false);
                return;
            }
            switch (message.what) {
                case 1:
                    this.A01.ABz(this.A05, jElapsedRealtime, j11, false);
                    return;
                case 2:
                    try {
                        this.A01.AC1(this.A05, jElapsedRealtime, j11);
                        return;
                    } catch (RuntimeException e11) {
                        Log.e(A01(6, 8, 85), A01(77, 44, 8), e11);
                        this.A09.A01 = new HC(e11);
                        return;
                    }
                case 3:
                    IOException iOException = (IOException) message.obj;
                    this.A02 = iOException;
                    int iAC2 = this.A01.AC2(this.A05, jElapsedRealtime, j11, iOException);
                    if (iAC2 == 3) {
                        this.A09.A01 = this.A02;
                        return;
                    } else {
                        if (iAC2 != 2) {
                            int i11 = 1;
                            if (iAC2 != 1) {
                                i11 = 1 + this.A00;
                            }
                            this.A00 = i11;
                            A06(A00());
                            return;
                        }
                        return;
                    }
                default:
                    return;
            }
            KL.A00(th, this);
        } catch (Throwable th2) {
            KL.A00(th2, this);
        }
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strA01 = A01(6, 8, 85);
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            this.A06 = Thread.currentThread();
                            if (!this.A07) {
                                IC.A02(A01(156, 10, 119) + this.A05.getClass().getSimpleName() + A01(0, 6, 47));
                                try {
                                    this.A05.A9P();
                                    IC.A00();
                                } catch (Throwable th2) {
                                    IC.A00();
                                    throw th2;
                                }
                            }
                            if (this.A08) {
                                return;
                            }
                            sendEmptyMessage(2);
                        } catch (IOException e11) {
                            if (this.A08) {
                                return;
                            }
                            obtainMessage(3, e11).sendToTarget();
                        }
                    } catch (OutOfMemoryError e12) {
                        Log.e(strA01, A01(14, 32, 72), e12);
                        if (this.A08) {
                            return;
                        }
                        obtainMessage(3, new HC(e12)).sendToTarget();
                    }
                } catch (Exception e13) {
                    Log.e(strA01, A01(121, 35, 10), e13);
                    if (this.A08) {
                        return;
                    }
                    obtainMessage(3, new HC(e13)).sendToTarget();
                }
            } catch (Error e14) {
                Log.e(strA01, A01(46, 31, 117), e14);
                if (!this.A08) {
                    obtainMessage(4, e14).sendToTarget();
                }
                throw e14;
            } catch (InterruptedException unused) {
                AbstractC1351Ha.A04(this.A07);
                if (this.A08) {
                    return;
                }
                sendEmptyMessage(2);
            }
        } catch (Throwable th3) {
            KL.A00(th3, this);
        }
    }
}
