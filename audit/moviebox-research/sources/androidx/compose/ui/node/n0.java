package androidx.compose.ui.node;

import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class n0<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5106c = androidx.compose.runtime.collection.b.f3357d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final androidx.compose.runtime.collection.b<T> f5107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f5108b;

    public n0(androidx.compose.runtime.collection.b<T> bVar, Function0<Unit> function0) {
        this.f5107a = bVar;
        this.f5108b = function0;
    }

    public final void a(int i11, T t11) {
        this.f5107a.a(i11, t11);
        this.f5108b.invoke();
    }

    public final List<T> b() {
        return this.f5107a.h();
    }

    public final void c() {
        this.f5107a.i();
        this.f5108b.invoke();
    }

    public final T d(int i11) {
        return this.f5107a.q()[i11];
    }

    public final int e() {
        return this.f5107a.r();
    }

    public final androidx.compose.runtime.collection.b<T> f() {
        return this.f5107a;
    }

    public final T g(int i11) {
        T tZ = this.f5107a.z(i11);
        this.f5108b.invoke();
        return tZ;
    }
}
