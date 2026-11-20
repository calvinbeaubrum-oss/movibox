package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface zzht extends zzgw {
    public static final zzfxf zza = new zzfxf() { // from class: com.google.android.gms.internal.ads.zzhn
        @Override // com.google.android.gms.internal.ads.zzfxf
        public final boolean zza(Object obj) {
            String str = (String) obj;
            if (str == null) {
                return false;
            }
            String strZza = zzfwk.zza(str);
            if (TextUtils.isEmpty(strZza)) {
                return false;
            }
            return ((strZza.contains(MimeTypes.BASE_TYPE_TEXT) && !strZza.contains(MimeTypes.TEXT_VTT)) || strZza.contains("html") || strZza.contains("xml")) ? false : true;
        }
    };

    @Override // com.google.android.gms.internal.ads.zzgw
    Map zze();
}
