package h00;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65823a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final w0 f65824b;

    public e0(@NonNull FrameLayout frameLayout, @NonNull w0 w0Var) {
        this.f65823a = frameLayout;
        this.f65824b = w0Var;
    }

    @NonNull
    public static e0 a(@NonNull View view) {
        int i11 = R$id.included_content;
        View viewA = n6.b.a(view, i11);
        if (viewA == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new e0((FrameLayout) view, w0.a(viewA));
    }

    @NonNull
    public static e0 c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e0 d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_download_res_path_setting, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65823a;
    }
}
