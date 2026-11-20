package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaml implements zzakm {
    private final List zza;
    private final long[] zzb;
    private final long[] zzc;

    public zzaml(List list) {
        this.zza = Collections.unmodifiableList(new ArrayList(list));
        int size = list.size();
        this.zzb = new long[size + size];
        for (int i11 = 0; i11 < list.size(); i11++) {
            zzama zzamaVar = (zzama) list.get(i11);
            long[] jArr = this.zzb;
            int i12 = i11 + i11;
            jArr[i12] = zzamaVar.zzb;
            jArr[i12 + 1] = zzamaVar.zzc;
        }
        long[] jArr2 = this.zzb;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.zzc = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final int zza() {
        return this.zzc.length;
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final long zzb(int i11) {
        zzek.zzd(i11 >= 0);
        zzek.zzd(i11 < this.zzc.length);
        return this.zzc[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzakm
    public final List zzc(long j11) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < this.zza.size(); i11++) {
            long[] jArr = this.zzb;
            int i12 = i11 + i11;
            if (jArr[i12] <= j11 && j11 < jArr[i12 + 1]) {
                zzama zzamaVar = (zzama) this.zza.get(i11);
                zzec zzecVar = zzamaVar.zza;
                if (zzecVar.zzg == -3.4028235E38f) {
                    arrayList2.add(zzamaVar);
                } else {
                    arrayList.add(zzecVar);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.google.android.gms.internal.ads.zzamk
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((zzama) obj).zzb, ((zzama) obj2).zzb);
            }
        });
        for (int i13 = 0; i13 < arrayList2.size(); i13++) {
            zzea zzeaVarZzb = ((zzama) arrayList2.get(i13)).zza.zzb();
            zzeaVarZzb.zze((-1) - i13, 1);
            arrayList.add(zzeaVarZzb.zzp());
        }
        return arrayList;
    }
}
