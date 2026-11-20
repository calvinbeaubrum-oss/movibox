package com.mbridge.msdk.mbbid.out;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class AdvancedNativeBidRequestParams extends CommonBidRequestParams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f45440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f45441b;

    public AdvancedNativeBidRequestParams(String str, String str2, int i11, int i12) {
        super(str, str2);
        this.f45440a = i12;
        this.f45441b = i11;
    }

    public AdvancedNativeBidRequestParams(String str, String str2, String str3, int i11, int i12) {
        super(str, str2, str3);
        this.f45440a = i12;
        this.f45441b = i11;
    }

    public int getHeight() {
        return this.f45440a;
    }

    public int getWidth() {
        return this.f45441b;
    }

    public void setHeight(int i11) {
        this.f45440a = i11;
    }

    public void setWidth(int i11) {
        this.f45441b = i11;
    }
}
