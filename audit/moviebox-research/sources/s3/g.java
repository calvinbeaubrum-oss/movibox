package s3;

import androidx.lifecycle.m;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.y0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.reflect.KClass;

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
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g f75955a = new g();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements r3.a.b<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f75956a = new a();
    }

    public final r3.a a(y0 owner) {
        Intrinsics.g(owner, "owner");
        return owner instanceof m ? ((m) owner).getDefaultViewModelCreationExtras() : r3.a.C0824a.f75108b;
    }

    public final v0.c b(y0 owner) {
        Intrinsics.g(owner, "owner");
        return owner instanceof m ? ((m) owner).getDefaultViewModelProviderFactory() : c.f75949a;
    }

    public final <T extends t0> String c(KClass<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        String strA = h.a(modelClass);
        if (strA == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels".toString());
        }
        return "androidx.lifecycle.ViewModelProvider.DefaultKey:" + strA;
    }

    public final <VM extends t0> VM d() {
        throw new UnsupportedOperationException("`Factory.create(String, CreationExtras)` is not implemented. You may need to override the method and provide a custom implementation. Note that using `Factory.create(String)` is not supported and considered an error.");
    }
}
