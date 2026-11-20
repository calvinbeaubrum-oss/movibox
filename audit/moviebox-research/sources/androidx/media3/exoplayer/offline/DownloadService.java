package androidx.media3.exoplayer.offline;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.media3.exoplayer.scheduler.Requirements;
import com.applovin.sdk.AppLovinEventParameters;
import java.util.HashMap;
import java.util.List;
import z3.a0;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DownloadService extends Service {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap<Class<? extends DownloadService>, b> f10840l = new HashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final c f10841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f10842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @StringRes
    public final int f10843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @StringRes
    public final int f10844d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public b f10845f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f10846g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f10847h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f10848i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f10849j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10850k;

    /* JADX INFO: compiled from: source.java */
    public static final class b implements DownloadManager.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f10851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final DownloadManager f10852b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f10853c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public final o4.h f10854d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Class<? extends DownloadService> f10855e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public DownloadService f10856f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Requirements f10857g;

        public b(Context context, DownloadManager downloadManager, boolean z11, @Nullable o4.h hVar, Class<? extends DownloadService> cls) {
            this.f10851a = context;
            this.f10852b = downloadManager;
            this.f10853c = z11;
            this.f10854d = hVar;
            this.f10855e = cls;
            downloadManager.d(this);
            q();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void a(DownloadManager downloadManager, boolean z11) {
            if (z11 || downloadManager.g() || !p()) {
                return;
            }
            List<androidx.media3.exoplayer.offline.c> listE = downloadManager.e();
            for (int i11 = 0; i11 < listE.size(); i11++) {
                if (listE.get(i11).f10902b == 0) {
                    n();
                    return;
                }
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void b(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar) {
            DownloadService downloadService = this.f10856f;
            if (downloadService != null) {
                downloadService.u();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public /* synthetic */ void c(DownloadManager downloadManager, boolean z11) {
            j.a(this, downloadManager, z11);
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public final void d(DownloadManager downloadManager) {
            DownloadService downloadService = this.f10856f;
            if (downloadService != null) {
                downloadService.w();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void e(DownloadManager downloadManager, Requirements requirements, int i11) {
            q();
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void f(DownloadManager downloadManager, androidx.media3.exoplayer.offline.c cVar, @Nullable Exception exc) {
            DownloadService downloadService = this.f10856f;
            if (downloadService != null) {
                downloadService.t(cVar);
            }
            if (p() && DownloadService.s(cVar.f10902b)) {
                z3.o.h("DownloadService", "DownloadService wasn't running. Restarting.");
                n();
            }
        }

        @Override // androidx.media3.exoplayer.offline.DownloadManager.d
        public void g(DownloadManager downloadManager) {
            DownloadService downloadService = this.f10856f;
            if (downloadService != null) {
                downloadService.v(downloadManager.e());
            }
        }

        public void j(final DownloadService downloadService) {
            z3.a.g(this.f10856f == null);
            this.f10856f = downloadService;
            if (this.f10852b.l()) {
                u0.C().postAtFrontOfQueue(new Runnable() { // from class: androidx.media3.exoplayer.offline.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10914a.m(downloadService);
                    }
                });
            }
        }

        public final void k() {
            Requirements requirements = new Requirements(0);
            if (o(requirements)) {
                this.f10854d.cancel();
                this.f10857g = requirements;
            }
        }

        public void l(DownloadService downloadService) {
            z3.a.g(this.f10856f == downloadService);
            this.f10856f = null;
        }

        public final /* synthetic */ void m(DownloadService downloadService) {
            downloadService.v(this.f10852b.e());
        }

        public final void n() {
            if (this.f10853c) {
                try {
                    u0.r1(this.f10851a, DownloadService.o(this.f10851a, this.f10855e, "androidx.media3.exoplayer.downloadService.action.RESTART"));
                    return;
                } catch (IllegalStateException unused) {
                    z3.o.h("DownloadService", "Failed to restart (foreground launch restriction)");
                    return;
                }
            }
            try {
                this.f10851a.startService(DownloadService.o(this.f10851a, this.f10855e, "androidx.media3.exoplayer.downloadService.action.INIT"));
            } catch (IllegalStateException unused2) {
                z3.o.h("DownloadService", "Failed to restart (process is idle)");
            }
        }

        public final boolean o(Requirements requirements) {
            return !u0.c(this.f10857g, requirements);
        }

        public final boolean p() {
            DownloadService downloadService = this.f10856f;
            return downloadService == null || downloadService.r();
        }

        public boolean q() {
            boolean zM = this.f10852b.m();
            if (this.f10854d == null) {
                return !zM;
            }
            if (!zM) {
                k();
                return true;
            }
            Requirements requirementsI = this.f10852b.i();
            if (!this.f10854d.b(requirementsI).equals(requirementsI)) {
                k();
                return false;
            }
            if (!o(requirementsI)) {
                return true;
            }
            if (this.f10854d.a(requirementsI, this.f10851a.getPackageName(), "androidx.media3.exoplayer.downloadService.action.RESTART")) {
                this.f10857g = requirementsI;
                return true;
            }
            z3.o.h("DownloadService", "Failed to schedule restart");
            k();
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f10859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Handler f10860c = new Handler(Looper.getMainLooper());

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f10862e;

        public c(int i11, long j11) {
            this.f10858a = i11;
            this.f10859b = j11;
        }

        public void b() {
            if (this.f10862e) {
                f();
            }
        }

        public void c() {
            if (this.f10862e) {
                return;
            }
            f();
        }

        public void d() {
            this.f10861d = true;
            f();
        }

        public void e() {
            this.f10861d = false;
            this.f10860c.removeCallbacksAndMessages(null);
        }

        @SuppressLint({"InlinedApi"})
        public final void f() {
            DownloadManager downloadManager = ((b) z3.a.e(DownloadService.this.f10845f)).f10852b;
            Notification notificationN = DownloadService.this.n(downloadManager.e(), downloadManager.h());
            if (this.f10862e) {
                ((NotificationManager) DownloadService.this.getSystemService("notification")).notify(this.f10858a, notificationN);
            } else {
                u0.k1(DownloadService.this, this.f10858a, notificationN, 1, "dataSync");
                this.f10862e = true;
            }
            if (this.f10861d) {
                this.f10860c.removeCallbacksAndMessages(null);
                this.f10860c.postDelayed(new Runnable() { // from class: androidx.media3.exoplayer.offline.n
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f10916a.f();
                    }
                }, this.f10859b);
            }
        }
    }

    public DownloadService(int i11, long j11, @Nullable String str, @StringRes int i12, @StringRes int i13) {
        if (i11 == 0) {
            this.f10841a = null;
            this.f10842b = null;
            this.f10843c = 0;
            this.f10844d = 0;
            return;
        }
        this.f10841a = new c(i11, j11);
        this.f10842b = str;
        this.f10843c = i12;
        this.f10844d = i13;
    }

    public static void A(Context context, Intent intent, boolean z11) {
        if (z11) {
            u0.r1(context, intent);
        } else {
            context.startService(intent);
        }
    }

    public static Intent i(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, int i11, boolean z11) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD", z11).putExtra("download_request", downloadRequest).putExtra("stop_reason", i11);
    }

    public static Intent j(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z11) {
        return i(context, cls, downloadRequest, 0, z11);
    }

    public static Intent k(Context context, Class<? extends DownloadService> cls, String str, boolean z11) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD", z11).putExtra(AppLovinEventParameters.CONTENT_IDENTIFIER, str);
    }

    public static Intent l(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i11, boolean z11) {
        return p(context, cls, "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON", z11).putExtra(AppLovinEventParameters.CONTENT_IDENTIFIER, str).putExtra("stop_reason", i11);
    }

    public static Intent o(Context context, Class<? extends DownloadService> cls, String str) {
        return new Intent(context, cls).setAction(str);
    }

    public static Intent p(Context context, Class<? extends DownloadService> cls, String str, boolean z11) {
        return o(context, cls, str).putExtra(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.KEY_FOREGROUND, z11);
    }

    public static boolean s(int i11) {
        return i11 == 2 || i11 == 5 || i11 == 7;
    }

    public static void x(Context context, Class<? extends DownloadService> cls, DownloadRequest downloadRequest, boolean z11) {
        A(context, j(context, cls, downloadRequest, z11), z11);
    }

    public static void y(Context context, Class<? extends DownloadService> cls, String str, boolean z11) {
        A(context, k(context, cls, str, z11), z11);
    }

    public static void z(Context context, Class<? extends DownloadService> cls, @Nullable String str, int i11, boolean z11) {
        A(context, l(context, cls, str, i11, z11), z11);
    }

    public abstract DownloadManager m();

    public abstract Notification n(List<androidx.media3.exoplayer.offline.c> list, int i11);

    @Override // android.app.Service
    @Nullable
    public final IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    public void onCreate() {
        String str = this.f10842b;
        if (str != null) {
            a0.a(this, str, this.f10843c, this.f10844d, 2);
        }
        Class<?> cls = getClass();
        HashMap<Class<? extends DownloadService>, b> map = f10840l;
        b bVar = map.get(cls);
        if (bVar == null) {
            boolean z11 = this.f10841a != null;
            o4.h hVarQ = (z11 && (u0.f81838a < 31)) ? q() : null;
            DownloadManager downloadManagerM = m();
            downloadManagerM.x();
            bVar = new b(getApplicationContext(), downloadManagerM, z11, hVarQ, cls);
            map.put((Class<? extends DownloadService>) cls, bVar);
        }
        this.f10845f = bVar;
        bVar.j(this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        this.f10850k = true;
        ((b) z3.a.e(this.f10845f)).l(this);
        c cVar = this.f10841a;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i11, int i12) {
        String action;
        String stringExtra;
        c cVar;
        this.f10846g = i12;
        this.f10848i = false;
        if (intent != null) {
            action = intent.getAction();
            stringExtra = intent.getStringExtra(AppLovinEventParameters.CONTENT_IDENTIFIER);
            this.f10847h |= intent.getBooleanExtra(com.mbridge.msdk.playercommon.exoplayer2.offline.DownloadService.KEY_FOREGROUND, false) || "androidx.media3.exoplayer.downloadService.action.RESTART".equals(action);
        } else {
            action = null;
            stringExtra = null;
        }
        if (action == null) {
            action = "androidx.media3.exoplayer.downloadService.action.INIT";
        }
        DownloadManager downloadManager = ((b) z3.a.e(this.f10845f)).f10852b;
        switch (action) {
            case "androidx.media3.exoplayer.downloadService.action.SET_STOP_REASON":
                if (!((Intent) z3.a.e(intent)).hasExtra("stop_reason")) {
                    z3.o.c("DownloadService", "Ignored SET_STOP_REASON: Missing stop_reason extra");
                    break;
                } else {
                    downloadManager.A(stringExtra, intent.getIntExtra("stop_reason", 0));
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_DOWNLOAD":
                if (stringExtra != null) {
                    downloadManager.v(stringExtra);
                    break;
                } else {
                    z3.o.c("DownloadService", "Ignored REMOVE_DOWNLOAD: Missing content_id extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESTART":
            case "androidx.media3.exoplayer.downloadService.action.INIT":
                break;
            case "androidx.media3.exoplayer.downloadService.action.RESUME_DOWNLOADS":
                downloadManager.x();
                break;
            case "androidx.media3.exoplayer.downloadService.action.REMOVE_ALL_DOWNLOADS":
                downloadManager.u();
                break;
            case "androidx.media3.exoplayer.downloadService.action.ADD_DOWNLOAD":
                DownloadRequest downloadRequest = (DownloadRequest) ((Intent) z3.a.e(intent)).getParcelableExtra("download_request");
                if (downloadRequest != null) {
                    downloadManager.c(downloadRequest, intent.getIntExtra("stop_reason", 0));
                    break;
                } else {
                    z3.o.c("DownloadService", "Ignored ADD_DOWNLOAD: Missing download_request extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.SET_REQUIREMENTS":
                Requirements requirements = (Requirements) ((Intent) z3.a.e(intent)).getParcelableExtra("requirements");
                if (requirements != null) {
                    downloadManager.z(requirements);
                    break;
                } else {
                    z3.o.c("DownloadService", "Ignored SET_REQUIREMENTS: Missing requirements extra");
                    break;
                }
                break;
            case "androidx.media3.exoplayer.downloadService.action.PAUSE_DOWNLOADS":
                downloadManager.t();
                break;
            default:
                z3.o.c("DownloadService", "Ignored unrecognized action: " + action);
                break;
        }
        if (u0.f81838a >= 26 && this.f10847h && (cVar = this.f10841a) != null) {
            cVar.c();
        }
        this.f10849j = false;
        if (downloadManager.k()) {
            w();
        }
        return 1;
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent intent) {
        this.f10848i = true;
    }

    @Nullable
    public abstract o4.h q();

    public final boolean r() {
        return this.f10849j;
    }

    public final void t(androidx.media3.exoplayer.offline.c cVar) {
        if (this.f10841a != null) {
            if (s(cVar.f10902b)) {
                this.f10841a.d();
            } else {
                this.f10841a.b();
            }
        }
    }

    public final void u() {
        c cVar = this.f10841a;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void v(List<androidx.media3.exoplayer.offline.c> list) {
        if (this.f10841a != null) {
            for (int i11 = 0; i11 < list.size(); i11++) {
                if (s(list.get(i11).f10902b)) {
                    this.f10841a.d();
                    return;
                }
            }
        }
    }

    public final void w() {
        c cVar = this.f10841a;
        if (cVar != null) {
            cVar.e();
        }
        if (((b) z3.a.e(this.f10845f)).q()) {
            if (u0.f81838a >= 28 || !this.f10848i) {
                this.f10849j |= stopSelfResult(this.f10846g);
            } else {
                stopSelf();
                this.f10849j = true;
            }
        }
    }
}
