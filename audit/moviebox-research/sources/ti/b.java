package ti;

import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public interface b {
    void cancelBackProgress();

    void handleBackInvoked();

    void startBackProgress(@NonNull androidx.activity.b bVar);

    void updateBackProgress(@NonNull androidx.activity.b bVar);
}
