package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Add missing generic type declarations: [T, V] */
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
@DebugMetadata(c = "androidx.compose.animation.core.Animatable$runAnimation$2", f = "Animatable.kt", l = {312}, m = "invokeSuspend")
public final class Animatable$runAnimation$2<T, V> extends SuspendLambda implements Function1<Continuation<? super e<T, V>>, Object> {
    final /* synthetic */ c<T, V> $animation;
    final /* synthetic */ Function1<Animatable<T, V>, Unit> $block;
    final /* synthetic */ T $initialVelocity;
    final /* synthetic */ long $startTime;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Animatable<T, V> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Animatable$runAnimation$2(Animatable<T, V> animatable, T t11, c<T, V> cVar, long j11, Function1<? super Animatable<T, V>, Unit> function1, Continuation<? super Animatable$runAnimation$2> continuation) {
        super(1, continuation);
        this.this$0 = animatable;
        this.$initialVelocity = t11;
        this.$animation = cVar;
        this.$startTime = j11;
        this.$block = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new Animatable$runAnimation$2(this.this$0, this.$initialVelocity, this.$animation, this.$startTime, this.$block, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super e<T, V>> continuation) {
        return ((Animatable$runAnimation$2) create(continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        i iVar;
        Ref.BooleanRef booleanRef;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            if (i11 == 0) {
                ResultKt.b(obj);
                this.this$0.i().m((o) this.this$0.j().a().invoke(this.$initialVelocity));
                this.this$0.q(this.$animation.g());
                this.this$0.p(true);
                final i iVarH = j.h(this.this$0.i(), null, null, 0L, Long.MIN_VALUE, false, 23, null);
                final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                c<T, V> cVar = this.$animation;
                long j11 = this.$startTime;
                final Animatable<T, V> animatable = this.this$0;
                final Function1<Animatable<T, V>, Unit> function1 = this.$block;
                Function1<f<T, V>, Unit> function2 = new Function1<f<T, V>, Unit>() { // from class: androidx.compose.animation.core.Animatable$runAnimation$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj2) {
                        invoke((f) obj2);
                        return Unit.f68710a;
                    }

                    /* JADX WARN: Multi-variable type inference failed */
                    public final void invoke(f<T, V> fVar) {
                        SuspendAnimationKt.o(fVar, animatable.i());
                        Object objG = animatable.g(fVar.e());
                        if (Intrinsics.b(objG, fVar.e())) {
                            Function1<Animatable<T, V>, Unit> function3 = function1;
                            if (function3 != null) {
                                function3.invoke(animatable);
                                return;
                            }
                            return;
                        }
                        animatable.i().l(objG);
                        iVarH.l((T) objG);
                        Function1<Animatable<T, V>, Unit> function4 = function1;
                        if (function4 != null) {
                            function4.invoke(animatable);
                        }
                        fVar.a();
                        booleanRef2.element = true;
                    }
                };
                this.L$0 = iVarH;
                this.L$1 = booleanRef2;
                this.label = 1;
                if (SuspendAnimationKt.c(iVarH, cVar, j11, function2, this) == objE) {
                    return objE;
                }
                iVar = iVarH;
                booleanRef = booleanRef2;
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                booleanRef = (Ref.BooleanRef) this.L$1;
                iVar = (i) this.L$0;
                ResultKt.b(obj);
            }
            AnimationEndReason animationEndReason = booleanRef.element ? AnimationEndReason.BoundReached : AnimationEndReason.Finished;
            this.this$0.h();
            return new e(iVar, animationEndReason);
        } catch (CancellationException e11) {
            this.this$0.h();
            throw e11;
        }
    }
}
