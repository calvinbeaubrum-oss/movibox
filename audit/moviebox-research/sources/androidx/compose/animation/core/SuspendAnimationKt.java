package androidx.compose.animation.core;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
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
public final class SuspendAnimationKt {
    public static final Object b(float f11, float f12, float f13, g<Float> gVar, Function2<? super Float, ? super Float, Unit> function2, Continuation<? super Unit> continuation) {
        Object objD = d(VectorConvertersKt.b(FloatCompanionObject.f68904a), Boxing.c(f11), Boxing.c(f12), Boxing.c(f13), gVar, function2, continuation);
        return objD == kotlin.coroutines.intrinsics.a.e() ? objD : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x012b  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Type inference failed for: r13v1, types: [T, androidx.compose.animation.core.f] */
    public static final <T, V extends o> Object c(final i<T, V> iVar, final c<T, V> cVar, long j11, final Function1<? super f<T, V>, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$4;
        Ref.ObjectRef objectRef;
        Function1<? super f<T, V>, Unit> function2;
        i<T, V> iVar2;
        f fVar;
        f fVar2;
        Function1<Long, Unit> function3;
        final i<T, V> iVar3 = iVar;
        c<T, V> cVar2 = cVar;
        if (continuation instanceof SuspendAnimationKt$animate$4) {
            suspendAnimationKt$animate$4 = (SuspendAnimationKt$animate$4) continuation;
            int i11 = suspendAnimationKt$animate$4.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                suspendAnimationKt$animate$4.label = i11 - Integer.MIN_VALUE;
            } else {
                suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuation);
            }
        } else {
            suspendAnimationKt$animate$4 = new SuspendAnimationKt$animate$4(continuation);
        }
        SuspendAnimationKt$animate$4 suspendAnimationKt$animate$5 = suspendAnimationKt$animate$4;
        Object obj = suspendAnimationKt$animate$5.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = suspendAnimationKt$animate$5.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            final T tF = cVar2.f(0L);
            final o oVarB = cVar2.b(0L);
            final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
            try {
                if (j11 == Long.MIN_VALUE) {
                    final float fN = n(suspendAnimationKt$animate$5.getContext());
                    Function1<Long, Unit> function4 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/internal/Ref$ObjectRef<Landroidx/compose/animation/core/f<TT;TV;>;>;TT;Landroidx/compose/animation/core/c<TT;TV;>;TV;Landroidx/compose/animation/core/i<TT;TV;>;FLkotlin/jvm/functions/Function1<-Landroidx/compose/animation/core/f<TT;TV;>;Lkotlin/Unit;>;)V */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                            invoke(l11.longValue());
                            return Unit.f68710a;
                        }

                        /* JADX WARN: Type inference failed for: r12v0, types: [T, androidx.compose.animation.core.f] */
                        public final void invoke(long j12) {
                            Ref.ObjectRef<f<T, V>> objectRef3 = objectRef2;
                            T t11 = tF;
                            s0 s0VarE = cVar.e();
                            o oVar = oVarB;
                            Object objG = cVar.g();
                            final i<T, V> iVar4 = iVar;
                            ?? fVar3 = new f(t11, s0VarE, oVar, j12, objG, j12, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$6.1
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
                                    iVar4.k(false);
                                }
                            });
                            SuspendAnimationKt.m(fVar3, j12, fN, cVar, iVar, function1);
                            objectRef3.element = fVar3;
                        }
                    };
                    suspendAnimationKt$animate$5.L$0 = iVar3;
                    suspendAnimationKt$animate$5.L$1 = cVar2;
                    function2 = function1;
                    suspendAnimationKt$animate$5.L$2 = function2;
                    suspendAnimationKt$animate$5.L$3 = objectRef2;
                    suspendAnimationKt$animate$5.label = 1;
                    if (k(cVar2, function4, suspendAnimationKt$animate$5) == objE) {
                        return objE;
                    }
                } else {
                    function2 = function1;
                    try {
                        ?? r13 = (T) new f(tF, cVar.e(), oVarB, j11, cVar.g(), j11, true, new Function0<Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$7
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
                                iVar3.k(false);
                            }
                        });
                        objectRef2 = objectRef2;
                        m(r13, j11, n(suspendAnimationKt$animate$5.getContext()), cVar, iVar, function1);
                        objectRef2.element = r13;
                    } catch (CancellationException e11) {
                        e = e11;
                        objectRef2 = objectRef2;
                        objectRef = objectRef2;
                        fVar = (f) objectRef.element;
                        if (fVar != null) {
                            fVar.k(false);
                        }
                        fVar2 = (f) objectRef.element;
                        if (fVar2 != null && fVar2.c() == iVar3.b()) {
                            iVar3.k(false);
                        }
                        throw e;
                    }
                }
                iVar2 = iVar3;
                objectRef = objectRef2;
            } catch (CancellationException e12) {
                e = e12;
            }
        } else {
            if (i12 != 1 && i12 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            objectRef = (Ref.ObjectRef) suspendAnimationKt$animate$5.L$3;
            Function1<? super f<T, V>, Unit> function5 = (Function1) suspendAnimationKt$animate$5.L$2;
            c<T, V> cVar3 = (c) suspendAnimationKt$animate$5.L$1;
            iVar2 = (i) suspendAnimationKt$animate$5.L$0;
            try {
                ResultKt.b(obj);
                function2 = function5;
                cVar2 = cVar3;
            } catch (CancellationException e13) {
                e = e13;
                iVar3 = iVar2;
                fVar = (f) objectRef.element;
                if (fVar != null) {
                    fVar.k(false);
                }
                fVar2 = (f) objectRef.element;
                if (fVar2 != null) {
                    iVar3.k(false);
                }
                throw e;
            }
        }
        do {
            T t11 = objectRef.element;
            Intrinsics.d(t11);
            if (!((f) t11).h()) {
                return Unit.f68710a;
            }
            final float fN2 = n(suspendAnimationKt$animate$5.getContext());
            final Ref.ObjectRef objectRef3 = objectRef;
            final c<T, V> cVar4 = cVar2;
            final i<T, V> iVar4 = iVar2;
            final Function1<? super f<T, V>, Unit> function6 = function2;
            function3 = new Function1<Long, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l11) {
                    invoke(l11.longValue());
                    return Unit.f68710a;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final void invoke(long j12) {
                    T t12 = objectRef3.element;
                    Intrinsics.d(t12);
                    SuspendAnimationKt.m((f) t12, j12, fN2, cVar4, iVar4, function6);
                }
            };
            suspendAnimationKt$animate$5.L$0 = iVar2;
            suspendAnimationKt$animate$5.L$1 = cVar2;
            suspendAnimationKt$animate$5.L$2 = function2;
            suspendAnimationKt$animate$5.L$3 = objectRef;
            suspendAnimationKt$animate$5.label = 2;
        } while (k(cVar2, function3, suspendAnimationKt$animate$5) != objE);
        return objE;
    }

    public static final <T, V extends o> Object d(final s0<T, V> s0Var, T t11, T t12, T t13, g<T> gVar, final Function2<? super T, ? super T, Unit> function2, Continuation<? super Unit> continuation) {
        V vG;
        if (t13 == null || (vG = s0Var.a().invoke(t13)) == null) {
            vG = p.g(s0Var.a().invoke(t11));
        }
        Object objF = f(new i(s0Var, t11, vG, 0L, 0L, false, 56, null), new p0(gVar, s0Var, t11, t12, vG), 0L, new Function1<f<T, V>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke((f) obj);
                return Unit.f68710a;
            }

            public final void invoke(f<T, V> fVar) {
                function2.invoke(fVar.e(), s0Var.b().invoke(fVar.g()));
            }
        }, continuation, 2, null);
        return objF == kotlin.coroutines.intrinsics.a.e() ? objF : Unit.f68710a;
    }

    public static /* synthetic */ Object e(float f11, float f12, float f13, g gVar, Function2 function2, Continuation continuation, int i11, Object obj) {
        float f14 = (i11 & 4) != 0 ? 0.0f : f13;
        if ((i11 & 8) != 0) {
            gVar = h.d(0.0f, 0.0f, null, 7, null);
        }
        return b(f11, f12, f14, gVar, function2, continuation);
    }

    public static /* synthetic */ Object f(i iVar, c cVar, long j11, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            j11 = Long.MIN_VALUE;
        }
        long j12 = j11;
        if ((i11 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((f) obj2);
                    return Unit.f68710a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return c(iVar, cVar, j12, function1, continuation);
    }

    public static final <T, V extends o> Object g(i<T, V> iVar, w<T> wVar, boolean z11, Function1<? super f<T, V>, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        Object objC = c(iVar, new v(wVar, iVar.e(), iVar.getValue(), iVar.g()), z11 ? iVar.b() : Long.MIN_VALUE, function1, continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    public static /* synthetic */ Object h(i iVar, w wVar, boolean z11, Function1 function1, Continuation continuation, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        if ((i11 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((f) obj2);
                    return Unit.f68710a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return g(iVar, wVar, z11, function1, continuation);
    }

    public static final <T, V extends o> Object i(i<T, V> iVar, T t11, g<T> gVar, boolean z11, Function1<? super f<T, V>, Unit> function1, Continuation<? super Unit> continuation) throws Throwable {
        Object objC = c(iVar, new p0(gVar, iVar.e(), iVar.getValue(), t11, iVar.g()), z11 ? iVar.b() : Long.MIN_VALUE, function1, continuation);
        return objC == kotlin.coroutines.intrinsics.a.e() ? objC : Unit.f68710a;
    }

    public static /* synthetic */ Object j(i iVar, Object obj, g gVar, boolean z11, Function1 function1, Continuation continuation, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            gVar = h.d(0.0f, 0.0f, null, 7, null);
        }
        g gVar2 = gVar;
        boolean z12 = (i11 & 4) != 0 ? false : z11;
        if ((i11 & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    invoke((f) obj3);
                    return Unit.f68710a;
                }

                public final void invoke(f fVar) {
                }
            };
        }
        return i(iVar, obj, gVar2, z12, function1, continuation);
    }

    public static final <R, T, V extends o> Object k(c<T, V> cVar, final Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation) {
        return cVar.a() ? InfiniteAnimationPolicyKt.a(function1, continuation) : androidx.compose.runtime.v0.b(new Function1<Long, R>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            public final R invoke(long j11) {
                return function1.invoke(Long.valueOf(j11));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Long l11) {
                return invoke(l11.longValue());
            }
        }, continuation);
    }

    public static final <T, V extends o> void l(f<T, V> fVar, long j11, long j12, c<T, V> cVar, i<T, V> iVar, Function1<? super f<T, V>, Unit> function1) {
        fVar.j(j11);
        fVar.l(cVar.f(j12));
        fVar.m(cVar.b(j12));
        if (cVar.c(j12)) {
            fVar.i(fVar.c());
            fVar.k(false);
        }
        o(fVar, iVar);
        function1.invoke(fVar);
    }

    public static final <T, V extends o> void m(f<T, V> fVar, long j11, float f11, c<T, V> cVar, i<T, V> iVar, Function1<? super f<T, V>, Unit> function1) {
        l(fVar, j11, f11 == 0.0f ? cVar.d() : (long) ((j11 - fVar.d()) / f11), cVar, iVar, function1);
    }

    public static final float n(CoroutineContext coroutineContext) {
        androidx.compose.ui.j jVar = (androidx.compose.ui.j) coroutineContext.get(androidx.compose.ui.j.Y7);
        float fD = jVar != null ? jVar.d() : 1.0f;
        if (!(fD >= 0.0f)) {
            k0.b("negative scale factor");
        }
        return fD;
    }

    public static final <T, V extends o> void o(f<T, V> fVar, i<T, V> iVar) {
        iVar.l(fVar.e());
        p.f(iVar.g(), fVar.g());
        iVar.i(fVar.b());
        iVar.j(fVar.c());
        iVar.k(fVar.h());
    }
}
