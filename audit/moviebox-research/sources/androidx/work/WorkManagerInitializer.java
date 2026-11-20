package androidx.work;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class WorkManagerInitializer implements i6.b<WorkManager> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f13240a = j.i("WrkMgrInitializer");

    @Override // i6.b
    @NonNull
    public List<Class<? extends i6.b<?>>> a() {
        return Collections.emptyList();
    }

    @Override // i6.b
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public WorkManager create(@NonNull Context context) {
        j.e().a(f13240a, "Initializing WorkManager with default configuration.");
        WorkManager.i(context, new a.b().a());
        return WorkManager.g(context);
    }
}
