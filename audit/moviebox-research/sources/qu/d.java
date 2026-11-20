package qu;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f74914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74915d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ImageView f74916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f74917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ImageView f74918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f74919i;

    public d(@NonNull GradientBorderView gradientBorderView, @NonNull GradientBorderView gradientBorderView2, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatTextView appCompatTextView, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull ImageView imageView2, @NonNull TextView textView2) {
        this.f74912a = gradientBorderView;
        this.f74913b = gradientBorderView2;
        this.f74914c = linearLayoutCompat;
        this.f74915d = appCompatTextView;
        this.f74916f = imageView;
        this.f74917g = textView;
        this.f74918h = imageView2;
        this.f74919i = textView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        GradientBorderView gradientBorderView = (GradientBorderView) view;
        int i11 = R$id.explore;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
        if (linearLayoutCompat != null) {
            i11 = R$id.explore_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.iv_close;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.iv_detail;
                    TextView textView = (TextView) n6.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.iv_premium_mask;
                        ImageView imageView2 = (ImageView) n6.b.a(view, i11);
                        if (imageView2 != null) {
                            i11 = R$id.iv_title;
                            TextView textView2 = (TextView) n6.b.a(view, i11);
                            if (textView2 != null) {
                                return new d(gradientBorderView, gradientBorderView, linearLayoutCompat, appCompatTextView, imageView, textView, imageView2, textView2);
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
    public GradientBorderView getRoot() {
        return this.f74912a;
    }
}
