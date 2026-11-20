package com.mbridge.msdk.video.dynview.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public enum a {
    NOT_FOUND_VIEWOPTION(-1, "ViewOption is null"),
    NOT_FOUND_CONTEXT(-2, "Context is null"),
    NOT_FOUND_LAYOUTNAME(-3, "layout xml name is null"),
    CAMPAIGNEX_IS_NULL(-4, "Campaign size only one"),
    VIEW_CREATE_ERROR(-5, "view create error"),
    NOT_FOUND_ROOTVIEW(-6, "rootview is null");


    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f47582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f47583h;

    a(int i11, String str) {
        this.f47582g = i11;
        this.f47583h = str;
    }

    public final int a() {
        return this.f47582g;
    }

    public final String b() {
        return this.f47583h;
    }
}
