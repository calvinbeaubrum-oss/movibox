package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class q implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77901a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77902b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f77903c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Space f77904d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f77905f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77906g;

    public q(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull Space space, @NonNull View view, @NonNull View view2) {
        this.f77901a = constraintLayout;
        this.f77902b = recyclerView;
        this.f77903c = swipeRefreshLayout;
        this.f77904d = space;
        this.f77905f = view;
        this.f77906g = view2;
    }

    @NonNull
    public static q a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.top_guideline;
                Space space = (Space) n6.b.a(view, i11);
                if (space != null && (viewA = n6.b.a(view, (i11 = R$id.v_bar_space))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_top_bg))) != null) {
                    return new q((ConstraintLayout) view, recyclerView, swipeRefreshLayout, space, viewA, viewA2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static q c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static q d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_short_tv_discover, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77901a;
    }
}
