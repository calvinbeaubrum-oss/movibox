package rz;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.tn.lib.view.bubbleview.BubbleTextView;
import com.transsion.videodetail.R$id;
import com.transsion.videodetail.R$layout;
import com.transsion.videodetail.music.widget.MusicDetailListOperateView;
import com.transsnet.downloader.widget.DownloadView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f75807a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BubbleTextView f75808b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f75809c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final DownloadView f75810d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f75811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75813h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75814i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75815j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75816k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75817l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f75818m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final mv.g f75819n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f75820o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final MusicDetailListOperateView f75821p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f75822q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75823r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75824s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final FrameLayout f75825t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f75826u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final View f75827v;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull BubbleTextView bubbleTextView, @NonNull AppBarLayout appBarLayout, @NonNull DownloadView downloadView, @NonNull CoordinatorLayout coordinatorLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull FrameLayout frameLayout5, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull mv.g gVar, @NonNull MagicIndicator magicIndicator, @NonNull MusicDetailListOperateView musicDetailListOperateView, @NonNull ViewPager2 viewPager2, @NonNull FrameLayout frameLayout6, @NonNull FrameLayout frameLayout7, @NonNull FrameLayout frameLayout8, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull View view) {
        this.f75807a = constraintLayout;
        this.f75808b = bubbleTextView;
        this.f75809c = appBarLayout;
        this.f75810d = downloadView;
        this.f75811f = coordinatorLayout;
        this.f75812g = frameLayout;
        this.f75813h = frameLayout2;
        this.f75814i = frameLayout3;
        this.f75815j = frameLayout4;
        this.f75816k = frameLayout5;
        this.f75817l = appCompatImageView;
        this.f75818m = appCompatImageView2;
        this.f75819n = gVar;
        this.f75820o = magicIndicator;
        this.f75821p = musicDetailListOperateView;
        this.f75822q = viewPager2;
        this.f75823r = frameLayout6;
        this.f75824s = frameLayout7;
        this.f75825t = frameLayout8;
        this.f75826u = collapsingToolbarLayout;
        this.f75827v = view;
    }

    @NonNull
    public static f a(@NonNull View view) {
        View viewA;
        View viewA2;
        int i11 = R$id.activity_tip;
        BubbleTextView bubbleTextView = (BubbleTextView) n6.b.a(view, i11);
        if (bubbleTextView != null) {
            i11 = R$id.appBar;
            AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
            if (appBarLayout != null) {
                i11 = R$id.btn_download;
                DownloadView downloadView = (DownloadView) n6.b.a(view, i11);
                if (downloadView != null) {
                    i11 = R$id.cdl;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                    if (coordinatorLayout != null) {
                        i11 = R$id.fl_bottom_dialog_container;
                        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout != null) {
                            i11 = R$id.flFullPlayerContainer;
                            FrameLayout frameLayout2 = (FrameLayout) n6.b.a(view, i11);
                            if (frameLayout2 != null) {
                                i11 = R$id.flMusicContainer;
                                FrameLayout frameLayout3 = (FrameLayout) n6.b.a(view, i11);
                                if (frameLayout3 != null) {
                                    i11 = R$id.flPlayer;
                                    FrameLayout frameLayout4 = (FrameLayout) n6.b.a(view, i11);
                                    if (frameLayout4 != null) {
                                        i11 = R$id.game_container;
                                        FrameLayout frameLayout5 = (FrameLayout) n6.b.a(view, i11);
                                        if (frameLayout5 != null) {
                                            i11 = R$id.ivBack;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView != null) {
                                                i11 = R$id.iv_publish;
                                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                                if (appCompatImageView2 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_sync_adjust))) != null) {
                                                    mv.g gVarA = mv.g.a(viewA);
                                                    i11 = R$id.magic_indicator;
                                                    MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                                    if (magicIndicator != null) {
                                                        i11 = R$id.operateView;
                                                        MusicDetailListOperateView musicDetailListOperateView = (MusicDetailListOperateView) n6.b.a(view, i11);
                                                        if (musicDetailListOperateView != null) {
                                                            i11 = R$id.rec_view_pager;
                                                            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                            if (viewPager2 != null) {
                                                                i11 = R$id.resourceDetectorGroup;
                                                                FrameLayout frameLayout6 = (FrameLayout) n6.b.a(view, i11);
                                                                if (frameLayout6 != null) {
                                                                    i11 = R$id.subjectDetailLayout;
                                                                    FrameLayout frameLayout7 = (FrameLayout) n6.b.a(view, i11);
                                                                    if (frameLayout7 != null) {
                                                                        i11 = R$id.subjectDetailLayoutV2;
                                                                        FrameLayout frameLayout8 = (FrameLayout) n6.b.a(view, i11);
                                                                        if (frameLayout8 != null) {
                                                                            i11 = R$id.toolbar_layout;
                                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                                                                            if (collapsingToolbarLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.vTopSpace))) != null) {
                                                                                return new f((ConstraintLayout) view, bubbleTextView, appBarLayout, downloadView, coordinatorLayout, frameLayout, frameLayout2, frameLayout3, frameLayout4, frameLayout5, appCompatImageView, appCompatImageView2, gVarA, magicIndicator, musicDetailListOperateView, viewPager2, frameLayout6, frameLayout7, frameLayout8, collapsingToolbarLayout, viewA2);
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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

    @NonNull
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_music_detail_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f75807a;
    }
}
