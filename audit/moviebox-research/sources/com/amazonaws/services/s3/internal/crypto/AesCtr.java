package com.amazonaws.services.s3.internal.crypto;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@Deprecated
class AesCtr extends ContentCryptoScheme {
    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int a() {
        return ContentCryptoScheme.f15986b.a();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String b() {
        return "AES/CTR/NoPadding";
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int c() {
        return 16;
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public String d() {
        return ContentCryptoScheme.f15986b.d();
    }

    @Override // com.amazonaws.services.s3.internal.crypto.ContentCryptoScheme
    public int e() {
        return ContentCryptoScheme.f15986b.e();
    }
}
