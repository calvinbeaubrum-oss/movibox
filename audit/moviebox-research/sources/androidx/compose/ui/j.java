package androidx.compose.ui;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
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
public interface j extends CoroutineContext.Element {
    public static final b Y7 = b.f4785a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static <R> R a(j jVar, R r11, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
            return (R) CoroutineContext.Element.DefaultImpls.a(jVar, r11, function2);
        }

        public static <E extends CoroutineContext.Element> E b(j jVar, CoroutineContext.Key<E> key) {
            return (E) CoroutineContext.Element.DefaultImpls.b(jVar, key);
        }

        public static CoroutineContext c(j jVar, CoroutineContext.Key<?> key) {
            return CoroutineContext.Element.DefaultImpls.c(jVar, key);
        }

        public static CoroutineContext d(j jVar, CoroutineContext coroutineContext) {
            return CoroutineContext.Element.DefaultImpls.d(jVar, coroutineContext);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements CoroutineContext.Key<j> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f4785a = new b();
    }

    float d();
}
