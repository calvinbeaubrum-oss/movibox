package androidx.compose.animation.core;

import androidx.compose.animation.core.o;
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
public final class d1<V extends o> implements x0<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f0 f2057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public V f2058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public V f2059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public V f2060d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f2061e;

    public d1(f0 f0Var) {
        this.f2057a = f0Var;
        this.f2061e = f0Var.a();
    }

    @Override // androidx.compose.animation.core.x0
    public float a() {
        return this.f2061e;
    }

    @Override // androidx.compose.animation.core.x0
    public V b(long j11, V v11, V v12) {
        if (this.f2059c == null) {
            this.f2059c = (V) p.g(v11);
        }
        V v13 = this.f2059c;
        if (v13 == null) {
            Intrinsics.y("velocityVector");
            v13 = null;
        }
        int iB = v13.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v14 = this.f2059c;
            if (v14 == null) {
                Intrinsics.y("velocityVector");
                v14 = null;
            }
            v14.e(i11, this.f2057a.b(j11, v11.a(i11), v12.a(i11)));
        }
        V v15 = this.f2059c;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.y("velocityVector");
        return null;
    }

    @Override // androidx.compose.animation.core.x0
    public long c(V v11, V v12) {
        if (this.f2059c == null) {
            this.f2059c = (V) p.g(v11);
        }
        V v13 = this.f2059c;
        if (v13 == null) {
            Intrinsics.y("velocityVector");
            v13 = null;
        }
        int iB = v13.b();
        long jMax = 0;
        for (int i11 = 0; i11 < iB; i11++) {
            jMax = Math.max(jMax, this.f2057a.c(v11.a(i11), v12.a(i11)));
        }
        return jMax;
    }

    @Override // androidx.compose.animation.core.x0
    public V d(V v11, V v12) {
        if (this.f2060d == null) {
            this.f2060d = (V) p.g(v11);
        }
        V v13 = this.f2060d;
        if (v13 == null) {
            Intrinsics.y("targetVector");
            v13 = null;
        }
        int iB = v13.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v14 = this.f2060d;
            if (v14 == null) {
                Intrinsics.y("targetVector");
                v14 = null;
            }
            v14.e(i11, this.f2057a.d(v11.a(i11), v12.a(i11)));
        }
        V v15 = this.f2060d;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.y("targetVector");
        return null;
    }

    @Override // androidx.compose.animation.core.x0
    public V e(long j11, V v11, V v12) {
        if (this.f2058b == null) {
            this.f2058b = (V) p.g(v11);
        }
        V v13 = this.f2058b;
        if (v13 == null) {
            Intrinsics.y("valueVector");
            v13 = null;
        }
        int iB = v13.b();
        for (int i11 = 0; i11 < iB; i11++) {
            V v14 = this.f2058b;
            if (v14 == null) {
                Intrinsics.y("valueVector");
                v14 = null;
            }
            v14.e(i11, this.f2057a.e(j11, v11.a(i11), v12.a(i11)));
        }
        V v15 = this.f2058b;
        if (v15 != null) {
            return v15;
        }
        Intrinsics.y("valueVector");
        return null;
    }
}
