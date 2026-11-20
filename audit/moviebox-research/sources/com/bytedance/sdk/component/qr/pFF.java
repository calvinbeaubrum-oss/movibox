package com.bytedance.sdk.component.qr;

import com.bytedance.sdk.component.pFF.sc.WH;
import java.io.File;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF {
    final long ExN;
    private final boolean Ol;
    final long TRI;
    final String We;
    final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    WH f26968qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    final int f26969sc;
    final Map<String, String> zY;
    private File Qj = null;
    private byte[] WH = null;

    public pFF(boolean z11, int i11, String str, Map<String, String> map, String str2, long j11, long j12) {
        this.Ol = z11;
        this.f26969sc = i11;
        this.pFF = str;
        this.zY = map;
        this.We = str2;
        this.ExN = j11;
        this.TRI = j12;
    }

    public File ExN() {
        return this.Qj;
    }

    public boolean TRI() {
        return this.Ol;
    }

    public String We() {
        return this.We;
    }

    public String pFF() {
        return this.pFF;
    }

    public WH qr() {
        return this.f26968qr;
    }

    public int sc() {
        return this.f26969sc;
    }

    public void sc(WH wh2) {
        this.f26968qr = wh2;
    }

    public void sc(File file) {
        this.Qj = file;
    }

    public void sc(byte[] bArr) {
        this.WH = bArr;
    }

    public Map<String, String> zY() {
        return this.zY;
    }
}
