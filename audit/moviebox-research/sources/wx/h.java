package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.view.SubtitleSyncAdjustView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class h implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final Space f79711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79712d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final SubtitleSyncAdjustView f79713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final SubtitleSyncAdjustView f79714g;

    public h(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull Space space, @NonNull AppCompatTextView appCompatTextView, @NonNull SubtitleSyncAdjustView subtitleSyncAdjustView, @NonNull SubtitleSyncAdjustView subtitleSyncAdjustView2) {
        this.f79709a = constraintLayout;
        this.f79710b = appCompatImageView;
        this.f79711c = space;
        this.f79712d = appCompatTextView;
        this.f79713f = subtitleSyncAdjustView;
        this.f79714g = subtitleSyncAdjustView2;
    }

    @NonNull
    public static h a(@NonNull View view) {
        int i11 = R$id.ivBack;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.space;
            Space space = (Space) n6.b.a(view, i11);
            if (space != null) {
                i11 = R$id.tvStyle;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null) {
                    i11 = R$id.viewSyncAdJustaND;
                    SubtitleSyncAdjustView subtitleSyncAdjustView = (SubtitleSyncAdjustView) n6.b.a(view, i11);
                    if (subtitleSyncAdjustView != null) {
                        i11 = R$id.viewSyncAdJustaST;
                        SubtitleSyncAdjustView subtitleSyncAdjustView2 = (SubtitleSyncAdjustView) n6.b.a(view, i11);
                        if (subtitleSyncAdjustView2 != null) {
                            return new h((ConstraintLayout) view, appCompatImageView, space, appCompatTextView, subtitleSyncAdjustView, subtitleSyncAdjustView2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static h c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static h d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subtitle_sync_adjust_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79709a;
    }
}
