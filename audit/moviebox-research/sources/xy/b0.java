package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final RecyclerView f80723b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f80724c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80725d;

    public b0(@NonNull ConstraintLayout constraintLayout, @NonNull RecyclerView recyclerView, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2) {
        this.f80722a = constraintLayout;
        this.f80723b = recyclerView;
        this.f80724c = appCompatImageView;
        this.f80725d = constraintLayout2;
    }

    @NonNull
    public static b0 a(@NonNull View view) {
        int i11 = R$id.contentList;
        RecyclerView recyclerView = (RecyclerView) n6.b.a(view, i11);
        if (recyclerView != null) {
            i11 = R$id.iv_qr_code;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                ConstraintLayout constraintLayout = (ConstraintLayout) view;
                return new b0(constraintLayout, recyclerView, appCompatImageView, constraintLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static b0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_me, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80722a;
    }
}
