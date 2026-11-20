package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzafb extends zzafg {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafb(zzaea zzaeaVar) {
        super(zzaeaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zza(zzfp zzfpVar) throws zzaff {
        if (this.zzc) {
            zzfpVar.zzL(1);
        } else {
            int iZzm = zzfpVar.zzm();
            int i11 = iZzm >> 4;
            this.zze = i11;
            if (i11 == 2) {
                int i12 = zzb[(iZzm >> 2) & 3];
                zzak zzakVar = new zzak();
                zzakVar.zzW(MimeTypes.AUDIO_MPEG);
                zzakVar.zzy(1);
                zzakVar.zzX(i12);
                this.zza.zzl(zzakVar.zzac());
                this.zzd = true;
            } else if (i11 == 7 || i11 == 8) {
                zzak zzakVar2 = new zzak();
                zzakVar2.zzW(i11 == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW);
                zzakVar2.zzy(1);
                zzakVar2.zzX(8000);
                this.zza.zzl(zzakVar2.zzac());
                this.zzd = true;
            } else if (i11 != 10) {
                throw new zzaff("Audio format not supported: " + i11);
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafg
    public final boolean zzb(zzfp zzfpVar, long j11) throws zzcc {
        if (this.zze == 2) {
            int iZzb = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, iZzb);
            this.zza.zzt(j11, 1, iZzb, 0, null);
            return true;
        }
        int iZzm = zzfpVar.zzm();
        if (iZzm != 0 || this.zzd) {
            if (this.zze == 10 && iZzm != 1) {
                return false;
            }
            int iZzb2 = zzfpVar.zzb();
            this.zza.zzr(zzfpVar, iZzb2);
            this.zza.zzt(j11, 1, iZzb2, 0, null);
            return true;
        }
        int iZzb3 = zzfpVar.zzb();
        byte[] bArr = new byte[iZzb3];
        zzfpVar.zzG(bArr, 0, iZzb3);
        zzabr zzabrVarZza = zzabs.zza(bArr);
        zzak zzakVar = new zzak();
        zzakVar.zzW(MimeTypes.AUDIO_AAC);
        zzakVar.zzz(zzabrVarZza.zzc);
        zzakVar.zzy(zzabrVarZza.zzb);
        zzakVar.zzX(zzabrVarZza.zza);
        zzakVar.zzL(Collections.singletonList(bArr));
        this.zza.zzl(zzakVar.zzac());
        this.zzd = true;
        return false;
    }
}
