package tv;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLImageView;
import com.noober.background.view.BLTextView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class q0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLImageView f77908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77910d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BLTextView f77911f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77912g;

    public q0(@NonNull View view, @NonNull BLImageView bLImageView, @NonNull ShapeableImageView shapeableImageView, @NonNull ProgressBar progressBar, @NonNull BLTextView bLTextView, @NonNull View view2) {
        this.f77907a = view;
        this.f77908b = bLImageView;
        this.f77909c = shapeableImageView;
        this.f77910d = progressBar;
        this.f77911f = bLTextView;
        this.f77912g = view2;
    }

    @NonNull
    public static q0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.ivMute;
        BLImageView bLImageView = (BLImageView) n6.b.a(view, i11);
        if (bLImageView != null) {
            i11 = R$id.ivPlayerCover;
            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
            if (shapeableImageView != null) {
                i11 = R$id.playerProgress;
                ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                if (progressBar != null) {
                    i11 = R$id.tvVideoDuration;
                    BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                    if (bLTextView != null && (viewA = n6.b.a(view, (i11 = R$id.vMuteHotZone))) != null) {
                        return new q0(view, bLImageView, shapeableImageView, progressBar, bLTextView, viewA);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77907a;
    }
}
