package mv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.transsion.player.longvideo.R$id;
import com.transsion.postdetail.ui.view.VideoDoubleClickBackgroundView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f71181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LottieAnimationView f71182c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71183d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71184f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final VideoDoubleClickBackgroundView f71185g;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull VideoDoubleClickBackgroundView videoDoubleClickBackgroundView) {
        this.f71180a = constraintLayout;
        this.f71181b = lottieAnimationView;
        this.f71182c = lottieAnimationView2;
        this.f71183d = appCompatTextView;
        this.f71184f = appCompatTextView2;
        this.f71185g = videoDoubleClickBackgroundView;
    }

    @NonNull
    public static a a(@NonNull View view) {
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
                            return new a((ConstraintLayout) view, lottieAnimationView, lottieAnimationView2, appCompatTextView, appCompatTextView2, videoDoubleClickBackgroundView);
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
        return this.f71180a;
    }
}
