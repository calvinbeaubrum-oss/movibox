package okhttp3.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.d;
import kotlin.collections.g;
import kotlin.collections.h;
import kotlin.collections.s;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.a;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import v10.b;

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
@JvmName
public final class Util {

    @JvmField
    public static final byte[] EMPTY_BYTE_ARRAY;

    @JvmField
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);

    @JvmField
    public static final RequestBody EMPTY_REQUEST;

    @JvmField
    public static final ResponseBody EMPTY_RESPONSE;
    private static final Options UNICODE_BOMS;

    @JvmField
    public static final TimeZone UTC;
    private static final Regex VERIFY_AS_IP_ADDRESS;

    @JvmField
    public static final boolean assertionsEnabled;

    @JvmField
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.9.3";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        Options.Companion companion = Options.Companion;
        ByteString.Companion companion2 = ByteString.Companion;
        UNICODE_BOMS = companion.of(companion2.decodeHex("efbbbf"), companion2.decodeHex("feff"), companion2.decodeHex("fffe"), companion2.decodeHex("0000ffff"), companion2.decodeHex("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.d(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String name = OkHttpClient.class.getName();
        Intrinsics.f(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt__StringsKt.v0(StringsKt__StringsKt.u0(name, "okhttp3."), "Client");
    }

    public static final <E> void addIfAbsent(List<E> addIfAbsent, E e11) {
        Intrinsics.g(addIfAbsent, "$this$addIfAbsent");
        if (addIfAbsent.contains(e11)) {
            return;
        }
        addIfAbsent.add(e11);
    }

    public static final int and(byte b11, int i11) {
        return b11 & i11;
    }

    public static final int and(short s11, int i11) {
        return s11 & i11;
    }

    public static final long and(int i11, long j11) {
        return ((long) i11) & j11;
    }

    public static final EventListener.Factory asFactory(final EventListener asFactory) {
        Intrinsics.g(asFactory, "$this$asFactory");
        return new EventListener.Factory() { // from class: okhttp3.internal.Util.asFactory.1
            @Override // okhttp3.EventListener.Factory
            public final EventListener create(Call it) {
                Intrinsics.g(it, "it");
                return asFactory;
            }
        };
    }

    public static final void assertThreadDoesntHoldLock(Object assertThreadDoesntHoldLock) {
        Intrinsics.g(assertThreadDoesntHoldLock, "$this$assertThreadDoesntHoldLock");
        if (assertionsEnabled && Thread.holdsLock(assertThreadDoesntHoldLock)) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics.f(threadCurrentThread, "Thread.currentThread()");
            sb2.append(threadCurrentThread.getName());
            sb2.append(" MUST NOT hold lock on ");
            sb2.append(assertThreadDoesntHoldLock);
            throw new AssertionError(sb2.toString());
        }
    }

    public static final void assertThreadHoldsLock(Object assertThreadHoldsLock) {
        Intrinsics.g(assertThreadHoldsLock, "$this$assertThreadHoldsLock");
        if (!assertionsEnabled || Thread.holdsLock(assertThreadHoldsLock)) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        Intrinsics.f(threadCurrentThread, "Thread.currentThread()");
        sb2.append(threadCurrentThread.getName());
        sb2.append(" MUST hold lock on ");
        sb2.append(assertThreadHoldsLock);
        throw new AssertionError(sb2.toString());
    }

    public static final boolean canParseAsIpAddress(String canParseAsIpAddress) {
        Intrinsics.g(canParseAsIpAddress, "$this$canParseAsIpAddress");
        return VERIFY_AS_IP_ADDRESS.matches(canParseAsIpAddress);
    }

    public static final boolean canReuseConnectionFor(HttpUrl canReuseConnectionFor, HttpUrl other) {
        Intrinsics.g(canReuseConnectionFor, "$this$canReuseConnectionFor");
        Intrinsics.g(other, "other");
        return Intrinsics.b(canReuseConnectionFor.host(), other.host()) && canReuseConnectionFor.port() == other.port() && Intrinsics.b(canReuseConnectionFor.scheme(), other.scheme());
    }

    public static final int checkDuration(String name, long j11, TimeUnit timeUnit) {
        Intrinsics.g(name, "name");
        if (!(j11 >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j11);
        if (!(millis <= ((long) Api.BaseClientBuilder.API_PRIORITY_OTHER))) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis != 0 || j11 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final void checkOffsetAndCount(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeQuietly) {
        Intrinsics.g(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket closeQuietly) {
        Intrinsics.g(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (RuntimeException e11) {
            throw e11;
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(Socket closeQuietly) {
        Intrinsics.g(closeQuietly, "$this$closeQuietly");
        try {
            closeQuietly.close();
        } catch (AssertionError e11) {
            throw e11;
        } catch (RuntimeException e12) {
            if (!Intrinsics.b(e12.getMessage(), "bio == null")) {
                throw e12;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] concat, String value) {
        Intrinsics.g(concat, "$this$concat");
        Intrinsics.g(value, "value");
        Object[] objArrCopyOf = Arrays.copyOf(concat, concat.length + 1);
        Intrinsics.f(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr = (String[]) objArrCopyOf;
        strArr[d.U(strArr)] = value;
        return strArr;
    }

    public static final int delimiterOffset(String delimiterOffset, char c11, int i11, int i12) {
        Intrinsics.g(delimiterOffset, "$this$delimiterOffset");
        while (i11 < i12) {
            if (delimiterOffset.charAt(i11) == c11) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static final int delimiterOffset(String delimiterOffset, String delimiters, int i11, int i12) {
        Intrinsics.g(delimiterOffset, "$this$delimiterOffset");
        Intrinsics.g(delimiters, "delimiters");
        while (i11 < i12) {
            if (StringsKt__StringsKt.P(delimiters, delimiterOffset.charAt(i11), false, 2, null)) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c11, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = str.length();
        }
        return delimiterOffset(str, c11, i11, i12);
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = str.length();
        }
        return delimiterOffset(str, str2, i11, i12);
    }

    public static final boolean discard(Source discard, int i11, TimeUnit timeUnit) {
        Intrinsics.g(discard, "$this$discard");
        Intrinsics.g(timeUnit, "timeUnit");
        try {
            return skipAll(discard, i11, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> filterList, Function1<? super T, Boolean> predicate) {
        Intrinsics.g(filterList, "$this$filterList");
        Intrinsics.g(predicate, "predicate");
        List<T> listL = g.l();
        for (T t11 : filterList) {
            if (predicate.invoke(t11).booleanValue()) {
                if (listL.isEmpty()) {
                    listL = new ArrayList<>();
                }
                TypeIntrinsics.c(listL).add(t11);
            }
        }
        return listL;
    }

    public static final String format(String format, Object... args) {
        Intrinsics.g(format, "format");
        Intrinsics.g(args, "args");
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(args, args.length);
        String str = String.format(locale, format, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics.f(str, "java.lang.String.format(locale, format, *args)");
        return str;
    }

    public static final boolean hasIntersection(String[] hasIntersection, String[] strArr, Comparator<? super String> comparator) {
        Intrinsics.g(hasIntersection, "$this$hasIntersection");
        Intrinsics.g(comparator, "comparator");
        if (hasIntersection.length != 0 && strArr != null && strArr.length != 0) {
            for (String str : hasIntersection) {
                for (String str2 : strArr) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long headersContentLength(Response headersContentLength) {
        Intrinsics.g(headersContentLength, "$this$headersContentLength");
        String str = headersContentLength.headers().get(HttpHeaders.CONTENT_LENGTH);
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(Function0<Unit> block) {
        Intrinsics.g(block, "block");
        try {
            block.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... elements) {
        Intrinsics.g(elements, "elements");
        Object[] objArr = (Object[]) elements.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(g.o(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.f(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(String[] indexOf, String value, Comparator<String> comparator) {
        Intrinsics.g(indexOf, "$this$indexOf");
        Intrinsics.g(value, "value");
        Intrinsics.g(comparator, "comparator");
        int length = indexOf.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (comparator.compare(indexOf[i11], value) == 0) {
                return i11;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String indexOfControlOrNonAscii) {
        Intrinsics.g(indexOfControlOrNonAscii, "$this$indexOfControlOrNonAscii");
        int length = indexOfControlOrNonAscii.length();
        for (int i11 = 0; i11 < length; i11++) {
            char cCharAt = indexOfControlOrNonAscii.charAt(i11);
            if (Intrinsics.i(cCharAt, 31) <= 0 || Intrinsics.i(cCharAt, 127) >= 0) {
                return i11;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String indexOfFirstNonAsciiWhitespace, int i11, int i12) {
        Intrinsics.g(indexOfFirstNonAsciiWhitespace, "$this$indexOfFirstNonAsciiWhitespace");
        while (i11 < i12) {
            char cCharAt = indexOfFirstNonAsciiWhitespace.charAt(i11);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i11, i12);
    }

    public static final int indexOfLastNonAsciiWhitespace(String indexOfLastNonAsciiWhitespace, int i11, int i12) {
        Intrinsics.g(indexOfLastNonAsciiWhitespace, "$this$indexOfLastNonAsciiWhitespace");
        int i13 = i12 - 1;
        if (i13 >= i11) {
            while (true) {
                char cCharAt = indexOfLastNonAsciiWhitespace.charAt(i13);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i13 + 1;
                }
                if (i13 == i11) {
                    break;
                }
                i13--;
            }
        }
        return i11;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i11, i12);
    }

    public static final int indexOfNonWhitespace(String indexOfNonWhitespace, int i11) {
        Intrinsics.g(indexOfNonWhitespace, "$this$indexOfNonWhitespace");
        int length = indexOfNonWhitespace.length();
        while (i11 < length) {
            char cCharAt = indexOfNonWhitespace.charAt(i11);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i11;
            }
            i11++;
        }
        return indexOfNonWhitespace.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return indexOfNonWhitespace(str, i11);
    }

    public static final String[] intersect(String[] intersect, String[] other, Comparator<? super String> comparator) {
        Intrinsics.g(intersect, "$this$intersect");
        Intrinsics.g(other, "other");
        Intrinsics.g(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : intersect) {
            for (String str2 : other) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean isCivilized(FileSystem isCivilized, File file) throws IOException {
        Intrinsics.g(isCivilized, "$this$isCivilized");
        Intrinsics.g(file, "file");
        Sink sink = isCivilized.sink(file);
        try {
            try {
                isCivilized.delete(file);
                CloseableKt.a(sink, null);
                return true;
            } catch (IOException unused) {
                Unit unit = Unit.f68710a;
                CloseableKt.a(sink, null);
                isCivilized.delete(file);
                return false;
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(sink, th2);
                throw th3;
            }
        }
    }

    public static final boolean isHealthy(Socket isHealthy, BufferedSource source) {
        Intrinsics.g(isHealthy, "$this$isHealthy");
        Intrinsics.g(source, "source");
        try {
            int soTimeout = isHealthy.getSoTimeout();
            try {
                isHealthy.setSoTimeout(1);
                return !source.exhausted();
            } finally {
                isHealthy.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String name) {
        Intrinsics.g(name, "name");
        return l.v(name, HttpHeaders.AUTHORIZATION, true) || l.v(name, "Cookie", true) || l.v(name, "Proxy-Authorization", true) || l.v(name, "Set-Cookie", true);
    }

    public static final void notify(Object notify) {
        Intrinsics.g(notify, "$this$notify");
        notify.notify();
    }

    public static final void notifyAll(Object notifyAll) {
        Intrinsics.g(notifyAll, "$this$notifyAll");
        notifyAll.notifyAll();
    }

    public static final int parseHexDigit(char c11) {
        if ('0' <= c11 && '9' >= c11) {
            return c11 - '0';
        }
        if ('a' <= c11 && 'f' >= c11) {
            return c11 - 'W';
        }
        if ('A' <= c11 && 'F' >= c11) {
            return c11 - '7';
        }
        return -1;
    }

    public static final String peerName(Socket peerName) {
        Intrinsics.g(peerName, "$this$peerName");
        SocketAddress remoteSocketAddress = peerName.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        Intrinsics.f(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(BufferedSource readBomAsCharset, Charset charset) throws IOException {
        Intrinsics.g(readBomAsCharset, "$this$readBomAsCharset");
        Intrinsics.g(charset, "default");
        int iSelect = readBomAsCharset.select(UNICODE_BOMS);
        if (iSelect == -1) {
            return charset;
        }
        if (iSelect == 0) {
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.f(UTF_8, "UTF_8");
            return UTF_8;
        }
        if (iSelect == 1) {
            Charset UTF_16BE = StandardCharsets.UTF_16BE;
            Intrinsics.f(UTF_16BE, "UTF_16BE");
            return UTF_16BE;
        }
        if (iSelect == 2) {
            Charset UTF_16LE = StandardCharsets.UTF_16LE;
            Intrinsics.f(UTF_16LE, "UTF_16LE");
            return UTF_16LE;
        }
        if (iSelect == 3) {
            return Charsets.f69090a.a();
        }
        if (iSelect == 4) {
            return Charsets.f69090a.b();
        }
        throw new AssertionError();
    }

    public static final <T> T readFieldOrNull(Object instance, Class<T> fieldType, String fieldName) throws IllegalAccessException {
        Object fieldOrNull;
        Intrinsics.g(instance, "instance");
        Intrinsics.g(fieldType, "fieldType");
        Intrinsics.g(fieldName, "fieldName");
        Class<?> superclass = instance.getClass();
        while (true) {
            T tCast = null;
            if (!(!Intrinsics.b(superclass, Object.class))) {
                if (!(!Intrinsics.b(fieldName, "delegate")) || (fieldOrNull = readFieldOrNull(instance, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, fieldType, fieldName);
            }
            try {
                Field field = superclass.getDeclaredField(fieldName);
                Intrinsics.f(field, "field");
                field.setAccessible(true);
                Object obj = field.get(instance);
                if (fieldType.isInstance(obj)) {
                    tCast = fieldType.cast(obj);
                }
                return tCast;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                Intrinsics.f(superclass, "c.superclass");
            }
        }
    }

    public static final int readMedium(BufferedSource readMedium) throws IOException {
        Intrinsics.g(readMedium, "$this$readMedium");
        return and(readMedium.readByte(), 255) | (and(readMedium.readByte(), 255) << 16) | (and(readMedium.readByte(), 255) << 8);
    }

    public static final int skipAll(Buffer skipAll, byte b11) throws EOFException {
        Intrinsics.g(skipAll, "$this$skipAll");
        int i11 = 0;
        while (!skipAll.exhausted() && skipAll.getByte(0L) == b11) {
            i11++;
            skipAll.readByte();
        }
        return i11;
    }

    public static final boolean skipAll(Source skipAll, int i11, TimeUnit timeUnit) throws IOException {
        Intrinsics.g(skipAll, "$this$skipAll");
        Intrinsics.g(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = skipAll.timeout().hasDeadline() ? skipAll.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        skipAll.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i11)) + jNanoTime);
        try {
            Buffer buffer = new Buffer();
            while (skipAll.read(buffer, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                buffer.clear();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                skipAll.timeout().clearDeadline();
            } else {
                skipAll.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                skipAll.timeout().clearDeadline();
            } else {
                skipAll.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th2) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                skipAll.timeout().clearDeadline();
            } else {
                skipAll.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th2;
        }
    }

    public static final ThreadFactory threadFactory(final String name, final boolean z11) {
        Intrinsics.g(name, "name");
        return new ThreadFactory() { // from class: okhttp3.internal.Util.threadFactory.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, name);
                thread.setDaemon(z11);
                return thread;
            }
        };
    }

    public static final void threadName(String name, Function0<Unit> block) {
        Intrinsics.g(name, "name");
        Intrinsics.g(block, "block");
        Thread currentThread = Thread.currentThread();
        Intrinsics.f(currentThread, "currentThread");
        String name2 = currentThread.getName();
        currentThread.setName(name);
        try {
            block.invoke();
        } finally {
            InlineMarker.b(1);
            currentThread.setName(name2);
            InlineMarker.a(1);
        }
    }

    public static final List<Header> toHeaderList(Headers toHeaderList) {
        Intrinsics.g(toHeaderList, "$this$toHeaderList");
        IntRange intRangeR = a.r(0, toHeaderList.size());
        ArrayList arrayList = new ArrayList(h.v(intRangeR, 10));
        Iterator<Integer> it = intRangeR.iterator();
        while (it.hasNext()) {
            int iA = ((IntIterator) it).a();
            arrayList.add(new Header(toHeaderList.name(iA), toHeaderList.value(iA)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> toHeaders) {
        Intrinsics.g(toHeaders, "$this$toHeaders");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : toHeaders) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    public static final String toHexString(int i11) {
        String hexString = Integer.toHexString(i11);
        Intrinsics.f(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    public static final String toHexString(long j11) {
        String hexString = Long.toHexString(j11);
        Intrinsics.f(hexString, "java.lang.Long.toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl toHostHeader, boolean z11) {
        String strHost;
        Intrinsics.g(toHostHeader, "$this$toHostHeader");
        if (StringsKt__StringsKt.Q(toHostHeader.host(), ":", false, 2, null)) {
            strHost = '[' + toHostHeader.host() + ']';
        } else {
            strHost = toHostHeader.host();
        }
        if (!z11 && toHostHeader.port() == HttpUrl.Companion.defaultPort(toHostHeader.scheme())) {
            return strHost;
        }
        return strHost + ':' + toHostHeader.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        return toHostHeader(httpUrl, z11);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> toImmutableList) {
        Intrinsics.g(toImmutableList, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(CollectionsKt___CollectionsKt.M0(toImmutableList));
        Intrinsics.f(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> toImmutableMap) {
        Intrinsics.g(toImmutableMap, "$this$toImmutableMap");
        if (toImmutableMap.isEmpty()) {
            return s.h();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(toImmutableMap));
        Intrinsics.f(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(String toLongOrDefault, long j11) {
        Intrinsics.g(toLongOrDefault, "$this$toLongOrDefault");
        try {
            return Long.parseLong(toLongOrDefault);
        } catch (NumberFormatException unused) {
            return j11;
        }
    }

    public static final int toNonNegativeInt(String str, int i11) {
        if (str != null) {
            try {
                long j11 = Long.parseLong(str);
                if (j11 > Api.BaseClientBuilder.API_PRIORITY_OTHER) {
                    return Api.BaseClientBuilder.API_PRIORITY_OTHER;
                }
                if (j11 < 0) {
                    return 0;
                }
                return (int) j11;
            } catch (NumberFormatException unused) {
            }
        }
        return i11;
    }

    public static final String trimSubstring(String trimSubstring, int i11, int i12) {
        Intrinsics.g(trimSubstring, "$this$trimSubstring");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(trimSubstring, i11, i12);
        String strSubstring = trimSubstring.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(trimSubstring, iIndexOfFirstNonAsciiWhitespace, i12));
        Intrinsics.f(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i11, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = 0;
        }
        if ((i13 & 2) != 0) {
            i12 = str.length();
        }
        return trimSubstring(str, i11, i12);
    }

    public static final void wait(Object wait) throws InterruptedException {
        Intrinsics.g(wait, "$this$wait");
        wait.wait();
    }

    public static final Throwable withSuppressed(Exception withSuppressed, List<? extends Exception> suppressed) {
        Intrinsics.g(withSuppressed, "$this$withSuppressed");
        Intrinsics.g(suppressed, "suppressed");
        if (suppressed.size() > 1) {
            System.out.println(suppressed);
        }
        Iterator<? extends Exception> it = suppressed.iterator();
        while (it.hasNext()) {
            b.a(withSuppressed, it.next());
        }
        return withSuppressed;
    }

    public static final void writeMedium(BufferedSink writeMedium, int i11) throws IOException {
        Intrinsics.g(writeMedium, "$this$writeMedium");
        writeMedium.writeByte((i11 >>> 16) & 255);
        writeMedium.writeByte((i11 >>> 8) & 255);
        writeMedium.writeByte(i11 & 255);
    }
}
