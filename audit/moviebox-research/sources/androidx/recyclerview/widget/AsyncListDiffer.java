package androidx.recyclerview.widget;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class AsyncListDiffer<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Executor f12389h = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f12390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f12391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Executor f12392c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public List<T> f12394e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f12396g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<a<T>> f12393d = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public List<T> f12395f = Collections.emptyList();

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        void a(@NonNull List<T> list, @NonNull List<T> list2);
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f12398a = new Handler(Looper.getMainLooper());

        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            this.f12398a.post(runnable);
        }
    }

    public AsyncListDiffer(@NonNull j jVar, @NonNull c<T> cVar) {
        this.f12390a = jVar;
        this.f12391b = cVar;
        if (cVar.c() != null) {
            this.f12392c = cVar.c();
        } else {
            this.f12392c = f12389h;
        }
    }

    public void a(@NonNull a<T> aVar) {
        this.f12393d.add(aVar);
    }

    @NonNull
    public List<T> b() {
        return this.f12395f;
    }

    public void c(@NonNull List<T> list, @NonNull DiffUtil.d dVar, @Nullable Runnable runnable) {
        List<T> list2 = this.f12395f;
        this.f12394e = list;
        this.f12395f = Collections.unmodifiableList(list);
        dVar.b(this.f12390a);
        d(list2, runnable);
    }

    public final void d(@NonNull List<T> list, @Nullable Runnable runnable) {
        Iterator<a<T>> it = this.f12393d.iterator();
        while (it.hasNext()) {
            it.next().a(list, this.f12395f);
        }
        if (runnable != null) {
            runnable.run();
        }
    }

    public void e(@Nullable List<T> list) {
        f(list, null);
    }

    public void f(@Nullable final List<T> list, @Nullable final Runnable runnable) {
        final int i11 = this.f12396g + 1;
        this.f12396g = i11;
        final List<T> list2 = this.f12394e;
        if (list == list2) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        List<T> list3 = this.f12395f;
        if (list == null) {
            int size = list2.size();
            this.f12394e = null;
            this.f12395f = Collections.emptyList();
            this.f12390a.onRemoved(0, size);
            d(list3, runnable);
            return;
        }
        if (list2 != null) {
            this.f12391b.a().execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1

                /* JADX INFO: renamed from: androidx.recyclerview.widget.AsyncListDiffer$1$a */
                /* JADX INFO: compiled from: source.java */
                public class a extends DiffUtil.a {
                    public a() {
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public boolean a(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        if (obj != null && obj2 != null) {
                            return AsyncListDiffer.this.f12391b.b().areContentsTheSame(obj, obj2);
                        }
                        if (obj == null && obj2 == null) {
                            return true;
                        }
                        throw new AssertionError();
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public boolean b(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        if (obj == null || obj2 == null) {
                            return obj == null && obj2 == null;
                        }
                        return AsyncListDiffer.this.f12391b.b().areItemsTheSame(obj, obj2);
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    @Nullable
                    public Object c(int i11, int i12) {
                        Object obj = list2.get(i11);
                        Object obj2 = list.get(i12);
                        if (obj == null || obj2 == null) {
                            throw new AssertionError();
                        }
                        return AsyncListDiffer.this.f12391b.b().getChangePayload(obj, obj2);
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public int d() {
                        return list.size();
                    }

                    @Override // androidx.recyclerview.widget.DiffUtil.a
                    public int e() {
                        return list2.size();
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    final DiffUtil.d dVarB = DiffUtil.b(new a());
                    AsyncListDiffer.this.f12392c.execute(new Runnable() { // from class: androidx.recyclerview.widget.AsyncListDiffer.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            AsyncListDiffer asyncListDiffer = AsyncListDiffer.this;
                            if (asyncListDiffer.f12396g == i11) {
                                asyncListDiffer.c(list, dVarB, runnable);
                            }
                        }
                    });
                }
            });
            return;
        }
        this.f12394e = list;
        this.f12395f = Collections.unmodifiableList(list);
        this.f12390a.onInserted(0, list.size());
        d(list3, runnable);
    }
}
