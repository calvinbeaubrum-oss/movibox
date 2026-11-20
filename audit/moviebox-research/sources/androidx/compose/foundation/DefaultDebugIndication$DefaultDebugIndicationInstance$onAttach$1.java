package androidx.compose.foundation;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "androidx.compose.foundation.DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1", f = "Indication.kt", l = {240}, m = "invokeSuspend")
public final class DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance this$0;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f2227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f2228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f2229c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ DefaultDebugIndication.DefaultDebugIndicationInstance f2230d;

        public a(Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3, DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance) {
            this.f2227a = intRef;
            this.f2228b = intRef2;
            this.f2229c = intRef3;
            this.f2230d = defaultDebugIndicationInstance;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(o1.f fVar, Continuation<? super Unit> continuation) {
            boolean z11 = true;
            if (fVar instanceof o1.k.b) {
                this.f2227a.element++;
            } else if (fVar instanceof o1.k.c) {
                this.f2227a.element--;
            } else if (fVar instanceof o1.k.a) {
                this.f2227a.element--;
            } else if (fVar instanceof o1.d) {
                this.f2228b.element++;
            } else if (fVar instanceof o1.e) {
                this.f2228b.element--;
            } else if (fVar instanceof o1.b) {
                this.f2229c.element++;
            } else if (fVar instanceof o1.c) {
                this.f2229c.element--;
            }
            boolean z12 = false;
            boolean z13 = this.f2227a.element > 0;
            boolean z14 = this.f2228b.element > 0;
            boolean z15 = this.f2229c.element > 0;
            if (this.f2230d.f2224p != z13) {
                this.f2230d.f2224p = z13;
                z12 = true;
            }
            if (this.f2230d.f2225q != z14) {
                this.f2230d.f2225q = z14;
            } else {
                z11 = z12;
            }
            if (this.f2230d.f2226r == z15) {
                if (z11) {
                }
                return Unit.f68710a;
            }
            this.f2230d.f2226r = z15;
            androidx.compose.ui.node.o.a(this.f2230d);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(DefaultDebugIndication.DefaultDebugIndicationInstance defaultDebugIndicationInstance, Continuation<? super DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1> continuation) {
        super(2, continuation);
        this.this$0 = defaultDebugIndicationInstance;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DefaultDebugIndication$DefaultDebugIndicationInstance$onAttach$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            Ref.IntRef intRef = new Ref.IntRef();
            Ref.IntRef intRef2 = new Ref.IntRef();
            Ref.IntRef intRef3 = new Ref.IntRef();
            kotlinx.coroutines.flow.a<o1.f> aVarC = this.this$0.f2223o.c();
            a aVar = new a(intRef, intRef2, intRef3, this.this$0);
            this.label = 1;
            if (aVarC.a(aVar, this) == objE) {
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
