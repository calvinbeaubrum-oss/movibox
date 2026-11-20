package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class Animatable<T, V extends o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s0<T, V> f2015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f2016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f2017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i<T, V> f2018d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final i1 f2019e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final i1 f2020f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutatorMutex f2021g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final o0<T> f2022h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final V f2023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final V f2024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public V f2025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public V f2026l;

    public Animatable(T t11, s0<T, V> s0Var, T t12, String str) {
        this.f2015a = s0Var;
        this.f2016b = t12;
        this.f2017c = str;
        this.f2018d = new i<>(s0Var, t11, null, 0L, 0L, false, 60, null);
        this.f2019e = u2.c(Boolean.FALSE, null, 2, null);
        this.f2020f = u2.c(t11, null, 2, null);
        this.f2021g = new MutatorMutex();
        this.f2022h = new o0<>(0.0f, 0.0f, t12, 3, null);
        o oVarM = m();
        V v11 = oVarM instanceof k ? a.f2044e : oVarM instanceof l ? a.f2045f : oVarM instanceof m ? a.f2046g : a.f2047h;
        Intrinsics.e(v11, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f2023i = v11;
        o oVarM2 = m();
        V v12 = oVarM2 instanceof k ? a.f2040a : oVarM2 instanceof l ? a.f2041b : oVarM2 instanceof m ? a.f2042c : a.f2043d;
        Intrinsics.e(v12, "null cannot be cast to non-null type V of androidx.compose.animation.core.Animatable");
        this.f2024j = v12;
        this.f2025k = v11;
        this.f2026l = v12;
    }

    public /* synthetic */ Animatable(Object obj, s0 s0Var, Object obj2, String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, s0Var, (i11 & 4) != 0 ? null : obj2, (i11 & 8) != 0 ? "Animatable" : str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object f(Animatable animatable, Object obj, g gVar, Object obj2, Function1 function1, Continuation continuation, int i11, Object obj3) {
        if ((i11 & 2) != 0) {
            gVar = animatable.f2022h;
        }
        g gVar2 = gVar;
        if ((i11 & 4) != 0) {
            obj2 = animatable.l();
        }
        Object obj4 = obj2;
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        return animatable.e(obj, gVar2, obj4, function1, continuation);
    }

    public final Object e(T t11, g<T> gVar, T t12, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super e<T, V>> continuation) {
        return o(d.a(gVar, this.f2015a, k(), t11, t12), t12, function1, continuation);
    }

    public final T g(T t11) {
        if (Intrinsics.b(this.f2025k, this.f2023i) && Intrinsics.b(this.f2026l, this.f2024j)) {
            return t11;
        }
        V vInvoke = this.f2015a.a().invoke(t11);
        int iB = vInvoke.b();
        boolean z11 = false;
        for (int i11 = 0; i11 < iB; i11++) {
            if (vInvoke.a(i11) < this.f2025k.a(i11) || vInvoke.a(i11) > this.f2026l.a(i11)) {
                vInvoke.e(i11, kotlin.ranges.a.j(vInvoke.a(i11), this.f2025k.a(i11), this.f2026l.a(i11)));
                z11 = true;
            }
        }
        return z11 ? this.f2015a.b().invoke(vInvoke) : t11;
    }

    public final void h() {
        i<T, V> iVar = this.f2018d;
        iVar.g().d();
        iVar.j(Long.MIN_VALUE);
        p(false);
    }

    public final i<T, V> i() {
        return this.f2018d;
    }

    public final s0<T, V> j() {
        return this.f2015a;
    }

    public final T k() {
        return this.f2018d.getValue();
    }

    public final T l() {
        return (T) this.f2015a.b().invoke(m());
    }

    public final V m() {
        return (V) this.f2018d.g();
    }

    public final boolean n() {
        return ((Boolean) this.f2019e.getValue()).booleanValue();
    }

    public final Object o(c<T, V> cVar, T t11, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super e<T, V>> continuation) {
        return MutatorMutex.e(this.f2021g, null, new Animatable$runAnimation$2(this, t11, cVar, this.f2018d.b(), function1, null), continuation, 1, null);
    }

    public final void p(boolean z11) {
        this.f2019e.setValue(Boolean.valueOf(z11));
    }

    public final void q(T t11) {
        this.f2020f.setValue(t11);
    }

    public final Object r(T t11, Continuation<? super Unit> continuation) {
        Object objE = MutatorMutex.e(this.f2021g, null, new Animatable$snapTo$2(this, t11, null), continuation, 1, null);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }

    public final Object s(Continuation<? super Unit> continuation) {
        Object objE = MutatorMutex.e(this.f2021g, null, new Animatable$stop$2(this, null), continuation, 1, null);
        return objE == kotlin.coroutines.intrinsics.a.e() ? objE : Unit.f68710a;
    }
}
