package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaqt {
    long zza;
    final String zzb;
    final String zzc;
    final long zzd;
    final long zze;
    final long zzf;
    final long zzg;
    final List zzh;

    /* JADX WARN: Illegal instructions before constructor call */
    public zzaqt(String str, zzapj zzapjVar) {
        String str2 = zzapjVar.zzb;
        long j11 = zzapjVar.zzc;
        long j12 = zzapjVar.zzd;
        long j13 = zzapjVar.zze;
        long j14 = zzapjVar.zzf;
        List arrayList = zzapjVar.zzh;
        if (arrayList == null) {
            Map map = zzapjVar.zzg;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new zzaps((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j11, j12, j13, j14, arrayList);
    }

    private zzaqt(String str, String str2, long j11, long j12, long j13, long j14, List list) {
        this.zzb = str;
        this.zzc = true == "".equals(str2) ? null : str2;
        this.zzd = j11;
        this.zze = j12;
        this.zzf = j13;
        this.zzg = j14;
        this.zzh = list;
    }

    public static zzaqt zza(zzaqu zzaquVar) throws IOException {
        if (zzaqw.zze(zzaquVar) != 538247942) {
            throw new IOException();
        }
        String strZzh = zzaqw.zzh(zzaquVar);
        String strZzh2 = zzaqw.zzh(zzaquVar);
        long jZzf = zzaqw.zzf(zzaquVar);
        long jZzf2 = zzaqw.zzf(zzaquVar);
        long jZzf3 = zzaqw.zzf(zzaquVar);
        long jZzf4 = zzaqw.zzf(zzaquVar);
        int iZze = zzaqw.zze(zzaquVar);
        if (iZze < 0) {
            throw new IOException("readHeaderList size=" + iZze);
        }
        List listEmptyList = iZze == 0 ? Collections.emptyList() : new ArrayList();
        for (int i11 = 0; i11 < iZze; i11++) {
            listEmptyList.add(new zzaps(zzaqw.zzh(zzaquVar).intern(), zzaqw.zzh(zzaquVar).intern()));
        }
        return new zzaqt(strZzh, strZzh2, jZzf, jZzf2, jZzf3, jZzf4, listEmptyList);
    }
}
