package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaeg {
    public static int zza(int i11) {
        int i12 = 0;
        while (i11 > 0) {
            i11 >>>= 1;
            i12++;
        }
        return i12;
    }

    @Nullable
    public static zzby zzb(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < list.size(); i11++) {
            String str = (String) list.get(i11);
            int i12 = zzfy.zza;
            String[] strArrSplit = str.split("=", 2);
            if (strArrSplit.length != 2) {
                zzff.zzf("VorbisUtil", "Failed to parse Vorbis comment: ".concat(str));
            } else if (strArrSplit[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(zzafw.zzb(new zzfp(Base64.decode(strArrSplit[1], 0))));
                } catch (RuntimeException e11) {
                    zzff.zzg("VorbisUtil", "Failed to parse vorbis picture", e11);
                }
            } else {
                arrayList.add(new zzaho(strArrSplit[0], strArrSplit[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzby(arrayList);
    }

    public static zzaed zzc(zzfp zzfpVar, boolean z11, boolean z12) throws zzcc {
        if (z11) {
            zzd(3, zzfpVar, false);
        }
        String strZzA = zzfpVar.zzA((int) zzfpVar.zzs(), zzfwq.zzc);
        int length = strZzA.length();
        long jZzs = zzfpVar.zzs();
        String[] strArr = new String[(int) jZzs];
        int length2 = length + 15;
        for (int i11 = 0; i11 < jZzs; i11++) {
            String strZzA2 = zzfpVar.zzA((int) zzfpVar.zzs(), zzfwq.zzc);
            strArr[i11] = strZzA2;
            length2 = length2 + 4 + strZzA2.length();
        }
        if (z12 && (zzfpVar.zzm() & 1) == 0) {
            throw zzcc.zza("framing bit expected to be set", null);
        }
        return new zzaed(strZzA, strArr, length2 + 1);
    }

    public static boolean zzd(int i11, zzfp zzfpVar, boolean z11) throws zzcc {
        if (zzfpVar.zzb() < 7) {
            if (z11) {
                return false;
            }
            throw zzcc.zza("too short header: " + zzfpVar.zzb(), null);
        }
        if (zzfpVar.zzm() != i11) {
            if (z11) {
                return false;
            }
            throw zzcc.zza("expected header type ".concat(String.valueOf(Integer.toHexString(i11))), null);
        }
        if (zzfpVar.zzm() == 118 && zzfpVar.zzm() == 111 && zzfpVar.zzm() == 114 && zzfpVar.zzm() == 98 && zzfpVar.zzm() == 105 && zzfpVar.zzm() == 115) {
            return true;
        }
        if (z11) {
            return false;
        }
        throw zzcc.zza("expected characters 'vorbis'", null);
    }
}
