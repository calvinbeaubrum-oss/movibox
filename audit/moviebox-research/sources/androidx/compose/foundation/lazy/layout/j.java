package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.lazy.layout.j.a;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public abstract class j<Interval extends a> {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        Function1<Integer, Object> getKey();

        Function1<Integer, Object> getType();
    }

    public final Object b(int i11) {
        b.a<Interval> aVar = c().get(i11);
        return aVar.c().getType().invoke(Integer.valueOf(i11 - aVar.b()));
    }

    public abstract b<Interval> c();

    public final int d() {
        return c().getSize();
    }

    public final Object e(int i11) {
        Object objInvoke;
        b.a<Interval> aVar = c().get(i11);
        int iB = i11 - aVar.b();
        Function1<Integer, Object> key = aVar.c().getKey();
        return (key == null || (objInvoke = key.invoke(Integer.valueOf(iB))) == null) ? b0.a(i11) : objInvoke;
    }
}
