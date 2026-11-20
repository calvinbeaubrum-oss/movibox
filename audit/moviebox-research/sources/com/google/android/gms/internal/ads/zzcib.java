package com.google.android.gms.internal.ads;

import com.bumptech.glide.integration.cronet.BufferQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcib {
    private final ArrayList zza = new ArrayList();
    private long zzb;

    public final long zza() {
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            for (Map.Entry entry : ((zzhj) it.next()).zze().entrySet()) {
                try {
                    if (BufferQueue.CONTENT_LENGTH.equalsIgnoreCase((String) entry.getKey())) {
                        this.zzb = Math.max(this.zzb, Long.parseLong((String) ((List) entry.getValue()).get(0)));
                    }
                } catch (RuntimeException unused) {
                }
            }
            it.remove();
        }
        return this.zzb;
    }

    public final void zzb(zzhj zzhjVar) {
        this.zza.add(zzhjVar);
    }
}
