package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.v1;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2", f = "ContentInViewNode.kt", l = {196}, m = "invokeSuspend")
public final class ContentInViewNode$launchAnimation$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ UpdatableAnimationState $animationState;
    final /* synthetic */ d $bringIntoViewSpec;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ ContentInViewNode this$0;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ContentInViewNode$launchAnimation$2$1", f = "ContentInViewNode.kt", l = {201}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
        final /* synthetic */ q1 $animationJob;
        final /* synthetic */ UpdatableAnimationState $animationState;
        final /* synthetic */ d $bringIntoViewSpec;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ContentInViewNode this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UpdatableAnimationState updatableAnimationState, ContentInViewNode contentInViewNode, d dVar, q1 q1Var, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$animationState = updatableAnimationState;
            this.this$0 = contentInViewNode;
            this.$bringIntoViewSpec = dVar;
            this.$animationJob = q1Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, this.$animationJob, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h hVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(hVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                final h hVar = (h) this.L$0;
                this.$animationState.j(this.this$0.R1(this.$bringIntoViewSpec));
                final UpdatableAnimationState updatableAnimationState = this.$animationState;
                final ContentInViewNode contentInViewNode = this.this$0;
                final q1 q1Var = this.$animationJob;
                Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Float f11) {
                        invoke(f11.floatValue());
                        return Unit.f68710a;
                    }

                    public final void invoke(float f11) {
                        float f12 = contentInViewNode.f2280q ? 1.0f : -1.0f;
                        ScrollingLogic scrollingLogic = contentInViewNode.f2279p;
                        float fA = f12 * scrollingLogic.A(scrollingLogic.u(hVar.b(scrollingLogic.u(scrollingLogic.B(f12 * f11)), androidx.compose.ui.input.nestedscroll.e.f4627a.b())));
                        if (Math.abs(fA) < Math.abs(f11)) {
                            v1.f(q1Var, "Scroll animation cancelled because scroll was not consumed (" + fA + " < " + f11 + ')', null, 2, null);
                        }
                    }
                };
                final ContentInViewNode contentInViewNode2 = this.this$0;
                final UpdatableAnimationState updatableAnimationState2 = this.$animationState;
                final d dVar = this.$bringIntoViewSpec;
                Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.compose.foundation.gestures.ContentInViewNode.launchAnimation.2.1.2
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
                        y1.i iVarW1;
                        y1.i iVarInvoke;
                        BringIntoViewRequestPriorityQueue bringIntoViewRequestPriorityQueue = contentInViewNode2.f2283t;
                        ContentInViewNode contentInViewNode3 = contentInViewNode2;
                        while (bringIntoViewRequestPriorityQueue.f2272a.u() && ((iVarInvoke = ((ContentInViewNode.a) bringIntoViewRequestPriorityQueue.f2272a.v()).b().invoke()) == null || ContentInViewNode.Z1(contentInViewNode3, iVarInvoke, 0L, 1, null))) {
                            ((ContentInViewNode.a) bringIntoViewRequestPriorityQueue.f2272a.z(bringIntoViewRequestPriorityQueue.f2272a.r() - 1)).a().resumeWith(Result.m163constructorimpl(Unit.f68710a));
                        }
                        if (contentInViewNode2.f2286w && (iVarW1 = contentInViewNode2.W1()) != null && ContentInViewNode.Z1(contentInViewNode2, iVarW1, 0L, 1, null)) {
                            contentInViewNode2.f2286w = false;
                        }
                        updatableAnimationState2.j(contentInViewNode2.R1(dVar));
                    }
                };
                this.label = 1;
                if (updatableAnimationState.h(function1, function0, this) == objE) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContentInViewNode$launchAnimation$2(ContentInViewNode contentInViewNode, UpdatableAnimationState updatableAnimationState, d dVar, Continuation<? super ContentInViewNode$launchAnimation$2> continuation) {
        super(2, continuation);
        this.this$0 = contentInViewNode;
        this.$animationState = updatableAnimationState;
        this.$bringIntoViewSpec = dVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ContentInViewNode$launchAnimation$2 contentInViewNode$launchAnimation$2 = new ContentInViewNode$launchAnimation$2(this.this$0, this.$animationState, this.$bringIntoViewSpec, continuation);
        contentInViewNode$launchAnimation$2.L$0 = obj;
        return contentInViewNode$launchAnimation$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((ContentInViewNode$launchAnimation$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        try {
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    q1 q1VarL = t1.l(((k0) this.L$0).getCoroutineContext());
                    this.this$0.f2288y = true;
                    ScrollingLogic scrollingLogic = this.this$0.f2279p;
                    MutatePriority mutatePriority = MutatePriority.Default;
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$animationState, this.this$0, this.$bringIntoViewSpec, q1VarL, null);
                    this.label = 1;
                    if (scrollingLogic.v(mutatePriority, anonymousClass1, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                this.this$0.f2283t.d();
                this.this$0.f2288y = false;
                this.this$0.f2283t.b(null);
                this.this$0.f2286w = false;
                return Unit.f68710a;
            } catch (CancellationException e11) {
                throw e11;
            }
        } catch (Throwable th2) {
            this.this$0.f2288y = false;
            this.this$0.f2283t.b(null);
            this.this$0.f2286w = false;
            throw th2;
        }
    }
}
