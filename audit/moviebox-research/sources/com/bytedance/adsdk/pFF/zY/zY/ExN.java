package com.bytedance.adsdk.pFF.zY.zY;

import com.bytedance.adsdk.pFF.zY.sc.Tf;
import com.bytedance.adsdk.pFF.zY.sc.UFX;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ExN {
    private final float BT;
    private final pFF Dl;
    private final sc ExN;
    private final com.bytedance.adsdk.pFF.ExN.WH FI;
    private final com.bytedance.adsdk.pFF.zY.pFF.sc JPJ;
    private final Tf Ol;
    private final List<com.bytedance.adsdk.pFF.zY.pFF.Qj> Qj;
    private final float Ql;
    private final float SR;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF Sfl;
    private final long TRI;
    private final int Tf;
    private final int UFX;
    private final int WH;
    private final long We;
    private final com.bytedance.adsdk.pFF.zY.sc.WH Xc;
    private final List<com.bytedance.adsdk.pFF.qr.sc<Float>> YIK;
    private final float dE;
    private final com.bytedance.adsdk.pFF.qr pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final String f26270qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final List<com.bytedance.adsdk.pFF.zY.pFF.zY> f26271sc;
    private final boolean uEA;
    private final UFX wjp;
    private final String zY;

    /* JADX INFO: compiled from: source.java */
    public enum pFF {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public ExN(List<com.bytedance.adsdk.pFF.zY.pFF.zY> list, com.bytedance.adsdk.pFF.qr qrVar, String str, long j11, sc scVar, long j12, String str2, List<com.bytedance.adsdk.pFF.zY.pFF.Qj> list2, Tf tf2, int i11, int i12, int i13, float f11, float f12, float f13, float f14, com.bytedance.adsdk.pFF.zY.sc.WH wh2, UFX ufx, List<com.bytedance.adsdk.pFF.qr.sc<Float>> list3, pFF pff, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, boolean z11, com.bytedance.adsdk.pFF.zY.pFF.sc scVar2, com.bytedance.adsdk.pFF.ExN.WH wh3) {
        this.f26271sc = list;
        this.pFF = qrVar;
        this.zY = str;
        this.We = j11;
        this.ExN = scVar;
        this.TRI = j12;
        this.f26270qr = str2;
        this.Qj = list2;
        this.Ol = tf2;
        this.WH = i11;
        this.UFX = i12;
        this.Tf = i13;
        this.Ql = f11;
        this.SR = f12;
        this.BT = f13;
        this.dE = f14;
        this.Xc = wh2;
        this.wjp = ufx;
        this.YIK = list3;
        this.Dl = pff;
        this.Sfl = pff2;
        this.uEA = z11;
        this.JPJ = scVar2;
        this.FI = wh3;
    }

    public Tf BT() {
        return this.Ol;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF Dl() {
        return this.Sfl;
    }

    public long ExN() {
        return this.We;
    }

    public com.bytedance.adsdk.pFF.ExN.WH FI() {
        return this.FI;
    }

    public com.bytedance.adsdk.pFF.zY.pFF.sc JPJ() {
        return this.JPJ;
    }

    public float Ol() {
        return this.dE;
    }

    public float Qj() {
        return this.BT;
    }

    public long Ql() {
        return this.TRI;
    }

    public List<com.bytedance.adsdk.pFF.zY.pFF.zY> SR() {
        return this.f26271sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.WH Sfl() {
        return this.Xc;
    }

    public String TRI() {
        return this.zY;
    }

    public pFF Tf() {
        return this.Dl;
    }

    public sc UFX() {
        return this.ExN;
    }

    public List<com.bytedance.adsdk.pFF.zY.pFF.Qj> WH() {
        return this.Qj;
    }

    public List<com.bytedance.adsdk.pFF.qr.sc<Float>> We() {
        return this.YIK;
    }

    public int Xc() {
        return this.UFX;
    }

    public UFX YIK() {
        return this.wjp;
    }

    public int dE() {
        return this.Tf;
    }

    public float pFF() {
        return this.Ql;
    }

    public String qr() {
        return this.f26270qr;
    }

    public com.bytedance.adsdk.pFF.qr sc() {
        return this.pFF;
    }

    public String sc(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(TRI());
        sb2.append("\n");
        ExN exNSc = this.pFF.sc(Ql());
        if (exNSc != null) {
            sb2.append("\t\tParents: ");
            sb2.append(exNSc.TRI());
            ExN exNSc2 = this.pFF.sc(exNSc.Ql());
            while (exNSc2 != null) {
                sb2.append("->");
                sb2.append(exNSc2.TRI());
                exNSc2 = this.pFF.sc(exNSc2.Ql());
            }
            sb2.append(str);
            sb2.append("\n");
        }
        if (!WH().isEmpty()) {
            sb2.append(str);
            sb2.append("\tMasks: ");
            sb2.append(WH().size());
            sb2.append("\n");
        }
        if (wjp() != 0 && Xc() != 0) {
            sb2.append(str);
            sb2.append("\tBackground: ");
            sb2.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(wjp()), Integer.valueOf(Xc()), Integer.valueOf(dE())));
        }
        if (!this.f26271sc.isEmpty()) {
            sb2.append(str);
            sb2.append("\tShapes:\n");
            for (com.bytedance.adsdk.pFF.zY.pFF.zY zYVar : this.f26271sc) {
                sb2.append(str);
                sb2.append("\t\t");
                sb2.append(zYVar);
                sb2.append("\n");
            }
        }
        return sb2.toString();
    }

    public String toString() {
        return sc("");
    }

    public boolean uEA() {
        return this.uEA;
    }

    public int wjp() {
        return this.WH;
    }

    public float zY() {
        return this.SR / this.pFF.Xc();
    }
}
