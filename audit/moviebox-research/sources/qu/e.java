package qu;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.baseui.widget.GradientBorderView;
import com.transsion.member.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f74920a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f74921b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final GradientBorderView f74922c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74923d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f74924f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f74925g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f74926h;

    public e(@NonNull FrameLayout frameLayout, @NonNull ConstraintLayout constraintLayout, @NonNull GradientBorderView gradientBorderView, @NonNull AppCompatTextView appCompatTextView, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView2, @NonNull TextView textView2) {
        this.f74920a = frameLayout;
        this.f74921b = constraintLayout;
        this.f74922c = gradientBorderView;
        this.f74923d = appCompatTextView;
        this.f74924f = textView;
        this.f74925g = appCompatTextView2;
        this.f74926h = textView2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.clRoot;
        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
        if (constraintLayout != null) {
            i11 = R$id.iv_confirm_container;
            GradientBorderView gradientBorderView = (GradientBorderView) n6.b.a(view, i11);
            if (gradientBorderView != null) {
                i11 = R$id.tv_confirm;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvDesc;
                    TextView textView = (TextView) n6.b.a(view, i11);
                    if (textView != null) {
                        i11 = R$id.tv_later;
                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView2 != null) {
                            i11 = R$id.tvTitle;
                            TextView textView2 = (TextView) n6.b.a(view, i11);
                            if (textView2 != null) {
                                return new e((FrameLayout) view, constraintLayout, gradientBorderView, appCompatTextView, textView, appCompatTextView2, textView2);
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
    public FrameLayout getRoot() {
        return this.f74920a;
    }
}
