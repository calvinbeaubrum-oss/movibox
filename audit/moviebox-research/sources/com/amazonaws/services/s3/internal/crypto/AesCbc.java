package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class AesCbc extends ContentCryptoScheme {
    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int a() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String b() {
        return "AES/CBC/PKCS5Padding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int c() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String d() {
        return "AES";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int e() {
        return 256;
    }
}
