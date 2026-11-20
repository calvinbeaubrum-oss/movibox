package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxn extends zzaxx {
    private List zzi;
    private final Context zzj;

    public zzaxn(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, Context context) {
        super(zzawjVar, "0gWjYXznHW/Eye6gdpKNKYjX/XLpx1vdgxUIuTN4hh6FwE+EupqjErYFsUwwKenZ", "tk45mDotIpTZidmNYxxiIBsjVftw/e0h3Unlwpf2Me4=", zzasgVar, i11, 31);
        this.zzi = null;
        this.zzj = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzW(-1L);
        this.zze.zzS(-1L);
        Context contextZzb = this.zzj;
        if (contextZzb == null) {
            contextZzb = this.zzb.zzb();
        }
        if (this.zzi == null) {
            this.zzi = (List) this.zzf.invoke(null, contextZzb);
        }
        List list = this.zzi;
        if (list == null || list.size() != 2) {
            return;
        }
        synchronized (this.zze) {
            this.zze.zzW(((Long) this.zzi.get(0)).longValue());
            this.zze.zzS(((Long) this.zzi.get(1)).longValue());
        }
    }
}
