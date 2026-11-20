package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public abstract class b implements i {
    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public i b(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i11 = 0; i11 < length; i11++) {
            j(charSequence.charAt(i11));
        }
        return this;
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public abstract i c(byte[] bArr, int i11, int i12);

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public i f(CharSequence charSequence, Charset charset) {
        return i(charSequence.toString().getBytes(charset));
    }

    @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.i
    public <T> i h(T t11, Funnel<? super T> funnel) {
        funnel.funnel(t11, this);
        return this;
    }

    public i i(byte[] bArr) {
        return c(bArr, 0, bArr.length);
    }

    public abstract i j(char c11);
}
