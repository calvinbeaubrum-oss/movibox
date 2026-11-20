package com.transsion.player.exo;

import android.content.Context;
import androidx.media3.datasource.cache.Cache;
import androidx.media3.datasource.cache.SimpleCache;
import androidx.media3.datasource.cache.q;
import androidx.media3.datasource.cronet.CronetDataSource;
import androidx.media3.datasource.cronet.CronetUtil;
import androidx.media3.exoplayer.a3;
import androidx.media3.exoplayer.offline.DownloadManager;
import androidx.media3.exoplayer.offline.k;
import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.Executors;
import org.chromium.net.CronetEngine;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static androidx.media3.datasource.a.InterfaceC0090a f54269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static androidx.media3.datasource.a.InterfaceC0090a f54270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b4.a f54271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static File f54272d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Cache f54273e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static DownloadManager f54274f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static k f54275g;

    /* JADX INFO: renamed from: com.transsion.player.exo.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0580a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f54276a;

        static {
            int[] iArr = new int[ORExoDecoderType.values().length];
            f54276a = iArr;
            try {
                iArr[ORExoDecoderType.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f54276a[ORExoDecoderType.FFMPEG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f54276a[ORExoDecoderType.AV1.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static androidx.media3.datasource.cache.a.c a(androidx.media3.datasource.a.InterfaceC0090a interfaceC0090a, Cache cache) {
        return new androidx.media3.datasource.cache.a.c().h(cache).i(interfaceC0090a);
    }

    public static a3 b(Context context, ORExoDecoderType oRExoDecoderType) {
        int i11;
        int i12 = C0580a.f54276a[oRExoDecoderType.ordinal()];
        if (i12 != 1) {
            i11 = 2;
            if (i12 != 2 && i12 != 3) {
                throw new IncompatibleClassChangeError();
            }
        } else {
            i11 = 1;
        }
        return new ORRenderersFactory(context.getApplicationContext(), oRExoDecoderType).l(true).m(i11).j();
    }

    public static synchronized void c(Context context) {
        if (f54274f == null) {
            DownloadManager downloadManager = new DownloadManager(context, new androidx.media3.exoplayer.offline.a(e(context)), new com.transsion.player.shorttv.preload.b(new androidx.media3.datasource.cache.a.c().h(f(context)).i(j(context)), Executors.newFixedThreadPool(6)));
            f54274f = downloadManager;
            downloadManager.u();
        }
    }

    public static synchronized androidx.media3.datasource.a.InterfaceC0090a d(Context context) {
        try {
            if (f54269a == null) {
                Context applicationContext = context.getApplicationContext();
                f54269a = a(new androidx.media3.datasource.b.a(applicationContext, j(applicationContext)), f(applicationContext));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54269a;
    }

    public static synchronized b4.a e(Context context) {
        try {
            if (f54271c == null) {
                f54271c = new b4.b(context);
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54271c;
    }

    public static synchronized Cache f(Context context) {
        try {
            if (f54273e == null) {
                f54273e = new SimpleCache(new File(g(context), "downloads"), new q(314572800L), e(context));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54273e;
    }

    public static synchronized File g(Context context) {
        try {
            if (f54272d == null) {
                File externalFilesDir = context.getExternalFilesDir(null);
                f54272d = externalFilesDir;
                if (externalFilesDir == null) {
                    f54272d = context.getFilesDir();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54272d;
    }

    public static synchronized DownloadManager h(Context context) {
        c(context);
        return f54274f;
    }

    public static synchronized k i(Context context) {
        try {
            if (f54275g == null) {
                f54275g = new k(context, "download_channel");
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54275g;
    }

    public static synchronized androidx.media3.datasource.a.InterfaceC0090a j(Context context) {
        try {
            if (f54270b == null) {
                CronetEngine cronetEngineA = CronetUtil.a(context.getApplicationContext());
                if (cronetEngineA != null) {
                    f54270b = new CronetDataSource.b(cronetEngineA, Executors.newSingleThreadExecutor());
                }
                if (f54270b == null) {
                    CookieManager cookieManager = new CookieManager();
                    cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ORIGINAL_SERVER);
                    CookieHandler.setDefault(cookieManager);
                    f54270b = new androidx.media3.datasource.c.b();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f54270b;
    }
}
