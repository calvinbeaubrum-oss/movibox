package com.mbridge.msdk.thrid.okhttp;

import com.amazonaws.services.s3.model.InstructionFileId;
import com.applovin.exoplayer2.common.base.Ascii;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okhttp.internal.publicsuffix.PublicSuffixDatabase;
import com.mbridge.msdk.thrid.okio.Buffer;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpUrl {
    static final String FORM_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#&!$(),~";
    static final String FRAGMENT_ENCODE_SET = "";
    static final String FRAGMENT_ENCODE_SET_URI = " \"#<>\\^`{|}";
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    static final String PASSWORD_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET = " \"<>^`{}|/\\?#";
    static final String PATH_SEGMENT_ENCODE_SET_URI = "[]";
    static final String QUERY_COMPONENT_ENCODE_SET = " !\"#$&'(),/:;<=>?@[]\\^`{|}~";
    static final String QUERY_COMPONENT_ENCODE_SET_URI = "\\^`{|}";
    static final String QUERY_COMPONENT_REENCODE_SET = " \"'<>#&=";
    static final String QUERY_ENCODE_SET = " \"'<>#";
    static final String USERNAME_ENCODE_SET = " \"':;<=>@[]^`{}|/\\?#";
    private final String fragment;
    final String host;
    private final String password;
    private final List<String> pathSegments;
    final int port;
    private final List<String> queryNamesAndValues;
    final String scheme;
    private final String url;
    private final String username;

    /* JADX INFO: compiled from: source.java */
    public static final class Builder {
        static final String INVALID_HOST = "Invalid URL host";
        String encodedFragment;
        final List<String> encodedPathSegments;
        List<String> encodedQueryNamesAndValues;
        String host;
        String scheme;
        String encodedUsername = "";
        String encodedPassword = "";
        int port = -1;

        public Builder() {
            ArrayList arrayList = new ArrayList();
            this.encodedPathSegments = arrayList;
            arrayList.add("");
        }

        private Builder addPathSegments(String str, boolean z11) {
            int i11 = 0;
            do {
                int iDelimiterOffset = Util.delimiterOffset(str, i11, str.length(), "/\\");
                push(str, i11, iDelimiterOffset, iDelimiterOffset < str.length(), z11);
                i11 = iDelimiterOffset + 1;
            } while (i11 <= str.length());
            return this;
        }

        private static String canonicalizeHost(String str, int i11, int i12) {
            return Util.canonicalizeHost(HttpUrl.percentDecode(str, i11, i12, false));
        }

        private boolean isDot(String str) {
            return str.equals(InstructionFileId.DOT) || str.equalsIgnoreCase("%2e");
        }

        private boolean isDotDot(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int parsePort(String str, int i11, int i12) {
            try {
                int i13 = Integer.parseInt(HttpUrl.canonicalize(str, i11, i12, "", false, false, false, true, null));
                if (i13 <= 0 || i13 > 65535) {
                    return -1;
                }
                return i13;
            } catch (NumberFormatException unused) {
            }
        }

        private void pop() {
            List<String> list = this.encodedPathSegments;
            if (!list.remove(list.size() - 1).isEmpty() || this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            } else {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, "");
            }
        }

        private static int portColonOffset(String str, int i11, int i12) {
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

        private void push(String str, int i11, int i12, boolean z11, boolean z12) {
            String strCanonicalize = HttpUrl.canonicalize(str, i11, i12, " \"<>^`{}|/\\?#", z12, false, false, true, null);
            if (isDot(strCanonicalize)) {
                return;
            }
            if (isDotDot(strCanonicalize)) {
                pop();
                return;
            }
            List<String> list = this.encodedPathSegments;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.encodedPathSegments;
                list2.set(list2.size() - 1, strCanonicalize);
            } else {
                this.encodedPathSegments.add(strCanonicalize);
            }
            if (z11) {
                this.encodedPathSegments.add("");
            }
        }

        private void removeAllCanonicalQueryParameters(String str) {
            for (int size = this.encodedQueryNamesAndValues.size() - 2; size >= 0; size -= 2) {
                if (str.equals(this.encodedQueryNamesAndValues.get(size))) {
                    this.encodedQueryNamesAndValues.remove(size + 1);
                    this.encodedQueryNamesAndValues.remove(size);
                    if (this.encodedQueryNamesAndValues.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
            }
        }

        private void resolvePath(String str, int i11, int i12) {
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
                i11 = Util.delimiterOffset(str, i13, i12, "/\\");
                boolean z11 = i11 < i12;
                push(str, i13, i11, z11, true);
                if (z11) {
                    i11++;
                }
            }
        }

        private static int schemeDelimiterOffset(String str, int i11, int i12) {
            if (i12 - i11 < 2) {
                return -1;
            }
            char cCharAt = str.charAt(i11);
            if ((cCharAt >= 'a' && cCharAt <= 'z') || (cCharAt >= 'A' && cCharAt <= 'Z')) {
                while (true) {
                    i11++;
                    if (i11 >= i12) {
                        break;
                    }
                    char cCharAt2 = str.charAt(i11);
                    if (cCharAt2 < 'a' || cCharAt2 > 'z') {
                        if (cCharAt2 < 'A' || cCharAt2 > 'Z') {
                            if (cCharAt2 < '0' || cCharAt2 > '9') {
                                if (cCharAt2 != '+' && cCharAt2 != '-' && cCharAt2 != '.') {
                                    if (cCharAt2 == ':') {
                                        return i11;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int slashCount(String str, int i11, int i12) {
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

        public Builder addEncodedPathSegment(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            push(str, 0, str.length(), false, true);
            return this;
        }

        public Builder addEncodedPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, true);
            }
            throw new NullPointerException("encodedPathSegments == null");
        }

        public Builder addEncodedQueryParameter(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, " \"'<>#&=", true, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, " \"'<>#&=", true, false, true, true) : null);
            return this;
        }

        public Builder addPathSegment(String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            push(str, 0, str.length(), false, false);
            return this;
        }

        public Builder addPathSegments(String str) {
            if (str != null) {
                return addPathSegments(str, false);
            }
            throw new NullPointerException("pathSegments == null");
        }

        public Builder addQueryParameter(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                this.encodedQueryNamesAndValues = new ArrayList();
            }
            this.encodedQueryNamesAndValues.add(HttpUrl.canonicalize(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            this.encodedQueryNamesAndValues.add(str2 != null ? HttpUrl.canonicalize(str2, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true) : null);
            return this;
        }

        public HttpUrl build() {
            if (this.scheme == null) {
                throw new IllegalStateException("scheme == null");
            }
            if (this.host != null) {
                return new HttpUrl(this);
            }
            throw new IllegalStateException("host == null");
        }

        public int effectivePort() {
            int i11 = this.port;
            return i11 != -1 ? i11 : HttpUrl.defaultPort(this.scheme);
        }

        public Builder encodedFragment(String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", true, false, false, false) : null;
            return this;
        }

        public Builder encodedPassword(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPassword == null");
            }
            this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder encodedPath(String str) {
            if (str == null) {
                throw new NullPointerException("encodedPath == null");
            }
            if (str.startsWith("/")) {
                resolvePath(str, 0, str.length());
                return this;
            }
            throw new IllegalArgumentException("unexpected encodedPath: " + str);
        }

        public Builder encodedQuery(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public Builder encodedUsername(String str) {
            if (str == null) {
                throw new NullPointerException("encodedUsername == null");
            }
            this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
            return this;
        }

        public Builder fragment(String str) {
            this.encodedFragment = str != null ? HttpUrl.canonicalize(str, "", false, false, false, false) : null;
            return this;
        }

        public Builder host(String str) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            String strCanonicalizeHost = canonicalizeHost(str, 0, str.length());
            if (strCanonicalizeHost != null) {
                this.host = strCanonicalizeHost;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        public Builder parse(HttpUrl httpUrl, String str) {
            int iDelimiterOffset;
            int i11;
            int iSkipLeadingAsciiWhitespace = Util.skipLeadingAsciiWhitespace(str, 0, str.length());
            int iSkipTrailingAsciiWhitespace = Util.skipTrailingAsciiWhitespace(str, iSkipLeadingAsciiWhitespace, str.length());
            int iSchemeDelimiterOffset = schemeDelimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            if (iSchemeDelimiterOffset != -1) {
                if (str.regionMatches(true, iSkipLeadingAsciiWhitespace, "https:", 0, 6)) {
                    this.scheme = "https";
                    iSkipLeadingAsciiWhitespace += 6;
                } else {
                    if (!str.regionMatches(true, iSkipLeadingAsciiWhitespace, "http:", 0, 5)) {
                        throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, iSchemeDelimiterOffset) + "'");
                    }
                    this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
                    iSkipLeadingAsciiWhitespace += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.scheme = httpUrl.scheme;
            }
            int iSlashCount = slashCount(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace);
            char c11 = '?';
            char c12 = '#';
            if (iSlashCount >= 2 || httpUrl == null || !httpUrl.scheme.equals(this.scheme)) {
                int i12 = iSkipLeadingAsciiWhitespace + iSlashCount;
                boolean z11 = false;
                boolean z12 = false;
                while (true) {
                    iDelimiterOffset = Util.delimiterOffset(str, i12, iSkipTrailingAsciiWhitespace, "@/\\?#");
                    byte bCharAt = iDelimiterOffset != iSkipTrailingAsciiWhitespace ? str.charAt(iDelimiterOffset) : (byte) -1;
                    if (bCharAt == -1 || bCharAt == c12 || bCharAt == 47 || bCharAt == 92 || bCharAt == c11) {
                        break;
                    }
                    if (bCharAt == 64) {
                        if (z11) {
                            i11 = iDelimiterOffset;
                            this.encodedPassword += "%40" + HttpUrl.canonicalize(str, i12, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        } else {
                            int iDelimiterOffset2 = Util.delimiterOffset(str, i12, iDelimiterOffset, ':');
                            i11 = iDelimiterOffset;
                            String strCanonicalize = HttpUrl.canonicalize(str, i12, iDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z12) {
                                strCanonicalize = this.encodedUsername + "%40" + strCanonicalize;
                            }
                            this.encodedUsername = strCanonicalize;
                            if (iDelimiterOffset2 != i11) {
                                this.encodedPassword = HttpUrl.canonicalize(str, iDelimiterOffset2 + 1, i11, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z11 = true;
                            }
                            z12 = true;
                        }
                        i12 = i11 + 1;
                    }
                    c11 = '?';
                    c12 = '#';
                }
                int iPortColonOffset = portColonOffset(str, i12, iDelimiterOffset);
                int i13 = iPortColonOffset + 1;
                if (i13 < iDelimiterOffset) {
                    this.host = canonicalizeHost(str, i12, iPortColonOffset);
                    int port = parsePort(str, i13, iDelimiterOffset);
                    this.port = port;
                    if (port == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i13, iDelimiterOffset) + '\"');
                    }
                } else {
                    this.host = canonicalizeHost(str, i12, iPortColonOffset);
                    this.port = HttpUrl.defaultPort(this.scheme);
                }
                if (this.host == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i12, iPortColonOffset) + '\"');
                }
                iSkipLeadingAsciiWhitespace = iDelimiterOffset;
            } else {
                this.encodedUsername = httpUrl.encodedUsername();
                this.encodedPassword = httpUrl.encodedPassword();
                this.host = httpUrl.host;
                this.port = httpUrl.port;
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(httpUrl.encodedPathSegments());
                if (iSkipLeadingAsciiWhitespace == iSkipTrailingAsciiWhitespace || str.charAt(iSkipLeadingAsciiWhitespace) == '#') {
                    encodedQuery(httpUrl.encodedQuery());
                }
            }
            int iDelimiterOffset3 = Util.delimiterOffset(str, iSkipLeadingAsciiWhitespace, iSkipTrailingAsciiWhitespace, "?#");
            resolvePath(str, iSkipLeadingAsciiWhitespace, iDelimiterOffset3);
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '?') {
                int iDelimiterOffset4 = Util.delimiterOffset(str, iDelimiterOffset3, iSkipTrailingAsciiWhitespace, '#');
                this.encodedQueryNamesAndValues = HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, iDelimiterOffset3 + 1, iDelimiterOffset4, " \"'<>#", true, false, true, true, null));
                iDelimiterOffset3 = iDelimiterOffset4;
            }
            if (iDelimiterOffset3 < iSkipTrailingAsciiWhitespace && str.charAt(iDelimiterOffset3) == '#') {
                this.encodedFragment = HttpUrl.canonicalize(str, 1 + iDelimiterOffset3, iSkipTrailingAsciiWhitespace, "", true, false, false, false, null);
            }
            return this;
        }

        public Builder password(String str) {
            if (str == null) {
                throw new NullPointerException("password == null");
            }
            this.encodedPassword = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public Builder port(int i11) {
            if (i11 > 0 && i11 <= 65535) {
                this.port = i11;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i11);
        }

        public Builder query(String str) {
            this.encodedQueryNamesAndValues = str != null ? HttpUrl.queryStringToNamesAndValues(HttpUrl.canonicalize(str, " \"'<>#", false, false, true, true)) : null;
            return this;
        }

        public Builder reencodeForUri() {
            int size = this.encodedPathSegments.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.encodedPathSegments.set(i11, HttpUrl.canonicalize(this.encodedPathSegments.get(i11), "[]", true, true, false, true));
            }
            List<String> list = this.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    String str = this.encodedQueryNamesAndValues.get(i12);
                    if (str != null) {
                        this.encodedQueryNamesAndValues.set(i12, HttpUrl.canonicalize(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.encodedFragment;
            if (str2 != null) {
                this.encodedFragment = HttpUrl.canonicalize(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public Builder removeAllEncodedQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("encodedName == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, " \"'<>#&=", true, false, true, true));
            return this;
        }

        public Builder removeAllQueryParameters(String str) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (this.encodedQueryNamesAndValues == null) {
                return this;
            }
            removeAllCanonicalQueryParameters(HttpUrl.canonicalize(str, " !\"#$&'(),/:;<=>?@[]\\^`{|}~", false, false, true, true));
            return this;
        }

        public Builder removePathSegment(int i11) {
            this.encodedPathSegments.remove(i11);
            if (this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.add("");
            }
            return this;
        }

        public Builder scheme(String str) {
            if (str == null) {
                throw new NullPointerException("scheme == null");
            }
            if (str.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
                this.scheme = HttpHost.DEFAULT_SCHEME_NAME;
            } else {
                if (!str.equalsIgnoreCase("https")) {
                    throw new IllegalArgumentException("unexpected scheme: " + str);
                }
                this.scheme = "https";
            }
            return this;
        }

        public Builder setEncodedPathSegment(int i11, String str) {
            if (str == null) {
                throw new NullPointerException("encodedPathSegment == null");
            }
            String strCanonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", true, false, false, true, null);
            this.encodedPathSegments.set(i11, strCanonicalize);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setEncodedQueryParameter(String str, String str2) {
            removeAllEncodedQueryParameters(str);
            addEncodedQueryParameter(str, str2);
            return this;
        }

        public Builder setPathSegment(int i11, String str) {
            if (str == null) {
                throw new NullPointerException("pathSegment == null");
            }
            String strCanonicalize = HttpUrl.canonicalize(str, 0, str.length(), " \"<>^`{}|/\\?#", false, false, false, true, null);
            if (!isDot(strCanonicalize) && !isDotDot(strCanonicalize)) {
                this.encodedPathSegments.set(i11, strCanonicalize);
                return this;
            }
            throw new IllegalArgumentException("unexpected path segment: " + str);
        }

        public Builder setQueryParameter(String str, String str2) {
            removeAllQueryParameters(str);
            addQueryParameter(str, str2);
            return this;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            String str = this.scheme;
            if (str != null) {
                sb2.append(str);
                sb2.append("://");
            } else {
                sb2.append("//");
            }
            if (!this.encodedUsername.isEmpty() || !this.encodedPassword.isEmpty()) {
                sb2.append(this.encodedUsername);
                if (!this.encodedPassword.isEmpty()) {
                    sb2.append(':');
                    sb2.append(this.encodedPassword);
                }
                sb2.append('@');
            }
            String str2 = this.host;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
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
                if (str3 == null || iEffectivePort != HttpUrl.defaultPort(str3)) {
                    sb2.append(':');
                    sb2.append(iEffectivePort);
                }
            }
            HttpUrl.pathSegmentsToString(sb2, this.encodedPathSegments);
            if (this.encodedQueryNamesAndValues != null) {
                sb2.append('?');
                HttpUrl.namesAndValuesToQueryString(sb2, this.encodedQueryNamesAndValues);
            }
            if (this.encodedFragment != null) {
                sb2.append('#');
                sb2.append(this.encodedFragment);
            }
            return sb2.toString();
        }

        public Builder username(String str) {
            if (str == null) {
                throw new NullPointerException("username == null");
            }
            this.encodedUsername = HttpUrl.canonicalize(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }
    }

    public HttpUrl(Builder builder) {
        this.scheme = builder.scheme;
        this.username = percentDecode(builder.encodedUsername, false);
        this.password = percentDecode(builder.encodedPassword, false);
        this.host = builder.host;
        this.port = builder.effectivePort();
        this.pathSegments = percentDecode(builder.encodedPathSegments, false);
        List<String> list = builder.encodedQueryNamesAndValues;
        this.queryNamesAndValues = list != null ? percentDecode(list, true) : null;
        String str = builder.encodedFragment;
        this.fragment = str != null ? percentDecode(str, false) : null;
        this.url = builder.toString();
    }

    public static String canonicalize(String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
        int iCharCount = i11;
        while (iCharCount < i12) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt >= 32 && iCodePointAt != 127 && (iCodePointAt < 128 || !z14)) {
                if (str2.indexOf(iCodePointAt) == -1 && ((iCodePointAt != 37 || (z11 && (!z12 || percentEncoded(str, iCharCount, i12)))) && (iCodePointAt != 43 || !z13))) {
                    iCharCount += Character.charCount(iCodePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i11, iCharCount);
            canonicalize(buffer, str, iCharCount, i12, str2, z11, z12, z13, z14, charset);
            return buffer.readUtf8();
        }
        return str.substring(i11, i12);
    }

    public static String canonicalize(String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14) {
        return canonicalize(str, 0, str.length(), str2, z11, z12, z13, z14, null);
    }

    public static String canonicalize(String str, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
        return canonicalize(str, 0, str.length(), str2, z11, z12, z13, z14, charset);
    }

    public static void canonicalize(Buffer buffer, String str, int i11, int i12, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Charset charset) {
        Buffer buffer2 = null;
        while (i11 < i12) {
            int iCodePointAt = str.codePointAt(i11);
            if (!z11 || (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 12 && iCodePointAt != 13)) {
                if (iCodePointAt == 43 && z13) {
                    buffer.writeUtf8(z11 ? "+" : "%2B");
                } else if (iCodePointAt < 32 || iCodePointAt == 127 || ((iCodePointAt >= 128 && z14) || str2.indexOf(iCodePointAt) != -1 || (iCodePointAt == 37 && (!z11 || (z12 && !percentEncoded(str, i11, i12)))))) {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset == null || charset.equals(Util.UTF_8)) {
                        buffer2.writeUtf8CodePoint(iCodePointAt);
                    } else {
                        buffer2.writeString(str, i11, Character.charCount(iCodePointAt) + i11, charset);
                    }
                    while (!buffer2.exhausted()) {
                        byte b11 = buffer2.readByte();
                        buffer.writeByte(37);
                        char[] cArr = HEX_DIGITS;
                        buffer.writeByte((int) cArr[((b11 & 255) >> 4) & 15]);
                        buffer.writeByte((int) cArr[b11 & Ascii.SI]);
                    }
                } else {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                }
            }
            i11 += Character.charCount(iCodePointAt);
        }
    }

    public static int defaultPort(String str) {
        if (str.equals(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static HttpUrl get(String str) {
        return new Builder().parse(null, str).build();
    }

    public static HttpUrl get(URI uri) {
        return parse(uri.toString());
    }

    public static HttpUrl get(URL url) {
        return parse(url.toString());
    }

    public static void namesAndValuesToQueryString(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            String str = list.get(i11);
            String str2 = list.get(i11 + 1);
            if (i11 > 0) {
                sb2.append('&');
            }
            sb2.append(str);
            if (str2 != null) {
                sb2.append('=');
                sb2.append(str2);
            }
        }
    }

    public static HttpUrl parse(String str) {
        try {
            return get(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public static void pathSegmentsToString(StringBuilder sb2, List<String> list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            sb2.append('/');
            sb2.append(list.get(i11));
        }
    }

    public static String percentDecode(String str, int i11, int i12, boolean z11) {
        for (int i13 = i11; i13 < i12; i13++) {
            char cCharAt = str.charAt(i13);
            if (cCharAt == '%' || (cCharAt == '+' && z11)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i11, i13);
                percentDecode(buffer, str, i13, i12, z11);
                return buffer.readUtf8();
            }
        }
        return str.substring(i11, i12);
    }

    public static String percentDecode(String str, boolean z11) {
        return percentDecode(str, 0, str.length(), z11);
    }

    private List<String> percentDecode(List<String> list, boolean z11) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i11 = 0; i11 < size; i11++) {
            String str = list.get(i11);
            arrayList.add(str != null ? percentDecode(str, z11) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0039  */
    public static void percentDecode(Buffer buffer, String str, int i11, int i12, boolean z11) {
        int i13;
        while (i11 < i12) {
            int iCodePointAt = str.codePointAt(i11);
            if (iCodePointAt == 37 && (i13 = i11 + 2) < i12) {
                int iDecodeHexDigit = Util.decodeHexDigit(str.charAt(i11 + 1));
                int iDecodeHexDigit2 = Util.decodeHexDigit(str.charAt(i13));
                if (iDecodeHexDigit == -1 || iDecodeHexDigit2 == -1) {
                    buffer.writeUtf8CodePoint(iCodePointAt);
                } else {
                    buffer.writeByte((iDecodeHexDigit << 4) + iDecodeHexDigit2);
                    i11 = i13;
                }
            } else if (iCodePointAt == 43 && z11) {
                buffer.writeByte(32);
            } else {
                buffer.writeUtf8CodePoint(iCodePointAt);
            }
            i11 += Character.charCount(iCodePointAt);
        }
    }

    public static boolean percentEncoded(String str, int i11, int i12) {
        int i13 = i11 + 2;
        return i13 < i12 && str.charAt(i11) == '%' && Util.decodeHexDigit(str.charAt(i11 + 1)) != -1 && Util.decodeHexDigit(str.charAt(i13)) != -1;
    }

    public static List<String> queryStringToNamesAndValues(String str) {
        ArrayList arrayList = new ArrayList();
        int i11 = 0;
        while (i11 <= str.length()) {
            int iIndexOf = str.indexOf(38, i11);
            if (iIndexOf == -1) {
                iIndexOf = str.length();
            }
            int iIndexOf2 = str.indexOf(61, i11);
            if (iIndexOf2 == -1 || iIndexOf2 > iIndexOf) {
                arrayList.add(str.substring(i11, iIndexOf));
                arrayList.add(null);
            } else {
                arrayList.add(str.substring(i11, iIndexOf2));
                arrayList.add(str.substring(iIndexOf2 + 1, iIndexOf));
            }
            i11 = iIndexOf + 1;
        }
        return arrayList;
    }

    public String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        return this.url.substring(this.url.indexOf(35) + 1);
    }

    public String encodedPassword() {
        if (this.password.isEmpty()) {
            return "";
        }
        return this.url.substring(this.url.indexOf(58, this.scheme.length() + 3) + 1, this.url.indexOf(64));
    }

    public String encodedPath() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        return this.url.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), "?#"));
    }

    public List<String> encodedPathSegments() {
        int iIndexOf = this.url.indexOf(47, this.scheme.length() + 3);
        String str = this.url;
        int iDelimiterOffset = Util.delimiterOffset(str, iIndexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (iIndexOf < iDelimiterOffset) {
            int i11 = iIndexOf + 1;
            int iDelimiterOffset2 = Util.delimiterOffset(this.url, i11, iDelimiterOffset, '/');
            arrayList.add(this.url.substring(i11, iDelimiterOffset2));
            iIndexOf = iDelimiterOffset2;
        }
        return arrayList;
    }

    public String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int iIndexOf = this.url.indexOf(63) + 1;
        String str = this.url;
        return this.url.substring(iIndexOf, Util.delimiterOffset(str, iIndexOf, str.length(), '#'));
    }

    public String encodedUsername() {
        if (this.username.isEmpty()) {
            return "";
        }
        int length = this.scheme.length() + 3;
        String str = this.url;
        return this.url.substring(length, Util.delimiterOffset(str, length, str.length(), ":@"));
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && ((HttpUrl) obj).url.equals(this.url);
    }

    public String fragment() {
        return this.fragment;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String host() {
        return this.host;
    }

    public boolean isHttps() {
        return this.scheme.equals("https");
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        builder.scheme = this.scheme;
        builder.encodedUsername = encodedUsername();
        builder.encodedPassword = encodedPassword();
        builder.host = this.host;
        builder.port = this.port != defaultPort(this.scheme) ? this.port : -1;
        builder.encodedPathSegments.clear();
        builder.encodedPathSegments.addAll(encodedPathSegments());
        builder.encodedQuery(encodedQuery());
        builder.encodedFragment = encodedFragment();
        return builder;
    }

    public Builder newBuilder(String str) {
        try {
            return new Builder().parse(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String password() {
        return this.password;
    }

    public List<String> pathSegments() {
        return this.pathSegments;
    }

    public int pathSize() {
        return this.pathSegments.size();
    }

    public int port() {
        return this.port;
    }

    public String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        namesAndValuesToQueryString(sb2, this.queryNamesAndValues);
        return sb2.toString();
    }

    public String queryParameter(String str) {
        List<String> list = this.queryNamesAndValues;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i11))) {
                return this.queryNamesAndValues.get(i11 + 1);
            }
        }
        return null;
    }

    public String queryParameterName(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get(i11 * 2);
        }
        throw new IndexOutOfBoundsException();
    }

    public Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return Collections.emptySet();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int size = this.queryNamesAndValues.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            linkedHashSet.add(this.queryNamesAndValues.get(i11));
        }
        return Collections.unmodifiableSet(linkedHashSet);
    }

    public String queryParameterValue(int i11) {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.get((i11 * 2) + 1);
        }
        throw new IndexOutOfBoundsException();
    }

    public List<String> queryParameterValues(String str) {
        if (this.queryNamesAndValues == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = this.queryNamesAndValues.size();
        for (int i11 = 0; i11 < size; i11 += 2) {
            if (str.equals(this.queryNamesAndValues.get(i11))) {
                arrayList.add(this.queryNamesAndValues.get(i11 + 1));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public int querySize() {
        List<String> list = this.queryNamesAndValues;
        if (list != null) {
            return list.size() / 2;
        }
        return 0;
    }

    public String redact() {
        return newBuilder("/...").username("").password("").build().toString();
    }

    public HttpUrl resolve(String str) {
        Builder builderNewBuilder = newBuilder(str);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public String scheme() {
        return this.scheme;
    }

    public String toString() {
        return this.url;
    }

    public String topPrivateDomain() {
        if (Util.verifyAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.get().getEffectiveTldPlusOne(this.host);
    }

    public URI uri() {
        String string = newBuilder().reencodeForUri().toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e11) {
            try {
                return URI.create(string.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e11);
            }
        }
    }

    public URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e11) {
            throw new RuntimeException(e11);
        }
    }

    public String username() {
        return this.username;
    }
}
