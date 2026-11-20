package com.transsion.ga;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.java.layout.WindowInfoTrackerCallbackAdapter;
import athena.a0;
import athena.j0;
import athena.w;
import com.hisavana.common.constant.ComConstants;
import com.transsion.athena.data.TrackData;
import com.transsion.push.PushConstants;
import java.util.LinkedList;
import java.util.Set;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f51945b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Runnable f51947d;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f51951i;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public long f51954l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public WindowInfoTrackerCallbackAdapter f51955m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f51944a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f51946c = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f51948f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f51949g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f51950h = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f51952j = 0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final LinkedList<b> f51953k = new LinkedList<>();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final m f51956n = new m();

    /* JADX INFO: renamed from: com.transsion.ga.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class RunnableC0570a implements Runnable {
        public RunnableC0570a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.f51952j = 0;
            a.this.f51953k.clear();
            a.this.f51946c = true;
            a.this.f51948f = 0L;
            br.g.k("");
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f51958a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f51959b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f51960c;

        public b(int i11, String str, long j11) {
            this.f51958a = i11;
            this.f51959b = str;
            this.f51960c = j11;
        }
    }

    public void d(long j11) {
        this.f51954l = j11;
    }

    public final boolean e(Activity activity) {
        Window window;
        if (activity == null || AthenaAnalytics.k(activity.getClass()) || (window = activity.getWindow()) == null) {
            return false;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        return (attributes.width == 1 && attributes.height == 1) ? false : true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        w.f(activity);
        if (j0.x() && this.f51955m == null) {
            this.f51955m = new WindowInfoTrackerCallbackAdapter(androidx.window.layout.w.a(activity));
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        w.c();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* JADX WARN: Code duplicated, block: B:50:0x0100 A[Catch: Exception -> 0x00fe, TryCatch #0 {Exception -> 0x00fe, blocks: (B:4:0x0006, B:6:0x002c, B:8:0x0036, B:13:0x0051, B:40:0x00bb, B:41:0x00c7, B:43:0x00cd, B:45:0x00db, B:47:0x00f6, B:39:0x00b4, B:12:0x0042, B:50:0x0100, B:52:0x0106, B:14:0x005a, B:16:0x0060, B:18:0x0066, B:22:0x0075, B:35:0x00a2, B:37:0x00b0, B:25:0x007e, B:28:0x0090, B:31:0x0099, B:21:0x006f, B:9:0x0038), top: B:61:0x0006, inners: #1, #2 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0106 A[Catch: Exception -> 0x00fe, TRY_LEAVE, TryCatch #0 {Exception -> 0x00fe, blocks: (B:4:0x0006, B:6:0x002c, B:8:0x0036, B:13:0x0051, B:40:0x00bb, B:41:0x00c7, B:43:0x00cd, B:45:0x00db, B:47:0x00f6, B:39:0x00b4, B:12:0x0042, B:50:0x0100, B:52:0x0106, B:14:0x005a, B:16:0x0060, B:18:0x0066, B:22:0x0075, B:35:0x00a2, B:37:0x00b0, B:25:0x007e, B:28:0x0090, B:31:0x0099, B:21:0x006f, B:9:0x0038), top: B:61:0x0006, inners: #1, #2 }] */
    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Runnable runnable;
        String strValueOf;
        WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter;
        if (e(activity)) {
            try {
                String simpleName = activity.getClass().getSimpleName();
                String str = br.g.f14348a;
                int i11 = 1;
                int i12 = this.f51952j + 1;
                this.f51952j = i12;
                this.f51953k.addLast(new b(i12, simpleName, SystemClock.elapsedRealtime()));
                int i13 = this.f51945b + 1;
                this.f51945b = i13;
                if (i13 <= 1) {
                    this.f51951i = SystemClock.elapsedRealtime();
                    if (this.f51946c) {
                        String str2 = j0.f13693a;
                        try {
                            strValueOf = UUID.randomUUID().toString();
                        } catch (Exception e11) {
                            a0.c(Log.getStackTraceString(e11));
                            strValueOf = String.valueOf(System.currentTimeMillis());
                        }
                        br.g.k(strValueOf);
                        this.f51948f = System.currentTimeMillis();
                        try {
                            if (Build.VERSION.SDK_INT >= 22) {
                                Uri referrer = activity.getReferrer();
                                if (referrer != null) {
                                    this.f51950h = referrer.getAuthority();
                                }
                            } else {
                                this.f51950h = activity.getCallingPackage();
                            }
                            Intent intent = activity.getIntent();
                            String str3 = this.f51950h;
                            if (intent != null) {
                                Set<String> categories = intent.getCategories();
                                if (!"android.intent.action.MAIN".equals(intent.getAction()) || categories == null || !categories.contains("android.intent.category.LAUNCHER")) {
                                    i11 = TextUtils.isEmpty(str3) ? 0 : 2;
                                }
                            }
                            this.f51949g = i11;
                            if (TextUtils.equals(this.f51950h, activity.getPackageName())) {
                                this.f51949g = 3;
                            }
                        } catch (Exception e12) {
                            a0.c(Log.getStackTraceString(e12));
                        }
                        int iA = w.a(activity);
                        for (Integer num : cr.b.a()) {
                            if (num.intValue() != 9999) {
                                AthenaAnalytics.z(num.intValue()).Q("page_enter", new TrackData().add("fromsite", iA).add("purl", simpleName), num.intValue());
                            }
                        }
                        this.f51946c = false;
                        runnable = this.f51947d;
                        if (runnable != null) {
                            this.f51944a.removeCallbacks(runnable);
                            this.f51947d = null;
                        }
                    } else {
                        this.f51946c = false;
                        runnable = this.f51947d;
                        if (runnable != null) {
                            this.f51944a.removeCallbacks(runnable);
                            this.f51947d = null;
                        }
                    }
                } else {
                    this.f51946c = false;
                    runnable = this.f51947d;
                    if (runnable != null) {
                        this.f51944a.removeCallbacks(runnable);
                        this.f51947d = null;
                    }
                }
            } catch (Exception e13) {
                a0.c(Log.getStackTraceString(e13));
            }
        }
        if (!j0.x() || (windowInfoTrackerCallbackAdapter = this.f51955m) == null) {
            return;
        }
        windowInfoTrackerCallbackAdapter.c(activity, new c6.e(), this.f51956n);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Bundle bundleExtra;
        if (e(activity)) {
            try {
                String str = br.g.f14348a;
                if (this.f51953k.size() > 0) {
                    String simpleName = activity.getClass().getSimpleName();
                    for (b bVar : this.f51953k) {
                        if (simpleName.equals(bVar.f51959b)) {
                            long jElapsedRealtime = SystemClock.elapsedRealtime() - bVar.f51960c;
                            TrackData trackDataAdd = new TrackData().add("s_id", br.g.z()).add("url", bVar.f51959b).add("no", bVar.f51958a);
                            if (jElapsedRealtime <= 0) {
                                jElapsedRealtime = 0;
                            }
                            TrackData trackDataAdd2 = trackDataAdd.add("t", jElapsedRealtime).add("ext", "");
                            if (activity.getIntent() != null && (bundleExtra = activity.getIntent().getBundleExtra("athena")) != null) {
                                trackDataAdd2.add("ext", bundleExtra);
                            }
                            AthenaAnalytics.A(this.f51954l).R("page_view", trackDataAdd2, this.f51954l);
                            this.f51953k.remove(bVar);
                            break;
                        }
                    }
                }
                int i11 = this.f51945b - 1;
                this.f51945b = i11;
                if (i11 == 0) {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime() - this.f51951i;
                    if (jElapsedRealtime2 > 1000 && jElapsedRealtime2 < ComConstants.REQ_CLOUD_CONFIG_INTERVAL_IF_NEED) {
                        for (Integer num : cr.b.a()) {
                            if (num.intValue() != 9999) {
                                AthenaAnalytics.z(num.intValue()).Q("app_active", new TrackData().add("s_id", br.g.z()).add("s_t", this.f51949g).add(PushConstants.PROVIDER_FIELD_PKG, this.f51949g == 2 ? this.f51950h : "").add("s_s", this.f51948f).add("t", jElapsedRealtime2), num.intValue());
                            }
                        }
                    }
                    Runnable runnable = this.f51947d;
                    if (runnable != null) {
                        this.f51944a.removeCallbacks(runnable);
                    }
                    Handler handler = this.f51944a;
                    RunnableC0570a runnableC0570a = new RunnableC0570a();
                    this.f51947d = runnableC0570a;
                    handler.postDelayed(runnableC0570a, br.g.A());
                    AthenaAnalytics.D();
                }
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        WindowInfoTrackerCallbackAdapter windowInfoTrackerCallbackAdapter = this.f51955m;
        if (windowInfoTrackerCallbackAdapter != null) {
            windowInfoTrackerCallbackAdapter.e(this.f51956n);
        }
    }
}
