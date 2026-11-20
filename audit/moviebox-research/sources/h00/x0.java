package h00;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tn.lib.view.CircleProgressBar;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class x0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f66093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f66094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CircleProgressBar f66095c;

    public x0(@NonNull View view, @NonNull ImageView imageView, @NonNull CircleProgressBar circleProgressBar) {
        this.f66093a = view;
        this.f66094b = imageView;
        this.f66095c = circleProgressBar;
    }

    @NonNull
    public static x0 a(@NonNull View view) {
        int i11 = R$id.iv_close;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.progress_bar_close;
            CircleProgressBar circleProgressBar = (CircleProgressBar) n6.b.a(view, i11);
            if (circleProgressBar != null) {
                return new x0(view, imageView, circleProgressBar);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f66093a;
    }
}
