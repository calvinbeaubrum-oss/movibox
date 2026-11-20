package com.bytedance.adsdk.pFF.sc.pFF;

import android.graphics.Color;
import android.graphics.Paint;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class zY implements sc.InterfaceC0222sc {
    private final sc<Float, Float> ExN;
    private final sc<Float, Float> TRI;
    private final sc<Float, Float> We;
    private final sc<Integer, Integer> pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private boolean f26194qr = true;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final sc.InterfaceC0222sc f26195sc;
    private final sc<Float, Float> zY;

    public zY(sc.InterfaceC0222sc interfaceC0222sc, com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.ExN.WH wh2) {
        this.f26195sc = interfaceC0222sc;
        sc<Integer, Integer> scVarSc = wh2.sc().sc();
        this.pFF = scVarSc;
        scVarSc.sc(this);
        scVar.sc(scVarSc);
        sc<Float, Float> scVarSc2 = wh2.pFF().sc();
        this.zY = scVarSc2;
        scVarSc2.sc(this);
        scVar.sc(scVarSc2);
        sc<Float, Float> scVarSc3 = wh2.zY().sc();
        this.We = scVarSc3;
        scVarSc3.sc(this);
        scVar.sc(scVarSc3);
        sc<Float, Float> scVarSc4 = wh2.We().sc();
        this.ExN = scVarSc4;
        scVarSc4.sc(this);
        scVar.sc(scVarSc4);
        sc<Float, Float> scVarSc5 = wh2.ExN().sc();
        this.TRI = scVarSc5;
        scVarSc5.sc(this);
        scVar.sc(scVarSc5);
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        this.f26194qr = true;
        this.f26195sc.sc();
    }

    public void sc(Paint paint) {
        if (this.f26194qr) {
            this.f26194qr = false;
            double dFloatValue = ((double) this.We.qr().floatValue()) * 0.017453292519943295d;
            float fFloatValue = this.ExN.qr().floatValue();
            float fSin = ((float) Math.sin(dFloatValue)) * fFloatValue;
            float fCos = ((float) Math.cos(dFloatValue + 3.141592653589793d)) * fFloatValue;
            int iIntValue = this.pFF.qr().intValue();
            paint.setShadowLayer(this.TRI.qr().floatValue(), fSin, fCos, Color.argb(Math.round(this.zY.qr().floatValue()), Color.red(iIntValue), Color.green(iIntValue), Color.blue(iIntValue)));
        }
    }
}
