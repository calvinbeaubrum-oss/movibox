package com.mbridge.msdk.mbbid.common;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f45436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f45437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f45438c;

    public c(String str, String str2) {
        this.f45436a = str;
        this.f45437b = str2;
    }

    public c(String str, String str2, String str3) {
        this.f45436a = str;
        this.f45437b = str2;
        this.f45438c = str3;
    }

    public String getmFloorPrice() {
        return this.f45438c;
    }

    public String getmPlacementId() {
        return this.f45436a;
    }

    public String getmUnitId() {
        return this.f45437b;
    }

    public void setmFloorPrice(String str) {
        this.f45438c = str;
    }

    public void setmPlacementId(String str) {
        this.f45436a = str;
    }

    public void setmUnitId(String str) {
        this.f45437b = str;
    }
}
