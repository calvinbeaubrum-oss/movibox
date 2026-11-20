package androidx.slidingpanelayout.widget;

import android.app.Activity;
import androidx.window.layout.a0;
import androidx.window.layout.l;
import androidx.window.layout.r;
import androidx.window.layout.x;
import java.util.Iterator;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;

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
public final class FoldingFeatureObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f12924a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f12925b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public q1 f12926c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f12927d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(r rVar);
    }

    public FoldingFeatureObserver(x windowInfoTracker, Executor executor) {
        Intrinsics.g(windowInfoTracker, "windowInfoTracker");
        Intrinsics.g(executor, "executor");
        this.f12924a = windowInfoTracker;
        this.f12925b = executor;
    }

    public final r d(a0 a0Var) {
        Object next;
        Iterator<T> it = a0Var.a().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
        } while (!(((l) next) instanceof r));
        if (next instanceof r) {
            return (r) next;
        }
        return null;
    }

    public final void e(Activity activity) {
        Intrinsics.g(activity, "activity");
        q1 q1Var = this.f12926c;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        this.f12926c = j.d(l0.a(i1.a(this.f12925b)), null, null, new FoldingFeatureObserver$registerLayoutStateChangeCallback$1(this, activity, null), 3, null);
    }

    public final void f(a onFoldingFeatureChangeListener) {
        Intrinsics.g(onFoldingFeatureChangeListener, "onFoldingFeatureChangeListener");
        this.f12927d = onFoldingFeatureChangeListener;
    }

    public final void g() {
        q1 q1Var = this.f12926c;
        if (q1Var == null) {
            return;
        }
        q1.a.b(q1Var, null, 1, null);
    }
}
