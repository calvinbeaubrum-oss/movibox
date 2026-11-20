package mv;

import android.view.View;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.SecondariesSeekBar;
import com.transsion.player.longvideo.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class k implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71279a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71280b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71281c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71282d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71283f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final b f71284g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayout f71285h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f71286i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final View f71287j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final View f71288k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final d f71289l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final SecondariesSeekBar f71290m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f71291n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ViewStub f71292o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final ViewStub f71293p;

    public k(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull b bVar, @NonNull LinearLayout linearLayout, @NonNull View view, @NonNull View view2, @NonNull View view3, @NonNull d dVar, @NonNull SecondariesSeekBar secondariesSeekBar, @NonNull TextView textView, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2) {
        this.f71279a = constraintLayout;
        this.f71280b = appCompatImageView;
        this.f71281c = appCompatImageView2;
        this.f71282d = appCompatImageView3;
        this.f71283f = appCompatImageView4;
        this.f71284g = bVar;
        this.f71285h = linearLayout;
        this.f71286i = view;
        this.f71287j = view2;
        this.f71288k = view3;
        this.f71289l = dVar;
        this.f71290m = secondariesSeekBar;
        this.f71291n = textView;
        this.f71292o = viewStub;
        this.f71293p = viewStub2;
    }

    @NonNull
    public static k a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_float;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.iv_middle_pause;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.iv_middle_screen_change;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView4 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_loading))) != null) {
                        b bVarA = b.a(viewA);
                        i11 = R$id.ll_middle_bottom_controller;
                        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                        if (linearLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.middle_gradient_bottom))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.middle_gradient_top))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.middle_guideline))) != null && (viewA5 = n6.b.a(view, (i11 = R$id.operatorLayout))) != null) {
                            d dVarA = d.a(viewA5);
                            i11 = R$id.seek_bar_middle;
                            SecondariesSeekBar secondariesSeekBar = (SecondariesSeekBar) n6.b.a(view, i11);
                            if (secondariesSeekBar != null) {
                                i11 = R$id.tv_middle_time;
                                TextView textView = (TextView) n6.b.a(view, i11);
                                if (textView != null) {
                                    i11 = R$id.vs_forward_guide_middle;
                                    ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                                    if (viewStub != null) {
                                        i11 = R$id.vs_forward_middle;
                                        ViewStub viewStub2 = (ViewStub) n6.b.a(view, i11);
                                        if (viewStub2 != null) {
                                            return new k((ConstraintLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, bVarA, linearLayout, viewA2, viewA3, viewA4, dVarA, secondariesSeekBar, textView, viewStub, viewStub2);
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
    public ConstraintLayout getRoot() {
        return this.f71279a;
    }
}
