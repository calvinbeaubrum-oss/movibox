package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzesl implements zzexp {
    private final com.google.android.gms.ads.internal.client.zzw zza;
    private final zzcei zzb;
    private final boolean zzc;

    public zzesl(com.google.android.gms.ads.internal.client.zzw zzwVar, zzcei zzceiVar, boolean z11) {
        this.zza = zzwVar;
        this.zzb = zzceiVar;
        this.zzc = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzexp
    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzb.zzc >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfh)).intValue()) {
            bundle.putString("app_open_version", "2");
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfi)).booleanValue()) {
            bundle.putBoolean("app_switched", this.zzc);
        }
        com.google.android.gms.ads.internal.client.zzw zzwVar = this.zza;
        if (zzwVar != null) {
            int i11 = zzwVar.zza;
            if (i11 == 1) {
                bundle.putString("avo", TtmlNode.TAG_P);
            } else if (i11 == 2) {
                bundle.putString("avo", "l");
            }
        }
    }
}
