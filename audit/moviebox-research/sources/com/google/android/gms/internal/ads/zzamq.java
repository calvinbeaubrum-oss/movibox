package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzamq implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzamp
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzamq()};
        }
    };
    private final zzamr zzb = new zzamr(null);
    private final zzfp zzc = new zzfp(16384);
    private boolean zzd;

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        int iZza = zzacvVar.zza(this.zzc.zzM(), 0, 16384);
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
        int i11;
        zzfp zzfpVar = new zzfp(10);
        int i12 = 0;
        while (true) {
            zzack zzackVar = (zzack) zzacvVar;
            zzackVar.zzm(zzfpVar.zzM(), 0, 10, false);
            zzfpVar.zzK(0);
            if (zzfpVar.zzo() != 4801587) {
                break;
            }
            zzfpVar.zzL(3);
            int iZzl = zzfpVar.zzl();
            i12 += iZzl + 10;
            zzackVar.zzl(iZzl, false);
        }
        zzacvVar.zzj();
        zzack zzackVar2 = (zzack) zzacvVar;
        zzackVar2.zzl(i12, false);
        int i13 = i12;
        while (true) {
            int i14 = 0;
            while (true) {
                int i15 = 7;
                zzackVar2.zzm(zzfpVar.zzM(), 0, 7, false);
                zzfpVar.zzK(0);
                int iZzq = zzfpVar.zzq();
                if (iZzq == 44096 || iZzq == 44097) {
                    i14++;
                    if (i14 >= 4) {
                        return true;
                    }
                    byte[] bArrZzM = zzfpVar.zzM();
                    int i16 = zzaby.zza;
                    if (bArrZzM.length < 7) {
                        i11 = -1;
                    } else {
                        int i17 = ((bArrZzM[2] & 255) << 8) | (bArrZzM[3] & 255);
                        if (i17 == 65535) {
                            i17 = ((bArrZzM[4] & 255) << 16) | ((bArrZzM[5] & 255) << 8) | (bArrZzM[6] & 255);
                        } else {
                            i15 = 4;
                        }
                        if (iZzq == 44097) {
                            i15 += 2;
                        }
                        i11 = i17 + i15;
                    }
                    if (i11 == -1) {
                        return false;
                    }
                    zzackVar2.zzl(i11 - 7, false);
                }
            }
            zzacvVar.zzj();
            i13++;
            if (i13 - i12 >= 8192) {
                return false;
            }
            zzackVar2.zzl(i13, false);
        }
    }
}
