package androidx.compose.foundation.lazy.layout;

import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import androidx.compose.runtime.b2;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import okhttp3.internal.http2.Http2Connection;

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
public final class AndroidPrefetchScheduler implements i0, b2, Runnable, Choreographer.FrameCallback {
    private static long frameIntervalNs;
    private long frameStartTimeNanos;
    private boolean isActive;
    private boolean prefetchScheduled;
    private final View view;
    public static final a Companion = new a(null);
    public static final int $stable = 8;
    private final androidx.compose.runtime.collection.b<g0> prefetchRequests = new androidx.compose.runtime.collection.b<>(new g0[16], 0);
    private final Choreographer choreographer = Choreographer.getInstance();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x0021  */
        public final void b(View view) {
            float refreshRate;
            if (AndroidPrefetchScheduler.frameIntervalNs == 0) {
                Display display = view.getDisplay();
                if (view.isInEditMode() || display == null) {
                    refreshRate = 60.0f;
                } else {
                    refreshRate = display.getRefreshRate();
                    if (refreshRate < 30.0f) {
                        refreshRate = 60.0f;
                    }
                }
                AndroidPrefetchScheduler.frameIntervalNs = (long) (Http2Connection.DEGRADED_PONG_TIMEOUT_NS / refreshRate);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements h0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f2596a;

        public b(long j11) {
            this.f2596a = j11;
        }

        @Override // androidx.compose.foundation.lazy.layout.h0
        public long a() {
            return Math.max(0L, this.f2596a - System.nanoTime());
        }
    }

    public AndroidPrefetchScheduler(View view) {
        this.view = view;
        Companion.b(view);
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j11) {
        if (this.isActive) {
            this.frameStartTimeNanos = j11;
            this.view.post(this);
        }
    }

    @Override // androidx.compose.runtime.b2
    public void onAbandoned() {
    }

    @Override // androidx.compose.runtime.b2
    public void onForgotten() {
        this.isActive = false;
        this.view.removeCallbacks(this);
        this.choreographer.removeFrameCallback(this);
    }

    @Override // androidx.compose.runtime.b2
    public void onRemembered() {
        this.isActive = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.prefetchRequests.t() || !this.prefetchScheduled || !this.isActive || this.view.getWindowVisibility() != 0) {
            this.prefetchScheduled = false;
            return;
        }
        b bVar = new b(this.frameStartTimeNanos + frameIntervalNs);
        boolean z11 = false;
        while (this.prefetchRequests.u() && !z11) {
            if (bVar.a() <= 0 || this.prefetchRequests.q()[0].b(bVar)) {
                z11 = true;
            } else {
                this.prefetchRequests.z(0);
            }
        }
        if (z11) {
            this.choreographer.postFrameCallback(this);
        } else {
            this.prefetchScheduled = false;
        }
    }

    @Override // androidx.compose.foundation.lazy.layout.i0
    public void schedulePrefetch(g0 g0Var) {
        this.prefetchRequests.b(g0Var);
        if (this.prefetchScheduled) {
            return;
        }
        this.prefetchScheduled = true;
        this.view.post(this);
    }
}
