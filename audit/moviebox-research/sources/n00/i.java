package n00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.login.R$id;
import com.transsnet.login.R$layout;
import com.transsnet.login.country.widget.SideBar;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f71428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f71429d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SideBar f71430f;

    public i(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull SideBar sideBar) {
        this.f71426a = constraintLayout;
        this.f71427b = appCompatImageView;
        this.f71428c = view;
        this.f71429d = recyclerView;
        this.f71430f = sideBar;
    }

    @NonNull
    public static i a(@NonNull View view) {
        View viewA;
        int i11 = R$id.btn_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
            i11 = R$id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.side_bar;
                SideBar sideBar = (SideBar) n6.b.a(view, i11);
                if (sideBar != null) {
                    return new i((ConstraintLayout) view, appCompatImageView, viewA, recyclerView, sideBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.login_activity_sel_country, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f71426a;
    }
}
