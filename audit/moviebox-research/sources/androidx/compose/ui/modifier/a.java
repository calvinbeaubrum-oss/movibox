package androidx.compose.ui.modifier;

import kotlin.Metadata;
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
public final class a extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j<?> f4898a;

    public a(j<?> jVar) {
        super(null);
        this.f4898a = jVar;
    }

    @Override // androidx.compose.ui.modifier.f
    public boolean a(c<?> cVar) {
        return cVar == this.f4898a.getKey();
    }

    @Override // androidx.compose.ui.modifier.f
    public <T> T b(c<T> cVar) {
        if (!(cVar == this.f4898a.getKey())) {
            h2.a.b("Check failed.");
        }
        return (T) this.f4898a.getValue();
    }

    public final void c(j<?> jVar) {
        this.f4898a = jVar;
    }
}
