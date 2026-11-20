package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
abstract class ContentCryptoScheme {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ContentCryptoScheme f15985a = new AesCbc();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ContentCryptoScheme f15986b = new AesGcm();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ContentCryptoScheme f15987c = new AesCtr();

    public abstract int a();

    public abstract String b();

    public abstract int c();

    public abstract String d();

    public abstract int e();

    public String f() {
        return null;
    }

    public int g() {
        return 0;
    }

    public String toString() {
        return "cipherAlgo=" + b() + ", blockSizeInBytes=" + a() + ", ivLengthInBytes=" + c() + ", keyGenAlgo=" + d() + ", keyLengthInBits=" + e() + ", specificProvider=" + f() + ", tagLengthInBits=" + g();
    }
}
