package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamn implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzamm
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzamn()};
        }
    };
    private final zzamo zzb = new zzamo(null);
    private final zzfp zzc = new zzfp(2786);
    private boolean zzd;

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int iZza = zzacvVar.zza(this.zzc.zzM(), 0, 2786);
        if (iZza == -1) {
            return -1;
        }
        this.zzc.zzK(0);
        this.zzc.zzJ(iZza);
        if (!this.zzd) {
            this.zzb.zzd(0L, 4);
            this.zzd = true;
        }
        this.zzb.zza(this.zzc);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzb.zzb(zzacxVar, new zzaok(Integer.MIN_VALUE, 0, 1));
        zzacxVar.zzD();
        zzacxVar.zzO(new zzadt(C.TIME_UNSET, 0L));
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzd = false;
        this.zzb.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        zzfp zzfpVar = new zzfp(10);
        int i11 = 0;
        while (true) {
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(zzfpVar.zzM(), 0, 10, false);
            zzfpVar.zzK(0);
            if (zzfpVar.zzo() != 4801587) {
                break;
            }
            zzfpVar.zzL(3);
            int iZzl = zzfpVar.zzl();
            i11 += iZzl + 10;
            zzackVar.zzl(iZzl, false);
        }
        zzacvVar.zzj();
        zzack zzackVar2 = (zzack) zzacvVar;
        zzackVar2.zzl(i11, false);
        int i12 = i11;
        while (true) {
            int i13 = 0;
            while (true) {
                zzackVar2.zzm(zzfpVar.zzM(), 0, 6, false);
                zzfpVar.zzK(0);
                if (zzfpVar.zzq() != 2935) {
                    break;
                }
                i13++;
                if (i13 >= 4) {
                    return true;
                }
                int iZzb = zzabv.zzb(zzfpVar.zzM());
                if (iZzb == -1) {
                    return false;
                }
                zzackVar2.zzl(iZzb - 6, false);
            }
            zzacvVar.zzj();
            i12++;
            if (i12 - i11 >= 8192) {
                return false;
            }
            zzackVar2.zzl(i12, false);
        }
    }
}
