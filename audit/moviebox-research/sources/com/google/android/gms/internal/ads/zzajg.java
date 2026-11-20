package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajg {
    public final zzajm zza;
    public final zzajp zzb;
    public final zzaea zzc;

    @Nullable
    public final zzaeb zzd;
    public int zze;

    public zzajg(zzajm zzajmVar, zzajp zzajpVar, zzaea zzaeaVar) {
        this.zza = zzajmVar;
        this.zzb = zzajpVar;
        this.zzc = zzaeaVar;
        this.zzd = MimeTypes.AUDIO_TRUEHD.equals(zzajmVar.zzf.zzm) ? new zzaeb() : null;
    }
}
