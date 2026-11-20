package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f80773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80775d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80776f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80777g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80778h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80779i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80780j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80781k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80782l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80783m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80784n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80785o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80786p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80787q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80788r;

    public e(@NonNull LinearLayout linearLayout, @NonNull AppCompatImageButton appCompatImageButton, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull AppCompatTextView appCompatTextView9, @NonNull AppCompatTextView appCompatTextView10, @NonNull AppCompatTextView appCompatTextView11, @NonNull AppCompatTextView appCompatTextView12, @NonNull AppCompatTextView appCompatTextView13, @NonNull AppCompatTextView appCompatTextView14, @NonNull AppCompatTextView appCompatTextView15) {
        this.f80772a = linearLayout;
        this.f80773b = appCompatImageButton;
        this.f80774c = appCompatTextView;
        this.f80775d = appCompatTextView2;
        this.f80776f = appCompatTextView3;
        this.f80777g = appCompatTextView4;
        this.f80778h = appCompatTextView5;
        this.f80779i = appCompatTextView6;
        this.f80780j = appCompatTextView7;
        this.f80781k = appCompatTextView8;
        this.f80782l = appCompatTextView9;
        this.f80783m = appCompatTextView10;
        this.f80784n = appCompatTextView11;
        this.f80785o = appCompatTextView12;
        this.f80786p = appCompatTextView13;
        this.f80787q = appCompatTextView14;
        this.f80788r = appCompatTextView15;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.btn_back;
        AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
        if (appCompatImageButton != null) {
            i11 = R$id.tv_app_info;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tvChannel;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.tvDebugJS;
                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView3 != null) {
                        i11 = R$id.tv_fps_switch;
                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView4 != null) {
                            i11 = R$id.tvHttpHost;
                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView5 != null) {
                                i11 = R$id.tvIso;
                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView6 != null) {
                                    i11 = R$id.tvKillApp;
                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView7 != null) {
                                        i11 = R$id.tv_lane;
                                        AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView8 != null) {
                                            i11 = R$id.tv_location_mock;
                                            AppCompatTextView appCompatTextView9 = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView9 != null) {
                                                i11 = R$id.tvMiniAppSDKTest;
                                                AppCompatTextView appCompatTextView10 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView10 != null) {
                                                    i11 = R$id.tvNotification;
                                                    AppCompatTextView appCompatTextView11 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView11 != null) {
                                                        i11 = R$id.tv_select_brand;
                                                        AppCompatTextView appCompatTextView12 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView12 != null) {
                                                            i11 = R$id.tvStreaming;
                                                            AppCompatTextView appCompatTextView13 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView13 != null) {
                                                                i11 = R$id.tvTestAd;
                                                                AppCompatTextView appCompatTextView14 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView14 != null) {
                                                                    i11 = R$id.tvWebTest;
                                                                    AppCompatTextView appCompatTextView15 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView15 != null) {
                                                                        return new e((LinearLayout) view, appCompatImageButton, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, appCompatTextView10, appCompatTextView11, appCompatTextView12, appCompatTextView13, appCompatTextView14, appCompatTextView15);
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
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_laboratory, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80772a;
    }
}
