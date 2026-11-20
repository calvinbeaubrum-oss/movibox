package com.google.zxing;

import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f41535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f41536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k[] f41537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final BarcodeFormat f41538e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<ResultMetadataType, Object> f41539f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f41540g;

    public j(String str, byte[] bArr, int i11, k[] kVarArr, BarcodeFormat barcodeFormat, long j11) {
        this.f41534a = str;
        this.f41535b = bArr;
        this.f41536c = i11;
        this.f41537d = kVarArr;
        this.f41538e = barcodeFormat;
        this.f41539f = null;
        this.f41540g = j11;
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, kVarArr, barcodeFormat, System.currentTimeMillis());
    }

    public j(String str, byte[] bArr, k[] kVarArr, BarcodeFormat barcodeFormat, long j11) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, kVarArr, barcodeFormat, j11);
    }

    public void a(k[] kVarArr) {
        k[] kVarArr2 = this.f41537d;
        if (kVarArr2 == null) {
            this.f41537d = kVarArr;
            return;
        }
        if (kVarArr == null || kVarArr.length <= 0) {
            return;
        }
        k[] kVarArr3 = new k[kVarArr2.length + kVarArr.length];
        System.arraycopy(kVarArr2, 0, kVarArr3, 0, kVarArr2.length);
        System.arraycopy(kVarArr, 0, kVarArr3, kVarArr2.length, kVarArr.length);
        this.f41537d = kVarArr3;
    }

    public BarcodeFormat b() {
        return this.f41538e;
    }

    public byte[] c() {
        return this.f41535b;
    }

    public Map<ResultMetadataType, Object> d() {
        return this.f41539f;
    }

    public k[] e() {
        return this.f41537d;
    }

    public String f() {
        return this.f41534a;
    }

    public void g(Map<ResultMetadataType, Object> map) {
        if (map != null) {
            Map<ResultMetadataType, Object> map2 = this.f41539f;
            if (map2 == null) {
                this.f41539f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f41539f == null) {
            this.f41539f = new EnumMap(ResultMetadataType.class);
        }
        this.f41539f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.f41534a;
    }
}
