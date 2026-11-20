package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.node.h1;
import androidx.compose.ui.node.i1;
import androidx.compose.ui.node.j1;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

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
public final class LazyLayoutSemanticsModifierNode extends androidx.compose.ui.f.c implements i1 {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Function0<? extends m> f2657o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public z f2658p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Orientation f2659q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f2660r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f2661s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public androidx.compose.ui.semantics.j f2662t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Function1<Object, Integer> f2663u = new Function1<Object, Integer>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$indexForKeyMapping$1
        {
            super(1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(Object obj) {
            m mVar = (m) this.this$0.f2657o.invoke();
            int itemCount = mVar.getItemCount();
            int i11 = 0;
            while (i11 < itemCount) {
                if (Intrinsics.b(mVar.b(i11), obj)) {
                    return Integer.valueOf(i11);
                }
                i11++;
            }
            i11 = -1;
            return Integer.valueOf(i11);
        }
    };

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Function1<? super Integer, Boolean> f2664v;

    public LazyLayoutSemanticsModifierNode(Function0<? extends m> function0, z zVar, Orientation orientation, boolean z11, boolean z12) {
        this.f2657o = function0;
        this.f2658p = zVar;
        this.f2659q = orientation;
        this.f2660r = z11;
        this.f2661s = z12;
        M1();
    }

    public final androidx.compose.ui.semantics.b J1() {
        return this.f2658p.d();
    }

    public final boolean K1() {
        return this.f2659q == Orientation.Vertical;
    }

    public final void L1(Function0<? extends m> function0, z zVar, Orientation orientation, boolean z11, boolean z12) {
        this.f2657o = function0;
        this.f2658p = zVar;
        if (this.f2659q != orientation) {
            this.f2659q = orientation;
            j1.b(this);
        }
        if (this.f2660r == z11 && this.f2661s == z12) {
            return;
        }
        this.f2660r = z11;
        this.f2661s = z12;
        M1();
        j1.b(this);
    }

    public final void M1() {
        this.f2662t = new androidx.compose.ui.semantics.j(new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.this$0.f2658p.f());
            }
        }, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.this$0.f2658p.b());
            }
        }, this.f2661s);
        this.f2664v = this.f2660r ? new Function1<Integer, Boolean>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3

            /* JADX INFO: renamed from: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2, reason: invalid class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$updateCachedSemanticsValues$3$2", f = "LazyLayoutSemantics.kt", l = {205}, m = "invokeSuspend")
            public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                final /* synthetic */ int $index;
                int label;
                final /* synthetic */ LazyLayoutSemanticsModifierNode this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass2(LazyLayoutSemanticsModifierNode lazyLayoutSemanticsModifierNode, int i11, Continuation<? super AnonymousClass2> continuation) {
                    super(2, continuation);
                    this.this$0 = lazyLayoutSemanticsModifierNode;
                    this.$index = i11;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass2(this.this$0, this.$index, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objE = kotlin.coroutines.intrinsics.a.e();
                    int i11 = this.label;
                    if (i11 == 0) {
                        ResultKt.b(obj);
                        z zVar = this.this$0.f2658p;
                        int i12 = this.$index;
                        this.label = 1;
                        if (zVar.c(i12, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i11 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f68710a;
                }
            }

            {
                super(1);
            }

            public final Boolean invoke(int i11) {
                m mVar = (m) this.this$0.f2657o.invoke();
                if (i11 >= 0 && i11 < mVar.getItemCount()) {
                    kotlinx.coroutines.j.d(this.this$0.h1(), null, null, new AnonymousClass2(this.this$0, i11, null), 3, null);
                    return Boolean.TRUE;
                }
                throw new IllegalArgumentException(("Can't scroll to index " + i11 + ", it is out of bounds [0, " + mVar.getItemCount() + ')').toString());
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
                return invoke(num.intValue());
            }
        } : null;
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean V() {
        return h1.a(this);
    }

    @Override // androidx.compose.ui.node.i1
    public void W0(androidx.compose.ui.semantics.q qVar) {
        SemanticsPropertiesKt.J(qVar, true);
        SemanticsPropertiesKt.k(qVar, this.f2663u);
        if (K1()) {
            androidx.compose.ui.semantics.j jVar = this.f2662t;
            if (jVar == null) {
                Intrinsics.y("scrollAxisRange");
                jVar = null;
            }
            SemanticsPropertiesKt.K(qVar, jVar);
        } else {
            androidx.compose.ui.semantics.j jVar2 = this.f2662t;
            if (jVar2 == null) {
                Intrinsics.y("scrollAxisRange");
                jVar2 = null;
            }
            SemanticsPropertiesKt.x(qVar, jVar2);
        }
        Function1<? super Integer, Boolean> function1 = this.f2664v;
        if (function1 != null) {
            SemanticsPropertiesKt.t(qVar, null, function1, 1, null);
        }
        SemanticsPropertiesKt.h(qVar, null, new Function0<Float>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutSemanticsModifierNode$applySemantics$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(this.this$0.f2658p.e() - this.this$0.f2658p.a());
            }
        }, 1, null);
        SemanticsPropertiesKt.u(qVar, J1());
    }

    @Override // androidx.compose.ui.node.i1
    public /* synthetic */ boolean Z0() {
        return h1.b(this);
    }

    @Override // androidx.compose.ui.f.c
    public boolean m1() {
        return false;
    }
}
