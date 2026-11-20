package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaim extends zzaio {
    public final long zza;
    public final List zzb;
    public final List zzc;

    public zzaim(int i11, long j11) {
        super(i11);
        this.zza = j11;
        this.zzb = new ArrayList();
        this.zzc = new ArrayList();
    }

    @Override // com.google.android.gms.internal.ads.zzaio
    public final String toString() {
        List list = this.zzb;
        return zzaio.zzf(this.zzd) + " leaves: " + Arrays.toString(list.toArray()) + " containers: " + Arrays.toString(this.zzc.toArray());
    }

    @Nullable
    public final zzaim zza(int i11) {
        int size = this.zzc.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzaim zzaimVar = (zzaim) this.zzc.get(i12);
            if (zzaimVar.zzd == i11) {
                return zzaimVar;
            }
        }
        return null;
    }

    @Nullable
    public final zzain zzb(int i11) {
        int size = this.zzb.size();
        for (int i12 = 0; i12 < size; i12++) {
            zzain zzainVar = (zzain) this.zzb.get(i12);
            if (zzainVar.zzd == i11) {
                return zzainVar;
            }
        }
        return null;
    }

    public final void zzc(zzaim zzaimVar) {
        this.zzc.add(zzaimVar);
    }

    public final void zzd(zzain zzainVar) {
        this.zzb.add(zzainVar);
    }
}
