package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzgac {
    Object[] zza;
    int zzb;
    zzgab zzc;

    public zzgac() {
        this(4);
    }

    public zzgac(int i11) {
        this.zza = new Object[i11 + i11];
        this.zzb = 0;
    }

    private final void zzd(int i11) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i12 = i11 + i11;
        if (i12 > length) {
            this.zza = Arrays.copyOf(objArr, zzfzu.zze(length, i12));
        }
    }

    public final zzgac zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzfyx.zzb(obj, obj2);
        Object[] objArr = this.zza;
        int i11 = this.zzb;
        int i12 = i11 + i11;
        objArr[i12] = obj;
        objArr[i12 + 1] = obj2;
        this.zzb = i11 + 1;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final zzgac zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + iterable.size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgad zzc() {
        zzgab zzgabVar = this.zzc;
        if (zzgabVar != null) {
            throw zzgabVar.zza();
        }
        zzgbp zzgbpVarZzj = zzgbp.zzj(this.zzb, this.zza, this);
        zzgab zzgabVar2 = this.zzc;
        if (zzgabVar2 == null) {
            return zzgbpVarZzj;
        }
        throw zzgabVar2.zza();
    }
}
