package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzare extends zzaqa {
    private final Object zza;

    @Nullable
    private final zzaqf zzb;

    public zzare(int i11, String str, zzaqf zzaqfVar, @Nullable zzaqe zzaqeVar) {
        super(i11, str, zzaqeVar);
        this.zza = new Object();
        this.zzb = zzaqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    public final zzaqg zzh(zzapw zzapwVar) {
        String str;
        String str2;
        try {
            byte[] bArr = zzapwVar.zzb;
            Map map = zzapwVar.zzc;
            String str3 = "ISO-8859-1";
            if (map != null && (str2 = (String) map.get(HttpHeaders.CONTENT_TYPE)) != null) {
                String[] strArrSplit = str2.split(";", 0);
                for (int i11 = 1; i11 < strArrSplit.length; i11++) {
                    String[] strArrSplit2 = strArrSplit[i11].trim().split("=", 0);
                    if (strArrSplit2.length == 2 && strArrSplit2[0].equals("charset")) {
                        str3 = strArrSplit2[1];
                        break;
                    }
                }
            }
            str = new String(bArr, str3);
        } catch (UnsupportedEncodingException unused) {
            str = new String(zzapwVar.zzb);
        }
        return zzaqg.zzb(str, zzaqx.zzb(zzapwVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaqa
    /* JADX INFO: renamed from: zzz, reason: merged with bridge method [inline-methods] */
    public void zzo(String str) {
        zzaqf zzaqfVar;
        synchronized (this.zza) {
            zzaqfVar = this.zzb;
        }
        zzaqfVar.zza(str);
    }
}
