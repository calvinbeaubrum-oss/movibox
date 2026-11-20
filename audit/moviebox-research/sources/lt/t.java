package lt;

import android.view.View;
import android.view.ViewStub;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R$id;
import com.transsion.home.view.filter.expand.FilterExpandView;
import com.transsion.home.view.filter.expand.TabExpandView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class t implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TabExpandView f70511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FilterExpandView f70512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewStub f70513d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewStub f70514f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewStub f70515g;

    public t(@NonNull ConstraintLayout constraintLayout, @NonNull TabExpandView tabExpandView, @NonNull FilterExpandView filterExpandView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3) {
        this.f70510a = constraintLayout;
        this.f70511b = tabExpandView;
        this.f70512c = filterExpandView;
        this.f70513d = viewStub;
        this.f70514f = viewStub2;
        this.f70515g = viewStub3;
    }

    @NonNull
    public static t a(@NonNull View view) {
        int i11 = R$id.channelExpand;
        TabExpandView tabExpandView = (TabExpandView) n6.b.a(view, i11);
        if (tabExpandView != null) {
            i11 = R$id.filterExpand;
            FilterExpandView filterExpandView = (FilterExpandView) n6.b.a(view, i11);
            if (filterExpandView != null) {
                i11 = R$id.loading_stub;
                ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                if (viewStub != null) {
                    i11 = R$id.no_network_stub;
                    ViewStub viewStub2 = (ViewStub) n6.b.a(view, i11);
                    if (viewStub2 != null) {
                        i11 = R$id.no_result_stub;
                        ViewStub viewStub3 = (ViewStub) n6.b.a(view, i11);
                        if (viewStub3 != null) {
                            return new t((ConstraintLayout) view, tabExpandView, filterExpandView, viewStub, viewStub2, viewStub3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70510a;
    }
}
