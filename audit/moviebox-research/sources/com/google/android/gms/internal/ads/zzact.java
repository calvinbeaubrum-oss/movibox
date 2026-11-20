package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzact implements zzaea {
    private final byte[] zza = new byte[4096];

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ int zzf(zzu zzuVar, int i11, boolean z11) {
        return zzady.zza(this, zzuVar, i11, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final int zzg(zzu zzuVar, int i11, boolean z11, int i12) throws IOException {
        int iZza = zzuVar.zza(this.zza, 0, Math.min(4096, i11));
        if (iZza != -1) {
            return iZza;
        }
        if (z11) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzl(zzam zzamVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ void zzr(zzfp zzfpVar, int i11) {
        zzady.zzb(this, zzfpVar, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzs(zzfp zzfpVar, int i11, int i12) {
        zzfpVar.zzL(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzt(long j11, int i11, int i12, int i13, @Nullable zzadz zzadzVar) {
    }
}
