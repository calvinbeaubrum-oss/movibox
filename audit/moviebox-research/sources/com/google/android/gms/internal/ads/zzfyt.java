package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfyt extends zzfyw implements Serializable {
    private final transient Map zza;
    private transient int zzb;

    public zzfyt(Map map) {
        zzfxe.zze(map.isEmpty());
        this.zza = map;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzfyt zzfytVar, Object obj) {
        Object objRemove;
        try {
            objRemove = zzfytVar.zza.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            objRemove = null;
        }
        Collection collection = (Collection) objRemove;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            zzfytVar.zzb -= size;
        }
    }

    public abstract Collection zza();

    public Collection zzb(Collection collection) {
        throw null;
    }

    public Collection zzc(Object obj, Collection collection) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgaw
    public final int zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public final Collection zzf() {
        return new zzfyv(this);
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public final Iterator zzg() {
        return new zzfyd(this);
    }

    public final List zzh(Object obj, List list, zzfyq zzfyqVar) {
        return list instanceof RandomAccess ? new zzfym(this, obj, list, zzfyqVar) : new zzfys(this, obj, list, zzfyqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public Map zzj() {
        throw null;
    }

    public final Map zzk() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfyk(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfyn(this, (SortedMap) map) : new zzfyg(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzfyw
    public Set zzl() {
        throw null;
    }

    public final Set zzm() {
        Map map = this.zza;
        if (map instanceof NavigableMap) {
            return new zzfyl(this, (NavigableMap) map);
        }
        return map instanceof SortedMap ? new zzfyo(this, (SortedMap) map) : new zzfyj(this, map);
    }

    @Override // com.google.android.gms.internal.ads.zzgaw
    public final void zzp() {
        Iterator it = this.zza.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.zza.clear();
        this.zzb = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzfyw, com.google.android.gms.internal.ads.zzgaw
    public final boolean zzq(Object obj, Object obj2) {
        Collection collection = (Collection) this.zza.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.zzb++;
            return true;
        }
        Collection collectionZza = zza();
        if (!collectionZza.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.zzb++;
        this.zza.put(obj, collectionZza);
        return true;
    }
}
