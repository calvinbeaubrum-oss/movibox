package androidx.media3.datasource;

import androidx.annotation.Nullable;
import c4.g;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public interface HttpDataSource extends androidx.media3.datasource.a {

    /* JADX INFO: compiled from: source.java */
    public static final class CleartextNotPermittedException extends HttpDataSourceException {
        public CleartextNotPermittedException(IOException iOException, g gVar) {
            super("Cleartext HTTP traffic not permitted. See https://developer.android.com/guide/topics/media/issues/cleartext-not-permitted", iOException, gVar, 2007, 1);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class HttpDataSourceException extends DataSourceException {
        public static final int TYPE_CLOSE = 3;
        public static final int TYPE_OPEN = 1;
        public static final int TYPE_READ = 2;
        public final g dataSpec;
        public final int type;

        @Deprecated
        public HttpDataSourceException(g gVar, int i11) {
            this(gVar, 2000, i11);
        }

        public HttpDataSourceException(g gVar, int i11, int i12) {
            super(assignErrorCode(i11, i12));
            this.dataSpec = gVar;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(IOException iOException, g gVar, int i11) {
            this(iOException, gVar, 2000, i11);
        }

        public HttpDataSourceException(IOException iOException, g gVar, int i11, int i12) {
            super(iOException, assignErrorCode(i11, i12));
            this.dataSpec = gVar;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(String str, g gVar, int i11) {
            this(str, gVar, 2000, i11);
        }

        public HttpDataSourceException(String str, g gVar, int i11, int i12) {
            super(str, assignErrorCode(i11, i12));
            this.dataSpec = gVar;
            this.type = i12;
        }

        @Deprecated
        public HttpDataSourceException(String str, IOException iOException, g gVar, int i11) {
            this(str, iOException, gVar, 2000, i11);
        }

        public HttpDataSourceException(String str, @Nullable IOException iOException, g gVar, int i11, int i12) {
            super(str, iOException, assignErrorCode(i11, i12));
            this.dataSpec = gVar;
            this.type = i12;
        }

        private static int assignErrorCode(int i11, int i12) {
            if (i11 == 2000 && i12 == 1) {
                return 2001;
            }
            return i11;
        }

        public static HttpDataSourceException createForIOException(IOException iOException, g gVar, int i11) {
            int i12;
            String message = iOException.getMessage();
            if (iOException instanceof SocketTimeoutException) {
                i12 = 2002;
            } else if (iOException instanceof InterruptedIOException) {
                i12 = 1004;
            } else {
                i12 = (message == null || !com.google.common.base.a.e(message).matches("cleartext.*not permitted.*")) ? 2001 : 2007;
            }
            return i12 == 2007 ? new CleartextNotPermittedException(iOException, gVar) : new HttpDataSourceException(iOException, gVar, i12, i11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class InvalidContentTypeException extends HttpDataSourceException {
        public final String contentType;

        public InvalidContentTypeException(String str, g gVar) {
            super("Invalid content type: " + str, gVar, 2003, 1);
            this.contentType = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class InvalidResponseCodeException extends HttpDataSourceException {
        public final Map<String, List<String>> headerFields;
        public final byte[] responseBody;
        public final int responseCode;

        @Nullable
        public final String responseMessage;

        public InvalidResponseCodeException(int i11, @Nullable String str, @Nullable IOException iOException, Map<String, List<String>> map, g gVar, byte[] bArr) {
            super("Response code: " + i11, iOException, gVar, 2004, 1);
            this.responseCode = i11;
            this.responseMessage = str;
            this.headerFields = map;
            this.responseBody = bArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a extends androidx.media3.datasource.a.InterfaceC0090a {
        @Override // androidx.media3.datasource.a.InterfaceC0090a
        HttpDataSource createDataSource();
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f9567a = new HashMap();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public Map<String, String> f9568b;

        public synchronized void a(Map<String, String> map) {
            this.f9568b = null;
            this.f9567a.clear();
            this.f9567a.putAll(map);
        }

        public synchronized Map<String, String> b() {
            try {
                if (this.f9568b == null) {
                    this.f9568b = Collections.unmodifiableMap(new HashMap(this.f9567a));
                }
            } catch (Throwable th2) {
                throw th2;
            }
            return this.f9568b;
        }
    }
}
