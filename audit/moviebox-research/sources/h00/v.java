package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.noober.background.view.BLConstraintLayout;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class v implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f66049a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLConstraintLayout f66050b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f66051c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66052d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f66053f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f66054g;

    public v(@NonNull FrameLayout frameLayout, @NonNull BLConstraintLayout bLConstraintLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull RecyclerView recyclerView, @NonNull AppCompatTextView appCompatTextView) {
        this.f66049a = frameLayout;
        this.f66050b = bLConstraintLayout;
        this.f66051c = frameLayout2;
        this.f66052d = appCompatImageView;
        this.f66053f = recyclerView;
        this.f66054g = appCompatTextView;
    }

    @NonNull
    public static v a(@NonNull View view) {
        int i11 = R$id.cl_content;
        BLConstraintLayout bLConstraintLayout = (BLConstraintLayout) n6.b.a(view, i11);
        if (bLConstraintLayout != null) {
            FrameLayout frameLayout = (FrameLayout) view;
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.f60286rv;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.tv_title;
                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView != null) {
                        return new v(frameLayout, bLConstraintLayout, frameLayout, appCompatImageView, recyclerView, appCompatTextView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static v c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static v d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_audio_track, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66049a;
    }
}
