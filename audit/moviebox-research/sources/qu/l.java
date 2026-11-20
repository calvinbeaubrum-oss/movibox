package qu;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74981a;

    public l(@NonNull ConstraintLayout constraintLayout) {
        this.f74981a = constraintLayout;
    }

    @NonNull
    public static l a(@NonNull View view) {
        if (view != null) {
            return new l((ConstraintLayout) view);
        }
        throw new NullPointerException("rootView");
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f74981a;
    }
}
