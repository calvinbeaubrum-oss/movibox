package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazu {
    private final int zza;
    private final zzazr zzb = new zzazw();

    public zzazu(int i11) {
        this.zza = i11;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append(((String) arrayList.get(i11)).toLowerCase(Locale.US));
            sb2.append('\n');
        }
        String[] strArrSplit = sb2.toString().split("\n");
        if (strArrSplit.length == 0) {
            return "";
        }
        zzazt zzaztVar = new zzazt();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzazs(this));
        for (String str : strArrSplit) {
            String[] strArrZzb = zzazv.zzb(str, false);
            if (strArrZzb.length != 0) {
                zzazz.zzc(strArrZzb, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzaztVar.zzb.write(this.zzb.zzb(((zzazy) it.next()).zzb));
            } catch (IOException e11) {
                zzcec.zzh("Error while writing hash to byteStream", e11);
            }
        }
        return zzaztVar.toString();
    }
}
