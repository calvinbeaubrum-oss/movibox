package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzesa implements zzexq {
    private final Set zza;

    public zzesa(Set set) {
        this.zza = set;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final int zza() {
        return 8;
    }

    @Override // com.google.android.gms.internal.ads.zzexq
    public final s zzb() {
        final ArrayList arrayList = new ArrayList();
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            arrayList.add((String) it.next());
        }
        return zzgen.zzh(new zzexp() { // from class: com.google.android.gms.internal.ads.zzerz
            @Override // com.google.android.gms.internal.ads.zzexp
            public final void zzj(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", arrayList);
            }
        });
    }
}
