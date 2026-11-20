package com.bytedance.adsdk.pFF.zY;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class TRI {
    public final float pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public final float f26227sc;
    private final String zY;

    public TRI(String str, float f11, float f12) {
        this.zY = str;
        this.pFF = f12;
        this.f26227sc = f11;
    }

    public boolean sc(String str) {
        if (this.zY.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.zY.endsWith("\r")) {
            String str2 = this.zY;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
