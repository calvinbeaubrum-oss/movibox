package com.applovin.impl;

import android.media.MediaCodec;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class jd extends o5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final kd f19939a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19940b;

    public jd(Throwable th2, kd kdVar) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Decoder failed: ");
        sb2.append(kdVar == null ? null : kdVar.f20199a);
        super(sb2.toString(), th2);
        this.f19939a = kdVar;
        this.f19940b = xp.f24372a >= 21 ? a(th2) : null;
    }

    private static String a(Throwable th2) {
        if (th2 instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
        }
        return null;
    }
}
