package com.applovin.impl;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dk implements cf {
    @Override // com.applovin.impl.cf
    public final bf a(ef efVar) {
        ByteBuffer byteBuffer = (ByteBuffer) b1.a(efVar.f21655c);
        b1.a(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (efVar.d()) {
            return null;
        }
        return a(efVar, byteBuffer);
    }

    public abstract bf a(ef efVar, ByteBuffer byteBuffer);
}
