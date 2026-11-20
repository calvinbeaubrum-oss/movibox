package cv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.payment.lib.R$id;
import com.transsion.payment.lib.R$layout;
import yp.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f62812a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f62813b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f62814c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f62815d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f62816f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f62817g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f62818h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f62819i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f62820j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final f f62821k;

    public b(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull ProgressBar progressBar, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull f fVar) {
        this.f62812a = linearLayoutCompat;
        this.f62813b = frameLayout;
        this.f62814c = appCompatImageView;
        this.f62815d = appCompatImageView2;
        this.f62816f = appCompatImageView3;
        this.f62817g = progressBar;
        this.f62818h = linearLayoutCompat2;
        this.f62819i = constraintLayout;
        this.f62820j = appCompatTextView;
        this.f62821k = fVar;
    }

    @NonNull
    public static b a(@NonNull View view) {
        View viewA;
        int i11 = R$id.fl_web;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.iv_back;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_close;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_right;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.progress;
                        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                        if (progressBar != null) {
                            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                            i11 = R$id.tool_bar;
                            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.tv_titleText;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null && (viewA = n6.b.a(view, (i11 = R$id.web_pay_include_loading))) != null) {
                                    return new b(linearLayoutCompat, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, progressBar, linearLayoutCompat, constraintLayout, appCompatTextView, f.a(viewA));
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
        View viewInflate = layoutInflater.inflate(R$layout.fragment_web_pay, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f62812a;
    }
}
