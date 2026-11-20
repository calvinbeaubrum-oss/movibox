package androidx.compose.ui.platform;

import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;

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
public final class AndroidUiDispatcher extends CoroutineDispatcher {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final b f5280l = new b(null);

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f5281m = 8;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Lazy<CoroutineContext> f5282n = LazyKt__LazyJVMKt.b(new Function0<CoroutineContext>() { // from class: androidx.compose.ui.platform.AndroidUiDispatcher$Companion$Main$2
        @Override // kotlin.jvm.functions.Function0
        public final CoroutineContext invoke() {
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(p0.b() ? Choreographer.getInstance() : (Choreographer) kotlinx.coroutines.h.e(kotlinx.coroutines.w0.c(), new AndroidUiDispatcher$Companion$Main$2$dispatcher$1(null)), androidx.core.os.g.a(Looper.getMainLooper()), null);
            return androidUiDispatcher.plus(androidUiDispatcher.W());
        }
    });

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final ThreadLocal<CoroutineContext> f5283o = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Choreographer f5284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f5285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayDeque<Runnable> f5287d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<Choreographer.FrameCallback> f5288f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<Choreographer.FrameCallback> f5289g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5290h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f5291i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final AndroidUiDispatcher$dispatchCallback$1 f5292j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final androidx.compose.runtime.u0 f5293k;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a extends ThreadLocal<CoroutineContext> {
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CoroutineContext initialValue() {
            Choreographer choreographer = Choreographer.getInstance();
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper == null) {
                throw new IllegalStateException("no Looper on this thread".toString());
            }
            AndroidUiDispatcher androidUiDispatcher = new AndroidUiDispatcher(choreographer, androidx.core.os.g.a(looperMyLooper), null);
            return androidUiDispatcher.plus(androidUiDispatcher.W());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {
        public b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CoroutineContext a() {
            if (p0.b()) {
                return b();
            }
            CoroutineContext coroutineContext = (CoroutineContext) AndroidUiDispatcher.f5283o.get();
            if (coroutineContext != null) {
                return coroutineContext;
            }
            throw new IllegalStateException("no AndroidUiDispatcher for this thread".toString());
        }

        public final CoroutineContext b() {
            return (CoroutineContext) AndroidUiDispatcher.f5282n.getValue();
        }
    }

    public AndroidUiDispatcher(Choreographer choreographer, Handler handler) {
        this.f5284a = choreographer;
        this.f5285b = handler;
        this.f5286c = new Object();
        this.f5287d = new ArrayDeque<>();
        this.f5288f = new ArrayList();
        this.f5289g = new ArrayList();
        this.f5292j = new AndroidUiDispatcher$dispatchCallback$1(this);
        this.f5293k = new AndroidUiFrameClock(choreographer, this);
    }

    public /* synthetic */ AndroidUiDispatcher(Choreographer choreographer, Handler handler, DefaultConstructorMarker defaultConstructorMarker) {
        this(choreographer, handler);
    }

    public final Choreographer U() {
        return this.f5284a;
    }

    public final androidx.compose.runtime.u0 W() {
        return this.f5293k;
    }

    public final Runnable Z() {
        Runnable runnableV;
        synchronized (this.f5286c) {
            runnableV = this.f5287d.v();
        }
        return runnableV;
    }

    public final void b0(long j11) {
        synchronized (this.f5286c) {
            if (this.f5291i) {
                this.f5291i = false;
                List<Choreographer.FrameCallback> list = this.f5288f;
                this.f5288f = this.f5289g;
                this.f5289g = list;
                int size = list.size();
                for (int i11 = 0; i11 < size; i11++) {
                    list.get(i11).doFrame(j11);
                }
                list.clear();
            }
        }
    }

    public final void d0() {
        boolean z11;
        do {
            Runnable runnableZ = Z();
            while (runnableZ != null) {
                runnableZ.run();
                runnableZ = Z();
            }
            synchronized (this.f5286c) {
                if (this.f5287d.isEmpty()) {
                    z11 = false;
                    this.f5290h = false;
                } else {
                    z11 = true;
                }
            }
        } while (z11);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        synchronized (this.f5286c) {
            try {
                this.f5287d.addLast(runnable);
                if (!this.f5290h) {
                    this.f5290h = true;
                    this.f5285b.post(this.f5292j);
                    if (!this.f5291i) {
                        this.f5291i = true;
                        this.f5284a.postFrameCallback(this.f5292j);
                    }
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void e0(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f5286c) {
            try {
                this.f5288f.add(frameCallback);
                if (!this.f5291i) {
                    this.f5291i = true;
                    this.f5284a.postFrameCallback(this.f5292j);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g0(Choreographer.FrameCallback frameCallback) {
        synchronized (this.f5286c) {
            this.f5288f.remove(frameCallback);
        }
    }
}
