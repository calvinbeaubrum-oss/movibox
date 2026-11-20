package androidx.compose.foundation.lazy.layout;

import androidx.compose.animation.core.Animatable;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2", f = "LazyLayoutItemAnimation.kt", l = {195, 197}, m = "invokeSuspend")
public final class LazyLayoutItemAnimation$animateAppearance$2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ GraphicsLayer $layer;
    final /* synthetic */ boolean $shouldResetValue;
    final /* synthetic */ androidx.compose.animation.core.c0<Float> $spec;
    int label;
    final /* synthetic */ LazyLayoutItemAnimation this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LazyLayoutItemAnimation$animateAppearance$2(boolean z11, LazyLayoutItemAnimation lazyLayoutItemAnimation, androidx.compose.animation.core.c0<Float> c0Var, GraphicsLayer graphicsLayer, Continuation<? super LazyLayoutItemAnimation$animateAppearance$2> continuation) {
        super(2, continuation);
        this.$shouldResetValue = z11;
        this.this$0 = lazyLayoutItemAnimation;
        this.$spec = c0Var;
        this.$layer = graphicsLayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LazyLayoutItemAnimation$animateAppearance$2(this.$shouldResetValue, this.this$0, this.$spec, this.$layer, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LazyLayoutItemAnimation$animateAppearance$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.this$0.z(false);
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            if (this.$shouldResetValue) {
                Animatable animatable = this.this$0.f2617p;
                Float fC = Boxing.c(0.0f);
                this.label = 1;
                if (animatable.r(fC, this) == objE) {
                    return objE;
                }
            }
            Animatable animatable2 = this.this$0.f2617p;
            Float fC2 = Boxing.c(1.0f);
            androidx.compose.animation.core.c0<Float> c0Var = this.$spec;
            final GraphicsLayer graphicsLayer = this.$layer;
            final LazyLayoutItemAnimation lazyLayoutItemAnimation = this.this$0;
            Function1<Animatable<Float, androidx.compose.animation.core.k>, Unit> function1 = new Function1<Animatable<Float, androidx.compose.animation.core.k>, Unit>() { // from class: androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimation$animateAppearance$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Animatable<Float, androidx.compose.animation.core.k> animatable3) {
                    invoke2(animatable3);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animatable<Float, androidx.compose.animation.core.k> animatable3) {
                    graphicsLayer.J(animatable3.k().floatValue());
                    lazyLayoutItemAnimation.f2604c.invoke();
                }
            };
            this.label = 2;
            if (Animatable.f(animatable2, fC2, c0Var, null, function1, this, 4, null) == objE) {
                return objE;
            }
            this.this$0.z(false);
            return Unit.f68710a;
        } catch (Throwable th2) {
            this.this$0.z(false);
            throw th2;
        }
    }
}
