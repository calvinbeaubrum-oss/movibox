package androidx.core.os;

import android.os.Build;
import android.os.LocaleList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f7790b = a(new Locale[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f7791a;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(21)
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Locale[] f7792a = {new Locale("en", "XA"), new Locale("ar", "XB")};

        public static Locale a(String str) {
            return Locale.forLanguageTag(str);
        }

        public static boolean b(Locale locale) {
            for (Locale locale2 : f7792a) {
                if (locale2.equals(locale)) {
                    return true;
                }
            }
            return false;
        }

        public static boolean c(@NonNull Locale locale, @NonNull Locale locale2) {
            if (locale.equals(locale2)) {
                return true;
            }
            if (!locale.getLanguage().equals(locale2.getLanguage()) || b(locale) || b(locale2)) {
                return false;
            }
            String strA = androidx.core.text.b.a(locale);
            if (!strA.isEmpty()) {
                return strA.equals(androidx.core.text.b.a(locale2));
            }
            String country = locale.getCountry();
            return country.isEmpty() || country.equals(locale2.getCountry());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(24)
    public static class b {
        public static LocaleList a(Locale... localeArr) {
            return new LocaleList(localeArr);
        }

        public static LocaleList b() {
            return LocaleList.getAdjustedDefault();
        }

        public static LocaleList c() {
            return LocaleList.getDefault();
        }
    }

    public h(j jVar) {
        this.f7791a = jVar;
    }

    @NonNull
    public static h a(@NonNull Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? j(b.a(localeArr)) : new h(new i(localeArr));
    }

    public static Locale b(String str) {
        if (str.contains("-")) {
            String[] strArrSplit = str.split("-", -1);
            if (strArrSplit.length > 2) {
                return new Locale(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
            }
            if (strArrSplit.length > 1) {
                return new Locale(strArrSplit[0], strArrSplit[1]);
            }
            if (strArrSplit.length == 1) {
                return new Locale(strArrSplit[0]);
            }
        } else {
            if (!str.contains("_")) {
                return new Locale(str);
            }
            String[] strArrSplit2 = str.split("_", -1);
            if (strArrSplit2.length > 2) {
                return new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
            }
            if (strArrSplit2.length > 1) {
                return new Locale(strArrSplit2[0], strArrSplit2[1]);
            }
            if (strArrSplit2.length == 1) {
                return new Locale(strArrSplit2[0]);
            }
        }
        throw new IllegalArgumentException("Can not parse language tag: [" + str + "]");
    }

    @NonNull
    public static h c(@Nullable String str) {
        if (str == null || str.isEmpty()) {
            return e();
        }
        String[] strArrSplit = str.split(",", -1);
        int length = strArrSplit.length;
        Locale[] localeArr = new Locale[length];
        for (int i11 = 0; i11 < length; i11++) {
            localeArr[i11] = a.a(strArrSplit[i11]);
        }
        return a(localeArr);
    }

    @NonNull
    public static h e() {
        return f7790b;
    }

    @NonNull
    @RequiresApi(24)
    public static h j(@NonNull LocaleList localeList) {
        return new h(new o(localeList));
    }

    @Nullable
    public Locale d(int i11) {
        return this.f7791a.get(i11);
    }

    public boolean equals(Object obj) {
        return (obj instanceof h) && this.f7791a.equals(((h) obj).f7791a);
    }

    public boolean f() {
        return this.f7791a.isEmpty();
    }

    public int g() {
        return this.f7791a.size();
    }

    @NonNull
    public String h() {
        return this.f7791a.a();
    }

    public int hashCode() {
        return this.f7791a.hashCode();
    }

    @Nullable
    public Object i() {
        return this.f7791a.b();
    }

    @NonNull
    public String toString() {
        return this.f7791a.toString();
    }
}
