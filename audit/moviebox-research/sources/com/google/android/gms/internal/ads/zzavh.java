package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzavh extends zzavg {
    public zzavh(Context context, String str, boolean z11) {
        super(context, str, z11);
    }

    public static zzavh zzt(String str, Context context, boolean z11) {
        zzavg.zzr(context, false);
        return new zzavh(context, str, false);
    }

    @Deprecated
    public static zzavh zzu(String str, Context context, boolean z11, int i11) {
        zzavg.zzr(context, z11);
        return new zzavh(context, str, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzavg
    public final List zzp(zzawj zzawjVar, Context context, zzasg zzasgVar, zzarz zzarzVar) {
        if (zzawjVar.zzk() == null || !((zzavg) this).zzu) {
            return super.zzp(zzawjVar, context, zzasgVar, null);
        }
        int iZza = zzawjVar.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzp(zzawjVar, context, zzasgVar, null));
        arrayList.add(new zzaxb(zzawjVar, "8UEA9TmdE+sqV3zcsNgnFI5Sf8uIsQHU61W37Ddl8zaNqY23x/FpuoK+mm9MWruA", "qlbJd0rViXaFpU2SvrkcezPlE/VtgXulMFWFUXmIBBg=", zzasgVar, iZza, 24));
        return arrayList;
    }
}
