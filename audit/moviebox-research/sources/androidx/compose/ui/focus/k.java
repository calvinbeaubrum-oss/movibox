package androidx.compose.ui.focus;

import android.view.KeyEvent;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

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
public interface k extends h {
    Boolean a(int i11, y1.i iVar, Function1<? super FocusTargetNode, Boolean> function1);

    void b(d dVar);

    boolean c(g2.c cVar);

    y d();

    boolean e(KeyEvent keyEvent);

    void f(FocusTargetNode focusTargetNode);

    androidx.compose.ui.f g();

    boolean h(KeyEvent keyEvent, Function0<Boolean> function0);

    boolean i(boolean z11, boolean z12, boolean z13, int i11);

    u j();

    void k(o oVar);

    y1.i l();

    boolean m(b bVar, y1.i iVar);

    void n();
}
