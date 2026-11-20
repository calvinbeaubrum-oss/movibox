package pq;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.ad.R$id;
import com.transsion.ad.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Button f74015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Button f74016c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Button f74017d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Button f74018f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Button f74019g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Button f74020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final Button f74021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final Button f74022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final Button f74023k;

    public g(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull Button button5, @NonNull Button button6, @NonNull Button button7, @NonNull Button button8, @NonNull Button button9) {
        this.f74014a = linearLayout;
        this.f74015b = button;
        this.f74016c = button2;
        this.f74017d = button3;
        this.f74018f = button4;
        this.f74019g = button5;
        this.f74020h = button6;
        this.f74021i = button7;
        this.f74022j = button8;
        this.f74023k = button9;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i11 = R$id.btnAdPlanConfig;
        Button button = (Button) n6.b.a(view, i11);
        if (button != null) {
            i11 = R$id.btnLoadBannerAd;
            Button button2 = (Button) n6.b.a(view, i11);
            if (button2 != null) {
                i11 = R$id.btnLoadInterstitialAd;
                Button button3 = (Button) n6.b.a(view, i11);
                if (button3 != null) {
                    i11 = R$id.btnLoadNativeAd;
                    Button button4 = (Button) n6.b.a(view, i11);
                    if (button4 != null) {
                        i11 = R$id.btnLoadNativeListAd;
                        Button button5 = (Button) n6.b.a(view, i11);
                        if (button5 != null) {
                            i11 = R$id.btnLoadSplashAd;
                            Button button6 = (Button) n6.b.a(view, i11);
                            if (button6 != null) {
                                i11 = R$id.btnLoadVideoAd;
                                Button button7 = (Button) n6.b.a(view, i11);
                                if (button7 != null) {
                                    i11 = R$id.btnOtherConfig;
                                    Button button8 = (Button) n6.b.a(view, i11);
                                    if (button8 != null) {
                                        i11 = R$id.btnSceneConfig;
                                        Button button9 = (Button) n6.b.a(view, i11);
                                        if (button9 != null) {
                                            return new g((LinearLayout) view, button, button2, button3, button4, button5, button6, button7, button8, button9);
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
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_test_ad_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f74014a;
    }
}
