package com.google.common.hash;

import com.google.common.base.m;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class a implements d {
    public HashCode hashBytes(ByteBuffer byteBuffer) {
        return newHasher(byteBuffer.remaining()).d(byteBuffer).a();
    }

    public HashCode hashBytes(byte[] bArr) {
        return hashBytes(bArr, 0, bArr.length);
    }

    public HashCode hashBytes(byte[] bArr, int i11, int i12) {
        m.u(i11, i11 + i12, bArr.length);
        return newHasher(i12).c(bArr, i11, i12).a();
    }

    public HashCode hashInt(int i11) {
        return newHasher(4).e(i11).a();
    }

    public HashCode hashLong(long j11) {
        return newHasher(8).g(j11).a();
    }

    @Override // com.google.common.hash.d
    public <T> HashCode hashObject(T t11, Funnel<? super T> funnel) {
        return newHasher().h(t11, funnel).a();
    }

    public HashCode hashString(CharSequence charSequence, Charset charset) {
        return newHasher().f(charSequence, charset).a();
    }

    public HashCode hashUnencodedChars(CharSequence charSequence) {
        return newHasher(charSequence.length() * 2).b(charSequence).a();
    }

    public e newHasher(int i11) {
        m.g(i11 >= 0, "expectedInputSize must be >= 0 but was %s", i11);
        return newHasher();
    }
}
