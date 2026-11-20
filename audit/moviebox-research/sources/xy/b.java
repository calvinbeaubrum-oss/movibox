package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f80718a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f80719b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f80720c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80721d;

    public b(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull TitleLayout titleLayout) {
        this.f80718a = linearLayoutCompat;
        this.f80719b = recyclerView;
        this.f80720c = swipeRefreshLayout;
        this.f80721d = titleLayout;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.rvFollow;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.swipeRefresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.titleLayout;
                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                if (titleLayout != null) {
                    return new b((LinearLayoutCompat) view, recyclerView, swipeRefreshLayout, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_follow, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f80718a;
    }
}
