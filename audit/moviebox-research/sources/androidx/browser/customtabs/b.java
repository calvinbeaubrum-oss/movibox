package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Integer f1822a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f1823b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final Integer f1824c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final Integer f1825d;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public Integer f1826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Integer f1827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public Integer f1828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @Nullable
        public Integer f1829d;

        @NonNull
        public b a() {
            return new b(this.f1826a, this.f1827b, this.f1828c, this.f1829d);
        }

        @NonNull
        public a b(int i11) {
            this.f1826a = Integer.valueOf(i11 | ViewCompat.MEASURED_STATE_MASK);
            return this;
        }
    }

    public b(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable Integer num4) {
        this.f1822a = num;
        this.f1823b = num2;
        this.f1824c = num3;
        this.f1825d = num4;
    }

    @NonNull
    public Bundle a() {
        Bundle bundle = new Bundle();
        Integer num = this.f1822a;
        if (num != null) {
            bundle.putInt("android.support.customtabs.extra.TOOLBAR_COLOR", num.intValue());
        }
        Integer num2 = this.f1823b;
        if (num2 != null) {
            bundle.putInt("android.support.customtabs.extra.SECONDARY_TOOLBAR_COLOR", num2.intValue());
        }
        Integer num3 = this.f1824c;
        if (num3 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_COLOR", num3.intValue());
        }
        Integer num4 = this.f1825d;
        if (num4 != null) {
            bundle.putInt("androidx.browser.customtabs.extra.NAVIGATION_BAR_DIVIDER_COLOR", num4.intValue());
        }
        return bundle;
    }
}
