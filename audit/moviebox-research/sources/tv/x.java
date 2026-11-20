package tv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f78006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f78007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f78008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78010f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final VideoDoubleClickBackgroundView f78011g;

    public x(@NonNull ConstraintLayout constraintLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull VideoDoubleClickBackgroundView videoDoubleClickBackgroundView) {
        this.f78006a = constraintLayout;
        this.f78007b = lottieAnimationView;
        this.f78008c = lottieAnimationView2;
        this.f78009d = appCompatTextView;
        this.f78010f = appCompatTextView2;
        this.f78011g = videoDoubleClickBackgroundView;
    }

    @NonNull
    public static x a(@NonNull View view) {
        int i11 = R$id.lottie_double_click_left;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) n6.b.a(view, i11);
        if (lottieAnimationView != null) {
            i11 = R$id.lottie_double_click_right;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) n6.b.a(view, i11);
            if (lottieAnimationView2 != null) {
                i11 = R$id.tv_double_click_left;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tv_double_click_right;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        i11 = R$id.v_double_click;
                        VideoDoubleClickBackgroundView videoDoubleClickBackgroundView = (VideoDoubleClickBackgroundView) n6.b.a(view, i11);
                        if (videoDoubleClickBackgroundView != null) {
                            return new x((ConstraintLayout) view, lottieAnimationView, lottieAnimationView2, appCompatTextView, appCompatTextView2, videoDoubleClickBackgroundView);
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
        return this.f78006a;
    }
}
