package fs;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsion.baseui.R$id;
import com.transsion.baseui.music.RoundedCornerLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65269a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65270b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65271c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65272d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65273f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ProgressBar f65274g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final RoundedCornerLayout f65275h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final RoundedCornerLayout f65276i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65277j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65278k;

    public e(@NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull ProgressBar progressBar, @NonNull RoundedCornerLayout roundedCornerLayout, @NonNull RoundedCornerLayout roundedCornerLayout2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f65269a = frameLayout;
        this.f65270b = appCompatImageView;
        this.f65271c = appCompatImageView2;
        this.f65272d = appCompatImageView3;
        this.f65273f = appCompatImageView4;
        this.f65274g = progressBar;
        this.f65275h = roundedCornerLayout;
        this.f65276i = roundedCornerLayout2;
        this.f65277j = appCompatTextView;
        this.f65278k = appCompatTextView2;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.ivClose;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ivCover;
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView2 != null) {
                i11 = R$id.ivCoverBg;
                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView3 != null) {
                    i11 = R$id.ivPlayPause;
                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView4 != null) {
                        i11 = R$id.progress;
                        ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                        if (progressBar != null) {
                            i11 = R$id.roundExpand;
                            RoundedCornerLayout roundedCornerLayout = (RoundedCornerLayout) n6.b.a(view, i11);
                            if (roundedCornerLayout != null) {
                                i11 = R$id.roundFold;
                                RoundedCornerLayout roundedCornerLayout2 = (RoundedCornerLayout) n6.b.a(view, i11);
                                if (roundedCornerLayout2 != null) {
                                    i11 = R$id.tvDescription;
                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                    if (appCompatTextView != null) {
                                        i11 = R$id.tvTitle;
                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                        if (appCompatTextView2 != null) {
                                            return new e((FrameLayout) view, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, progressBar, roundedCornerLayout, roundedCornerLayout2, appCompatTextView, appCompatTextView2);
                                        }
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
    public FrameLayout getRoot() {
        return this.f65269a;
    }
}
