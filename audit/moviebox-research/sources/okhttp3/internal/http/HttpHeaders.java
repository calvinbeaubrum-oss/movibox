package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.ByteString;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@JvmName
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS;
    private static final ByteString TOKEN_DELIMITERS;

    static {
        ByteString.Companion companion = ByteString.Companion;
        QUOTED_STRING_DELIMITERS = companion.encodeUtf8("\"\\");
        TOKEN_DELIMITERS = companion.encodeUtf8("\t ,=");
    }

    @Deprecated
    public static final boolean hasBody(Response response) {
        Intrinsics.g(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers parseChallenges, String headerName) {
        Intrinsics.g(parseChallenges, "$this$parseChallenges");
        Intrinsics.g(headerName, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = parseChallenges.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (l.v(headerName, parseChallenges.name(i11), true)) {
                try {
                    readChallengeHeader(new Buffer().writeUtf8(parseChallenges.value(i11)), arrayList);
                } catch (EOFException e11) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e11);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response promisesBody) {
        Intrinsics.g(promisesBody, "$this$promisesBody");
        if (Intrinsics.b(promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int iCode = promisesBody.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(promisesBody) == -1 && !l.v("chunked", Response.header$default(promisesBody, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    /* JADX WARN: Code duplicated, block: B:37:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:38:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x0085 A[EDGE_INSN: B:59:0x0085->B:28:0x0085 BREAK  A[LOOP:2: B:22:0x0072->B:48:0x00c5], SYNTHETIC] */
    private static final void readChallengeHeader(Buffer buffer, List<Challenge> list) throws EOFException {
        String token;
        while (true) {
            String token2 = null;
            while (true) {
                if (token2 == null) {
                    skipCommasAndWhitespace(buffer);
                    token2 = readToken(buffer);
                    if (token2 == null) {
                        return;
                    }
                }
                boolean zSkipCommasAndWhitespace = skipCommasAndWhitespace(buffer);
                String token3 = readToken(buffer);
                if (token3 == null) {
                    if (buffer.exhausted()) {
                        list.add(new Challenge(token2, (Map<String, String>) s.h()));
                        return;
                    }
                    return;
                }
                byte b11 = (byte) 61;
                int iSkipAll = Util.skipAll(buffer, b11);
                boolean zSkipCommasAndWhitespace2 = skipCommasAndWhitespace(buffer);
                if (zSkipCommasAndWhitespace || !(zSkipCommasAndWhitespace2 || buffer.exhausted())) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    int iSkipAll2 = iSkipAll + Util.skipAll(buffer, b11);
                    while (true) {
                        if (token3 != null) {
                            if (iSkipAll2 == 0) {
                                break;
                                break;
                            }
                            if (iSkipAll2 <= 1) {
                                return;
                            }
                            if (startsWith(buffer, (byte) 34)) {
                                token = readQuotedString(buffer);
                            } else {
                                token = readToken(buffer);
                            }
                            if (token != null) {
                                return;
                            } else {
                                return;
                            }
                        }
                        token3 = readToken(buffer);
                        if (skipCommasAndWhitespace(buffer)) {
                            break;
                        }
                        iSkipAll2 = Util.skipAll(buffer, b11);
                        if (iSkipAll2 == 0) {
                            break;
                        }
                        if (iSkipAll2 <= 1 || skipCommasAndWhitespace(buffer)) {
                            return;
                        }
                        if (startsWith(buffer, (byte) 34)) {
                            token = readQuotedString(buffer);
                        } else {
                            token = readToken(buffer);
                        }
                        if (token != null || ((String) linkedHashMap.put(token3, token)) != null) {
                            return;
                        }
                        if (!skipCommasAndWhitespace(buffer) && !buffer.exhausted()) {
                            return;
                        } else {
                            token3 = null;
                        }
                    }
                    list.add(new Challenge(token2, linkedHashMap));
                    token2 = token3;
                } else {
                    Map mapSingletonMap = Collections.singletonMap(null, token3 + l.B("=", iSkipAll));
                    Intrinsics.f(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
                    list.add(new Challenge(token2, (Map<String, String>) mapSingletonMap));
                }
            }
        }
    }

    private static final String readQuotedString(Buffer buffer) throws EOFException {
        byte b11 = (byte) 34;
        if (!(buffer.readByte() == b11)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Buffer buffer2 = new Buffer();
        while (true) {
            long jIndexOfElement = buffer.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (jIndexOfElement == -1) {
                return null;
            }
            if (buffer.getByte(jIndexOfElement) == b11) {
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

    private static final String readToken(Buffer buffer) {
        long jIndexOfElement = buffer.indexOfElement(TOKEN_DELIMITERS);
        if (jIndexOfElement == -1) {
            jIndexOfElement = buffer.size();
        }
        if (jIndexOfElement != 0) {
            return buffer.readUtf8(jIndexOfElement);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar receiveHeaders, HttpUrl url, Headers headers) {
        Intrinsics.g(receiveHeaders, "$this$receiveHeaders");
        Intrinsics.g(url, "url");
        Intrinsics.g(headers, "headers");
        if (receiveHeaders == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(url, headers);
        if (all.isEmpty()) {
            return;
        }
        receiveHeaders.saveFromResponse(url, all);
    }

    private static final boolean skipCommasAndWhitespace(Buffer buffer) throws EOFException {
        boolean z11 = false;
        while (!buffer.exhausted()) {
            byte b11 = buffer.getByte(0L);
            if (b11 == 9 || b11 == 32) {
                buffer.readByte();
            } else {
                if (b11 != 44) {
                    break;
                }
                buffer.readByte();
                z11 = true;
            }
        }
        return z11;
    }

    private static final boolean startsWith(Buffer buffer, byte b11) {
        return !buffer.exhausted() && buffer.getByte(0L) == b11;
    }
}
