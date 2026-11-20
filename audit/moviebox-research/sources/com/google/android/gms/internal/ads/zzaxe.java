package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxe extends zzaxx {
    private final Map zzi;
    private final View zzj;
    private final Context zzk;

    public zzaxe(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, Map map, View view, Context context) {
        super(zzawjVar, "DNq6U+mZz2ZReiKgjo/VDFnaMNaZiKgTjVzJ4/NswvXzkfhe/AgU2N86qSmmEbDf", "ZzhYXgKMhken/ic2sDR8A53WLOTMzsBN7DfnMjKoyhk=", zzasgVar, i11, 85);
        this.zzi = map;
        this.zzj = view;
        this.zzk = context;
    }

    private final long zzc(int i11) {
        Map map = this.zzi;
        Integer numValueOf = Integer.valueOf(i11);
        if (map.containsKey(numValueOf)) {
            return ((Long) this.zzi.get(numValueOf)).longValue();
        }
        return Long.MIN_VALUE;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long[] jArr = {zzc(1), zzc(2)};
        Context contextZzb = this.zzk;
        if (contextZzb == null) {
            contextZzb = this.zzb.zzb();
        }
        long[] jArr2 = (long[]) this.zzf.invoke(null, jArr, contextZzb, this.zzj);
        long j11 = jArr2[0];
        this.zzi.put(1, Long.valueOf(jArr2[1]));
        long j12 = jArr2[2];
        this.zzi.put(2, Long.valueOf(jArr2[3]));
        synchronized (this.zze) {
            this.zze.zzv(j11);
            this.zze.zzu(j12);
        }
    }
}
