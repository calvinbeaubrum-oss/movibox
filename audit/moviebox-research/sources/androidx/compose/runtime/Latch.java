package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CancellableContinuationImpl;

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
public final class Latch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3290a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<Continuation<Unit>> f3291b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List<Continuation<Unit>> f3292c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f3293d = true;

    public final Object c(Continuation<? super Unit> continuation) {
        if (e()) {
            return Unit.f68710a;
        }
        final CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        synchronized (this.f3290a) {
            this.f3291b.add(cancellableContinuationImpl);
        }
        cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Latch$await$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                invoke2(th2);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                Object obj = this.this$0.f3290a;
                Latch latch = this.this$0;
                kotlinx.coroutines.n<Unit> nVar = cancellableContinuationImpl;
                synchronized (obj) {
                    latch.f3291b.remove(nVar);
                    Unit unit = Unit.f68710a;
                }
            }
        });
        Object result = cancellableContinuationImpl.getResult();
        if (result == kotlin.coroutines.intrinsics.a.e()) {
            DebugProbesKt.c(continuation);
        }
        return result == kotlin.coroutines.intrinsics.a.e() ? result : Unit.f68710a;
    }

    public final void d() {
        synchronized (this.f3290a) {
            this.f3293d = false;
            Unit unit = Unit.f68710a;
        }
    }

    public final boolean e() {
        boolean z11;
        synchronized (this.f3290a) {
            z11 = this.f3293d;
        }
        return z11;
    }

    public final void f() {
        synchronized (this.f3290a) {
            try {
                if (e()) {
                    return;
                }
                List<Continuation<Unit>> list = this.f3291b;
                this.f3291b = this.f3292c;
                this.f3292c = list;
                this.f3293d = true;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    Continuation<Unit> continuation = list.get(i11);
                    Result.Companion companion = Result.Companion;
                    continuation.resumeWith(Result.m163constructorimpl(Unit.f68710a));
                }
                list.clear();
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
