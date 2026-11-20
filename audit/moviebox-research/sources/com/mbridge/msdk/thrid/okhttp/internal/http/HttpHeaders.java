package com.mbridge.msdk.thrid.okhttp.internal.http;

import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.thrid.okhttp.Challenge;
import com.mbridge.msdk.thrid.okhttp.Cookie;
import com.mbridge.msdk.thrid.okhttp.CookieJar;
import com.mbridge.msdk.thrid.okhttp.Headers;
import com.mbridge.msdk.thrid.okhttp.HttpUrl;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.encodeUtf8("\t ,=");

    private HttpHeaders() {
    }

    public static long contentLength(Headers headers) {
        return stringToLong(headers.get(com.alibaba.sdk.android.oss.common.utils.HttpHeaders.CONTENT_LENGTH));
    }

    public static long contentLength(Response response) {
        return contentLength(response.headers());
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals("HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && contentLength(response) == -1 && !"chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) ? false : true;
    }

    public static boolean hasVaryAll(Headers headers) {
        return varyFields(headers).contains("*");
    }

    public static boolean hasVaryAll(Response response) {
        return hasVaryAll(response.headers());
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088  */
    /* JADX WARN: Code duplicated, block: B:40:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:61:0x007d A[EDGE_INSN: B:61:0x007d->B:28:0x007d BREAK  A[LOOP:2: B:22:0x006a->B:51:0x00c5], SYNTHETIC] */
    private static void parseChallengeHeader(List<Challenge> list, Buffer buffer) {
        String token;
        while (true) {
            String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipWhitespaceAndCommas(buffer);
                    token2 = readToken(buffer);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipWhitespaceAndCommas = skipWhitespaceAndCommas(buffer);
                String token3 = readToken(buffer);
                if (token3 == null) {
                    if (buffer.exhausted()) {
                        list.add(new Challenge(token2, (Map<String, String>) Collections.emptyMap()));
                        return;
                    }
                    return;
                }
                int iSkipAll = skipAll(buffer, (byte) 61);
                boolean zSkipWhitespaceAndCommas2 = skipWhitespaceAndCommas(buffer);
                if (zSkipWhitespaceAndCommas || !(zSkipWhitespaceAndCommas2 || buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = iSkipAll + skipAll(buffer, (byte) 61);
                    while (true) {
                        if (token3 == null) {
                            token3 = readToken(buffer);
                            if (skipWhitespaceAndCommas(buffer)) {
                                break;
                            }
                            iSkipAll2 = skipAll(buffer, (byte) 61);
                            if (iSkipAll2 == 0) {
                                break;
                            }
                            if (iSkipAll2 <= 1 || skipWhitespaceAndCommas(buffer)) {
                                return;
                            }
                            if (buffer.exhausted() && buffer.getByte(0L) == 34) {
                                token = readQuotedString(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null || ((String) linkedHashMap.put(token3, token)) != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer) && !buffer.exhausted()) {
                                return;
                            } else {
                                token3 = null;
                            }
                        } else {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (buffer.exhausted()) {
                                token = readToken(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null) {
                                return;
                            }
                            if (skipWhitespaceAndCommas(buffer)) {
                            }
                            token3 = null;
                        }
                    }
                    list.add(new Challenge(token2, linkedHashMap));
                    token2 = token3;
                } else {
                    list.add(new Challenge(token2, (Map<String, String>) Collections.singletonMap(null, token3 + repeat('=', iSkipAll))));
                }
            }
        }
    }

    public static List<Challenge> parseChallenges(Headers headers, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < headers.size(); i11++) {
            if (str.equalsIgnoreCase(headers.name(i11))) {
                parseChallengeHeader(arrayList, new Buffer().writeUtf8(headers.value(i11)));
            }
        }
        return arrayList;
    }

    public static int parseSeconds(String str, int i11) {
        try {
            long j11 = Long.parseLong(str);
            if (j11 > 2147483647L) {
                return Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            if (j11 < 0) {
                return 0;
            }
            return (int) j11;
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    private static String readQuotedString(Buffer buffer) {
        if (buffer.readByte() != 34) {
            throw new IllegalArgumentException();
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == 34) {
                buffer2.write(buffer, jIndexOfElement);
                buffer.readByte();
                return buffer2.readUtf8();
            }
            if (buffer.size() == jIndexOfElement + 1) {
                return null;
            }
            buffer2.write(buffer, jIndexOfElement);
            buffer.readByte();
            buffer2.write(buffer, 1L);
        }
    }

    private static String readToken(Buffer buffer) {
        try {
            long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
            if (jIndexOfElement == -1) {
                jIndexOfElement = buffer.size();
            }
            if (jIndexOfElement != 0) {
                return buffer.readUtf8(jIndexOfElement);
            }
            return null;
        } catch (EOFException unused) {
            throw new AssertionError();
        }
    }

    public static void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static String repeat(char c11, int i11) {
        char[] cArr = new char[i11];
        Arrays.fill(cArr, c11);
        return new String(cArr);
    }

    private static int skipAll(Buffer buffer, byte b11) {
        int i11 = 0;
        while (!buffer.exhausted() && buffer.getByte(0L) == b11) {
            i11++;
            buffer.readByte();
        }
        return i11;
    }

    public static int skipUntil(String str, int i11, String str2) {
        while (i11 < str.length() && str2.indexOf(str.charAt(i11)) == -1) {
            i11++;
        }
        return i11;
    }

    public static int skipWhitespace(String str, int i11) {
        char cCharAt;
        while (i11 < str.length() && ((cCharAt = str.charAt(i11)) == ' ' || cCharAt == '\t')) {
            i11++;
        }
        return i11;
    }

    private static boolean skipWhitespaceAndCommas(Buffer buffer) {
        boolean z11 = false;
        while (!buffer.exhausted()) {
            byte b11 = buffer.getByte(0L);
            if (b11 != 44) {
                if (b11 != 32 && b11 != 9) {
                    break;
                }
                buffer.readByte();
            } else {
                buffer.readByte();
                z11 = true;
            }
        }
        return z11;
    }

    private static long stringToLong(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> varyFields(Headers headers) {
        Set<String> setEmptySet = Collections.emptySet();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            if ("Vary".equalsIgnoreCase(headers.name(i11))) {
                String strValue = headers.value(i11);
                if (setEmptySet.isEmpty()) {
                    setEmptySet = new TreeSet<>((Comparator<? super String>) String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : strValue.split(",")) {
                    setEmptySet.add(str.trim());
                }
            }
        }
        return setEmptySet;
    }

    private static Set<String> varyFields(Response response) {
        return varyFields(response.headers());
    }

    public static Headers varyHeaders(Headers headers, Headers headers2) {
        Set<String> setVaryFields = varyFields(headers2);
        if (setVaryFields.isEmpty()) {
            return new Headers.Builder().build();
        }
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (int i11 = 0; i11 < size; i11++) {
            String strName = headers.name(i11);
            if (setVaryFields.contains(strName)) {
                builder.add(strName, headers.value(i11));
            }
        }
        return builder.build();
    }

    public static Headers varyHeaders(Response response) {
        return varyHeaders(response.networkResponse().request().headers(), response.headers());
    }

    public static boolean varyMatches(Response response, Headers headers, Request request) {
        for (String str : varyFields(response)) {
            if (!Util.equal(headers.values(str), request.headers(str))) {
                return false;
            }
        }
        return true;
    }
}
