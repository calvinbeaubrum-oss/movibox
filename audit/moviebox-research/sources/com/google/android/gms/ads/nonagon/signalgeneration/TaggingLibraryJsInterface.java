package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzavi;
import com.google.android.gms.internal.ads.zzavj;
import com.google.android.gms.internal.ads.zzbgc;
import com.google.android.gms.internal.ads.zzcec;
import com.google.android.gms.internal.ads.zzcep;
import com.google.android.gms.internal.ads.zzdwk;
import com.google.android.gms.internal.ads.zzfhl;
import com.google.android.gms.internal.ads.zzfny;
import com.google.android.gms.internal.ads.zzgey;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class TaggingLibraryJsInterface {
    private final Context zza;
    private final WebView zzb;
    private final zzavi zzc;
    private final zzfhl zzd;
    private final int zze;
    private final zzdwk zzf;
    private final boolean zzg;
    private final zzgey zzh = zzcep.zze;
    private final zzfny zzi;

    public TaggingLibraryJsInterface(WebView webView, zzavi zzaviVar, zzdwk zzdwkVar, zzfny zzfnyVar, zzfhl zzfhlVar) {
        this.zzb = webView;
        Context context = webView.getContext();
        this.zza = context;
        this.zzc = zzaviVar;
        this.zzf = zzdwkVar;
        zzbgc.zza(context);
        this.zze = ((Integer) zzba.zzc().zza(zzbgc.zzjq)).intValue();
        this.zzg = ((Boolean) zzba.zzc().zza(zzbgc.zzjr)).booleanValue();
        this.zzi = zzfnyVar;
        this.zzd = zzfhlVar;
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getClickSignals(String str) {
        try {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            String strZze = this.zzc.zzc().zze(this.zza, str, this.zzb);
            if (this.zzg) {
                zzf.zzc(this.zzf, null, "csg", new Pair("clat", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - jCurrentTimeMillis)));
            }
            return strZze;
        } catch (RuntimeException e11) {
            zzcec.zzh("Exception getting click signals. ", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "TaggingLibraryJsInterface.getClickSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getClickSignalsWithTimeout(final String str, int i11) {
        if (i11 <= 0) {
            zzcec.zzg("Invalid timeout for getting click signals. Timeout=" + i11);
            return "";
        }
        try {
            return (String) zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzap
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.getClickSignals(str);
                }
            }).get(Math.min(i11, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            zzcec.zzh("Exception getting click signals with timeout. ", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "TaggingLibraryJsInterface.getClickSignalsWithTimeout");
            return e11 instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getQueryInfo() {
        com.google.android.gms.ads.internal.zzt.zzp();
        String string = UUID.randomUUID().toString();
        final Bundle bundle = new Bundle();
        bundle.putString("query_info_type", "requester_type_6");
        final zzar zzarVar = new zzar(this, string);
        if (((Boolean) zzba.zzc().zza(zzbgc.zzjt)).booleanValue()) {
            this.zzh.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzaq
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb(bundle, zzarVar);
                }
            });
        } else {
            QueryInfo.generate(this.zza, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), zzarVar);
        }
        return string;
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getViewSignals() {
        try {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            String strZzh = this.zzc.zzc().zzh(this.zza, this.zzb, null);
            if (this.zzg) {
                zzf.zzc(this.zzf, null, "vsg", new Pair("vlat", String.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - jCurrentTimeMillis)));
            }
            return strZzh;
        } catch (RuntimeException e11) {
            zzcec.zzh("Exception getting view signals. ", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "TaggingLibraryJsInterface.getViewSignals");
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public String getViewSignalsWithTimeout(int i11) {
        if (i11 <= 0) {
            zzcec.zzg("Invalid timeout for getting view signals. Timeout=" + i11);
            return "";
        }
        try {
            return (String) zzcep.zza.zzb(new Callable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzan
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return this.zza.getViewSignals();
                }
            }).get(Math.min(i11, this.zze), TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e11) {
            zzcec.zzh("Exception getting view signals with timeout. ", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "TaggingLibraryJsInterface.getViewSignalsWithTimeout");
            return e11 instanceof TimeoutException ? "17" : "";
        }
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public void recordClick(final String str) {
        if (!((Boolean) zzba.zzc().zza(zzbgc.zzjv)).booleanValue() || TextUtils.isEmpty(str)) {
            return;
        }
        zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zzao
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzc(str);
            }
        });
    }

    @JavascriptInterface
    @KeepForSdk
    @TargetApi(21)
    public void reportTouchEvent(String str) {
        int i11;
        try {
            JSONObject jSONObject = new JSONObject(str);
            int i12 = jSONObject.getInt("x");
            int i13 = jSONObject.getInt("y");
            int i14 = jSONObject.getInt("duration_ms");
            float f11 = (float) jSONObject.getDouble("force");
            int i15 = jSONObject.getInt("type");
            if (i15 == 0) {
                i11 = 0;
            } else if (i15 == 1) {
                i11 = 1;
            } else if (i15 != 2) {
                i11 = i15 != 3 ? -1 : 3;
            } else {
                i11 = 2;
            }
            try {
                this.zzc.zzd(MotionEvent.obtain(0L, i14, i11, i12, i13, f11, 1.0f, 0, 1.0f, 1.0f, 0, 0));
            } catch (RuntimeException e11) {
                e = e11;
                zzcec.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            } catch (JSONException e12) {
                e = e12;
                zzcec.zzh("Failed to parse the touch string. ", e);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "TaggingLibraryJsInterface.reportTouchEvent");
            }
        } catch (RuntimeException | JSONException e13) {
            e = e13;
        }
    }

    public final /* synthetic */ void zzb(Bundle bundle, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        CookieManager cookieManagerZza = com.google.android.gms.ads.internal.zzt.zzq().zza(this.zza);
        bundle.putBoolean("accept_3p_cookie", cookieManagerZza != null ? cookieManagerZza.acceptThirdPartyCookies(this.zzb) : false);
        QueryInfo.generate(this.zza, AdFormat.BANNER, new AdRequest.Builder().addNetworkExtrasBundle(AdMobAdapter.class, bundle).build(), queryInfoGenerationCallback);
    }

    public final /* synthetic */ void zzc(String str) {
        zzfhl zzfhlVar;
        Uri uriZza = Uri.parse(str);
        try {
            uriZza = (!((Boolean) zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || (zzfhlVar = this.zzd) == null) ? this.zzc.zza(uriZza, this.zza, this.zzb, null) : zzfhlVar.zza(uriZza, this.zza, this.zzb, null);
        } catch (zzavj e11) {
            zzcec.zzf("Failed to append the click signal to URL: ", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "TaggingLibraryJsInterface.recordClick");
        }
        this.zzi.zzc(uriZza.toString(), null);
    }
}
