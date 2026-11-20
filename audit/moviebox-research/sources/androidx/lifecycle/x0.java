package androidx.lifecycle;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public class x0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, t0> f8802a = new LinkedHashMap();

    public final void a() {
        Iterator<t0> it = this.f8802a.values().iterator();
        while (it.hasNext()) {
            it.next().clear$lifecycle_viewmodel_release();
        }
        this.f8802a.clear();
    }

    public final t0 b(String key) {
        Intrinsics.g(key, "key");
        return this.f8802a.get(key);
    }

    public final Set<String> c() {
        return new HashSet(this.f8802a.keySet());
    }

    public final void d(String key, t0 viewModel) {
        Intrinsics.g(key, "key");
        Intrinsics.g(viewModel, "viewModel");
        t0 t0VarPut = this.f8802a.put(key, viewModel);
        if (t0VarPut != null) {
            t0VarPut.clear$lifecycle_viewmodel_release();
        }
    }
}
