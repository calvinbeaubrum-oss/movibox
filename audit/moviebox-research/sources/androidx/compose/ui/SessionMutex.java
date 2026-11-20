package androidx.compose.ui;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
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
@JvmInline
public final class SessionMutex<T> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q1 f3768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f3769b;

        public a(q1 q1Var, T t11) {
            this.f3768a = q1Var;
            this.f3769b = t11;
        }

        public final q1 a() {
            return this.f3768a;
        }

        public final T b() {
            return this.f3769b;
        }
    }

    public static <T> AtomicReference<a<T>> a() {
        return b(new AtomicReference(null));
    }

    public static <T> AtomicReference<a<T>> b(AtomicReference<a<T>> atomicReference) {
        return atomicReference;
    }

    public static final T c(AtomicReference<a<T>> atomicReference) {
        a<T> aVar = atomicReference.get();
        if (aVar != null) {
            return aVar.b();
        }
        return null;
    }

    public static final <R> Object d(AtomicReference<a<T>> atomicReference, Function1<? super k0, ? extends T> function1, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, Continuation<? super R> continuation) {
        return l0.e(new SessionMutex$withSessionCancellingPrevious$2(function1, atomicReference, function2, null), continuation);
    }
}
