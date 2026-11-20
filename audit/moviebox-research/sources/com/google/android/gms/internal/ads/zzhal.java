package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhal extends zzgxv implements RandomAccess, zzham {

    @Deprecated
    public static final zzham zza;
    private static final zzhal zzb;
    private final List zzc;

    static {
        zzhal zzhalVar = new zzhal(false);
        zzb = zzhalVar;
        zza = zzhalVar;
    }

    public zzhal() {
        this(10);
    }

    public zzhal(int i11) {
        ArrayList arrayList = new ArrayList(i11);
        super(true);
        this.zzc = arrayList;
    }

    private zzhal(ArrayList arrayList) {
        super(true);
        this.zzc = arrayList;
    }

    private zzhal(boolean z11) {
        super(false);
        this.zzc = Collections.emptyList();
    }

    private static String zzj(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        return obj instanceof zzgyl ? ((zzgyl) obj).zzx(zzhae.zzb) : zzhae.zzd((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ void add(int i11, Object obj) {
        zzbQ();
        this.zzc.add(i11, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final boolean addAll(int i11, Collection collection) {
        zzbQ();
        if (collection instanceof zzham) {
            collection = ((zzham) collection).zzh();
        }
        boolean zAddAll = this.zzc.addAll(i11, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbQ();
        this.zzc.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i11) {
        zzbQ();
        Object objRemove = this.zzc.remove(i11);
        ((AbstractList) this).modCount++;
        return zzj(objRemove);
    }

    @Override // com.google.android.gms.internal.ads.zzgxv, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i11, Object obj) {
        zzbQ();
        return zzj(this.zzc.set(i11, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc.size();
    }

    @Override // com.google.android.gms.internal.ads.zzhad
    public final /* bridge */ /* synthetic */ zzhad zzd(int i11) {
        if (i11 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i11);
        arrayList.addAll(this.zzc);
        return new zzhal(arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzham
    public final zzham zze() {
        return zzc() ? new zzhcu(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzham
    public final Object zzf(int i11) {
        return this.zzc.get(i11);
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final String get(int i11) {
        Object obj = this.zzc.get(i11);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzgyl) {
            zzgyl zzgylVar = (zzgyl) obj;
            String strZzx = zzgylVar.zzx(zzhae.zzb);
            if (zzgylVar.zzp()) {
                this.zzc.set(i11, strZzx);
            }
            return strZzx;
        }
        byte[] bArr = (byte[]) obj;
        String strZzd = zzhae.zzd(bArr);
        if (zzhde.zzi(bArr)) {
            this.zzc.set(i11, strZzd);
        }
        return strZzd;
    }

    @Override // com.google.android.gms.internal.ads.zzham
    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzham
    public final void zzi(zzgyl zzgylVar) {
        zzbQ();
        this.zzc.add(zzgylVar);
        ((AbstractList) this).modCount++;
    }
}
