package hk;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class c implements b, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f66483a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f66484b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TimeUnit f66485c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public CountDownLatch f66487e;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f66486d = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f66488f = false;

    public c(@NonNull e eVar, int i11, TimeUnit timeUnit) {
        this.f66483a = eVar;
        this.f66484b = i11;
        this.f66485c = timeUnit;
    }

    @Override // hk.a
    public void a(@NonNull String str, @Nullable Bundle bundle) {
        synchronized (this.f66486d) {
            try {
                gk.f.f().i("Logging event " + str + " to Firebase Analytics with params " + bundle);
                this.f66487e = new CountDownLatch(1);
                this.f66488f = false;
                this.f66483a.a(str, bundle);
                gk.f.f().i("Awaiting app exception callback from Analytics...");
                try {
                    if (this.f66487e.await(this.f66484b, this.f66485c)) {
                        this.f66488f = true;
                        gk.f.f().i("App exception callback received from Analytics listener.");
                    } else {
                        gk.f.f().k("Timeout exceeded while awaiting app exception callback from Analytics listener.");
                    }
                } catch (InterruptedException unused) {
                    gk.f.f().d("Interrupted while awaiting app exception callback from Analytics listener.");
                }
                this.f66487e = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // hk.b
    public void onEvent(@NonNull String str, @NonNull Bundle bundle) {
        CountDownLatch countDownLatch = this.f66487e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
