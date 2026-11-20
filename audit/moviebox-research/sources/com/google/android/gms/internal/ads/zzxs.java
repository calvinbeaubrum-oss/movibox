package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxs extends zzdf {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private final SparseArray zzh;
    private final SparseBooleanArray zzi;

    @Deprecated
    public zzxs() {
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    public zzxs(Context context) {
        super.zze(context);
        Point pointZzu = zzfy.zzu(context);
        zzf(pointZzu.x, pointZzu.y, true);
        this.zzh = new SparseArray();
        this.zzi = new SparseBooleanArray();
        zzx();
    }

    public /* synthetic */ zzxs(zzxu zzxuVar, zzxr zzxrVar) {
        super(zzxuVar);
        this.zza = zzxuVar.zzI;
        this.zzb = zzxuVar.zzK;
        this.zzc = zzxuVar.zzM;
        this.zzd = zzxuVar.zzR;
        this.zze = zzxuVar.zzS;
        this.zzf = zzxuVar.zzT;
        this.zzg = zzxuVar.zzV;
        SparseArray sparseArray = zzxuVar.zzap;
        SparseArray sparseArray2 = new SparseArray();
        for (int i11 = 0; i11 < sparseArray.size(); i11++) {
            sparseArray2.put(sparseArray.keyAt(i11), new HashMap((Map) sparseArray.valueAt(i11)));
        }
        this.zzh = sparseArray2;
        this.zzi = zzxuVar.zzaq.clone();
    }

    private final void zzx() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
        this.zzf = true;
        this.zzg = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdf
    public final /* synthetic */ zzdf zzf(int i11, int i12, boolean z11) {
        super.zzf(i11, i12, true);
        return this;
    }

    public final zzxs zzp(int i11, boolean z11) {
        if (this.zzi.get(i11) != z11) {
            if (z11) {
                this.zzi.put(i11, true);
            } else {
                this.zzi.delete(i11);
            }
        }
        return this;
    }
}
