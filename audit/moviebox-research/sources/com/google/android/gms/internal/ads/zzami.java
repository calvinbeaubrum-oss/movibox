package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzami implements zzakr {
    private final zzfp zza = new zzfp();
    private final zzaly zzb = new zzaly();

    @Override // com.google.android.gms.internal.ads.zzakr
    public final void zza(byte[] bArr, int i11, int i12, zzakq zzakqVar, zzep zzepVar) {
        this.zza.zzI(bArr, i12 + i11);
        this.zza.zzK(i11);
        ArrayList arrayList = new ArrayList();
        try {
            zzfp zzfpVar = this.zza;
            int iZzd = zzfpVar.zzd();
            Charset charset = zzfwq.zzc;
            String strZzy = zzfpVar.zzy(charset);
            if (strZzy == null || !strZzy.startsWith("WEBVTT")) {
                zzfpVar.zzK(iZzd);
                throw zzcc.zza("Expected WEBVTT. Got ".concat(String.valueOf(zzfpVar.zzy(charset))), null);
            }
            while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc))) {
            }
            ArrayList arrayList2 = new ArrayList();
            while (true) {
                zzfp zzfpVar2 = this.zza;
                byte b11 = -1;
                int iZzd2 = 0;
                while (b11 == -1) {
                    iZzd2 = zzfpVar2.zzd();
                    String strZzy2 = zzfpVar2.zzy(zzfwq.zzc);
                    if (strZzy2 == null) {
                        b11 = 0;
                    } else if ("STYLE".equals(strZzy2)) {
                        b11 = 2;
                    } else {
                        b11 = strZzy2.startsWith("NOTE") ? (byte) 1 : (byte) 3;
                    }
                }
                zzfpVar2.zzK(iZzd2);
                if (b11 == 0) {
                    zzakl.zza(new zzaml(arrayList2), zzakqVar, zzepVar);
                    return;
                }
                if (b11 == 1) {
                    while (!TextUtils.isEmpty(this.zza.zzy(zzfwq.zzc))) {
                    }
                } else if (b11 != 2) {
                    zzama zzamaVarZzc = zzamh.zzc(this.zza, arrayList);
                    if (zzamaVarZzc != null) {
                        arrayList2.add(zzamaVarZzc);
                    }
                } else {
                    if (!arrayList2.isEmpty()) {
                        throw new IllegalArgumentException("A style block was found after the first cue.");
                    }
                    this.zza.zzy(zzfwq.zzc);
                    arrayList.addAll(this.zzb.zzb(this.zza));
                }
            }
        } catch (zzcc e11) {
            throw new IllegalArgumentException(e11);
        }
    }
}
