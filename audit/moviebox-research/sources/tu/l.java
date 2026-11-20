package tu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.moviedetail.R$id;
import com.transsion.moviedetail.R$layout;
import com.transsion.moviedetail.view.WatchModeTipsView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77529c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77530d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77531f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f77532g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77533h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77534i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77535j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final WatchModeTipsView f77536k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final RecyclerView f77537l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final BLTextView f77538m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final BLTextView f77539n;

    public l(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull BLTextView bLTextView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull WatchModeTipsView watchModeTipsView, @NonNull RecyclerView recyclerView, @NonNull BLTextView bLTextView2, @NonNull BLTextView bLTextView3) {
        this.f77527a = constraintLayout;
        this.f77528b = appCompatImageView;
        this.f77529c = appCompatTextView;
        this.f77530d = appCompatTextView2;
        this.f77531f = appCompatTextView3;
        this.f77532g = bLTextView;
        this.f77533h = frameLayout;
        this.f77534i = linearLayout;
        this.f77535j = progressBar;
        this.f77536k = watchModeTipsView;
        this.f77537l = recyclerView;
        this.f77538m = bLTextView2;
        this.f77539n = bLTextView3;
    }

    @NonNull
    public static l a(@NonNull View view) {
        int i11 = R$id.innerIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.innerTvInfo;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.innerTvName;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.innerTvTitle;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.iv_seasons;
                        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                        if (bLTextView != null) {
                            i11 = R$id.lf_loading;
                            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.llLanguage;
                                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                if (linearLayout != null) {
                                    i11 = R$id.load_view;
                                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                    if (progressBar != null) {
                                        i11 = R$id.modeTipsLayout;
                                        WatchModeTipsView watchModeTipsView = (WatchModeTipsView) n6.b.a(view, i11);
                                        if (watchModeTipsView != null) {
                                            i11 = R$id.resourceRv;
                                            RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                                            if (recyclerView != null) {
                                                i11 = R$id.tvLanguage;
                                                BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                                                if (bLTextView2 != null) {
                                                    i11 = R$id.tv_more;
                                                    BLTextView bLTextView3 = (BLTextView) n6.b.a(view, i11);
                                                    if (bLTextView3 != null) {
                                                        return new l((ConstraintLayout) view, appCompatImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, bLTextView, frameLayout, linearLayout, progressBar, watchModeTipsView, recyclerView, bLTextView2, bLTextView3);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_resource_detector_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77527a;
    }
}
