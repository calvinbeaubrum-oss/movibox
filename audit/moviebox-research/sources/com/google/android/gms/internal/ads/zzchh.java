package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchh {
    private long zza;

    public final long zza(ByteBuffer byteBuffer) {
        zzarp zzarpVar;
        zzaro zzaroVar;
        long j11 = this.zza;
        if (j11 > 0) {
            return j11;
        }
        try {
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.flip();
            Iterator it = new zzark(new zzchg(byteBufferDuplicate), zzchj.zzb).zze().iterator();
            while (true) {
                zzarpVar = null;
                if (!it.hasNext()) {
                    zzaroVar = null;
                    break;
                }
                zzarm zzarmVar = (zzarm) it.next();
                if (zzarmVar instanceof zzaro) {
                    zzaroVar = (zzaro) zzarmVar;
                    break;
                }
            }
            for (zzarm zzarmVar2 : zzaroVar.zze()) {
                if (zzarmVar2 instanceof zzarp) {
                    zzarpVar = (zzarp) zzarmVar2;
                    break;
                }
            }
            long jZzd = (zzarpVar.zzd() * 1000) / zzarpVar.zze();
            this.zza = jZzd;
            return jZzd;
        } catch (IOException | RuntimeException unused) {
            return 0L;
        }
    }
}
