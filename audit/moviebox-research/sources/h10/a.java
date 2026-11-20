package h10;

import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.internal.util.f;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f<b> f66122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f66123b;

    @Override // h10.c
    public boolean a(b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // h10.c
    public boolean b(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (this.f66123b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f66123b) {
                    return false;
                }
                f<b> fVar = this.f66122a;
                if (fVar != null && fVar.e(bVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // h10.c
    public boolean c(b bVar) {
        Objects.requireNonNull(bVar, "disposable is null");
        if (!this.f66123b) {
            synchronized (this) {
                try {
                    if (!this.f66123b) {
                        f<b> fVar = this.f66122a;
                        if (fVar == null) {
                            fVar = new f<>();
                            this.f66122a = fVar;
                        }
                        fVar.a(bVar);
                        return true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        bVar.dispose();
        return false;
    }

    public void d() {
        if (this.f66123b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f66123b) {
                    return;
                }
                f<b> fVar = this.f66122a;
                this.f66122a = null;
                e(fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // h10.b
    public void dispose() {
        if (this.f66123b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f66123b) {
                    return;
                }
                this.f66123b = true;
                f<b> fVar = this.f66122a;
                this.f66122a = null;
                e(fVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(f<b> fVar) {
        if (fVar == null) {
            return;
        }
        ArrayList arrayList = null;
        for (Object obj : fVar.b()) {
            if (obj instanceof b) {
                try {
                    ((b) obj).dispose();
                } catch (Throwable th2) {
                    i10.a.b(th2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
        }
        if (arrayList != null) {
            if (arrayList.size() != 1) {
                throw new CompositeException(arrayList);
            }
            throw ExceptionHelper.g((Throwable) arrayList.get(0));
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f66123b;
    }
}
