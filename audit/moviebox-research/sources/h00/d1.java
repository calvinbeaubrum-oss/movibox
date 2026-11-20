package h00;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.noober.background.view.BLView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d1 implements n6.a {

    @NonNull
    public final BLView A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f65786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Group f65788d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Group f65789f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Group f65790g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final Group f65791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65795l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65796m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final View f65797n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65798o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65799p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65800q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65801r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65802s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65803t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65804u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65805v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65806w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final View f65807x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final View f65808y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final View f65809z;

    public d1(@NonNull View view, @NonNull View view2, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull Group group2, @NonNull Group group3, @NonNull Group group4, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull ProgressBar progressBar, @NonNull View view3, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull AppCompatTextView appCompatTextView6, @NonNull AppCompatTextView appCompatTextView7, @NonNull AppCompatTextView appCompatTextView8, @NonNull AppCompatTextView appCompatTextView9, @NonNull View view4, @NonNull View view5, @NonNull View view6, @NonNull BLView bLView) {
        this.f65785a = view;
        this.f65786b = view2;
        this.f65787c = frameLayout;
        this.f65788d = group;
        this.f65789f = group2;
        this.f65790g = group3;
        this.f65791h = group4;
        this.f65792i = appCompatImageView;
        this.f65793j = appCompatImageView2;
        this.f65794k = appCompatImageView3;
        this.f65795l = appCompatImageView4;
        this.f65796m = progressBar;
        this.f65797n = view3;
        this.f65798o = appCompatTextView;
        this.f65799p = appCompatTextView2;
        this.f65800q = appCompatTextView3;
        this.f65801r = appCompatTextView4;
        this.f65802s = appCompatTextView5;
        this.f65803t = appCompatTextView6;
        this.f65804u = appCompatTextView7;
        this.f65805v = appCompatTextView8;
        this.f65806w = appCompatTextView9;
        this.f65807x = view4;
        this.f65808y = view5;
        this.f65809z = view6;
        this.A = bLView;
    }

    @NonNull
    public static d1 a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        int i11 = R$id.bottom_guideline;
        View viewA5 = n6.b.a(view, i11);
        if (viewA5 != null) {
            i11 = R$id.fl_send;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.group_def;
                Group group = (Group) n6.b.a(view, i11);
                if (group != null) {
                    i11 = R$id.group_list;
                    Group group2 = (Group) n6.b.a(view, i11);
                    if (group2 != null) {
                        i11 = R$id.group_send;
                        Group group3 = (Group) n6.b.a(view, i11);
                        if (group3 != null) {
                            i11 = R$id.group_top_connect;
                            Group group4 = (Group) n6.b.a(view, i11);
                            if (group4 != null) {
                                i11 = R$id.iv_close;
                                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView != null) {
                                    i11 = R$id.iv_reset;
                                    AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView2 != null) {
                                        i11 = R$id.iv_send_list;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.iv_top_icon;
                                            AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView4 != null) {
                                                i11 = R$id.pb_loading;
                                                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                                if (progressBar != null && (viewA = n6.b.a(view, (i11 = R$id.top_guideline))) != null) {
                                                    i11 = R$id.tv_close;
                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                    if (appCompatTextView != null) {
                                                        i11 = R$id.tv_receive_def;
                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                        if (appCompatTextView2 != null) {
                                                            i11 = R$id.tv_reset;
                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView3 != null) {
                                                                i11 = R$id.tv_send;
                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView4 != null) {
                                                                    i11 = R$id.tv_send_def;
                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView5 != null) {
                                                                        i11 = R$id.tv_send_list_count;
                                                                        AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                        if (appCompatTextView6 != null) {
                                                                            i11 = R$id.tv_send_list_tips;
                                                                            AppCompatTextView appCompatTextView7 = (AppCompatTextView) n6.b.a(view, i11);
                                                                            if (appCompatTextView7 != null) {
                                                                                i11 = R$id.tv_top_disconnect;
                                                                                AppCompatTextView appCompatTextView8 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView8 != null) {
                                                                                    i11 = R$id.tv_top_phone_model;
                                                                                    AppCompatTextView appCompatTextView9 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView9 != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_receive_def))) != null && (viewA3 = n6.b.a(view, (i11 = R$id.v_send))) != null && (viewA4 = n6.b.a(view, (i11 = R$id.v_send_def))) != null) {
                                                                                        i11 = R$id.v_top_bg;
                                                                                        BLView bLView = (BLView) n6.b.a(view, i11);
                                                                                        if (bLView != null) {
                                                                                            return new d1(view, viewA5, frameLayout, group, group2, group3, group4, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, progressBar, viewA, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, appCompatTextView6, appCompatTextView7, appCompatTextView8, appCompatTextView9, viewA2, viewA3, viewA4, bLView);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65785a;
    }
}
