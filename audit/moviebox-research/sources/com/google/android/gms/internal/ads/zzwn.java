package com.google.android.gms.internal.ads;

import android.util.SparseArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzwn {
    private int zza;
    private final SparseArray zzb;
    private final zzep zzc;

    public zzwn() {
        zzwm zzwmVar = new zzep() { // from class: com.google.android.gms.internal.ads.zzwm
            @Override // com.google.android.gms.internal.ads.zzep
            public final void zza(Object obj) {
            }
        };
        throw null;
    }

    public zzwn(zzep zzepVar) {
        this.zzb = new SparseArray();
        this.zzc = zzepVar;
        this.zza = -1;
    }

    public final Object zza(int i11) {
        if (this.zza == -1) {
            this.zza = 0;
        }
        while (true) {
            int i12 = this.zza;
            if (i12 <= 0 || i11 >= this.zzb.keyAt(i12)) {
                break;
            }
            this.zza--;
        }
        while (this.zza < this.zzb.size() - 1 && i11 >= this.zzb.keyAt(this.zza + 1)) {
            this.zza++;
        }
        return this.zzb.valueAt(this.zza);
    }

    public final Object zzb() {
        return this.zzb.valueAt(this.zzb.size() - 1);
    }

    public final void zzc(int i11, Object obj) {
        if (this.zza == -1) {
            zzek.zzf(this.zzb.size() == 0);
            this.zza = 0;
        }
        if (this.zzb.size() > 0) {
            SparseArray sparseArray = this.zzb;
            int iKeyAt = sparseArray.keyAt(sparseArray.size() - 1);
            zzek.zzd(i11 >= iKeyAt);
            if (iKeyAt == i11) {
                SparseArray sparseArray2 = this.zzb;
                zzwg.zzm((zzwe) sparseArray2.valueAt(sparseArray2.size() - 1));
            }
        }
        this.zzb.append(i11, obj);
    }

    public final void zzd() {
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            zzwg.zzm((zzwe) this.zzb.valueAt(i11));
        }
        this.zza = -1;
        this.zzb.clear();
    }

    public final void zze(int i11) {
        int i12 = 0;
        while (i12 < this.zzb.size() - 1) {
            int i13 = i12 + 1;
            if (i11 < this.zzb.keyAt(i13)) {
                return;
            }
            zzwg.zzm((zzwe) this.zzb.valueAt(i12));
            this.zzb.removeAt(i12);
            int i14 = this.zza;
            if (i14 > 0) {
                this.zza = i14 - 1;
            }
            i12 = i13;
        }
    }

    public final boolean zzf() {
        return this.zzb.size() == 0;
    }
}
