package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
public interface u0 extends CoroutineContext.Element {
    public static final b X7 = b.f3732a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static <R> R a(u0 u0Var, R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(u0Var, r11, function2);
        }

        public static <E extends CoroutineContext.Element> E b(u0 u0Var, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.b(u0Var, key);
        }

        public static CoroutineContext c(u0 u0Var, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(u0Var, key);
        }

        public static CoroutineContext d(u0 u0Var, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(u0Var, coroutineContext);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements CoroutineContext.Key<u0> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f3732a = new b();
    }

    <R> Object e(Function1<? super Long, ? extends R> function1, Continuation<? super R> continuation);
}
