package com.bytedance.sdk.openadsdk.SR.sc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.bytedance.sdk.component.pFF.sc.SR;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ExN {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static int f27115sc = -10;
    private long ExN;
    private String Ol;
    private boolean Qj;
    private int TRI;
    private int WH;
    private long We;
    private final int pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private int f27116qr;
    private String zY;

    public ExN(int i11) {
        this.pFF = i11;
    }

    public static void zY() {
    }

    public ExN We(String str) {
        this.Ol = str;
        return this;
    }

    public ExN pFF(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.TRI = bytes.length;
        }
        return this;
    }

    public void pFF() {
        this.ExN = SystemClock.elapsedRealtime() - this.We;
    }

    public ExN sc(int i11) {
        this.WH = i11;
        return this;
    }

    public ExN sc(SR sr2) {
        byte[] bArr;
        if (sr2 != null) {
            if (sr2.TRI == SR.sc.STRING_TYPE && !TextUtils.isEmpty(sr2.sc())) {
                this.TRI = sr2.sc().getBytes().length;
            }
            if (sr2.TRI == SR.sc.BYTE_ARRAY_TYPE && (bArr = sr2.ExN) != null) {
                this.TRI = bArr.length;
            }
        }
        return this;
    }

    public ExN sc(String str) {
        this.zY = str;
        return this;
    }

    public ExN sc(boolean z11) {
        this.Qj = z11;
        return this;
    }

    public void sc() {
        this.We = SystemClock.elapsedRealtime();
    }

    public ExN zY(String str) {
        byte[] bytes;
        if (!TextUtils.isEmpty(str) && (bytes = str.getBytes()) != null) {
            this.f27116qr = bytes.length;
        }
        return this;
    }
}
