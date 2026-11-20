package a10;

import androidx.annotation.NonNull;
import com.vungle.warren.model.o;
import com.vungle.warren.persistence.Repository;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f358a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Repository f359b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Repository.y f360c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AtomicBoolean f361d = new AtomicBoolean(true);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f362e;

    public b(@NonNull o oVar, @NonNull Repository repository, @NonNull Repository.y yVar) {
        this.f358a = oVar;
        this.f359b = repository;
        this.f360c = yVar;
    }

    public final void a() {
        this.f358a.i(System.currentTimeMillis() - this.f362e);
        this.f359b.i0(this.f358a, this.f360c);
    }

    public void b() {
        if (this.f361d.getAndSet(false)) {
            this.f362e = System.currentTimeMillis() - this.f358a.a();
        }
    }

    public void c() {
        if (this.f361d.getAndSet(true)) {
            return;
        }
        a();
    }

    public void d() {
        if (this.f361d.get()) {
            return;
        }
        a();
    }
}
