package androidx.media3.common;

import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f9349c = u0.E0(0);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f9350d = u0.E0(1);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Deprecated
    public static final i<o0> f9351e = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n0 f9352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList<Integer> f9353b;

    public o0(n0 n0Var, int i11) {
        this(n0Var, ImmutableList.of(Integer.valueOf(i11)));
    }

    public o0(n0 n0Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= n0Var.f9330a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f9352a = n0Var;
        this.f9353b = ImmutableList.copyOf((Collection) list);
    }

    public int a() {
        return this.f9352a.f9332c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o0.class != obj.getClass()) {
            return false;
        }
        o0 o0Var = (o0) obj;
        return this.f9352a.equals(o0Var.f9352a) && this.f9353b.equals(o0Var.f9353b);
    }

    public int hashCode() {
        return this.f9352a.hashCode() + (this.f9353b.hashCode() * 31);
    }
}
