package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.profileinstaller.ProfileInstallerInitializer;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class ProfileInstallerInitializer implements i6.b<c> {

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(16)
    public static class a {
        public static void c(final Runnable runnable) {
            Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: c6.j
                @Override // android.view.Choreographer.FrameCallback
                public final void doFrame(long j11) {
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @RequiresApi(28)
    public static class b {
        public static Handler a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    public static class c {
    }

    public static void k(@NonNull final Context context) {
        new ThreadPoolExecutor(0, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue()).execute(new Runnable() { // from class: c6.i
            @Override // java.lang.Runnable
            public final void run() {
                androidx.profileinstaller.c.i(context);
            }
        });
    }

    @Override // i6.b
    @NonNull
    public List<Class<? extends i6.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // i6.b
    @NonNull
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public c create(@NonNull Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return new c();
        }
        f(context.getApplicationContext());
        return new c();
    }

    @RequiresApi(16)
    public void f(@NonNull final Context context) {
        a.c(new Runnable() { // from class: c6.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f14648a.h(context);
            }
        });
    }

    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void h(@NonNull final Context context) {
        (Build.VERSION.SDK_INT >= 28 ? b.a(Looper.getMainLooper()) : new Handler(Looper.getMainLooper())).postDelayed(new Runnable() { // from class: c6.h
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstallerInitializer.k(context);
            }
        }, new Random().nextInt(Math.max(1000, 1)) + 5000);
    }
}
