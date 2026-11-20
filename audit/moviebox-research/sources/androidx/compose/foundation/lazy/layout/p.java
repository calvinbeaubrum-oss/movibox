package androidx.compose.foundation.lazy.layout;

import kotlin.Metadata;

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
public interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2730a = a.f2731b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements p {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ a f2731b = new a();

        @Override // androidx.compose.foundation.lazy.layout.p
        public int a(Object obj) {
            return -1;
        }

        @Override // androidx.compose.foundation.lazy.layout.p
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void b(int i11) {
            return null;
        }
    }

    int a(Object obj);

    Object b(int i11);
}
