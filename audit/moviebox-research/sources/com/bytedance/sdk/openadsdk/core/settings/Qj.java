package com.bytedance.sdk.openadsdk.core.settings;

import android.text.TextUtils;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class Qj implements Comparable<Qj> {
    private String ExN;
    private final String Qj;
    private final int TRI;
    private final int We;
    private final String pFF;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private final int f28487qr;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f28488sc;
    private final int zY;

    public Qj(String str, String str2, int i11, int i12, String str3, int i13, int i14, String str4) {
        this.f28488sc = str;
        this.pFF = str2;
        this.zY = i11;
        this.We = i12;
        this.ExN = str3;
        if (TextUtils.isEmpty(str3)) {
            this.ExN = "0";
        }
        this.TRI = i13;
        this.f28487qr = i14;
        this.Qj = str4;
    }

    public int sc() {
        return this.TRI;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: sc, reason: merged with bridge method [inline-methods] */
    public int compareTo(Qj qj2) {
        if (this.TRI < qj2.sc()) {
            return -1;
        }
        return this.TRI == qj2.sc() ? 0 : 1;
    }
}
