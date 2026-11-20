package com.google.android.exoplayer2.offline;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.exoplayer2.scheduler.Requirements;
import com.google.android.exoplayer2.util.a0;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.s;
import java.util.HashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DownloadService extends Service {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap<Class<? extends DownloadService>, a> f33635k = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f33636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @StringRes
    public final int f33637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @StringRes
    public final int f33638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f33639d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f33640f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f33641g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f33642h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f33643i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f33644j;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public DownloadService f33645a;

        public static /* synthetic */ DownloadManager a(a aVar) {
            aVar.getClass();
            return null;
        }

        public void b(DownloadService downloadService) {
            com.google.android.exoplayer2.util.a.g(this.f33645a == null);
            this.f33645a = downloadService;
            throw null;
        }

        public void c(DownloadService downloadService) {
            com.google.android.exoplayer2.util.a.g(this.f33645a == downloadService);
            this.f33645a = null;
        }
    }

    public abstract DownloadManager a();

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f33636a;
        if (str != null) {
            a0.a(this, str, this.f33637b, this.f33638c, 2);
        }
        a aVar = f33635k.get(getClass());
        if (aVar != null) {
            this.f33639d = aVar;
            aVar.b(this);
        } else {
            int i11 = o0.f35608a;
            a();
            throw null;
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f33644j = true;
        ((a) com.google.android.exoplayer2.util.a.e(this.f33639d)).c(this);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:18:0x0047  */
    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        String action;
        String stringExtra;
        this.f33640f = i12;
        this.f33642h = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra(AppLovinEventParameters.CONTENT_IDENTIFIER);
            this.f33641g |= intent.getBooleanExtra(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.KEY_FOREGROUND, false) || "com.google.android.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.ACTION_INIT;
        }
        a.a((a) com.google.android.exoplayer2.util.a.e(this.f33639d));
        switch (action) {
            case "com.google.android.exoplayer.downloadService.action.ADD_DOWNLOAD":
                if (((DownloadRequest) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("download_request")) != null) {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                s.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.RESTART":
            case "com.google.android.exoplayer.downloadService.action.INIT":
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_REQUIREMENTS":
                if (((Requirements) ((Intent) com.google.android.exoplayer2.util.a.e(intent)).getParcelableExtra("requirements")) != null) {
                    throw null;
                }
                s.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                break;
                break;
            case "com.google.android.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                throw null;
            case "com.google.android.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) com.google.android.exoplayer2.util.a.e(intent)).hasExtra("stop_reason")) {
                    s.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    intent.getIntExtra("stop_reason", 0);
                    throw null;
                }
                break;
            case "com.google.android.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    throw null;
                }
                s.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                break;
                break;
            default:
                s.c("DownloadService", "Ignored unrecognized action: " + action);
                break;
        }
        int i13 = o0.f35608a;
        this.f33643i = false;
        throw null;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f33642h = true;
    }
}
