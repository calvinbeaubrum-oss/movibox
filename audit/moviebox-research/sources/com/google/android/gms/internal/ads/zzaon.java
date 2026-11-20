package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaon {
    private final List zza;
    private final zzaea[] zzb;

    public zzaon(List list) {
        this.zza = list;
        this.zzb = new zzaea[list.size()];
    }

    public final void zza(long j11, zzfp zzfpVar) {
        if (zzfpVar.zzb() < 9) {
            return;
        }
        int iZzg = zzfpVar.zzg();
        int iZzg2 = zzfpVar.zzg();
        int iZzm = zzfpVar.zzm();
        if (iZzg == 434 && iZzg2 == 1195456820 && iZzm == 3) {
            zzach.zzb(j11, zzfpVar, this.zzb);
        }
    }

    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        for (int i11 = 0; i11 < this.zzb.length; i11++) {
            zzaokVar.zzc();
            zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 3);
            zzam zzamVar = (zzam) this.zza.get(i11);
            String str = zzamVar.zzm;
            boolean z11 = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str) && !MimeTypes.APPLICATION_CEA708.equals(str)) {
                z11 = false;
            }
            zzek.zze(z11, "Invalid closed caption MIME type provided: ".concat(String.valueOf(str)));
            zzak zzakVar = new zzak();
            zzakVar.zzK(zzaokVar.zzb());
            zzakVar.zzW(str);
            zzakVar.zzY(zzamVar.zze);
            zzakVar.zzN(zzamVar.zzd);
            zzakVar.zzw(zzamVar.zzE);
            zzakVar.zzL(zzamVar.zzo);
            zzaeaVarZzw.zzl(zzakVar.zzac());
            this.zzb[i11] = zzaeaVarZzw;
        }
    }
}
