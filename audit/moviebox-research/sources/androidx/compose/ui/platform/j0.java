package androidx.compose.ui.platform;

import android.view.PointerIcon;
import android.view.View;
import androidx.annotation.RequiresApi;
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
@RequiresApi(24)
@Metadata
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j0 f5497a = new j0();

    @RequiresApi(24)
    public final void a(View view, androidx.compose.ui.input.pointer.u uVar) {
        PointerIcon systemIcon;
        if (uVar instanceof androidx.compose.ui.input.pointer.b) {
            systemIcon = ((androidx.compose.ui.input.pointer.b) uVar).a();
        } else {
            systemIcon = uVar instanceof androidx.compose.ui.input.pointer.c ? PointerIcon.getSystemIcon(view.getContext(), ((androidx.compose.ui.input.pointer.c) uVar).a()) : PointerIcon.getSystemIcon(view.getContext(), 1000);
        }
        if (Intrinsics.b(view.getPointerIcon(), systemIcon)) {
            return;
        }
        view.setPointerIcon(systemIcon);
    }
}
