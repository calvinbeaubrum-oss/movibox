package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzih extends zzib {

    @Nullable
    public zzam zza;
    public final zzie zzb = new zzie();

    @Nullable
    public ByteBuffer zzc;
    public boolean zzd;
    public long zze;

    @Nullable
    public ByteBuffer zzf;
    private final int zzg;

    static {
        zzbq.zzb("media3.decoder");
    }

    public zzih(int i11, int i12) {
        this.zzg = i11;
    }

    private final ByteBuffer zzl(int i11) {
        int i12 = this.zzg;
        if (i12 == 1) {
            return ByteBuffer.allocate(i11);
        }
        if (i12 == 2) {
            return ByteBuffer.allocateDirect(i11);
        }
        ByteBuffer byteBuffer = this.zzc;
        throw new zzig(byteBuffer == null ? 0 : byteBuffer.capacity(), i11);
    }

    @Override // com.google.android.gms.internal.ads.zzib
    public void zzb() {
        super.zzb();
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.clear();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.clear();
        }
        this.zzd = false;
    }

    public final void zzi(int i11) {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer == null) {
            this.zzc = zzl(i11);
            return;
        }
        int iCapacity = byteBuffer.capacity();
        int iPosition = byteBuffer.position();
        int i12 = i11 + iPosition;
        if (iCapacity >= i12) {
            this.zzc = byteBuffer;
            return;
        }
        ByteBuffer byteBufferZzl = zzl(i12);
        byteBufferZzl.order(byteBuffer.order());
        if (iPosition > 0) {
            byteBuffer.flip();
            byteBufferZzl.put(byteBuffer);
        }
        this.zzc = byteBufferZzl;
    }

    public final void zzj() {
        ByteBuffer byteBuffer = this.zzc;
        if (byteBuffer != null) {
            byteBuffer.flip();
        }
        ByteBuffer byteBuffer2 = this.zzf;
        if (byteBuffer2 != null) {
            byteBuffer2.flip();
        }
    }

    public final boolean zzk() {
        return zzd(1073741824);
    }
}
