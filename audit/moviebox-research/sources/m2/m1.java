package m2;

import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
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
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m1 f70625a = new m1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o1 f70626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f70627c;

    static {
        f70626b = Build.VERSION.SDK_INT >= 23 ? new a1() : new n1();
        f70627c = 8;
    }

    public final StaticLayout a(CharSequence charSequence, TextPaint textPaint, int i11, int i12, int i13, TextDirectionHeuristic textDirectionHeuristic, Layout.Alignment alignment, int i14, TextUtils.TruncateAt truncateAt, int i15, float f11, float f12, int i16, boolean z11, boolean z12, int i17, int i18, int i19, int i21, int[] iArr, int[] iArr2) {
        return f70626b.a(new p1(charSequence, i12, i13, textPaint, i11, textDirectionHeuristic, alignment, i14, truncateAt, i15, f11, f12, i16, z11, z12, i17, i18, i19, i21, iArr, iArr2));
    }

    public final boolean c(StaticLayout staticLayout, boolean z11) {
        return f70626b.b(staticLayout, z11);
    }
}
