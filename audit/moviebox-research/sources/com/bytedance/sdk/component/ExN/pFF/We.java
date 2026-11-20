package com.bytedance.sdk.component.ExN.pFF;

import com.bytedance.sdk.component.ExN.TRI;
import com.bytedance.sdk.component.ExN.qr;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We<T> implements TRI {
    private qr ExN;
    private String We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    Map<String, String> f26496sc;
    private T zY;

    public We(int i11, T t11, String str) {
        this.pFF = i11;
        this.zY = t11;
        this.We = str;
    }

    public We(int i11, T t11, String str, Map<String, String> map) {
        this(i11, t11, str);
        this.f26496sc = map;
    }

    @Override // com.bytedance.sdk.component.ExN.TRI
    public Map<String, String> ExN() {
        return this.f26496sc;
    }

    @Override // com.bytedance.sdk.component.ExN.TRI
    public String We() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.ExN.TRI
    public int pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.ExN.TRI
    public qr sc() {
        return this.ExN;
    }

    public void sc(qr qrVar) {
        this.ExN = qrVar;
    }

    @Override // com.bytedance.sdk.component.ExN.TRI
    public T zY() {
        return this.zY;
    }
}
