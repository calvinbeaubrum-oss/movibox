package androidx.core.os;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i implements j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Locale[] f7793c = new Locale[0];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Locale f7794d = new Locale("en", "XA");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Locale f7795e = new Locale("ar", "XB");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Locale f7796f = h.b("en-Latn");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Locale[] f7797a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final String f7798b;

    public i(@NonNull Locale... localeArr) {
        if (localeArr.length == 0) {
            this.f7797a = f7793c;
            this.f7798b = "";
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < localeArr.length; i11++) {
            Locale locale = localeArr[i11];
            if (locale == null) {
                throw new NullPointerException("list[" + i11 + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                c(sb2, locale2);
                if (i11 < localeArr.length - 1) {
                    sb2.append(',');
                }
                hashSet.add(locale2);
            }
        }
        this.f7797a = (Locale[]) arrayList.toArray(new Locale[0]);
        this.f7798b = sb2.toString();
    }

    public static void c(StringBuilder sb2, Locale locale) {
        sb2.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb2.append('-');
        sb2.append(locale.getCountry());
    }

    @Override // androidx.core.os.j
    public String a() {
        return this.f7798b;
    }

    @Override // androidx.core.os.j
    @Nullable
    public Object b() {
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        Locale[] localeArr = ((i) obj).f7797a;
        if (this.f7797a.length != localeArr.length) {
            return false;
        }
        int i11 = 0;
        while (true) {
            Locale[] localeArr2 = this.f7797a;
            if (i11 >= localeArr2.length) {
                return true;
            }
            if (!localeArr2[i11].equals(localeArr[i11])) {
                return false;
            }
            i11++;
        }
    }

    @Override // androidx.core.os.j
    public Locale get(int i11) {
        if (i11 >= 0) {
            Locale[] localeArr = this.f7797a;
            if (i11 < localeArr.length) {
                return localeArr[i11];
            }
        }
        return null;
    }

    public int hashCode() {
        int iHashCode = 1;
        for (Locale locale : this.f7797a) {
            iHashCode = (iHashCode * 31) + locale.hashCode();
        }
        return iHashCode;
    }

    @Override // androidx.core.os.j
    public boolean isEmpty() {
        return this.f7797a.length == 0;
    }

    @Override // androidx.core.os.j
    public int size() {
        return this.f7797a.length;
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        int i11 = 0;
        while (true) {
            Locale[] localeArr = this.f7797a;
            if (i11 >= localeArr.length) {
                sb2.append("]");
                return sb2.toString();
            }
            sb2.append(localeArr[i11]);
            if (i11 < this.f7797a.length - 1) {
                sb2.append(',');
            }
            i11++;
        }
    }
}
