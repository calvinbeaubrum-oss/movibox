package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzbvt extends zzbvw {
    private final Map zza;
    private final Context zzb;

    public zzbvt(zzcjk zzcjkVar, Map map) {
        super(zzcjkVar, "storePicture");
        this.zza = map;
        this.zzb = zzcjkVar.zzi();
    }

    public final void zzb() {
        if (this.zzb == null) {
            zzh("Activity context is not available");
            return;
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        if (!new zzbfm(this.zzb).zzc()) {
            zzh("Feature is not supported by the device.");
            return;
        }
        String str = (String) this.zza.get("iurl");
        if (TextUtils.isEmpty(str)) {
            zzh("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            zzh("Invalid image url: ".concat(String.valueOf(str)));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        com.google.android.gms.ads.internal.zzt.zzp();
        if (TextUtils.isEmpty(lastPathSegment) || !lastPathSegment.matches("([^\\s]+(\\.(?i)(jpg|png|gif|bmp|webp))$)")) {
            zzh("Image type not recognized: ".concat(String.valueOf(lastPathSegment)));
            return;
        }
        Resources resourcesZze = com.google.android.gms.ads.internal.zzt.zzo().zze();
        com.google.android.gms.ads.internal.zzt.zzp();
        AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(this.zzb);
        builderZzJ.setTitle(resourcesZze != null ? resourcesZze.getString(R.string.f36073s1) : "Save image");
        builderZzJ.setMessage(resourcesZze != null ? resourcesZze.getString(R.string.f36074s2) : "Allow Ad to store image in Picture gallery?");
        builderZzJ.setPositiveButton(resourcesZze != null ? resourcesZze.getString(R.string.f36075s3) : "Accept", new zzbvr(this, str, lastPathSegment));
        builderZzJ.setNegativeButton(resourcesZze != null ? resourcesZze.getString(R.string.f36076s4) : "Decline", new zzbvs(this));
        builderZzJ.create().show();
    }
}
