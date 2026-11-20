package h00;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.noober.background.view.BLFrameLayout;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class p0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLFrameLayout f65988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f65989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final CircleProgressBar f65990d;

    public p0(@NonNull View view, @NonNull BLFrameLayout bLFrameLayout, @NonNull ImageView imageView, @NonNull CircleProgressBar circleProgressBar) {
        this.f65987a = view;
        this.f65988b = bLFrameLayout;
        this.f65989c = imageView;
        this.f65990d = circleProgressBar;
    }

    @NonNull
    public static p0 a(@NonNull View view) {
        int i11 = R$id.fl_guide_content;
        BLFrameLayout bLFrameLayout = (BLFrameLayout) n6.b.a(view, i11);
        if (bLFrameLayout != null) {
            i11 = R$id.iv_guide_close;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.progress_bar_guide_close;
                CircleProgressBar circleProgressBar = (CircleProgressBar) n6.b.a(view, i11);
                if (circleProgressBar != null) {
                    return new p0(view, bLFrameLayout, imageView, circleProgressBar);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65987a;
    }
}
