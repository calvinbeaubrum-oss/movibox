package l6;

import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    public static Interpolator a(Context context, int i11) throws Resources.NotFoundException {
        return AnimationUtils.loadInterpolator(context, i11);
    }
}
