package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpx extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzpx(int i11, int i12, int i13, int i14, zzam zzamVar, boolean z11, @Nullable Exception exc) {
        String strValueOf = String.valueOf(zzamVar);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("AudioTrack init failed ");
        sb2.append(i11);
        sb2.append(" Config(");
        sb2.append(i12);
        sb2.append(", ");
        sb2.append(i13);
        sb2.append(", ");
        sb2.append(i14);
        sb2.append(") ");
        sb2.append(strValueOf);
        sb2.append(true != z11 ? "" : " (recoverable)");
        super(sb2.toString(), exc);
        this.zza = i11;
        this.zzb = z11;
        this.zzc = zzamVar;
    }
}
