package androidx.compose.ui.text.font;

import android.graphics.Typeface;
import android.os.Build;
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
public final class s {
    /* JADX WARN: Code duplicated, block: B:14:0x0033  */
    public static final Object a(int i11, Object obj, h hVar, u uVar, int i12) {
        boolean z11;
        if (!(obj instanceof Typeface)) {
            return obj;
        }
        boolean z12 = false;
        if (!r.h(i11) || Intrinsics.b(hVar.b(), uVar)) {
            z11 = false;
        } else {
            u.a aVar = u.f5860b;
            if (uVar.compareTo(e.a(aVar)) < 0 || hVar.b().compareTo(e.a(aVar)) >= 0) {
                z11 = false;
            } else {
                z11 = true;
            }
        }
        boolean z13 = r.g(i11) && !q.f(i12, hVar.d());
        if (!z13 && !z11) {
            return obj;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return m0.f5837a.a((Typeface) obj, z11 ? uVar.i() : hVar.b().i(), z13 ? q.f(i12, q.f5850b.a()) : q.f(hVar.d(), q.f5850b.a()));
        }
        if (z13 && q.f(i12, q.f5850b.a())) {
            z12 = true;
        }
        return Typeface.create((Typeface) obj, e.b(z11, z12));
    }
}
