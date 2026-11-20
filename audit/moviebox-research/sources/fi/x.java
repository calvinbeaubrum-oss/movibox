package fi;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import nh.i0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class x implements com.google.android.exoplayer2.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final com.google.android.exoplayer2.g.a<x> f65054c = new com.google.android.exoplayer2.g.a() { // from class: fi.w
        @Override // com.google.android.exoplayer2.g.a
        public final com.google.android.exoplayer2.g a(Bundle bundle) {
            return x.d(bundle);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f65055a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImmutableList<Integer> f65056b;

    public x(i0 i0Var, List<Integer> list) {
        if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= i0Var.f71931a)) {
            throw new IndexOutOfBoundsException();
        }
        this.f65055a = i0Var;
        this.f65056b = ImmutableList.copyOf((Collection) list);
    }

    private static String c(int i11) {
        return Integer.toString(i11, 36);
    }

    public static /* synthetic */ x d(Bundle bundle) {
        return new x((i0) i0.f71930g.a((Bundle) com.google.android.exoplayer2.util.a.e(bundle.getBundle(c(0)))), Ints.c((int[]) com.google.android.exoplayer2.util.a.e(bundle.getIntArray(c(1)))));
    }

    public int b() {
        return this.f65055a.f71933c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return this.f65055a.equals(xVar.f65055a) && this.f65056b.equals(xVar.f65056b);
    }

    public int hashCode() {
        return this.f65055a.hashCode() + (this.f65056b.hashCode() * 31);
    }

    @Override // com.google.android.exoplayer2.g
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBundle(c(0), this.f65055a.toBundle());
        bundle.putIntArray(c(1), Ints.m(this.f65056b));
        return bundle;
    }
}
