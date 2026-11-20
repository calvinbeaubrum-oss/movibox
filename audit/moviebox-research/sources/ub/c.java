package ub;

import android.view.View;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface c {
    boolean getAddScreenVisibility();

    View getContent();

    boolean isTransparent();

    void setHomeAction(int i11, boolean z11);

    void setHomeVisibility(boolean z11);

    void setTitle(@Nullable String str);

    void setTitleBarVisible(boolean z11);

    void setTitleColor(boolean z11);

    void setTitleVisible(boolean z11);

    void setTransparent(boolean z11);
}
