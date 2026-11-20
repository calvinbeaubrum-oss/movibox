package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.music.widget.MusicLikedListEmptyView;
import com.transsion.videodetail.music.widget.MusicLikedListLoadingView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MusicLikedListEmptyView f75800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final RecyclerView f75802d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final MusicLikedListLoadingView f75803f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75804g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f75805h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final View f75806i;

    public e(@NonNull ConstraintLayout constraintLayout, @NonNull MusicLikedListEmptyView musicLikedListEmptyView, @NonNull FrameLayout frameLayout, @NonNull RecyclerView recyclerView, @NonNull MusicLikedListLoadingView musicLikedListLoadingView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull View view) {
        this.f75799a = constraintLayout;
        this.f75800b = musicLikedListEmptyView;
        this.f75801c = frameLayout;
        this.f75802d = recyclerView;
        this.f75803f = musicLikedListLoadingView;
        this.f75804g = appCompatTextView;
        this.f75805h = appCompatTextView2;
        this.f75806i = view;
    }

    @NonNull
    public static e a(@NonNull View view) {
        View viewA;
        int i11 = R$id.emptyView;
        MusicLikedListEmptyView musicLikedListEmptyView = (MusicLikedListEmptyView) n6.b.a(view, i11);
        if (musicLikedListEmptyView != null) {
            i11 = R$id.flPlayer;
            FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
            if (frameLayout != null) {
                i11 = R$id.likedRv;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.loadingView;
                    MusicLikedListLoadingView musicLikedListLoadingView = (MusicLikedListLoadingView) n6.b.a(view, i11);
                    if (musicLikedListLoadingView != null) {
                        i11 = R$id.tvPlayAll;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tvVideosCount;
                            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.viewTopPlaceholder))) != null) {
                                return new e((ConstraintLayout) view, musicLikedListEmptyView, frameLayout, recyclerView, musicLikedListLoadingView, appCompatTextView, appCompatTextView2, viewA);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_liked_music_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75799a;
    }
}
