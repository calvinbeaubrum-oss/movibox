package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements h {
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).d(byteBuffer).a();
    }

    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.s(i11, i11 + i12, bArr.length);
        return newHasher(i12).c(bArr, i11, i12).a();
    }

    public HashCode hashInt(int i11) {
        return newHasher(4).e(i11).a();
    }

    public HashCode hashLong(long j11) {
        return newHasher(8).g(j11).a();
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.h
    public <T> HashCode hashObject(T t11, Funnel<? super T> funnel) {
        return newHasher().h(t11, funnel).a();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().f(charSequence, charset).a();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).b(charSequence).a();
    }

    public i newHasher(int i11) {
        com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.l.f(i11 >= 0, "expectedInputSize must be >= 0 but was %s", i11);
        return newHasher();
    }
}
