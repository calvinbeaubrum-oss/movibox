package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzp {
    private static final Comparator zza = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzl
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ((zzzo) obj).zza - ((zzzo) obj2).zza;
        }
    };
    private static final Comparator zzb = new Comparator() { // from class: com.google.android.gms.internal.ads.zzzm
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((zzzo) obj).zzc, ((zzzo) obj2).zzc);
        }
    };
    private int zzf;
    private int zzg;
    private int zzh;
    private final zzzo[] zzd = new zzzo[5];
    private final ArrayList zzc = new ArrayList();
    private int zze = -1;

    public zzzp(int i11) {
    }

    public final float zza(float f11) {
        if (this.zze != 0) {
            Collections.sort(this.zzc, zzb);
            this.zze = 0;
        }
        float f12 = this.zzg;
        int i11 = 0;
        for (int i12 = 0; i12 < this.zzc.size(); i12++) {
            float f13 = 0.5f * f12;
            zzzo zzzoVar = (zzzo) this.zzc.get(i12);
            i11 += zzzoVar.zzb;
            if (i11 >= f13) {
                return zzzoVar.zzc;
            }
        }
        if (this.zzc.isEmpty()) {
            return Float.NaN;
        }
        ArrayList arrayList = this.zzc;
        return ((zzzo) arrayList.get(arrayList.size() - 1)).zzc;
    }

    public final void zzb(int i11, float f11) {
        zzzo zzzoVar;
        if (this.zze != 1) {
            Collections.sort(this.zzc, zza);
            this.zze = 1;
        }
        int i12 = this.zzh;
        if (i12 > 0) {
            zzzo[] zzzoVarArr = this.zzd;
            int i13 = i12 - 1;
            this.zzh = i13;
            zzzoVar = zzzoVarArr[i13];
        } else {
            zzzoVar = new zzzo(null);
        }
        int i14 = this.zzf;
        this.zzf = i14 + 1;
        zzzoVar.zza = i14;
        zzzoVar.zzb = i11;
        zzzoVar.zzc = f11;
        this.zzc.add(zzzoVar);
        this.zzg += i11;
        while (true) {
            int i15 = this.zzg;
            if (i15 <= 2000) {
                return;
            }
            int i16 = i15 - 2000;
            zzzo zzzoVar2 = (zzzo) this.zzc.get(0);
            int i17 = zzzoVar2.zzb;
            if (i17 <= i16) {
                this.zzg -= i17;
                this.zzc.remove(0);
                int i18 = this.zzh;
                if (i18 < 5) {
                    zzzo[] zzzoVarArr2 = this.zzd;
                    this.zzh = i18 + 1;
                    zzzoVarArr2[i18] = zzzoVar2;
                }
            } else {
                zzzoVar2.zzb = i17 - i16;
                this.zzg -= i16;
            }
        }
    }

    public final void zzc() {
        this.zzc.clear();
        this.zze = -1;
        this.zzf = 0;
        this.zzg = 0;
    }
}
