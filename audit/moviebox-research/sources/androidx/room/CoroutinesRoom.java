package androidx.room;

import android.os.CancellationSignal;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.j1;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class CoroutinesRoom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Companion f12732a = new Companion(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final <R> Object a(RoomDatabase roomDatabase, boolean z11, final CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
            ContinuationInterceptor continuationInterceptorB;
            if (roomDatabase.z() && roomDatabase.t()) {
                return callable.call();
            }
            b0 b0Var = (b0) continuation.getContext().get(b0.f12816c);
            if (b0Var == null || (continuationInterceptorB = b0Var.f()) == null) {
                continuationInterceptorB = z11 ? e.b(roomDatabase) : e.a(roomDatabase);
            }
            ContinuationInterceptor continuationInterceptor = continuationInterceptorB;
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt__IntrinsicsJvmKt.c(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final q1 q1VarD = kotlinx.coroutines.j.d(j1.f69500a, continuationInterceptor, null, new CoroutinesRoom$Companion$execute$4$job$1(callable, cancellableContinuationImpl, null), 2, null);
            cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: androidx.room.CoroutinesRoom$Companion$execute$4$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    g6.b.a(cancellationSignal);
                    q1.a.b(q1VarD, null, 1, null);
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == kotlin.coroutines.intrinsics.a.e()) {
                DebugProbesKt.c(continuation);
            }
            return result;
        }

        @JvmStatic
        public final <R> Object b(RoomDatabase roomDatabase, boolean z11, Callable<R> callable, Continuation<? super R> continuation) {
            ContinuationInterceptor continuationInterceptorB;
            if (roomDatabase.z() && roomDatabase.t()) {
                return callable.call();
            }
            b0 b0Var = (b0) continuation.getContext().get(b0.f12816c);
            if (b0Var == null || (continuationInterceptorB = b0Var.f()) == null) {
                continuationInterceptorB = z11 ? e.b(roomDatabase) : e.a(roomDatabase);
            }
            return kotlinx.coroutines.h.g(continuationInterceptorB, new CoroutinesRoom$Companion$execute$2(callable, null), continuation);
        }
    }

    @JvmStatic
    public static final <R> Object a(RoomDatabase roomDatabase, boolean z11, CancellationSignal cancellationSignal, Callable<R> callable, Continuation<? super R> continuation) {
        return f12732a.a(roomDatabase, z11, cancellationSignal, callable, continuation);
    }

    @JvmStatic
    public static final <R> Object b(RoomDatabase roomDatabase, boolean z11, Callable<R> callable, Continuation<? super R> continuation) {
        return f12732a.b(roomDatabase, z11, callable, continuation);
    }
}
