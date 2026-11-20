package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.shorttv.widget.ShortTVBannerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ShortTVBannerView f77917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f77919d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f77920f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77921g;

    public r0(@NonNull ConstraintLayout constraintLayout, @NonNull ShortTVBannerView shortTVBannerView, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.f77916a = constraintLayout;
        this.f77917b = shortTVBannerView;
        this.f77918c = constraintLayout2;
        this.f77919d = view;
        this.f77920f = view2;
        this.f77921g = view3;
    }

    @NonNull
    public static r0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.banner;
        ShortTVBannerView shortTVBannerView = (ShortTVBannerView) n6.b.a(view, i11);
        if (shortTVBannerView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.v_banner_bg;
            View viewA3 = n6.b.a(view, i11);
            if (viewA3 != null && (viewA = n6.b.a(view, (i11 = R$id.v_bar_space))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_top_space))) != null) {
                return new r0(constraintLayout, shortTVBannerView, constraintLayout, viewA3, viewA, viewA2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static r0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static r0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.view_short_tv_banner, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77916a;
    }
}
