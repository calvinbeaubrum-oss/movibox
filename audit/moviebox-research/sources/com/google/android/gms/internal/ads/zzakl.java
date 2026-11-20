package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzakl {
    public static void zza(zzakm zzakmVar, zzakq zzakqVar, zzep zzepVar) {
        for (int i11 = 0; i11 < zzakmVar.zza(); i11++) {
            long jZzb = zzakmVar.zzb(i11);
            List listZzc = zzakmVar.zzc(jZzb);
            if (!listZzc.isEmpty()) {
                if (i11 == zzakmVar.zza() - 1) {
                    throw new IllegalStateException();
                }
                zzepVar.zza(new zzakj(listZzc, jZzb, zzakmVar.zzb(i11 + 1) - zzakmVar.zzb(i11)));
            }
        }
    }
}
