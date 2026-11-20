package androidx.privacysandbox.ads.adservices.java.internal;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.s;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.o0;

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
public final class CoroutineAdapterKt {
    public static final <T> s<T> b(final o0<? extends T> o0Var, final Object obj) {
        Intrinsics.g(o0Var, "<this>");
        s<T> sVarA = CallbackToFutureAdapter.a(new CallbackToFutureAdapter.b() { // from class: androidx.privacysandbox.ads.adservices.java.internal.a
            @Override // androidx.concurrent.futures.CallbackToFutureAdapter.b
            public final Object a(CallbackToFutureAdapter.a aVar) {
                return CoroutineAdapterKt.d(o0Var, obj, aVar);
            }
        });
        Intrinsics.f(sVarA, "getFuture { completer ->…        }\n    }\n    tag\n}");
        return sVarA;
    }

    public static /* synthetic */ s c(o0 o0Var, Object obj, int i11, Object obj2) {
        if ((i11 & 1) != 0) {
            obj = "Deferred.asListenableFuture";
        }
        return b(o0Var, obj);
    }

    public static final Object d(final o0 this_asListenableFuture, Object obj, final CallbackToFutureAdapter.a completer) {
        Intrinsics.g(this_asListenableFuture, "$this_asListenableFuture");
        Intrinsics.g(completer, "completer");
        this_asListenableFuture.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt$asListenableFuture$1$1
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

            /* JADX WARN: Type inference incomplete: some casts might be missing */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th2) {
                if (th2 == null) {
                    completer.b((T) this_asListenableFuture.a());
                } else if (th2 instanceof CancellationException) {
                    completer.c();
                } else {
                    completer.e(th2);
                }
            }
        });
        return obj;
    }
}
