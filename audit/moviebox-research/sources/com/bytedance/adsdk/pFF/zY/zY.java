package com.bytedance.adsdk.pFF.zY;

import android.graphics.Typeface;
import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class zY {
    private Typeface ExN;
    private final float We;
    private final String pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final String f26269sc;
    private final String zY;

    public zY(String str, String str2, String str3, float f11) {
        this.f26269sc = str;
        this.pFF = str2;
        this.zY = str3;
        this.We = f11;
    }

    public Typeface We() {
        return this.ExN;
    }

    public String pFF() {
        return this.pFF;
    }

    public String sc() {
        return this.f26269sc;
    }

    public void sc(Typeface typeface) {
        this.ExN = typeface;
    }

    public String zY() {
        return this.zY;
    }
}
