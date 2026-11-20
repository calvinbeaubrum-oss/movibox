package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.transsion.publish.R$id;
import com.transsion.publish.R$layout;
import com.transsion.publish.view.MatchParentVideoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64402a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f64403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f64404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f64405d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f64407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f64408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f64409i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f64410j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64411k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f64412l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64413m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f64414n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final TextView f64415o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final TextView f64416p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final TextView f64417q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final MatchParentVideoView f64418r;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull View view, @NonNull AppCompatImageButton appCompatImageButton, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView2, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull MatchParentVideoView matchParentVideoView) {
        this.f64402a = constraintLayout;
        this.f64403b = group;
        this.f64404c = view;
        this.f64405d = appCompatImageButton;
        this.f64406f = relativeLayout;
        this.f64407g = progressBar;
        this.f64408h = textView;
        this.f64409i = imageView;
        this.f64410j = frameLayout;
        this.f64411k = linearLayout;
        this.f64412l = imageView2;
        this.f64413m = constraintLayout2;
        this.f64414n = textView2;
        this.f64415o = textView3;
        this.f64416p = textView4;
        this.f64417q = textView5;
        this.f64418r = matchParentVideoView;
    }

    @NonNull
    public static g a(@NonNull View view) {
        View viewA;
        int i11 = R$id.bottomGroup;
        Group group = (Group) n6.b.a(view, i11);
        if (group != null && (viewA = n6.b.a(view, (i11 = R$id.bottomLine))) != null) {
            i11 = R$id.btn_back;
            AppCompatImageButton appCompatImageButton = (AppCompatImageButton) n6.b.a(view, i11);
            if (appCompatImageButton != null) {
                i11 = R$id.clTitle;
                RelativeLayout relativeLayout = (RelativeLayout) n6.b.a(view, i11);
                if (relativeLayout != null) {
                    i11 = R$id.clip_loading;
                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                    if (progressBar != null) {
                        i11 = R$id.confirmTV;
                        TextView textView = (TextView) n6.b.a(view, i11);
                        if (textView != null) {
                            i11 = R$id.coverIV;
                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.fl_clear;
                                FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                                if (frameLayout != null) {
                                    i11 = R$id.llSelect;
                                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                    if (linearLayout != null) {
                                        i11 = R$id.playIV;
                                        ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                                        if (imageView2 != null) {
                                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                                            i11 = R$id.selectNumTV;
                                            TextView textView2 = (TextView) n6.b.a(view, i11);
                                            if (textView2 != null) {
                                                i11 = R$id.tv_delete;
                                                TextView textView3 = (TextView) n6.b.a(view, i11);
                                                if (textView3 != null) {
                                                    i11 = R$id.tvNumber;
                                                    TextView textView4 = (TextView) n6.b.a(view, i11);
                                                    if (textView4 != null) {
                                                        i11 = R$id.tvSelect;
                                                        TextView textView5 = (TextView) n6.b.a(view, i11);
                                                        if (textView5 != null) {
                                                            i11 = R$id.vv_video;
                                                            MatchParentVideoView matchParentVideoView = (MatchParentVideoView) n6.b.a(view, i11);
                                                            if (matchParentVideoView != null) {
                                                                return new g(constraintLayout, group, viewA, appCompatImageButton, relativeLayout, progressBar, textView, imageView, frameLayout, linearLayout, imageView2, constraintLayout, textView2, textView3, textView4, textView5, matchParentVideoView);
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
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_video_preview, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64402a;
    }
}
