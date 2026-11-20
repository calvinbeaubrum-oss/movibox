package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Recomposer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;

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
public final class WindowRecomposerPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final WindowRecomposerPolicy f5400a = new WindowRecomposerPolicy();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AtomicReference<b3> f5401b = new AtomicReference<>(b3.f5437a.c());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f5402c = 8;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.q1 f5403a;

        public a(kotlinx.coroutines.q1 q1Var) {
            this.f5403a = q1Var;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            view.removeOnAttachStateChangeListener(this);
            kotlinx.coroutines.q1.a.b(this.f5403a, null, 1, null);
        }
    }

    public final Recomposer a(View view) {
        Recomposer recomposerA = f5401b.get().a(view);
        WindowRecomposer_androidKt.i(view, recomposerA);
        view.addOnAttachStateChangeListener(new a(kotlinx.coroutines.j.d(kotlinx.coroutines.j1.f69500a, kotlinx.coroutines.android.f.d(view.getHandler(), "windowRecomposer cleanup").q(), null, new WindowRecomposerPolicy$createAndInstallWindowRecomposer$unsetJob$1(recomposerA, view, null), 2, null)));
        return recomposerA;
    }
}
