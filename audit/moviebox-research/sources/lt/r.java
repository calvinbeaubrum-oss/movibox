package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f70499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final b0 f70500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Guideline f70501d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f70502f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f70503g;

    public r(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull b0 b0Var, @NonNull Guideline guideline, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout) {
        this.f70498a = constraintLayout;
        this.f70499b = view;
        this.f70500c = b0Var;
        this.f70501d = guideline;
        this.f70502f = recyclerView;
        this.f70503g = swipeRefreshLayout;
    }

    @NonNull
    public static r a(@NonNull View view) {
        View viewA;
        int i11 = R$id.sub_operation_header_bg;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null && (viewA = n6.b.a(view, (i11 = R$id.sub_operation_loading))) != null) {
            b0 b0VarA = b0.a(viewA);
            i11 = R$id.sub_operation_main_guide;
            Guideline guideline = (Guideline) n6.b.a(view, i11);
            if (guideline != null) {
                i11 = R$id.sub_operation_main_recycler;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.sub_operation_main_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        return new r((ConstraintLayout) view, viewA2, b0VarA, guideline, recyclerView, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static r c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_sub_tab, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70498a;
    }
}
