package lt;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.tabs.TabLayout;
import com.transsion.home.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70519a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f70520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70521c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TabLayout f70522d;

    public v(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull ConstraintLayout constraintLayout2, @NonNull TabLayout tabLayout) {
        this.f70519a = constraintLayout;
        this.f70520b = view;
        this.f70521c = constraintLayout2;
        this.f70522d = tabLayout;
    }

    @NonNull
    public static v a(@NonNull View view) {
        int i11 = R$id.divider;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i12 = R$id.tab_movie;
            TabLayout tabLayout = (TabLayout) n6.b.a(view, i12);
            if (tabLayout != null) {
                return new v(constraintLayout, viewA, constraintLayout, tabLayout);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70519a;
    }
}
