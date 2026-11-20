package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.TransferBottomToolsView;
import com.transsnet.downloader.widget.TransferSelectSeriesListView;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class m0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f65951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final NestedScrollableHost f65952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TransferBottomToolsView f65953d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TransferSelectSeriesListView f65954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f65956h;

    public m0(@NonNull ConstraintLayout constraintLayout, @NonNull MagicIndicator magicIndicator, @NonNull NestedScrollableHost nestedScrollableHost, @NonNull TransferBottomToolsView transferBottomToolsView, @NonNull TransferSelectSeriesListView transferSelectSeriesListView, @NonNull AppCompatImageView appCompatImageView, @NonNull ViewPager2 viewPager2) {
        this.f65950a = constraintLayout;
        this.f65951b = magicIndicator;
        this.f65952c = nestedScrollableHost;
        this.f65953d = transferBottomToolsView;
        this.f65954f = transferSelectSeriesListView;
        this.f65955g = appCompatImageView;
        this.f65956h = viewPager2;
    }

    @NonNull
    public static m0 a(@NonNull View view) {
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
        if (magicIndicator != null) {
            i11 = R$id.nsh_view_pager;
            NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) n6.b.a(view, i11);
            if (nestedScrollableHost != null) {
                i11 = R$id.v_bottom_tools;
                TransferBottomToolsView transferBottomToolsView = (TransferBottomToolsView) n6.b.a(view, i11);
                if (transferBottomToolsView != null) {
                    i11 = R$id.v_series_list;
                    TransferSelectSeriesListView transferSelectSeriesListView = (TransferSelectSeriesListView) n6.b.a(view, i11);
                    if (transferSelectSeriesListView != null) {
                        i11 = R$id.v_top_bg;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.view_pager;
                            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                            if (viewPager2 != null) {
                                return new m0((ConstraintLayout) view, magicIndicator, nestedScrollableHost, transferBottomToolsView, transferSelectSeriesListView, appCompatImageView, viewPager2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static m0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static m0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_transfer_main, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65950a;
    }
}
