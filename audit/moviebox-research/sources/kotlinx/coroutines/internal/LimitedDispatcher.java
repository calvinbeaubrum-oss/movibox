package kotlinx.coroutines.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.q0;
import kotlinx.coroutines.y0;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class LimitedDispatcher extends CoroutineDispatcher implements q0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f69436g = AtomicIntegerFieldUpdater.newUpdater(LimitedDispatcher.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineDispatcher f69437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f69438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ q0 f69439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final p<Runnable> f69440d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f69441f;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes8.dex */
    @Metadata
    public final class Worker implements Runnable {
        private Runnable currentTask;

        public Worker(Runnable runnable) {
            this.currentTask = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i11 = 0;
            while (true) {
                try {
                    this.currentTask.run();
                } catch (Throwable th2) {
                    kotlinx.coroutines.h0.a(EmptyCoroutineContext.INSTANCE, th2);
                }
                Runnable runnableT = LimitedDispatcher.this.t();
                if (runnableT == null) {
                    return;
                }
                this.currentTask = runnableT;
                i11++;
                if (i11 >= 16 && LimitedDispatcher.this.f69437a.isDispatchNeeded(LimitedDispatcher.this)) {
                    LimitedDispatcher.this.f69437a.dispatch(LimitedDispatcher.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LimitedDispatcher(CoroutineDispatcher coroutineDispatcher, int i11) {
        this.f69437a = coroutineDispatcher;
        this.f69438b = i11;
        q0 q0Var = coroutineDispatcher instanceof q0 ? (q0) coroutineDispatcher : null;
        this.f69439c = q0Var == null ? n0.a() : q0Var;
        this.f69440d = new p<>(false);
        this.f69441f = new Object();
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableT;
        this.f69440d.a(runnable);
        if (f69436g.get(this) >= this.f69438b || !u() || (runnableT = t()) == null) {
            return;
        }
        this.f69437a.dispatch(this, new Worker(runnableT));
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatchYield(CoroutineContext coroutineContext, Runnable runnable) {
        Runnable runnableT;
        this.f69440d.a(runnable);
        if (f69436g.get(this) >= this.f69438b || !u() || (runnableT = t()) == null) {
            return;
        }
        this.f69437a.dispatchYield(this, new Worker(runnableT));
    }

    @Override // kotlinx.coroutines.q0
    public y0 invokeOnTimeout(long j11, Runnable runnable, CoroutineContext coroutineContext) {
        return this.f69439c.invokeOnTimeout(j11, runnable, coroutineContext);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public CoroutineDispatcher limitedParallelism(int i11) {
        m.a(i11);
        return i11 >= this.f69438b ? this : super.limitedParallelism(i11);
    }

    @Override // kotlinx.coroutines.q0
    public void scheduleResumeAfterDelay(long j11, kotlinx.coroutines.n<? super Unit> nVar) {
        this.f69439c.scheduleResumeAfterDelay(j11, nVar);
    }

    public final Runnable t() {
        while (true) {
            Runnable runnableE = this.f69440d.e();
            if (runnableE != null) {
                return runnableE;
            }
            synchronized (this.f69441f) {
                f69436g.decrementAndGet(this);
                if (this.f69440d.c() == 0) {
                    return null;
                }
                f69436g.incrementAndGet(this);
            }
        }
    }

    public final boolean u() {
        synchronized (this.f69441f) {
            if (f69436g.get(this) >= this.f69438b) {
                return false;
            }
            f69436g.incrementAndGet(this);
            return true;
        }
    }
}
