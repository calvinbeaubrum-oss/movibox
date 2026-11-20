package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzarq extends zzhgk {
    ByteBuffer zza;

    public zzarq(String str) {
        super(str);
    }

    @Override // com.google.android.gms.internal.ads.zzhgk
    public final void zzf(ByteBuffer byteBuffer) {
        this.zza = byteBuffer;
        byteBuffer.position(byteBuffer.position() + byteBuffer.remaining());
    }
}
