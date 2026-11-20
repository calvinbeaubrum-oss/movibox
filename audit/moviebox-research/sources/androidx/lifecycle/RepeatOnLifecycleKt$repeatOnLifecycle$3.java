package androidx.lifecycle;

import com.transsion.gslb.Worker;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.q1;

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
@DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
public final class RepeatOnLifecycleKt$repeatOnLifecycle$3 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ Lifecycle.State $state;
    final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.k0 $$this$coroutineScope;
        final /* synthetic */ Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ Lifecycle.State $state;
        final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, kotlinx.coroutines.k0 k0Var, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$$this$coroutineScope = k0Var;
            this.$block = function2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:28:0x00b7  */
        /* JADX WARN: Code duplicated, block: B:31:0x00c1  */
        /* JADX WARN: Code duplicated, block: B:36:0x00cf  */
        /* JADX WARN: Code duplicated, block: B:39:0x00d9  */
        /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1, java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref.ObjectRef objectRef;
            Ref.ObjectRef objectRef2;
            q1 q1Var;
            r rVar;
            q1 q1Var2;
            r rVar2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                objectRef2 = (Ref.ObjectRef) this.L$1;
                objectRef = (Ref.ObjectRef) this.L$0;
                try {
                    ResultKt.b(obj);
                    q1Var2 = (q1) objectRef.element;
                    if (q1Var2 != null) {
                        q1.a.b(q1Var2, null, 1, null);
                    }
                    rVar2 = (r) objectRef2.element;
                    if (rVar2 != null) {
                        this.$this_repeatOnLifecycle.d(rVar2);
                    }
                    return Unit.f68710a;
                } catch (Throwable th2) {
                    th = th2;
                    q1Var = (q1) objectRef.element;
                    if (q1Var != null) {
                        q1.a.b(q1Var, null, 1, null);
                    }
                    rVar = (r) objectRef2.element;
                    if (rVar != null) {
                        this.$this_repeatOnLifecycle.d(rVar);
                    }
                    throw th;
                }
            }
            ResultKt.b(obj);
            if (this.$this_repeatOnLifecycle.b() == Lifecycle.State.DESTROYED) {
                return Unit.f68710a;
            }
            final Ref.ObjectRef objectRef3 = new Ref.ObjectRef();
            Ref.ObjectRef objectRef4 = new Ref.ObjectRef();
            try {
                Lifecycle.State state = this.$state;
                Lifecycle lifecycle = this.$this_repeatOnLifecycle;
                final kotlinx.coroutines.k0 k0Var = this.$$this$coroutineScope;
                final Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> function2 = this.$block;
                this.L$0 = objectRef3;
                this.L$1 = objectRef4;
                this.L$2 = state;
                this.L$3 = lifecycle;
                this.L$4 = k0Var;
                this.L$5 = function2;
                this.label = 1;
                final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(this), 1);
                cancellableContinuationImpl.initCancellability();
                Lifecycle.Event.a aVar = Lifecycle.Event.Companion;
                final Lifecycle.Event eventD = aVar.d(state);
                final Lifecycle.Event eventA = aVar.a(state);
                final kotlinx.coroutines.sync.a aVarB = kotlinx.coroutines.sync.b.b(false, 1, null);
                ?? r11 = new r() { // from class: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1

                    /* JADX INFO: renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1, reason: invalid class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1", f = "RepeatOnLifecycle.kt", l = {171, Worker.WHAT_QUIT}, m = "invokeSuspend")
                    @SourceDebugExtension
                    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                        final /* synthetic */ Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> $block;
                        final /* synthetic */ kotlinx.coroutines.sync.a $mutex;
                        Object L$0;
                        Object L$1;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        public AnonymousClass1(kotlinx.coroutines.sync.a aVar, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super AnonymousClass1> continuation) {
                            super(2, continuation);
                            this.$mutex = aVar;
                            this.$block = function2;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new AnonymousClass1(this.$mutex, this.$block, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            kotlinx.coroutines.sync.a aVar;
                            Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> function2;
                            kotlinx.coroutines.sync.a aVar2;
                            Throwable th2;
                            Object objE = kotlin.coroutines.intrinsics.a.e();
                            int i11 = this.label;
                            try {
                                if (i11 == 0) {
                                    ResultKt.b(obj);
                                    aVar = this.$mutex;
                                    function2 = this.$block;
                                    this.L$0 = aVar;
                                    this.L$1 = function2;
                                    this.label = 1;
                                    if (aVar.a(null, this) == objE) {
                                        return objE;
                                    }
                                } else {
                                    if (i11 != 1) {
                                        if (i11 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        aVar2 = (kotlinx.coroutines.sync.a) this.L$0;
                                        try {
                                            ResultKt.b(obj);
                                            Unit unit = Unit.f68710a;
                                            aVar2.unlock(null);
                                            return Unit.f68710a;
                                        } catch (Throwable th3) {
                                            th2 = th3;
                                            aVar2.unlock(null);
                                            throw th2;
                                        }
                                    }
                                    function2 = (Function2) this.L$1;
                                    kotlinx.coroutines.sync.a aVar3 = (kotlinx.coroutines.sync.a) this.L$0;
                                    ResultKt.b(obj);
                                    aVar = aVar3;
                                }
                                RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1 = new RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1(function2, null);
                                this.L$0 = aVar;
                                this.L$1 = null;
                                this.label = 2;
                                if (kotlinx.coroutines.l0.e(repeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1$1$1$1, this) == objE) {
                                    return objE;
                                }
                                aVar2 = aVar;
                                Unit unit2 = Unit.f68710a;
                                aVar2.unlock(null);
                                return Unit.f68710a;
                            } catch (Throwable th4) {
                                aVar2 = aVar;
                                th2 = th4;
                                aVar2.unlock(null);
                                throw th2;
                            }
                        }
                    }

                    /* JADX WARN: Type inference failed for: r9v5, types: [T, kotlinx.coroutines.q1] */
                    @Override // androidx.lifecycle.r
                    public final void onStateChanged(u uVar, Lifecycle.Event event) {
                        Intrinsics.g(uVar, "<anonymous parameter 0>");
                        Intrinsics.g(event, "event");
                        if (event == eventD) {
                            objectRef3.element = kotlinx.coroutines.j.d(k0Var, null, null, new AnonymousClass1(aVarB, function2, null), 3, null);
                            return;
                        }
                        if (event == eventA) {
                            q1 q1Var3 = objectRef3.element;
                            if (q1Var3 != null) {
                                q1.a.b(q1Var3, null, 1, null);
                            }
                            objectRef3.element = null;
                        }
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            kotlinx.coroutines.n<Unit> nVar = cancellableContinuationImpl;
                            Result.Companion companion = Result.Companion;
                            nVar.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                        }
                    }
                };
                objectRef4.element = r11;
                Intrinsics.e(r11, "null cannot be cast to non-null type androidx.lifecycle.LifecycleEventObserver");
                lifecycle.a((r) r11);
                Object result = cancellableContinuationImpl.getResult();
                if (result == kotlin.coroutines.intrinsics.a.e()) {
                    DebugProbesKt.c(this);
                }
                if (result == objE) {
                    return objE;
                }
                objectRef = objectRef3;
                objectRef2 = objectRef4;
                q1Var2 = (q1) objectRef.element;
                if (q1Var2 != null) {
                    q1.a.b(q1Var2, null, 1, null);
                }
                rVar2 = (r) objectRef2.element;
                if (rVar2 != null) {
                    this.$this_repeatOnLifecycle.d(rVar2);
                }
                return Unit.f68710a;
            } catch (Throwable th3) {
                th = th3;
                objectRef = objectRef3;
                objectRef2 = objectRef4;
                q1Var = (q1) objectRef.element;
                if (q1Var != null) {
                    q1.a.b(q1Var, null, 1, null);
                }
                rVar = (r) objectRef2.element;
                if (rVar != null) {
                    this.$this_repeatOnLifecycle.d(rVar);
                }
                throw th;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RepeatOnLifecycleKt$repeatOnLifecycle$3(Lifecycle lifecycle, Lifecycle.State state, Function2<? super kotlinx.coroutines.k0, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super RepeatOnLifecycleKt$repeatOnLifecycle$3> continuation) {
        super(2, continuation);
        this.$this_repeatOnLifecycle = lifecycle;
        this.$state = state;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RepeatOnLifecycleKt$repeatOnLifecycle$3 repeatOnLifecycleKt$repeatOnLifecycle$3 = new RepeatOnLifecycleKt$repeatOnLifecycle$3(this.$this_repeatOnLifecycle, this.$state, this.$block, continuation);
        repeatOnLifecycleKt$repeatOnLifecycle$3.L$0 = obj;
        return repeatOnLifecycleKt$repeatOnLifecycle$3;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RepeatOnLifecycleKt$repeatOnLifecycle$3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.k0 k0Var = (kotlinx.coroutines.k0) this.L$0;
            a2 a2VarQ = kotlinx.coroutines.w0.c().q();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, k0Var, this.$block, null);
            this.label = 1;
            if (kotlinx.coroutines.h.g(a2VarQ, anonymousClass1, this) == objE) {
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
