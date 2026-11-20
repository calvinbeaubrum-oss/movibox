package androidx.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static e f8177a = new DataBinderMapperImpl();

    @Nullable
    public static <T extends ViewDataBinding> T a(@NonNull View view) {
        return (T) b(view, null);
    }

    @Nullable
    public static <T extends ViewDataBinding> T b(@NonNull View view, f fVar) {
        T t11 = (T) c(view);
        if (t11 != null) {
            return t11;
        }
        Object tag = view.getTag();
        if (!(tag instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        int iC = f8177a.c((String) tag);
        if (iC != 0) {
            return (T) f8177a.b(fVar, view, iC);
        }
        throw new IllegalArgumentException("View is not a binding layout. Tag: " + tag);
    }

    @Nullable
    public static <T extends ViewDataBinding> T c(@NonNull View view) {
        return (T) ViewDataBinding.j(view);
    }
}
