package androidx.compose.ui.text.input;

import android.view.inputmethod.CursorAnchorInfo;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

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
@RequiresApi(34)
@Metadata
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f5938a = new i();

    @JvmStatic
    public static final CursorAnchorInfo.Builder a(CursorAnchorInfo.Builder builder, androidx.compose.ui.text.a0 a0Var, y1.i iVar) {
        int iQ;
        int iQ2;
        if (!iVar.n() && (iQ = a0Var.q(iVar.i())) <= (iQ2 = a0Var.q(iVar.c()))) {
            while (true) {
                builder.addVisibleLineBounds(a0Var.r(iQ), a0Var.u(iQ), a0Var.s(iQ), a0Var.l(iQ));
                if (iQ == iQ2) {
                    break;
                }
                iQ++;
            }
        }
        return builder;
    }
}
