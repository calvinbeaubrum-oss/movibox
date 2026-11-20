package com.bytedance.adsdk.pFF.sc.sc;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Dl implements com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc, zY {
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> ExN;
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> TRI;
    private final com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc We;
    private final boolean pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> f26198qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26199sc;
    private final List<com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc> zY = new ArrayList();

    public Dl(com.bytedance.adsdk.pFF.zY.zY.sc scVar, com.bytedance.adsdk.pFF.zY.pFF.Sfl sfl) {
        this.f26199sc = sfl.sc();
        this.pFF = sfl.TRI();
        this.We = sfl.pFF();
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc = sfl.We().sc();
        this.ExN = scVarSc;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc2 = sfl.zY().sc();
        this.TRI = scVarSc2;
        com.bytedance.adsdk.pFF.sc.pFF.sc<Float, Float> scVarSc3 = sfl.ExN().sc();
        this.f26198qr = scVarSc3;
        scVar.sc(scVarSc);
        scVar.sc(scVarSc2);
        scVar.sc(scVarSc3);
        scVarSc.sc(this);
        scVarSc2.sc(this);
        scVarSc3.sc(this);
    }

    public com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> ExN() {
        return this.f26198qr;
    }

    public boolean TRI() {
        return this.pFF;
    }

    public com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> We() {
        return this.TRI;
    }

    public com.bytedance.adsdk.pFF.zY.pFF.Sfl.sc pFF() {
        return this.We;
    }

    @Override // com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc
    public void sc() {
        for (int i11 = 0; i11 < this.zY.size(); i11++) {
            this.zY.get(i11).sc();
        }
    }

    public void sc(com.bytedance.adsdk.pFF.sc.pFF.sc.InterfaceC0222sc interfaceC0222sc) {
        this.zY.add(interfaceC0222sc);
    }

    @Override // com.bytedance.adsdk.pFF.sc.sc.zY
    public void sc(List<zY> list, List<zY> list2) {
    }

    public com.bytedance.adsdk.pFF.sc.pFF.sc<?, Float> zY() {
        return this.ExN;
    }
}
