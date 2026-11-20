package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class AesGcm extends ContentCryptoScheme {
    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int a() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String b() {
        return "AES/GCM/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int c() {
        return 12;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String d() {
        return "AES";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int e() {
        return 256;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String f() {
        return "BC";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int g() {
        return 128;
    }
}
