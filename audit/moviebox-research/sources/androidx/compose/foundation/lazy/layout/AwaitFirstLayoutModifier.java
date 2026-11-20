package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
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
public final class AwaitFirstLayoutModifier implements androidx.compose.ui.layout.c0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f2597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Continuation<? super Unit> f2598c;

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(Continuation<? super Unit> continuation) throws Throwable {
        AwaitFirstLayoutModifier$waitForFirstLayout$1 awaitFirstLayoutModifier$waitForFirstLayout$1;
        Continuation<? super Unit> continuation2;
        if (continuation instanceof AwaitFirstLayoutModifier$waitForFirstLayout$1) {
            awaitFirstLayoutModifier$waitForFirstLayout$1 = (AwaitFirstLayoutModifier$waitForFirstLayout$1) continuation;
            int i11 = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                awaitFirstLayoutModifier$waitForFirstLayout$1.label = i11 - Integer.MIN_VALUE;
            } else {
                awaitFirstLayoutModifier$waitForFirstLayout$1 = new AwaitFirstLayoutModifier$waitForFirstLayout$1(this, continuation);
            }
        } else {
            awaitFirstLayoutModifier$waitForFirstLayout$1 = new AwaitFirstLayoutModifier$waitForFirstLayout$1(this, continuation);
        }
        Object obj = awaitFirstLayoutModifier$waitForFirstLayout$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = awaitFirstLayoutModifier$waitForFirstLayout$1.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            if (!this.f2597b) {
                Continuation<? super Unit> continuation3 = this.f2598c;
                awaitFirstLayoutModifier$waitForFirstLayout$1.L$0 = this;
                awaitFirstLayoutModifier$waitForFirstLayout$1.L$1 = continuation3;
                awaitFirstLayoutModifier$waitForFirstLayout$1.label = 1;
                SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt__IntrinsicsJvmKt.c(awaitFirstLayoutModifier$waitForFirstLayout$1));
                this.f2598c = safeContinuation;
                Object objA = safeContinuation.a();
                if (objA == kotlin.coroutines.intrinsics.a.e()) {
                    DebugProbesKt.c(awaitFirstLayoutModifier$waitForFirstLayout$1);
                }
                if (objA == objE) {
                    return objE;
                }
                continuation2 = continuation3;
            }
            return Unit.f68710a;
        }
        if (i12 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        continuation2 = (Continuation) awaitFirstLayoutModifier$waitForFirstLayout$1.L$1;
        ResultKt.b(obj);
        if (continuation2 != null) {
            Result.Companion companion = Result.Companion;
            continuation2.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
        return Unit.f68710a;
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ Object c(Object obj, Function2 function2) {
        return androidx.compose.ui.g.b(this, obj, function2);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ boolean d(Function1 function1) {
        return androidx.compose.ui.g.a(this, function1);
    }

    @Override // androidx.compose.ui.f
    public /* synthetic */ androidx.compose.ui.f f(androidx.compose.ui.f fVar) {
        return androidx.compose.ui.e.a(this, fVar);
    }

    @Override // androidx.compose.ui.layout.c0
    public void x(androidx.compose.ui.layout.m mVar) {
        if (this.f2597b) {
            return;
        }
        this.f2597b = true;
        Continuation<? super Unit> continuation = this.f2598c;
        if (continuation != null) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
        }
        this.f2598c = null;
    }
}
