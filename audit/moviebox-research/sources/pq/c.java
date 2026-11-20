package pq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;
import com.transsion.ad.view.AdTagView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AdTagView f73985b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73986c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73987d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f73988f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73989g;

    public c(@NonNull ConstraintLayout constraintLayout, @NonNull AdTagView adTagView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull AppCompatTextView appCompatTextView) {
        this.f73984a = constraintLayout;
        this.f73985b = adTagView;
        this.f73986c = frameLayout;
        this.f73987d = frameLayout2;
        this.f73988f = frameLayout3;
        this.f73989g = appCompatTextView;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.adIcon;
        AdTagView adTagView = (AdTagView) n6.b.a(view, i11);
        if (adTagView != null) {
            i11 = R$id.container;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.flVolumeContainer;
                FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout2 != null) {
                    i11 = R$id.movieBoxLayout;
                    FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout3 != null) {
                        i11 = R$id.tvCountDown;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            return new c((ConstraintLayout) view, adTagView, frameLayout, frameLayout2, frameLayout3, appCompatTextView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_bidding_buy_out_splash, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f73984a;
    }
}
