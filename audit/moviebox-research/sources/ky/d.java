package ky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.SwitchButton;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f69670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f69671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Group f69672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f69673d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f69674f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f69675g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f69676h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ProgressBar f69677i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final SwitchButton f69678j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TitleLayout f69679k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69680l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69681m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69682n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69683o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69684p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69685q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f69686r;

    public d(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull Group group, @NonNull Group group2, @NonNull AppCompatImageView appCompatImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull LinearLayout linearLayout, @NonNull ConstraintLayout constraintLayout, @NonNull ProgressBar progressBar, @NonNull SwitchButton switchButton, @NonNull TitleLayout titleLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7) {
        this.f69670a = linearLayoutCompat;
        this.f69671b = group;
        this.f69672c = group2;
        this.f69673d = appCompatImageView;
        this.f69674f = shapeableImageView;
        this.f69675g = linearLayout;
        this.f69676h = constraintLayout;
        this.f69677i = progressBar;
        this.f69678j = switchButton;
        this.f69679k = titleLayout;
        this.f69680l = appCompatTextView;
        this.f69681m = appCompatTextView2;
        this.f69682n = appCompatTextView3;
        this.f69683o = appCompatTextView4;
        this.f69684p = appCompatTextView5;
        this.f69685q = appCompatTextView6;
        this.f69686r = appCompatTextView7;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.groupErrorLayout;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null) {
            i11 = R$id.groupSuccessLayout;
            Group group2 = (Group) n6.b.a(view, i11);
            if (group2 != null) {
                i11 = R$id.ivError;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ivTransWifiQrCode;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.llSend;
                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                        if (linearLayout != null) {
                            i11 = R$id.llUp;
                            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                            if (constraintLayout != null) {
                                i11 = R$id.progressBar;
                                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                if (progressBar != null) {
                                    i11 = R$id.switchButton;
                                    SwitchButton switchButton = (SwitchButton) n6.b.a(view, i11);
                                    if (switchButton != null) {
                                        i11 = R$id.toolBar;
                                        TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                                        if (titleLayout != null) {
                                            i11 = R$id.tvErrorTip;
                                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                            if (appCompatTextView != null) {
                                                i11 = R$id.tvRetry;
                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                if (appCompatTextView2 != null) {
                                                    i11 = R$id.tvSend;
                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView3 != null) {
                                                        i11 = R$id.tvShareLink;
                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView4 != null) {
                                                            i11 = R$id.tvShareQrCode;
                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView5 != null) {
                                                                i11 = R$id.tvWaitingForReceiver;
                                                                AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView6 != null) {
                                                                    i11 = R$id.tvWifiSsid;
                                                                    AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView7 != null) {
                                                                        return new d((LinearLayoutCompat) view, group, group2, appCompatImageView, shapeableImageView, linearLayout, constraintLayout, progressBar, switchButton, titleLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_wifi_create, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f69670a;
    }
}
