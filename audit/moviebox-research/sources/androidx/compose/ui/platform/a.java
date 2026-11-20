package androidx.compose.ui.platform;

import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
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
public abstract class a implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f5420a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f5421b = new int[2];

    public final int[] c(int i11, int i12) {
        if (i11 < 0 || i12 < 0 || i11 == i12) {
            return null;
        }
        int[] iArr = this.f5421b;
        iArr[0] = i11;
        iArr[1] = i12;
        return iArr;
    }

    public final String d() {
        String str = this.f5420a;
        if (str != null) {
            return str;
        }
        Intrinsics.y(MimeTypes.BASE_TYPE_TEXT);
        return null;
    }

    public void e(String str) {
        f(str);
    }

    public final void f(String str) {
        this.f5420a = str;
    }
}
