package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqa extends Exception {
    public final int zza;
    public final boolean zzb;
    public final zzam zzc;

    public zzqa(int i11, zzam zzamVar, boolean z11) {
        super("AudioTrack write failed: " + i11);
        this.zzb = z11;
        this.zza = i11;
        this.zzc = zzamVar;
    }
}
