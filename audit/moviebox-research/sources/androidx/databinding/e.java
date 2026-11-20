package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class e {
    @NonNull
    public List<e> a() {
        return Collections.emptyList();
    }

    public abstract ViewDataBinding b(f fVar, View view, int i11);

    public abstract int c(String str);
}
