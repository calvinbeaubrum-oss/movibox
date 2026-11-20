package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.alibaba.sdk.android.oss.common.OSSHeaders;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzcjs extends WebViewClient implements zzcky {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private int zzB;
    private boolean zzC;

    @Nullable
    private final zzehs zzE;
    private View.OnAttachStateChangeListener zzF;

    @Nullable
    protected zzcbs zza;
    private final zzcjk zzc;

    @Nullable
    private final zzbbp zzd;
    private com.google.android.gms.ads.internal.client.zza zzg;
    private com.google.android.gms.ads.internal.overlay.zzp zzh;
    private zzckw zzi;
    private zzckx zzj;
    private zzblw zzk;
    private zzbly zzl;
    private zzdiu zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private com.google.android.gms.ads.internal.overlay.zzaa zzv;

    @Nullable
    private zzbvv zzw;
    private com.google.android.gms.ads.internal.zzb zzx;
    private boolean zzz;
    private final HashMap zze = new HashMap();
    private final Object zzf = new Object();
    private int zzp = 0;
    private String zzq = "";
    private String zzr = "";
    private zzbvq zzy = null;
    private final HashSet zzD = new HashSet(Arrays.asList(((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfE)).split(",")));

    public zzcjs(zzcjk zzcjkVar, @Nullable zzbbp zzbbpVar, boolean z11, zzbvv zzbvvVar, @Nullable zzbvq zzbvqVar, @Nullable zzehs zzehsVar) {
        this.zzd = zzbbpVar;
        this.zzc = zzcjkVar;
        this.zzs = z11;
        this.zzw = zzbvvVar;
        this.zzE = zzehsVar;
    }

    @Nullable
    private static WebResourceResponse zzO() {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaJ)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    @Nullable
    private final WebResourceResponse zzP(String str, Map map) throws IOException {
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i11 = 0;
            while (true) {
                i11++;
                if (i11 > 20) {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
                URLConnection uRLConnectionOpenConnection = url.openConnection();
                uRLConnectionOpenConnection.setConnectTimeout(10000);
                uRLConnectionOpenConnection.setReadTimeout(10000);
                for (Map.Entry entry : map.entrySet()) {
                    uRLConnectionOpenConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
                }
                if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                    throw new IOException("Invalid protocol.");
                }
                HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                com.google.android.gms.ads.internal.zzt.zzp().zzf(this.zzc.getContext(), this.zzc.zzn().zza, false, httpURLConnection, false, 60000);
                WebResourceResponse webResourceResponseZzb = null;
                zzceb zzcebVar = new zzceb(null);
                zzcebVar.zzc(httpURLConnection, null);
                int responseCode = httpURLConnection.getResponseCode();
                zzcebVar.zze(httpURLConnection, responseCode);
                if (responseCode < 300 || responseCode >= 400) {
                    com.google.android.gms.ads.internal.zzt.zzp();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String contentType = httpURLConnection.getContentType();
                    String strTrim = "";
                    String strTrim2 = TextUtils.isEmpty(contentType) ? "" : contentType.split(";")[0].trim();
                    com.google.android.gms.ads.internal.zzt.zzp();
                    String contentType2 = httpURLConnection.getContentType();
                    if (!TextUtils.isEmpty(contentType2)) {
                        String[] strArrSplit = contentType2.split(";");
                        if (strArrSplit.length != 1) {
                            for (int i12 = 1; i12 < strArrSplit.length; i12++) {
                                if (strArrSplit[i12].trim().startsWith("charset")) {
                                    String[] strArrSplit2 = strArrSplit[i12].trim().split("=");
                                    if (strArrSplit2.length > 1) {
                                        strTrim = strArrSplit2[1].trim();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    String str2 = strTrim;
                    Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
                    HashMap map2 = new HashMap(headerFields.size());
                    for (Map.Entry<String, List<String>> entry2 : headerFields.entrySet()) {
                        if (entry2.getKey() != null && entry2.getValue() != null && !entry2.getValue().isEmpty()) {
                            map2.put(entry2.getKey(), entry2.getValue().get(0));
                        }
                    }
                    webResourceResponseZzb = com.google.android.gms.ads.internal.zzt.zzq().zzb(strTrim2, str2, httpURLConnection.getResponseCode(), httpURLConnection.getResponseMessage(), map2, httpURLConnection.getInputStream());
                } else {
                    String headerField = httpURLConnection.getHeaderField(HttpHeaders.LOCATION);
                    if (headerField == null) {
                        throw new IOException("Missing Location header in redirect");
                    }
                    if (!headerField.startsWith("tel:")) {
                        URL url2 = new URL(url, headerField);
                        String protocol = url2.getProtocol();
                        if (protocol == null) {
                            zzcec.zzj("Protocol is null");
                            webResourceResponseZzb = zzO();
                        } else if (protocol.equals(HttpHost.DEFAULT_SCHEME_NAME) || protocol.equals("https")) {
                            zzcec.zze("Redirecting to " + headerField);
                            httpURLConnection.disconnect();
                            url = url2;
                        } else {
                            zzcec.zzj("Unsupported scheme: " + protocol);
                            webResourceResponseZzb = zzO();
                        }
                    }
                }
                TrafficStats.clearThreadStatsTag();
                return webResourceResponseZzb;
            }
        } catch (Throwable th2) {
            TrafficStats.clearThreadStatsTag();
            throw th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ(Map map, List list, String str) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(str));
            for (String str2 : map.keySet()) {
                com.google.android.gms.ads.internal.util.zze.zza("  " + str2 + ": " + ((String) map.get(str2)));
            }
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((zzbng) it.next()).zza(this.zzc, map);
        }
    }

    private final void zzR() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzF;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzS(final View view, final zzcbs zzcbsVar, final int i11) {
        if (!zzcbsVar.zzi() || i11 <= 0) {
            return;
        }
        zzcbsVar.zzg(view);
        if (zzcbsVar.zzi()) {
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjl
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzp(view, zzcbsVar, i11);
                }
            }, 100L);
        }
    }

    private static final boolean zzT(zzcjk zzcjkVar) {
        if (zzcjkVar.zzD() != null) {
            return zzcjkVar.zzD().zzaj;
        }
        return false;
    }

    private static final boolean zzU(boolean z11, zzcjk zzcjkVar) {
        return (!z11 || zzcjkVar.zzO().zzi() || zzcjkVar.zzT().equals("interstitial_mb")) ? false : true;
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
        if (zzaVar != null) {
            zzaVar.onAdClicked();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("Loading resource: ".concat(String.valueOf(str)));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzj(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzf) {
            try {
                if (this.zzc.zzaB()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Blank page loaded, 1...");
                    this.zzc.zzV();
                    return;
                }
                this.zzz = true;
                zzckx zzckxVar = this.zzj;
                if (zzckxVar != null) {
                    zzckxVar.zza();
                    this.zzj = null;
                }
                zzg();
                if (this.zzc.zzL() != null) {
                    if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlm)).booleanValue()) {
                        this.zzc.zzL().zzG(str);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        this.zzo = true;
        this.zzp = i11;
        this.zzq = str;
        this.zzr = str2;
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaA(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Override // android.webkit.WebViewClient
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case ModuleDescriptor.MODULE_VERSION /* 86 */:
            case 87:
            case 88:
            case TsExtractor.TS_STREAM_TYPE_DVBSUBS /* 89 */:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case WebSocketProtocol.PAYLOAD_SHORT /* 126 */:
                    case 127:
                    case 128:
                    case TsExtractor.TS_STREAM_TYPE_AC3 /* 129 */:
                    case TsExtractor.TS_STREAM_TYPE_HDMV_DTS /* 130 */:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.google.android.gms.ads.internal.util.zze.zza("AdWebView shouldOverrideUrlLoading: ".concat(String.valueOf(str)));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzj(uriZza);
        } else {
            if (this.zzn && webView == this.zzc.zzG()) {
                String scheme = uriZza.getScheme();
                if (HttpHost.DEFAULT_SCHEME_NAME.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    com.google.android.gms.ads.internal.client.zza zzaVar = this.zzg;
                    if (zzaVar != null) {
                        zzaVar.onAdClicked();
                        zzcbs zzcbsVar = this.zza;
                        if (zzcbsVar != null) {
                            zzcbsVar.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdiu zzdiuVar = this.zzm;
                    if (zzdiuVar != null) {
                        zzdiuVar.zzs();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzc.zzG().willNotDraw()) {
                zzcec.zzj("AdWebView unable to handle URL: ".concat(String.valueOf(str)));
            } else {
                try {
                    zzavi zzaviVarZzI = this.zzc.zzI();
                    zzfhl zzfhlVarZzQ = this.zzc.zzQ();
                    if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzlr)).booleanValue() || zzfhlVarZzQ == null) {
                        if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                            Context context = this.zzc.getContext();
                            zzcjk zzcjkVar = this.zzc;
                            uriZza = zzaviVarZzI.zza(uriZza, context, (View) zzcjkVar, zzcjkVar.zzi());
                        }
                    } else if (zzaviVarZzI != null && zzaviVarZzI.zzf(uriZza)) {
                        Context context2 = this.zzc.getContext();
                        zzcjk zzcjkVar2 = this.zzc;
                        uriZza = zzfhlVarZzQ.zza(uriZza, context2, (View) zzcjkVar2, zzcjkVar2.zzi());
                    }
                } catch (zzavj unused) {
                    zzcec.zzj("Unable to append parameter to URL: ".concat(String.valueOf(str)));
                }
                com.google.android.gms.ads.internal.zzb zzbVar = this.zzx;
                if (zzbVar == null || zzbVar.zzc()) {
                    zzu(new com.google.android.gms.ads.internal.overlay.zzc("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null, null), true);
                } else {
                    zzbVar.zzb(str);
                }
            }
        }
        return true;
    }

    public final void zzA(String str, zzbng zzbngVar) {
        synchronized (this.zzf) {
            try {
                List copyOnWriteArrayList = (List) this.zze.get(str);
                if (copyOnWriteArrayList == null) {
                    copyOnWriteArrayList = new CopyOnWriteArrayList();
                    this.zze.put(str, copyOnWriteArrayList);
                }
                copyOnWriteArrayList.add(zzbngVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzB(zzckw zzckwVar) {
        this.zzi = zzckwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzC(int i11, int i12) {
        zzbvq zzbvqVar = this.zzy;
        if (zzbvqVar != null) {
            zzbvqVar.zze(i11, i12);
        }
    }

    public final void zzD(boolean z11) {
        this.zzn = false;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzE(boolean z11) {
        synchronized (this.zzf) {
            this.zzu = z11;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzF() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzs = true;
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjm
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzn();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzG(boolean z11) {
        synchronized (this.zzf) {
            this.zzt = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzH(zzckx zzckxVar) {
        this.zzj = zzckxVar;
    }

    public final void zzI(String str, zzbng zzbngVar) {
        synchronized (this.zzf) {
            try {
                List list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                list.remove(zzbngVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzJ(String str, Predicate predicate) {
        synchronized (this.zzf) {
            try {
                List<zzbng> list = (List) this.zze.get(str);
                if (list == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (zzbng zzbngVar : list) {
                    if (predicate.apply(zzbngVar)) {
                        arrayList.add(zzbngVar);
                    }
                }
                list.removeAll(arrayList);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean zzK() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzu;
        }
        return z11;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final boolean zzL() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzs;
        }
        return z11;
    }

    public final boolean zzM() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzt;
        }
        return z11;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzN(@Nullable com.google.android.gms.ads.internal.client.zza zzaVar, @Nullable zzblw zzblwVar, @Nullable com.google.android.gms.ads.internal.overlay.zzp zzpVar, @Nullable zzbly zzblyVar, @Nullable com.google.android.gms.ads.internal.overlay.zzaa zzaaVar, boolean z11, @Nullable zzbni zzbniVar, @Nullable com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbvx zzbvxVar, @Nullable zzcbs zzcbsVar, @Nullable final zzehh zzehhVar, @Nullable final zzfny zzfnyVar, @Nullable zzdwf zzdwfVar, @Nullable zzflw zzflwVar, @Nullable zzbnz zzbnzVar, @Nullable final zzdiu zzdiuVar, @Nullable zzbny zzbnyVar, @Nullable zzbns zzbnsVar, @Nullable final zzcse zzcseVar) {
        com.google.android.gms.ads.internal.zzb zzbVar2 = zzbVar == null ? new com.google.android.gms.ads.internal.zzb(this.zzc.getContext(), zzcbsVar, null) : zzbVar;
        this.zzy = new zzbvq(this.zzc, zzbvxVar);
        this.zza = zzcbsVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzaR)).booleanValue()) {
            zzA("/adMetadata", new zzblv(zzblwVar));
        }
        if (zzblyVar != null) {
            zzA("/appEvent", new zzblx(zzblyVar));
        }
        zzA("/backButton", zzbnf.zzj);
        zzA("/refresh", zzbnf.zzk);
        zzA("/canOpenApp", zzbnf.zzb);
        zzA("/canOpenURLs", zzbnf.zza);
        zzA("/canOpenIntents", zzbnf.zzc);
        zzA("/close", zzbnf.zzd);
        zzA("/customClose", zzbnf.zze);
        zzA("/instrument", zzbnf.zzn);
        zzA("/delayPageLoaded", zzbnf.zzp);
        zzA("/delayPageClosed", zzbnf.zzq);
        zzA("/getLocationInfo", zzbnf.zzr);
        zzA("/log", zzbnf.zzg);
        zzA("/mraid", new zzbnm(zzbVar2, this.zzy, zzbvxVar));
        zzbvv zzbvvVar = this.zzw;
        if (zzbvvVar != null) {
            zzA("/mraidLoaded", zzbvvVar);
        }
        com.google.android.gms.ads.internal.zzb zzbVar3 = zzbVar2;
        zzA("/open", new zzbnr(zzbVar2, this.zzy, zzehhVar, zzdwfVar, zzflwVar, zzcseVar));
        zzA("/precache", new zzchx());
        zzA("/touch", zzbnf.zzi);
        zzA("/video", zzbnf.zzl);
        zzA("/videoMeta", zzbnf.zzm);
        if (zzehhVar == null || zzfnyVar == null) {
            zzA("/click", new zzbme(zzdiuVar, zzcseVar));
            zzA("/httpTrack", zzbnf.zzf);
        } else {
            zzA("/click", new zzbng() { // from class: com.google.android.gms.internal.ads.zzfhp
                @Override // com.google.android.gms.internal.ads.zzbng
                public final void zza(Object obj, Map map) {
                    zzcjk zzcjkVar = (zzcjk) obj;
                    zzbnf.zzc(map, zzdiuVar);
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzcec.zzj("URL missing from click GMSG.");
                        return;
                    }
                    zzehh zzehhVar2 = zzehhVar;
                    zzfny zzfnyVar2 = zzfnyVar;
                    zzgen.zzr(zzbnf.zza(zzcjkVar, str), new zzfhr(zzcjkVar, zzcseVar, zzfnyVar2, zzehhVar2), zzcep.zza);
                }
            });
            zzA("/httpTrack", new zzbng() { // from class: com.google.android.gms.internal.ads.zzfhq
                @Override // com.google.android.gms.internal.ads.zzbng
                public final void zza(Object obj, Map map) {
                    zzcjb zzcjbVar = (zzcjb) obj;
                    String str = (String) map.get("u");
                    if (str == null) {
                        zzcec.zzj("URL missing from httpTrack GMSG.");
                    } else if (zzcjbVar.zzD().zzaj) {
                        zzehhVar.zzd(new zzehj(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis(), ((zzckj) zzcjbVar).zzP().zzb, str, 2));
                    } else {
                        zzfnyVar.zzc(str, null);
                    }
                }
            });
        }
        if (com.google.android.gms.ads.internal.zzt.zzn().zzp(this.zzc.getContext())) {
            zzA("/logScionEvent", new zzbnl(this.zzc.getContext()));
        }
        if (zzbniVar != null) {
            zzA("/setInterstitialProperties", new zzbnh(zzbniVar));
        }
        if (zzbnzVar != null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziN)).booleanValue()) {
                zzA("/inspectorNetworkExtras", zzbnzVar);
            }
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjg)).booleanValue() && zzbnyVar != null) {
            zzA("/shareSheet", zzbnyVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzjl)).booleanValue() && zzbnsVar != null) {
            zzA("/inspectorOutOfContextTest", zzbnsVar);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzkT)).booleanValue()) {
            zzA("/bindPlayStoreOverlay", zzbnf.zzu);
            zzA("/presentPlayStoreOverlay", zzbnf.zzv);
            zzA("/expandPlayStoreOverlay", zzbnf.zzw);
            zzA("/collapsePlayStoreOverlay", zzbnf.zzx);
            zzA("/closePlayStoreOverlay", zzbnf.zzy);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzda)).booleanValue()) {
            zzA("/setPAIDPersonalizationEnabled", zzbnf.zzA);
            zzA("/resetPAID", zzbnf.zzz);
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzll)).booleanValue()) {
            zzcjk zzcjkVar = this.zzc;
            if (zzcjkVar.zzD() != null && zzcjkVar.zzD().zzar) {
                zzA("/writeToLocalStorage", zzbnf.zzB);
                zzA("/clearLocalStorageKeys", zzbnf.zzC);
            }
        }
        this.zzg = zzaVar;
        this.zzh = zzpVar;
        this.zzk = zzblwVar;
        this.zzl = zzblyVar;
        this.zzv = zzaaVar;
        this.zzx = zzbVar3;
        this.zzm = zzdiuVar;
        this.zzn = z11;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzbo() {
        zzdiu zzdiuVar = this.zzm;
        if (zzdiuVar != null) {
            zzdiuVar.zzbo();
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0087  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARN: Type inference failed for: r11v9 */
    @Nullable
    public final WebResourceResponse zzc(String str, Map map) throws Throwable {
        int i11;
        InputStream inputStreamZza;
        Long l11;
        boolean z11;
        InputStream inputStreamZzc;
        final boolean z12;
        boolean z13;
        final boolean z14;
        String str2;
        try {
            String strZzc = zzccj.zzc(str, this.zzc.getContext(), this.zzC);
            if (!strZzc.equals(str)) {
                return zzP(strZzc, map);
            }
            zzbbb zzbbbVarZza = zzbbb.zza(Uri.parse(str));
            if (zzbbbVarZza != null) {
                HashMap map2 = new HashMap();
                map2.put(OSSHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
                Uri uri = Uri.parse(str);
                if (uri.getQueryParameterNames().contains("range")) {
                    List listZzf = zzfxr.zzc(zzfwp.zzc('-')).zzf(uri.getQueryParameter("range"));
                    if (listZzf.size() == 2) {
                        int i12 = Integer.parseInt((String) listZzf.get(0));
                        int i13 = Integer.parseInt((String) listZzf.get(1)) + 1;
                        if (i12 > 0) {
                            zzbbbVarZza.zzh = i12;
                        }
                        i11 = i13 - i12;
                    } else {
                        i11 = -1;
                    }
                } else {
                    i11 = -1;
                }
                final ?? r11 = "X-Afma-Gcache-HasAdditionalMetadataFromReadV2";
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzej)).booleanValue()) {
                    zzbbbVarZza.zzi = zzfxt.zzc(this.zzc.zzr());
                    zzbbbVarZza.zzj = this.zzc.zzf();
                    if (zzbbbVarZza.zzg) {
                        l11 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzel);
                    } else {
                        l11 = (Long) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzek);
                    }
                    try {
                        long jLongValue = l11.longValue();
                        long jElapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
                        com.google.android.gms.ads.internal.zzt.zzd();
                        Future futureZza = zzbbm.zza(this.zzc.getContext(), zzbbbVarZza);
                        try {
                            zzbbn zzbbnVar = (zzbbn) futureZza.get(jLongValue, TimeUnit.MILLISECONDS);
                            try {
                                try {
                                    map2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbbnVar.zzd()));
                                    map2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbbnVar.zzf()));
                                    map2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbbnVar.zze()));
                                    map2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbbnVar.zza()));
                                    inputStreamZzc = zzbbnVar.zzc();
                                    if (i11 != -1) {
                                        try {
                                            inputStreamZzc = zzgci.zza(inputStreamZzc, i11);
                                        } catch (InterruptedException unused) {
                                            z13 = true;
                                            z14 = true;
                                            futureZza.cancel(z13);
                                            Thread.currentThread().interrupt();
                                            final long jElapsedRealtime2 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzo(z14, jElapsedRealtime2);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime2 + "ms";
                                            r11 = z14;
                                        } catch (ExecutionException | TimeoutException unused2) {
                                            z11 = true;
                                            z12 = true;
                                            futureZza.cancel(z11);
                                            final long jElapsedRealtime3 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                                @Override // java.lang.Runnable
                                                public final void run() {
                                                    this.zza.zzo(z12, jElapsedRealtime3);
                                                }
                                            });
                                            str2 = "Cache connection took " + jElapsedRealtime3 + "ms";
                                            r11 = z12;
                                        }
                                    }
                                    final long jElapsedRealtime4 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                    final boolean z15 = true;
                                    com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzo(z15, jElapsedRealtime4);
                                        }
                                    });
                                    str2 = "Cache connection took " + jElapsedRealtime4 + "ms";
                                } catch (Throwable th2) {
                                    th = th2;
                                    r11 = 1;
                                    final long jElapsedRealtime5 = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - jElapsedRealtime;
                                    com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjo
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            this.zza.zzo(r11, jElapsedRealtime5);
                                        }
                                    });
                                    com.google.android.gms.ads.internal.util.zze.zza("Cache connection took " + jElapsedRealtime5 + "ms");
                                    throw th;
                                }
                            } catch (InterruptedException unused3) {
                                z13 = true;
                                inputStreamZzc = null;
                            } catch (ExecutionException | TimeoutException unused4) {
                                z11 = true;
                                inputStreamZzc = null;
                            }
                        } catch (InterruptedException unused5) {
                            z13 = true;
                            inputStreamZzc = null;
                            z14 = false;
                        } catch (ExecutionException | TimeoutException unused6) {
                            z11 = true;
                            inputStreamZzc = null;
                            z12 = false;
                        } catch (Throwable th3) {
                            th = th3;
                            r11 = 0;
                        }
                        com.google.android.gms.ads.internal.util.zze.zza(str2);
                        inputStreamZza = inputStreamZzc;
                    } catch (Throwable th4) {
                        th = th4;
                    }
                } else {
                    zzbay zzbayVarZzb = com.google.android.gms.ads.internal.zzt.zzc().zzb(zzbbbVarZza);
                    if (zzbayVarZzb == null || !zzbayVarZzb.zze()) {
                        inputStreamZza = null;
                    } else {
                        map2.put("X-Afma-Gcache-HasAdditionalMetadataFromReadV2", Boolean.toString(zzbayVarZzb.zzd()));
                        map2.put("X-Afma-Gcache-IsGcacheHit", Boolean.toString(zzbayVarZzb.zzg()));
                        map2.put("X-Afma-Gcache-IsDownloaded", Boolean.toString(zzbayVarZzb.zzf()));
                        map2.put("X-Afma-Gcache-CachedBytes", Long.toString(zzbayVarZzb.zza()));
                        InputStream inputStreamZzc2 = zzbayVarZzb.zzc();
                        inputStreamZza = i11 != -1 ? zzgci.zza(inputStreamZzc2, i11) : inputStreamZzc2;
                    }
                }
                if (inputStreamZza != null) {
                    return new WebResourceResponse("", "", 200, "OK", map2, inputStreamZza);
                }
            }
            if (zzceb.zzk() && ((Boolean) zzbhw.zzb.zze()).booleanValue()) {
                return zzP(str, map);
            }
            return null;
        } catch (Exception e11) {
            e = e11;
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdWebViewClient.interceptRequest");
            return zzO();
        } catch (NoClassDefFoundError e12) {
            e = e12;
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e, "AdWebViewClient.interceptRequest");
            return zzO();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final com.google.android.gms.ads.internal.zzb zzd() {
        return this.zzx;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzz && this.zzB <= 0) || this.zzA || this.zzo)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzbQ)).booleanValue() && this.zzc.zzm() != null) {
                zzbgm.zza(this.zzc.zzm().zza(), this.zzc.zzk(), "awfllc");
            }
            zzckw zzckwVar = this.zzi;
            boolean z11 = false;
            if (!this.zzA && !this.zzo) {
                z11 = true;
            }
            zzckwVar.zza(z11, this.zzp, this.zzq, this.zzr);
            this.zzi = null;
        }
        this.zzc.zzad();
    }

    public final void zzh() {
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            zzcbsVar.zze();
            this.zza = null;
        }
        zzR();
        synchronized (this.zzf) {
            try {
                this.zze.clear();
                this.zzg = null;
                this.zzh = null;
                this.zzi = null;
                this.zzj = null;
                this.zzk = null;
                this.zzl = null;
                this.zzn = false;
                this.zzs = false;
                this.zzt = false;
                this.zzv = null;
                this.zzx = null;
                this.zzw = null;
                zzbvq zzbvqVar = this.zzy;
                if (zzbvqVar != null) {
                    zzbvqVar.zza(true);
                    this.zzy = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzi(boolean z11) {
        this.zzC = z11;
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzj(Uri uri) {
        com.google.android.gms.ads.internal.util.zze.zza("Received GMSG: ".concat(String.valueOf(uri)));
        HashMap map = this.zze;
        String path = uri.getPath();
        List list = (List) map.get(path);
        if (path == null || list == null) {
            com.google.android.gms.ads.internal.util.zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzgM)).booleanValue() || com.google.android.gms.ads.internal.zzt.zzo().zzg() == null) {
                return;
            }
            final String strSubstring = (path == null || path.length() < 2) ? "null" : path.substring(1);
            zzcep.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcjn
                @Override // java.lang.Runnable
                public final void run() throws Throwable {
                    int i11 = zzcjs.zzb;
                    com.google.android.gms.ads.internal.zzt.zzo().zzg().zze(strSubstring);
                }
            });
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfD)).booleanValue() && this.zzD.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzfF)).intValue()) {
                com.google.android.gms.ads.internal.util.zze.zza("Parsing gmsg query params on BG thread: ".concat(path));
                zzgen.zzr(com.google.android.gms.ads.internal.zzt.zzp().zzb(uri), new zzcjq(this, list, path, uri), zzcep.zze);
                return;
            }
        }
        com.google.android.gms.ads.internal.zzt.zzp();
        zzQ(com.google.android.gms.ads.internal.util.zzt.zzO(uri), list, path);
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzk() {
        zzbbp zzbbpVar = this.zzd;
        if (zzbbpVar != null) {
            zzbbpVar.zzc(10005);
        }
        this.zzA = true;
        this.zzp = 10004;
        this.zzq = "Page loaded delay cancel.";
        zzg();
        this.zzc.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzl() {
        synchronized (this.zzf) {
        }
        this.zzB++;
        zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzm() {
        this.zzB--;
        zzg();
    }

    public final /* synthetic */ void zzn() {
        this.zzc.zzab();
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zzc.zzL();
        if (zzmVarZzL != null) {
            zzmVarZzL.zzz();
        }
    }

    public final /* synthetic */ void zzo(boolean z11, long j11) {
        this.zzc.zzv(z11, j11);
    }

    public final /* synthetic */ void zzp(View view, zzcbs zzcbsVar, int i11) {
        zzS(view, zzcbsVar, i11 - 1);
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzq(int i11, int i12, boolean z11) {
        zzbvv zzbvvVar = this.zzw;
        if (zzbvvVar != null) {
            zzbvvVar.zzb(i11, i12);
        }
        zzbvq zzbvqVar = this.zzy;
        if (zzbvqVar != null) {
            zzbvqVar.zzd(i11, i12, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcky
    public final void zzr() {
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            WebView webViewZzG = this.zzc.zzG();
            if (ViewCompat.isAttachedToWindow(webViewZzG)) {
                zzS(webViewZzG, zzcbsVar, 10);
                return;
            }
            zzR();
            zzcjp zzcjpVar = new zzcjp(this, zzcbsVar);
            this.zzF = zzcjpVar;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcjpVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdiu
    public final void zzs() {
        zzdiu zzdiuVar = this.zzm;
        if (zzdiuVar != null) {
            zzdiuVar.zzs();
        }
    }

    public final void zzu(com.google.android.gms.ads.internal.overlay.zzc zzcVar, boolean z11) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z12 = true;
        if (!zZzU && z11) {
            z12 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = zZzaC ? null : this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcVar, zzaVar, zzpVar, zzaaVar, zzcjkVar2.zzn(), zzcjkVar2, z12 ? null : this.zzm));
    }

    public final void zzv(String str, String str2, int i11) {
        zzehs zzehsVar = this.zzE;
        zzcjk zzcjkVar = this.zzc;
        zzx(new AdOverlayInfoParcel(zzcjkVar, zzcjkVar.zzn(), str, str2, 14, zzehsVar));
    }

    public final void zzw(boolean z11, int i11, boolean z12) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzU = zzU(zzcjkVar.zzaC(), zzcjkVar);
        boolean z13 = true;
        if (!zZzU && z12) {
            z13 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzh;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzpVar, zzaaVar, zzcjkVar2, z11, i11, zzcjkVar2.zzn(), z13 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null));
    }

    public final void zzx(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzc zzcVar;
        zzbvq zzbvqVar = this.zzy;
        boolean zZzf = zzbvqVar != null ? zzbvqVar.zzf() : false;
        com.google.android.gms.ads.internal.zzt.zzi();
        com.google.android.gms.ads.internal.overlay.zzn.zza(this.zzc.getContext(), adOverlayInfoParcel, !zZzf);
        zzcbs zzcbsVar = this.zza;
        if (zzcbsVar != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzcVar = adOverlayInfoParcel.zza) != null) {
                str = zzcVar.zzb;
            }
            zzcbsVar.zzh(str);
        }
    }

    public final void zzy(boolean z11, int i11, String str, String str2, boolean z12) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z13 = true;
        if (!zZzU && z12) {
            z13 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        zzcjr zzcjrVar = zZzaC ? null : new zzcjr(this.zzc, this.zzh);
        zzblw zzblwVar = this.zzk;
        zzbly zzblyVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzcjrVar, zzblwVar, zzblyVar, zzaaVar, zzcjkVar2, z11, i11, str, str2, zzcjkVar2.zzn(), z13 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null));
    }

    public final void zzz(boolean z11, int i11, String str, boolean z12, boolean z13) {
        zzcjk zzcjkVar = this.zzc;
        boolean zZzaC = zzcjkVar.zzaC();
        boolean zZzU = zzU(zZzaC, zzcjkVar);
        boolean z14 = true;
        if (!zZzU && z12) {
            z14 = false;
        }
        com.google.android.gms.ads.internal.client.zza zzaVar = zZzU ? null : this.zzg;
        zzcjr zzcjrVar = zZzaC ? null : new zzcjr(this.zzc, this.zzh);
        zzblw zzblwVar = this.zzk;
        zzbly zzblyVar = this.zzl;
        com.google.android.gms.ads.internal.overlay.zzaa zzaaVar = this.zzv;
        zzcjk zzcjkVar2 = this.zzc;
        zzx(new AdOverlayInfoParcel(zzaVar, zzcjrVar, zzblwVar, zzblyVar, zzaaVar, zzcjkVar2, z11, i11, str, zzcjkVar2.zzn(), z14 ? null : this.zzm, zzT(this.zzc) ? this.zzE : null, z13));
    }
}
