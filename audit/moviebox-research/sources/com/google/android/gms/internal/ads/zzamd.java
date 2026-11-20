package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzamd {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzamb
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Integer.compare(((zzamd) obj).zzb.zzb, ((zzamd) obj2).zzb.zzb);
        }
    };
    private final zzame zzb;
    private final int zzc;

    public /* synthetic */ zzamd(zzame zzameVar, int i11, zzamc zzamcVar) {
        this.zzb = zzameVar;
        this.zzc = i11;
    }
}
