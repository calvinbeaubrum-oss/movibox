package androidx.compose.material;

import androidx.compose.ui.graphics.w1;
import androidx.compose.ui.graphics.y1;
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
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f3095a = new k();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3096b = 0;

    public final j a(long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j21, androidx.compose.runtime.i iVar, int i11, int i12, int i13) {
        long jH;
        long jH2 = (i13 & 1) != 0 ? e.f3086a.a(iVar, 6).h() : j11;
        if ((i13 & 2) != 0) {
            e eVar = e.f3086a;
            jH = y1.h(w1.k(eVar.a(iVar, 6).g(), c.f3075a.b(iVar, 6), 0.0f, 0.0f, 0.0f, 14, null), eVar.a(iVar, 6).l());
        } else {
            jH = j12;
        }
        long jH3 = (i13 & 4) != 0 ? e.f3086a.a(iVar, 6).h() : j13;
        long jK = (i13 & 8) != 0 ? w1.k(jH3, 0.24f, 0.0f, 0.0f, 0.0f, 14, null) : j14;
        long jK2 = (i13 & 16) != 0 ? w1.k(e.f3086a.a(iVar, 6).g(), 0.32f, 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jK3 = (i13 & 32) != 0 ? w1.k(jK2, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jK4 = (i13 & 64) != 0 ? w1.k(ColorsKt.b(jH3, iVar, (i11 >> 6) & 14), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jK5 = (i13 & 128) != 0 ? w1.k(jH3, 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j18;
        long jK6 = (i13 & 256) != 0 ? w1.k(jK4, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jK7 = (i13 & 512) != 0 ? w1.k(jK3, 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j21;
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(436017687, i11, i12, "androidx.compose.material.SliderDefaults.colors (Slider.kt:500)");
        }
        d dVar = new d(jH2, jH, jH3, jK, jK2, jK3, jK4, jK5, jK6, jK7, null);
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return dVar;
    }
}
