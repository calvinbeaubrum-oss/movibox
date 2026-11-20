package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalx implements zzakr {
    private final zzfp zza = new zzfp();

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        zzec zzecVarZzp;
        this.zza.zzI(bArr, i12 + i11);
        this.zza.zzK(i11);
        ArrayList arrayList = new ArrayList();
        while (true) {
            zzfp zzfpVar = this.zza;
            if (zzfpVar.zzb() <= 0) {
                zzepVar.zza(new zzakj(arrayList, C.TIME_UNSET, C.TIME_UNSET));
                return;
            }
            zzek.zze(zzfpVar.zzb() >= 8, "Incomplete Mp4Webvtt Top Level box header found.");
            zzfp zzfpVar2 = this.zza;
            int iZzg = zzfpVar2.zzg() - 8;
            if (zzfpVar2.zzg() == 1987343459) {
                zzfp zzfpVar3 = this.zza;
                CharSequence charSequenceZza = null;
                zzea zzeaVarZzb = null;
                while (iZzg > 0) {
                    zzek.zze(iZzg >= 8, "Incomplete vtt cue box header found.");
                    int iZzg2 = zzfpVar3.zzg();
                    int iZzg3 = zzfpVar3.zzg();
                    int i13 = iZzg - 8;
                    int i14 = iZzg2 - 8;
                    String strZzA = zzfy.zzA(zzfpVar3.zzM(), zzfpVar3.zzd(), i14);
                    zzfpVar3.zzL(i14);
                    if (iZzg3 == 1937011815) {
                        zzeaVarZzb = zzamh.zzb(strZzA);
                    } else if (iZzg3 == 1885436268) {
                        charSequenceZza = zzamh.zza(null, strZzA.trim(), Collections.emptyList());
                    }
                    iZzg = i13 - i14;
                }
                if (charSequenceZza == null) {
                    charSequenceZza = "";
                }
                if (zzeaVarZzb != null) {
                    zzeaVarZzb.zzl(charSequenceZza);
                    zzecVarZzp = zzeaVarZzb.zzp();
                } else {
                    zzamg zzamgVar = new zzamg();
                    zzamgVar.zzc = charSequenceZza;
                    zzecVarZzp = zzamgVar.zza().zzp();
                }
                arrayList.add(zzecVarZzp);
            } else {
                this.zza.zzL(iZzg);
            }
        }
    }
}
