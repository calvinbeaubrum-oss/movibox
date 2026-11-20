package ra;

import android.view.Choreographer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f75171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static long f75172c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f75170a = new b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<ra.a> f75173d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f75174e = new a();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a implements Choreographer.FrameCallback {
        @Override // android.view.Choreographer.FrameCallback
        public void doFrame(long j11) {
            if (0 != b.f75172c) {
                long j12 = (j11 - b.f75172c) / ((long) 1000000);
                Iterator it = b.f75173d.iterator();
                while (it.hasNext()) {
                    ((ra.a) it.next()).a(System.currentTimeMillis(), j12);
                }
            }
            b.f75172c = j11;
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    public void d(ra.a frameListener) {
        Intrinsics.g(frameListener, "frameListener");
        List<ra.a> list = f75173d;
        synchronized (list) {
            try {
                if (!list.contains(frameListener)) {
                    list.add(frameListener);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void e(boolean z11) {
        if (z11 == f75171b) {
            return;
        }
        Iterator<T> it = f75173d.iterator();
        while (it.hasNext()) {
            ((ra.a) it.next()).b(z11);
        }
        if (z11) {
            Choreographer.getInstance().postFrameCallback(f75174e);
        } else {
            Choreographer.getInstance().removeFrameCallback(f75174e);
        }
        f75171b = z11;
    }
}
