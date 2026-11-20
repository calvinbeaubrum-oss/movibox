package com.mbridge.msdk.mbbid.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class BannerBidRequestParams extends CommonBidRequestParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f45442a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45443b;

    public BannerBidRequestParams(String str, String str2, int i11, int i12) {
        super(str, str2);
        this.f45442a = i12;
        this.f45443b = i11;
    }

    public BannerBidRequestParams(String str, String str2, String str3, int i11, int i12) {
        super(str, str2, str3);
        this.f45442a = i12;
        this.f45443b = i11;
    }

    public int getHeight() {
        return this.f45442a;
    }

    public int getWidth() {
        return this.f45443b;
    }

    public void setHeight(int i11) {
        this.f45442a = i11;
    }

    public void setWidth(int i11) {
        this.f45443b = i11;
    }
}
