package okhttp3;

import androidx.compose.foundation.e;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mbridge.msdk.MBridgeConstans;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import l.p;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = 253402300799999L;
        private String path = "/";

        private final Builder domain(String str, boolean z11) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost != null) {
                this.domain = canonicalHost;
                this.hostOnly = z11;
                return this;
            }
            throw new IllegalArgumentException("unexpected domain: " + str);
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j11 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j11, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String domain) {
            Intrinsics.g(domain, "domain");
            return domain(domain, false);
        }

        public final Builder expiresAt(long j11) {
            if (j11 <= 0) {
                j11 = Long.MIN_VALUE;
            }
            if (j11 > 253402300799999L) {
                j11 = 253402300799999L;
            }
            this.expiresAt = j11;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String domain) {
            Intrinsics.g(domain, "domain");
            return domain(domain, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String name) {
            Intrinsics.g(name, "name");
            if (!Intrinsics.b(StringsKt__StringsKt.Z0(name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.name = name;
            return this;
        }

        public final Builder path(String path) {
            Intrinsics.g(path, "path");
            if (!l.L(path, "/", false, 2, null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.path = path;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String value) {
            Intrinsics.g(value, "value");
            if (!Intrinsics.b(StringsKt__StringsKt.Z0(value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.value = value;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final int dateCharacterOffset(String str, int i11, int i12, boolean z11) {
            while (i11 < i12) {
                char cCharAt = str.charAt(i11);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z11)) {
                    return i11;
                }
                i11++;
            }
            return i12;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (Intrinsics.b(str, str2)) {
                return true;
            }
            return l.u(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (!(!l.u(str, InstructionFileId.DOT, false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(StringsKt__StringsKt.u0(str, InstructionFileId.DOT));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i11, int i12) {
            int iDateCharacterOffset = dateCharacterOffset(str, i11, i12, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i13 = -1;
            int i14 = -1;
            int i15 = -1;
            int iD0 = -1;
            int i16 = -1;
            int i17 = -1;
            while (iDateCharacterOffset < i12) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i12, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i14 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    Intrinsics.f(strGroup, "matcher.group(1)");
                    i14 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics.f(strGroup2, "matcher.group(2)");
                    i16 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    Intrinsics.f(strGroup3, "matcher.group(3)");
                    i17 = Integer.parseInt(strGroup3);
                } else if (i15 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    Intrinsics.f(strGroup4, "matcher.group(1)");
                    i15 = Integer.parseInt(strGroup4);
                } else if (iD0 == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.f(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    Intrinsics.f(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    Intrinsics.f(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.f(strPattern, "MONTH_PATTERN.pattern()");
                    iD0 = StringsKt__StringsKt.d0(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i13 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.f(strGroup6, "matcher.group(1)");
                    i13 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i12, false);
            }
            if (70 <= i13 && 99 >= i13) {
                i13 += 1900;
            }
            if (i13 >= 0 && 69 >= i13) {
                i13 += 2000;
            }
            if (!(i13 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iD0 != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i15 && 31 >= i15)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i14 >= 0 && 23 >= i14)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i16 >= 0 && 59 >= i16)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i17 >= 0 && 59 >= i17)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i13);
            gregorianCalendar.set(2, iD0 - 1);
            gregorianCalendar.set(5, i15);
            gregorianCalendar.set(11, i14);
            gregorianCalendar.set(12, i16);
            gregorianCalendar.set(13, i17);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) {
            try {
                long j11 = Long.parseLong(str);
                if (j11 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j11;
            } catch (NumberFormatException e11) {
                if (new Regex("-?\\d+").matches(str)) {
                    return l.L(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e11;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (Intrinsics.b(strEncodedPath, str)) {
                return true;
            }
            return l.L(strEncodedPath, str, false, 2, null) && (l.u(str, "/", false, 2, null) || strEncodedPath.charAt(str.length()) == '/');
        }

        @JvmStatic
        public final Cookie parse(HttpUrl url, String setCookie) {
            Intrinsics.g(url, "url");
            Intrinsics.g(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        /* JADX WARN: Code duplicated, block: B:43:0x00d7 A[PHI: r1
  0x00d7: PHI (r1v23 long) = (r1v7 long), (r1v10 long) binds: [B:42:0x00d5, B:53:0x00fe] A[DONT_GENERATE, DONT_INLINE]] */
        public final Cookie parse$okhttp(long j11, HttpUrl url, String setCookie) {
            long j12;
            long j13;
            Cookie cookie;
            String str;
            String str2;
            Intrinsics.g(url, "url");
            Intrinsics.g(setCookie, "setCookie");
            int iDelimiterOffset$default = Util.delimiterOffset$default(setCookie, ';', 0, 0, 6, (Object) null);
            int iDelimiterOffset$default2 = Util.delimiterOffset$default(setCookie, '=', 0, iDelimiterOffset$default, 2, (Object) null);
            if (iDelimiterOffset$default2 == iDelimiterOffset$default) {
                return null;
            }
            String strTrimSubstring$default = Util.trimSubstring$default(setCookie, 0, iDelimiterOffset$default2, 1, null);
            if (strTrimSubstring$default.length() == 0 || Util.indexOfControlOrNonAscii(strTrimSubstring$default) != -1) {
                return null;
            }
            String strTrimSubstring = Util.trimSubstring(setCookie, iDelimiterOffset$default2 + 1, iDelimiterOffset$default);
            if (Util.indexOfControlOrNonAscii(strTrimSubstring) != -1) {
                return null;
            }
            int i11 = iDelimiterOffset$default + 1;
            int length = setCookie.length();
            String domain = null;
            String str3 = null;
            long maxAge = -1;
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            boolean z14 = true;
            long expires = 253402300799999L;
            while (i11 < length) {
                int iDelimiterOffset = Util.delimiterOffset(setCookie, ';', i11, length);
                int iDelimiterOffset2 = Util.delimiterOffset(setCookie, '=', i11, iDelimiterOffset);
                String strTrimSubstring2 = Util.trimSubstring(setCookie, i11, iDelimiterOffset2);
                String strTrimSubstring3 = iDelimiterOffset2 < iDelimiterOffset ? Util.trimSubstring(setCookie, iDelimiterOffset2 + 1, iDelimiterOffset) : "";
                if (l.v(strTrimSubstring2, "expires", true)) {
                    try {
                        expires = parseExpires(strTrimSubstring3, 0, strTrimSubstring3.length());
                        z13 = true;
                    } catch (NumberFormatException | IllegalArgumentException unused) {
                    }
                } else if (l.v(strTrimSubstring2, "max-age", true)) {
                    maxAge = parseMaxAge(strTrimSubstring3);
                    z13 = true;
                } else if (l.v(strTrimSubstring2, "domain", true)) {
                    domain = parseDomain(strTrimSubstring3);
                    z14 = false;
                } else if (l.v(strTrimSubstring2, MBridgeConstans.DYNAMIC_VIEW_WX_PATH, true)) {
                    str3 = strTrimSubstring3;
                } else if (l.v(strTrimSubstring2, "secure", true)) {
                    z11 = true;
                } else if (l.v(strTrimSubstring2, "httponly", true)) {
                    z12 = true;
                }
                i11 = iDelimiterOffset + 1;
            }
            long j14 = Long.MIN_VALUE;
            if (maxAge == Long.MIN_VALUE) {
                j12 = j14;
            } else if (maxAge != -1) {
                j14 = j11 + (maxAge <= 9223372036854775L ? maxAge * ((long) 1000) : Long.MAX_VALUE);
                if (j14 >= j11) {
                    j13 = 253402300799999L;
                    if (j14 <= 253402300799999L) {
                        j12 = j14;
                    }
                } else {
                    j13 = 253402300799999L;
                }
                j12 = j13;
            } else {
                j12 = expires;
            }
            String strHost = url.host();
            if (domain == null) {
                str = strHost;
                cookie = null;
            } else {
                if (!domainMatch(strHost, domain)) {
                    return null;
                }
                cookie = null;
                str = domain;
            }
            if (strHost.length() != str.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(str) == null) {
                return cookie;
            }
            String strSubstring = "/";
            String str4 = str3;
            if (str4 == null || !l.L(str4, "/", false, 2, cookie)) {
                String strEncodedPath = url.encodedPath();
                int iI0 = StringsKt__StringsKt.i0(strEncodedPath, '/', 0, false, 6, null);
                if (iI0 != 0) {
                    if (strEncodedPath == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    strSubstring = strEncodedPath.substring(0, iI0);
                    Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                }
                str2 = strSubstring;
            } else {
                str2 = str4;
            }
            return new Cookie(strTrimSubstring$default, strTrimSubstring, j12, str, str2, z11, z12, z13, z14, null);
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            Intrinsics.g(url, "url");
            Intrinsics.g(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i11 = 0; i11 < size; i11++) {
                Cookie cookie = parse(url, listValues.get(i11));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return g.l();
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            Intrinsics.f(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
            return listUnmodifiableList;
        }
    }

    private Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j11;
        this.domain = str3;
        this.path = str4;
        this.secure = z11;
        this.httpOnly = z12;
        this.persistent = z13;
        this.hostOnly = z14;
    }

    public /* synthetic */ Cookie(String str, String str2, long j11, String str3, String str4, boolean z11, boolean z12, boolean z13, boolean z14, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j11, str3, str4, z11, z12, z13, z14);
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_domain, reason: not valid java name */
    public final String m206deprecated_domain() {
        return this.domain;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m207deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m208deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m209deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_name, reason: not valid java name */
    public final String m210deprecated_name() {
        return this.name;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_path, reason: not valid java name */
    public final String m211deprecated_path() {
        return this.path;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m212deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m213deprecated_secure() {
        return this.secure;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_value, reason: not valid java name */
    public final String m214deprecated_value() {
        return this.value;
    }

    @JvmName
    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (Intrinsics.b(cookie.name, this.name) && Intrinsics.b(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && Intrinsics.b(cookie.domain, this.domain) && Intrinsics.b(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    @JvmName
    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return ((((((((((((((((527 + this.name.hashCode()) * 31) + this.value.hashCode()) * 31) + p.a(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + e.a(this.secure)) * 31) + e.a(this.httpOnly)) * 31) + e.a(this.persistent)) * 31) + e.a(this.hostOnly);
    }

    @JvmName
    public final boolean hostOnly() {
        return this.hostOnly;
    }

    @JvmName
    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl url) {
        Intrinsics.g(url, "url");
        if ((this.hostOnly ? Intrinsics.b(url.host(), this.domain) : Companion.domainMatch(url.host(), this.domain)) && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    @JvmName
    public final String name() {
        return this.name;
    }

    @JvmName
    public final String path() {
        return this.path;
    }

    @JvmName
    public final boolean persistent() {
        return this.persistent;
    }

    @JvmName
    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.name);
        sb2.append('=');
        sb2.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb2.append("; max-age=0");
            } else {
                sb2.append("; expires=");
                sb2.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb2.append("; domain=");
            if (z11) {
                sb2.append(InstructionFileId.DOT);
            }
            sb2.append(this.domain);
        }
        sb2.append("; path=");
        sb2.append(this.path);
        if (this.secure) {
            sb2.append("; secure");
        }
        if (this.httpOnly) {
            sb2.append("; httponly");
        }
        String string = sb2.toString();
        Intrinsics.f(string, "toString()");
        return string;
    }

    @JvmName
    public final String value() {
        return this.value;
    }
}
