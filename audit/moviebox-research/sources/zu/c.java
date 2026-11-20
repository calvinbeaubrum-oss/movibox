package zu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.photoview.PhotoView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f82174a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f82175b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f82176c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f82177d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final PhotoView f82178f;

    public c(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull FrameLayout frameLayout3, @NonNull PhotoView photoView) {
        this.f82174a = frameLayout;
        this.f82175b = frameLayout2;
        this.f82176c = appCompatImageView;
        this.f82177d = frameLayout3;
        this.f82178f = photoView;
    }

    @NonNull
    public static c a(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.thumb;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.video_container;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null) {
                i11 = R$id.video_cover;
                PhotoView photoView = (PhotoView) n6.b.a(view, i11);
                if (photoView != null) {
                    return new c(frameLayout, frameLayout, appCompatImageView, frameLayout2, photoView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static c c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static c d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_gif_image_preview, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f82174a;
    }
}
