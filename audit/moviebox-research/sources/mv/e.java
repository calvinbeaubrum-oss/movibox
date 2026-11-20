package mv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLTextView;
import com.transsion.player.longvideo.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71202a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLTextView f71203b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71204c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f71205d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BLTextView f71206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71207g;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull BLTextView bLTextView2, @NonNull ConstraintLayout constraintLayout2) {
        this.f71202a = constraintLayout;
        this.f71203b = bLTextView;
        this.f71204c = appCompatTextView;
        this.f71205d = appCompatTextView2;
        this.f71206f = bLTextView2;
        this.f71207g = constraintLayout2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.interceptPremium;
        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
        if (bLTextView != null) {
            i11 = R$id.interceptTip;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.interceptTitle;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.interceptWatchAd;
                    BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                    if (bLTextView2 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new e(constraintLayout, bLTextView, appCompatTextView, appCompatTextView2, bLTextView2, constraintLayout);
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
        return this.f71202a;
    }
}
