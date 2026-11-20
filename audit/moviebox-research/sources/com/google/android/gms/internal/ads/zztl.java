package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@RequiresApi(21)
final class zztl implements zzti {
    private final int zza;

    @Nullable
    private MediaCodecInfo[] zzb;

    public zztl(boolean z11, boolean z12) {
        int i11 = 1;
        if (!z11 && !z12) {
            i11 = 0;
        }
        this.zza = i11;
    }

    private final void zzf() {
        if (this.zzb == null) {
            this.zzb = new MediaCodecList(this.zza).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final int zza() {
        zzf();
        return this.zzb.length;
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final MediaCodecInfo zzb(int i11) {
        zzf();
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zzc(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureRequired(str);
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zzd(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported(str);
    }

    @Override // com.google.android.gms.internal.ads.zzti
    public final boolean zze() {
        return true;
    }
}
