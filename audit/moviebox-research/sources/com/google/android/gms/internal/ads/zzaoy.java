package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoy implements zzaoz {
    private final ByteBuffer zza;

    public zzaoy(ByteBuffer byteBuffer) {
        this.zza = byteBuffer.slice();
    }

    @Override // com.google.android.gms.internal.ads.zzaoz
    public final long zza() {
        return this.zza.capacity();
    }

    @Override // com.google.android.gms.internal.ads.zzaoz
    public final void zzb(MessageDigest[] messageDigestArr, long j11, int i11) throws IOException {
        ByteBuffer byteBufferSlice;
        synchronized (this.zza) {
            int i12 = (int) j11;
            this.zza.position(i12);
            this.zza.limit(i12 + i11);
            byteBufferSlice = this.zza.slice();
        }
        for (MessageDigest messageDigest : messageDigestArr) {
            byteBufferSlice.position(0);
            messageDigest.update(byteBufferSlice);
        }
    }
}
