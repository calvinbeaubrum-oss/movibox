package com.bytedance.adsdk.ugeno.Ol.ExN;

import android.content.Context;
import android.graphics.Color;
import com.bytedance.adsdk.ugeno.pFF.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends zY<sc> {
    private static final int HC = Color.parseColor("#FFC642");
    private static final int ymG = Color.parseColor("#e3e3e4");
    private float We;
    private float jcs;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private int f26321sc;
    private float zY;

    public pFF(Context context) {
        super(context);
        this.f26321sc = HC;
        this.pFF = ymG;
        this.zY = 4.0f;
        this.We = 20.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        if (McK()) {
            ((sc) this.Qj).sc(this.zY, this.f26321sc, this.pFF, this.We, (int) this.jcs);
        } else {
            ((sc) this.Qj).sc(this.zY, this.f26321sc, this.pFF, this.We, 5);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public sc We() {
        sc scVar = new sc(this.ExN);
        scVar.sc(this);
        return scVar;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        str.hashCode();
        switch (str) {
            case "highLightColor":
            case "highlightColor":
                this.f26321sc = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case "lowLightColor":
            case "lowlightColor":
                this.pFF = com.bytedance.adsdk.ugeno.qr.sc.sc(str2, ymG);
                break;
            case "gap":
                this.jcs = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case "size":
                this.We = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 20.0f);
                break;
            case "score":
                this.zY = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 4.0f);
                break;
        }
    }
}
