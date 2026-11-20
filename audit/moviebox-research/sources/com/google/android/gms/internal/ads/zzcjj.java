package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcjj extends WebChromeClient {
    private final zzcjk zza;

    public zzcjj(zzcjk zzcjkVar) {
        this.zza = zzcjkVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcjk)) {
            return webView.getContext();
        }
        zzcjk zzcjkVar = (zzcjk) webView;
        Activity activityZzi = zzcjkVar.zzi();
        return activityZzi != null ? activityZzi : zzcjkVar.getContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcjk)) {
            zzcec.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = ((zzcjk) webView).zzL();
        if (zzmVarZzL == null) {
            zzcec.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzmVarZzL.zzb();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i11 = zzcji.zza[consoleMessage.messageLevel().ordinal()];
        if (i11 == 1) {
            zzcec.zzg(str);
        } else if (i11 == 2) {
            zzcec.zzj(str);
        } else if (i11 == 3 || i11 == 4 || i11 != 5) {
            zzcec.zzi(str);
        } else {
            zzcec.zze(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    @Override // android.webkit.WebChromeClient
    public final void onExceededDatabaseQuota(String str, String str2, long j11, long j12, long j13, WebStorage.QuotaUpdater quotaUpdater) {
        long j14 = 5242880 - j13;
        if (j14 <= 0) {
            quotaUpdater.updateQuota(j11);
            return;
        }
        if (j11 == 0) {
            if (j12 > j14 || j12 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                j12 = 0;
            }
        } else if (j12 == 0) {
            j12 = Math.min(j11 + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j14), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } else {
            if (j12 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j11, j14)) {
                j11 += j12;
            }
            j12 = j11;
        }
        quotaUpdater.updateQuota(j12);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0025  */
    @Override // android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z11;
        if (callback != null) {
            zzcjk zzcjkVar = this.zza;
            com.google.android.gms.ads.internal.zzt.zzp();
            if (com.google.android.gms.ads.internal.util.zzt.zzz(zzcjkVar.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                z11 = true;
            } else {
                zzcjk zzcjkVar2 = this.zza;
                com.google.android.gms.ads.internal.zzt.zzp();
                if (com.google.android.gms.ads.internal.util.zzt.zzz(zzcjkVar2.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            callback.invoke(str, z11, true);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL == null) {
            zzcec.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzmVarZzL.zzg();
        }
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, null, jsResult, null, false);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, null, jsPromptResult, true);
    }

    @Override // android.webkit.WebChromeClient
    @Deprecated
    public final void onShowCustomView(View view, int i11, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzmVarZzL = this.zza.zzL();
        if (zzmVarZzL == null) {
            zzcec.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
        } else {
            zzmVarZzL.zzC(view, customViewCallback);
            zzmVarZzL.zzA(i11);
        }
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }

    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z11) {
        com.google.android.gms.ads.internal.zzb zzbVarZzd;
        try {
            zzcjk zzcjkVar = this.zza;
            if (zzcjkVar != null && zzcjkVar.zzN() != null && this.zza.zzN().zzd() != null && (zzbVarZzd = this.zza.zzN().zzd()) != null && !zzbVarZzd.zzc()) {
                zzbVarZzd.zzb("window." + str + "('" + str3 + "')");
                return false;
            }
            com.google.android.gms.ads.internal.zzt.zzp();
            AlertDialog.Builder builderZzJ = com.google.android.gms.ads.internal.util.zzt.zzJ(context);
            builderZzJ.setTitle(str2);
            if (z11) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                TextView textView = new TextView(context);
                textView.setText(str3);
                EditText editText = new EditText(context);
                editText.setText(str4);
                linearLayout.addView(textView);
                linearLayout.addView(editText);
                builderZzJ.setView(linearLayout).setPositiveButton(R.string.ok, new zzcjh(jsPromptResult, editText)).setNegativeButton(R.string.cancel, new zzcjg(jsPromptResult)).setOnCancelListener(new zzcjf(jsPromptResult)).create().show();
            } else {
                builderZzJ.setMessage(str3).setPositiveButton(R.string.ok, new zzcje(jsResult)).setNegativeButton(R.string.cancel, new zzcjd(jsResult)).setOnCancelListener(new zzcjc(jsResult)).create().show();
            }
            return true;
        } catch (WindowManager.BadTokenException e11) {
            zzcec.zzk("Fail to display Dialog.", e11);
        }
    }
}
