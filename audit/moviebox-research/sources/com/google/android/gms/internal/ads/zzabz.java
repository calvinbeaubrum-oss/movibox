package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabz {
    public final List zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final int zzh;
    public final int zzi;
    public final float zzj;

    @Nullable
    public final String zzk;

    private zzabz(List list, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, float f11, @Nullable String str) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = i12;
        this.zzd = i13;
        this.zze = i14;
        this.zzf = i15;
        this.zzg = i16;
        this.zzh = i17;
        this.zzi = i18;
        this.zzj = f11;
        this.zzk = str;
    }

    public static zzabz zza(zzfp zzfpVar) throws zzcc {
        String strZza;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        float f11;
        try {
            zzfpVar.zzL(4);
            int iZzm = zzfpVar.zzm() & 3;
            int i18 = iZzm + 1;
            if (i18 == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iZzm2 = zzfpVar.zzm() & 31;
            for (int i19 = 0; i19 < iZzm2; i19++) {
                arrayList.add(zzb(zzfpVar));
            }
            int iZzm3 = zzfpVar.zzm();
            for (int i21 = 0; i21 < iZzm3; i21++) {
                arrayList.add(zzb(zzfpVar));
            }
            if (iZzm2 > 0) {
                zzgl zzglVarZze = zzgm.zze((byte[]) arrayList.get(0), iZzm + 2, ((byte[]) arrayList.get(0)).length);
                int i22 = zzglVarZze.zze;
                int i23 = zzglVarZze.zzf;
                int i24 = zzglVarZze.zzh + 8;
                int i25 = zzglVarZze.zzi + 8;
                int i26 = zzglVarZze.zzj;
                int i27 = zzglVarZze.zzk;
                int i28 = zzglVarZze.zzl;
                float f12 = zzglVarZze.zzg;
                strZza = zzem.zza(zzglVarZze.zza, zzglVarZze.zzb, zzglVarZze.zzc);
                i16 = i27;
                i17 = i28;
                f11 = f12;
                i13 = i24;
                i14 = i25;
                i15 = i26;
                i11 = i22;
                i12 = i23;
            } else {
                strZza = null;
                i11 = -1;
                i12 = -1;
                i13 = -1;
                i14 = -1;
                i15 = -1;
                i16 = -1;
                i17 = -1;
                f11 = 1.0f;
            }
            return new zzabz(arrayList, i18, i11, i12, i13, i14, i15, i16, i17, f11, strZza);
        } catch (ArrayIndexOutOfBoundsException e11) {
            throw zzcc.zza("Error parsing AVC config", e11);
        }
    }

    private static byte[] zzb(zzfp zzfpVar) {
        int iZzq = zzfpVar.zzq();
        int iZzd = zzfpVar.zzd();
        zzfpVar.zzL(iZzq);
        return zzem.zzc(zzfpVar.zzM(), iZzd, iZzq);
    }
}
