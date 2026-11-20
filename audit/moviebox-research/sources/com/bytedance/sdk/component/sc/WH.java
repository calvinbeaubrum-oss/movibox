package com.bytedance.sdk.component.sc;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import java.util.LinkedHashSet;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class WH {
    boolean BT;
    Context ExN;
    Ql Ol;
    boolean Qj;
    boolean SR;
    boolean TRI;
    SR WH;
    Qj We;
    UFX.sc dE;
    sc pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    boolean f27000qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    WebView f27001sc;
    String zY = "IESJSBridge";
    String UFX = "host";
    final Set<String> Tf = new LinkedHashSet();
    final Set<String> Ql = new LinkedHashSet();

    public WH() {
    }

    public WH(WebView webView) {
        this.f27001sc = webView;
    }

    private void zY() {
        if ((this.f27001sc == null && !this.SR && this.pFF == null) || ((TextUtils.isEmpty(this.zY) && this.f27001sc != null) || this.We == null)) {
            throw new IllegalArgumentException("Requested arguments aren't set properly when building JsBridge.");
        }
    }

    public WH pFF(boolean z11) {
        this.f27000qr = z11;
        return this;
    }

    public Xc pFF() {
        zY();
        return new Xc(this);
    }

    public WH sc() {
        this.BT = true;
        return this;
    }

    public WH sc(Tf tf2) {
        this.We = Qj.sc(tf2);
        return this;
    }

    public WH sc(sc scVar) {
        this.pFF = scVar;
        return this;
    }

    public WH sc(String str) {
        this.zY = str;
        return this;
    }

    public WH sc(boolean z11) {
        this.TRI = z11;
        return this;
    }
}
