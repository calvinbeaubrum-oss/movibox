package l10;

import h10.c;
import io.reactivex.rxjava3.exceptions.CompositeException;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements h10.b, c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<h10.b> f69763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f69764b;

    @Override // h10.c
    public boolean a(h10.b bVar) {
        if (!b(bVar)) {
            return false;
        }
        bVar.dispose();
        return true;
    }

    @Override // h10.c
    public boolean b(h10.b bVar) {
        Objects.requireNonNull(bVar, "Disposable item is null");
        if (this.f69764b) {
            return false;
        }
        synchronized (this) {
            try {
                if (this.f69764b) {
                    return false;
                }
                List<h10.b> list = this.f69763a;
                if (list != null && list.remove(bVar)) {
                    return true;
                }
                return false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // h10.c
    public boolean c(h10.b bVar) {
        Objects.requireNonNull(bVar, "d is null");
        if (!this.f69764b) {
            synchronized (this) {
                try {
                    if (!this.f69764b) {
                        List linkedList = this.f69763a;
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            this.f69763a = linkedList;
                        }
                        linkedList.add(bVar);
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

    public void d(List<h10.b> list) {
        if (list == null) {
            return;
        }
        Iterator<h10.b> it = list.iterator();
        ArrayList arrayList = null;
        while (it.hasNext()) {
            try {
                it.next().dispose();
            } catch (Throwable th2) {
                i10.a.b(th2);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(th2);
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
    public void dispose() {
        if (this.f69764b) {
            return;
        }
        synchronized (this) {
            try {
                if (this.f69764b) {
                    return;
                }
                this.f69764b = true;
                List<h10.b> list = this.f69763a;
                this.f69763a = null;
                d(list);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // h10.b
    public boolean isDisposed() {
        return this.f69764b;
    }
}
