package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlv extends zzip implements RandomAccess {
    private static final zzlv zza;
    private Object[] zzb;
    private int zzc;

    static {
        zzlv zzlvVar = new zzlv(new Object[0], 0);
        zza = zzlvVar;
        zzlvVar.zzb();
    }

    public zzlv() {
        this(new Object[10], 0);
    }

    private zzlv(Object[] objArr, int i11) {
        this.zzb = objArr;
        this.zzc = i11;
    }

    public static zzlv zze() {
        return zza;
    }

    private final String zzf(int i11) {
        return "Index:" + i11 + ", Size:" + this.zzc;
    }

    private final void zzg(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final void add(int i11, Object obj) {
        int i12;
        zzbT();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i11));
        }
        Object[] objArr = this.zzb;
        if (i12 < objArr.length) {
            System.arraycopy(objArr, i11, objArr, i11 + 1, i12 - i11);
        } else {
            Object[] objArr2 = new Object[((i12 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i11);
            System.arraycopy(this.zzb, i11, objArr2, i11 + 1, this.zzc - i11);
            this.zzb = objArr2;
        }
        this.zzb[i11] = obj;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzbT();
        int i11 = this.zzc;
        Object[] objArr = this.zzb;
        if (i11 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i11 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i12 = this.zzc;
        this.zzc = i12 + 1;
        objArr2[i12] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i11) {
        zzg(i11);
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final Object remove(int i11) {
        zzbT();
        zzg(i11);
        Object[] objArr = this.zzb;
        Object obj = objArr[i11];
        int i12 = this.zzc;
        if (i11 < i12 - 1) {
            System.arraycopy(objArr, i11 + 1, objArr, i11, (i12 - i11) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzip, java.util.AbstractList, java.util.List
    public final Object set(int i11, Object obj) {
        zzbT();
        zzg(i11);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i11];
        objArr[i11] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.measurement.zzkm
    public final /* bridge */ /* synthetic */ zzkm zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzlv(Arrays.copyOf(this.zzb, i11), this.zzc);
        }
        throw new IllegalArgumentException();
    }
}
