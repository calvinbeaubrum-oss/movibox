package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.TitleLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f66027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f66028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TitleLayout f66029d;

    public t(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull TitleLayout titleLayout) {
        this.f66026a = constraintLayout;
        this.f66027b = recyclerView;
        this.f66028c = swipeRefreshLayout;
        this.f66029d = titleLayout;
    }

    @NonNull
    public static t a(@NonNull View view) {
        int i11 = R$id.historyRv;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.titleLayout;
                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                if (titleLayout != null) {
                    return new t((ConstraintLayout) view, recyclerView, swipeRefreshLayout, titleLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static t c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static t d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_all_historical_play_record, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66026a;
    }
}
