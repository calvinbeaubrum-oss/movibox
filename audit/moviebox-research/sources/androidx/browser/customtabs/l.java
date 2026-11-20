package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface l {
    void onGreatestScrollPercentageIncreased(int i11, @NonNull Bundle bundle);

    void onSessionEnded(boolean z11, @NonNull Bundle bundle);

    void onVerticalScrollEvent(boolean z11, @NonNull Bundle bundle);
}
