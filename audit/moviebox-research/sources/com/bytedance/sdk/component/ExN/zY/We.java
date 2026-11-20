package com.bytedance.sdk.component.ExN.zY;

import com.bytedance.sdk.component.ExN.UFX;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We<T> implements UFX {
    private int ExN;
    private boolean Ol;
    private boolean Qj;
    private int TRI;
    private int UFX;
    private com.bytedance.sdk.component.ExN.qr WH;
    private T We;
    private String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private Map<String, String> f26507qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26508sc;
    private T zY;

    @Override // com.bytedance.sdk.component.ExN.UFX
    public boolean ExN() {
        return this.Qj;
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public boolean TRI() {
        return this.Ol;
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public Map<String, String> We() {
        return this.f26507qr;
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public T pFF() {
        return this.zY;
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public int qr() {
        return this.UFX;
    }

    public We sc(zY zYVar, T t11) {
        this.zY = t11;
        this.f26508sc = zYVar.ExN();
        this.pFF = zYVar.sc();
        this.ExN = zYVar.pFF();
        this.TRI = zYVar.zY();
        this.Ol = zYVar.BT();
        this.WH = zYVar.dE();
        this.UFX = zYVar.Xc();
        return this;
    }

    public We sc(zY zYVar, T t11, Map<String, String> map, boolean z11) {
        this.f26507qr = map;
        this.Qj = z11;
        return sc(zYVar, t11);
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public String sc() {
        return this.pFF;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.sdk.component.ExN.UFX
    public void sc(Object obj) {
        this.We = this.zY;
        this.zY = obj;
    }

    @Override // com.bytedance.sdk.component.ExN.UFX
    public T zY() {
        return this.We;
    }
}
