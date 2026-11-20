package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzadk {
    private static final Pattern zzc = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int zza = -1;
    public int zzb = -1;

    private final boolean zzc(String str) {
        Matcher matcher = zzc.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            String strGroup = matcher.group(1);
            int i11 = zzfy.zza;
            int i12 = Integer.parseInt(strGroup, 16);
            int i13 = Integer.parseInt(matcher.group(2), 16);
            if (i12 <= 0 && i13 <= 0) {
                return false;
            }
            this.zza = i12;
            this.zzb = i13;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public final boolean zza() {
        return (this.zza == -1 || this.zzb == -1) ? false : true;
    }

    public final boolean zzb(zzby zzbyVar) {
        for (int i11 = 0; i11 < zzbyVar.zza(); i11++) {
            zzbx zzbxVarZzb = zzbyVar.zzb(i11);
            if (zzbxVarZzb instanceof zzagk) {
                zzagk zzagkVar = (zzagk) zzbxVarZzb;
                if ("iTunSMPB".equals(zzagkVar.zzb) && zzc(zzagkVar.zzc)) {
                    return true;
                }
            } else if (zzbxVarZzb instanceof zzagt) {
                zzagt zzagtVar = (zzagt) zzbxVarZzb;
                if ("com.apple.iTunes".equals(zzagtVar.zza) && "iTunSMPB".equals(zzagtVar.zzb) && zzc(zzagtVar.zzc)) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return false;
    }
}
