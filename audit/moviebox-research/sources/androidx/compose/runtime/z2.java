package androidx.compose.runtime;

import java.util.ArrayList;
import kotlin.Metadata;

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
public final class z2<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<T> f3765a = new ArrayList<>();

    public final void a() {
        this.f3765a.clear();
    }

    public final int b() {
        return this.f3765a.size();
    }

    public final boolean c() {
        return this.f3765a.isEmpty();
    }

    public final boolean d() {
        return !c();
    }

    public final T e() {
        return this.f3765a.get(b() - 1);
    }

    public final T f(int i11) {
        return this.f3765a.get(i11);
    }

    public final T g() {
        return this.f3765a.remove(b() - 1);
    }

    public final boolean h(T t11) {
        return this.f3765a.add(t11);
    }

    public final T[] i() {
        int size = this.f3765a.size();
        T[] tArr = (T[]) new Object[size];
        for (int i11 = 0; i11 < size; i11++) {
            tArr[i11] = this.f3765a.get(i11);
        }
        return tArr;
    }
}
