package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.NotificationCompat;
import java.io.ByteArrayOutputStream;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzca implements zzd {
    private final Application zza;
    private final zzbw zzb;
    private final Handler zzc;
    private final Executor zzd;
    private final zze zze;
    private final zzan zzf;
    private final zzbb zzg;
    private final zzap zzh;

    public zzca(Application application, zzbw zzbwVar, Handler handler, Executor executor, zze zzeVar, zzan zzanVar, zzbb zzbbVar, zzap zzapVar) {
        this.zza = application;
        this.zzb = zzbwVar;
        this.zzc = handler;
        this.zzd = executor;
        this.zze = zzeVar;
        this.zzf = zzanVar;
        this.zzg = zzbbVar;
        this.zzh = zzapVar;
    }

    private final void zzg(JSONObject jSONObject) {
        String strOptString = jSONObject.optString("url");
        TextUtils.isEmpty(strOptString);
        Uri uri = Uri.parse(strOptString);
        if (uri.getScheme() == null) {
            "Action[browser]: empty scheme: ".concat(String.valueOf(strOptString));
        }
        try {
            this.zzb.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (ActivityNotFoundException unused) {
            "Action[browser]: can not open url: ".concat(String.valueOf(strOptString));
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final Executor zza() {
        final Handler handler = this.zzc;
        Objects.requireNonNull(handler);
        return new Executor() { // from class: com.google.android.gms.internal.consent_sdk.zzby
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x0035  */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.google.android.gms.internal.consent_sdk.zzd
    public final boolean zzb(String str, JSONObject jSONObject) {
        byte b11;
        byte b12 = -1;
        switch (str) {
            case "load_complete":
                b11 = 0;
                break;
            case "configure_app_assets":
                b11 = 3;
                break;
            case "browser":
                b11 = 2;
                break;
            case "dismiss":
                b11 = 1;
                break;
            default:
                b11 = -1;
                break;
        }
        if (b11 == 0) {
            this.zzg.zze();
            return true;
        }
        if (b11 != 1) {
            if (b11 == 2) {
                zzg(jSONObject);
                return true;
            }
            if (b11 != 3) {
                return false;
            }
            zzc();
            return true;
        }
        String strOptString = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
        switch (strOptString.hashCode()) {
            case -954325659:
                if (strOptString.equals("CONSENT_SIGNAL_NON_PERSONALIZED_ADS")) {
                    b12 = 3;
                }
                break;
            case -258041904:
                if (strOptString.equals("personalized")) {
                    b12 = 0;
                }
                break;
            case 429411856:
                if (strOptString.equals("CONSENT_SIGNAL_SUFFICIENT")) {
                    b12 = 4;
                }
                break;
            case 467888915:
                if (strOptString.equals("CONSENT_SIGNAL_PERSONALIZED_ADS")) {
                    b12 = 1;
                }
                break;
            case 1666911234:
                if (strOptString.equals("non_personalized")) {
                    b12 = 2;
                }
                break;
        }
        if (b12 == 0 || b12 == 1 || b12 == 2 || b12 == 3 || b12 == 4) {
            this.zzg.zzc(3);
        } else {
            this.zzg.zzd(new zzg(1, "We are getting something wrong with the webview."));
        }
        return true;
    }

    public final void zzc() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.consent_sdk.zzbz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd();
            }
        });
    }

    public final /* synthetic */ void zzd() {
        String strConcat;
        JSONObject jSONObject = new JSONObject();
        Application application = this.zza;
        try {
            jSONObject.put("app_name", application.getPackageManager().getApplicationLabel(application.getApplicationInfo()).toString());
            Drawable applicationIcon = application.getPackageManager().getApplicationIcon(application.getApplicationInfo());
            if (applicationIcon == null) {
                strConcat = null;
            } else {
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(applicationIcon.getIntrinsicWidth(), applicationIcon.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmapCreateBitmap);
                applicationIcon.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
                applicationIcon.draw(canvas);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmapCreateBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                strConcat = "data:image/png;base64,".concat(String.valueOf(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2)));
            }
            jSONObject.put("app_icon", strConcat);
            jSONObject.put("stored_infos_map", this.zzh.zzc());
        } catch (JSONException unused) {
        }
        this.zzg.zza().zzd("UMP_configureFormWithAppAssets", jSONObject.toString());
    }

    public final void zze(String str) {
        "Receive consent action: ".concat(String.valueOf(str));
        Uri uri = Uri.parse(str);
        this.zze.zzb(uri.getQueryParameter("action"), uri.getQueryParameter("args"), this, this.zzf);
    }

    public final void zzf(int i11, String str, String str2) {
        this.zzg.zzf(new zzg(2, String.format(Locale.US, "WebResourceError(%d, %s): %s", Integer.valueOf(i11), str2, str)));
    }
}
