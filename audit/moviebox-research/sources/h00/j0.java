package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f65912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f65913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TnTextView f65914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TnTextView f65915d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f65916f;

    public j0(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull TnTextView tnTextView, @NonNull TnTextView tnTextView2, @NonNull View view) {
        this.f65912a = constraintLayout;
        this.f65913b = recyclerView;
        this.f65914c = tnTextView;
        this.f65915d = tnTextView2;
        this.f65916f = view;
    }

    @NonNull
    public static j0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.historyRv;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.tvAll;
            TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
            if (tnTextView != null) {
                i11 = R$id.tvTitle;
                TnTextView tnTextView2 = (TnTextView) n6.b.a(view, i11);
                if (tnTextView2 != null && (viewA = n6.b.a(view, (i11 = R$id.vLine))) != null) {
                    return new j0((ConstraintLayout) view, recyclerView, tnTextView, tnTextView2, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static j0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_history_play_record_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f65912a;
    }
}
