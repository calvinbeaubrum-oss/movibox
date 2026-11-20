package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private static IThreadPoolCallback f25714q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private static ThreadPoolExecutor f25715r;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f25716a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.geckox.a.a.c f25717b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final IStatisticMonitor f25718c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final INetWork f25719d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<String> f25720e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final List<String> f25721f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.bykv.vk.openvk.preload.geckox.a.a.a f25722g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Long f25723h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f25724i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f25725j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f25726k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final String f25727l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f25728m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final File f25729n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final boolean f25730o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private JSONObject f25731p;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private INetWork f25732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private List<String> f25733b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<String> f25734c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Context f25735d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private IStatisticMonitor f25736e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private boolean f25737f = true;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private com.bykv.vk.openvk.preload.geckox.a.a.a f25738g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private Long f25739h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private String f25740i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private String f25741j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private String f25742k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private File f25743l;

        public a(Context context) {
            this.f25735d = context.getApplicationContext();
        }

        public final a a() {
            this.f25737f = false;
            return this;
        }

        public final a a(com.bykv.vk.openvk.preload.geckox.a.a.a aVar) {
            this.f25738g = aVar;
            return this;
        }

        public final a a(INetWork iNetWork) {
            this.f25732a = iNetWork;
            return this;
        }

        public final a a(IStatisticMonitor iStatisticMonitor) {
            this.f25736e = iStatisticMonitor;
            return this;
        }

        public final a a(File file) {
            this.f25743l = file;
            return this;
        }

        public final a a(String str) {
            this.f25740i = str;
            return this;
        }

        public final a a(String... strArr) {
            this.f25734c = Arrays.asList(strArr);
            return this;
        }

        public final a b() {
            this.f25739h = 38L;
            return this;
        }

        public final a b(String str) {
            this.f25741j = str;
            return this;
        }

        public final a b(String... strArr) {
            this.f25733b = Arrays.asList(strArr);
            return this;
        }

        public final a c(String str) {
            this.f25742k = str;
            return this;
        }
    }

    private b(a aVar) {
        Context context = aVar.f25735d;
        this.f25716a = context;
        if (context == null) {
            throw new IllegalArgumentException("context == null");
        }
        List<String> list = aVar.f25733b;
        this.f25720e = list;
        this.f25721f = aVar.f25734c;
        this.f25717b = null;
        this.f25722g = aVar.f25738g;
        Long l11 = aVar.f25739h;
        this.f25723h = l11;
        if (TextUtils.isEmpty(aVar.f25740i)) {
            this.f25724i = com.bykv.vk.openvk.preload.geckox.utils.a.a(context);
        } else {
            this.f25724i = aVar.f25740i;
        }
        String str = aVar.f25741j;
        this.f25725j = str;
        this.f25727l = null;
        this.f25728m = null;
        if (aVar.f25743l == null) {
            this.f25729n = new File(context.getFilesDir(), "gecko_offline_res_x");
        } else {
            this.f25729n = aVar.f25743l;
        }
        String str2 = aVar.f25742k;
        this.f25726k = str2;
        if (TextUtils.isEmpty(str2)) {
            throw new IllegalArgumentException("host == null");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("access key empty");
        }
        if (l11 == null) {
            throw new IllegalArgumentException("appId == null");
        }
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("deviceId key empty");
        }
        this.f25719d = aVar.f25732a;
        this.f25718c = aVar.f25736e;
        this.f25730o = aVar.f25737f;
    }

    public /* synthetic */ b(a aVar, byte b11) {
        this(aVar);
    }

    public static void a(IThreadPoolCallback iThreadPoolCallback) {
        f25714q = iThreadPoolCallback;
    }

    public static Executor g() {
        return p();
    }

    public static Executor h() {
        return p();
    }

    public static ExecutorService p() {
        IThreadPoolCallback iThreadPoolCallback = f25714q;
        ExecutorService threadPool = iThreadPoolCallback != null ? iThreadPoolCallback.getThreadPool() : null;
        if (threadPool != null) {
            return threadPool;
        }
        if (f25715r == null) {
            synchronized (b.class) {
                try {
                    if (f25715r == null) {
                        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 20L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                        f25715r = threadPoolExecutor;
                        threadPoolExecutor.allowCoreThreadTimeOut(true);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f25715r;
    }

    public final Context a() {
        return this.f25716a;
    }

    public final void a(JSONObject jSONObject) {
        this.f25731p = jSONObject;
    }

    public final com.bykv.vk.openvk.preload.geckox.a.a.a b() {
        return this.f25722g;
    }

    public final boolean c() {
        return this.f25730o;
    }

    public final List<String> d() {
        return this.f25721f;
    }

    public final List<String> e() {
        return this.f25720e;
    }

    public final JSONObject f() {
        return this.f25731p;
    }

    public final INetWork i() {
        return this.f25719d;
    }

    public final String j() {
        return this.f25726k;
    }

    public final long k() {
        return this.f25723h.longValue();
    }

    public final File l() {
        return this.f25729n;
    }

    public final String m() {
        return this.f25724i;
    }

    public final IStatisticMonitor n() {
        return this.f25718c;
    }

    public final String o() {
        return this.f25725j;
    }
}
