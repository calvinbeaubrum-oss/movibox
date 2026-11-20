package okhttp3;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import java.io.EOFException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.collections.h;
import kotlin.collections.w;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.a;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.Buffer;
import okio.Utf8;

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
public final class HttpUrl {
    public static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    public static final String FRAGMENT_ENCODE_SET = "";
    public static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    public static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    public static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    public static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    public static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    public static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    public static final String QUERY_ENCODE_SET = " \"'<>#";
    public static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    private final String host;
    private final boolean isHttps;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;
    public static final Companion Companion = new Companion(null);
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Builder {
        public static final Companion Companion = new Companion(null);
        public static final String INVALID_HOST = "Invalid URL host";
        private String encodedFragment;
        private final List<String> encodedPathSegments;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = "";
        private String encodedPassword = "";
        private int port = -1;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int parsePort(String str, int i11, int i12) {
                try {
                    int i13 = Integer.parseInt(Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i11, i12, "", false, false, false, false, null, 248, null));
                    if (1 <= i13 && 65535 >= i13) {
                        return i13;
                    }
                    return -1;
                } catch (NumberFormatException unused) {
                    return -1;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int portColonOffset(String str, int i11, int i12) {
                while (i11 < i12) {
                    char cCharAt = str.charAt(i11);
                    if (cCharAt == ':') {
                        return i11;
                    }
                    if (cCharAt == '[') {
                        do {
                            i11++;
                            if (i11 >= i12) {
                                break;
                            }
                        } while (str.charAt(i11) != ']');
                    }
                    i11++;
                }
                return i12;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int schemeDelimiterOffset(String str, int i11, int i12) {
                if (i12 - i11 < 2) {
                    return -1;
                }
                char cCharAt = str.charAt(i11);
                if ((Intrinsics.i(cCharAt, 97) < 0 || Intrinsics.i(cCharAt, 122) > 0) && (Intrinsics.i(cCharAt, 65) < 0 || Intrinsics.i(cCharAt, 90) > 0)) {
                    return -1;
                }
                while (true) {
                    i11++;
                    if (i11 >= i12) {
                        return -1;
                    }
                    char cCharAt2 = str.charAt(i11);
                    if ('a' > cCharAt2 || 'z' < cCharAt2) {
                        if ('A' > cCharAt2 || 'Z' < cCharAt2) {
                            if ('0' > cCharAt2 || '9' < cCharAt2) {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i11;
                                    }
                                    return -1;
                                }
                            }
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public final int slashCount(String str, int i11, int i12) {
                int i13 = 0;
                while (i11 < i12) {
                    char cCharAt = str.charAt(i11);
                    if (cCharAt != '\\' && cCharAt != '/') {
                        break;
                    }
                    i13++;
                    i11++;
                }
                return i13;
            }
        }

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private final Builder addPathSegments(String str, boolean z11) {
            int i11 = 0;
            do {
                int iDelimiterOffset = Util.delimiterOffset(str, "/\\", i11, str.length());
                push(str, i11, iDelimiterOffset, iDelimiterOffset < str.length(), z11);
                i11 = iDelimiterOffset + 1;
            } while (i11 <= str.length());
            return this;
        }

        private final int effectivePort() {
            int i11 = this.port;
            if (i11 != -1) {
                return i11;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            Intrinsics.d(str);
            return companion.defaultPort(str);
        }

        private final boolean isDot(String str) {
            return Intrinsics.b(str, InstructionFileId.DOT) || l.v(str, "%2e", true);
        }

        private final boolean isDotDot(String str) {
            return Intrinsics.b(str, "..") || l.v(str, "%2e.", true) || l.v(str, ".%2e", true) || l.v(str, "%2e%2e", true);
        }

        private final void pop() {
            List<String> list = this.encodedPathSegments;
            if (list.remove(list.size() - 1).length() != 0 || !(!this.encodedPathSegments.isEmpty())) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private final void push(String str, int i11, int i12, boolean z11, boolean z12) {
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, i11, i12, HttpUrl.PATH_SEGMENT_ENCODE_SET, z12, false, false, false, null, 240, null);
            if (isDot(strCanonicalize$okhttp$default)) {
                return;
            }
            if (isDotDot(strCanonicalize$okhttp$default)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).length() == 0) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize$okhttp$default);
            } else {
                this.encodedPathSegments.add(strCanonicalize$okhttp$default);
            }
            if (z11) {
                this.encodedPathSegments.add("");
            }
        }

        private final void removeAllCanonicalQueryParameters(String str) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.d(list);
            IntProgression intProgressionQ = a.q(a.n(list.size() - 2, 0), 2);
            int iG = intProgressionQ.g();
            int i11 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if (iR >= 0) {
                if (iG > i11) {
                    return;
                }
            } else if (iG < i11) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                Intrinsics.d(list2);
                if (Intrinsics.b(str, list2.get(iG))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.d(list3);
                    list3.remove(iG + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.d(list4);
                    list4.remove(iG);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.d(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (iG == i11) {
                    return;
                } else {
                    iG += iR;
                }
            }
        }

        private final void resolvePath(String str, int i11, int i12) {
            if (i11 == i12) {
                return;
            }
            char cCharAt = str.charAt(i11);
            if (cCharAt == '/' || cCharAt == '\\') {
                this.encodedPathSegments.clear();
                this.encodedPathSegments.add("");
                i11++;
            } else {
                List<String> list = this.encodedPathSegments;
                list.set(list.size() - 1, "");
            }
            while (true) {
                int i13 = i11;
                if (i13 >= i12) {
                    return;
                }
                i11 = Util.delimiterOffset(str, "/\\", i13, i12);
                boolean z11 = i11 < i12;
                push(str, i13, i11, z11, true);
                if (z11) {
                    i11++;
                }
            }
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            Intrinsics.g(encodedPathSegment, "encodedPathSegment");
            push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            Intrinsics.g(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        public final Builder addEncodedQueryParameter(String encodedName, String str) {
            Intrinsics.g(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.d(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.d(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null) : null);
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            Intrinsics.g(pathSegment, "pathSegment");
            push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            Intrinsics.g(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addQueryParameter(String name, String str) {
            Intrinsics.g(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.d(list);
            Companion companion = HttpUrl.Companion;
            list.add(Companion.canonicalize$okhttp$default(companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            List<String> list2 = this.encodedQueryNamesAndValues;
            Intrinsics.d(list2);
            list2.add(str != null ? Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null) : null);
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            Companion companion = HttpUrl.Companion;
            String strPercentDecode$okhttp$default = Companion.percentDecode$okhttp$default(companion, this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$okhttp$default2 = Companion.percentDecode$okhttp$default(companion, this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            List<String> list = this.encodedPathSegments;
            ArrayList arrayList2 = new ArrayList(h.v(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(Companion.percentDecode$okhttp$default(HttpUrl.Companion, (String) it.next(), 0, 0, false, 7, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                List<String> list3 = list2;
                arrayList = new ArrayList(h.v(list3, 10));
                for (String str3 : list3) {
                    arrayList.add(str3 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str3, 0, 0, true, 3, null) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$okhttp$default, strPercentDecode$okhttp$default2, str2, iEffectivePort, arrayList2, arrayList, str4 != null ? Companion.percentDecode$okhttp$default(HttpUrl.Companion, str4, 0, 0, false, 7, null) : null, toString());
        }

        public final Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", true, false, false, true, null, 179, null) : null;
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            Intrinsics.g(encodedPassword, "encodedPassword");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            Intrinsics.g(encodedPath, "encodedPath");
            if (l.L(encodedPath, "/", false, 2, null)) {
                resolvePath(encodedPath, 0, encodedPath.length());
                return this;
            }
            throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        public final Builder encodedQuery(String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 211, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            Intrinsics.g(encodedUsername, "encodedUsername");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 243, null);
            return this;
        }

        public final Builder fragment(String str) {
            this.encodedFragment = str != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str, 0, 0, "", false, false, false, true, null, 187, null) : null;
            return this;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final Builder host(String host) {
            Intrinsics.g(host, "host");
            String canonicalHost = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, host, 0, 0, false, 7, null));
            if (canonicalHost != null) {
                this.host = canonicalHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + host);
        }

        public final Builder parse$okhttp(HttpUrl httpUrl, String input) {
            int iDelimiterOffset;
            int i11;
            int i12;
            String str;
            int i13;
            boolean z11;
            boolean z12;
            Intrinsics.g(input, "input");
            int iIndexOfFirstNonAsciiWhitespace$default = Util.indexOfFirstNonAsciiWhitespace$default(input, 0, 0, 3, null);
            int iIndexOfLastNonAsciiWhitespace$default = Util.indexOfLastNonAsciiWhitespace$default(input, iIndexOfFirstNonAsciiWhitespace$default, 0, 2, null);
            Companion companion = Companion;
            int iSchemeDelimiterOffset = companion.schemeDelimiterOffset(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            String str2 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
            byte b11 = -1;
            if (iSchemeDelimiterOffset != -1) {
                if (l.I(input, "https:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                    this.scheme = "https";
                    iIndexOfFirstNonAsciiWhitespace$default += 6;
                } else {
                    if (!l.I(input, "http:", iIndexOfFirstNonAsciiWhitespace$default, true)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = input.substring(0, iSchemeDelimiterOffset);
                        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sb2.append(strSubstring);
                        sb2.append("'");
                        throw new IllegalArgumentException(sb2.toString());
                    }
                    this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
                    iIndexOfFirstNonAsciiWhitespace$default += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme();
            }
            int iSlashCount = companion.slashCount(input, iIndexOfFirstNonAsciiWhitespace$default, iIndexOfLastNonAsciiWhitespace$default);
            byte b12 = Utf8.REPLACEMENT_BYTE;
            byte b13 = 35;
            if (iSlashCount >= 2 || httpUrl == null || (!Intrinsics.b(httpUrl.scheme(), this.scheme))) {
                int i14 = iIndexOfFirstNonAsciiWhitespace$default + iSlashCount;
                boolean z13 = false;
                boolean z14 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(input, "@/\\?#", i14, iIndexOfLastNonAsciiWhitespace$default);
                    byte bCharAt = iDelimiterOffset != iIndexOfLastNonAsciiWhitespace$default ? input.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == b11 || bCharAt == b13 || bCharAt == 47 || bCharAt == 92 || bCharAt == b12) {
                        break;
                    }
                    if (bCharAt != 64) {
                        str = str2;
                        iIndexOfLastNonAsciiWhitespace$default = iIndexOfLastNonAsciiWhitespace$default;
                    } else {
                        if (z13) {
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(this.encodedPassword);
                            sb3.append("%40");
                            str = str2;
                            i13 = iDelimiterOffset;
                            sb3.append(Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, i14, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null));
                            this.encodedPassword = sb3.toString();
                            z11 = z14;
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(input, ':', i14, iDelimiterOffset);
                            Companion companion2 = HttpUrl.Companion;
                            String str3 = str2;
                            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion2, input, i14, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                            if (z14) {
                                strCanonicalize$okhttp$default = this.encodedUsername + "%40" + strCanonicalize$okhttp$default;
                            }
                            this.encodedUsername = strCanonicalize$okhttp$default;
                            if (iDelimiterOffset2 != iDelimiterOffset) {
                                this.encodedPassword = Companion.canonicalize$okhttp$default(companion2, input, iDelimiterOffset2 + 1, iDelimiterOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240, null);
                                z12 = true;
                            } else {
                                z12 = z13;
                            }
                            z13 = z12;
                            str = str3;
                            z11 = true;
                            i13 = iDelimiterOffset;
                        }
                        i14 = i13 + 1;
                        z14 = z11;
                    }
                    str2 = str;
                    iIndexOfLastNonAsciiWhitespace$default = iIndexOfLastNonAsciiWhitespace$default;
                    b13 = 35;
                    b12 = Utf8.REPLACEMENT_BYTE;
                    b11 = -1;
                }
                String str4 = str2;
                i11 = iIndexOfLastNonAsciiWhitespace$default;
                Companion companion3 = Companion;
                int iPortColonOffset = companion3.portColonOffset(input, i14, iDelimiterOffset);
                int i15 = iPortColonOffset + 1;
                if (i15 < iDelimiterOffset) {
                    i12 = i14;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(HttpUrl.Companion, input, i14, iPortColonOffset, false, 4, null));
                    int port = companion3.parsePort(input, i15, iDelimiterOffset);
                    this.port = port;
                    if (!(port != -1)) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append("Invalid URL port: \"");
                        String strSubstring2 = input.substring(i15, iDelimiterOffset);
                        Intrinsics.f(strSubstring2, str4);
                        sb4.append(strSubstring2);
                        sb4.append('\"');
                        throw new IllegalArgumentException(sb4.toString().toString());
                    }
                } else {
                    i12 = i14;
                    Companion companion4 = HttpUrl.Companion;
                    this.host = HostnamesKt.toCanonicalHost(Companion.percentDecode$okhttp$default(companion4, input, i12, iPortColonOffset, false, 4, null));
                    String str5 = this.scheme;
                    Intrinsics.d(str5);
                    this.port = companion4.defaultPort(str5);
                }
                if (!(this.host != null)) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("Invalid URL host: \"");
                    String strSubstring3 = input.substring(i12, iPortColonOffset);
                    Intrinsics.f(strSubstring3, str4);
                    sb5.append(strSubstring3);
                    sb5.append('\"');
                    throw new IllegalArgumentException(sb5.toString().toString());
                }
                iIndexOfFirstNonAsciiWhitespace$default = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host();
                this.port = httpUrl.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iIndexOfFirstNonAsciiWhitespace$default == iIndexOfLastNonAsciiWhitespace$default || input.charAt(iIndexOfFirstNonAsciiWhitespace$default) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
                i11 = iIndexOfLastNonAsciiWhitespace$default;
            }
            int i16 = i11;
            int iDelimiterOffset3 = Util.delimiterOffset(input, "?#", iIndexOfFirstNonAsciiWhitespace$default, i16);
            resolvePath(input, iIndexOfFirstNonAsciiWhitespace$default, iDelimiterOffset3);
            if (iDelimiterOffset3 < i16 && input.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(input, '#', iDelimiterOffset3, i16);
                Companion companion5 = HttpUrl.Companion;
                this.encodedQueryNamesAndValues = companion5.toQueryNamesAndValues$okhttp(Companion.canonicalize$okhttp$default(companion5, input, iDelimiterOffset3 + 1, iDelimiterOffset4, HttpUrl.QUERY_ENCODE_SET, true, false, true, false, null, 208, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < i16 && input.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = Companion.canonicalize$okhttp$default(HttpUrl.Companion, input, iDelimiterOffset3 + 1, i16, "", true, false, false, true, null, 176, null);
            }
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.g(password, "password");
            this.encodedPassword = Companion.canonicalize$okhttp$default(HttpUrl.Companion, password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
            return this;
        }

        public final Builder port(int i11) {
            if (1 <= i11 && 65535 >= i11) {
                this.port = i11;
                return this;
            }
            throw new IllegalArgumentException(("unexpected port: " + i11).toString());
        }

        /* JADX WARN: Code duplicated, block: B:6:0x001d  */
        public final Builder query(String str) {
            List<String> queryNamesAndValues$okhttp;
            if (str != null) {
                Companion companion = HttpUrl.Companion;
                String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.QUERY_ENCODE_SET, false, false, true, false, null, 219, null);
                if (strCanonicalize$okhttp$default != null) {
                    queryNamesAndValues$okhttp = companion.toQueryNamesAndValues$okhttp(strCanonicalize$okhttp$default);
                } else {
                    queryNamesAndValues$okhttp = null;
                }
            } else {
                queryNamesAndValues$okhttp = null;
            }
            this.encodedQueryNamesAndValues = queryNamesAndValues$okhttp;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            String str = this.host;
            this.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
            int size = this.encodedPathSegments.size();
            for (int i11 = 0; i11 < size; i11++) {
                List<String> list = this.encodedPathSegments;
                list.set(i11, Companion.canonicalize$okhttp$default(HttpUrl.Companion, list.get(i11), 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, null, 227, null));
            }
            List<String> list2 = this.encodedQueryNamesAndValues;
            if (list2 != null) {
                int size2 = list2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    String str2 = list2.get(i12);
                    list2.set(i12, str2 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str2, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, null, 195, null) : null);
                }
            }
            String str3 = this.encodedFragment;
            this.encodedFragment = str3 != null ? Companion.canonicalize$okhttp$default(HttpUrl.Companion, str3, 0, 0, HttpUrl.FRAGMENT_ENCODE_SET_URI, true, true, false, true, null, 163, null) : null;
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            Intrinsics.g(encodedName, "encodedName");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedName, 0, 0, HttpUrl.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, null, 211, null));
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            Intrinsics.g(name, "name");
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(Companion.canonicalize$okhttp$default(HttpUrl.Companion, name, 0, 0, HttpUrl.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, null, 219, null));
            return this;
        }

        public final Builder removePathSegment(int i11) {
            this.encodedPathSegments.remove(i11);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public final Builder scheme(String scheme) {
            Intrinsics.g(scheme, "scheme");
            if (l.v(scheme, HttpHost.DEFAULT_SCHEME_NAME, true)) {
                this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            } else {
                if (!l.v(scheme, "https", true)) {
                    throw new IllegalArgumentException("unexpected scheme: " + scheme);
                }
                this.scheme = "https";
            }
            return this;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.g(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final Builder setEncodedPathSegment(int i11, String encodedPathSegment) {
            Intrinsics.g(encodedPathSegment, "encodedPathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, encodedPathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, true, false, false, false, null, 243, null);
            this.encodedPathSegments.set(i11, strCanonicalize$okhttp$default);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String str) {
            Intrinsics.g(encodedName, "encodedName");
            removeAllEncodedQueryParameters(encodedName);
            addEncodedQueryParameter(encodedName, str);
            return this;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.g(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final Builder setPathSegment(int i11, String pathSegment) {
            Intrinsics.g(pathSegment, "pathSegment");
            String strCanonicalize$okhttp$default = Companion.canonicalize$okhttp$default(HttpUrl.Companion, pathSegment, 0, 0, HttpUrl.PATH_SEGMENT_ENCODE_SET, false, false, false, false, null, 251, null);
            if ((isDot(strCanonicalize$okhttp$default) || isDotDot(strCanonicalize$okhttp$default)) ? false : true) {
                this.encodedPathSegments.set(i11, strCanonicalize$okhttp$default);
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
        }

        public final void setPort$okhttp(int i11) {
            this.port = i11;
        }

        public final Builder setQueryParameter(String name, String str) {
            Intrinsics.g(name, "name");
            removeAllQueryParameters(name);
            addQueryParameter(name, str);
            return this;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x0085  */
        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (this.encodedUsername.length() > 0 || this.encodedPassword.length() > 0) {
                sb2.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    sb2.append(':');
                    sb2.append(this.encodedPassword);
                }
                sb2.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                Intrinsics.d(str2);
                if (StringsKt__StringsKt.P(str2, ':', false, 2, null)) {
                    sb2.append('[');
                    sb2.append(this.host);
                    sb2.append(']');
                } else {
                    sb2.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int iEffectivePort = effectivePort();
                String str3 = this.scheme;
                if (str3 != null) {
                    Companion companion = HttpUrl.Companion;
                    Intrinsics.d(str3);
                    if (iEffectivePort != companion.defaultPort(str3)) {
                        sb2.append(':');
                        sb2.append(iEffectivePort);
                    }
                } else {
                    sb2.append(':');
                    sb2.append(iEffectivePort);
                }
            }
            Companion companion2 = HttpUrl.Companion;
            companion2.toPathString$okhttp(this.encodedPathSegments, sb2);
            if (this.encodedQueryNamesAndValues != null) {
                sb2.append('?');
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.d(list);
                companion2.toQueryString$okhttp(list, sb2);
            }
            if (this.encodedFragment != null) {
                sb2.append('#');
                sb2.append(this.encodedFragment);
            }
            String string = sb2.toString();
            Intrinsics.f(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }

        public final Builder username(String username) {
            Intrinsics.g(username, "username");
            this.encodedUsername = Companion.canonicalize$okhttp$default(HttpUrl.Companion, username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251, null);
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

        public static /* synthetic */ String canonicalize$okhttp$default(Companion companion, String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset, int i13, Object obj) {
            return companion.canonicalize$okhttp(str, (i13 & 1) != 0 ? 0 : i11, (i13 & 2) != 0 ? str.length() : i12, str2, (i13 & 8) != 0 ? false : z11, (i13 & 16) != 0 ? false : z12, (i13 & 32) != 0 ? false : z13, (i13 & 64) != 0 ? false : z14, (i13 & 128) != 0 ? null : charset);
        }

        private final boolean isPercentEncoded(String str, int i11, int i12) {
            int i13 = i11 + 2;
            return i13 < i12 && str.charAt(i11) == '%' && Util.parseHexDigit(str.charAt(i11 + 1)) != -1 && Util.parseHexDigit(str.charAt(i13)) != -1;
        }

        public static /* synthetic */ String percentDecode$okhttp$default(Companion companion, String str, int i11, int i12, boolean z11, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                i11 = 0;
            }
            if ((i13 & 2) != 0) {
                i12 = str.length();
            }
            if ((i13 & 4) != 0) {
                z11 = false;
            }
            return companion.percentDecode$okhttp(str, i11, i12, z11);
        }

        /* JADX WARN: Code duplicated, block: B:41:0x006a  */
        /* JADX WARN: Code duplicated, block: B:42:0x006c  */
        /* JADX WARN: Code duplicated, block: B:45:0x0074  */
        /* JADX WARN: Code duplicated, block: B:51:0x008d  */
        /* JADX WARN: Code duplicated, block: B:54:0x0096 A[LOOP:1: B:52:0x0090->B:54:0x0096, LOOP_END] */
        private final void writeCanonicalized(Buffer buffer, String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) throws EOFException {
            int iCharCount = i11;
            Buffer buffer2 = null;
            while (iCharCount < i12) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(iCharCount);
                if (!z11 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                    if (iCodePointAt == 43 && z13) {
                        buffer.writeUtf8(z11 ? "+" : "%2B");
                    } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z14) || StringsKt__StringsKt.P(str2, (char) iCodePointAt, false, 2, null))) {
                        if (buffer2 == null) {
                            buffer2 = new Buffer();
                        }
                        if (charset != null || Intrinsics.b(charset, StandardCharsets.UTF_8)) {
                            buffer2.writeUtf8CodePoint(iCodePointAt);
                        } else {
                            buffer2.writeString(str, iCharCount, Character.charCount(iCodePointAt) + iCharCount, charset);
                        }
                        while (!buffer2.exhausted()) {
                            byte b11 = buffer2.readByte();
                            buffer.writeByte(37);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[((b11 & 255) >> 4) & 15]);
                            buffer.writeByte((int) HttpUrl.HEX_DIGITS[b11 & Ascii.SI]);
                        }
                    } else {
                        if (iCodePointAt == 37) {
                            if (z11) {
                                if (z12) {
                                    if (!isPercentEncoded(str, iCharCount, i12)) {
                                    }
                                }
                            }
                            if (buffer2 == null) {
                                buffer2 = new Buffer();
                            }
                            if (charset != null) {
                                buffer2.writeUtf8CodePoint(iCodePointAt);
                            } else {
                                buffer2.writeUtf8CodePoint(iCodePointAt);
                            }
                            while (!buffer2.exhausted()) {
                                byte b12 = buffer2.readByte();
                                buffer.writeByte(37);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[((b12 & 255) >> 4) & 15]);
                                buffer.writeByte((int) HttpUrl.HEX_DIGITS[b12 & Ascii.SI]);
                            }
                        }
                        buffer.writeUtf8CodePoint(iCodePointAt);
                    }
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
        }

        private final void writePercentDecoded(Buffer buffer, String str, int i11, int i12, boolean z11) {
            int i13;
            while (i11 < i12) {
                if (str == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                int iCodePointAt = str.codePointAt(i11);
                if (iCodePointAt == 37 && (i13 = i11 + 2) < i12) {
                    int hexDigit = Util.parseHexDigit(str.charAt(i11 + 1));
                    int hexDigit2 = Util.parseHexDigit(str.charAt(i13));
                    if (hexDigit == -1 || hexDigit2 == -1) {
                        buffer.writeUtf8CodePoint(iCodePointAt);
                        i11 += Character.charCount(iCodePointAt);
                    } else {
                        buffer.writeByte((hexDigit << 4) + hexDigit2);
                        i11 = Character.charCount(iCodePointAt) + i13;
                    }
                } else if (iCodePointAt == 43 && z11) {
                    buffer.writeByte(32);
                    i11++;
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                    i11 += Character.charCount(iCodePointAt);
                }
            }
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m246deprecated_get(String url) {
            Intrinsics.g(url, "url");
            return get(url);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m247deprecated_get(URI uri) {
            Intrinsics.g(uri, "uri");
            return get(uri);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_get, reason: not valid java name */
        public final HttpUrl m248deprecated_get(URL url) {
            Intrinsics.g(url, "url");
            return get(url);
        }

        @Deprecated
        @JvmName
        /* JADX INFO: renamed from: -deprecated_parse, reason: not valid java name */
        public final HttpUrl m249deprecated_parse(String url) {
            Intrinsics.g(url, "url");
            return parse(url);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0041  */
        public final String canonicalize$okhttp(String canonicalize, int i11, int i12, String encodeSet, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) throws EOFException {
            Intrinsics.g(canonicalize, "$this$canonicalize");
            Intrinsics.g(encodeSet, "encodeSet");
            int iCharCount = i11;
            while (true) {
                if (iCharCount >= i12) {
                    String strSubstring = canonicalize.substring(i11, i12);
                    Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    return strSubstring;
                }
                int iCodePointAt = canonicalize.codePointAt(iCharCount);
                if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && !z14) || StringsKt__StringsKt.P(encodeSet, (char) iCodePointAt, false, 2, null))) {
                    break;
                }
                if (iCodePointAt == 37) {
                    if (!z11) {
                        break;
                    }
                    if (z12) {
                        if (isPercentEncoded(canonicalize, iCharCount, i12)) {
                        }
                    }
                    if (iCodePointAt == 43) {
                    }
                    iCharCount += Character.charCount(iCodePointAt);
                } else if (iCodePointAt == 43 || !z13) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
                Buffer buffer = new Buffer();
                buffer.writeUtf8(canonicalize, i11, iCharCount);
                writeCanonicalized(buffer, canonicalize, iCharCount, i12, encodeSet, z11, z12, z13, z14, charset);
                return buffer.readUtf8();
            }
            Buffer buffer2 = new Buffer();
            buffer2.writeUtf8(canonicalize, i11, iCharCount);
            writeCanonicalized(buffer2, canonicalize, iCharCount, i12, encodeSet, z11, z12, z13, z14, charset);
            return buffer2.readUtf8();
        }

        @JvmStatic
        public final int defaultPort(String scheme) {
            Intrinsics.g(scheme, "scheme");
            int iHashCode = scheme.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && scheme.equals("https")) {
                    return 443;
                }
            } else if (scheme.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
                return 80;
            }
            return -1;
        }

        @JvmStatic
        @JvmName
        public final HttpUrl get(String toHttpUrl) {
            Intrinsics.g(toHttpUrl, "$this$toHttpUrl");
            return new Builder().parse$okhttp(null, toHttpUrl).build();
        }

        @JvmStatic
        @JvmName
        public final HttpUrl get(URI toHttpUrlOrNull) {
            Intrinsics.g(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            Intrinsics.f(string, "toString()");
            return parse(string);
        }

        @JvmStatic
        @JvmName
        public final HttpUrl get(URL toHttpUrlOrNull) {
            Intrinsics.g(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            String string = toHttpUrlOrNull.toString();
            Intrinsics.f(string, "toString()");
            return parse(string);
        }

        @JvmStatic
        @JvmName
        public final HttpUrl parse(String toHttpUrlOrNull) {
            Intrinsics.g(toHttpUrlOrNull, "$this$toHttpUrlOrNull");
            try {
                return get(toHttpUrlOrNull);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public final String percentDecode$okhttp(String percentDecode, int i11, int i12, boolean z11) {
            Intrinsics.g(percentDecode, "$this$percentDecode");
            for (int i13 = i11; i13 < i12; i13++) {
                char cCharAt = percentDecode.charAt(i13);
                if (cCharAt == '%' || (cCharAt == '+' && z11)) {
                    Buffer buffer = new Buffer();
                    buffer.writeUtf8(percentDecode, i11, i13);
                    writePercentDecoded(buffer, percentDecode, i13, i12, z11);
                    return buffer.readUtf8();
                }
            }
            String strSubstring = percentDecode.substring(i11, i12);
            Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final void toPathString$okhttp(List<String> toPathString, StringBuilder out) {
            Intrinsics.g(toPathString, "$this$toPathString");
            Intrinsics.g(out, "out");
            int size = toPathString.size();
            for (int i11 = 0; i11 < size; i11++) {
                out.append('/');
                out.append(toPathString.get(i11));
            }
        }

        public final List<String> toQueryNamesAndValues$okhttp(String toQueryNamesAndValues) {
            Intrinsics.g(toQueryNamesAndValues, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i11 = 0;
            while (i11 <= toQueryNamesAndValues.length()) {
                int iC0 = StringsKt__StringsKt.c0(toQueryNamesAndValues, '&', i11, false, 4, null);
                if (iC0 == -1) {
                    iC0 = toQueryNamesAndValues.length();
                }
                int i12 = iC0;
                int iC1 = StringsKt__StringsKt.c0(toQueryNamesAndValues, '=', i11, false, 4, null);
                if (iC1 == -1 || iC1 > i12) {
                    String strSubstring = toQueryNamesAndValues.substring(i11, i12);
                    Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = toQueryNamesAndValues.substring(i11, iC1);
                    Intrinsics.f(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = toQueryNamesAndValues.substring(iC1 + 1, i12);
                    Intrinsics.f(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i11 = i12 + 1;
            }
            return arrayList;
        }

        public final void toQueryString$okhttp(List<String> toQueryString, StringBuilder out) {
            Intrinsics.g(toQueryString, "$this$toQueryString");
            Intrinsics.g(out, "out");
            IntProgression intProgressionQ = a.q(a.r(0, toQueryString.size()), 2);
            int iG = intProgressionQ.g();
            int i11 = intProgressionQ.i();
            int iR = intProgressionQ.r();
            if (iR >= 0) {
                if (iG > i11) {
                    return;
                }
            } else if (iG < i11) {
                return;
            }
            while (true) {
                String str = toQueryString.get(iG);
                String str2 = toQueryString.get(iG + 1);
                if (iG > 0) {
                    out.append('&');
                }
                out.append(str);
                if (str2 != null) {
                    out.append('=');
                    out.append(str2);
                }
                if (iG == i11) {
                    return;
                } else {
                    iG += iR;
                }
            }
        }
    }

    public HttpUrl(String scheme, String username, String password, String host, int i11, List<String> pathSegments, List<String> list, String str, String url) {
        Intrinsics.g(scheme, "scheme");
        Intrinsics.g(username, "username");
        Intrinsics.g(password, "password");
        Intrinsics.g(host, "host");
        Intrinsics.g(pathSegments, "pathSegments");
        Intrinsics.g(url, "url");
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = i11;
        this.pathSegments = pathSegments;
        this.queryNamesAndValues = list;
        this.fragment = str;
        this.url = url;
        this.isHttps = Intrinsics.b(scheme, "https");
    }

    @JvmStatic
    public static final int defaultPort(String str) {
        return Companion.defaultPort(str);
    }

    @JvmStatic
    @JvmName
    public static final HttpUrl get(String str) {
        return Companion.get(str);
    }

    @JvmStatic
    @JvmName
    public static final HttpUrl get(URI uri) {
        return Companion.get(uri);
    }

    @JvmStatic
    @JvmName
    public static final HttpUrl get(URL url) {
        return Companion.get(url);
    }

    @JvmStatic
    @JvmName
    public static final HttpUrl parse(String str) {
        return Companion.parse(str);
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedFragment, reason: not valid java name */
    public final String m227deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedPassword, reason: not valid java name */
    public final String m228deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedPath, reason: not valid java name */
    public final String m229deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedPathSegments, reason: not valid java name */
    public final List<String> m230deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedQuery, reason: not valid java name */
    public final String m231deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_encodedUsername, reason: not valid java name */
    public final String m232deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_fragment, reason: not valid java name */
    public final String m233deprecated_fragment() {
        return this.fragment;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_host, reason: not valid java name */
    public final String m234deprecated_host() {
        return this.host;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_password, reason: not valid java name */
    public final String m235deprecated_password() {
        return this.password;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_pathSegments, reason: not valid java name */
    public final List<String> m236deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_pathSize, reason: not valid java name */
    public final int m237deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_port, reason: not valid java name */
    public final int m238deprecated_port() {
        return this.port;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_query, reason: not valid java name */
    public final String m239deprecated_query() {
        return query();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_queryParameterNames, reason: not valid java name */
    public final Set<String> m240deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_querySize, reason: not valid java name */
    public final int m241deprecated_querySize() {
        return querySize();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_scheme, reason: not valid java name */
    public final String m242deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_uri, reason: not valid java name */
    public final URI m243deprecated_uri() {
        return uri();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_url, reason: not valid java name */
    public final URL m244deprecated_url() {
        return url();
    }

    @Deprecated
    @JvmName
    /* JADX INFO: renamed from: -deprecated_username, reason: not valid java name */
    public final String m245deprecated_username() {
        return this.username;
    }

    @JvmName
    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int iC0 = StringsKt__StringsKt.c0(this.url, '#', 0, false, 6, null) + 1;
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iC0);
        Intrinsics.f(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    @JvmName
    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return "";
        }
        int iC0 = StringsKt__StringsKt.c0(this.url, ':', this.scheme.length() + 3, false, 4, null) + 1;
        int iC1 = StringsKt__StringsKt.c0(this.url, '@', 0, false, 6, null);
        String str = this.url;
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iC0, iC1);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmName
    public final String encodedPath() {
        int iC0 = StringsKt__StringsKt.c0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iC0, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iC0, iDelimiterOffset);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmName
    public final List<String> encodedPathSegments() {
        int iC0 = StringsKt__StringsKt.c0(this.url, '/', this.scheme.length() + 3, false, 4, null);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, "?#", iC0, str.length());
        ArrayList arrayList = new ArrayList();
        while (iC0 < iDelimiterOffset) {
            int i11 = iC0 + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, '/', i11, iDelimiterOffset);
            String str2 = this.url;
            if (str2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i11, iDelimiterOffset2);
            Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iC0 = iDelimiterOffset2;
        }
        return arrayList;
    }

    @JvmName
    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iC0 = StringsKt__StringsKt.c0(this.url, '?', 0, false, 6, null) + 1;
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, '#', iC0, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iC0, iDelimiterOffset);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    @JvmName
    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, ":@", length, str.length());
        String str2 = this.url;
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iDelimiterOffset);
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics.b(((HttpUrl) obj).url, this.url);
    }

    @JvmName
    public final String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @JvmName
    public final String host() {
        return this.host;
    }

    public final boolean isHttps() {
        return this.isHttps;
    }

    public final Builder newBuilder() {
        Builder builder = new Builder();
        builder.setScheme$okhttp(this.scheme);
        builder.setEncodedUsername$okhttp(encodedUsername());
        builder.setEncodedPassword$okhttp(encodedPassword());
        builder.setHost$okhttp(this.host);
        builder.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        builder.getEncodedPathSegments$okhttp().clear();
        builder.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.setEncodedFragment$okhttp(encodedFragment());
        return builder;
    }

    public final Builder newBuilder(String link) {
        Intrinsics.g(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @JvmName
    public final String password() {
        return this.password;
    }

    @JvmName
    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    @JvmName
    public final int pathSize() {
        return this.pathSegments.size();
    }

    @JvmName
    public final int port() {
        return this.port;
    }

    @JvmName
    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        Companion.toQueryString$okhttp(this.queryNamesAndValues, sb2);
        return sb2.toString();
    }

    public final String queryParameter(String name) {
        Intrinsics.g(name, "name");
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        IntProgression intProgressionQ = a.q(a.r(0, list.size()), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if (iR < 0 ? iG >= i11 : iG <= i11) {
            while (!Intrinsics.b(name, this.queryNamesAndValues.get(iG))) {
                if (iG != i11) {
                    iG += iR;
                }
            }
            return this.queryNamesAndValues.get(iG + 1);
        }
        return null;
    }

    public final String queryParameterName(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = list.get(i11 * 2);
        Intrinsics.d(str);
        return str;
    }

    @JvmName
    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return w.f();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        IntProgression intProgressionQ = a.q(a.r(0, this.queryNamesAndValues.size()), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if (iR < 0 ? iG >= i11 : iG <= i11) {
            while (true) {
                String str = this.queryNamesAndValues.get(iG);
                Intrinsics.d(str);
                linkedHashSet.add(str);
                if (iG == i11) {
                    break;
                }
                iG += iR;
            }
        }
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet(linkedHashSet);
        Intrinsics.f(setUnmodifiableSet, "Collections.unmodifiableSet(result)");
        return setUnmodifiableSet;
    }

    public final String queryParameterValue(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i11 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public final List<String> queryParameterValues(String name) {
        Intrinsics.g(name, "name");
        if (this.queryNamesAndValues == null) {
            return g.l();
        }
        ArrayList arrayList = new ArrayList();
        IntProgression intProgressionQ = a.q(a.r(0, this.queryNamesAndValues.size()), 2);
        int iG = intProgressionQ.g();
        int i11 = intProgressionQ.i();
        int iR = intProgressionQ.r();
        if (iR < 0 ? iG >= i11 : iG <= i11) {
            while (true) {
                if (Intrinsics.b(name, this.queryNamesAndValues.get(iG))) {
                    arrayList.add(this.queryNamesAndValues.get(iG + 1));
                }
                if (iG == i11) {
                    break;
                }
                iG += iR;
            }
        }
        List<String> listUnmodifiableList = Collections.unmodifiableList(arrayList);
        Intrinsics.f(listUnmodifiableList, "Collections.unmodifiableList(result)");
        return listUnmodifiableList;
    }

    @JvmName
    public final int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        Intrinsics.d(builderNewBuilder);
        return builderNewBuilder.username("").password("").build().toString();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.g(link, "link");
        Builder builderNewBuilder = newBuilder(link);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    @JvmName
    public final String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (Util.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @JvmName
    public final URI uri() {
        String string = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e11) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics.f(uriCreate, "try {\n        val stripp…e) // Unexpected!\n      }");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e11);
            }
        }
    }

    @JvmName
    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e11) {
            throw new RuntimeException(e11);
        }
    }

    @JvmName
    public final String username() {
        return this.username;
    }
}
