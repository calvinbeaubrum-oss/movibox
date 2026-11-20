package com.bytedance.sdk.component.pFF.sc;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Ol {
    private String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private String f26927sc;

    private Ol(String str) {
        this.f26927sc = str;
    }

    public static Ol sc(String str) {
        return new Ol(str);
    }

    public String sc() {
        return this.f26927sc;
    }

    public Charset sc(Charset charset) {
        try {
            String str = this.pFF;
            return str != null ? Charset.forName(str) : charset;
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }
}
