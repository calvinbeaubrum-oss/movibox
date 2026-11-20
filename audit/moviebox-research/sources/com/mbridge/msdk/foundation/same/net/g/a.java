package com.mbridge.msdk.foundation.same.net.g;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class a {
    public static String a(com.mbridge.msdk.foundation.same.net.b.a aVar) {
        if (aVar == null) {
            return "Network error,Load failed";
        }
        try {
            int i11 = aVar.f44551a;
            com.mbridge.msdk.foundation.same.net.f.c cVar = aVar.f44553c;
            int i12 = cVar != null ? cVar.f44608d : 0;
            if (i11 == -2) {
                return "Network is canceled";
            }
            if (i11 == 15) {
                return "Network error,I/O exception contents null";
            }
            if (i11 == 880023) {
                return "timeout";
            }
            if (i11 == 880041) {
                return "Network error,UnknownHostException";
            }
            switch (i11) {
                case 1:
                    return "Network error,Load failed";
                case 2:
                    return "Network error,I/O exception";
                case 3:
                    return "Network error,timeout exception";
                case 4:
                    return "Network unknown error";
                case 5:
                    return "Network error，https is not work,please check your phone time";
                case 6:
                    if (i12 == 0) {
                        return "Network error,please check ";
                    }
                    return "Network error,please check state code " + i12;
                case 7:
                    if (i12 == 0) {
                        return "The server returns an exception ";
                    }
                    return "The server returns an exception state code " + i12;
                case 8:
                    return "Cast exception, return data can not be casted correctly";
                default:
                    switch (i11) {
                        case 10:
                            return "Network error,socket timeout exception";
                        case 11:
                            return "Network error，sslp exception";
                        case 12:
                            return "Network error,ConnectException";
                        case 13:
                            if (cVar == null) {
                                return "Unknown socket exception";
                            }
                            byte[] bArr = cVar.f44605a;
                            return bArr != null ? new String(bArr) : "Socket exception message is NULL";
                        default:
                            return "Network error,unknown";
                    }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            return "Network error,Load failed";
        }
    }
}
