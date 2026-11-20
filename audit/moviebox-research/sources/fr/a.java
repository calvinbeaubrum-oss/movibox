package fr;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.audio.R$id;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f65222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f65223d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f65224f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f65225g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f65226h;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull MagicIndicator magicIndicator, @NonNull TextView textView, @NonNull ViewPager2 viewPager2) {
        this.f65220a = constraintLayout;
        this.f65221b = appCompatImageView;
        this.f65222c = view;
        this.f65223d = linearLayoutCompat;
        this.f65224f = magicIndicator;
        this.f65225g = textView;
        this.f65226h = viewPager2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        View viewA;
        int i11 = R$id.iv_clear;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null && (viewA = n6.b.a(view, (i11 = R$id.line1))) != null) {
            i11 = R$id.ll_ctl;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                if (magicIndicator != null) {
                    i11 = R$id.tv_close;
                    TextView textView = (TextView) n6.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.view_pager;
                        ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                        if (viewPager2 != null) {
                            return new a((ConstraintLayout) view, appCompatImageView, viewA, linearLayoutCompat, magicIndicator, textView, viewPager2);
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
        return this.f65220a;
    }
}
