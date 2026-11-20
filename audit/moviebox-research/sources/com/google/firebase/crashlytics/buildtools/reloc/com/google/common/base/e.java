package com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base;

import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f39080a;

    /* JADX INFO: compiled from: source.java */
    public class a extends e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f39081b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e eVar, String str) {
            super(eVar, null);
            this.f39081b = str;
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e
        public CharSequence h(Object obj) {
            return obj == null ? this.f39081b : e.this.h(obj);
        }

        @Override // com.google.firebase.crashlytics.buildtools.reloc.com.google.common.base.e
        public e i(String str) {
            throw new UnsupportedOperationException("already specified useForNull");
        }
    }

    public e(e eVar) {
        this.f39080a = eVar.f39080a;
    }

    public /* synthetic */ e(e eVar, a aVar) {
        this(eVar);
    }

    public e(String str) {
        this.f39080a = (String) l.n(str);
    }

    public static e f(char c11) {
        return new e(String.valueOf(c11));
    }

    public static e g(String str) {
        return new e(str);
    }

    public <A extends Appendable> A a(A a11, Iterator<?> it) throws IOException {
        l.n(a11);
        if (it.hasNext()) {
            a11.append(h(it.next()));
            while (it.hasNext()) {
                a11.append(this.f39080a);
                a11.append(h(it.next()));
            }
        }
        return a11;
    }

    public final StringBuilder b(StringBuilder sb2, Iterator<?> it) {
        try {
            a(sb2, it);
            return sb2;
        } catch (IOException e11) {
            throw new AssertionError(e11);
        }
    }

    public final String c(Iterable<?> iterable) {
        return d(iterable.iterator());
    }

    public final String d(Iterator<?> it) {
        return b(new StringBuilder(), it).toString();
    }

    public final String e(Object[] objArr) {
        return c(Arrays.asList(objArr));
    }

    public CharSequence h(Object obj) {
        l.n(obj);
        return obj instanceof CharSequence ? (CharSequence) obj : obj.toString();
    }

    public e i(String str) {
        l.n(str);
        return new a(this, str);
    }
}
