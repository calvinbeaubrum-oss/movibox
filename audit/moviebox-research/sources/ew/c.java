package ew;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
import com.transsion.publish.view.FixedViewPager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f64369a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Group f64370b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f64371c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageButton f64372d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RelativeLayout f64373f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f64374g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f64375h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ImageView f64376i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final LinearLayout f64377j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f64378k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final TextView f64379l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final TextView f64380m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final TextView f64381n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final FixedViewPager f64382o;

    public c(@NonNull ConstraintLayout constraintLayout, @NonNull Group group, @NonNull View view, @NonNull AppCompatImageButton appCompatImageButton, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull FixedViewPager fixedViewPager) {
        this.f64369a = constraintLayout;
        this.f64370b = group;
        this.f64371c = view;
        this.f64372d = appCompatImageButton;
        this.f64373f = relativeLayout;
        this.f64374g = progressBar;
        this.f64375h = textView;
        this.f64376i = imageView;
        this.f64377j = linearLayout;
        this.f64378k = textView2;
        this.f64379l = textView3;
        this.f64380m = textView4;
        this.f64381n = textView5;
        this.f64382o = fixedViewPager;
    }

    @NonNull
    public static c a(@NonNull View view) {
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
                            i11 = R$id.ivDelete;
                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                            if (imageView != null) {
                                i11 = R$id.llSelect;
                                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                if (linearLayout != null) {
                                    i11 = R$id.selectNumTV;
                                    TextView textView2 = (TextView) n6.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.tv_num;
                                        TextView textView3 = (TextView) n6.b.a(view, i11);
                                        if (textView3 != null) {
                                            i11 = R$id.tvNumber;
                                            TextView textView4 = (TextView) n6.b.a(view, i11);
                                            if (textView4 != null) {
                                                i11 = R$id.tvSelect;
                                                TextView textView5 = (TextView) n6.b.a(view, i11);
                                                if (textView5 != null) {
                                                    i11 = R$id.f56358vp;
                                                    FixedViewPager fixedViewPager = (FixedViewPager) n6.b.a(view, i11);
                                                    if (fixedViewPager != null) {
                                                        return new c((ConstraintLayout) view, group, viewA, appCompatImageButton, relativeLayout, progressBar, textView, imageView, linearLayout, textView2, textView3, textView4, textView5, fixedViewPager);
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
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_gallery, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f64369a;
    }
}
