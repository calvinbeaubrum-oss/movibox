package androidx.compose.foundation.lazy.layout;

import android.os.Build;
import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2723a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements i0 {
        @Override // androidx.compose.foundation.lazy.layout.i0
        public void schedulePrefetch(g0 g0Var) {
        }
    }

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        f2723a = Intrinsics.b(lowerCase, "robolectric") ? new a() : null;
    }

    public static final i0 a(androidx.compose.runtime.i iVar, int i11) {
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.S(1141871251, i11, -1, "androidx.compose.foundation.lazy.layout.rememberDefaultPrefetchScheduler (PrefetchScheduler.android.kt:32)");
        }
        i0 i0Var = f2723a;
        if (i0Var != null) {
            iVar.R(1213893039);
            iVar.L();
        } else {
            iVar.R(1213931944);
            View view = (View) iVar.l(AndroidCompositionLocals_androidKt.j());
            boolean zQ = iVar.Q(view);
            Object objY = iVar.y();
            if (zQ || objY == androidx.compose.runtime.i.f3413a.a()) {
                objY = new AndroidPrefetchScheduler(view);
                iVar.p(objY);
            }
            i0Var = (AndroidPrefetchScheduler) objY;
            iVar.L();
        }
        if (androidx.compose.runtime.k.J()) {
            androidx.compose.runtime.k.R();
        }
        return i0Var;
    }
}
