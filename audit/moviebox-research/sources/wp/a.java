package wp;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface a extends c {
    com.tn.lib.view.indicator.a getIndicatorConfig();

    @NonNull
    View getIndicatorView();

    void onPageChanged(int i11, int i12);
}
