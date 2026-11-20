package androidx.emoji2.text;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.u;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class EmojiCompatInitializer implements i6.b<Boolean> {

    /* JADX INFO: compiled from: source.java */
    public static class LoadEmojiCompatRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            try {
                androidx.core.os.r.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.i()) {
                    EmojiCompat.c().l();
                }
            } finally {
                androidx.core.os.r.b();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class a implements androidx.lifecycle.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f8307a;

        public a(Lifecycle lifecycle) {
            this.f8307a = lifecycle;
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onCreate(u uVar) {
            androidx.lifecycle.e.a(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onDestroy(u uVar) {
            androidx.lifecycle.e.b(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onPause(u uVar) {
            androidx.lifecycle.e.c(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public void onResume(@NonNull u uVar) {
            EmojiCompatInitializer.this.d();
            this.f8307a.d(this);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStart(u uVar) {
            androidx.lifecycle.e.e(this, uVar);
        }

        @Override // androidx.lifecycle.f
        public /* synthetic */ void onStop(u uVar) {
            androidx.lifecycle.e.f(this, uVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(19)
    public static class b extends EmojiCompat.c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(19)
    public static class c implements EmojiCompat.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f8309a;

        /* JADX INFO: compiled from: source.java */
        public class a extends EmojiCompat.h {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ EmojiCompat.h f8310a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f8311b;

            public a(EmojiCompat.h hVar, ThreadPoolExecutor threadPoolExecutor) {
                this.f8310a = hVar;
                this.f8311b = threadPoolExecutor;
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void a(@Nullable Throwable th2) {
                try {
                    this.f8310a.a(th2);
                } finally {
                    this.f8311b.shutdown();
                }
            }

            @Override // androidx.emoji2.text.EmojiCompat.h
            public void b(@NonNull m mVar) {
                try {
                    this.f8310a.b(mVar);
                } finally {
                    this.f8311b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f8309a = context.getApplicationContext();
        }

        @Override // androidx.emoji2.text.EmojiCompat.g
        public void a(@NonNull final EmojiCompat.h hVar) {
            final ThreadPoolExecutor threadPoolExecutorB = androidx.emoji2.text.c.b("EmojiCompatInitializer");
            threadPoolExecutorB.execute(new Runnable() { // from class: androidx.emoji2.text.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f8317a.d(hVar, threadPoolExecutorB);
                }
            });
        }

        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void d(@NonNull EmojiCompat.h hVar, @NonNull ThreadPoolExecutor threadPoolExecutor) {
            try {
                j jVarA = d.a(this.f8309a);
                if (jVarA == null) {
                    throw new RuntimeException("EmojiCompat font provider not available on this device.");
                }
                jVarA.c(threadPoolExecutor);
                jVarA.a().a(new a(hVar, threadPoolExecutor));
            } catch (Throwable th2) {
                hVar.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    @Override // i6.b
    @NonNull
    public List<Class<? extends i6.b<?>>> a() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }

    @Override // i6.b
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Boolean create(@NonNull Context context) {
        EmojiCompat.h(new b(context));
        c(context);
        return Boolean.TRUE;
    }

    @RequiresApi(19)
    public void c(@NonNull Context context) {
        Lifecycle lifecycle = ((u) i6.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    @RequiresApi(19)
    public void d() {
        androidx.emoji2.text.c.d().postDelayed(new LoadEmojiCompatRunnable(), 500L);
    }
}
