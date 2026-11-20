package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.view.View;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfou extends zzfox {

    @SuppressLint({"StaticFieldLeak"})
    private static final zzfou zzb = new zzfou();

    private zzfou() {
    }

    public static zzfou zza() {
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzfox
    public final void zzb(boolean z11) {
        Iterator it = zzfov.zza().zzc().iterator();
        while (it.hasNext()) {
            zzfpi zzfpiVarZzg = ((zzfoh) it.next()).zzg();
            if (zzfpiVarZzg.zzl()) {
                zzfpb.zza().zzb(zzfpiVarZzg.zza(), "setState", true != z11 ? "backgrounded" : "foregrounded");
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfox
    public final boolean zzc() {
        Iterator it = zzfov.zza().zzb().iterator();
        while (it.hasNext()) {
            View viewZzf = ((zzfoh) it.next()).zzf();
            if (viewZzf != null && viewZzf.hasWindowFocus()) {
                return true;
            }
        }
        return false;
    }
}
