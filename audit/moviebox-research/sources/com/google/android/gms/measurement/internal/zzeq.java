package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeq {
    final /* synthetic */ zzew zza;
    private final String zzb;
    private final boolean zzc;
    private boolean zzd;
    private boolean zze;

    public zzeq(zzew zzewVar, String str, boolean z11) {
        this.zza = zzewVar;
        Preconditions.checkNotEmpty(str);
        this.zzb = str;
        this.zzc = z11;
    }

    public final void zza(boolean z11) {
        SharedPreferences.Editor editorEdit = this.zza.zza().edit();
        editorEdit.putBoolean(this.zzb, z11);
        editorEdit.apply();
        this.zze = z11;
    }

    public final boolean zzb() {
        if (!this.zzd) {
            this.zzd = true;
            this.zze = this.zza.zza().getBoolean(this.zzb, this.zzc);
        }
        return this.zze;
    }
}
