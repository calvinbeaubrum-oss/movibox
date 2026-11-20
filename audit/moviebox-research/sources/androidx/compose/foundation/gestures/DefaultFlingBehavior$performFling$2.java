package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.w;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.k0;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {893}, m = "invokeSuspend")
public final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<k0, Continuation<? super Float>, Object> {
    final /* synthetic */ float $initialVelocity;
    final /* synthetic */ k $this_performFling;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ DefaultFlingBehavior this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultFlingBehavior$performFling$2(float f11, DefaultFlingBehavior defaultFlingBehavior, k kVar, Continuation<? super DefaultFlingBehavior$performFling$2> continuation) {
        super(2, continuation);
        this.$initialVelocity = f11;
        this.this$0 = defaultFlingBehavior;
        this.$this_performFling = kVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultFlingBehavior$performFling$2(this.$initialVelocity, this.this$0, this.$this_performFling, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Float> continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        float f11;
        Ref.FloatRef floatRef;
        androidx.compose.animation.core.i iVar;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            if (Math.abs(this.$initialVelocity) > 1.0f) {
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.element = this.$initialVelocity;
                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                androidx.compose.animation.core.i iVarC = androidx.compose.animation.core.j.c(0.0f, this.$initialVelocity, 0L, 0L, false, 28, null);
                try {
                    w<Float> wVarB = this.this$0.b();
                    final k kVar = this.$this_performFling;
                    final DefaultFlingBehavior defaultFlingBehavior = this.this$0;
                    Function1<androidx.compose.animation.core.f<Float, androidx.compose.animation.core.k>, Unit> function1 = new Function1<androidx.compose.animation.core.f<Float, androidx.compose.animation.core.k>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(androidx.compose.animation.core.f<Float, androidx.compose.animation.core.k> fVar) {
                            invoke2(fVar);
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(androidx.compose.animation.core.f<Float, androidx.compose.animation.core.k> fVar) {
                            float fFloatValue = fVar.e().floatValue() - floatRef3.element;
                            float fA = kVar.a(fFloatValue);
                            floatRef3.element = fVar.e().floatValue();
                            floatRef2.element = fVar.f().floatValue();
                            if (Math.abs(fFloatValue - fA) > 0.5f) {
                                fVar.a();
                            }
                            DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                            defaultFlingBehavior2.e(defaultFlingBehavior2.c() + 1);
                        }
                    };
                    this.L$0 = floatRef2;
                    this.L$1 = iVarC;
                    this.label = 1;
                    if (SuspendAnimationKt.h(iVarC, wVarB, false, function1, this, 2, null) == objE) {
                        return objE;
                    }
                    floatRef = floatRef2;
                    f11 = floatRef.element;
                } catch (CancellationException unused) {
                    floatRef = floatRef2;
                    iVar = iVarC;
                    floatRef.element = ((Number) iVar.f()).floatValue();
                }
            } else {
                f11 = this.$initialVelocity;
            }
        } else {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            iVar = (androidx.compose.animation.core.i) this.L$1;
            floatRef = (Ref.FloatRef) this.L$0;
            try {
                ResultKt.b(obj);
            } catch (CancellationException unused2) {
                floatRef.element = ((Number) iVar.f()).floatValue();
            }
            f11 = floatRef.element;
        }
        return Boxing.c(f11);
    }
}
