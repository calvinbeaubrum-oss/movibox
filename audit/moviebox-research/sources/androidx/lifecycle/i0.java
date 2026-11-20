package androidx.lifecycle;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class i0 implements r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f8740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c.a f8741b;

    public i0(Object obj) {
        this.f8740a = obj;
        this.f8741b = c.f8708c.c(obj.getClass());
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(@NonNull u uVar, @NonNull Lifecycle.Event event) {
        this.f8741b.a(uVar, event, this.f8740a);
    }
}
