package m2;

import android.text.Layout;
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
public final class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q1 f70653a = new q1();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Layout.Alignment f70654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Layout.Alignment f70655c;

    static {
        Layout.Alignment[] alignmentArrValues = Layout.Alignment.values();
        Layout.Alignment alignment = Layout.Alignment.ALIGN_NORMAL;
        Layout.Alignment alignment2 = alignment;
        for (Layout.Alignment alignment3 : alignmentArrValues) {
            if (Intrinsics.b(alignment3.name(), "ALIGN_LEFT")) {
                alignment = alignment3;
            } else if (Intrinsics.b(alignment3.name(), "ALIGN_RIGHT")) {
                alignment2 = alignment3;
            }
        }
        f70654b = alignment;
        f70655c = alignment2;
    }

    public final Layout.Alignment a(int i11) {
        if (i11 == 0) {
            return Layout.Alignment.ALIGN_NORMAL;
        }
        if (i11 == 1) {
            return Layout.Alignment.ALIGN_OPPOSITE;
        }
        if (i11 == 2) {
            return Layout.Alignment.ALIGN_CENTER;
        }
        if (i11 != 3) {
            return i11 != 4 ? Layout.Alignment.ALIGN_NORMAL : f70655c;
        }
        return f70654b;
    }
}
