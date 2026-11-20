package p1;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.m4;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import y1.m;

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
public abstract class a implements c5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f73479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f73480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f73481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f73482d;

    public a(b bVar, b bVar2, b bVar3, b bVar4) {
        this.f73479a = bVar;
        this.f73480b = bVar2;
        this.f73481c = bVar3;
        this.f73482d = bVar4;
    }

    @Override // androidx.compose.ui.graphics.c5
    public final m4 a(long j11, LayoutDirection layoutDirection, q2.e eVar) {
        float fA = this.f73479a.a(j11, eVar);
        float fA2 = this.f73480b.a(j11, eVar);
        float fA3 = this.f73481c.a(j11, eVar);
        float fA4 = this.f73482d.a(j11, eVar);
        float fH = m.h(j11);
        float f11 = fA + fA4;
        if (f11 > fH) {
            float f12 = fH / f11;
            fA *= f12;
            fA4 *= f12;
        }
        float f13 = fA4;
        float f14 = fA2 + fA3;
        if (f14 > fH) {
            float f15 = fH / f14;
            fA2 *= f15;
            fA3 *= f15;
        }
        if (fA >= 0.0f && fA2 >= 0.0f && fA3 >= 0.0f && f13 >= 0.0f) {
            return b(j11, fA, fA2, fA3, f13, layoutDirection);
        }
        throw new IllegalArgumentException(("Corner size in Px can't be negative(topStart = " + fA + ", topEnd = " + fA2 + ", bottomEnd = " + fA3 + ", bottomStart = " + f13 + ")!").toString());
    }

    public abstract m4 b(long j11, float f11, float f12, float f13, float f14, LayoutDirection layoutDirection);

    public final b c() {
        return this.f73481c;
    }

    public final b d() {
        return this.f73482d;
    }

    public final b e() {
        return this.f73480b;
    }

    public final b f() {
        return this.f73479a;
    }
}
