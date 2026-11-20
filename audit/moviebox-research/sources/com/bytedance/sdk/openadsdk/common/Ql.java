package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.Sfl;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Ql {
    private ImageView ExN;
    private dE Qj;
    private final String TRI;
    private com.bytedance.sdk.component.Ol.We We;
    private RelativeLayout pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private wjp f27688qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final Sfl f27689sc;
    private final Context zY;

    public Ql(Context context, Sfl sfl, String str) {
        this.zY = context;
        this.f27689sc = sfl;
        this.TRI = str;
        TRI();
    }

    private void TRI() {
        RelativeLayout relativeLayoutSc = sc(this.zY);
        this.pFF = relativeLayoutSc;
        this.We = (com.bytedance.sdk.component.Ol.We) relativeLayoutSc.findViewById(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        wjp wjpVar = new wjp(this.zY, (RelativeLayout) this.pFF.findViewById(com.bytedance.sdk.openadsdk.utils.SR.NQ), this.f27689sc);
        this.f27688qr = wjpVar;
        this.ExN = wjpVar.zY();
        this.Qj = new dE(this.zY, (LinearLayout) this.pFF.findViewById(com.bytedance.sdk.openadsdk.utils.SR.mD), this.We, this.f27689sc, this.TRI);
    }

    private static RelativeLayout sc(Context context) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setBackgroundColor(-1);
        relativeLayout.addView(new Ol(context));
        com.bytedance.sdk.component.Ol.We we2 = new com.bytedance.sdk.component.Ol.We(context);
        we2.setId(com.bytedance.sdk.openadsdk.utils.SR.QLv);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams.addRule(12);
        layoutParams.addRule(3, com.bytedance.sdk.openadsdk.utils.SR.NQ);
        relativeLayout.addView(we2, layoutParams);
        Qj qj2 = new Qj(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(qj2.getLayoutParams());
        layoutParams2.addRule(12);
        relativeLayout.addView(qj2, layoutParams2);
        return relativeLayout;
    }

    public View ExN() {
        return this.pFF;
    }

    public com.bytedance.sdk.component.Ol.We We() {
        return this.We;
    }

    public void pFF() {
        wjp wjpVar = this.f27688qr;
        if (wjpVar != null) {
            wjpVar.pFF();
        }
        dE dEVar = this.Qj;
        if (dEVar != null) {
            dEVar.pFF();
        }
    }

    public void sc() {
        wjp wjpVar = this.f27688qr;
        if (wjpVar != null) {
            wjpVar.sc();
        }
        dE dEVar = this.Qj;
        if (dEVar != null) {
            dEVar.sc();
        }
    }

    public void sc(WebView webView, int i11, com.bytedance.sdk.openadsdk.core.widget.sc.TRI.sc scVar) {
        wjp wjpVar = this.f27688qr;
        if (wjpVar != null) {
            wjpVar.sc(i11);
        }
        dE dEVar = this.Qj;
        if (dEVar != null) {
            dEVar.sc(webView, scVar);
        }
    }

    public ImageView zY() {
        return this.ExN;
    }
}
