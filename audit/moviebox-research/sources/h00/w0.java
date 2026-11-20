package h00;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class w0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f66072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f66073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f66074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66075d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f66076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CircleProgressBar f66077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RecyclerView f66078h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66079i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66080j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66081k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66082l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final View f66083m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f66084n;

    public w0(@NonNull ConstraintLayout constraintLayout, @NonNull BLFrameLayout bLFrameLayout, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull CircleProgressBar circleProgressBar, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull View view2, @NonNull View view3) {
        this.f66072a = constraintLayout;
        this.f66073b = bLFrameLayout;
        this.f66074c = imageView;
        this.f66075d = appCompatImageView;
        this.f66076f = view;
        this.f66077g = circleProgressBar;
        this.f66078h = recyclerView;
        this.f66079i = appCompatTextView;
        this.f66080j = appCompatTextView2;
        this.f66081k = appCompatTextView3;
        this.f66082l = appCompatTextView4;
        this.f66083m = view2;
        this.f66084n = view3;
    }

    @NonNull
    public static w0 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        int i11 = R$id.fl_loading;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_close;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.iv_save_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null && (viewA = n6.b.a(view, (i11 = R$id.line))) != null) {
                    i11 = R$id.progress_bar;
                    CircleProgressBar circleProgressBar = (CircleProgressBar) n6.b.a(view, i11);
                    if (circleProgressBar != null) {
                        i11 = R$id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.tv_btn_confirm;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_progress;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.tv_tips;
                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView3 != null) {
                                        i11 = R$id.tv_title;
                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView4 != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_bottom))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_loading_intercept))) != null) {
                                            return new w0((ConstraintLayout) view, bLFrameLayout, imageView, appCompatImageView, viewA, circleProgressBar, recyclerView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, viewA2, viewA3);
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

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f66072a;
    }
}
