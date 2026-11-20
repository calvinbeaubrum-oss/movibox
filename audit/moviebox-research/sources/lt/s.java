package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class s implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f70505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final b0 f70506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f70507d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f70508f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f70509g;

    public s(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull b0 b0Var, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull View view) {
        this.f70504a = frameLayout;
        this.f70505b = frameLayout2;
        this.f70506c = b0Var;
        this.f70507d = recyclerView;
        this.f70508f = swipeRefreshLayout;
        this.f70509g = view;
    }

    @NonNull
    public static s a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.flWidget;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null && (viewA = n6.b.a(view, (i11 = R$id.loading_bg))) != null) {
            b0 b0VarA = b0.a(viewA);
            i11 = R$id.recycleView;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
            if (recyclerView != null) {
                i11 = R$id.swipe_refresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
                if (swipeRefreshLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.trending_header_bg))) != null) {
                    return new s((FrameLayout) view, frameLayout, b0VarA, recyclerView, swipeRefreshLayout, viewA2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static s c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static s d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_trending, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f70504a;
    }
}
