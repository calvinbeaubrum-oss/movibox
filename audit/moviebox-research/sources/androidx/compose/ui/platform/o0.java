package androidx.compose.ui.platform;

import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.SessionMutex;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

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
public final class o0 implements kotlinx.coroutines.k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f5535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.compose.ui.text.input.d0 f5536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final kotlinx.coroutines.k0 f5537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f5538d = SessionMutex.a();

    public o0(View view, androidx.compose.ui.text.input.d0 d0Var, kotlinx.coroutines.k0 k0Var) {
        this.f5535a = view;
        this.f5536b = d0Var;
        this.f5537c = k0Var;
    }

    public final InputConnection a(EditorInfo editorInfo) {
        c1 c1Var = (c1) SessionMutex.c(this.f5538d);
        if (c1Var != null) {
            return c1Var.a(editorInfo);
        }
        return null;
    }

    public final boolean b() {
        c1 c1Var = (c1) SessionMutex.c(this.f5538d);
        return c1Var != null && c1Var.b();
    }

    @Override // kotlinx.coroutines.k0
    public CoroutineContext getCoroutineContext() {
        return this.f5537c.getCoroutineContext();
    }
}
