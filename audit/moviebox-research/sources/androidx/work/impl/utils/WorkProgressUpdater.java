package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class WorkProgressUpdater implements androidx.work.n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f13500c = androidx.work.j.i("WorkProgressUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WorkDatabase f13501a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t6.c f13502b;

    public WorkProgressUpdater(@NonNull WorkDatabase workDatabase, @NonNull t6.c cVar) {
        this.f13501a = workDatabase;
        this.f13502b = cVar;
    }

    @Override // androidx.work.n
    @NonNull
    public com.google.common.util.concurrent.s<Void> a(@NonNull Context context, @NonNull final UUID uuid, @NonNull final androidx.work.d dVar) {
        final androidx.work.impl.utils.futures.a aVarX = androidx.work.impl.utils.futures.a.x();
        this.f13502b.c(new Runnable() { // from class: androidx.work.impl.utils.WorkProgressUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                String string = uuid.toString();
                androidx.work.j jVarE = androidx.work.j.e();
                String str = WorkProgressUpdater.f13500c;
                jVarE.a(str, "Updating progress for " + uuid + " (" + dVar + ")");
                WorkProgressUpdater.this.f13501a.e();
                try {
                    s6.u uVarJ = WorkProgressUpdater.this.f13501a.N().j(string);
                    if (uVarJ == null) {
                        throw new IllegalStateException("Calls to setProgressAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                    }
                    if (uVarJ.f76200b == WorkInfo.State.RUNNING) {
                        WorkProgressUpdater.this.f13501a.M().b(new s6.q(string, dVar));
                    } else {
                        androidx.work.j.e().k(str, "Ignoring setProgressAsync(...). WorkSpec (" + string + ") is not in a RUNNING state.");
                    }
                    aVarX.t(null);
                    WorkProgressUpdater.this.f13501a.E();
                } catch (Throwable th2) {
                    try {
                        androidx.work.j.e().d(WorkProgressUpdater.f13500c, "Error updating Worker progress", th2);
                        aVarX.u(th2);
                    } finally {
                        WorkProgressUpdater.this.f13501a.i();
                    }
                }
            }
        });
        return aVarX;
    }
}
