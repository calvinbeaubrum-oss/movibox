package com.bumptech.glide.integration.cronet;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
interface ByteBufferParser<T> {
    Class<T> getDataClass();

    T parse(ByteBuffer byteBuffer);
}
