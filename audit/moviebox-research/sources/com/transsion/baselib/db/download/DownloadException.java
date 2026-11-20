package com.transsion.baselib.db.download;

import java.net.BindException;
import java.net.ConnectException;
import java.net.HttpRetryException;
import java.net.MalformedURLException;
import java.net.NoRouteToHostException;
import java.net.PortUnreachableException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLKeyException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public class DownloadException extends RuntimeException {
    public static final a Companion = new a(null);
    private static final int DEFAULT_CODE = -1;
    public static final int EXCEPTION_FILE_SIZE_ZERO = 6;
    public static final int EXCEPTION_IO_EXCEPTION = 5;
    public static final int EXCEPTION_IO_HTTP_RETRY = 509;
    public static final int EXCEPTION_IO_MALFORMED_URL = 508;
    public static final int EXCEPTION_IO_SOCKET_BIND = 504;
    public static final int EXCEPTION_IO_SOCKET_CONNECT = 505;
    public static final int EXCEPTION_IO_SOCKET_NO_ROOT_TO_HOST = 506;
    public static final int EXCEPTION_IO_SOCKET_PORT_UNREACHABLE = 507;
    public static final int EXCEPTION_IO_SOCKET_TIMEOUT = 503;
    public static final int EXCEPTION_IO_SSL_HANDSHAKE = 510;
    public static final int EXCEPTION_IO_SSL_KEY = 511;
    public static final int EXCEPTION_IO_SSL_PEER_UNVERIFIED = 512;
    public static final int EXCEPTION_IO_SSL_PROTOCOL = 513;
    public static final int EXCEPTION_IO_UNKNOWN_HOST = 501;
    public static final int EXCEPTION_IO_UNKNOWN_SERVICE = 502;
    public static final String EXCEPTION_MESSAGE_FAILED_CONNECT = "failed to connect to host";
    public static final String EXCEPTION_MESSAGE_NO_NET = "noNetWork";
    public static final String EXCEPTION_MESSAGE_NO_SDCARD = "no sdcard";
    public static final String EXCEPTION_MESSAGE_SSL = "ssl_error";
    public static final int EXCEPTION_OTHER = 9;
    public static final int EXCEPTION_PATH_NULL = 1;
    public static final int EXCEPTION_PAUSE = 7;
    public static final int EXCEPTION_PROTOCOL = 4;
    public static final int EXCEPTION_SERVER_ERROR = 3;
    public static final int EXCEPTION_SERVER_SUPPORT_CODE = 8;
    public static final int EXCEPTION_URL_ERROR = 2;
    public static final int EXCEPTION_URL_NULL = 0;
    private int code;
    private String formatMessage;
    private String range;
    private int responseCode;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return DownloadException.DEFAULT_CODE;
        }

        public final int b(Exception exception, int i11) {
            Intrinsics.g(exception, "exception");
            if (exception instanceof UnknownHostException) {
                return 501;
            }
            if (exception instanceof UnknownServiceException) {
                return 502;
            }
            if (exception instanceof BindException) {
                return 504;
            }
            if (exception instanceof ConnectException) {
                return 505;
            }
            if (exception instanceof NoRouteToHostException) {
                return 506;
            }
            if (exception instanceof PortUnreachableException) {
                return DownloadException.EXCEPTION_IO_SOCKET_PORT_UNREACHABLE;
            }
            if (exception instanceof SocketTimeoutException) {
                return 503;
            }
            if (exception instanceof MalformedURLException) {
                return DownloadException.EXCEPTION_IO_MALFORMED_URL;
            }
            if (exception instanceof HttpRetryException) {
                return DownloadException.EXCEPTION_IO_HTTP_RETRY;
            }
            if (exception instanceof SSLHandshakeException) {
                return DownloadException.EXCEPTION_IO_SSL_HANDSHAKE;
            }
            if (exception instanceof SSLKeyException) {
                return 511;
            }
            if (exception instanceof SSLPeerUnverifiedException) {
                return 512;
            }
            if (exception instanceof SSLProtocolException) {
                return 513;
            }
            return i11;
        }

        public final boolean c(int i11) {
            switch (i11) {
                case 501:
                case 502:
                case 503:
                case 504:
                case 505:
                case 506:
                case DownloadException.EXCEPTION_IO_SOCKET_PORT_UNREACHABLE /* 507 */:
                    return true;
                default:
                    return false;
            }
        }
    }

    public DownloadException(int i11) {
        this.formatMessage = "";
        this.range = "";
        this.code = i11;
    }

    public DownloadException(int i11, String str) {
        super(str);
        this.formatMessage = "";
        this.range = "";
        this.code = i11;
    }

    public DownloadException(int i11, String str, Throwable th2) {
        super(str, th2);
        this.formatMessage = "";
        this.range = "";
        this.code = i11;
    }

    public DownloadException(int i11, Throwable th2) {
        super(th2);
        this.formatMessage = "";
        this.range = "";
        this.code = i11;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getFormatMessage() {
        return this.formatMessage;
    }

    public final String getRange() {
        return this.range;
    }

    public final int getResponseCode() {
        return this.responseCode;
    }

    public final void setCode(int i11) {
        this.code = i11;
    }

    public final void setFormatMessage(String str) {
        Intrinsics.g(str, "<set-?>");
        this.formatMessage = str;
    }

    public final void setRange(String str) {
        Intrinsics.g(str, "<set-?>");
        this.range = str;
    }

    public final void setResponseCode(int i11) {
        this.responseCode = i11;
    }
}
