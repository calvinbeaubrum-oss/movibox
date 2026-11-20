package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadm {
    private final zzfp zza = new zzfp(10);

    @Nullable
    public final zzby zza(zzacv zzacvVar, @Nullable zzago zzagoVar) throws IOException {
        zzby zzbyVarZza = null;
        int i11 = 0;
        while (true) {
            try {
                ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 10, false);
                this.zza.zzK(0);
                if (this.zza.zzo() != 4801587) {
                    break;
                }
                this.zza.zzL(3);
                int iZzl = this.zza.zzl();
                int i12 = iZzl + 10;
                if (zzbyVarZza == null) {
                    byte[] bArr = new byte[i12];
                    System.arraycopy(this.zza.zzM(), 0, bArr, 0, 10);
                    ((zzack) zzacvVar).zzm(bArr, 10, iZzl, false);
                    zzbyVarZza = zzagq.zza(bArr, i12, zzagoVar, new zzafr());
                } else {
                    ((zzack) zzacvVar).zzl(iZzl, false);
                }
                i11 += i12;
            } catch (EOFException unused) {
            }
        }
        zzacvVar.zzj();
        ((zzack) zzacvVar).zzl(i11, false);
        return zzbyVarZza;
    }
}
