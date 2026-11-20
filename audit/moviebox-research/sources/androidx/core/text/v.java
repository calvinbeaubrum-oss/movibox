package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public static int a(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
