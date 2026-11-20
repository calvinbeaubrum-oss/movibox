package iu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.transsion.lib_web.R$id;
import com.transsion.lib_web.R$layout;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f67701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BridgeWebView f67702b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f67703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f67704d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f67705f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f67706g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ProgressBar f67707h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f67708i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f67709j;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull BridgeWebView bridgeWebView, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull ProgressBar progressBar, @NonNull View view, @NonNull AppCompatTextView appCompatTextView) {
        this.f67701a = constraintLayout;
        this.f67702b = bridgeWebView;
        this.f67703c = appCompatImageView;
        this.f67704d = appCompatImageView2;
        this.f67705f = appCompatImageView3;
        this.f67706g = linearLayoutCompat;
        this.f67707h = progressBar;
        this.f67708i = view;
        this.f67709j = appCompatTextView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewA;
        int i11 = R$id.bridgeWebView;
        BridgeWebView bridgeWebView = (BridgeWebView) b.a(view, i11);
        if (bridgeWebView != null) {
            i11 = R$id.ivBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.ivClose;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.ivRight;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        i11 = R$id.llToolBar;
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) b.a(view, i11);
                        if (linearLayoutCompat != null) {
                            i11 = R$id.progressBar;
                            ProgressBar progressBar = (ProgressBar) b.a(view, i11);
                            if (progressBar != null && (viewA = b.a(view, (i11 = R$id.subWebHeaderBg))) != null) {
                                i11 = R$id.tvTitle;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) b.a(view, i11);
                                if (appCompatTextView != null) {
                                    return new a((ConstraintLayout) view, bridgeWebView, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, progressBar, viewA, appCompatTextView);
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
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.lib_web_web_fragment_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f67701a;
    }
}
