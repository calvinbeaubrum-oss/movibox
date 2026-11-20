package io.reactivex.rxjava3.internal.functions;

import java.util.Objects;
import k10.d;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<Object, Object> f67339a = new C0712a();

    /* JADX INFO: renamed from: io.reactivex.rxjava3.internal.functions.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0712a implements d<Object, Object> {
        @Override // k10.d
        public boolean test(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    public static int a(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i11);
    }
}
