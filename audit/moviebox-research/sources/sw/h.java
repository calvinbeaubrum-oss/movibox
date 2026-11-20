package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.AdvRecyclerView;
import com.tn.lib.view.TitleLayout;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f76499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AdvRecyclerView f76500b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f76501c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleLayout f76502d;

    public h(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AdvRecyclerView advRecyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull TitleLayout titleLayout) {
        this.f76499a = linearLayoutCompat;
        this.f76500b = advRecyclerView;
        this.f76501c = swipeRefreshLayout;
        this.f76502d = titleLayout;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i11 = R$id.rv_room;
        AdvRecyclerView advRecyclerView = (AdvRecyclerView) n6.b.a(view, i11);
        if (advRecyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.tool_bar;
                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                if (titleLayout != null) {
                    return new h((LinearLayoutCompat) view, advRecyclerView, swipeRefreshLayout, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f76499a;
    }
}
