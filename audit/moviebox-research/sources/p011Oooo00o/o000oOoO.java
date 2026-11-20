package p011Oooo00o;

import d0.a;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o000oOoO {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o000oOoO f221a = new o000oOoO();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f222b = LazyKt__LazyJVMKt.b(OooO00o.OooO00o);

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<a> {
        public static final OooO00o OooO00o = new OooO00o();

        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public a invoke() {
            return new a();
        }
    }

    public final a a() {
        return (a) f222b.getValue();
    }
}
