package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public final class ComputedProvidableCompositionLocal<T> extends s1<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x<T> f3274b;

    public ComputedProvidableCompositionLocal(Function1<? super r, ? extends T> function1) {
        super(new Function0<T>() { // from class: androidx.compose.runtime.ComputedProvidableCompositionLocal.1
            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                k.t("Unexpected call to default provider");
                throw new KotlinNothingValueException();
            }
        });
        this.f3274b = new x<>(function1);
    }

    @Override // androidx.compose.runtime.s1
    public t1<T> c(T t11) {
        return new t1<>(this, t11, t11 == null, null, null, null, true);
    }

    @Override // androidx.compose.runtime.q
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public x<T> a() {
        return this.f3274b;
    }
}
