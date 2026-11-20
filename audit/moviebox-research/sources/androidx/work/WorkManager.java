package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.work.impl.d0;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"AddedAbstractMethod"})
public abstract class WorkManager {

    /* JADX INFO: compiled from: source.java */
    public enum UpdateResult {
        NOT_APPLIED,
        APPLIED_IMMEDIATELY,
        APPLIED_FOR_NEXT_RUN
    }

    @NonNull
    public static WorkManager g(@NonNull Context context) {
        return d0.p(context);
    }

    public static void i(@NonNull Context context, @NonNull a aVar) {
        d0.i(context, aVar);
    }

    @NonNull
    public final p a(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull k kVar) {
        return b(str, existingWorkPolicy, Collections.singletonList(kVar));
    }

    @NonNull
    public abstract p b(@NonNull String str, @NonNull ExistingWorkPolicy existingWorkPolicy, @NonNull List<k> list);

    @NonNull
    public abstract l c(@NonNull String str);

    @NonNull
    public final l d(@NonNull r rVar) {
        return e(Collections.singletonList(rVar));
    }

    @NonNull
    public abstract l e(@NonNull List<? extends r> list);

    @NonNull
    public abstract l f(@NonNull String str, @NonNull ExistingPeriodicWorkPolicy existingPeriodicWorkPolicy, @NonNull m mVar);

    @NonNull
    public abstract LiveData<WorkInfo> h(@NonNull UUID uuid);
}
