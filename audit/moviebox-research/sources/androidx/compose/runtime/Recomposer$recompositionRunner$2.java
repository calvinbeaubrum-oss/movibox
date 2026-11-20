package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
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
@DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2", f = "Recomposer.kt", l = {1054}, m = "invokeSuspend")
@SourceDebugExtension
public final class Recomposer$recompositionRunner$2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<kotlinx.coroutines.k0, u0, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ u0 $parentFrameClock;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ Recomposer this$0;

    /* JADX INFO: renamed from: androidx.compose.runtime.Recomposer$recompositionRunner$2$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "androidx.compose.runtime.Recomposer$recompositionRunner$2$3", f = "Recomposer.kt", l = {1055}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function3<kotlinx.coroutines.k0, u0, Continuation<? super Unit>, Object> $block;
        final /* synthetic */ u0 $parentFrameClock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Function3<? super kotlinx.coroutines.k0, ? super u0, ? super Continuation<? super Unit>, ? extends Object> function3, u0 u0Var, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$block = function3;
            this.$parentFrameClock = u0Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, continuation);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.k0 k0Var = (kotlinx.coroutines.k0) this.L$0;
                Function3<kotlinx.coroutines.k0, u0, Continuation<? super Unit>, Object> function3 = this.$block;
                u0 u0Var = this.$parentFrameClock;
                this.label = 1;
                if (function3.invoke(k0Var, u0Var, this) == objE) {
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
    /* JADX WARN: Multi-variable type inference failed */
    public Recomposer$recompositionRunner$2(Recomposer recomposer, Function3<? super kotlinx.coroutines.k0, ? super u0, ? super Continuation<? super Unit>, ? extends Object> function3, u0 u0Var, Continuation<? super Recomposer$recompositionRunner$2> continuation) {
        super(2, continuation);
        this.this$0 = recomposer;
        this.$block = function3;
        this.$parentFrameClock = u0Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Recomposer$recompositionRunner$2 recomposer$recompositionRunner$2 = new Recomposer$recompositionRunner$2(this.this$0, this.$block, this.$parentFrameClock, continuation);
        recomposer$recompositionRunner$2.L$0 = obj;
        return recomposer$recompositionRunner$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((Recomposer$recompositionRunner$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x009f A[Catch: all -> 0x00a3, TryCatch #2 {all -> 0x00a3, blocks: (B:28:0x0099, B:30:0x009f, B:33:0x00a5), top: B:58:0x0099 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00ce A[Catch: all -> 0x00d2, TryCatch #1 {all -> 0x00d2, blocks: (B:44:0x00c8, B:46:0x00ce, B:49:0x00d4), top: B:56:0x00c8 }] */
    /* JADX WARN: Code duplicated, block: B:56:0x00c8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:58:0x0099 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlinx.coroutines.q1 q1VarL;
        androidx.compose.runtime.snapshots.e eVar;
        Throwable th2;
        List listK0;
        Object obj2;
        Recomposer recomposer;
        Object obj3;
        Recomposer recomposer2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            eVar = (androidx.compose.runtime.snapshots.e) this.L$1;
            q1VarL = (kotlinx.coroutines.q1) this.L$0;
            try {
                ResultKt.b(obj);
                eVar.dispose();
                obj3 = this.this$0.f3315c;
                recomposer2 = this.this$0;
                synchronized (obj3) {
                    try {
                        if (recomposer2.f3316d == q1VarL) {
                            recomposer2.f3316d = null;
                        }
                        recomposer2.c0();
                    } catch (Throwable th3) {
                        throw th3;
                    }
                }
                Recomposer.f3311y.d(this.this$0.f3336x);
                return Unit.f68710a;
            } catch (Throwable th4) {
                th2 = th4;
                eVar.dispose();
                obj2 = this.this$0.f3315c;
                recomposer = this.this$0;
                synchronized (obj2) {
                    try {
                        if (recomposer.f3316d == q1VarL) {
                            recomposer.f3316d = null;
                        }
                        recomposer.c0();
                        Recomposer.f3311y.d(this.this$0.f3336x);
                        throw th2;
                    } catch (Throwable th5) {
                        throw th5;
                    }
                }
            }
        }
        ResultKt.b(obj);
        q1VarL = kotlinx.coroutines.t1.l(((kotlinx.coroutines.k0) this.L$0).getCoroutineContext());
        this.this$0.y0(q1VarL);
        androidx.compose.runtime.snapshots.j.a aVar = androidx.compose.runtime.snapshots.j.f3684e;
        final Recomposer recomposer3 = this.this$0;
        androidx.compose.runtime.snapshots.e eVarI = aVar.i(new Function2<Set<? extends Object>, androidx.compose.runtime.snapshots.j, Unit>() { // from class: androidx.compose.runtime.Recomposer$recompositionRunner$2$unregisterApplyObserver$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, androidx.compose.runtime.snapshots.j jVar) {
                invoke2(set, jVar);
                return Unit.f68710a;
            }

            /* JADX WARN: Code duplicated, block: B:28:0x0085 A[DONT_INVERT] */
            /* JADX WARN: Code duplicated, block: B:29:0x0087 A[Catch: all -> 0x0074, LOOP:0: B:11:0x0038->B:29:0x0087, LOOP_END, TryCatch #0 {all -> 0x0074, blocks: (B:4:0x000d, B:6:0x001f, B:8:0x0028, B:11:0x0038, B:13:0x0048, B:15:0x0054, B:17:0x005d, B:19:0x0066, B:24:0x0076, B:25:0x0079, B:29:0x0087, B:39:0x00b0, B:30:0x008a, B:31:0x0090, B:33:0x0096, B:35:0x009e, B:38:0x00ac), top: B:48:0x000d }] */
            /* JADX WARN: Code duplicated, block: B:51:0x00b0 A[EDGE_INSN: B:51:0x00b0->B:39:0x00b0 BREAK  A[LOOP:0: B:11:0x0038->B:29:0x0087], SYNTHETIC] */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Set<? extends Object> set, androidx.compose.runtime.snapshots.j jVar) {
                kotlinx.coroutines.n nVarC0;
                Object obj4 = recomposer3.f3315c;
                Recomposer recomposer4 = recomposer3;
                synchronized (obj4) {
                    try {
                        if (((Recomposer.State) recomposer4.f3333u.getValue()).compareTo(Recomposer.State.Idle) >= 0) {
                            MutableScatterSet mutableScatterSet = recomposer4.f3320h;
                            if (set instanceof ScatterSetWrapper) {
                                ScatterSet scatterSetA = ((ScatterSetWrapper) set).a();
                                Object[] objArr = scatterSetA.f1898b;
                                long[] jArr = scatterSetA.f1897a;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i12 = 0;
                                    while (true) {
                                        long j11 = jArr[i12];
                                        if ((((~j11) << 7) & j11 & (-9187201950435737472L)) == -9187201950435737472L) {
                                            if (i12 != length) {
                                                break;
                                                break;
                                            }
                                            i12++;
                                        } else {
                                            int i13 = 8 - ((~(i12 - length)) >>> 31);
                                            for (int i14 = 0; i14 < i13; i14++) {
                                                if ((255 & j11) < 128) {
                                                    Object obj5 = objArr[(i12 << 3) + i14];
                                                    if (!(obj5 instanceof androidx.compose.runtime.snapshots.d0) || ((androidx.compose.runtime.snapshots.d0) obj5).m47isReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1))) {
                                                        mutableScatterSet.h(obj5);
                                                    }
                                                }
                                                j11 >>= 8;
                                            }
                                            if (i13 != 8) {
                                                break;
                                            } else if (i12 != length) {
                                                break;
                                            } else {
                                                i12++;
                                            }
                                        }
                                    }
                                }
                            } else {
                                for (Object obj6 : set) {
                                    if (!(obj6 instanceof androidx.compose.runtime.snapshots.d0) || ((androidx.compose.runtime.snapshots.d0) obj6).m47isReadInh_f27i8$runtime_release(androidx.compose.runtime.snapshots.f.a(1))) {
                                        mutableScatterSet.h(obj6);
                                    }
                                }
                            }
                            nVarC0 = recomposer4.c0();
                        } else {
                            nVarC0 = null;
                        }
                    } catch (Throwable th6) {
                        throw th6;
                    }
                }
                if (nVarC0 != null) {
                    Result.Companion companion = Result.Companion;
                    nVarC0.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                }
            }
        });
        Recomposer.f3311y.c(this.this$0.f3336x);
        try {
            Object obj4 = this.this$0.f3315c;
            Recomposer recomposer4 = this.this$0;
            synchronized (obj4) {
                listK0 = recomposer4.k0();
            }
            int size = listK0.size();
            for (int i12 = 0; i12 < size; i12++) {
                ((y) listK0.get(i12)).u();
            }
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$block, this.$parentFrameClock, null);
            this.L$0 = q1VarL;
            this.L$1 = eVarI;
            this.label = 1;
            if (kotlinx.coroutines.l0.e(anonymousClass3, this) == objE) {
                return objE;
            }
            eVar = eVarI;
            eVar.dispose();
            obj3 = this.this$0.f3315c;
            recomposer2 = this.this$0;
            synchronized (obj3) {
                if (recomposer2.f3316d == q1VarL) {
                    recomposer2.f3316d = null;
                }
                recomposer2.c0();
                Recomposer.f3311y.d(this.this$0.f3336x);
                return Unit.f68710a;
            }
        } catch (Throwable th6) {
            eVar = eVarI;
            th2 = th6;
            eVar.dispose();
            obj2 = this.this$0.f3315c;
            recomposer = this.this$0;
            synchronized (obj2) {
                if (recomposer.f3316d == q1VarL) {
                    recomposer.f3316d = null;
                }
                recomposer.c0();
            }
            Recomposer.f3311y.d(this.this$0.f3336x);
            throw th2;
        }
    }
}
