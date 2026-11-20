package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzes {
    final /* synthetic */ zzew zza;
    private final String zzb;
    private final long zzc;
    private boolean zzd;
    private long zze;

    public zzes(zzew zzewVar, String str, long j11) {
        this.zza = zzewVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = j11;
    }

    public final long zza() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getLong(this.zzb, this.zzc);
        }
        return this.zze;
    }

    public final void zzb(long j11) {
        SharedPreferences.Editor editorEdit = this.zza.zza().edit();
        editorEdit.putLong(this.zzb, j11);
        editorEdit.apply();
        this.zze = j11;
    }
}
