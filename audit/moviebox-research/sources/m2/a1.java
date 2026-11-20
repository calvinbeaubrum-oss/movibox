package m2;

import android.os.Build;
import android.text.StaticLayout;
import androidx.annotation.RequiresApi;
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
@RequiresApi(23)
@Metadata
public final class a1 implements o1 {
    @Override // m2.o1
    public StaticLayout a(p1 p1Var) {
        StaticLayout.Builder builderObtain = StaticLayout.Builder.obtain(p1Var.r(), p1Var.q(), p1Var.e(), p1Var.o(), p1Var.u());
        builderObtain.setTextDirection(p1Var.s());
        builderObtain.setAlignment(p1Var.a());
        builderObtain.setMaxLines(p1Var.n());
        builderObtain.setEllipsize(p1Var.c());
        builderObtain.setEllipsizedWidth(p1Var.d());
        builderObtain.setLineSpacing(p1Var.l(), p1Var.m());
        builderObtain.setIncludePad(p1Var.g());
        builderObtain.setBreakStrategy(p1Var.b());
        builderObtain.setHyphenationFrequency(p1Var.f());
        builderObtain.setIndents(p1Var.i(), p1Var.p());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            c1.a(builderObtain, p1Var.h());
        }
        if (i11 >= 28) {
            e1.a(builderObtain, p1Var.t());
        }
        if (i11 >= 33) {
            l1.b(builderObtain, p1Var.j(), p1Var.k());
        }
        return builderObtain.build();
    }

    @Override // m2.o1
    public boolean b(StaticLayout staticLayout, boolean z11) {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 33) {
            return l1.a(staticLayout);
        }
        if (i11 >= 28) {
            return z11;
        }
        return false;
    }
}
