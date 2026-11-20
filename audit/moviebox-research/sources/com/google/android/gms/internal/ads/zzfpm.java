package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfpm extends zzfpi {
    private WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfpm(Map map, String str) {
        this.zzc = map;
    }

    @Override // com.google.android.gms.internal.ads.zzfpi
    public final void zzc() {
        super.zzc();
        new Handler().postDelayed(new zzfpl(this), Math.max(4000 - (this.zzb == null ? 4000L : TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS)), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS));
        this.zza = null;
    }

    @Override // com.google.android.gms.internal.ads.zzfpi
    public final void zzg(zzfoh zzfohVar, zzfof zzfofVar) {
        JSONObject jSONObject = new JSONObject();
        Map mapZzi = zzfofVar.zzi();
        Iterator it = mapZzi.keySet().iterator();
        if (it.hasNext()) {
            throw null;
        }
        zzh(zzfohVar, zzfofVar, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzfpi
    public final void zzk() {
        WebView webView = new WebView(zzfoz.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfpk(this));
        zzj(this.zza);
        zzfpb.zzi(this.zza, null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
        } else {
            throw null;
        }
    }
}
