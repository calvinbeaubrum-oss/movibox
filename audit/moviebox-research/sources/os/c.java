package os;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.commercialization.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f73365a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CardView f73366b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73367c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73368d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f73369f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73370g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f73371h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final NativeWrapperAdView f73372i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f73373j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f73374k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f73375l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f73376m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f73377n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final View f73378o;

    public c(@NonNull LinearLayout linearLayout, @NonNull CardView cardView, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatTextView appCompatTextView, @NonNull ConstraintLayout constraintLayout2, @NonNull NativeWrapperAdView nativeWrapperAdView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull AppCompatTextView appCompatTextView2, @NonNull TextView textView3, @NonNull View view, @NonNull View view2) {
        this.f73365a = linearLayout;
        this.f73366b = cardView;
        this.f73367c = constraintLayout;
        this.f73368d = appCompatImageView;
        this.f73369f = appCompatImageView2;
        this.f73370g = appCompatTextView;
        this.f73371h = constraintLayout2;
        this.f73372i = nativeWrapperAdView;
        this.f73373j = textView;
        this.f73374k = textView2;
        this.f73375l = appCompatTextView2;
        this.f73376m = textView3;
        this.f73377n = view;
        this.f73378o = view2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.cardView;
        CardView cardView = (CardView) n6.b.a(view, i11);
        if (cardView != null) {
            i11 = R$id.cl2MemberInfo;
            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ivClose;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivIcon;
                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView2 != null) {
                        i11 = R$id.ivPremium;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.llContent;
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout2 != null) {
                                i11 = R$id.nativeWrapperAdView;
                                NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) n6.b.a(view, i11);
                                if (nativeWrapperAdView != null) {
                                    i11 = R$id.tvGetAd;
                                    TextView textView = (TextView) n6.b.a(view, i11);
                                    if (textView != null) {
                                        i11 = R$id.tvGo2Integral;
                                        TextView textView2 = (TextView) n6.b.a(view, i11);
                                        if (textView2 != null) {
                                            i11 = R$id.tvOr;
                                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView2 != null) {
                                                i11 = R$id.tvTips;
                                                TextView textView3 = (TextView) n6.b.a(view, i11);
                                                if (textView3 != null && (viewA = n6.b.a(view, (i11 = R$id.viewLineL))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.viewLineR))) != null) {
                                                    return new c((LinearLayout) view, cardView, constraintLayout, appCompatImageView, appCompatImageView2, appCompatTextView, constraintLayout2, nativeWrapperAdView, textView, textView2, appCompatTextView2, textView3, viewA, viewA2);
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

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f73365a;
    }
}
