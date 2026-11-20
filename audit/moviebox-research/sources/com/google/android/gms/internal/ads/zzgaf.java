package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgaf extends zzfzv implements Set {
    private transient zzgaa zza;

    public static int zzh(int i11) {
        int iMax = Math.max(i11, 2);
        if (iMax >= 751619276) {
            zzfxe.zzf(iMax < 1073741824, "collection too large");
            return 1073741824;
        }
        int iHighestOneBit = Integer.highestOneBit(iMax - 1);
        do {
            iHighestOneBit += iHighestOneBit;
        } while (((double) iHighestOneBit) * 0.7d < iMax);
        return iHighestOneBit;
    }

    public static zzgae zzj(int i11) {
        return new zzgae(i11);
    }

    public static zzgaf zzl(Collection collection) {
        Object[] array = collection.toArray();
        return zzv(array.length, array);
    }

    public static zzgaf zzm(Object[] objArr) {
        int length = objArr.length;
        if (length != 0) {
            return length != 1 ? zzv(length, (Object[]) objArr.clone()) : new zzgcb(objArr[0]);
        }
        return zzgbq.zza;
    }

    public static zzgaf zzn() {
        return zzgbq.zza;
    }

    public static zzgaf zzo(Object obj) {
        return new zzgcb(obj);
    }

    public static zzgaf zzp(Object obj, Object obj2) {
        return zzv(2, obj, obj2);
    }

    public static zzgaf zzq(Object obj, Object obj2, Object obj3) {
        return zzv(3, obj, obj2, obj3);
    }

    public static zzgaf zzr(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        return zzv(5, obj, obj2, obj3, obj4, obj5);
    }

    @SafeVarargs
    public static zzgaf zzs(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        Object[] objArr2 = new Object[12];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, 6);
        return zzv(12, objArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzgaf zzv(int i11, Object... objArr) {
        if (i11 == 0) {
            return zzgbq.zza;
        }
        if (i11 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            return new zzgcb(obj);
        }
        int iZzh = zzh(i11);
        Object[] objArr2 = new Object[iZzh];
        int i12 = iZzh - 1;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 0; i15 < i11; i15++) {
            Object obj2 = objArr[i15];
            zzgbi.zza(obj2, i15);
            int iHashCode = obj2.hashCode();
            int iZza = zzfzs.zza(iHashCode);
            while (true) {
                int i16 = iZza & i12;
                Object obj3 = objArr2[i16];
                if (obj3 == null) {
                    objArr[i14] = obj2;
                    objArr2[i16] = obj2;
                    i13 += iHashCode;
                    i14++;
                    break;
                }
                if (obj3.equals(obj2)) {
                    break;
                }
                iZza++;
            }
        }
        Arrays.fill(objArr, i14, i11, (Object) null);
        if (i14 == 1) {
            Object obj4 = objArr[0];
            Objects.requireNonNull(obj4);
            return new zzgcb(obj4);
        }
        if (zzh(i14) < iZzh / 2) {
            return zzv(i14, objArr);
        }
        if (zzw(i14, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i14);
        }
        return new zzgbq(objArr, i13, objArr2, i12, i14);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzw(int i11, int i12) {
        return i11 < (i12 >> 1) + (i12 >> 2);
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof zzgaf) && zzu() && ((zzgaf) obj).zzu() && hashCode() != obj.hashCode()) {
            return false;
        }
        return zzgca.zzd(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return zzgca.zza(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfzv
    public zzgaa zzd() {
        zzgaa zzgaaVar = this.zza;
        if (zzgaaVar != null) {
            return zzgaaVar;
        }
        zzgaa zzgaaVarZzi = zzi();
        this.zza = zzgaaVarZzi;
        return zzgaaVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzfzv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zze */
    public abstract zzgce iterator();

    public zzgaa zzi() {
        Object[] array = toArray();
        int i11 = zzgaa.zzd;
        return zzgaa.zzi(array, array.length);
    }

    public boolean zzu() {
        return false;
    }
}
