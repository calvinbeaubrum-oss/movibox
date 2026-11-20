package com.bytedance.adsdk.ugeno;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import com.applovin.exoplayer2.common.base.Ascii;
import com.bytedance.adsdk.ugeno.core.Ol;
import com.bytedance.adsdk.ugeno.qr.Qj;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF extends com.bytedance.adsdk.ugeno.pFF.sc<com.bytedance.adsdk.ugeno.TRI.pFF> {
    private boolean GOt;
    private float HC;
    private int Pu;
    private int VZ;
    private boolean We;
    private float WgX;

    /* JADX INFO: renamed from: ag, reason: collision with root package name */
    private com.bytedance.adsdk.ugeno.pFF.zY f26413ag;

    /* JADX INFO: renamed from: bp, reason: collision with root package name */
    private float f26414bp;

    /* JADX INFO: renamed from: ef, reason: collision with root package name */
    private float f26415ef;
    private float jcs;
    private float pCa;
    private String pFF;

    /* JADX INFO: renamed from: vl, reason: collision with root package name */
    private JSONArray f26416vl;
    private String ymG;
    private boolean zY;

    public pFF(Context context) {
        super(context);
        this.zY = true;
        this.We = true;
        this.jcs = 0.0f;
        this.HC = 2000.0f;
        this.ymG = "normal";
        this.GOt = true;
        this.Pu = Color.parseColor("#666666");
        this.VZ = Color.parseColor("#ffffff");
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public View We() {
        com.bytedance.adsdk.ugeno.TRI.pFF pff = new com.bytedance.adsdk.ugeno.TRI.pFF(this.ExN);
        this.Qj = pff;
        pff.sc((zY) this);
        return this.Qj;
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc, com.bytedance.adsdk.ugeno.pFF.zY
    public void pFF() {
        super.pFF();
        JSONArray jSONArray = this.f26416vl;
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.TRI.pFF) this.Qj).We((int) this.pCa).ExN((int) this.f26414bp).TRI((int) this.WgX).pFF(this.GOt).pFF(this.VZ).zY(this.Pu).sc(this.ymG).zY(this.zY).sc(this.f26415ef).sc(this.We).sc((int) this.HC).pFF(this.GOt);
        for (int i11 = 0; i11 < this.f26416vl.length(); i11++) {
            Ol ol2 = new Ol(this.ExN);
            ol2.sc(this.JP);
            com.bytedance.adsdk.ugeno.pFF.zY<View> zYVarPFF = ol2.pFF(this.f26413ag.II(), null);
            ol2.pFF(this.f26416vl.optJSONObject(i11));
            ((com.bytedance.adsdk.ugeno.TRI.pFF) this.Qj).sc(zYVarPFF);
        }
        if (this.We) {
            ((com.bytedance.adsdk.ugeno.TRI.pFF) this.Qj).sc();
        }
    }

    public void sc(int i11) {
        T t11 = this.Qj;
        if (t11 != 0) {
            ((com.bytedance.adsdk.ugeno.TRI.pFF) t11).Ol(i11);
        }
    }

    public void sc(com.bytedance.adsdk.ugeno.TRI.zY zYVar) {
        T t11 = this.Qj;
        if (t11 != 0) {
            ((com.bytedance.adsdk.ugeno.TRI.pFF) t11).setOnPageChangeListener(zYVar);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.sc
    public void sc(com.bytedance.adsdk.ugeno.pFF.zY zYVar) {
        this.f26413ag = zYVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(String str, String str2) {
        super.sc(str, str2);
        if (TextUtils.isEmpty(str)) {
        }
        str.hashCode();
        byte b11 = -1;
        switch (str.hashCode()) {
            case -1657957217:
                if (str.equals("delayStart")) {
                    b11 = 0;
                }
                break;
            case -1575751020:
                if (str.equals("indicatorColor")) {
                    b11 = 1;
                }
                break;
            case -1453344127:
                if (str.equals("nextMargin")) {
                    b11 = 2;
                }
                break;
            case -1306084975:
                if (str.equals("effect")) {
                    b11 = 3;
                }
                break;
            case -962590849:
                if (str.equals("direction")) {
                    b11 = 4;
                }
                break;
            case -711999985:
                if (str.equals("indicator")) {
                    b11 = 5;
                }
                break;
            case -202057851:
                if (str.equals("previousMargin")) {
                    b11 = 6;
                }
                break;
            case 3327652:
                if (str.equals("loop")) {
                    b11 = 7;
                }
                break;
            case 109641799:
                if (str.equals("speed")) {
                    b11 = 8;
                }
                break;
            case 857882560:
                if (str.equals("pageCount")) {
                    b11 = 9;
                }
                break;
            case 1097821469:
                if (str.equals("pageMargin")) {
                    b11 = 10;
                }
                break;
            case 1196931001:
                if (str.equals("indicatorSelectedColor")) {
                    b11 = Ascii.VT;
                }
                break;
            case 1439562083:
                if (str.equals("autoplay")) {
                    b11 = Ascii.FF;
                }
                break;
            case 1788817256:
                if (str.equals("dataList")) {
                    b11 = Ascii.CR;
                }
                break;
        }
        switch (b11) {
            case 0:
                this.jcs = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f);
                break;
            case 1:
                this.Pu = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case 2:
                this.WgX = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 3:
                this.ymG = str2;
                break;
            case 4:
                this.pFF = str2;
                break;
            case 5:
                this.GOt = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, true);
                break;
            case 6:
                this.f26414bp = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 7:
                this.zY = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, true);
                break;
            case 8:
                this.HC = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 500.0f);
                break;
            case 9:
                this.f26415ef = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 1.0f);
                break;
            case 10:
                this.pCa = Qj.sc(this.ExN, com.bytedance.adsdk.ugeno.qr.zY.sc(str2, 0.0f));
                break;
            case 11:
                this.VZ = com.bytedance.adsdk.ugeno.qr.sc.sc(str2);
                break;
            case 12:
                this.We = com.bytedance.adsdk.ugeno.qr.zY.sc(str2, true);
                break;
            case 13:
                this.f26416vl = com.bytedance.adsdk.ugeno.qr.pFF.sc(str2, (JSONArray) null);
                break;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.pFF.zY
    public void sc(JSONObject jSONObject) {
    }
}
