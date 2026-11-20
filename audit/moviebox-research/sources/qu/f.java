package qu;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.member.R$id;
import com.transsion.member.view.CheckInView;
import com.transsion.member.view.GradientTextView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CheckBox f74928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final GradientTextView f74929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f74930d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f74931f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final CheckInView f74932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f74933h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f74934i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final GradientTextView f74935j;

    public f(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull GradientTextView gradientTextView, @NonNull ImageView imageView, @NonNull AppCompatImageView appCompatImageView, @NonNull CheckInView checkInView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull GradientTextView gradientTextView2) {
        this.f74927a = linearLayout;
        this.f74928b = checkBox;
        this.f74929c = gradientTextView;
        this.f74930d = imageView;
        this.f74931f = appCompatImageView;
        this.f74932g = checkInView;
        this.f74933h = textView;
        this.f74934i = textView2;
        this.f74935j = gradientTextView2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.dialog_ignore;
        CheckBox checkBox = (CheckBox) n6.b.a(view, i11);
        if (checkBox != null) {
            i11 = R$id.go_purchase_member;
            GradientTextView gradientTextView = (GradientTextView) n6.b.a(view, i11);
            if (gradientTextView != null) {
                i11 = R$id.ic_tips;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    i11 = R$id.ivClose;
                    AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView != null) {
                        i11 = R$id.member_check_in_view;
                        CheckInView checkInView = (CheckInView) n6.b.a(view, i11);
                        if (checkInView != null) {
                            i11 = R$id.member_tips;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.point_tips;
                                TextView textView2 = (TextView) n6.b.a(view, i11);
                                if (textView2 != null) {
                                    i11 = R$id.title;
                                    GradientTextView gradientTextView2 = (GradientTextView) n6.b.a(view, i11);
                                    if (gradientTextView2 != null) {
                                        return new f((LinearLayout) view, checkBox, gradientTextView, imageView, appCompatImageView, checkInView, textView, textView2, gradientTextView2);
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
        return this.f74927a;
    }
}
