package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75775a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f75776b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75777c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75778d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f75779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final RecyclerView f75780g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75781h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final BLTextView f75782i;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ProgressBar progressBar, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView, @NonNull BLTextView bLTextView) {
        this.f75775a = constraintLayout;
        this.f75776b = view;
        this.f75777c = frameLayout;
        this.f75778d = appCompatImageView;
        this.f75779f = progressBar;
        this.f75780g = recyclerView;
        this.f75781h = appCompatTextView;
        this.f75782i = bLTextView;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.divider;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            i11 = R$id.fl_season_container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.iv_close;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.pb_loading;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.f59795rv;
                        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                        if (recyclerView != null) {
                            i11 = R$id.tv_all_episodes;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_title;
                                BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                                if (bLTextView != null) {
                                    return new b((ConstraintLayout) view, viewA, frameLayout, appCompatImageView, progressBar, recyclerView, appCompatTextView, bLTextView);
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
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_all_episodes, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75775a;
    }
}
