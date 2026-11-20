package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgae extends zzfzt {
    Object[] zzd;
    private int zze;

    public zzgae() {
        super(4);
    }

    public zzgae(int i11) {
        super(i11);
        this.zzd = new Object[zzgaf.zzh(i11)];
    }

    @Override // com.google.android.gms.internal.ads.zzfzt, com.google.android.gms.internal.ads.zzfzu
    public final /* bridge */ /* synthetic */ zzfzu zzb(Object obj) {
        zzf(obj);
        return this;
    }

    public final zzgae zzf(Object obj) {
        obj.getClass();
        if (this.zzd != null) {
            int iZzh = zzgaf.zzh(this.zzb);
            Object[] objArr = this.zzd;
            if (iZzh <= objArr.length) {
                int length = objArr.length - 1;
                int iHashCode = obj.hashCode();
                int iZza = zzfzs.zza(iHashCode);
                while (true) {
                    int i11 = iZza & length;
                    Object[] objArr2 = this.zzd;
                    Object obj2 = objArr2[i11];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        iZza = i11 + 1;
                    } else {
                        objArr2[i11] = obj;
                        this.zze += iHashCode;
                        super.zza(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzd = null;
        super.zza(obj);
        return this;
    }

    public final zzgae zzg(Iterable iterable) {
        iterable.getClass();
        if (this.zzd != null) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                zzf(it.next());
            }
        } else {
            super.zzc(iterable);
        }
        return this;
    }

    public final zzgaf zzh() {
        zzgaf zzgafVarZzv;
        int i11 = this.zzb;
        if (i11 == 0) {
            return zzgbq.zza;
        }
        if (i11 == 1) {
            Object obj = this.zza[0];
            Objects.requireNonNull(obj);
            return new zzgcb(obj);
        }
        if (this.zzd == null || zzgaf.zzh(i11) != this.zzd.length) {
            zzgafVarZzv = zzgaf.zzv(this.zzb, this.zza);
            this.zzb = zzgafVarZzv.size();
        } else {
            int i12 = this.zzb;
            Object[] objArrCopyOf = this.zza;
            if (zzgaf.zzw(i12, objArrCopyOf.length)) {
                objArrCopyOf = Arrays.copyOf(objArrCopyOf, i12);
            }
            int i13 = this.zze;
            Object[] objArr = this.zzd;
            zzgafVarZzv = new zzgbq(objArrCopyOf, i13, objArr, objArr.length - 1, this.zzb);
        }
        this.zzc = true;
        this.zzd = null;
        return zzgafVarZzv;
    }
}
