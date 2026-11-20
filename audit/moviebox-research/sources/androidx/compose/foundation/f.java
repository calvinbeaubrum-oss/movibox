package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
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
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f2267a = ViewConfiguration.getTapTimeout();

    public static final long a() {
        return f2267a;
    }

    public static final boolean b(KeyEvent keyEvent) {
        return e2.c.e(e2.d.b(keyEvent), e2.c.f63782a.b()) && d(keyEvent);
    }

    public static final boolean c(androidx.compose.ui.node.f fVar) {
        return e(androidx.compose.ui.node.h.a(fVar));
    }

    public static final boolean d(KeyEvent keyEvent) {
        int iB = e2.g.b(e2.d.a(keyEvent));
        return iB == 23 || iB == 66 || iB == 160;
    }

    public static final boolean e(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    public static final boolean f(KeyEvent keyEvent) {
        return e2.c.e(e2.d.b(keyEvent), e2.c.f63782a.a()) && d(keyEvent);
    }
}
