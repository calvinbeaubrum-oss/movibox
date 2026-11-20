package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaln {
    private static final Pattern zzd = Pattern.compile("\\s+");
    private static final zzgaf zze = zzgaf.zzp("auto", DevicePublicKeyStringDef.NONE);
    private static final zzgaf zzf = zzgaf.zzq("dot", "sesame", "circle");
    private static final zzgaf zzg = zzgaf.zzp("filled", "open");
    private static final zzgaf zzh = zzgaf.zzq("after", "before", "outside");
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaln(int i11, int i12, int i13) {
        this.zza = i11;
        this.zzb = i12;
        this.zzc = i13;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x004e  */
    @Nullable
    public static zzaln zza(@Nullable String str) {
        byte b11;
        int i11;
        if (str == null) {
            return null;
        }
        String strZza = zzfwk.zza(str.trim());
        if (strZza.isEmpty()) {
            return null;
        }
        zzgaf zzgafVarZzm = zzgaf.zzm(TextUtils.split(strZza, zzd));
        String str2 = (String) zzgag.zza(zzgca.zzb(zzh, zzgafVarZzm), "outside");
        int iHashCode = str2.hashCode();
        int i12 = -1;
        int i13 = 0;
        if (iHashCode != -1106037339) {
            if (iHashCode == 92734940 && str2.equals("after")) {
                b11 = 0;
            } else {
                b11 = -1;
            }
        } else if (str2.equals("outside")) {
            b11 = 1;
        } else {
            b11 = -1;
        }
        if (b11 != 0) {
            i11 = b11 != 1 ? 1 : -2;
        } else {
            i11 = 2;
        }
        zzgbz zzgbzVarZzb = zzgca.zzb(zze, zzgafVarZzm);
        if (zzgbzVarZzb.isEmpty()) {
            zzgbz zzgbzVarZzb2 = zzgca.zzb(zzg, zzgafVarZzm);
            zzgbz zzgbzVarZzb3 = zzgca.zzb(zzf, zzgafVarZzm);
            if (!zzgbzVarZzb2.isEmpty() || !zzgbzVarZzb3.isEmpty()) {
                String str3 = (String) zzgag.zza(zzgbzVarZzb2, "filled");
                int i14 = (str3.hashCode() == 3417674 && str3.equals("open")) ? 2 : 1;
                String str4 = (String) zzgag.zza(zzgbzVarZzb3, "circle");
                int iHashCode2 = str4.hashCode();
                if (iHashCode2 != -905816648) {
                    if (iHashCode2 == 99657 && str4.equals("dot")) {
                        i12 = 0;
                    }
                } else if (str4.equals("sesame")) {
                    i12 = 1;
                }
                if (i12 == 0) {
                    i13 = i14;
                    i12 = 2;
                } else if (i12 != 1) {
                    i13 = i14;
                    i12 = 1;
                } else {
                    i12 = 3;
                    i13 = i14;
                }
            }
        } else {
            String str5 = (String) zzgbzVarZzb.iterator().next();
            if (str5.hashCode() == 3387192 && str5.equals(DevicePublicKeyStringDef.NONE)) {
                i12 = 0;
            }
        }
        return new zzaln(i12, i13, i11);
    }
}
