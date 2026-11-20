package androidx.compose.ui.scrollcapture;

import android.graphics.Point;
import android.view.ScrollCaptureTarget;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.compose.runtime.i1;
import androidx.compose.runtime.u2;
import androidx.compose.ui.graphics.w4;
import androidx.compose.ui.layout.n;
import androidx.compose.ui.semantics.p;
import com.vungle.warren.error.VungleException;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;
import q2.s;

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
@RequiresApi(VungleException.WEB_CRASH)
@Metadata
@SourceDebugExtension
public final class ScrollCapture implements ComposeScrollCaptureCallback.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i1 f5576a = u2.c(Boolean.FALSE, null, 2, null);

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.a
    public void a() {
        e(true);
    }

    @Override // androidx.compose.ui.scrollcapture.ComposeScrollCaptureCallback.a
    public void b() {
        e(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean c() {
        return ((Boolean) this.f5576a.getValue()).booleanValue();
    }

    public final void d(View view, p pVar, CoroutineContext coroutineContext, Consumer<ScrollCaptureTarget> consumer) {
        androidx.compose.runtime.collection.b bVar = new androidx.compose.runtime.collection.b(new j[16], 0);
        k.f(pVar.a(), 0, new ScrollCapture$onScrollCaptureSearch$1(bVar), 2, null);
        bVar.E(kotlin.comparisons.b.b(new Function1<j, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$2
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(j jVar) {
                return Integer.valueOf(jVar.b());
            }
        }, new Function1<j, Comparable<?>>() { // from class: androidx.compose.ui.scrollcapture.ScrollCapture$onScrollCaptureSearch$3
            @Override // kotlin.jvm.functions.Function1
            public final Comparable<?> invoke(j jVar) {
                return Integer.valueOf(jVar.d().e());
            }
        }));
        j jVar = (j) (bVar.t() ? null : bVar.q()[bVar.r() - 1]);
        if (jVar == null) {
            return;
        }
        ComposeScrollCaptureCallback composeScrollCaptureCallback = new ComposeScrollCaptureCallback(jVar.c(), jVar.d(), l0.a(coroutineContext), this);
        y1.i iVarB = n.b(jVar.a());
        long jI = jVar.d().i();
        ScrollCaptureTarget scrollCaptureTargetA = i.a(view, w4.a(s.b(iVarB)), new Point(q2.p.h(jI), q2.p.i(jI)), g.a(composeScrollCaptureCallback));
        scrollCaptureTargetA.setScrollBounds(w4.a(jVar.d()));
        consumer.accept(scrollCaptureTargetA);
    }

    public final void e(boolean z11) {
        this.f5576a.setValue(Boolean.valueOf(z11));
    }
}
