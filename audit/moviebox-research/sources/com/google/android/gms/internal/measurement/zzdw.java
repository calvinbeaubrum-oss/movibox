package com.google.android.gms.internal.measurement;

import android.os.Bundle;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzdw extends zzch {
    private final com.google.android.gms.measurement.internal.zzgs zza;

    public zzdw(com.google.android.gms.measurement.internal.zzgs zzgsVar) {
        this.zza = zzgsVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final int zzd() {
        return System.identityHashCode(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzci
    public final void zze(String str, String str2, Bundle bundle, long j11) {
        this.zza.onEvent(str, str2, bundle, j11);
    }
}
