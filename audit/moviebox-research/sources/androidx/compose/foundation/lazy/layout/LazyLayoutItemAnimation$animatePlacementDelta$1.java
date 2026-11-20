package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.o0;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1", f = "LazyLayoutItemAnimation.kt", l = {151, 158}, m = "invokeSuspend")
public final class LazyLayoutItemAnimation$animatePlacementDelta$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ androidx.compose.animation.core.c0<q2.p> $spec;
    final /* synthetic */ long $totalDelta;
    Object L$0;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animatePlacementDelta$1(LazyLayoutItemAnimation lazyLayoutItemAnimation, androidx.compose.animation.core.c0<q2.p> c0Var, long j11, Continuation<? super LazyLayoutItemAnimation$animatePlacementDelta$1> continuation) {
        super(2, continuation);
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = c0Var;
        this.$totalDelta = j11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animatePlacementDelta$1(this.this$0, this.$spec, this.$totalDelta, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animatePlacementDelta$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x00a9 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        androidx.compose.animation.core.c0 c0Var;
        androidx.compose.animation.core.c0 c0Var2;
        androidx.compose.animation.core.c0 c0Var3;
        Animatable animatable;
        q2.p pVarB;
        Function1<Animatable<q2.p, androidx.compose.animation.core.l>, Unit> function1;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    c0Var2 = (androidx.compose.animation.core.c0) this.L$0;
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.this$0.G(false);
                this.this$0.f2608g = false;
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (this.this$0.f2616o.n()) {
                androidx.compose.animation.core.c0<q2.p> c0Var4 = this.$spec;
                c0Var = c0Var4 instanceof o0 ? (o0) c0Var4 : k.f2724a;
            } else {
                c0Var = this.$spec;
            }
            c0Var2 = c0Var;
            if (!this.this$0.f2616o.n()) {
                Animatable animatable2 = this.this$0.f2616o;
                q2.p pVarB2 = q2.p.b(this.$totalDelta);
                this.L$0 = c0Var2;
                this.label = 1;
                if (animatable2.r(pVarB2, this) == objE) {
                    return objE;
                }
            }
            c0Var3 = c0Var2;
            final long jK = q2.p.k(((q2.p) this.this$0.f2616o.k()).n(), this.$totalDelta);
            animatable = this.this$0.f2616o;
            pVarB = q2.p.b(jK);
            final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
            function1 = new Function1<Animatable<q2.p, androidx.compose.animation.core.l>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animatable<q2.p, androidx.compose.animation.core.l> animatable3) {
                    invoke2(animatable3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animatable<q2.p, androidx.compose.animation.core.l> animatable3) {
                    lazyLayoutItemAnimation.H(q2.p.k(animatable3.k().n(), jK));
                    lazyLayoutItemAnimation.f2604c.invoke();
                }
            };
            this.L$0 = null;
            this.label = 2;
            if (Animatable.f(animatable, pVarB, c0Var3, null, function1, this, 4, null) == objE) {
                return objE;
            }
            this.this$0.G(false);
            this.this$0.f2608g = false;
            return Unit.f68710a;
            this.this$0.f2604c.invoke();
            c0Var3 = c0Var2;
            final long jK2 = q2.p.k(((q2.p) this.this$0.f2616o.k()).n(), this.$totalDelta);
            animatable = this.this$0.f2616o;
            pVarB = q2.p.b(jK2);
            final LazyLayoutItemAnimation lazyLayoutItemAnimation2 = this.this$0;
            function1 = new Function1<Animatable<q2.p, androidx.compose.animation.core.l>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animatePlacementDelta$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animatable<q2.p, androidx.compose.animation.core.l> animatable3) {
                    invoke2(animatable3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animatable<q2.p, androidx.compose.animation.core.l> animatable3) {
                    lazyLayoutItemAnimation2.H(q2.p.k(animatable3.k().n(), jK2));
                    lazyLayoutItemAnimation2.f2604c.invoke();
                }
            };
            this.L$0 = null;
            this.label = 2;
            if (Animatable.f(animatable, pVarB, c0Var3, null, function1, this, 4, null) == objE) {
                return objE;
            }
            this.this$0.G(false);
            this.this$0.f2608g = false;
        } catch (CancellationException unused) {
        }
        return Unit.f68710a;
    }
}
