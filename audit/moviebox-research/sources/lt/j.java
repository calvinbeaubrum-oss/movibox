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

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final u f70451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final RecyclerView f70452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f70453d;

    public j(@NonNull LinearLayout linearLayout, @NonNull u uVar, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout) {
        this.f70450a = linearLayout;
        this.f70451b = uVar;
        this.f70452c = recyclerView;
        this.f70453d = swipeRefreshLayout;
    }

    @NonNull
    public static j a(@NonNull View view) {
        int i11 = R$id.ll_tab_filter;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            u uVarA = u.a(viewA);
            int i12 = R$id.movie_list;
            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i12);
            if (recyclerView != null) {
                i12 = R$id.swipe_refresh;
                SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i12);
                if (swipeRefreshLayout != null) {
                    return new j((LinearLayout) view, uVarA, recyclerView, swipeRefreshLayout);
                }
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static j c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_filter, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70450a;
    }
}
