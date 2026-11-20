package com.bytedance.sdk.component.sc;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Xc {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    static uEA f27004sc;
    private final List<SR> ExN;
    private volatile boolean TRI;
    private final WH We;
    private final sc pFF;
    private final WebView zY;

    public Xc(WH wh2) {
        ArrayList arrayList = new ArrayList();
        this.ExN = arrayList;
        this.TRI = false;
        this.We = wh2;
        if (wh2.Qj && f27004sc != null) {
            throw null;
        }
        if (wh2.f27001sc != null) {
            sc scVar = wh2.pFF;
            if (scVar == null) {
                this.pFF = new WP();
            } else {
                this.pFF = scVar;
            }
        } else {
            this.pFF = wh2.pFF;
        }
        this.pFF.sc(wh2, (Dl) null);
        this.zY = wh2.f27001sc;
        arrayList.add(wh2.WH);
        FI.sc(wh2.f27000qr);
    }

    private void pFF() {
        if (this.TRI) {
            Ol.sc(new IllegalStateException("JsBridge2 is already released!!!"));
        }
    }

    public static WH sc(WebView webView) {
        return new WH(webView);
    }

    public Xc sc(String str, ExN<?, ?> exN) {
        return sc(str, (String) null, exN);
    }

    public Xc sc(String str, We.pFF pff) {
        return sc(str, (String) null, pff);
    }

    public Xc sc(String str, String str2, ExN<?, ?> exN) {
        pFF();
        this.pFF.f27016qr.sc(str, exN);
        return this;
    }

    public Xc sc(String str, String str2, We.pFF pff) {
        pFF();
        this.pFF.f27016qr.sc(str, pff);
        return this;
    }

    public void sc() {
        if (this.TRI) {
            return;
        }
        this.pFF.pFF();
        this.TRI = true;
        Iterator<SR> it = this.ExN.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}
