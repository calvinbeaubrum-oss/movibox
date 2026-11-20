package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzgzv extends zzgxv implements RandomAccess, zzgzz, zzhbm {
    private static final zzgzv zza = new zzgzv(new int[0], 0, false);
    private int[] zzb;
    private int zzc;

    public zzgzv() {
        this(new int[10], 0, true);
    }

    private zzgzv(int[] iArr, int i11, boolean z11) {
        super(z11);
        this.zzb = iArr;
        this.zzc = i11;
    }

    public static zzgzv zzf() {
        return zza;
    }

    private final String zzi(int i11) {
        return "Index:" + i11 + ", Size:" + this.zzc;
    }

    private final void zzj(int i11) {
        if (i11 < 0 || i11 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i11));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i11, Object obj) {
        int i12;
        int iIntValue = ((Integer) obj).intValue();
        zzbQ();
        if (i11 < 0 || i11 > (i12 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i11));
        }
        int i13 = i11 + 1;
        int[] iArr = this.zzb;
        if (i12 < iArr.length) {
            System.arraycopy(iArr, i11, iArr, i13, i12 - i11);
        } else {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i11);
            System.arraycopy(this.zzb, i11, iArr2, i13, this.zzc - i11);
            this.zzb = iArr2;
        }
        this.zzb[i11] = iIntValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzbQ();
        byte[] bArr = zzhae.zzd;
        collection.getClass();
        if (!(collection instanceof zzgzv)) {
            return super.addAll(collection);
        }
        zzgzv zzgzvVar = (zzgzv) collection;
        int i11 = zzgzvVar.zzc;
        if (i11 == 0) {
            return false;
        }
        int i12 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i12 < i11) {
            throw new OutOfMemoryError();
        }
        int i13 = i12 + i11;
        int[] iArr = this.zzb;
        if (i13 > iArr.length) {
            this.zzb = Arrays.copyOf(iArr, i13);
        }
        System.arraycopy(zzgzvVar.zzb, 0, this.zzb, this.zzc, zzgzvVar.zzc);
        this.zzc = i13;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgzv)) {
            return super.equals(obj);
        }
        zzgzv zzgzvVar = (zzgzv) obj;
        if (this.zzc != zzgzvVar.zzc) {
            return false;
        }
        int[] iArr = zzgzvVar.zzb;
        for (int i11 = 0; i11 < this.zzc; i11++) {
            if (this.zzb[i11] != iArr[i11]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i11) {
        zzj(i11);
        return Integer.valueOf(this.zzb[i11]);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i11 = 1;
        for (int i12 = 0; i12 < this.zzc; i12++) {
            i11 = (i11 * 31) + this.zzb[i12];
        }
        return i11;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i11 = this.zzc;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.zzb[i12] == iIntValue) {
                return i12;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbQ();
        zzj(i11);
        int[] iArr = this.zzb;
        int i12 = iArr[i11];
        int i13 = this.zzc;
        if (i11 < i13 - 1) {
            System.arraycopy(iArr, i11 + 1, iArr, i11, (i13 - i11) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i12);
    }

    @Override // java.util.AbstractList
    public final void removeRange(int i11, int i12) {
        zzbQ();
        if (i12 < i11) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.zzb;
        System.arraycopy(iArr, i12, iArr, i11, this.zzc - i12);
        this.zzc -= i12 - i11;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        zzbQ();
        zzj(i11);
        int[] iArr = this.zzb;
        int i12 = iArr[i11];
        iArr[i11] = iIntValue;
        return Integer.valueOf(i12);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    public final int zze(int i11) {
        zzj(i11);
        return this.zzb[i11];
    }

    @Override // com.google.android.gms.internal.ads.zzhad
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzgzz zzd(int i11) {
        if (i11 >= this.zzc) {
            return new zzgzv(Arrays.copyOf(this.zzb, i11), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.ads.zzgzz
    public final void zzh(int i11) {
        zzbQ();
        int i12 = this.zzc;
        int[] iArr = this.zzb;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[((i12 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.zzb = iArr2;
        }
        int[] iArr3 = this.zzb;
        int i13 = this.zzc;
        this.zzc = i13 + 1;
        iArr3[i13] = i11;
    }
}
