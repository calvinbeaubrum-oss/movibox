package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzccl implements SharedPreferences.OnSharedPreferenceChangeListener {
    final /* synthetic */ zzccm zza;
    private final String zzb;

    public zzccl(zzccm zzccmVar, String str) {
        this.zza = zzccmVar;
        this.zzb = str;
    }

    @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zza) {
            try {
                for (zzcck zzcckVar : this.zza.zzb) {
                    zzcckVar.zza.zzb(zzcckVar.zzb, sharedPreferences, this.zzb, str);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
