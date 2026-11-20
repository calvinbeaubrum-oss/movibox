package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanz {
    private final List zza;
    private final zzaea[] zzb;

    public zzanz(List list) {
        this.zza = list;
        this.zzb = new zzaea[list.size()];
    }

    public final void zza(long j11, zzfp zzfpVar) {
        zzach.zza(j11, zzfpVar, this.zzb);
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
            String strZzb = zzamVar.zzb;
            if (strZzb == null) {
                strZzb = zzaokVar.zzb();
            }
            zzak zzakVar = new zzak();
            zzakVar.zzK(strZzb);
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
