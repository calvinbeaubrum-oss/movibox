package com.google.android.gms.internal.measurement;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlb extends zzip implements RandomAccess, zzkl, zzlt {
    private static final zzlb zza;
    private long[] zzb;
    private int zzc;

    static {
        zzlb zzlbVar = new zzlb(new long[0], 0);
        zza = zzlbVar;
        zzlbVar.zzb();
    }

    public zzlb() {
        this(new long[10], 0);
    }

    private zzlb(long[] jArr, int i11) {
        this.zzb = jArr;
        this.zzc = i11;
    }

    public static zzlb zzf() {
        return zza;
    }

    private final String zzh(int i11) {
        return "Index:" + i11 + ", Size:" + this.zzc;
    }

    private final void zzi(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        long jLongValue = ((Long) obj).longValue();
        zzbT();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzh(i11));
        }
        long[] jArr = this.zzb;
        if (i12 < jArr.length) {
            System.arraycopy(jArr, i11, jArr, i11 + 1, i12 - i11);
        } else {
            long[] jArr2 = new long[((i12 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            System.arraycopy(this.zzb, i11, jArr2, i11 + 1, this.zzc - i11);
            this.zzb = jArr2;
        }
        this.zzb[i11] = jLongValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzg(((Long) obj).longValue());
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbT();
        zzkn.zze(collection);
        if (!(collection instanceof zzlb)) {
            return super.addAll(collection);
        }
        zzlb zzlbVar = (zzlb) collection;
        int i11 = zzlbVar.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        long[] jArr = this.zzb;
        if (i13 > jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i13);
        }
        System.arraycopy(zzlbVar.zzb, 0, this.zzb, this.zzc, zzlbVar.zzc);
        this.zzc = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzlb)) {
            return super.equals(obj);
        }
        zzlb zzlbVar = (zzlb) obj;
        if (this.zzc != zzlbVar.zzc) {
            return false;
        }
        long[] jArr = zzlbVar.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != jArr[i11]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i11) {
        zzi(i11);
        return Long.valueOf(this.zzb[i11]);
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iZzc = 1;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            iZzc = (iZzc * 31) + zzkn.zzc(this.zzb[i11]);
        }
        return iZzc;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == jLongValue) {
                return i12;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbT();
        zzi(i11);
        long[] jArr = this.zzb;
        long j11 = jArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(jArr, i11 + 1, jArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j11);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i11, int i12) {
        zzbT();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzb;
        System.arraycopy(jArr, i12, jArr, i11, this.zzc - i12);
        this.zzc -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zzbT();
        zzi(i11);
        long[] jArr = this.zzb;
        long j11 = jArr[i11];
        jArr[i11] = jLongValue;
        return Long.valueOf(j11);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkl
    public final long zza(int i11) {
        zzi(i11);
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    /* JADX INFO: renamed from: zze, reason: merged with bridge method [inline-methods] */
    public final zzkl zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzlb(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }

    public final void zzg(long j11) {
        zzbT();
        int i11 = this.zzc;
        long[] jArr = this.zzb;
        if (i11 == jArr.length) {
            long[] jArr2 = new long[((i11 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i11);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        jArr3[i12] = j11;
    }
}
