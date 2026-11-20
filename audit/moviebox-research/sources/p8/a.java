package p8;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.Ol;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF;
import com.bykv.vk.openvk.sc.sc.pFF.pFF.pFF.zY;
import com.bytedance.sdk.component.Qj.Qj;
import com.bytedance.sdk.component.Qj.TRI;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import java.io.Closeable;
import java.io.RandomAccessFile;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import l8.e;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Handler f73720a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Charset f73721b = Charset.forName("UTF-8");

    public static int a(String str) {
        return g(str, 0);
    }

    public static String b(int i11, int i12) {
        if (i11 >= 0 && i12 > 0) {
            return i11 + "-" + i12;
        }
        if (i11 > 0) {
            return i11 + "-";
        }
        if (i11 >= 0 || i12 <= 0) {
            return null;
        }
        return "-".concat(String.valueOf(i12));
    }

    public static String c(List<Ol.a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Ol.a aVar = list.get(0);
            if (aVar != null) {
                sb2.append(aVar.f25907a);
                sb2.append(": ");
                sb2.append(aVar.f25908b);
                sb2.append("\r\n");
            }
        }
        return sb2.toString();
    }

    public static String d(Map<String, String> map) {
        if (map == null || map.size() == 0) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb2.append((Object) entry.getKey());
            sb2.append(": ");
            sb2.append((Object) entry.getValue());
            sb2.append("\r\n");
        }
        return sb2.toString();
    }

    public static boolean e() {
        return Thread.currentThread() == Looper.getMainLooper().getThread();
    }

    public static int f() {
        return Math.max(Runtime.getRuntime().availableProcessors(), 1);
    }

    public static int g(String str, int i11) {
        if (TextUtils.isEmpty(str)) {
            return i11;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i11;
        }
    }

    public static int h(e eVar) {
        int iLastIndexOf;
        if (eVar == null) {
            return -1;
        }
        if (eVar.f() == 200) {
            return g(eVar.i(HttpHeaders.CONTENT_LENGTH, null), -1);
        }
        if (eVar.f() == 206) {
            String strI = eVar.i("Content-Range", null);
            if (!TextUtils.isEmpty(strI) && (iLastIndexOf = strI.lastIndexOf("/")) >= 0 && iLastIndexOf < strI.length() - 1) {
                return g(strI.substring(iLastIndexOf + 1), -1);
            }
        }
        return -1;
    }

    public static pFF.e i(e eVar, zY zYVar, String str, int i11) {
        String strD;
        String str2;
        String string;
        pFF.e eVarE = zYVar.e(str, i11);
        if (eVarE != null) {
            return eVarE;
        }
        int iH = h(eVar);
        String strI = eVar.i(HttpHeaders.CONTENT_TYPE, null);
        if (iH <= 0 || TextUtils.isEmpty(strI)) {
            return eVarE;
        }
        l8.a aVarE = eVar.e();
        if (aVarE != null) {
            str2 = aVarE.f70153b;
            strD = d(aVarE.f70156e);
        } else {
            strD = "";
            str2 = strD;
        }
        String strC = c(eVar.j());
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("requestUrl", str2);
            jSONObject.put("requestHeaders", strD);
            jSONObject.put("responseHeaders", strC);
            string = jSONObject.toString();
        } catch (Throwable unused) {
            string = "";
        }
        pFF.e eVar2 = new pFF.e(str, strI, iH, i11, string);
        zYVar.h(eVar2);
        return eVar2;
    }

    public static String j(int i11, int i12) {
        String strB = b(i11, i12);
        if (strB == null) {
            return null;
        }
        return "bytes=".concat(strB);
    }

    public static String k(pFF.e eVar, int i11) {
        StringBuilder sb2 = new StringBuilder();
        if (i11 <= 0) {
            sb2.append("HTTP/1.1 200 OK\r\n");
        } else {
            sb2.append("HTTP/1.1 206 Partial Content\r\n");
        }
        sb2.append("Accept-Ranges: bytes\r\n");
        sb2.append("Content-Type: ");
        sb2.append(eVar.f26005b);
        sb2.append("\r\n");
        if (i11 <= 0) {
            sb2.append("Content-Length: ");
            sb2.append(eVar.f26006c);
            sb2.append("\r\n");
        } else {
            sb2.append("Content-Range: bytes ");
            sb2.append(i11);
            sb2.append("-");
            sb2.append(eVar.f26006c - 1);
            sb2.append("/");
            sb2.append(eVar.f26006c);
            sb2.append("\r\n");
            sb2.append("Content-Length: ");
            sb2.append(eVar.f26006c - i11);
            sb2.append("\r\n");
        }
        sb2.append("Connection: close\r\n");
        sb2.append("\r\n");
        String string = sb2.toString();
        com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
        return string;
    }

    /* JADX WARN: Code duplicated, block: B:25:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:27:0x00b2  */
    public static String l(e eVar, int i11) {
        int iH;
        if (eVar == null || !eVar.d()) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(eVar.a().toUpperCase());
        sb2.append(' ');
        sb2.append(eVar.f());
        sb2.append(' ');
        sb2.append(eVar.b());
        sb2.append("\r\n");
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(eVar.a().toUpperCase());
            sb3.append(" ");
            sb3.append(eVar.f());
            sb3.append(" ");
            sb3.append(eVar.b());
        }
        List<Ol.a> listN = n(eVar.j());
        if (listN != null) {
            int size = listN.size();
            boolean z11 = true;
            for (int i12 = 0; i12 < size; i12++) {
                Ol.a aVar = listN.get(i12);
                if (aVar != null) {
                    String str = aVar.f25907a;
                    String str2 = aVar.f25908b;
                    sb2.append(str);
                    sb2.append(": ");
                    sb2.append(str2);
                    sb2.append("\r\n");
                    if ("Content-Range".equalsIgnoreCase(str) || ("Accept-Ranges".equalsIgnoreCase(str) && "bytes".equalsIgnoreCase(str2))) {
                        z11 = false;
                    }
                }
            }
            if (z11) {
                iH = h(eVar);
                if (iH > 0) {
                    sb2.append("Content-Range: bytes ");
                    sb2.append(Math.max(i11, 0));
                    sb2.append("-");
                    sb2.append(iH - 1);
                    sb2.append("/");
                    sb2.append(iH);
                    sb2.append("\r\n");
                }
            }
        } else {
            iH = h(eVar);
            if (iH > 0) {
                sb2.append("Content-Range: bytes ");
                sb2.append(Math.max(i11, 0));
                sb2.append("-");
                sb2.append(iH - 1);
                sb2.append("/");
                sb2.append(iH);
                sb2.append("\r\n");
            }
        }
        sb2.append("Connection: close\r\n");
        sb2.append("\r\n");
        String string = sb2.toString();
        com.bykv.vk.openvk.sc.sc.pFF.pFF.sc.zY zYVar = com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25970a;
        return string;
    }

    public static String m(e eVar, boolean z11, boolean z12) {
        String strI;
        if (eVar == null) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_Response", "response null");
            }
            return "response null";
        }
        if (!eVar.d()) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_Response", "response code: " + eVar.f());
            }
            return "response code: " + eVar.f();
        }
        String strI2 = eVar.i(HttpHeaders.CONTENT_TYPE, null);
        if (!x(strI2)) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_Response", "Content-Type: ".concat(String.valueOf(strI2)));
            }
            return "Content-Type: ".concat(String.valueOf(strI2));
        }
        int iH = h(eVar);
        if (iH <= 0) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_Response", "Content-Length: ".concat(String.valueOf(iH)));
            }
            return "Content-Length: ".concat(String.valueOf(iH));
        }
        if (z11 && ((strI = eVar.i("Accept-Ranges", null)) == null || !strI.contains("bytes"))) {
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_Response", "Accept-Ranges: ".concat(String.valueOf(strI)));
            }
            return "Accept-Ranges: ".concat(String.valueOf(strI));
        }
        if (!z12 || eVar.c() != null) {
            return null;
        }
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            Log.e("TAG_PROXY_Response", "response body null");
        }
        return "response body null";
    }

    public static List<Ol.a> n(List<Ol.a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                Ol.a aVar = list.get(i11);
                if (aVar != null) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aVar.f25907a);
                    sb2.append(": ");
                    sb2.append(aVar.f25907a);
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Ol.a aVar2 : list) {
            if (HttpHeaders.HOST.equals(aVar2.f25907a) || "Keep-Alive".equals(aVar2.f25907a) || "Connection".equals(aVar2.f25907a) || "Proxy-Connection".equals(aVar2.f25907a)) {
                arrayList.add(aVar2);
            }
        }
        list.removeAll(arrayList);
        if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
            int size2 = list.size();
            for (int i12 = 0; i12 < size2; i12++) {
                Ol.a aVar3 = list.get(i12);
                if (aVar3 != null) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(aVar3.f25907a);
                    sb3.append(": ");
                    sb3.append(aVar3.f25908b);
                }
            }
        }
        return list;
    }

    public static List<Ol.a> o(Map<String, String> map) {
        if (map != null && !map.isEmpty()) {
            try {
                Set<Map.Entry<String, String>> setEntrySet = map.entrySet();
                ArrayList arrayList = new ArrayList();
                for (Map.Entry<String, String> entry : setEntrySet) {
                    arrayList.add(new Ol.a(entry.getKey(), entry.getValue()));
                }
                return arrayList;
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    public static List<String> p(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            if (w(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void q(Qj qj2) {
        if (qj2 != null) {
            if (e()) {
                TRI.pFF(qj2);
                if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                    Log.e("TAG_PROXY_UTIL", "invoke in pool thread");
                    return;
                }
                return;
            }
            qj2.run();
            if (com.bykv.vk.openvk.sc.sc.pFF.pFF.a.f25972c) {
                Log.e("TAG_PROXY_UTIL", "invoke calling thread");
            }
        }
    }

    public static void r(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void s(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.getFD().sync();
                randomAccessFile.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void t(Runnable runnable) {
        if (runnable != null) {
            if (e()) {
                runnable.run();
            } else {
                f73720a.post(runnable);
            }
        }
    }

    public static void u(ServerSocket serverSocket) {
        if (serverSocket != null) {
            try {
                serverSocket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static void v(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (Throwable unused) {
            }
        }
    }

    public static boolean w(String str) {
        if (str != null) {
            return str.startsWith("http://") || str.startsWith(AgentPageJsBridge.HTTPS);
        }
        return false;
    }

    public static boolean x(String str) {
        if (str != null) {
            return str.startsWith("video/") || OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE.equals(str) || "binary/octet-stream".equals(str);
        }
        return false;
    }
}
