package com.google.common.hash;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface e extends i {
    HashCode a();

    e b(CharSequence charSequence);

    e c(byte[] bArr, int i11, int i12);

    e d(ByteBuffer byteBuffer);

    e e(int i11);

    e f(CharSequence charSequence, Charset charset);

    e g(long j11);

    <T> e h(T t11, Funnel<? super T> funnel);
}
