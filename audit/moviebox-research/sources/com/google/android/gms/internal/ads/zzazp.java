package com.google.android.gms.internal.ads;

import android.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.PlatformVersion;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzazp extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzazg zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzazp() {
        zzazg zzazgVar = new zzazg();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzazgVar;
        this.zzc = new Object();
        this.zzf = ((Long) zzbhs.zzd.zze()).intValue();
        this.zzg = ((Long) zzbhs.zza.zze()).intValue();
        this.zzh = ((Long) zzbhs.zze.zze()).intValue();
        this.zzi = ((Long) zzbhs.zzc.zze()).intValue();
        this.zzj = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzS)).intValue();
        this.zzk = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzT)).intValue();
        this.zzl = ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzU)).intValue();
        this.zze = ((Long) zzbhs.zzf.zze()).intValue();
        this.zzm = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzW);
        this.zzn = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzX)).booleanValue();
        this.zzo = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzY)).booleanValue();
        this.zzp = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzZ)).booleanValue();
        setName("ContentFetchTask");
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x00ed */
    /* JADX WARN: Code duplicated, block: B:62:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x00de A[EXC_TOP_SPLITTER, LOOP:1: B:66:0x00de->B:73:0x00de, LOOP_START, SYNTHETIC] */
    @Override // java.lang.Thread, java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        while (true) {
            try {
                Context contextZzb = com.google.android.gms.ads.internal.zzt.zzb().zzb();
                try {
                    if (contextZzb != null) {
                        ActivityManager activityManager = (ActivityManager) contextZzb.getSystemService("activity");
                        KeyguardManager keyguardManager = (KeyguardManager) contextZzb.getSystemService("keyguard");
                        if (activityManager != null && keyguardManager != null && (runningAppProcesses = activityManager.getRunningAppProcesses()) != null) {
                            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    ActivityManager.RunningAppProcessInfo next = it.next();
                                    if (Process.myPid() == next.pid) {
                                        if (next.importance == 100 && !keyguardManager.inKeyguardRestrictedInputMode() && (powerManager = (PowerManager) contextZzb.getSystemService("power")) != null && powerManager.isScreenOn()) {
                                            Activity activityZza = com.google.android.gms.ads.internal.zzt.zzb().zza();
                                            if (activityZza == null) {
                                                zzcec.zze("ContentFetchThread: no activity. Sleeping.");
                                                zzf();
                                            } else {
                                                View viewFindViewById = null;
                                                try {
                                                    if (activityZza.getWindow() != null && activityZza.getWindow().getDecorView() != null) {
                                                        viewFindViewById = activityZza.getWindow().getDecorView().findViewById(R.id.content);
                                                    }
                                                } catch (Exception e11) {
                                                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "ContentFetchTask.extractContent");
                                                    zzcec.zze("Failed getting root view of activity. Content not extracted.");
                                                }
                                                if (viewFindViewById != null) {
                                                    viewFindViewById.post(new zzazl(this, viewFindViewById));
                                                }
                                            }
                                        }
                                        Thread.sleep(this.zze * 1000);
                                    }
                                }
                            }
                        }
                        synchronized (this.zzc) {
                            while (this.zzb) {
                                try {
                                    zzcec.zze("ContentFetchTask: waiting");
                                    this.zzc.wait();
                                } catch (InterruptedException unused) {
                                }
                            }
                        }
                    }
                    zzcec.zze("ContentFetchTask: sleeping");
                    zzf();
                    Thread.sleep(this.zze * 1000);
                } catch (InterruptedException e12) {
                    zzcec.zzh("Error in ContentFetchTask", e12);
                } catch (Exception e13) {
                    zzcec.zzh("Error in ContentFetchTask", e13);
                    com.google.android.gms.ads.internal.zzt.zzo().zzw(e13, "ContentFetchTask.run");
                }
            } catch (Throwable th2) {
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "ContentFetchTask.isInForeground");
            }
            synchronized (this.zzc) {
                while (this.zzb) {
                    zzcec.zze("ContentFetchTask: waiting");
                    this.zzc.wait();
                }
            }
        }
    }

    public final zzazf zza() {
        return this.zzd.zza(this.zzp);
    }

    public final zzazo zzb(@Nullable View view, zzazf zzazfVar) {
        if (view != null) {
            boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
            if ((view instanceof TextView) && !(view instanceof EditText)) {
                CharSequence text = ((TextView) view).getText();
                if (!TextUtils.isEmpty(text)) {
                    zzazfVar.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), view.getWidth(), view.getHeight());
                    return new zzazo(this, 1, 0);
                }
            } else if ((view instanceof WebView) && !(view instanceof zzcjk)) {
                WebView webView = (WebView) view;
                if (PlatformVersion.isAtLeastKitKat()) {
                    zzazfVar.zzh();
                    webView.post(new zzazn(this, zzazfVar, webView, globalVisibleRect));
                    return new zzazo(this, 0, 1);
                }
            } else if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int i11 = 0;
                int i12 = 0;
                for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                    zzazo zzazoVarZzb = zzb(viewGroup.getChildAt(i13), zzazfVar);
                    i11 += zzazoVarZzb.zza;
                    i12 += zzazoVarZzb.zzb;
                }
                return new zzazo(this, i11, i12);
            }
        }
        return new zzazo(this, 0, 0);
    }

    public final void zzc(View view) {
        try {
            zzazf zzazfVar = new zzazf(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context contextZzb = com.google.android.gms.ads.internal.zzt.zzb().zzb();
            if (contextZzb != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(contextZzb.getResources().getIdentifier((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zzV), "id", contextZzb.getPackageName()));
                if (str != null && str.equals(this.zzm)) {
                    return;
                }
            }
            zzazo zzazoVarZzb = zzb(view, zzazfVar);
            zzazfVar.zzm();
            if (zzazoVarZzb.zza == 0 && zzazoVarZzb.zzb == 0) {
                return;
            }
            int i11 = zzazoVarZzb.zzb;
            if (i11 != 0) {
                if (i11 == 0) {
                }
                this.zzd.zzb(zzazfVar);
            } else if (zzazfVar.zzc() == 0) {
                return;
            }
            if (this.zzd.zzd(zzazfVar)) {
                return;
            }
            this.zzd.zzb(zzazfVar);
        } catch (Exception e11) {
            zzcec.zzh("Exception in fetchContentOnUIThread", e11);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(e11, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzd(zzazf zzazfVar, WebView webView, String str, boolean z11) {
        zzazfVar.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String strOptString = new JSONObject(str).optString(MimeTypes.BASE_TYPE_TEXT);
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzazfVar.zzl(strOptString, z11, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                } else {
                    zzazfVar.zzl(webView.getTitle() + "\n" + strOptString, z11, webView.getX(), webView.getY(), webView.getWidth(), webView.getHeight());
                }
            }
            if (zzazfVar.zzo()) {
                this.zzd.zzc(zzazfVar);
            }
        } catch (JSONException unused) {
            zzcec.zze("Json string may be malformed.");
        } catch (Throwable th2) {
            zzcec.zzf("Failed to get webview content.", th2);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(th2, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            try {
                if (this.zza) {
                    zzcec.zze("Content hash thread already started, quitting...");
                } else {
                    this.zza = true;
                    start();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            zzcec.zze("ContentFetchThread: paused, pause = true");
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzcec.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
