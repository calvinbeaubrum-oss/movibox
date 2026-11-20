package androidx.databinding;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class m<T> extends WeakReference<ViewDataBinding> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f8186a;

    public boolean a() {
        if (this.f8186a != null) {
            throw null;
        }
        this.f8186a = null;
        return false;
    }
}
