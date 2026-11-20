package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.view.filter.popup.PopupFilterView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70469a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final v f70470b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f70471c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final PopupFilterView f70472d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f70473f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f70474g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f70475h;

    public l(@NonNull LinearLayout linearLayout, @NonNull v vVar, @NonNull RecyclerView recyclerView, @NonNull PopupFilterView popupFilterView, @NonNull View view, @NonNull View view2, @NonNull SwipeRefreshLayout swipeRefreshLayout) {
        this.f70469a = linearLayout;
        this.f70470b = vVar;
        this.f70471c = recyclerView;
        this.f70472d = popupFilterView;
        this.f70473f = view;
        this.f70474g = view2;
        this.f70475h = swipeRefreshLayout;
    }

    @NonNull
    public static l a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.ll_tab_movie;
        View viewA3 = n6.b.a(view, i11);
        if (viewA3 != null) {
            v vVarA = v.a(viewA3);
            i11 = R$id.movie_list;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.popup_filter_view;
                PopupFilterView popupFilterView = (PopupFilterView) n6.b.a(view, i11);
                if (popupFilterView != null && (viewA = n6.b.a(view, (i11 = R$id.popup_filter_view_linear))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.sub_movie_header_bg))) != null) {
                    i11 = R$id.swipe_refresh;
                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
                    if (swipeRefreshLayout != null) {
                        return new l((LinearLayout) view, vVarA, recyclerView, popupFilterView, viewA, viewA2, swipeRefreshLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static l c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static l d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_movie, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70469a;
    }
}
