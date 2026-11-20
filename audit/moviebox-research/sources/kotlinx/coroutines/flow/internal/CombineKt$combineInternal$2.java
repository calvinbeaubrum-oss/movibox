package kotlinx.coroutines.flow.internal;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.u2;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", l = {51, 73, 76}, m = "invokeSuspend")
public final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<T[]> $arrayFactory;
    final /* synthetic */ kotlinx.coroutines.flow.a<T>[] $flows;
    final /* synthetic */ kotlinx.coroutines.flow.b<R> $this_combineInternal;
    final /* synthetic */ Function3<kotlinx.coroutines.flow.b<? super R>, T[], Continuation<? super Unit>, Object> $transform;
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1", f = "Combine.kt", l = {28}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ kotlinx.coroutines.flow.a<T>[] $flows;
        final /* synthetic */ int $i;
        final /* synthetic */ AtomicInteger $nonClosed;
        final /* synthetic */ kotlinx.coroutines.channels.a<IndexedValue<Object>> $resultChannel;
        int label;

        /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class C07431<T> implements kotlinx.coroutines.flow.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ kotlinx.coroutines.channels.a<IndexedValue<Object>> f69400a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ int f69401b;

            public C07431(kotlinx.coroutines.channels.a<IndexedValue<Object>> aVar, int i11) {
                this.f69400a = aVar;
                this.f69401b = i11;
            }

            /* JADX WARN: Code duplicated, block: B:7:0x0013  */
            @Override // kotlinx.coroutines.flow.b
            public final Object emit(T t11, Continuation<? super Unit> continuation) throws Throwable {
                CombineKt$combineInternal$2$1$1$emit$1 combineKt$combineInternal$2$1$1$emit$1;
                if (continuation instanceof CombineKt$combineInternal$2$1$1$emit$1) {
                    combineKt$combineInternal$2$1$1$emit$1 = (CombineKt$combineInternal$2$1$1$emit$1) continuation;
                    int i11 = combineKt$combineInternal$2$1$1$emit$1.label;
                    if ((i11 & Integer.MIN_VALUE) != 0) {
                        combineKt$combineInternal$2$1$1$emit$1.label = i11 - Integer.MIN_VALUE;
                    } else {
                        combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                    }
                } else {
                    combineKt$combineInternal$2$1$1$emit$1 = new CombineKt$combineInternal$2$1$1$emit$1(this, continuation);
                }
                Object obj = combineKt$combineInternal$2$1$1$emit$1.result;
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i12 = combineKt$combineInternal$2$1$1$emit$1.label;
                if (i12 != 0) {
                    if (i12 == 1) {
                        ResultKt.b(obj);
                    } else {
                        if (i12 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.b(obj);
                    }
                    return Unit.f68710a;
                }
                ResultKt.b(obj);
                kotlinx.coroutines.channels.a<IndexedValue<Object>> aVar = this.f69400a;
                IndexedValue<Object> indexedValue = new IndexedValue<>(this.f69401b, t11);
                combineKt$combineInternal$2$1$1$emit$1.label = 1;
                if (aVar.q(indexedValue, combineKt$combineInternal$2$1$1$emit$1) == objE) {
                    return objE;
                }
                combineKt$combineInternal$2$1$1$emit$1.label = 2;
                if (u2.a(combineKt$combineInternal$2$1$1$emit$1) == objE) {
                    return objE;
                }
                return Unit.f68710a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(kotlinx.coroutines.flow.a<? extends T>[] aVarArr, int i11, AtomicInteger atomicInteger, kotlinx.coroutines.channels.a<IndexedValue<Object>> aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$flows = aVarArr;
            this.$i = i11;
            this.$nonClosed = atomicInteger;
            this.$resultChannel = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$flows, this.$i, this.$nonClosed, this.$resultChannel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            try {
                if (i11 == 0) {
                    ResultKt.b(obj);
                    kotlinx.coroutines.flow.a[] aVarArr = this.$flows;
                    int i12 = this.$i;
                    kotlinx.coroutines.flow.a aVar = aVarArr[i12];
                    C07431 c07431 = new C07431(this.$resultChannel, i12);
                    this.label = 1;
                    if (aVar.a(c07431, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                if (this.$nonClosed.decrementAndGet() == 0) {
                    kotlinx.coroutines.channels.p.a.a(this.$resultChannel, null, 1, null);
                }
                return Unit.f68710a;
            } catch (Throwable th2) {
                if (this.$nonClosed.decrementAndGet() == 0) {
                    kotlinx.coroutines.channels.p.a.a(this.$resultChannel, null, 1, null);
                }
                throw th2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public CombineKt$combineInternal$2(kotlinx.coroutines.flow.a<? extends T>[] aVarArr, Function0<T[]> function0, Function3<? super kotlinx.coroutines.flow.b<? super R>, ? super T[], ? super Continuation<? super Unit>, ? extends Object> function3, kotlinx.coroutines.flow.b<? super R> bVar, Continuation<? super CombineKt$combineInternal$2> continuation) {
        super(2, continuation);
        this.$flows = aVarArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
        this.$this_combineInternal = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$flows, this.$arrayFactory, this.$transform, this.$this_combineInternal, continuation);
        combineKt$combineInternal$2.L$0 = obj;
        return combineKt$combineInternal$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:22:0x00d7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:23:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:26:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:28:0x00e5 A[LOOP:0: B:28:0x00e5->B:51:?, LOOP_START, PHI: r6 r10
  0x00e5: PHI (r6v6 int) = (r6v5 int), (r6v7 int) binds: [B:25:0x00e0, B:51:?] A[DONT_GENERATE, DONT_INLINE]
  0x00e5: PHI (r10v8 kotlin.collections.IndexedValue) = (r10v7 kotlin.collections.IndexedValue), (r10v21 kotlin.collections.IndexedValue) binds: [B:25:0x00e0, B:51:?] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:30:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:33:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:36:0x010c  */
    /* JADX WARN: Code duplicated, block: B:38:0x0116  */
    /* JADX WARN: Code duplicated, block: B:40:0x012c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:41:0x012d  */
    /* JADX WARN: Code duplicated, block: B:46:0x015f  */
    /* JADX WARN: Code duplicated, block: B:49:0x010a A[EDGE_INSN: B:49:0x010a->B:35:0x010a BREAK  A[LOOP:0: B:28:0x00e5->B:51:?], SYNTHETIC] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x012d -> B:20:0x00c2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
