package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import com.transsion.subtitle.view.SubtitleOptionsView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class e implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final NestedScrollView f79684a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final SubtitleOptionsView f79685b;

    public e(@NonNull NestedScrollView nestedScrollView, @NonNull SubtitleOptionsView subtitleOptionsView) {
        this.f79684a = nestedScrollView;
        this.f79685b = subtitleOptionsView;
    }

    @NonNull
    public static e a(@NonNull View view) {
        int i11 = R$id.v_options;
        SubtitleOptionsView subtitleOptionsView = (SubtitleOptionsView) n6.b.a(view, i11);
        if (subtitleOptionsView != null) {
            return new e((NestedScrollView) view, subtitleOptionsView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static e c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static e d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subtitle_options, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public NestedScrollView getRoot() {
        return this.f79684a;
    }
}
