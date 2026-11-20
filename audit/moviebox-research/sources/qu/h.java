package qu;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatEditText;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74943a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f74944b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f74945c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f74946d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f74947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f74948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74949h;

    public h(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull AppCompatEditText appCompatEditText, @NonNull GradientBorderView gradientBorderView) {
        this.f74943a = linearLayout;
        this.f74944b = imageView;
        this.f74945c = imageView2;
        this.f74946d = textView;
        this.f74947f = textView2;
        this.f74948g = appCompatEditText;
        this.f74949h = gradientBorderView;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i11 = R$id.promo_code_dialog_close;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.promo_code_input_clear_iv;
            ImageView imageView2 = (ImageView) n6.b.a(view, i11);
            if (imageView2 != null) {
                i11 = R$id.promo_code_input_confirm;
                TextView textView = (TextView) n6.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.promo_code_input_error_tips;
                    TextView textView2 = (TextView) n6.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.promo_code_input_et;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
                        if (appCompatEditText != null) {
                            i11 = R$id.promo_code_title_layout;
                            GradientBorderView gradientBorderView = (GradientBorderView) n6.b.a(view, i11);
                            if (gradientBorderView != null) {
                                return new h((LinearLayout) view, imageView, imageView2, textView, textView2, appCompatEditText, gradientBorderView);
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
        return this.f74943a;
    }
}
