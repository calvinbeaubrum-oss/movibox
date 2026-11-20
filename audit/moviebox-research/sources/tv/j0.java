package tv;

import android.view.View;
import androidx.annotation.NonNull;
import com.tn.lib.view.expand.ExpandView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ExpandView f77808a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ExpandView f77809b;

    public j0(@NonNull ExpandView expandView, @NonNull ExpandView expandView2) {
        this.f77808a = expandView;
        this.f77809b = expandView2;
    }

    @NonNull
    public static j0 a(@NonNull View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        ExpandView expandView = (ExpandView) view;
        return new j0(expandView, expandView);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ExpandView getRoot() {
        return this.f77808a;
    }
}
