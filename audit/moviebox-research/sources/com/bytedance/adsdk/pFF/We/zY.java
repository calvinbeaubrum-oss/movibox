package com.bytedance.adsdk.pFF.We;

import com.bytedance.component.sdk.annotation.RestrictTo;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public enum zY {
    JSON(".json"),
    ZIP(".zip");

    public final String zY;

    zY(String str) {
        this.zY = str;
    }

    public String sc() {
        return ".temp" + this.zY;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.zY;
    }
}
