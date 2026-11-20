package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.d0;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import s6.j;
import s6.o;
import s6.u;
import s6.v;
import s6.z;
import u6.d;

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
public final class DiagnosticsWorker extends Worker {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiagnosticsWorker(Context context, WorkerParameters parameters) {
        super(context, parameters);
        Intrinsics.g(context, "context");
        Intrinsics.g(parameters, "parameters");
    }

    @Override // androidx.work.Worker
    public i.a doWork() {
        d0 d0VarP = d0.p(getApplicationContext());
        Intrinsics.f(d0VarP, "getInstance(applicationContext)");
        WorkDatabase workDatabaseU = d0VarP.u();
        Intrinsics.f(workDatabaseU, "workManager.workDatabase");
        v vVarN = workDatabaseU.N();
        o oVarL = workDatabaseU.L();
        z zVarO = workDatabaseU.O();
        j jVarK = workDatabaseU.K();
        List<u> listD = vVarN.d(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1L));
        List<u> listW = vVarN.w();
        List<u> listO = vVarN.o(200);
        if (!listD.isEmpty()) {
            androidx.work.j.e().f(d.f78488a, "Recently completed work:\n\n");
            androidx.work.j.e().f(d.f78488a, d.d(oVarL, zVarO, jVarK, listD));
        }
        if (!listW.isEmpty()) {
            androidx.work.j.e().f(d.f78488a, "Running work:\n\n");
            androidx.work.j.e().f(d.f78488a, d.d(oVarL, zVarO, jVarK, listW));
        }
        if (!listO.isEmpty()) {
            androidx.work.j.e().f(d.f78488a, "Enqueued work:\n\n");
            androidx.work.j.e().f(d.f78488a, d.d(oVarL, zVarO, jVarK, listO));
        }
        i.a aVarC = i.a.c();
        Intrinsics.f(aVarC, "success()");
        return aVarC;
    }
}
