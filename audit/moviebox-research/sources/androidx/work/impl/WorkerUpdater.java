package androidx.work.impl;

import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.impl.utils.EnqueueRunnable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@JvmName
public final class WorkerUpdater {
    public static final androidx.work.l c(final d0 d0Var, final String name, final androidx.work.r workRequest) {
        Intrinsics.g(d0Var, "<this>");
        Intrinsics.g(name, "name");
        Intrinsics.g(workRequest, "workRequest");
        final o oVar = new o();
        final Function0<Unit> function0 = new Function0<Unit>() { // from class: androidx.work.impl.WorkerUpdater$enqueueUniquelyNamedPeriodic$enqueueNew$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                new EnqueueRunnable(new w(d0Var, name, ExistingWorkPolicy.KEEP, kotlin.collections.f.e(workRequest)), oVar).run();
            }
        };
        d0Var.v().b().execute(new Runnable() { // from class: androidx.work.impl.g0
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.d(d0Var, name, oVar, function0, workRequest);
            }
        });
        return oVar;
    }

    public static final void d(d0 this_enqueueUniquelyNamedPeriodic, String name, o operation, Function0 enqueueNew, androidx.work.r workRequest) {
        Intrinsics.g(this_enqueueUniquelyNamedPeriodic, "$this_enqueueUniquelyNamedPeriodic");
        Intrinsics.g(name, "$name");
        Intrinsics.g(operation, "$operation");
        Intrinsics.g(enqueueNew, "$enqueueNew");
        Intrinsics.g(workRequest, "$workRequest");
        s6.v vVarN = this_enqueueUniquelyNamedPeriodic.u().N();
        List<s6.u.b> listS = vVarN.s(name);
        if (listS.size() > 1) {
            e(operation, "Can't apply UPDATE policy to the chains of work.");
            return;
        }
        s6.u.b bVar = (s6.u.b) CollectionsKt___CollectionsKt.g0(listS);
        if (bVar == null) {
            enqueueNew.invoke();
            return;
        }
        s6.u uVarJ = vVarN.j(bVar.f76219a);
        if (uVarJ == null) {
            operation.a(new androidx.work.l.b.a(new IllegalStateException("WorkSpec with " + bVar.f76219a + ", that matches a name \"" + name + "\", wasn't found")));
            return;
        }
        if (!uVarJ.j()) {
            e(operation, "Can't update OneTimeWorker to Periodic Worker. Update operation must preserve worker's type.");
            return;
        }
        if (bVar.f76220b == WorkInfo.State.CANCELLED) {
            vVarN.a(bVar.f76219a);
            enqueueNew.invoke();
            return;
        }
        s6.u uVarD = workRequest.d();
        s6.u uVarD2 = uVarD.d((1048574 & 1) != 0 ? uVarD.f76199a : bVar.f76219a, (1048574 & 2) != 0 ? uVarD.f76200b : null, (1048574 & 4) != 0 ? uVarD.f76201c : null, (1048574 & 8) != 0 ? uVarD.f76202d : null, (1048574 & 16) != 0 ? uVarD.f76203e : null, (1048574 & 32) != 0 ? uVarD.f76204f : null, (1048574 & 64) != 0 ? uVarD.f76205g : 0L, (1048574 & 128) != 0 ? uVarD.f76206h : 0L, (1048574 & 256) != 0 ? uVarD.f76207i : 0L, (1048574 & 512) != 0 ? uVarD.f76208j : null, (1048574 & 1024) != 0 ? uVarD.f76209k : 0, (1048574 & 2048) != 0 ? uVarD.f76210l : null, (1048574 & 4096) != 0 ? uVarD.f76211m : 0L, (1048574 & 8192) != 0 ? uVarD.f76212n : 0L, (1048574 & 16384) != 0 ? uVarD.f76213o : 0L, (1048574 & 32768) != 0 ? uVarD.f76214p : 0L, (1048574 & 65536) != 0 ? uVarD.f76215q : false, (131072 & 1048574) != 0 ? uVarD.f76216r : null, (1048574 & 262144) != 0 ? uVarD.f76217s : 0, (1048574 & 524288) != 0 ? uVarD.f76218t : 0);
        try {
            Processor processor = this_enqueueUniquelyNamedPeriodic.r();
            Intrinsics.f(processor, "processor");
            WorkDatabase workDatabase = this_enqueueUniquelyNamedPeriodic.u();
            Intrinsics.f(workDatabase, "workDatabase");
            androidx.work.a configuration = this_enqueueUniquelyNamedPeriodic.n();
            Intrinsics.f(configuration, "configuration");
            List<s> schedulers = this_enqueueUniquelyNamedPeriodic.s();
            Intrinsics.f(schedulers, "schedulers");
            f(processor, workDatabase, configuration, schedulers, uVarD2, workRequest.c());
            operation.a(androidx.work.l.f13572a);
        } catch (Throwable th2) {
            operation.a(new androidx.work.l.b.a(th2));
        }
    }

    public static final void e(o oVar, String str) {
        oVar.a(new androidx.work.l.b.a(new UnsupportedOperationException(str)));
    }

    public static final WorkManager.UpdateResult f(Processor processor, final WorkDatabase workDatabase, androidx.work.a aVar, final List<? extends s> list, final s6.u uVar, final Set<String> set) {
        final String str = uVar.f76199a;
        final s6.u uVarJ = workDatabase.N().j(str);
        if (uVarJ == null) {
            throw new IllegalArgumentException("Worker with " + str + " doesn't exist");
        }
        if (uVarJ.f76200b.isFinished()) {
            return WorkManager.UpdateResult.NOT_APPLIED;
        }
        if (uVarJ.j() ^ uVar.j()) {
            WorkerUpdater$updateWorkImpl$type$1 workerUpdater$updateWorkImpl$type$1 = new Function1<s6.u, String>() { // from class: androidx.work.impl.WorkerUpdater$updateWorkImpl$type$1
                @Override // kotlin.jvm.functions.Function1
                public final String invoke(s6.u spec) {
                    Intrinsics.g(spec, "spec");
                    return spec.j() ? "Periodic" : "OneTime";
                }
            };
            throw new UnsupportedOperationException("Can't update " + workerUpdater$updateWorkImpl$type$1.invoke(uVarJ) + " Worker to " + workerUpdater$updateWorkImpl$type$1.invoke(uVar) + " Worker. Update operation must preserve worker's type.");
        }
        final boolean zK = processor.k(str);
        if (!zK) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((s) it.next()).a(str);
            }
        }
        workDatabase.D(new Runnable() { // from class: androidx.work.impl.h0
            @Override // java.lang.Runnable
            public final void run() {
                WorkerUpdater.g(workDatabase, uVar, uVarJ, list, str, set, zK);
            }
        });
        if (!zK) {
            t.b(aVar, workDatabase, list);
        }
        return zK ? WorkManager.UpdateResult.APPLIED_FOR_NEXT_RUN : WorkManager.UpdateResult.APPLIED_IMMEDIATELY;
    }

    public static final void g(WorkDatabase workDatabase, s6.u newWorkSpec, s6.u oldWorkSpec, List schedulers, String workSpecId, Set tags, boolean z11) {
        Intrinsics.g(workDatabase, "$workDatabase");
        Intrinsics.g(newWorkSpec, "$newWorkSpec");
        Intrinsics.g(oldWorkSpec, "$oldWorkSpec");
        Intrinsics.g(schedulers, "$schedulers");
        Intrinsics.g(workSpecId, "$workSpecId");
        Intrinsics.g(tags, "$tags");
        s6.v vVarN = workDatabase.N();
        s6.z zVarO = workDatabase.O();
        vVarN.q(androidx.work.impl.utils.b.c(schedulers, newWorkSpec.d((1048574 & 1) != 0 ? newWorkSpec.f76199a : null, (1048574 & 2) != 0 ? newWorkSpec.f76200b : oldWorkSpec.f76200b, (1048574 & 4) != 0 ? newWorkSpec.f76201c : null, (1048574 & 8) != 0 ? newWorkSpec.f76202d : null, (1048574 & 16) != 0 ? newWorkSpec.f76203e : null, (1048574 & 32) != 0 ? newWorkSpec.f76204f : null, (1048574 & 64) != 0 ? newWorkSpec.f76205g : 0L, (1048574 & 128) != 0 ? newWorkSpec.f76206h : 0L, (1048574 & 256) != 0 ? newWorkSpec.f76207i : 0L, (1048574 & 512) != 0 ? newWorkSpec.f76208j : null, (1048574 & 1024) != 0 ? newWorkSpec.f76209k : oldWorkSpec.f76209k, (1048574 & 2048) != 0 ? newWorkSpec.f76210l : null, (1048574 & 4096) != 0 ? newWorkSpec.f76211m : 0L, (1048574 & 8192) != 0 ? newWorkSpec.f76212n : oldWorkSpec.f76212n, (1048574 & 16384) != 0 ? newWorkSpec.f76213o : 0L, (1048574 & 32768) != 0 ? newWorkSpec.f76214p : 0L, (1048574 & 65536) != 0 ? newWorkSpec.f76215q : false, (131072 & 1048574) != 0 ? newWorkSpec.f76216r : null, (1048574 & 262144) != 0 ? newWorkSpec.f76217s : 0, (1048574 & 524288) != 0 ? newWorkSpec.f76218t : oldWorkSpec.f() + 1)));
        zVarO.c(workSpecId);
        zVarO.d(workSpecId, tags);
        if (z11) {
            return;
        }
        vVarN.r(workSpecId, -1L);
        workDatabase.M().a(workSpecId);
    }
}
