package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.WorkerParameters;
import androidx.work.i;
import androidx.work.impl.d0;
import androidx.work.impl.utils.futures.a;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.j;
import com.google.common.util.concurrent.s;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.f;
import kotlin.jvm.internal.Intrinsics;
import p6.c;
import p6.e;
import r6.n;
import s6.u;
import s6.v;

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
public final class ConstraintTrackingWorker extends i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkerParameters f13559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f13561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<i.a> f13562d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i f13563f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context appContext, WorkerParameters workerParameters) {
        super(appContext, workerParameters);
        Intrinsics.g(appContext, "appContext");
        Intrinsics.g(workerParameters, "workerParameters");
        this.f13559a = workerParameters;
        this.f13560b = new Object();
        this.f13562d = a.x();
    }

    public static final void f(ConstraintTrackingWorker this$0, s innerFuture) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(innerFuture, "$innerFuture");
        synchronized (this$0.f13560b) {
            try {
                if (this$0.f13561c) {
                    a<i.a> future = this$0.f13562d;
                    Intrinsics.f(future, "future");
                    u6.c.e(future);
                } else {
                    this$0.f13562d.v(innerFuture);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public static final void g(ConstraintTrackingWorker this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.d();
    }

    @Override // p6.c
    public void b(List<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
        j.e().a(u6.c.f78487a, "Constraints changed for " + workSpecs);
        synchronized (this.f13560b) {
            this.f13561c = true;
            Unit unit = Unit.f68710a;
        }
    }

    public final void d() {
        if (this.f13562d.isCancelled()) {
            return;
        }
        String strI = getInputData().i("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        j jVarE = j.e();
        Intrinsics.f(jVarE, "get()");
        if (strI == null || strI.length() == 0) {
            jVarE.c(u6.c.f78487a, "No worker to delegate to.");
            a<i.a> future = this.f13562d;
            Intrinsics.f(future, "future");
            u6.c.d(future);
            return;
        }
        i iVarB = getWorkerFactory().b(getApplicationContext(), strI, this.f13559a);
        this.f13563f = iVarB;
        if (iVarB == null) {
            jVarE.a(u6.c.f78487a, "No worker to delegate to.");
            a<i.a> future2 = this.f13562d;
            Intrinsics.f(future2, "future");
            u6.c.d(future2);
            return;
        }
        d0 d0VarP = d0.p(getApplicationContext());
        Intrinsics.f(d0VarP, "getInstance(applicationContext)");
        v vVarN = d0VarP.u().N();
        String string = getId().toString();
        Intrinsics.f(string, "id.toString()");
        u uVarJ = vVarN.j(string);
        if (uVarJ == null) {
            a<i.a> future3 = this.f13562d;
            Intrinsics.f(future3, "future");
            u6.c.d(future3);
            return;
        }
        n nVarT = d0VarP.t();
        Intrinsics.f(nVarT, "workManagerImpl.trackers");
        e eVar = new e(nVarT, this);
        eVar.a(f.e(uVarJ));
        String string2 = getId().toString();
        Intrinsics.f(string2, "id.toString()");
        if (!eVar.d(string2)) {
            jVarE.a(u6.c.f78487a, "Constraints not met for delegate " + strI + ". Requesting retry.");
            a<i.a> future4 = this.f13562d;
            Intrinsics.f(future4, "future");
            u6.c.e(future4);
            return;
        }
        jVarE.a(u6.c.f78487a, "Constraints met for delegate " + strI);
        try {
            i iVar = this.f13563f;
            Intrinsics.d(iVar);
            final s<i.a> sVarStartWork = iVar.startWork();
            Intrinsics.f(sVarStartWork, "delegate!!.startWork()");
            sVarStartWork.addListener(new Runnable() { // from class: u6.b
                @Override // java.lang.Runnable
                public final void run() {
                    ConstraintTrackingWorker.f(this.f78485a, sVarStartWork);
                }
            }, getBackgroundExecutor());
        } catch (Throwable th2) {
            jVarE.b(u6.c.f78487a, "Delegated worker " + strI + " threw exception in startWork.", th2);
            synchronized (this.f13560b) {
                try {
                    if (!this.f13561c) {
                        a<i.a> future5 = this.f13562d;
                        Intrinsics.f(future5, "future");
                        u6.c.d(future5);
                    } else {
                        jVarE.a(u6.c.f78487a, "Constraints were unmet, Retrying.");
                        a<i.a> future6 = this.f13562d;
                        Intrinsics.f(future6, "future");
                        u6.c.e(future6);
                    }
                } catch (Throwable th3) {
                    throw th3;
                }
            }
        }
    }

    @Override // p6.c
    public void e(List<u> workSpecs) {
        Intrinsics.g(workSpecs, "workSpecs");
    }

    @Override // androidx.work.i
    public void onStopped() {
        super.onStopped();
        i iVar = this.f13563f;
        if (iVar == null || iVar.isStopped()) {
            return;
        }
        iVar.stop();
    }

    @Override // androidx.work.i
    public s<i.a> startWork() {
        getBackgroundExecutor().execute(new Runnable() { // from class: u6.a
            @Override // java.lang.Runnable
            public final void run() {
                ConstraintTrackingWorker.g(this.f78484a);
            }
        });
        a<i.a> future = this.f13562d;
        Intrinsics.f(future, "future");
        return future;
    }
}
