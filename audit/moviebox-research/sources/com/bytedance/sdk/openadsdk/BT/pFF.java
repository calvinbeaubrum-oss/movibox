package com.bytedance.sdk.openadsdk.BT;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class pFF {
    public static int ExN = 3;
    public static int We = 2;
    public static int pFF = 0;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f27058sc = -1;
    public static int zY = 1;
    private int TRI = f27058sc;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private long f27059qr = 0;
    private long Qj = 0;
    private final List<zY> Ol = new ArrayList();
    private long WH = 0;

    public void We(long j11) {
        int i11 = this.TRI;
        if (i11 == f27058sc || i11 != We) {
            return;
        }
        this.TRI = zY;
        this.Ol.add(new zY(this.WH, j11));
        this.WH = 0L;
    }

    public void pFF(long j11) {
        int i11;
        int i12 = this.TRI;
        if (i12 == f27058sc || i12 == (i11 = ExN)) {
            return;
        }
        this.TRI = i11;
        this.Qj = j11;
    }

    public int sc() {
        return this.TRI;
    }

    public long sc(long j11, long j12) {
        long j13;
        long j14;
        long jPFF;
        long j15 = this.Qj;
        if (j15 != 0 && j11 > j15) {
            return 0L;
        }
        int i11 = 0;
        for (zY zYVar : this.Ol) {
            if (zYVar.pFF() > j11) {
                if (j11 < zYVar.sc()) {
                    j14 = i11;
                    jPFF = zYVar.pFF() - zYVar.sc();
                } else {
                    j14 = i11;
                    jPFF = zYVar.pFF() - j11;
                }
                i11 = (int) (j14 + jPFF);
            }
        }
        long j16 = this.f27059qr;
        if (j16 < j11) {
            long j17 = this.WH;
            if (j17 == 0) {
                j17 = this.Qj;
                if (j17 == 0) {
                    j13 = j12 - j11;
                }
            } else if (j17 <= j11) {
                return 0L;
            }
            return (j17 - j11) - ((long) i11);
        }
        long j18 = this.WH;
        if (j18 == 0) {
            j18 = this.Qj;
            if (j18 == 0) {
                j13 = j12 - j16;
            }
        } else if (j18 <= j16) {
            return 0L;
        }
        return (j18 - j16) - ((long) i11);
        return j13 - ((long) i11);
    }

    public void sc(long j11) {
        this.TRI = pFF;
        this.f27059qr = j11;
    }

    public void zY(long j11) {
        int i11;
        int i12 = this.TRI;
        if (i12 == f27058sc || i12 == (i11 = We) || i12 == ExN) {
            return;
        }
        this.TRI = i11;
        this.WH = j11;
    }
}
