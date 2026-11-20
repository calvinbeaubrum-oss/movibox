package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.widget.DownloadPanelForYouFootView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class w implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f66066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final FrameLayout f66067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final DownloadPanelForYouFootView f66068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f66069d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final RecyclerView f66070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f66071g;

    public w(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull DownloadPanelForYouFootView downloadPanelForYouFootView, @NonNull LinearLayout linearLayout2, @NonNull RecyclerView recyclerView, @NonNull NestedScrollView nestedScrollView) {
        this.f66066a = linearLayout;
        this.f66067b = frameLayout;
        this.f66068c = downloadPanelForYouFootView;
        this.f66069d = linearLayout2;
        this.f66070f = recyclerView;
        this.f66071g = nestedScrollView;
    }

    @NonNull
    public static w a(@NonNull View view) {
        int i11 = R$id.fl_empty_root;
        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
        if (frameLayout != null) {
            i11 = R$id.foot_for_you;
            DownloadPanelForYouFootView downloadPanelForYouFootView = (DownloadPanelForYouFootView) n6.b.a(view, i11);
            if (downloadPanelForYouFootView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R$id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
                if (recyclerView != null) {
                    i11 = R$id.sv_empty_root;
                    NestedScrollView nestedScrollView = (NestedScrollView) n6.b.a(view, i11);
                    if (nestedScrollView != null) {
                        return new w(linearLayout, frameLayout, downloadPanelForYouFootView, linearLayout, recyclerView, nestedScrollView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static w c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static w d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_list, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f66066a;
    }
}
