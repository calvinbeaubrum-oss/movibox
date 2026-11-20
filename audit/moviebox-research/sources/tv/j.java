package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.AdCountDownView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final NativeWrapperAdView f77795c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AdCountDownView f77796d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77797f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final NativeWrapperAdView f77798g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77799h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77800i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f77801j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ImageView f77802k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final w f77803l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final y f77804m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final a0 f77805n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77806o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final ImageView f77807p;

    public j(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull NativeWrapperAdView nativeWrapperAdView, @NonNull AdCountDownView adCountDownView, @NonNull AppCompatTextView appCompatTextView, @NonNull NativeWrapperAdView nativeWrapperAdView2, @NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull ImageView imageView, @NonNull w wVar, @NonNull y yVar, @NonNull a0 a0Var, @NonNull AppCompatImageView appCompatImageView2, @NonNull ImageView imageView2) {
        this.f77793a = constraintLayout;
        this.f77794b = appCompatImageView;
        this.f77795c = nativeWrapperAdView;
        this.f77796d = adCountDownView;
        this.f77797f = appCompatTextView;
        this.f77798g = nativeWrapperAdView2;
        this.f77799h = frameLayout;
        this.f77800i = constraintLayout2;
        this.f77801j = view;
        this.f77802k = imageView;
        this.f77803l = wVar;
        this.f77804m = yVar;
        this.f77805n = a0Var;
        this.f77806o = appCompatImageView2;
        this.f77807p = imageView2;
    }

    @NonNull
    public static j a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.adCloseView;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.adContainer;
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) n6.b.a(view, i11);
            if (nativeWrapperAdView != null) {
                i11 = R$id.adCountDownView;
                AdCountDownView adCountDownView = (AdCountDownView) n6.b.a(view, i11);
                if (adCountDownView != null) {
                    i11 = R$id.enter_ad_tip;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        i11 = R$id.flLandAd;
                        NativeWrapperAdView nativeWrapperAdView2 = (NativeWrapperAdView) n6.b.a(view, i11);
                        if (nativeWrapperAdView2 != null) {
                            i11 = R$id.flLandAdGroup;
                            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout != null) {
                                i11 = R$id.flPauseAdGroup;
                                ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                if (constraintLayout != null && (viewA = n6.b.a(view, (i11 = R$id.guideline))) != null) {
                                    i11 = R$id.ivAdPauseClose;
                                    ImageView imageView = (ImageView) n6.b.a(view, i11);
                                    if (imageView != null && (viewA2 = n6.b.a(view, (i11 = R$id.local_video_land))) != null) {
                                        w wVarA = w.a(viewA2);
                                        i11 = R$id.local_video_middle;
                                        View viewA3 = n6.b.a(view, i11);
                                        if (viewA3 != null) {
                                            y yVarA = y.a(viewA3);
                                            i11 = R$id.local_video_portrait;
                                            View viewA4 = n6.b.a(view, i11);
                                            if (viewA4 != null) {
                                                a0 a0VarA = a0.a(viewA4);
                                                i11 = R$id.rotate;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                                if (appCompatImageView2 != null) {
                                                    i11 = R$id.v_top_space;
                                                    ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                                                    if (imageView2 != null) {
                                                        return new j((ConstraintLayout) view, appCompatImageView, nativeWrapperAdView, adCountDownView, appCompatTextView, nativeWrapperAdView2, frameLayout, constraintLayout, viewA, imageView, wVarA, yVarA, a0VarA, appCompatImageView2, imageView2);
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
    public static j c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_local_video, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77793a;
    }
}
