package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.util.IOUtils;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzdzc;
import com.google.android.gms.internal.ads.zzdzd;
import com.google.common.util.concurrent.s;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class zzay {
    private zzdzd zzg;
    private final Object zzb = new Object();
    private String zzc = "";
    private String zzd = "";
    private boolean zze = false;
    private boolean zzf = false;
    protected String zza = "";

    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static final String zzo(Context context, String str, String str2) {
        HashMap map = new HashMap();
        map.put("User-Agent", com.google.android.gms.ads.internal.zzt.zzp().zzc(context, str2));
        s sVarZzb = new zzbq(context).zzb(0, str, map, null);
        try {
            return (String) sVarZzb.get(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeG)).intValue(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e11) {
            zzcec.zzh("Interrupted while retrieving a response from: ".concat(String.valueOf(str)), e11);
            sVarZzb.cancel(true);
            return null;
        } catch (TimeoutException e12) {
            zzcec.zzh("Timeout while retrieving a response from: ".concat(String.valueOf(str)), e12);
            sVarZzb.cancel(true);
            return null;
        } catch (Exception e13) {
            zzcec.zzh("Error retrieving a response from: ".concat(String.valueOf(str)), e13);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0066 A[Catch: all -> 0x0029, TryCatch #1 {, blocks: (B:4:0x000b, B:6:0x0013, B:7:0x0018, B:12:0x0032, B:14:0x003a, B:16:0x004f, B:19:0x0061, B:11:0x002b, B:20:0x0066, B:21:0x0068), top: B:28:0x000b, inners: #0, #2 }] */
    private final Uri zzp(Context context, String str, String str2, String str3) {
        String str4;
        String str5;
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        synchronized (this.zzb) {
            if (TextUtils.isEmpty(this.zzc)) {
                com.google.android.gms.ads.internal.zzt.zzp();
                try {
                    str5 = new String(IOUtils.readInputStreamFully(context.openFileInput("debug_signals_id.txt"), true), "UTF-8");
                } catch (IOException unused) {
                    zzcec.zze("Error reading from internal storage.");
                    str5 = "";
                }
                this.zzc = str5;
                if (TextUtils.isEmpty(str5)) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    this.zzc = UUID.randomUUID().toString();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String str6 = this.zzc;
                    try {
                        FileOutputStream fileOutputStreamOpenFileOutput = context.openFileOutput("debug_signals_id.txt", 0);
                        fileOutputStreamOpenFileOutput.write(str6.getBytes("UTF-8"));
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e11) {
                        zzcec.zzh("Error writing to file in internal storage.", e11);
                    }
                    str4 = this.zzc;
                } else {
                    str4 = this.zzc;
                }
            } else {
                str4 = this.zzc;
            }
            throw th;
        }
        builderBuildUpon.appendQueryParameter("linkedDeviceId", str4);
        builderBuildUpon.appendQueryParameter("adSlotPath", str2);
        builderBuildUpon.appendQueryParameter("afmaVersion", str3);
        return builderBuildUpon.build();
    }

    public final zzdzd zza() {
        return this.zzg;
    }

    public final String zzb() {
        String str;
        synchronized (this.zzb) {
            str = this.zzd;
        }
        return str;
    }

    public final void zzc(Context context) {
        zzdzd zzdzdVar;
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue() || (zzdzdVar = this.zzg) == null) {
            return;
        }
        zzdzdVar.zzh(new zzav(this, context), zzdzc.DEBUG_MENU);
    }

    public final void zzd(Context context, String str, String str2) {
        com.google.android.gms.ads.internal.zzt.zzp();
        zzt.zzT(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeC), str, str2));
    }

    public final void zze(Context context, String str, String str2, String str3) {
        Uri.Builder builderBuildUpon = zzp(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeF), str3, str).buildUpon();
        builderBuildUpon.appendQueryParameter("debugData", str2);
        com.google.android.gms.ads.internal.zzt.zzp();
        zzt.zzK(context, str, builderBuildUpon.build().toString());
    }

    public final void zzf(boolean z11) {
        synchronized (this.zzb) {
            try {
                this.zzf = z11;
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzt.zzo().zzi().zzB(z11);
                    zzdzd zzdzdVar = this.zzg;
                    if (zzdzdVar != null) {
                        zzdzdVar.zzk(z11);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzg(zzdzd zzdzdVar) {
        this.zzg = zzdzdVar;
    }

    public final void zzh(boolean z11) {
        synchronized (this.zzb) {
            this.zze = z11;
        }
    }

    public final void zzi(Context context, String str, boolean z11, boolean z12) {
        if (context instanceof Activity) {
            zzt.zza.post(new zzax(this, context, str, z11, z12));
        } else {
            zzcec.zzi("Can not create dialog without Activity Context");
        }
    }

    public final boolean zzj(Context context, String str, String str2) {
        String strZzo = zzo(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeE), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzo)) {
            zzcec.zze("Not linked for debug signals.");
            return false;
        }
        try {
            boolean zEquals = "1".equals(new JSONObject(strZzo.trim()).optString("debug_mode"));
            zzf(zEquals);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
                zzg zzgVarZzi = com.google.android.gms.ads.internal.zzt.zzo().zzi();
                if (true != zEquals) {
                    str = "";
                }
                zzgVarZzi.zzA(str);
            }
            return zEquals;
        } catch (JSONException e11) {
            zzcec.zzk("Fail to get debug mode response json.", e11);
            return false;
        }
    }

    public final boolean zzk(Context context, String str, String str2) {
        String strZzo = zzo(context, zzp(context, (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzeD), str, str2).toString(), str2);
        if (TextUtils.isEmpty(strZzo)) {
            zzcec.zze("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(strZzo.trim());
            String strOptString = jSONObject.optString("gct");
            this.zza = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjc)).booleanValue()) {
                boolean z11 = "0".equals(this.zza) || "2".equals(this.zza);
                zzf(z11);
                zzg zzgVarZzi = com.google.android.gms.ads.internal.zzt.zzo().zzi();
                if (!z11) {
                    str = "";
                }
                zzgVarZzi.zzA(str);
            }
            synchronized (this.zzb) {
                this.zzd = strOptString;
            }
            return true;
        } catch (JSONException e11) {
            zzcec.zzk("Fail to get in app preview response json.", e11);
            return false;
        }
    }

    public final boolean zzl() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zzf;
        }
        return z11;
    }

    public final boolean zzm() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zze;
        }
        return z11;
    }

    public final boolean zzn(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzm()) {
            return false;
        }
        zzcec.zze("Sending troubleshooting signals to the server.");
        zze(context, str, str2, str3);
        return true;
    }
}
