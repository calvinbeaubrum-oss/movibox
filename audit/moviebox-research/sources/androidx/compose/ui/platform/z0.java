package androidx.compose.ui.platform;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

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
public final class z0 implements androidx.compose.runtime.saveable.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f5562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ androidx.compose.runtime.saveable.b f5563b;

    public z0(androidx.compose.runtime.saveable.b bVar, Function0<Unit> function0) {
        this.f5562a = function0;
        this.f5563b = bVar;
    }

    @Override // androidx.compose.runtime.saveable.b
    public boolean a(Object obj) {
        return this.f5563b.a(obj);
    }

    @Override // androidx.compose.runtime.saveable.b
    public androidx.compose.runtime.saveable.b.a b(String str, Function0<? extends Object> function0) {
        return this.f5563b.b(str, function0);
    }

    public final void c() {
        this.f5562a.invoke();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Map<String, List<Object>> e() {
        return this.f5563b.e();
    }

    @Override // androidx.compose.runtime.saveable.b
    public Object f(String str) {
        return this.f5563b.f(str);
    }
}
