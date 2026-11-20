package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public interface i extends l {
    HashCode a();

    i b(CharSequence charSequence);

    i c(byte[] bArr, int i11, int i12);

    i d(ByteBuffer byteBuffer);

    i e(int i11);

    i f(CharSequence charSequence, Charset charset);

    i g(long j11);

    <T> i h(T t11, Funnel<? super T> funnel);
}
