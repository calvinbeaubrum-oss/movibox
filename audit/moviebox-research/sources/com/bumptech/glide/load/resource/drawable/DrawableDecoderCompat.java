package com.bumptech.glide.load.resource.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import b3.h;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DrawableDecoderCompat {
    private static volatile boolean shouldCallAppCompatResources = true;

    private DrawableDecoderCompat() {
    }

    public static Drawable getDrawable(Context context, int i11, @Nullable Resources.Theme theme) {
        return getDrawable(context, context, i11, theme);
    }

    public static Drawable getDrawable(Context context, Context context2, int i11) {
        return getDrawable(context, context2, i11, null);
    }

    private static Drawable getDrawable(Context context, Context context2, int i11, @Nullable Resources.Theme theme) {
        try {
            if (shouldCallAppCompatResources) {
                return loadDrawableV7(context2, i11, theme);
            }
        } catch (Resources.NotFoundException unused) {
        } catch (IllegalStateException e11) {
            if (context.getPackageName().equals(context2.getPackageName())) {
                throw e11;
            }
            return z2.a.getDrawable(context2, i11);
        } catch (NoClassDefFoundError unused2) {
            shouldCallAppCompatResources = false;
        }
        if (theme == null) {
            theme = context2.getTheme();
        }
        return loadDrawableV4(context2, i11, theme);
    }

    private static Drawable loadDrawableV4(Context context, int i11, @Nullable Resources.Theme theme) {
        return h.e(context.getResources(), i11, theme);
    }

    private static Drawable loadDrawableV7(Context context, int i11, @Nullable Resources.Theme theme) {
        if (theme != null) {
            context = new g1.d(context, theme);
        }
        return d1.a.b(context, i11);
    }
}
