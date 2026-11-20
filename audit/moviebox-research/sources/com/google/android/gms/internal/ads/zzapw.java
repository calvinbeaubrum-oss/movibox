package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzapw {
    public final int zza;
    public final byte[] zzb;

    @Nullable
    public final Map zzc;

    @Nullable
    public final List zzd;
    public final boolean zze;

    private zzapw(int i11, byte[] bArr, @Nullable Map map, @Nullable List list, boolean z11, long j11) {
        this.zza = i11;
        this.zzb = bArr;
        this.zzc = map;
        this.zzd = list == null ? null : Collections.unmodifiableList(list);
        this.zze = z11;
    }

    @Deprecated
    public zzapw(int i11, byte[] bArr, @Nullable Map map, boolean z11, long j11) {
        this(i11, bArr, map, zza(map), z11, j11);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public zzapw(int i11, byte[] bArr, boolean z11, long j11, @Nullable List list) {
        Map treeMap;
        if (list == null) {
            treeMap = null;
        } else if (list.isEmpty()) {
            treeMap = Collections.emptyMap();
        } else {
            treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzaps zzapsVar = (zzaps) it.next();
                treeMap.put(zzapsVar.zza(), zzapsVar.zzb());
            }
        }
        this(i11, bArr, treeMap, list, z11, j11);
    }

    @Deprecated
    public zzapw(byte[] bArr, @Nullable Map map) {
        this(200, bArr, map, zza(map), false, 0L);
    }

    @Nullable
    private static List zza(@Nullable Map map) {
        if (map == null) {
            return null;
        }
        if (map.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry entry : map.entrySet()) {
            arrayList.add(new zzaps((String) entry.getKey(), (String) entry.getValue()));
        }
        return arrayList;
    }
}
