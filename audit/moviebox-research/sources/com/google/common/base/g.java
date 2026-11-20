package com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f38170a;

    /* JADX INFO: compiled from: source.java */
    public class a extends g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f38171b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, String str) {
            super(gVar, null);
            this.f38171b = str;
        }

        @Override // com.google.common.base.g
        public CharSequence i(Object obj) {
            return obj == null ? this.f38171b : g.this.i(obj);
        }

        @Override // com.google.common.base.g
        public g j(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public g(g gVar) {
        this.f38170a = gVar.f38170a;
    }

    public /* synthetic */ g(g gVar, a aVar) {
        this(gVar);
    }

    public g(String str) {
        this.f38170a = (String) m.p(str);
    }

    public static g g(char c11) {
        return new g(String.valueOf(c11));
    }

    public static g h(String str) {
        return new g(str);
    }

    public <A extends Appendable> A a(A a11, Iterator<? extends Object> it) throws IOException {
        m.p(a11);
        if (it.hasNext()) {
            a11.append(i(it.next()));
            while (it.hasNext()) {
                a11.append(this.f38170a);
                a11.append(i(it.next()));
            }
        }
        return a11;
    }

    public final StringBuilder b(StringBuilder sb2, Iterable<? extends Object> iterable) {
        return c(sb2, iterable.iterator());
    }

    public final StringBuilder c(StringBuilder sb2, Iterator<? extends Object> it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final String d(Iterable<? extends Object> iterable) {
        return e(iterable.iterator());
    }

    public final String e(Iterator<? extends Object> it) {
        return c(new StringBuilder(), it).toString();
    }

    public final String f(Object[] objArr) {
        return d(Arrays.asList(objArr));
    }

    public CharSequence i(Object obj) {
        Objects.requireNonNull(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public g j(String str) {
        m.p(str);
        return new a(this, str);
    }
}
