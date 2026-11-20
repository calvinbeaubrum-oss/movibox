package androidx.work.impl.utils;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.foreground.SystemForegroundDispatcher;
import java.util.UUID;
import s6.v;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class WorkForegroundUpdater implements androidx.work.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13496d = androidx.work.j.i("WMFgUpdater");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6.c f13497a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final androidx.work.impl.foreground.a f13498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f13499c;

    public WorkForegroundUpdater(@NonNull WorkDatabase workDatabase, @NonNull androidx.work.impl.foreground.a aVar, @NonNull t6.c cVar) {
        this.f13498b = aVar;
        this.f13497a = cVar;
        this.f13499c = workDatabase.N();
    }

    @Override // androidx.work.f
    @NonNull
    public com.google.common.util.concurrent.s<Void> a(@NonNull final Context context, @NonNull final UUID uuid, @NonNull final androidx.work.e eVar) {
        final androidx.work.impl.utils.futures.a aVarX = androidx.work.impl.utils.futures.a.x();
        this.f13497a.c(new Runnable() { // from class: androidx.work.impl.utils.WorkForegroundUpdater.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (!aVarX.isCancelled()) {
                        String string = uuid.toString();
                        s6.u uVarJ = WorkForegroundUpdater.this.f13499c.j(string);
                        if (uVarJ == null || uVarJ.f76200b.isFinished()) {
                            throw new IllegalStateException("Calls to setForegroundAsync() must complete before a ListenableWorker signals completion of work by returning an instance of Result.");
                        }
                        WorkForegroundUpdater.this.f13498b.d(string, eVar);
                        context.startService(SystemForegroundDispatcher.d(context, x.a(uVarJ), eVar));
                    }
                    aVarX.t(null);
                } catch (Throwable th2) {
                    aVarX.u(th2);
                }
            }
        });
        return aVarX;
    }
}
