package athena;

import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.util.Pair;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.hisavana.common.constant.ComConstants;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.transsion.gslb.GslbSdk;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.crypto.KeyGenerator;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static SSLSocketFactory f13757a;

    /* JADX INFO: compiled from: source.java */
    public class a implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            File file3 = file;
            File file4 = file2;
            if (file3.lastModified() < file4.lastModified()) {
                return -1;
            }
            return file3.lastModified() == file4.lastModified() ? 0 : 1;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Comparator<File> {
        @Override // java.util.Comparator
        public int compare(File file, File file2) {
            return file.getName().compareTo(file2.getName());
        }
    }

    /* JADX WARN: Code duplicated, block: B:90:0x029b  */
    public static y0<athena.b> a(long j11, byte[] bArr, int i11, br.c cVar) throws Throwable {
        HttpURLConnection httpURLConnection;
        SSLContext sSLContextA;
        y0<athena.b> y0Var = new y0<>(2, new athena.b("sdk_error"));
        try {
            URL url = new URL(GslbSdk.getDomain(cVar.f14327a, true));
            HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
            try {
                if (httpURLConnection2 instanceof HttpsURLConnection) {
                    if (f13757a == null && (sSLContextA = q0.a()) != null) {
                        f13757a = sSLContextA.getSocketFactory();
                    }
                    SSLSocketFactory sSLSocketFactory = f13757a;
                    if (sSLSocketFactory != null) {
                        ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                        ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(q0.f13735a);
                    }
                }
                httpURLConnection2.setReadTimeout(20000);
                httpURLConnection2.setConnectTimeout(ComConstants.AD_TIMEOUT_MILLIS);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setRequestMethod("POST");
                httpURLConnection2.setInstanceFollowRedirects(true);
                byte[] bArrI = bArr;
                if (cVar.f14329c * 1024 <= bArrI.length) {
                    httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                    httpURLConnection2.setRequestProperty("zip", "1");
                    bArrI = i(bArr);
                } else {
                    httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                    httpURLConnection2.setRequestProperty("zip", "0");
                }
                httpURLConnection2.setRequestProperty("fixed", "1");
                httpURLConnection2.setRequestProperty("record-id", j11 + "");
                httpURLConnection2.setRequestProperty("count", i11 + "");
                httpURLConnection2.setRequestProperty("ver", "3.0.0.5");
                br.a aVarN = ar.b.a().n(j11);
                if (aVarN == null) {
                    a0.a("requestByPost TidConfigBean " + j11 + " is missing, maybe cancelled");
                    y0Var.f13773b.f13602d = "tid not found";
                    httpURLConnection2.disconnect();
                    return y0Var;
                }
                aVarN.e().getClass();
                byte[] bArr2 = (byte[]) cVar.f14328b.second;
                n0 n0Var = bArr2 == null ? null : new n0(bArr2);
                if (n0Var == null) {
                    y0Var.f13773b.f13602d = "encrypt error";
                    httpURLConnection2.disconnect();
                    return y0Var;
                }
                byte[] bytes = Base64.encodeToString(n0Var.c(bArrI), 2).getBytes();
                if (bytes == null) {
                    a0.c("requestByPost buffer is null");
                    y0Var.f13773b.f13602d = "base64 error";
                    httpURLConnection2.disconnect();
                    return y0Var;
                }
                String strK = k(bytes);
                if (TextUtils.isEmpty(strK)) {
                    httpURLConnection2.setRequestProperty("md5", "error");
                } else {
                    httpURLConnection2.setRequestProperty("md5", strK);
                }
                httpURLConnection2.setRequestProperty("encrypt-level", "3");
                httpURLConnection2.setRequestProperty("encrypt-index", "" + (((Integer) cVar.f14328b.first).intValue() + 1));
                a0.e(url + " tid = " + j11 + " count = " + i11);
                httpURLConnection2.connect();
                DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                dataOutputStream.write(bytes);
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpURLConnection2.getResponseCode();
                if (responseCode != 200) {
                    a0.e(String.format(Locale.ENGLISH, "tid: %s response code: %d", Long.valueOf(j11), Integer.valueOf(responseCode)));
                    httpURLConnection2.disconnect();
                    return new y0<>(-1, new athena.b());
                }
                String strD = d(httpURLConnection2.getInputStream());
                a0.e(String.format(Locale.ENGLISH, "post tid: %s response: %s", Long.valueOf(j11), strD));
                if (TextUtils.isEmpty(strD)) {
                    y0<athena.b> y0Var2 = new y0<>(-1, new athena.b("rc_" + i11));
                    httpURLConnection2.disconnect();
                    return y0Var2;
                }
                int iOptInt = new JSONObject(strD).optInt(TrackingKey.CODE);
                if (iOptInt == 0) {
                    y0<athena.b> y0Var3 = new y0<>(0, new athena.b());
                    httpURLConnection2.disconnect();
                    return y0Var3;
                }
                y0<athena.b> y0Var4 = new y0<>(-1, new athena.b("rc_" + iOptInt));
                httpURLConnection2.disconnect();
                return y0Var4;
            } catch (Exception e11) {
                e = e11;
                httpURLConnection = httpURLConnection2;
                try {
                    if (e instanceof UnknownHostException) {
                        a0.c(e.getMessage());
                    } else {
                        a0.c(Log.getStackTraceString(e));
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                httpURLConnection = httpURLConnection2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Exception e12) {
            e = e12;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th = th4;
            httpURLConnection = null;
        }
    }

    public static y0<String> b(String str, String str2, long j11, int i11) {
        y0<String> y0Var;
        SSLContext sSLContextA;
        HttpURLConnection httpURLConnection = null;
        y0<String> y0Var2 = new y0<>(-1, null);
        try {
            try {
                KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
                keyGenerator.init(128);
                String strE = br.d.e(keyGenerator.generateKey().getEncoded());
                n0 n0Var = new n0(strE.getBytes());
                byte[] bArrA = n0Var.a(str2);
                String str3 = Base64.encodeToString(bArrA, 2) + "," + Base64.encodeToString(new ww.a("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArNrm4jErOdstd1P5L1X/\nCGSS6NKf4glPrFbTM97aE9ZKGUiMALIV8W7FClAgLZdtTZkL5XEQdbX4RB/C6edc\nnN2ifla6sVu23y78FMiL6smp9ayE7Y3gSEfB3md4nvEUpyRUu4wYLIf9nVR36okK\nGCerxYdLtDbJ69Rux4lgE5C9a6qLfV6BzjJYONk/vQhGQYT6qes+TFtXV0hvF8UM\nDG+0GfA3MiQue/Ny8uIPBykDPS1dcIADzVos2fXs/o2aFTrkdVjiX8irwYBze69K\nzFx18H12iZ9gG1VztMbHetvImBoXeCOwjTc5RnGIz+Hya96pxJLK2DcSlAaHEs1H\nOQIDAQAB").d(strE), 2);
                URL url = new URL(GslbSdk.getDomain(str, true));
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
                try {
                    try {
                        if (httpURLConnection2 instanceof HttpsURLConnection) {
                            if (f13757a == null && (sSLContextA = q0.a()) != null) {
                                f13757a = sSLContextA.getSocketFactory();
                            }
                            SSLSocketFactory sSLSocketFactory = f13757a;
                            if (sSLSocketFactory != null) {
                                ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                                ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(q0.f13735a);
                            }
                        }
                        httpURLConnection2.setRequestProperty("accept", "*/*");
                        httpURLConnection2.setRequestProperty(HttpHeaders.CONTENT_LENGTH, String.valueOf(str3.length()));
                        httpURLConnection2.setRequestProperty("encrypt-level", "2");
                        httpURLConnection2.setRequestProperty("ver", String.valueOf(j11));
                        httpURLConnection2.setRequestProperty("vn", "1");
                        if (i11 > 0) {
                            httpURLConnection2.setRequestProperty(MBridgeConstans.DYNAMIC_VIEW_WX_APP, String.valueOf(i11));
                            httpURLConnection2.setRequestProperty("model", Build.MODEL);
                        }
                        httpURLConnection2.setRequestMethod("POST");
                        httpURLConnection2.setReadTimeout(20000);
                        httpURLConnection2.setConnectTimeout(ComConstants.AD_TIMEOUT_MILLIS);
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(true);
                        PrintWriter printWriter = new PrintWriter(httpURLConnection2.getOutputStream());
                        printWriter.write(str3);
                        printWriter.flush();
                        printWriter.close();
                        int responseCode = httpURLConnection2.getResponseCode();
                        try {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("url", url);
                            jSONObject.put("params", str2);
                            jSONObject.put("version", j11);
                            jSONObject.put(TrackingKey.CODE, responseCode);
                            a0.f("--> request config:%s", jSONObject.toString().replace("\\", ""));
                        } catch (Exception e11) {
                            a0.d("print request config exception:%s", e11.getMessage());
                        }
                        if (responseCode == 200) {
                            InputStream inputStream = httpURLConnection2.getInputStream();
                            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                            StringBuilder sb2 = new StringBuilder();
                            while (true) {
                                String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                sb2.append(line);
                            }
                            String string = sb2.toString();
                            if (TextUtils.equals("{}", string)) {
                                y0Var = new y0<>(1, null);
                            } else if (TextUtils.isEmpty(string)) {
                                y0Var = new y0<>(-1, null);
                            } else {
                                y0Var = new y0<>(0, str.contains("secret") ? new String(n0Var.b(Base64.decode(string, 2)), StandardCharsets.UTF_8) : new String(n(n0Var.b(Base64.decode(string, 2))), StandardCharsets.UTF_8));
                            }
                            y0Var2 = y0Var;
                            bufferedReader.close();
                            inputStream.close();
                        }
                        httpURLConnection2.disconnect();
                    } catch (Exception e12) {
                        e = e12;
                        httpURLConnection = httpURLConnection2;
                        a0.c(e.getMessage());
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    }
                    return y0Var2;
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e13) {
                e = e13;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static y0<athena.b> c(String str, byte[] bArr, int i11, List<Integer> list, String str2, String str3) throws Throwable {
        SSLContext sSLContextA;
        y0<athena.b> y0Var = new y0<>(2, new athena.b("sdk_error"));
        HttpURLConnection httpURLConnection = null;
        n0 n0Var = null;
        httpURLConnection = null;
        try {
            try {
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
                try {
                    if (httpURLConnection2 instanceof HttpsURLConnection) {
                        if (f13757a == null && (sSLContextA = q0.a()) != null) {
                            f13757a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f13757a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection2).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection2).setHostnameVerifier(q0.f13735a);
                        }
                    }
                    httpURLConnection2.setReadTimeout(20000);
                    httpURLConnection2.setConnectTimeout(ComConstants.AD_TIMEOUT_MILLIS);
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod("POST");
                    httpURLConnection2.setInstanceFollowRedirects(true);
                    byte[] bArrI = bArr;
                    if (bArrI.length > 2048) {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "gzip, deflate");
                        httpURLConnection2.setRequestProperty("zip", "1");
                        bArrI = i(bArr);
                    } else {
                        httpURLConnection2.setRequestProperty("Accept-Encoding", "text/example");
                        httpURLConnection2.setRequestProperty("zip", "0");
                    }
                    httpURLConnection2.setRequestProperty("fixed", "1");
                    httpURLConnection2.setRequestProperty("count", String.valueOf(list.size()));
                    httpURLConnection2.setRequestProperty("appids", br.d.d(list, "_"));
                    httpURLConnection2.setRequestProperty("ver", "3.0.0.5");
                    httpURLConnection2.setRequestProperty("uuid", str2);
                    httpURLConnection2.setRequestProperty("dupid", str3);
                    Pair<Integer, byte[]> pairT = ar.b.a().t();
                    byte[] bArr2 = (byte[]) pairT.second;
                    if (bArr2 != null) {
                        n0Var = new n0(bArr2);
                    }
                    if (n0Var == null) {
                        y0Var.f13773b.f13602d = "encrypt error";
                        httpURLConnection2.disconnect();
                        return y0Var;
                    }
                    byte[] bytes = Base64.encodeToString(n0Var.c(bArrI), 2).getBytes();
                    if (bytes == null) {
                        a0.c("requestByPost buffer is null");
                        y0Var.f13773b.f13602d = "base64 error";
                        httpURLConnection2.disconnect();
                        return y0Var;
                    }
                    httpURLConnection2.setRequestProperty("encrypt-level", "3");
                    httpURLConnection2.setRequestProperty("encrypt-index", "" + (((Integer) pairT.first).intValue() + 1));
                    httpURLConnection2.connect();
                    DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection2.getOutputStream());
                    dataOutputStream.write(bytes);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    int responseCode = httpURLConnection2.getResponseCode();
                    if (responseCode != 200) {
                        a0.d("--> post failed code : %d", Integer.valueOf(responseCode));
                        httpURLConnection2.disconnect();
                        return new y0<>(-1, new athena.b());
                    }
                    String strD = d(httpURLConnection2.getInputStream());
                    if (TextUtils.isEmpty(strD)) {
                        y0<athena.b> y0Var2 = new y0<>(-1, new athena.b("rc_" + i11));
                        httpURLConnection2.disconnect();
                        return y0Var2;
                    }
                    JSONObject jSONObject = new JSONObject(strD);
                    int iOptInt = jSONObject.optInt(TrackingKey.CODE);
                    String strOptString = jSONObject.optString("message", "");
                    athena.b bVar = new athena.b();
                    bVar.f13599a = iOptInt;
                    bVar.f13600b = strOptString;
                    if (iOptInt != 0) {
                        bVar.f13602d = "rc_" + iOptInt;
                        y0<athena.b> y0Var3 = new y0<>(-1, bVar);
                        httpURLConnection2.disconnect();
                        return y0Var3;
                    }
                    JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                    if (jSONObjectOptJSONObject != null) {
                        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            String next = itKeys.next();
                            long j11 = jSONObjectOptJSONObject.getJSONObject(next).getLong("ver");
                            int i12 = jSONObjectOptJSONObject.getJSONObject(next).getInt("type");
                            if (i12 != 0) {
                                athena.b.a aVar = new athena.b.a(Integer.parseInt(next), i12, j11);
                                if (bVar.f13601c == null) {
                                    bVar.f13601c = new ArrayList();
                                }
                                bVar.f13601c.add(aVar);
                            }
                        }
                    }
                    y0<athena.b> y0Var4 = new y0<>(0, bVar);
                    httpURLConnection2.disconnect();
                    return y0Var4;
                } catch (Exception e11) {
                    e = e11;
                    httpURLConnection = httpURLConnection2;
                    a0.c(e.getMessage());
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection = httpURLConnection2;
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Exception e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public static String d(InputStream inputStream) {
        try {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    bufferedReader.close();
                    inputStream.close();
                    return sb2.toString();
                }
                sb2.append(line);
            }
        } catch (IOException e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static List<File> e(String str, long j11) {
        List<File> listF = f(str, new ArrayList(), String.valueOf(j11));
        if (listF != null && listF.size() > 0) {
            Collections.sort(listF, new b());
        }
        return listF;
    }

    public static List<File> f(String str, List<File> list, String str2) {
        File[] fileArrListFiles;
        if (str == null) {
            return list;
        }
        File file = new File(str);
        if (!file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return list;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.isDirectory()) {
                f(file2.getAbsolutePath(), list, str2);
            } else if (str2 == null) {
                list.add(file2);
            } else if (file2.getName().contains(str2)) {
                list.add(file2);
            }
        }
        return list;
    }

    public static void g(File file) throws Throwable {
        if (file.exists() && file.isDirectory() && file.listFiles() != null) {
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    l(file2);
                } else if (file2.isDirectory()) {
                    g(file2);
                }
            }
        }
    }

    public static void h(String str) throws Throwable {
        File file = new File(str);
        g(file);
        if (file.isDirectory()) {
            if (file.listFiles() == null || file.listFiles().length == 0) {
                boolean zDelete = file.delete();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("deleteDir ");
                sb2.append(file.getName());
                sb2.append(" ");
                sb2.append(zDelete);
            }
        }
    }

    public static byte[] i(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            byteArrayOutputStream.reset();
            return byteArray;
        } catch (Exception e11) {
            a0.c(Log.getStackTraceString(e11));
            return null;
        }
    }

    public static y0<Long> j(String str) throws Throwable {
        Throwable th2;
        HttpURLConnection httpURLConnection;
        Exception e11;
        SSLContext sSLContextA;
        try {
            httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str).openConnection()));
            try {
                try {
                    if (httpURLConnection instanceof HttpsURLConnection) {
                        if (f13757a == null && (sSLContextA = q0.a()) != null) {
                            f13757a = sSLContextA.getSocketFactory();
                        }
                        SSLSocketFactory sSLSocketFactory = f13757a;
                        if (sSLSocketFactory != null) {
                            ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLSocketFactory);
                            ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(q0.f13735a);
                        }
                    }
                    httpURLConnection.setReadTimeout(10000);
                    httpURLConnection.setConnectTimeout(10000);
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode >= 200 && responseCode < 400) {
                        y0<Long> y0Var = new y0<>(0, Long.valueOf(httpURLConnection.getDate()));
                        httpURLConnection.disconnect();
                        return y0Var;
                    }
                } catch (Exception e12) {
                    e11 = e12;
                    if (e11 instanceof UnknownHostException) {
                        a0.c(e11.getMessage());
                    } else {
                        a0.c(Log.getStackTraceString(e11));
                    }
                    if (httpURLConnection != null) {
                    }
                    return new y0<>(-1, 0L);
                }
            } catch (Throwable th3) {
                th2 = th3;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        } catch (Exception e13) {
            e11 = e13;
            httpURLConnection = null;
        } catch (Throwable th4) {
            th2 = th4;
            httpURLConnection = null;
        }
        httpURLConnection.disconnect();
        return new y0<>(-1, 0L);
    }

    public static String k(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < bArrDigest.length; i11++) {
                if (Integer.toHexString(bArrDigest[i11] & 255).length() == 1) {
                    sb2.append("0");
                    sb2.append(Integer.toHexString(bArrDigest[i11] & 255));
                } else {
                    sb2.append(Integer.toHexString(bArrDigest[i11] & 255));
                }
            }
            return sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            return "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x0114 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:75:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x011d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:? A[SYNTHETIC] */
    public static boolean l(File file) throws Throwable {
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        if (file == null) {
            return true;
        }
        if (file.getParent().contains(ws.a.a().getFilesDir().getPath())) {
            File file2 = new File(file.getParent() + File.separator + System.currentTimeMillis());
            if (file.renameTo(file2)) {
                a0.e(String.format(Locale.getDefault(), "rename to %s success", file.getName()));
            }
            return file2.delete();
        }
        FileLock fileLockLock = null;
        try {
            randomAccessFile = new RandomAccessFile(file.getPath(), "rw");
            try {
                channel = randomAccessFile.getChannel();
                try {
                    try {
                        fileLockLock = channel.lock();
                        File file3 = new File(file.getParent() + File.separator + System.currentTimeMillis());
                        if (file.renameTo(file3)) {
                            a0.e(String.format(Locale.getDefault(), "rename to %s success", file.getName()));
                        }
                        boolean zDelete = file3.delete();
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused) {
                                a0.e("File to release file lock");
                            }
                        }
                        try {
                            channel.close();
                        } catch (IOException unused2) {
                            a0.e("File to release file channel");
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused3) {
                            a0.e("File to release file RandomAccessFile");
                        }
                        return zDelete;
                    } catch (Exception e11) {
                        e = e11;
                        a0.e("复制单个文件操作出错");
                        a0.c(Log.getStackTraceString(e));
                        if (fileLockLock != null) {
                            try {
                                fileLockLock.release();
                            } catch (IOException unused4) {
                                a0.e("File to release file lock");
                            }
                        }
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException unused5) {
                                a0.e("File to release file channel");
                            }
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused6) {
                                a0.e("File to release file RandomAccessFile");
                            }
                        }
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileLockLock != null) {
                        try {
                            fileLockLock.release();
                        } catch (IOException unused7) {
                            a0.e("File to release file lock");
                        }
                    }
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException unused8) {
                            a0.e("File to release file channel");
                        }
                    }
                    if (randomAccessFile != null) {
                        throw th;
                    }
                    try {
                        randomAccessFile.close();
                        throw th;
                    } catch (IOException unused9) {
                        a0.e("File to release file RandomAccessFile");
                        throw th;
                    }
                }
            } catch (Exception e12) {
                e = e12;
                channel = null;
            } catch (Throwable th3) {
                th = th3;
                channel = null;
                if (fileLockLock != null) {
                    fileLockLock.release();
                }
                if (channel != null) {
                    channel.close();
                }
                if (randomAccessFile != null) {
                    throw th;
                }
                randomAccessFile.close();
                throw th;
            }
        } catch (Exception e13) {
            e = e13;
            randomAccessFile = null;
            channel = null;
        } catch (Throwable th4) {
            th = th4;
            randomAccessFile = null;
            channel = null;
        }
    }

    public static List<File> m(String str) {
        List<File> listF = f(str, new ArrayList(), null);
        if (listF != null && listF.size() > 0) {
            try {
                Collections.sort(listF, new a());
            } catch (Exception e11) {
                a0.c(Log.getStackTraceString(e11));
            }
        }
        return listF;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0060 A[Catch: Exception -> 0x0064, TRY_LEAVE, TryCatch #4 {Exception -> 0x0064, blocks: (B:36:0x005b, B:38:0x0060), top: B:49:0x005b }] */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0026: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:15:0x0026 */
    public static byte[] n(byte[] bArr) throws Throwable {
        GZIPInputStream gZIPInputStream;
        GZIPInputStream gZIPInputStream2;
        GZIPInputStream gZIPInputStream3 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            try {
                gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
                try {
                    byte[] bArr2 = new byte[1024];
                    while (true) {
                        int i11 = gZIPInputStream.read(bArr2);
                        if (i11 < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, i11);
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    try {
                        byteArrayOutputStream.close();
                        gZIPInputStream.close();
                    } catch (Exception e11) {
                        a0.c(Log.getStackTraceString(e11));
                    }
                    return byteArray;
                } catch (Exception e12) {
                    e = e12;
                    a0.c(Log.getStackTraceString(e));
                    try {
                        byteArrayOutputStream.close();
                        if (gZIPInputStream != null) {
                            gZIPInputStream.close();
                        }
                    } catch (Exception e13) {
                        a0.c(Log.getStackTraceString(e13));
                    }
                    return null;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPInputStream3 = gZIPInputStream2;
                try {
                    byteArrayOutputStream.close();
                    if (gZIPInputStream3 != null) {
                        gZIPInputStream3.close();
                    }
                } catch (Exception e14) {
                    a0.c(Log.getStackTraceString(e14));
                }
                throw th;
            }
        } catch (Exception e15) {
            e = e15;
            gZIPInputStream = null;
        } catch (Throwable th3) {
            th = th3;
            byteArrayOutputStream.close();
            if (gZIPInputStream3 != null) {
                gZIPInputStream3.close();
            }
            throw th;
        }
    }
}
