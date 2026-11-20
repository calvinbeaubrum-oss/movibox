package com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class b implements e {
    @Override // com.google.common.hash.e
    public e b(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            j(charSequence.charAt(i11));
        }
        return this;
    }

    @Override // com.google.common.hash.e
    public abstract e c(byte[] bArr, int i11, int i12);

    @Override // com.google.common.hash.e
    public e f(CharSequence charSequence, Charset charset) {
        return i(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.common.hash.e
    public <T> e h(T t11, Funnel<? super T> funnel) {
        funnel.funnel(t11, this);
        return this;
    }

    public e i(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public abstract e j(char c11);
}
