package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.internal.SafeCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
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
@SourceDebugExtension
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> implements a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f69332a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function3 f69333b;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1", f = "Emitters.kt", l = {113, 120, 127}, m = "collect")
    @SourceDebugExtension
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.this.a(null, this);
        }
    }

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(a aVar, Function3 function3) {
        this.f69332a = aVar;
        this.f69333b = function3;
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0086 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:35:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ab A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:56:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.a
    public Object a(b<? super T> bVar, Continuation<? super Unit> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1<T> flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1;
        i1 i1Var;
        Function3 function3;
        SafeCollector safeCollector;
        Throwable th2;
        SafeCollector safeCollector2;
        Object objInvoke;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i11 = anonymousClass1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i11 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = anonymousClass1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            try {
                a aVar = this.f69332a;
                anonymousClass1.L$0 = this;
                anonymousClass1.L$1 = bVar;
                anonymousClass1.label = 1;
                if (aVar.a(bVar, anonymousClass1) == objE) {
                    return objE;
                }
                flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                safeCollector = new SafeCollector(bVar, anonymousClass1.getContext());
                Function3 function4 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f69333b;
                anonymousClass1.L$0 = safeCollector;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                InlineMarker.c(6);
                objInvoke = function4.invoke(safeCollector, null, anonymousClass1);
                InlineMarker.c(7);
                if (objInvoke == objE) {
                    return objE;
                }
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                return Unit.f68710a;
            } catch (Throwable th3) {
                th = th3;
                flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = this;
                i1Var = new i1(th);
                function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f69333b;
                anonymousClass1.L$0 = th;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 2;
                if (FlowKt__EmittersKt.c(i1Var, function3, th, anonymousClass1) == objE) {
                    return objE;
                }
                throw th;
            }
        }
        if (i12 != 1) {
            if (i12 == 2) {
                Throwable th4 = (Throwable) anonymousClass1.L$0;
                ResultKt.b(obj);
                throw th4;
            }
            if (i12 != 3) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            safeCollector2 = (SafeCollector) anonymousClass1.L$0;
            try {
                ResultKt.b(obj);
                safeCollector2.releaseIntercepted();
                return Unit.f68710a;
            } catch (Throwable th5) {
                th2 = th5;
                safeCollector2.releaseIntercepted();
                throw th2;
            }
        }
        bVar = (b) anonymousClass1.L$1;
        flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 = (FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) anonymousClass1.L$0;
        try {
            ResultKt.b(obj);
            safeCollector = new SafeCollector(bVar, anonymousClass1.getContext());
            try {
                Function3 function5 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f69333b;
                anonymousClass1.L$0 = safeCollector;
                anonymousClass1.L$1 = null;
                anonymousClass1.label = 3;
                InlineMarker.c(6);
                objInvoke = function5.invoke(safeCollector, null, anonymousClass1);
                InlineMarker.c(7);
                if (objInvoke == objE) {
                    return objE;
                }
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                return Unit.f68710a;
            } catch (Throwable th6) {
                th2 = th6;
                safeCollector2 = safeCollector;
                safeCollector2.releaseIntercepted();
                throw th2;
            }
        } catch (Throwable th7) {
            th = th7;
            i1Var = new i1(th);
            function3 = flowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.f69333b;
            anonymousClass1.L$0 = th;
            anonymousClass1.L$1 = null;
            anonymousClass1.label = 2;
            if (FlowKt__EmittersKt.c(i1Var, function3, th, anonymousClass1) == objE) {
                return objE;
            }
            throw th;
        }
    }
}
