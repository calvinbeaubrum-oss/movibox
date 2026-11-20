package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class l0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final NativeSlideshowView f65936c;

    public l0(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull NativeSlideshowView nativeSlideshowView) {
        this.f65934a = frameLayout;
        this.f65935b = frameLayout2;
        this.f65936c = nativeSlideshowView;
    }

    @NonNull
    public static l0 a(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i11 = R$id.nativeSlideshowView;
        NativeSlideshowView nativeSlideshowView = (NativeSlideshowView) n6.b.a(view, i11);
        if (nativeSlideshowView != null) {
            return new l0(frameLayout, frameLayout, nativeSlideshowView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static l0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static l0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_top_card_ad_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65934a;
    }
}
