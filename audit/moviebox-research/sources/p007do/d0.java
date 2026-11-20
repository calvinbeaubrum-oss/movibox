package p007do;

import android.content.Context;
import android.os.Handler;
import androidx.core.util.l;
import com.google.common.base.m;
import eo.s;
import ho.j;
import io.c;
import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;
import ws.a;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class d0 {
    public static void a() {
        try {
            Context context = a.f79586a;
            Constructor declaredConstructor = z.class.getDeclaredConstructor(null);
            declaredConstructor.setAccessible(true);
            final l lVar = (l) declaredConstructor.newInstance(null);
            Thread thread = new Thread(new Runnable() { // from class: do.a0
                @Override // java.lang.Runnable
                public final void run() {
                    d0.c(lVar);
                }
            });
            thread.setDaemon(true);
            thread.start();
        } catch (Throwable unused) {
        }
    }

    public static void b(final Context context) {
        m.p(context);
        try {
            m.r();
        } catch (IllegalStateException unused) {
            new Handler(context.getMainLooper()).post(new Runnable() { // from class: do.b0
                @Override // java.lang.Runnable
                public final void run() {
                    m.C().h(context).f(j.ofProvider().i("ogsvc.pgoriginad.com")).f(s.ofProvider()).i(new c() { // from class: do.c0
                        @Override // io.c
                        public final void accept(Object obj, Object obj2) {
                            d0.d((m) obj, (Throwable) obj2);
                        }
                    });
                }
            });
        }
    }

    public static /* synthetic */ void c(l lVar) {
        for (int i11 = 0; i11 < 5; i11++) {
            try {
                Thread.sleep(TimeUnit.SECONDS.toMillis(15L));
                b((Context) lVar.get());
                return;
            } catch (Throwable unused) {
            }
        }
    }

    public static /* synthetic */ void d(m mVar, Throwable th2) {
    }
}
