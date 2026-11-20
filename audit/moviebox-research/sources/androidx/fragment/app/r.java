package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.lifecycle.x0;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Deprecated
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Collection<Fragment> f8601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Map<String, r> f8602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Map<String, x0> f8603c;

    public r(@Nullable Collection<Fragment> collection, @Nullable Map<String, r> map, @Nullable Map<String, x0> map2) {
        this.f8601a = collection;
        this.f8602b = map;
        this.f8603c = map2;
    }

    @Nullable
    public Map<String, r> a() {
        return this.f8602b;
    }

    @Nullable
    public Collection<Fragment> b() {
        return this.f8601a;
    }

    @Nullable
    public Map<String, x0> c() {
        return this.f8603c;
    }
}
