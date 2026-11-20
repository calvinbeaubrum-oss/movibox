package com.bytedance.adsdk.pFF.zY.pFF;

import android.graphics.Paint;
import com.bytedance.adsdk.pFF.sc.sc.YIK;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class wjp implements zY {
    private final com.bytedance.adsdk.pFF.zY.sc.We ExN;
    private final float Ol;
    private final pFF Qj;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF TRI;
    private final boolean WH;
    private final com.bytedance.adsdk.pFF.zY.sc.sc We;
    private final com.bytedance.adsdk.pFF.zY.sc.pFF pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final sc f26256qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26257sc;
    private final List<com.bytedance.adsdk.pFF.zY.sc.pFF> zY;

    /* JADX INFO: renamed from: com.bytedance.adsdk.pFF.zY.pFF.wjp$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] pFF;

        /* JADX INFO: renamed from: sc, reason: collision with root package name */
        static final /* synthetic */ int[] f26258sc;

        static {
            int[] iArr = new int[pFF.values().length];
            pFF = iArr;
            try {
                iArr[pFF.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                pFF[pFF.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                pFF[pFF.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[sc.values().length];
            f26258sc = iArr2;
            try {
                iArr2[sc.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26258sc[sc.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26258sc[sc.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum pFF {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join sc() {
            int i11 = AnonymousClass1.pFF[ordinal()];
            if (i11 == 1) {
                return Paint.Join.BEVEL;
            }
            if (i11 == 2) {
                return Paint.Join.MITER;
            }
            if (i11 != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public enum sc {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap sc() {
            int i11 = AnonymousClass1.f26258sc[ordinal()];
            if (i11 != 1) {
                return i11 != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public wjp(String str, com.bytedance.adsdk.pFF.zY.sc.pFF pff, List<com.bytedance.adsdk.pFF.zY.sc.pFF> list, com.bytedance.adsdk.pFF.zY.sc.sc scVar, com.bytedance.adsdk.pFF.zY.sc.We we2, com.bytedance.adsdk.pFF.zY.sc.pFF pff2, sc scVar2, pFF pff3, float f11, boolean z11) {
        this.f26257sc = str;
        this.pFF = pff;
        this.zY = list;
        this.We = scVar;
        this.ExN = we2;
        this.TRI = pff2;
        this.f26256qr = scVar2;
        this.Qj = pff3;
        this.Ol = f11;
        this.WH = z11;
    }

    public List<com.bytedance.adsdk.pFF.zY.sc.pFF> ExN() {
        return this.zY;
    }

    public float Ol() {
        return this.Ol;
    }

    public pFF Qj() {
        return this.Qj;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF TRI() {
        return this.pFF;
    }

    public boolean WH() {
        return this.WH;
    }

    public com.bytedance.adsdk.pFF.zY.sc.pFF We() {
        return this.TRI;
    }

    public com.bytedance.adsdk.pFF.zY.sc.sc pFF() {
        return this.We;
    }

    public sc qr() {
        return this.f26256qr;
    }

    @Override // com.bytedance.adsdk.pFF.zY.pFF.zY
    public com.bytedance.adsdk.pFF.sc.sc.zY sc(com.bytedance.adsdk.pFF.Ol ol2, com.bytedance.adsdk.pFF.qr qrVar, com.bytedance.adsdk.pFF.zY.zY.sc scVar) {
        return new YIK(ol2, scVar, this);
    }

    public String sc() {
        return this.f26257sc;
    }

    public com.bytedance.adsdk.pFF.zY.sc.We zY() {
        return this.ExN;
    }
}
