package dg;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.datatransport.cct.internal.ClientInfo;
import com.google.android.datatransport.cct.internal.ComplianceData;
import com.google.android.datatransport.cct.internal.NetworkConnectionInfo;
import com.google.android.datatransport.cct.internal.QosTier;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.h;
import com.google.android.libraries.places.api.model.PlaceTypes;
import com.google.firebase.encoders.EncodingException;
import com.google.logging.type.LogSeverity;
import com.hisavana.common.constant.ComConstants;
import eg.i;
import eg.j;
import eg.l;
import eg.m;
import eg.n;
import fg.k;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class d implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final uk.a f63037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConnectivityManager f63038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f63039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final URL f63040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final og.a f63041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final og.a f63042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f63043g;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final URL f63044a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final i f63045b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final String f63046c;

        public a(URL url, i iVar, @Nullable String str) {
            this.f63044a = url;
            this.f63045b = iVar;
            this.f63046c = str;
        }

        public a a(URL url) {
            return new a(url, this.f63045b, this.f63046c);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f63047a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @Nullable
        public final URL f63048b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f63049c;

        public b(int i11, @Nullable URL url, long j11) {
            this.f63047a = i11;
            this.f63048b = url;
            this.f63049c = j11;
        }
    }

    public d(Context context, og.a aVar, og.a aVar2) {
        this(context, aVar, aVar2, 130000);
    }

    public d(Context context, og.a aVar, og.a aVar2, int i11) {
        this.f63037a = i.b();
        this.f63039c = context;
        this.f63038b = (ConnectivityManager) context.getSystemService("connectivity");
        this.f63040d = o(dg.a.f63028c);
        this.f63041e = aVar2;
        this.f63042f = aVar;
        this.f63043g = i11;
    }

    public static String f(Context context) {
        String simOperator = k(context).getSimOperator();
        return simOperator != null ? simOperator : "";
    }

    public static int g(NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return NetworkConnectionInfo.MobileSubtype.UNKNOWN_MOBILE_SUBTYPE.getValue();
        }
        int subtype = networkInfo.getSubtype();
        if (subtype == -1) {
            return NetworkConnectionInfo.MobileSubtype.COMBINED.getValue();
        }
        if (NetworkConnectionInfo.MobileSubtype.forNumber(subtype) != null) {
            return subtype;
        }
        return 0;
    }

    public static int h(NetworkInfo networkInfo) {
        return networkInfo == null ? NetworkConnectionInfo.NetworkType.NONE.getValue() : networkInfo.getType();
    }

    public static int i(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e11) {
            ig.a.d("CctTransportBackend", "Unable to find version code for package", e11);
            return -1;
        }
    }

    public static TelephonyManager k(Context context) {
        return (TelephonyManager) context.getSystemService("phone");
    }

    public static long l() {
        Calendar.getInstance();
        return TimeZone.getDefault().getOffset(Calendar.getInstance().getTimeInMillis()) / 1000;
    }

    public static /* synthetic */ a m(a aVar, b bVar) {
        URL url = bVar.f63048b;
        if (url == null) {
            return null;
        }
        ig.a.b("CctTransportBackend", "Following redirect to: %s", url);
        return aVar.a(bVar.f63048b);
    }

    public static InputStream n(InputStream inputStream, String str) throws IOException {
        return "gzip".equals(str) ? new GZIPInputStream(inputStream) : inputStream;
    }

    public static URL o(String str) {
        try {
            return new URL(str);
        } catch (MalformedURLException e11) {
            throw new IllegalArgumentException("Invalid url: " + str, e11);
        }
    }

    @Override // fg.k
    public com.google.android.datatransport.runtime.i a(com.google.android.datatransport.runtime.i iVar) {
        NetworkInfo activeNetworkInfo = this.f63038b.getActiveNetworkInfo();
        return iVar.m().a("sdk-version", Build.VERSION.SDK_INT).c("model", Build.MODEL).c("hardware", Build.HARDWARE).c("device", Build.DEVICE).c(AppLovinEventTypes.USER_VIEWED_PRODUCT, Build.PRODUCT).c("os-uild", Build.ID).c("manufacturer", Build.MANUFACTURER).c("fingerprint", Build.FINGERPRINT).b("tz-offset", l()).a("net-type", h(activeNetworkInfo)).a("mobile-subtype", g(activeNetworkInfo)).c(PlaceTypes.COUNTRY, Locale.getDefault().getCountry()).c("locale", Locale.getDefault().getLanguage()).c("mcc_mnc", f(this.f63039c)).c("application_build", Integer.toString(i(this.f63039c))).d();
    }

    @Override // fg.k
    public BackendResponse b(fg.e eVar) {
        i iVarJ = j(eVar);
        URL urlO = this.f63040d;
        String strD = null;
        if (eVar.c() != null) {
            try {
                dg.a aVarC = dg.a.c(eVar.c());
                strD = aVarC.d() != null ? aVarC.d() : null;
                if (aVarC.e() != null) {
                    urlO = o(aVarC.e());
                }
            } catch (IllegalArgumentException unused) {
                return BackendResponse.a();
            }
        }
        try {
            b bVar = (b) jg.b.a(5, new a(urlO, iVarJ, strD), new jg.a() { // from class: dg.b
                @Override // jg.a
                public final Object apply(Object obj) {
                    return this.f63036a.e((d.a) obj);
                }
            }, new jg.c() { // from class: dg.c
                @Override // jg.c
                public final Object a(Object obj, Object obj2) {
                    return d.m((d.a) obj, (d.b) obj2);
                }
            });
            int i11 = bVar.f63047a;
            if (i11 == 200) {
                return BackendResponse.e(bVar.f63049c);
            }
            if (i11 < 500 && i11 != 404) {
                return i11 == 400 ? BackendResponse.d() : BackendResponse.a();
            }
            return BackendResponse.f();
        } catch (IOException e11) {
            ig.a.d("CctTransportBackend", "Could not make request to the backend", e11);
            return BackendResponse.f();
        }
    }

    public final b e(a aVar) throws IOException {
        ig.a.f("CctTransportBackend", "Making request to: %s", aVar.f63044a);
        HttpURLConnection httpURLConnection = (HttpURLConnection) aVar.f63044a.openConnection();
        httpURLConnection.setConnectTimeout(ComConstants.AD_TIMEOUT_MILLIS);
        httpURLConnection.setReadTimeout(this.f63043g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", String.format("datatransport/%s android/", "3.2.0"));
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_ENCODING, "gzip");
        httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = aVar.f63046c;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    this.f63037a.a(aVar.f63045b, new BufferedWriter(new OutputStreamWriter(gZIPOutputStream)));
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    ig.a.f("CctTransportBackend", "Status Code: %d", Integer.valueOf(responseCode));
                    ig.a.b("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_TYPE));
                    ig.a.b("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField(HttpHeaders.LOCATION)), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream inputStreamN = n(inputStream, httpURLConnection.getHeaderField(HttpHeaders.CONTENT_ENCODING));
                        try {
                            b bVar = new b(responseCode, null, n.b(new BufferedReader(new InputStreamReader(inputStreamN))).c());
                            if (inputStreamN != null) {
                                inputStreamN.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } catch (Throwable th2) {
                            if (inputStreamN != null) {
                                try {
                                    inputStreamN.close();
                                } catch (Throwable th3) {
                                    th2.addSuppressed(th3);
                                }
                            }
                            throw th2;
                        }
                    } catch (Throwable th4) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (Throwable th5) {
                                th4.addSuppressed(th5);
                            }
                        }
                        throw th4;
                    }
                } catch (Throwable th6) {
                    try {
                        gZIPOutputStream.close();
                    } catch (Throwable th7) {
                        th6.addSuppressed(th7);
                    }
                    throw th6;
                }
            } catch (Throwable th8) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th9) {
                        th8.addSuppressed(th9);
                    }
                }
                throw th8;
            }
        } catch (EncodingException e11) {
            e = e11;
            ig.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(LogSeverity.WARNING_VALUE, null, 0L);
        } catch (ConnectException e12) {
            e = e12;
            ig.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e13) {
            e = e13;
            ig.a.d("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e14) {
            e = e14;
            ig.a.d("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(LogSeverity.WARNING_VALUE, null, 0L);
        }
    }

    public final i j(fg.e eVar) {
        l.a aVarK;
        HashMap map = new HashMap();
        for (com.google.android.datatransport.runtime.i iVar : eVar.b()) {
            String strK = iVar.k();
            if (map.containsKey(strK)) {
                ((List) map.get(strK)).add(iVar);
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(iVar);
                map.put(strK, arrayList);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            com.google.android.datatransport.runtime.i iVar2 = (com.google.android.datatransport.runtime.i) ((List) entry.getValue()).get(0);
            m.a aVarB = m.a().f(QosTier.DEFAULT).g(this.f63042f.a()).h(this.f63041e.a()).b(ClientInfo.a().c(ClientInfo.ClientType.ANDROID_FIREBASE).b(eg.a.a().m(Integer.valueOf(iVar2.g("sdk-version"))).j(iVar2.b("model")).f(iVar2.b("hardware")).d(iVar2.b("device")).l(iVar2.b(AppLovinEventTypes.USER_VIEWED_PRODUCT)).k(iVar2.b("os-uild")).h(iVar2.b("manufacturer")).e(iVar2.b("fingerprint")).c(iVar2.b(PlaceTypes.COUNTRY)).g(iVar2.b("locale")).i(iVar2.b("mcc_mnc")).b(iVar2.b("application_build")).a()).a());
            try {
                aVarB.i(Integer.parseInt((String) entry.getKey()));
            } catch (NumberFormatException unused) {
                aVarB.j((String) entry.getKey());
            }
            ArrayList arrayList3 = new ArrayList();
            for (com.google.android.datatransport.runtime.i iVar3 : (List) entry.getValue()) {
                h hVarE = iVar3.e();
                cg.c cVarB = hVarE.b();
                if (cVarB.equals(cg.c.b("proto"))) {
                    aVarK = l.k(hVarE.a());
                } else if (cVarB.equals(cg.c.b("json"))) {
                    aVarK = l.j(new String(hVarE.a(), Charset.forName("UTF-8")));
                } else {
                    ig.a.g("CctTransportBackend", "Received event of unsupported encoding %s. Skipping...", cVarB);
                }
                aVarK.d(iVar3.f()).e(iVar3.l()).i(iVar3.h("tz-offset")).f(NetworkConnectionInfo.a().c(NetworkConnectionInfo.NetworkType.forNumber(iVar3.g("net-type"))).b(NetworkConnectionInfo.MobileSubtype.forNumber(iVar3.g("mobile-subtype"))).a());
                if (iVar3.d() != null) {
                    aVarK.c(iVar3.d());
                }
                if (iVar3.j() != null) {
                    aVarK.b(ComplianceData.a().b(eg.k.a().b(j.a().b(iVar3.j()).a()).a()).c(ComplianceData.ProductIdOrigin.EVENT_OVERRIDE).a());
                }
                arrayList3.add(aVarK.a());
            }
            aVarB.c(arrayList3);
            arrayList2.add(aVarB.a());
        }
        return i.a(arrayList2);
    }
}
