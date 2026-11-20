package mv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.view.LongVodRewardInterceptTimerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LongVodRewardInterceptTimerView f71223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71224d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f71226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f71227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71228i;

    public h(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull LongVodRewardInterceptTimerView longVodRewardInterceptTimerView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view, @NonNull View view2, @NonNull AppCompatTextView appCompatTextView3) {
        this.f71221a = constraintLayout;
        this.f71222b = appCompatImageView;
        this.f71223c = longVodRewardInterceptTimerView;
        this.f71224d = appCompatTextView;
        this.f71225f = appCompatTextView2;
        this.f71226g = view;
        this.f71227h = view2;
        this.f71228i = appCompatTextView3;
    }

    @NonNull
    public static h a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.rewardInterceptTimer;
            LongVodRewardInterceptTimerView longVodRewardInterceptTimerView = (LongVodRewardInterceptTimerView) n6.b.a(view, i11);
            if (longVodRewardInterceptTimerView != null) {
                i11 = R$id.tvFeedback;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.tvSubtitleSetting;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.v_space_end))) != null && (viewA2 = n6.b.a(view, (i11 = R$id.v_space_start))) != null) {
                        i11 = R$id.vd_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new h((ConstraintLayout) view, appCompatImageView, longVodRewardInterceptTimerView, appCompatTextView, appCompatTextView2, viewA, viewA2, appCompatTextView3);
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
        return this.f71221a;
    }
}
