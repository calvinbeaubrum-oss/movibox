package pq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AdTagView f73991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73993d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73995g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73996h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73997i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73998j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f73999k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74000l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74001m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74002n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f74003o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74004p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74005q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74006r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74007s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f74008t;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull AdTagView adTagView, @NonNull ConstraintLayout constraintLayout2, @NonNull ConstraintLayout constraintLayout3, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ConstraintLayout constraintLayout4, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull ShapeableImageView shapeableImageView2, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull LinearLayoutCompat linearLayoutCompat) {
        this.f73990a = constraintLayout;
        this.f73991b = adTagView;
        this.f73992c = constraintLayout2;
        this.f73993d = constraintLayout3;
        this.f73994f = frameLayout;
        this.f73995g = frameLayout2;
        this.f73996h = appCompatImageView;
        this.f73997i = appCompatImageView2;
        this.f73998j = constraintLayout4;
        this.f73999k = shapeableImageView;
        this.f74000l = appCompatTextView;
        this.f74001m = appCompatTextView2;
        this.f74002n = appCompatTextView3;
        this.f74003o = shapeableImageView2;
        this.f74004p = appCompatTextView4;
        this.f74005q = appCompatTextView5;
        this.f74006r = appCompatTextView6;
        this.f74007s = appCompatTextView7;
        this.f74008t = linearLayoutCompat;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.adIcon;
        AdTagView adTagView = (AdTagView) n6.b.a(view, i11);
        if (adTagView != null) {
            i11 = R$id.clAdEndLayout;
            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.clAdInfo;
                ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                if (constraintLayout2 != null) {
                    i11 = R$id.container;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.flVolumeContainer;
                        FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout2 != null) {
                            i11 = R$id.ivAdClose;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.ivClose;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    ConstraintLayout constraintLayout3 = (ConstraintLayout) view;
                                    i11 = R$id.tvAdAvatar;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                    if (shapeableImageView != null) {
                                        i11 = R$id.tvAdBtn;
                                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView != null) {
                                            i11 = R$id.tvAdDesc;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tvAdTitle;
                                                AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView3 != null) {
                                                    i11 = R$id.tvAvatar;
                                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                                                    if (shapeableImageView2 != null) {
                                                        i11 = R$id.tvBtn;
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView4 != null) {
                                                            i11 = R$id.tvCd;
                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView5 != null) {
                                                                i11 = R$id.tvDesc;
                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView6 != null) {
                                                                    i11 = R$id.tvTitle;
                                                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView7 != null) {
                                                                        i11 = R$id.viewCd;
                                                                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                                                        if (linearLayoutCompat != null) {
                                                                            return new d(constraintLayout3, adTagView, constraintLayout, constraintLayout2, frameLayout, frameLayout2, appCompatImageView, appCompatImageView2, constraintLayout3, shapeableImageView, appCompatTextView, appCompatTextView2, appCompatTextView3, shapeableImageView2, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, linearLayoutCompat);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static d c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static d d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_video_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73990a;
    }
}
