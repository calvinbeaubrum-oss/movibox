package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.tn.lib.view.AdvRecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadTransferLaterTipsView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class y implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f66096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AdvRecyclerView f66097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final SwipeRefreshLayout f66098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final DownloadTransferLaterTipsView f66099d;

    public y(@NonNull FrameLayout frameLayout, @NonNull AdvRecyclerView advRecyclerView, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull DownloadTransferLaterTipsView downloadTransferLaterTipsView) {
        this.f66096a = frameLayout;
        this.f66097b = advRecyclerView;
        this.f66098c = swipeRefreshLayout;
        this.f66099d = downloadTransferLaterTipsView;
    }

    @NonNull
    public static y a(@NonNull View view) {
        int i11 = R$id.rv_list;
        AdvRecyclerView advRecyclerView = (AdvRecyclerView) n6.b.a(view, i11);
        if (advRecyclerView != null) {
            i11 = R$id.swipe_refresh;
            SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) n6.b.a(view, i11);
            if (swipeRefreshLayout != null) {
                i11 = R$id.v_transfer_later_tips;
                DownloadTransferLaterTipsView downloadTransferLaterTipsView = (DownloadTransferLaterTipsView) n6.b.a(view, i11);
                if (downloadTransferLaterTipsView != null) {
                    return new y((FrameLayout) view, advRecyclerView, swipeRefreshLayout, downloadTransferLaterTipsView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static y c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static y d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_panel, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f66096a;
    }
}
