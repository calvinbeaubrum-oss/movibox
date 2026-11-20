package com.facebook.ads.redexgen.uinode;

import android.media.AudioTrack;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1206Ar {
    public static String[] A06 = {"tMW2fkMpy5HihKk0yN3j3FySApib3JSJ", "DmNw9hS4nxXBj6Mr2INd4L8q1xMEyvKq", "0eqkaL3Dsezuu4pOs0MDPfwpckzWpND4", "49OOFjFtCxl3f3ujLPMCOchIYt8uEQEa", "MWNNllbG7VNHRaURq2pyYfck8pAxQtjw", "ldwZ0eJIezAamtWPjZLM2iroOhc1OYkS", "11ihmkQKk", "Tg3NlfrAQ4uSsG9"};
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public final C1204Ap A05;

    public C1206Ar(AudioTrack audioTrack) {
        if (IF.A02 >= 19) {
            this.A05 = new C1204Ap(audioTrack);
            A05();
        } else {
            this.A05 = null;
            A00(3);
        }
    }

    private void A00(int i11) {
        this.A00 = i11;
        switch (i11) {
            case 0:
                this.A03 = 0L;
                this.A01 = -1L;
                long jNanoTime = System.nanoTime();
                if (A06[6].length() != 9) {
                    throw new RuntimeException();
                }
                A06[6] = "I3kIT2QQI";
                this.A02 = jNanoTime / 1000;
                this.A04 = 5000L;
                return;
            case 1:
                this.A04 = 5000L;
                return;
            case 2:
            case 3:
                this.A04 = 10000000L;
                return;
            case 4:
                this.A04 = 500000L;
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final long A01() {
        C1204Ap c1204Ap = this.A05;
        if (c1204Ap != null) {
            return c1204Ap.A00();
        }
        return -1L;
    }

    public final long A02() {
        C1204Ap c1204Ap = this.A05;
        return c1204Ap != null ? c1204Ap.A01() : C.TIME_UNSET;
    }

    public final void A03() {
        if (this.A00 == 4) {
            A05();
        }
    }

    public final void A04() {
        A00(4);
    }

    public final void A05() {
        if (this.A05 != null) {
            A00(0);
        }
    }

    public final boolean A06() {
        int i11 = this.A00;
        return i11 == 1 || i11 == 2;
    }

    public final boolean A07() {
        return this.A00 == 2;
    }

    public final boolean A08(long j11) {
        C1204Ap c1204Ap = this.A05;
        if (c1204Ap == null || j11 - this.A03 < this.A04) {
            return false;
        }
        this.A03 = j11;
        boolean zA02 = c1204Ap.A02();
        switch (this.A00) {
            case 0:
                if (!zA02) {
                    if (j11 - this.A02 <= 500000) {
                        return zA02;
                    }
                    A00(3);
                    return zA02;
                }
                if (this.A05.A01() < this.A02) {
                    return false;
                }
                this.A01 = this.A05.A00();
                A00(1);
                return zA02;
            case 1:
                if (!zA02) {
                    A05();
                    return zA02;
                }
                if (this.A05.A00() <= this.A01) {
                    return zA02;
                }
                A00(2);
                return zA02;
            case 2:
                if (zA02) {
                    return zA02;
                }
                A05();
                return zA02;
            case 3:
                if (!zA02) {
                    return zA02;
                }
                A05();
                return zA02;
            case 4:
                return zA02;
            default:
                throw new IllegalStateException();
        }
    }
}
