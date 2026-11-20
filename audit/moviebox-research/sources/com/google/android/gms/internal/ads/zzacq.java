package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.amazonaws.services.s3.model.InstructionFileId;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzacq {
    public final String zza;

    private zzacq(int i11, int i12, String str) {
        this.zza = str;
    }

    @Nullable
    public static zzacq zza(zzfp zzfpVar) {
        String str;
        zzfpVar.zzL(2);
        int iZzm = zzfpVar.zzm();
        int i11 = iZzm >> 1;
        int i12 = iZzm & 1;
        int iZzm2 = zzfpVar.zzm() >> 3;
        if (i11 == 4 || i11 == 5 || i11 == 7) {
            str = "dvhe";
        } else if (i11 == 8) {
            str = "hev1";
        } else {
            if (i11 != 9) {
                return null;
            }
            str = "avc3";
        }
        int i13 = iZzm2 | (i12 << 5);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append(".0");
        sb2.append(i11);
        sb2.append(i13 >= 10 ? InstructionFileId.DOT : ".0");
        sb2.append(i13);
        return new zzacq(i11, i13, sb2.toString());
    }
}
