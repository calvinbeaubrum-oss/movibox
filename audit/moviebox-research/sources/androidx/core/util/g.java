package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
public class g<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f7891a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f7892b;

    public g(int i11) {
        if (i11 <= 0) {
            throw new IllegalArgumentException("The max pool size must be > 0".toString());
        }
        this.f7891a = new Object[i11];
    }

    public final boolean a(T t11) {
        int i11 = this.f7892b;
        for (int i12 = 0; i12 < i11; i12++) {
            if (this.f7891a[i12] == t11) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.core.util.f
    public T acquire() {
        int i11 = this.f7892b;
        if (i11 <= 0) {
            return null;
        }
        int i12 = i11 - 1;
        T t11 = (T) this.f7891a[i12];
        Intrinsics.e(t11, "null cannot be cast to non-null type T of androidx.core.util.Pools.SimplePool");
        this.f7891a[i12] = null;
        this.f7892b--;
        return t11;
    }

    @Override // androidx.core.util.f
    public boolean release(T instance) {
        Intrinsics.g(instance, "instance");
        if (!(!a(instance))) {
            throw new IllegalStateException("Already in the pool!".toString());
        }
        int i11 = this.f7892b;
        Object[] objArr = this.f7891a;
        if (i11 >= objArr.length) {
            return false;
        }
        objArr[i11] = instance;
        this.f7892b = i11 + 1;
        return true;
    }
}
