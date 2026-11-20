package dg;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.g;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f63028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f63029d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f63030e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<cg.c> f63031f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f63032g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f63033h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final String f63034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f63035b;

    static {
        String strA = e.a("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f63028c = strA;
        String strA2 = e.a("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        f63029d = strA2;
        String strA3 = e.a("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f63030e = strA3;
        f63031f = Collections.unmodifiableSet(new HashSet(Arrays.asList(cg.c.b("proto"), cg.c.b("json"))));
        f63032g = new a(strA, null);
        f63033h = new a(strA2, strA3);
    }

    public a(@NonNull String str, @Nullable String str2) {
        this.f63034a = str;
        this.f63035b = str2;
    }

    @NonNull
    public static a c(@NonNull byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }

    @Override // com.google.android.datatransport.runtime.g
    public Set<cg.c> a() {
        return f63031f;
    }

    @Nullable
    public byte[] b() {
        String str = this.f63035b;
        if (str == null && this.f63034a == null) {
            return null;
        }
        Object[] objArr = new Object[4];
        objArr[0] = "1$";
        objArr[1] = this.f63034a;
        objArr[2] = "\\";
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("%s%s%s%s", objArr).getBytes(Charset.forName("UTF-8"));
    }

    @Nullable
    public String d() {
        return this.f63035b;
    }

    @NonNull
    public String e() {
        return this.f63034a;
    }

    @Override // com.google.android.datatransport.runtime.f
    @Nullable
    public byte[] getExtras() {
        return b();
    }

    @Override // com.google.android.datatransport.runtime.f
    @NonNull
    public String getName() {
        return "cct";
    }
}
