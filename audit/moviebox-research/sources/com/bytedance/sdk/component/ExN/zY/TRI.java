package com.bytedance.sdk.component.ExN.zY;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bytedance.sdk.component.ExN.Dl;
import com.bytedance.sdk.component.ExN.Ql;
import com.bytedance.sdk.component.ExN.Sfl;
import com.bytedance.sdk.component.ExN.Tf;
import com.bytedance.sdk.component.ExN.Xc;
import com.bytedance.sdk.component.ExN.wjp;
import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {
    private Xc Ol;
    private ExecutorService Qj;
    private com.bytedance.sdk.component.ExN.We TRI;
    private final Ql pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Tf f26505qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private Map<String, List<zY>> f26506sc = new ConcurrentHashMap();
    private Map<String, wjp> zY = new HashMap();
    private Map<String, Sfl> We = new HashMap();
    private Map<String, com.bytedance.sdk.component.ExN.zY> ExN = new HashMap();

    public TRI(Context context, Ql ql2) {
        this.pFF = (Ql) Qj.sc(ql2);
        com.bytedance.sdk.component.ExN.zY.sc.sc.sc(context, ql2.Ol());
    }

    private Sfl ExN(com.bytedance.sdk.component.ExN.pFF pff) {
        Sfl sflTRI = this.pFF.TRI();
        return sflTRI != null ? sflTRI : com.bytedance.sdk.component.ExN.zY.sc.pFF.ExN.sc(pff.pFF());
    }

    private com.bytedance.sdk.component.ExN.We Ol() {
        com.bytedance.sdk.component.ExN.We We = this.pFF.We();
        return We == null ? com.bytedance.sdk.component.ExN.pFF.pFF.sc() : We;
    }

    private com.bytedance.sdk.component.ExN.zY TRI(com.bytedance.sdk.component.ExN.pFF pff) {
        com.bytedance.sdk.component.ExN.zY zYVarQr = this.pFF.qr();
        return zYVarQr != null ? zYVarQr : new com.bytedance.sdk.component.ExN.zY.sc.sc.pFF(pff.ExN(), pff.sc(), TRI());
    }

    private Xc Tf() {
        Xc xcQj = this.pFF.Qj();
        return xcQj == null ? new qr() : xcQj;
    }

    private ExecutorService UFX() {
        ExecutorService executorServicePFF = this.pFF.pFF();
        return executorServicePFF != null ? executorServicePFF : com.bytedance.sdk.component.ExN.sc.zY.sc();
    }

    private Tf WH() {
        Tf tfSc = this.pFF.sc();
        return tfSc != null ? tfSc : com.bytedance.sdk.component.ExN.sc.pFF.sc();
    }

    private wjp We(com.bytedance.sdk.component.ExN.pFF pff) {
        wjp wjpVarExN = this.pFF.ExN();
        return wjpVarExN != null ? com.bytedance.sdk.component.ExN.zY.sc.pFF.sc.sc(wjpVarExN) : com.bytedance.sdk.component.ExN.zY.sc.pFF.sc.sc(pff.pFF());
    }

    public Tf ExN() {
        if (this.f26505qr == null) {
            this.f26505qr = WH();
        }
        return this.f26505qr;
    }

    public Xc Qj() {
        if (this.Ol == null) {
            this.Ol = Tf();
        }
        return this.Ol;
    }

    public ExecutorService TRI() {
        ExecutorService executorServiceSc;
        Dl dlZY = this.pFF.zY();
        if (dlZY != null && (executorServiceSc = dlZY.sc()) != null) {
            return executorServiceSc;
        }
        if (this.Qj == null) {
            this.Qj = UFX();
        }
        return this.Qj;
    }

    public com.bytedance.sdk.component.ExN.We We() {
        if (this.TRI == null) {
            this.TRI = Ol();
        }
        return this.TRI;
    }

    public Sfl pFF(com.bytedance.sdk.component.ExN.pFF pff) {
        if (pff == null) {
            pff = com.bytedance.sdk.component.ExN.zY.sc.sc.qr();
        }
        String string = pff.ExN().toString();
        Sfl sfl = this.We.get(string);
        if (sfl != null) {
            return sfl;
        }
        Sfl sflExN = ExN(pff);
        this.We.put(string, sflExN);
        return sflExN;
    }

    public Collection<Sfl> pFF() {
        return this.We.values();
    }

    public Map<String, List<zY>> qr() {
        return this.f26506sc;
    }

    public wjp sc(com.bytedance.sdk.component.ExN.pFF pff) {
        if (pff == null) {
            pff = com.bytedance.sdk.component.ExN.zY.sc.sc.qr();
        }
        String string = pff.ExN().toString();
        wjp wjpVar = this.zY.get(string);
        if (wjpVar != null) {
            return wjpVar;
        }
        wjp wjpVarWe = We(pff);
        this.zY.put(string, wjpVarWe);
        return wjpVarWe;
    }

    public com.bytedance.sdk.component.ExN.zY.pFF.sc sc(zY zYVar) {
        ImageView.ScaleType scaleTypeWe = zYVar.We();
        if (scaleTypeWe == null) {
            scaleTypeWe = com.bytedance.sdk.component.ExN.zY.pFF.sc.f26510sc;
        }
        ImageView.ScaleType scaleType = scaleTypeWe;
        Bitmap.Config configUFX = zYVar.UFX();
        if (configUFX == null) {
            configUFX = com.bytedance.sdk.component.ExN.zY.pFF.sc.pFF;
        }
        return new com.bytedance.sdk.component.ExN.zY.pFF.sc(zYVar.pFF(), zYVar.zY(), scaleType, configUFX, zYVar.qr(), zYVar.Qj());
    }

    public com.bytedance.sdk.component.ExN.zY sc(String str) {
        return zY(com.bytedance.sdk.component.ExN.zY.sc.sc.sc(new File(str)));
    }

    public Collection<wjp> sc() {
        return this.zY.values();
    }

    public com.bytedance.sdk.component.ExN.zY zY(com.bytedance.sdk.component.ExN.pFF pff) {
        if (pff == null) {
            pff = com.bytedance.sdk.component.ExN.zY.sc.sc.qr();
        }
        String string = pff.ExN().toString();
        com.bytedance.sdk.component.ExN.zY zYVar = this.ExN.get(string);
        if (zYVar != null) {
            return zYVar;
        }
        com.bytedance.sdk.component.ExN.zY zYVarTRI = TRI(pff);
        this.ExN.put(string, zYVarTRI);
        return zYVarTRI;
    }

    public Collection<com.bytedance.sdk.component.ExN.zY> zY() {
        return this.ExN.values();
    }
}
