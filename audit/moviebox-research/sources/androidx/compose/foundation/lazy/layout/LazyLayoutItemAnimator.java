package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableScatterSet;
import androidx.collection.t0;
import androidx.collection.u0;
import androidx.compose.foundation.lazy.layout.s;
import androidx.compose.ui.graphics.c4;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class LazyLayoutItemAnimator<T extends s> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p f2621b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f2622c;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public androidx.compose.ui.node.n f2629j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.collection.l0<Object, LazyLayoutItemAnimator<T>.ItemInfo> f2620a = t0.d();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableScatterSet<Object> f2623d = u0.a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<T> f2624e = new ArrayList();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<T> f2625f = new ArrayList();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<T> f2626g = new ArrayList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<T> f2627h = new ArrayList();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<LazyLayoutItemAnimation> f2628i = new ArrayList();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.ui.f f2630k = new DisplayingDisappearingItemsElement(this);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DisplayingDisappearingItemsElement extends androidx.compose.ui.node.l0<a> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LazyLayoutItemAnimator<?> f2631b;

        public DisplayingDisappearingItemsElement(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.f2631b = lazyLayoutItemAnimator;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DisplayingDisappearingItemsElement) && Intrinsics.b(this.f2631b, ((DisplayingDisappearingItemsElement) obj).f2631b);
        }

        public int hashCode() {
            return this.f2631b.hashCode();
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public a a() {
            return new a(this.f2631b);
        }

        @Override // androidx.compose.ui.node.l0
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public void o(a aVar) {
            aVar.H1(this.f2631b);
        }

        public String toString() {
            return "DisplayingDisappearingItemsElement(animator=" + this.f2631b + ')';
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public final class ItemInfo {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public q2.b f2633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f2634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f2635d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f2637f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f2638g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LazyLayoutItemAnimation[] f2632a = l.f2725a;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f2636e = 1;

        public ItemInfo() {
        }

        public static /* synthetic */ void l(ItemInfo itemInfo, s sVar, kotlinx.coroutines.k0 k0Var, c4 c4Var, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 32) != 0) {
                i13 = LazyLayoutItemAnimator.this.f(sVar);
            }
            itemInfo.k(sVar, k0Var, c4Var, i11, i12, i13);
        }

        public final LazyLayoutItemAnimation[] a() {
            return this.f2632a;
        }

        public final q2.b b() {
            return this.f2633b;
        }

        public final int c() {
            return this.f2634c;
        }

        public final int d() {
            return this.f2635d;
        }

        public final int e() {
            return this.f2638g;
        }

        public final int f() {
            return this.f2637f;
        }

        public final int g() {
            return this.f2636e;
        }

        public final boolean h() {
            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : this.f2632a) {
                if (lazyLayoutItemAnimation != null && lazyLayoutItemAnimation.x()) {
                    return true;
                }
            }
            return false;
        }

        public final void i(int i11) {
            this.f2635d = i11;
        }

        public final void j(int i11) {
            this.f2636e = i11;
        }

        public final void k(T t11, kotlinx.coroutines.k0 k0Var, c4 c4Var, int i11, int i12, int i13) {
            if (!h()) {
                this.f2637f = i11;
                this.f2638g = i12;
            }
            int length = this.f2632a.length;
            for (int iB = t11.b(); iB < length; iB++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = this.f2632a[iB];
                if (lazyLayoutItemAnimation != null) {
                    lazyLayoutItemAnimation.y();
                }
            }
            if (this.f2632a.length != t11.b()) {
                Object[] objArrCopyOf = Arrays.copyOf(this.f2632a, t11.b());
                Intrinsics.f(objArrCopyOf, "copyOf(this, newSize)");
                this.f2632a = (LazyLayoutItemAnimation[]) objArrCopyOf;
            }
            this.f2633b = q2.b.a(t11.a());
            this.f2634c = i13;
            this.f2635d = t11.k();
            this.f2636e = t11.d();
            int iB2 = t11.b();
            final LazyLayoutItemAnimator<T> lazyLayoutItemAnimator = LazyLayoutItemAnimator.this;
            for (int i14 = 0; i14 < iB2; i14++) {
                d dVarC = l.c(t11.i(i14));
                if (dVarC == null) {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.f2632a[i14];
                    if (lazyLayoutItemAnimation2 != null) {
                        lazyLayoutItemAnimation2.y();
                    }
                    this.f2632a[i14] = null;
                } else {
                    LazyLayoutItemAnimation lazyLayoutItemAnimation3 = this.f2632a[i14];
                    if (lazyLayoutItemAnimation3 == null) {
                        lazyLayoutItemAnimation3 = new LazyLayoutItemAnimation(k0Var, c4Var, new Function0<Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$ItemInfo$updateAnimation$1$animation$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.f68710a;
                            }

                            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                androidx.compose.ui.node.n nVar = lazyLayoutItemAnimator.f2629j;
                                if (nVar != null) {
                                    androidx.compose.ui.node.o.a(nVar);
                                }
                            }
                        });
                        this.f2632a[i14] = lazyLayoutItemAnimation3;
                    }
                    lazyLayoutItemAnimation3.C(dVarC.H1());
                    lazyLayoutItemAnimation3.I(dVarC.J1());
                    lazyLayoutItemAnimation3.D(dVarC.I1());
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends androidx.compose.ui.f.c implements androidx.compose.ui.node.n {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public LazyLayoutItemAnimator<?> f2640o;

        public a(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            this.f2640o = lazyLayoutItemAnimator;
        }

        @Override // androidx.compose.ui.node.n
        public void A(z1.c cVar) {
            List list = this.f2640o.f2628i;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                LazyLayoutItemAnimation lazyLayoutItemAnimation = (LazyLayoutItemAnimation) list.get(i11);
                GraphicsLayer graphicsLayerP = lazyLayoutItemAnimation.p();
                if (graphicsLayerP != null) {
                    float fH = q2.p.h(lazyLayoutItemAnimation.o());
                    float fI = q2.p.i(lazyLayoutItemAnimation.o());
                    float fH2 = fH - q2.p.h(graphicsLayerP.w());
                    float fI2 = fI - q2.p.i(graphicsLayerP.w());
                    cVar.Q0().c().c(fH2, fI2);
                    try {
                        androidx.compose.ui.graphics.layer.d.a(cVar, graphicsLayerP);
                        cVar.Q0().c().c(-fH2, -fI2);
                    } catch (Throwable th2) {
                        cVar.Q0().c().c(-fH2, -fI2);
                        throw th2;
                    }
                }
            }
            cVar.a1();
        }

        @Override // androidx.compose.ui.node.n
        public /* synthetic */ void F0() {
            androidx.compose.ui.node.m.a(this);
        }

        public final void H1(LazyLayoutItemAnimator<?> lazyLayoutItemAnimator) {
            if (Intrinsics.b(this.f2640o, lazyLayoutItemAnimator) || !getNode().o1()) {
                return;
            }
            this.f2640o.o();
            lazyLayoutItemAnimator.f2629j = this;
            this.f2640o = lazyLayoutItemAnimator;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.b(this.f2640o, ((a) obj).f2640o);
        }

        public int hashCode() {
            return this.f2640o.hashCode();
        }

        @Override // androidx.compose.ui.f.c
        public void r1() {
            this.f2640o.f2629j = this;
        }

        @Override // androidx.compose.ui.f.c
        public void s1() {
            this.f2640o.o();
        }

        public String toString() {
            return "DisplayingDisappearingItemsNode(animator=" + this.f2640o + ')';
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void l(LazyLayoutItemAnimator lazyLayoutItemAnimator, s sVar, int i11, ItemInfo itemInfo, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            LazyLayoutItemAnimator<T>.ItemInfo itemInfoB = lazyLayoutItemAnimator.f2620a.b(sVar.getKey());
            Intrinsics.d(itemInfoB);
            itemInfo = itemInfoB;
        }
        lazyLayoutItemAnimator.k(sVar, i11, itemInfo);
    }

    public static /* synthetic */ void q(LazyLayoutItemAnimator lazyLayoutItemAnimator, s sVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        lazyLayoutItemAnimator.p(sVar, z11);
    }

    public final LazyLayoutItemAnimation e(Object obj, int i11) {
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfoB = this.f2620a.b(obj);
        if (itemInfoB == null || (lazyLayoutItemAnimationArrA = itemInfoB.a()) == null) {
            return null;
        }
        return lazyLayoutItemAnimationArrA[i11];
    }

    public final int f(s sVar) {
        long j11 = sVar.j(0);
        return !sVar.e() ? q2.p.i(j11) : q2.p.h(j11);
    }

    public final boolean g(T t11) {
        int iB = t11.b();
        for (int i11 = 0; i11 < iB; i11++) {
            if (l.c(t11.i(i11)) != null) {
                return true;
            }
        }
        return false;
    }

    public final int h(s sVar) {
        long j11 = sVar.j(0);
        return sVar.e() ? q2.p.i(j11) : q2.p.h(j11);
    }

    public final long i() {
        long jA = q2.t.f74253b.a();
        List<LazyLayoutItemAnimation> list = this.f2628i;
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = list.get(i11);
            GraphicsLayer graphicsLayerP = lazyLayoutItemAnimation.p();
            if (graphicsLayerP != null) {
                jA = q2.u.a(Math.max(q2.t.g(jA), q2.p.h(lazyLayoutItemAnimation.s()) + q2.t.g(graphicsLayerP.v())), Math.max(q2.t.f(jA), q2.p.i(lazyLayoutItemAnimation.s()) + q2.t.f(graphicsLayerP.v())));
            }
        }
        return jA;
    }

    public final androidx.compose.ui.f j() {
        return this.f2630k;
    }

    public final void k(T t11, int i11, LazyLayoutItemAnimator<T>.ItemInfo itemInfo) {
        int i12 = 0;
        long j11 = t11.j(0);
        long jE = t11.e() ? q2.p.e(j11, 0, i11, 1, null) : q2.p.e(j11, i11, 0, 2, null);
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA = itemInfo.a();
        int length = lazyLayoutItemAnimationArrA.length;
        int i13 = 0;
        while (i12 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArrA[i12];
            int i14 = i13 + 1;
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.J(q2.p.l(jE, q2.p.k(t11.j(i13), j11)));
            }
            i12++;
            i13 = i14;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m(int i11, int i12, int i13, List<T> list, p pVar, t<T> tVar, boolean z11, boolean z12, int i14, boolean z13, int i15, int i16, kotlinx.coroutines.k0 k0Var, c4 c4Var) {
        final p pVar2;
        final p pVar3;
        int[] iArr;
        int[] iArr2;
        long[] jArr;
        Object[] objArr;
        long[] jArr2;
        Object[] objArr2;
        int[] iArr3;
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArr;
        int i17;
        p pVar4;
        p pVar5;
        long[] jArr3;
        Object[] objArr3;
        List<T> list2 = list;
        p pVar6 = this.f2621b;
        this.f2621b = pVar;
        int size = list.size();
        int i18 = 0;
        int i19 = 0;
        while (true) {
            if (i19 >= size) {
                if (!this.f2620a.e()) {
                    break;
                }
                o();
                return;
            } else if (g(list2.get(i19))) {
                break;
            } else {
                i19++;
            }
        }
        int i21 = this.f2622c;
        s sVar = (s) CollectionsKt___CollectionsKt.g0(list);
        this.f2622c = sVar != null ? sVar.getIndex() : 0;
        long jA = z11 ? q2.q.a(0, i11) : q2.q.a(i11, 0);
        boolean z14 = z12 || !z13;
        androidx.collection.l0<Object, LazyLayoutItemAnimator<T>.ItemInfo> l0Var = this.f2620a;
        Object[] objArr4 = l0Var.f1983b;
        long[] jArr4 = l0Var.f1982a;
        int length = jArr4.length - 2;
        boolean z15 = z14;
        if (length >= 0) {
            while (true) {
                long j11 = jArr4[i18];
                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i22 = 8 - ((~(i18 - length)) >>> 31);
                    int i23 = 0;
                    while (i23 < i22) {
                        if ((j11 & 255) < 128) {
                            this.f2623d.h(objArr4[(i18 << 3) + i23]);
                        }
                        j11 >>= 8;
                        i23++;
                        objArr4 = objArr4;
                        jArr4 = jArr4;
                    }
                    jArr3 = jArr4;
                    objArr3 = objArr4;
                    if (i22 != 8) {
                        break;
                    }
                } else {
                    jArr3 = jArr4;
                    objArr3 = objArr4;
                }
                if (i18 == length) {
                    break;
                }
                i18++;
                objArr4 = objArr3;
                jArr4 = jArr3;
            }
        }
        int size2 = list.size();
        int i24 = 0;
        while (i24 < size2) {
            T t11 = list2.get(i24);
            this.f2623d.x(t11.getKey());
            if (g(t11)) {
                LazyLayoutItemAnimator<T>.ItemInfo itemInfoB = this.f2620a.b(t11.getKey());
                int iA = pVar6 != null ? pVar6.a(t11.getKey()) : -1;
                boolean z16 = iA == -1 && pVar6 != null;
                if (itemInfoB == null) {
                    LazyLayoutItemAnimator<T>.ItemInfo itemInfo = new ItemInfo();
                    ItemInfo.l(itemInfo, t11, k0Var, c4Var, i15, i16, 0, 32, null);
                    this.f2620a.r(t11.getKey(), itemInfo);
                    if (t11.getIndex() == iA || iA == -1) {
                        long j12 = t11.j(0);
                        k(t11, t11.e() ? q2.p.i(j12) : q2.p.h(j12), itemInfo);
                        if (z16) {
                            LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA = itemInfo.a();
                            for (LazyLayoutItemAnimation lazyLayoutItemAnimation : lazyLayoutItemAnimationArrA) {
                                if (lazyLayoutItemAnimation != null) {
                                    lazyLayoutItemAnimation.k();
                                    Unit unit = Unit.f68710a;
                                }
                            }
                        }
                    } else if (iA < i21) {
                        this.f2624e.add(t11);
                    } else {
                        this.f2625f.add(t11);
                    }
                } else if (z15) {
                    ItemInfo.l(itemInfoB, t11, k0Var, c4Var, i15, i16, 0, 32, null);
                    LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA2 = itemInfoB.a();
                    int length2 = lazyLayoutItemAnimationArrA2.length;
                    int i25 = 0;
                    while (i25 < length2) {
                        int i26 = size2;
                        LazyLayoutItemAnimation lazyLayoutItemAnimation2 = lazyLayoutItemAnimationArrA2[i25];
                        if (lazyLayoutItemAnimation2 != null) {
                            pVar5 = pVar6;
                            if (!q2.p.g(lazyLayoutItemAnimation2.s(), LazyLayoutItemAnimation.f2599s.a())) {
                                lazyLayoutItemAnimation2.J(q2.p.l(lazyLayoutItemAnimation2.s(), jA));
                            }
                        } else {
                            pVar5 = pVar6;
                        }
                        i25++;
                        size2 = i26;
                        pVar6 = pVar5;
                    }
                    i17 = size2;
                    pVar4 = pVar6;
                    if (z16) {
                        for (LazyLayoutItemAnimation lazyLayoutItemAnimation3 : itemInfoB.a()) {
                            if (lazyLayoutItemAnimation3 != null) {
                                if (lazyLayoutItemAnimation3.v()) {
                                    this.f2628i.remove(lazyLayoutItemAnimation3);
                                    androidx.compose.ui.node.n nVar = this.f2629j;
                                    if (nVar != null) {
                                        androidx.compose.ui.node.o.a(nVar);
                                        Unit unit2 = Unit.f68710a;
                                    }
                                }
                                lazyLayoutItemAnimation3.k();
                            }
                        }
                    }
                    q(this, t11, false, 2, null);
                }
                i17 = size2;
                pVar4 = pVar6;
            } else {
                i17 = size2;
                pVar4 = pVar6;
                n(t11.getKey());
            }
            i24++;
            list2 = list;
            size2 = i17;
            pVar6 = pVar4;
        }
        int i27 = i14;
        p pVar7 = pVar6;
        int[] iArr4 = new int[i27];
        for (int i28 = 0; i28 < i27; i28++) {
            iArr4[i28] = 0;
        }
        if (!z15 || pVar7 == null) {
            pVar2 = pVar7;
        } else {
            if (!this.f2624e.isEmpty()) {
                List<T> list3 = this.f2624e;
                if (list3.size() > 1) {
                    pVar2 = pVar7;
                    kotlin.collections.j.z(list3, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$1
                        @Override // java.util.Comparator
                        public final int compare(T t12, T t13) {
                            return kotlin.comparisons.b.d(Integer.valueOf(pVar2.a(((s) t13).getKey())), Integer.valueOf(pVar2.a(((s) t12).getKey())));
                        }
                    });
                } else {
                    pVar2 = pVar7;
                }
                List<T> list4 = this.f2624e;
                int size3 = list4.size();
                for (int i29 = 0; i29 < size3; i29++) {
                    T t12 = list4.get(i29);
                    l(this, t12, i15 - r(iArr4, t12), null, 4, null);
                    q(this, t12, false, 2, null);
                }
                ArraysKt___ArraysJvmKt.v(iArr4, 0, 0, 0, 6, null);
            } else {
                pVar2 = pVar7;
            }
            if (!this.f2625f.isEmpty()) {
                List<T> list5 = this.f2625f;
                if (list5.size() > 1) {
                    kotlin.collections.j.z(list5, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$1
                        @Override // java.util.Comparator
                        public final int compare(T t13, T t14) {
                            return kotlin.comparisons.b.d(Integer.valueOf(pVar2.a(((s) t13).getKey())), Integer.valueOf(pVar2.a(((s) t14).getKey())));
                        }
                    });
                }
                List<T> list6 = this.f2625f;
                int size4 = list6.size();
                for (int i31 = 0; i31 < size4; i31++) {
                    T t13 = list6.get(i31);
                    l(this, t13, (i16 + r(iArr4, t13)) - t13.h(), null, 4, null);
                    q(this, t13, false, 2, null);
                }
                ArraysKt___ArraysJvmKt.v(iArr4, 0, 0, 0, 6, null);
            }
        }
        MutableScatterSet<Object> mutableScatterSet = this.f2623d;
        Object[] objArr5 = mutableScatterSet.f1898b;
        long[] jArr5 = mutableScatterSet.f1897a;
        int length3 = jArr5.length - 2;
        if (length3 >= 0) {
            int i32 = 0;
            while (true) {
                long j13 = jArr5[i32];
                if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i33 = 8 - ((~(i32 - length3)) >>> 31);
                    int i34 = 0;
                    while (i34 < i33) {
                        if ((j13 & 255) < 128) {
                            Object obj = objArr5[(i32 << 3) + i34];
                            LazyLayoutItemAnimator<T>.ItemInfo itemInfoB2 = this.f2620a.b(obj);
                            Intrinsics.d(itemInfoB2);
                            LazyLayoutItemAnimator<T>.ItemInfo itemInfo2 = itemInfoB2;
                            int iA2 = pVar.a(obj);
                            jArr2 = jArr5;
                            itemInfo2.j(Math.min(i27, itemInfo2.g()));
                            objArr2 = objArr5;
                            itemInfo2.i(Math.min(i27 - itemInfo2.g(), itemInfo2.d()));
                            if (iA2 == -1) {
                                LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA3 = itemInfo2.a();
                                int length4 = lazyLayoutItemAnimationArrA3.length;
                                int i35 = 0;
                                boolean z17 = false;
                                int i36 = 0;
                                while (i35 < length4) {
                                    LazyLayoutItemAnimation lazyLayoutItemAnimation4 = lazyLayoutItemAnimationArrA3[i35];
                                    int i37 = i36 + 1;
                                    if (lazyLayoutItemAnimation4 != null) {
                                        if (lazyLayoutItemAnimation4.v()) {
                                            lazyLayoutItemAnimationArr = lazyLayoutItemAnimationArrA3;
                                        } else {
                                            if (lazyLayoutItemAnimation4.u()) {
                                                lazyLayoutItemAnimation4.y();
                                                itemInfo2.a()[i36] = null;
                                                lazyLayoutItemAnimationArr = lazyLayoutItemAnimationArrA3;
                                                this.f2628i.remove(lazyLayoutItemAnimation4);
                                                androidx.compose.ui.node.n nVar2 = this.f2629j;
                                                if (nVar2 != null) {
                                                    androidx.compose.ui.node.o.a(nVar2);
                                                    Unit unit3 = Unit.f68710a;
                                                }
                                            } else {
                                                lazyLayoutItemAnimationArr = lazyLayoutItemAnimationArrA3;
                                                if (lazyLayoutItemAnimation4.p() != null) {
                                                    lazyLayoutItemAnimation4.l();
                                                }
                                                if (lazyLayoutItemAnimation4.v()) {
                                                    this.f2628i.add(lazyLayoutItemAnimation4);
                                                    androidx.compose.ui.node.n nVar3 = this.f2629j;
                                                    if (nVar3 != null) {
                                                        androidx.compose.ui.node.o.a(nVar3);
                                                        Unit unit4 = Unit.f68710a;
                                                    }
                                                } else {
                                                    lazyLayoutItemAnimation4.y();
                                                    itemInfo2.a()[i36] = null;
                                                }
                                            }
                                            i35++;
                                            i36 = i37;
                                            lazyLayoutItemAnimationArrA3 = lazyLayoutItemAnimationArr;
                                        }
                                        z17 = true;
                                        i35++;
                                        i36 = i37;
                                        lazyLayoutItemAnimationArrA3 = lazyLayoutItemAnimationArr;
                                    } else {
                                        lazyLayoutItemAnimationArr = lazyLayoutItemAnimationArrA3;
                                    }
                                    i35++;
                                    i36 = i37;
                                    lazyLayoutItemAnimationArrA3 = lazyLayoutItemAnimationArr;
                                }
                                if (!z17) {
                                    n(obj);
                                }
                            } else {
                                q2.b bVarB = itemInfo2.b();
                                Intrinsics.d(bVarB);
                                s sVarA = tVar.a(iA2, itemInfo2.d(), itemInfo2.g(), bVarB.r());
                                sVarA.c(true);
                                LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA4 = itemInfo2.a();
                                int length5 = lazyLayoutItemAnimationArrA4.length;
                                iArr3 = iArr4;
                                int i38 = 0;
                                while (true) {
                                    if (i38 < length5) {
                                        LazyLayoutItemAnimation lazyLayoutItemAnimation5 = lazyLayoutItemAnimationArrA4[i38];
                                        int i39 = length5;
                                        if (lazyLayoutItemAnimation5 != null && lazyLayoutItemAnimation5.w()) {
                                        }
                                        i38++;
                                        lazyLayoutItemAnimationArrA4 = lazyLayoutItemAnimationArrA4;
                                        length5 = i39;
                                    } else if (pVar2 != null && iA2 == pVar2.a(obj)) {
                                        n(obj);
                                    }
                                    itemInfo2.k(sVarA, k0Var, c4Var, i15, i16, itemInfo2.c());
                                    if (iA2 < this.f2622c) {
                                        this.f2626g.add((T) sVarA);
                                    } else {
                                        this.f2627h.add((T) sVarA);
                                    }
                                }
                            }
                            j13 >>= 8;
                            i34++;
                            jArr5 = jArr2;
                            i27 = i14;
                            iArr4 = iArr3;
                            objArr5 = objArr2;
                        } else {
                            jArr2 = jArr5;
                            objArr2 = objArr5;
                        }
                        iArr3 = iArr4;
                        j13 >>= 8;
                        i34++;
                        jArr5 = jArr2;
                        i27 = i14;
                        iArr4 = iArr3;
                        objArr5 = objArr2;
                    }
                    pVar3 = pVar;
                    jArr = jArr5;
                    objArr = objArr5;
                    iArr = iArr4;
                    if (i33 != 8) {
                        break;
                    }
                } else {
                    pVar3 = pVar;
                    jArr = jArr5;
                    objArr = objArr5;
                    iArr = iArr4;
                }
                if (i32 == length3) {
                    break;
                }
                i32++;
                jArr5 = jArr;
                i27 = i14;
                iArr4 = iArr;
                objArr5 = objArr;
            }
        } else {
            pVar3 = pVar;
            iArr = iArr4;
        }
        if (!this.f2626g.isEmpty()) {
            List<T> list7 = this.f2626g;
            if (list7.size() > 1) {
                kotlin.collections.j.z(list7, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortByDescending$2
                    @Override // java.util.Comparator
                    public final int compare(T t14, T t15) {
                        return kotlin.comparisons.b.d(Integer.valueOf(pVar3.a(((s) t15).getKey())), Integer.valueOf(pVar3.a(((s) t14).getKey())));
                    }
                });
            }
            List<T> list8 = this.f2626g;
            int size5 = list8.size();
            int i40 = 0;
            while (i40 < size5) {
                T t14 = list8.get(i40);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfoB3 = this.f2620a.b(t14.getKey());
                Intrinsics.d(itemInfoB3);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo3 = itemInfoB3;
                int[] iArr5 = iArr;
                t14.f((z12 ? h((s) CollectionsKt___CollectionsKt.e0(list)) : itemInfo3.f()) - r(iArr5, t14), itemInfo3.c(), i12, i13);
                if (z15) {
                    p(t14, true);
                }
                i40++;
                iArr = iArr5;
            }
            iArr2 = iArr;
            ArraysKt___ArraysJvmKt.v(iArr2, 0, 0, 0, 6, null);
        } else {
            iArr2 = iArr;
        }
        if (!this.f2627h.isEmpty()) {
            List<T> list9 = this.f2627h;
            if (list9.size() > 1) {
                kotlin.collections.j.z(list9, new Comparator() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator$onMeasured$$inlined$sortBy$2
                    @Override // java.util.Comparator
                    public final int compare(T t15, T t16) {
                        return kotlin.comparisons.b.d(Integer.valueOf(pVar3.a(((s) t15).getKey())), Integer.valueOf(pVar3.a(((s) t16).getKey())));
                    }
                });
            }
            List<T> list10 = this.f2627h;
            int size6 = list10.size();
            for (int i41 = 0; i41 < size6; i41++) {
                T t15 = list10.get(i41);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfoB4 = this.f2620a.b(t15.getKey());
                Intrinsics.d(itemInfoB4);
                LazyLayoutItemAnimator<T>.ItemInfo itemInfo4 = itemInfoB4;
                t15.f((z12 ? h((s) CollectionsKt___CollectionsKt.q0(list)) : itemInfo4.e() - t15.h()) + r(iArr2, t15), itemInfo4.c(), i12, i13);
                if (z15) {
                    p(t15, true);
                }
            }
        }
        List<T> list11 = this.f2626g;
        kotlin.collections.m.U(list11);
        Unit unit5 = Unit.f68710a;
        list.addAll(0, list11);
        list.addAll(this.f2627h);
        this.f2624e.clear();
        this.f2625f.clear();
        this.f2626g.clear();
        this.f2627h.clear();
        this.f2623d.m();
    }

    public final void n(Object obj) {
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA;
        LazyLayoutItemAnimator<T>.ItemInfo itemInfoO = this.f2620a.o(obj);
        if (itemInfoO == null || (lazyLayoutItemAnimationArrA = itemInfoO.a()) == null) {
            return;
        }
        for (LazyLayoutItemAnimation lazyLayoutItemAnimation : lazyLayoutItemAnimationArrA) {
            if (lazyLayoutItemAnimation != null) {
                lazyLayoutItemAnimation.y();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:22:0x005b A[LOOP:0: B:7:0x0015->B:22:0x005b, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x005e A[EDGE_INSN: B:27:0x005e->B:23:0x005e BREAK  A[LOOP:0: B:7:0x0015->B:22:0x005b], SYNTHETIC] */
    public final void o() {
        if (this.f2620a.f()) {
            androidx.collection.l0<Object, LazyLayoutItemAnimator<T>.ItemInfo> l0Var = this.f2620a;
            Object[] objArr = l0Var.f1984c;
            long[] jArr = l0Var.f1982a;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i11 = 0;
                while (true) {
                    long j11 = jArr[i11];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                        if (i11 != length) {
                            break;
                            break;
                        }
                        i11++;
                    } else {
                        int i12 = 8 - ((~(i11 - length)) >>> 31);
                        for (int i13 = 0; i13 < i12; i13++) {
                            if ((255 & j11) < 128) {
                                for (LazyLayoutItemAnimation lazyLayoutItemAnimation : ((ItemInfo) objArr[(i11 << 3) + i13]).a()) {
                                    if (lazyLayoutItemAnimation != null) {
                                        lazyLayoutItemAnimation.y();
                                    }
                                }
                            }
                            j11 >>= 8;
                        }
                        if (i12 != 8) {
                            break;
                        } else if (i11 != length) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                }
            }
            this.f2620a.h();
        }
        this.f2621b = p.f2730a;
        this.f2622c = -1;
    }

    public final void p(T t11, boolean z11) {
        LazyLayoutItemAnimator<T>.ItemInfo itemInfoB = this.f2620a.b(t11.getKey());
        Intrinsics.d(itemInfoB);
        LazyLayoutItemAnimation[] lazyLayoutItemAnimationArrA = itemInfoB.a();
        int length = lazyLayoutItemAnimationArrA.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            LazyLayoutItemAnimation lazyLayoutItemAnimation = lazyLayoutItemAnimationArrA[i11];
            int i13 = i12 + 1;
            if (lazyLayoutItemAnimation != null) {
                long j11 = t11.j(i12);
                long jS = lazyLayoutItemAnimation.s();
                if (!q2.p.g(jS, LazyLayoutItemAnimation.f2599s.a()) && !q2.p.g(jS, j11)) {
                    lazyLayoutItemAnimation.m(q2.p.k(j11, jS), z11);
                }
                lazyLayoutItemAnimation.J(j11);
            }
            i11++;
            i12 = i13;
        }
    }

    public final int r(int[] iArr, T t11) {
        int iK = t11.k();
        int iD = t11.d() + iK;
        int iMax = 0;
        while (iK < iD) {
            int iH = iArr[iK] + t11.h();
            iArr[iK] = iH;
            iMax = Math.max(iMax, iH);
            iK++;
        }
        return iMax;
    }
}
