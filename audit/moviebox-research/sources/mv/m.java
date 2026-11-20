package mv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.player.longvideo.R$id;
import com.transsion.player.longvideo.R$layout;
import com.transsion.player.longvideo.ui.LongVodPlayerView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f71296a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f71297b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f71298c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final g f71299d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LongVodPlayerView f71300f;

    public m(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull g gVar, @NonNull LongVodPlayerView longVodPlayerView) {
        this.f71296a = constraintLayout;
        this.f71297b = frameLayout;
        this.f71298c = frameLayout2;
        this.f71299d = gVar;
        this.f71300f = longVodPlayerView;
    }

    @NonNull
    public static m a(@NonNull View view) {
        View viewA;
        int i11 = R$id.fl_full_player_container;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.fl_player_container;
            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout2 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                g gVarA = g.a(viewA);
                i11 = R$id.player_view;
                LongVodPlayerView longVodPlayerView = (LongVodPlayerView) n6.b.a(view, i11);
                if (longVodPlayerView != null) {
                    return new m((ConstraintLayout) view, frameLayout, frameLayout2, gVarA, longVodPlayerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static m c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static m d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.test_fragment_long_vod, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f71296a;
    }
}
