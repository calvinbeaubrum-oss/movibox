package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaey extends zzacg {
    public zzaey(final zzadh zzadhVar, int i11, long j11, long j12) {
        long j13;
        Objects.requireNonNull(zzadhVar);
        zzacd zzacdVar = new zzacd() { // from class: com.google.android.gms.internal.ads.zzaev
            @Override // com.google.android.gms.internal.ads.zzacd
            public final long zza(long j14) {
                return zzadhVar.zzb(j14);
            }
        };
        zzaex zzaexVar = new zzaex(zzadhVar, i11, null);
        long jZza = zzadhVar.zza();
        long j14 = zzadhVar.zzj;
        int i12 = zzadhVar.zzd;
        if (i12 > 0) {
            j13 = ((((long) i12) + ((long) zzadhVar.zzc)) / 2) + 1;
        } else {
            int i13 = zzadhVar.zza;
            int i14 = zzadhVar.zzb;
            long j15 = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            if (i13 == i14 && i13 > 0) {
                j15 = i13;
            }
            j13 = (((j15 * ((long) zzadhVar.zzg)) * ((long) zzadhVar.zzh)) / 8) + 64;
        }
        super(zzacdVar, zzaexVar, jZza, 0L, j14, j11, j12, j13, Math.max(6, zzadhVar.zzc));
    }
}
