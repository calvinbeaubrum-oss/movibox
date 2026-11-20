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
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AdTagView f73975b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73976c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73977d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73980h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73981i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73982j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f73983k;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull AdTagView adTagView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatTextView appCompatTextView, @NonNull FrameLayout frameLayout4, @NonNull LinearLayoutCompat linearLayoutCompat) {
        this.f73974a = constraintLayout;
        this.f73975b = adTagView;
        this.f73976c = frameLayout;
        this.f73977d = frameLayout2;
        this.f73978f = frameLayout3;
        this.f73979g = constraintLayout2;
        this.f73980h = appCompatImageView;
        this.f73981i = appCompatTextView;
        this.f73982j = frameLayout4;
        this.f73983k = linearLayoutCompat;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.adIcon;
        AdTagView adTagView = (AdTagView) n6.b.a(view, i11);
        if (adTagView != null) {
            i11 = R$id.container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flCloseContainer;
                FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout2 != null) {
                    i11 = R$id.flVolumeContainer;
                    FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout3 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        i11 = R$id.tvAudio;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.tvCd;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.view;
                                FrameLayout frameLayout4 = (FrameLayout) n6.b.a(view, i11);
                                if (frameLayout4 != null) {
                                    i11 = R$id.viewCd;
                                    LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
                                    if (linearLayoutCompat != null) {
                                        return new b(constraintLayout, adTagView, frameLayout, frameLayout2, frameLayout3, constraintLayout, appCompatImageView, appCompatTextView, frameLayout4, linearLayoutCompat);
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
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_interstitial_half_screen_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73974a;
    }
}
