package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class VectorConvertersKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s0<Float, k> f2031a = a(new Function1<Float, k>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        public final k invoke(float f11) {
            return new k(f11);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ k invoke(Float f11) {
            return invoke(f11.floatValue());
        }
    }, new Function1<k, Float>() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(k kVar) {
            return Float.valueOf(kVar.f());
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final s0<Integer, k> f2032b = a(new Function1<Integer, k>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        public final k invoke(int i11) {
            return new k(i11);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ k invoke(Integer num) {
            return invoke(num.intValue());
        }
    }, new Function1<k, Integer>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(k kVar) {
            return Integer.valueOf((int) kVar.f());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final s0<q2.i, k> f2033c = a(new Function1<q2.i, k>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ k invoke(q2.i iVar) {
            return m2invoke0680j_4(iVar.m());
        }

        /* JADX INFO: renamed from: invoke-0680j_4, reason: not valid java name */
        public final k m2invoke0680j_4(float f11) {
            return new k(f11);
        }
    }, new Function1<k, q2.i>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ q2.i invoke(k kVar) {
            return q2.i.c(m3invokeu2uoSUM(kVar));
        }

        /* JADX INFO: renamed from: invoke-u2uoSUM, reason: not valid java name */
        public final float m3invokeu2uoSUM(k kVar) {
            return q2.i.h(kVar.f());
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final s0<q2.k, l> f2034d = a(new Function1<q2.k, l>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ l invoke(q2.k kVar) {
            return m0invokejoFl9I(kVar.h());
        }

        /* JADX INFO: renamed from: invoke-jo-Fl9I, reason: not valid java name */
        public final l m0invokejoFl9I(long j11) {
            return new l(q2.k.d(j11), q2.k.e(j11));
        }
    }, new Function1<l, q2.k>() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ q2.k invoke(l lVar) {
            return q2.k.a(m1invokegVRvYmI(lVar));
        }

        /* JADX INFO: renamed from: invoke-gVRvYmI, reason: not valid java name */
        public final long m1invokegVRvYmI(l lVar) {
            return q2.j.a(q2.i.h(lVar.f()), q2.i.h(lVar.g()));
        }
    });

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final s0<y1.m, l> f2035e = a(new Function1<y1.m, l>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ l invoke(y1.m mVar) {
            return m10invokeuvyYCjk(mVar.m());
        }

        /* JADX INFO: renamed from: invoke-uvyYCjk, reason: not valid java name */
        public final l m10invokeuvyYCjk(long j11) {
            return new l(y1.m.i(j11), y1.m.g(j11));
        }
    }, new Function1<l, y1.m>() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ y1.m invoke(l lVar) {
            return y1.m.c(m11invoke7Ah8Wj8(lVar));
        }

        /* JADX INFO: renamed from: invoke-7Ah8Wj8, reason: not valid java name */
        public final long m11invoke7Ah8Wj8(l lVar) {
            return y1.n.a(lVar.f(), lVar.g());
        }
    });

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final s0<y1.g, l> f2036f = a(new Function1<y1.g, l>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ l invoke(y1.g gVar) {
            return m8invokek4lQ0M(gVar.v());
        }

        /* JADX INFO: renamed from: invoke-k-4lQ0M, reason: not valid java name */
        public final l m8invokek4lQ0M(long j11) {
            return new l(y1.g.m(j11), y1.g.n(j11));
        }
    }, new Function1<l, y1.g>() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ y1.g invoke(l lVar) {
            return y1.g.d(m9invoketuRUvjQ(lVar));
        }

        /* JADX INFO: renamed from: invoke-tuRUvjQ, reason: not valid java name */
        public final long m9invoketuRUvjQ(l lVar) {
            return y1.h.a(lVar.f(), lVar.g());
        }
    });

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final s0<q2.p, l> f2037g = a(new Function1<q2.p, l>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ l invoke(q2.p pVar) {
            return m4invokegyyYBs(pVar.n());
        }

        /* JADX INFO: renamed from: invoke--gyyYBs, reason: not valid java name */
        public final l m4invokegyyYBs(long j11) {
            return new l(q2.p.h(j11), q2.p.i(j11));
        }
    }, new Function1<l, q2.p>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ q2.p invoke(l lVar) {
            return q2.p.b(m5invokeBjo55l4(lVar));
        }

        /* JADX INFO: renamed from: invoke-Bjo55l4, reason: not valid java name */
        public final long m5invokeBjo55l4(l lVar) {
            return q2.q.a(Math.round(lVar.f()), Math.round(lVar.g()));
        }
    });

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final s0<q2.t, l> f2038h = a(new Function1<q2.t, l>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ l invoke(q2.t tVar) {
            return m6invokeozmzZPI(tVar.j());
        }

        /* JADX INFO: renamed from: invoke-ozmzZPI, reason: not valid java name */
        public final l m6invokeozmzZPI(long j11) {
            return new l(q2.t.g(j11), q2.t.f(j11));
        }
    }, new Function1<l, q2.t>() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ q2.t invoke(l lVar) {
            return q2.t.b(m7invokeYEO4UFw(lVar));
        }

        /* JADX INFO: renamed from: invoke-YEO4UFw, reason: not valid java name */
        public final long m7invokeYEO4UFw(l lVar) {
            return q2.u.a(kotlin.ranges.a.d(Math.round(lVar.f()), 0), kotlin.ranges.a.d(Math.round(lVar.g()), 0));
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final s0<y1.i, n> f2039i = a(new Function1<y1.i, n>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final n invoke(y1.i iVar) {
            return new n(iVar.f(), iVar.i(), iVar.g(), iVar.c());
        }
    }, new Function1<n, y1.i>() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final y1.i invoke(n nVar) {
            return new y1.i(nVar.f(), nVar.g(), nVar.h(), nVar.i());
        }
    });

    public static final <T, V extends o> s0<T, V> a(Function1<? super T, ? extends V> function1, Function1<? super V, ? extends T> function2) {
        return new t0(function1, function2);
    }

    public static final s0<Float, k> b(FloatCompanionObject floatCompanionObject) {
        return f2031a;
    }

    public static final s0<Integer, k> c(IntCompanionObject intCompanionObject) {
        return f2032b;
    }

    public static final s0<q2.i, k> d(q2.i.a aVar) {
        return f2033c;
    }

    public static final s0<q2.k, l> e(q2.k.a aVar) {
        return f2034d;
    }

    public static final s0<q2.p, l> f(q2.p.a aVar) {
        return f2037g;
    }

    public static final s0<q2.t, l> g(q2.t.a aVar) {
        return f2038h;
    }

    public static final s0<y1.g, l> h(y1.g.a aVar) {
        return f2036f;
    }

    public static final s0<y1.i, n> i(y1.i.a aVar) {
        return f2039i;
    }

    public static final s0<y1.m, l> j(y1.m.a aVar) {
        return f2035e;
    }

    public static final float k(float f11, float f12, float f13) {
        return (f11 * (1 - f13)) + (f12 * f13);
    }
}
