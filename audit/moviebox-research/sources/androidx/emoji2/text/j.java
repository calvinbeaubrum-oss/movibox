package androidx.emoji2.text;

import android.content.Context;
import android.content.pm.PackageManager;
import android.database.ContentObserver;
import android.graphics.Typeface;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class j extends EmojiCompat.c {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final a f8349k = new a();

    /* JADX INFO: compiled from: source.java */
    public static class a {
        @Nullable
        public Typeface a(@NonNull Context context, @NonNull androidx.core.provider.g.b bVar) throws PackageManager.NameNotFoundException {
            return androidx.core.provider.g.a(context, null, new androidx.core.provider.g.b[]{bVar});
        }

        @NonNull
        public androidx.core.provider.g.a b(@NonNull Context context, @NonNull androidx.core.provider.e eVar) throws PackageManager.NameNotFoundException {
            return androidx.core.provider.g.b(context, null, eVar);
        }

        public void c(@NonNull Context context, @NonNull ContentObserver contentObserver) {
            context.getContentResolver().unregisterContentObserver(contentObserver);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements EmojiCompat.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final Context f8350a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NonNull
        public final androidx.core.provider.e f8351b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NonNull
        public final a f8352c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        public final Object f8353d = new Object();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @Nullable
        public Handler f8354e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @Nullable
        public Executor f8355f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @Nullable
        public ThreadPoolExecutor f8356g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @Nullable
        public EmojiCompat.h f8357h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        @Nullable
        public ContentObserver f8358i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        @Nullable
        public Runnable f8359j;

        public b(@NonNull Context context, @NonNull androidx.core.provider.e eVar, @NonNull a aVar) {
            androidx.core.util.i.h(context, "Context cannot be null");
            androidx.core.util.i.h(eVar, "FontRequest cannot be null");
            this.f8350a = context.getApplicationContext();
            this.f8351b = eVar;
            this.f8352c = aVar;
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        @RequiresApi(19)
        public void a(@NonNull EmojiCompat.h hVar) {
            androidx.core.util.i.h(hVar, "LoaderCallback cannot be null");
            synchronized (this.f8353d) {
                this.f8357h = hVar;
            }
            d();
        }

        public final void b() {
            synchronized (this.f8353d) {
                try {
                    this.f8357h = null;
                    ContentObserver contentObserver = this.f8358i;
                    if (contentObserver != null) {
                        this.f8352c.c(this.f8350a, contentObserver);
                        this.f8358i = null;
                    }
                    Handler handler = this.f8354e;
                    if (handler != null) {
                        handler.removeCallbacks(this.f8359j);
                    }
                    this.f8354e = null;
                    ThreadPoolExecutor threadPoolExecutor = this.f8356g;
                    if (threadPoolExecutor != null) {
                        threadPoolExecutor.shutdown();
                    }
                    this.f8355f = null;
                    this.f8356g = null;
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @RequiresApi(19)
        public void c() {
            synchronized (this.f8353d) {
                try {
                    if (this.f8357h == null) {
                        return;
                    }
                    try {
                        androidx.core.provider.g.b bVarE = e();
                        int iB = bVarE.b();
                        if (iB == 2) {
                            synchronized (this.f8353d) {
                            }
                        }
                        if (iB != 0) {
                            throw new RuntimeException("fetchFonts result is not OK. (" + iB + ")");
                        }
                        try {
                            androidx.core.os.r.a("EmojiCompat.FontRequestEmojiCompatConfig.buildTypeface");
                            Typeface typefaceA = this.f8352c.a(this.f8350a, bVarE);
                            ByteBuffer byteBufferF = c3.m.f(this.f8350a, null, bVarE.d());
                            if (byteBufferF == null || typefaceA == null) {
                                throw new RuntimeException("Unable to open file.");
                            }
                            m mVarB = m.b(typefaceA, byteBufferF);
                            androidx.core.os.r.b();
                            synchronized (this.f8353d) {
                                try {
                                    EmojiCompat.h hVar = this.f8357h;
                                    if (hVar != null) {
                                        hVar.b(mVarB);
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                            b();
                        } catch (Throwable th3) {
                            androidx.core.os.r.b();
                            throw th3;
                        }
                    } catch (Throwable th4) {
                        synchronized (this.f8353d) {
                            try {
                                EmojiCompat.h hVar2 = this.f8357h;
                                if (hVar2 != null) {
                                    hVar2.a(th4);
                                }
                                b();
                            } catch (Throwable th5) {
                                throw th5;
                            }
                        }
                    }
                } catch (Throwable th6) {
                    throw th6;
                }
            }
        }

        @RequiresApi(19)
        public void d() {
            synchronized (this.f8353d) {
                try {
                    if (this.f8357h == null) {
                        return;
                    }
                    if (this.f8355f == null) {
                        ThreadPoolExecutor threadPoolExecutorB = c.b("emojiCompat");
                        this.f8356g = threadPoolExecutorB;
                        this.f8355f = threadPoolExecutorB;
                    }
                    this.f8355f.execute(new Runnable() { // from class: androidx.emoji2.text.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f8360a.c();
                        }
                    });
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        public final androidx.core.provider.g.b e() {
            try {
                androidx.core.provider.g.a aVarB = this.f8352c.b(this.f8350a, this.f8351b);
                if (aVarB.c() == 0) {
                    androidx.core.provider.g.b[] bVarArrB = aVarB.b();
                    if (bVarArrB == null || bVarArrB.length == 0) {
                        throw new RuntimeException("fetchFonts failed (empty result)");
                    }
                    return bVarArrB[0];
                }
                throw new RuntimeException("fetchFonts failed (" + aVarB.c() + ")");
            } catch (PackageManager.NameNotFoundException e11) {
                throw new RuntimeException("provider not found", e11);
            }
        }

        public void f(@NonNull Executor executor) {
            synchronized (this.f8353d) {
                this.f8355f = executor;
            }
        }
    }

    public j(@NonNull Context context, @NonNull androidx.core.provider.e eVar) {
        super(new b(context, eVar, f8349k));
    }

    @NonNull
    public j c(@NonNull Executor executor) {
        ((b) a()).f(executor);
        return this;
    }
}
