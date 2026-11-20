package mv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLTextView f71191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLTextView f71192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71193d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71194f;

    public c(@NonNull ConstraintLayout constraintLayout, @NonNull BLTextView bLTextView, @NonNull BLTextView bLTextView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f71190a = constraintLayout;
        this.f71191b = bLTextView;
        this.f71192c = bLTextView2;
        this.f71193d = appCompatTextView;
        this.f71194f = appCompatTextView2;
    }

    @NonNull
    public static c a(@NonNull View view) {
        int i11 = R$id.longVdTvOperator;
        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.longVdTvPlay;
            BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
            if (bLTextView2 != null) {
                i11 = R$id.longVodTvTips;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.longVodTvTitle;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new c((ConstraintLayout) view, bLTextView, bLTextView2, appCompatTextView, appCompatTextView2);
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
        return this.f71190a;
    }
}
