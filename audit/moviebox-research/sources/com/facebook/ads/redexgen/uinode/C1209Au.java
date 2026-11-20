package com.facebook.ads.redexgen.uinode;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Au, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1209Au {
    public static byte[] A0P;
    public static String[] A0Q = {"G0ejmsNLWo5N4HwPMLJOyhcWTLvm5k", "AaVAi8kEbPSTq7WMPq", "3SFwMFVKqfYZc9yidXjkKt9eYi", "MpavoNzourXMB6MEjk2fzdRtD4ZxlK4T", "tgtkP63ogxvavW2iBkIKDzfLLaZpZCzK", "ybOdqEkHneyM4wZj2LwFYBNLYP9L294", "eNRXQ28nuUhO04KATDB8SwCNKP", "apyaz1fP5pXVrlGks8RRBsGavNttMFUQ"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public AudioTrack A0H;
    public C1206Ar A0I;
    public Method A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public final InterfaceC1207As A0N;
    public final long[] A0O;

    static {
        A06();
    }

    public C1209Au(InterfaceC1207As interfaceC1207As) {
        this.A0N = (InterfaceC1207As) AbstractC1351Ha.A01(interfaceC1207As);
        if (IF.A02 >= 18) {
            try {
                this.A0J = AudioTrack.class.getMethod(A03(0, 10, 75), null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.A0O = new long[10];
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0091  */
    /* JADX WARN: Code duplicated, block: B:29:0x0094  */
    /* JADX WARN: Code duplicated, block: B:31:0x009a  */
    private long A00() {
        if (this.A0G != C.TIME_UNSET) {
            return Math.min(this.A06, this.A0F + ((((long) this.A03) * ((SystemClock.elapsedRealtime() * 1000) - this.A0G)) / 1000000));
        }
        int playState = this.A0H.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = ((long) this.A0H.getPlaybackHeadPosition()) & 4294967295L;
        if (this.A0M) {
            if (playState == 2) {
                String[] strArr = A0Q;
                if (strArr[7].charAt(23) == strArr[3].charAt(23)) {
                    throw new RuntimeException();
                }
                A0Q[1] = "2Rrhrvg7XFDDHkaxdizPj4VES";
                if (playbackHeadPosition == 0) {
                    this.A0C = this.A0A;
                }
            }
            playbackHeadPosition += this.A0C;
        }
        if (IF.A02 <= 28) {
            if (playbackHeadPosition == 0) {
                long j11 = this.A0A;
                if (A0Q[1].length() != 9) {
                    A0Q[5] = "5rZ1QvooVelNPm3umI";
                    if (j11 > 0) {
                        if (playState == 3) {
                            if (this.A07 == C.TIME_UNSET) {
                                this.A07 = SystemClock.elapsedRealtime();
                            }
                            return this.A0A;
                        }
                    }
                } else if (j11 > 0) {
                    if (playState == 3) {
                        if (this.A07 == C.TIME_UNSET) {
                            this.A07 = SystemClock.elapsedRealtime();
                        }
                        return this.A0A;
                    }
                }
            }
            this.A07 = C.TIME_UNSET;
        }
        if (this.A0A > playbackHeadPosition) {
            this.A0D++;
        }
        this.A0A = playbackHeadPosition;
        return (this.A0D << 32) + playbackHeadPosition;
    }

    private long A01() {
        return A02(A00());
    }

    private long A02(long j11) {
        return (1000000 * j11) / ((long) this.A03);
    }

    public static String A03(int i11, int i12, int i13) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0P, i11, i11 + i12);
        for (int i14 = 0; i14 < bArrCopyOfRange.length; i14++) {
            bArrCopyOfRange[i14] = (byte) ((bArrCopyOfRange[i14] - i13) - 126);
        }
        return new String(bArrCopyOfRange);
    }

    private void A04() {
        long jA01 = A01();
        if (jA01 == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.A09 >= 30000) {
            long[] jArr = this.A0O;
            int i11 = this.A01;
            jArr[i11] = jA01 - jNanoTime;
            this.A01 = (i11 + 1) % 10;
            int i12 = this.A04;
            if (i12 < 10) {
                this.A04 = i12 + 1;
            }
            this.A09 = jNanoTime;
            this.A0E = 0L;
            int i13 = 0;
            while (true) {
                int i14 = this.A04;
                if (i13 >= i14) {
                    break;
                }
                this.A0E += this.A0O[i13] / ((long) i14);
                i13++;
            }
        }
        if (this.A0M) {
            return;
        }
        A08(jNanoTime, jA01);
        A07(jNanoTime);
    }

    private void A05() {
        this.A0E = 0L;
        this.A04 = 0;
        this.A01 = 0;
        this.A09 = 0L;
    }

    public static void A06() {
        A0P = new byte[]{48, 46, 61, Ascii.NAK, 42, 61, 46, 55, 44, 66};
    }

    private void A07(long j11) {
        if (this.A0L) {
            Method method = this.A0J;
            if (A0Q[1].length() == 9) {
                throw new RuntimeException();
            }
            A0Q[5] = "5gTCJ";
            if (method == null || j11 - this.A08 < 500000) {
                return;
            }
            try {
                long jIntValue = (((long) ((Integer) method.invoke(this.A0H, null)).intValue()) * 1000) - this.A05;
                this.A0B = jIntValue;
                long jMax = Math.max(jIntValue, 0L);
                this.A0B = jMax;
                if (jMax > 5000000) {
                    this.A0N.ABv(jMax);
                    this.A0B = 0L;
                }
            } catch (Exception unused) {
                this.A0J = null;
            }
            this.A08 = j11;
        }
    }

    private void A08(long j11, long j12) {
        if (this.A0I.A08(j11)) {
            long jA02 = this.A0I.A02();
            long jA01 = this.A0I.A01();
            if (Math.abs(jA02 - j11) > 5000000) {
                this.A0N.ADH(jA01, jA02, j11, j12);
                this.A0I.A04();
            } else if (Math.abs(A02(jA01) - j12) <= 5000000) {
                this.A0I.A03();
            } else {
                this.A0N.ACi(jA01, jA02, j11, j12);
                this.A0I.A04();
            }
        }
    }

    private boolean A09() {
        return this.A0M && this.A0H.getPlayState() == 2 && A00() == 0;
    }

    public static boolean A0A(int i11) {
        if (IF.A02 < 23) {
            if (i11 != 5) {
                String[] strArr = A0Q;
                if (strArr[6].length() != strArr[2].length()) {
                    throw new RuntimeException();
                }
                A0Q[0] = "NO";
                if (i11 == 6) {
                }
            }
            return true;
        }
        return false;
    }

    public final int A0B(long j11) {
        return this.A00 - ((int) (j11 - (A00() * ((long) this.A02))));
    }

    public final long A0C(boolean z11) {
        if (this.A0H.getPlayState() == 3) {
            A04();
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (!this.A0I.A06()) {
            long jA01 = this.A04 == 0 ? A01() : this.A0E + jNanoTime;
            return !z11 ? jA01 - this.A0B : jA01;
        }
        long jA02 = A02(this.A0I.A01());
        boolean zA07 = this.A0I.A07();
        if (A0Q[1].length() == 9) {
            throw new RuntimeException();
        }
        String[] strArr = A0Q;
        strArr[7] = "B2EPmPjaxRfTTctNgZbFUDggQYGnhm7g";
        strArr[3] = "gdL6KIe4ggUqKImq5hrR6J8T2bfxhE0p";
        if (!zA07) {
            return jA02;
        }
        C1206Ar c1206Ar = this.A0I;
        String[] strArr2 = A0Q;
        if (strArr2[6].length() != strArr2[2].length()) {
            return jA02 + (jNanoTime - c1206Ar.A02());
        }
        A0Q[5] = "zkTTFu0HqLBb6JIYxZc4CSGv3";
        return jA02 + (jNanoTime - c1206Ar.A02());
    }

    public final void A0D() {
        A05();
        this.A0H = null;
        this.A0I = null;
    }

    public final void A0E() {
        this.A0I.A05();
    }

    public final void A0F(long j11) {
        this.A0F = A00();
        this.A0G = SystemClock.elapsedRealtime() * 1000;
        this.A06 = j11;
    }

    public final void A0G(AudioTrack audioTrack, int i11, int i12, int i13) {
        this.A0H = audioTrack;
        this.A02 = i12;
        this.A00 = i13;
        this.A0I = new C1206Ar(audioTrack);
        this.A03 = audioTrack.getSampleRate();
        this.A0M = A0A(i11);
        boolean zA0c = IF.A0c(i11);
        this.A0L = zA0c;
        this.A05 = zA0c ? A02(i13 / i12) : -9223372036854775807L;
        this.A0A = 0L;
        this.A0D = 0L;
        this.A0C = 0L;
        this.A0K = false;
        this.A0G = C.TIME_UNSET;
        this.A07 = C.TIME_UNSET;
        this.A0B = 0L;
    }

    public final boolean A0H() {
        return this.A0H.getPlayState() == 3;
    }

    public final boolean A0I() {
        A05();
        if (this.A0G != C.TIME_UNSET) {
            return false;
        }
        this.A0I.A05();
        return true;
    }

    public final boolean A0J(long j11) {
        return j11 > A00() || A09();
    }

    public final boolean A0K(long j11) {
        return this.A07 != C.TIME_UNSET && j11 > 0 && SystemClock.elapsedRealtime() - this.A07 >= 200;
    }

    public final boolean A0L(long j11) {
        InterfaceC1207As interfaceC1207As;
        int playState = this.A0H.getPlayState();
        if (this.A0M) {
            if (playState == 2) {
                this.A0K = false;
                return false;
            }
            if (playState == 1 && A00() == 0) {
                return false;
            }
        }
        boolean z11 = this.A0K;
        boolean zA0J = A0J(j11);
        this.A0K = zA0J;
        if (z11 && !zA0J && playState != 1 && (interfaceC1207As = this.A0N) != null) {
            interfaceC1207As.ADQ(this.A00, C9W.A01(this.A05));
        }
        return true;
    }
}
