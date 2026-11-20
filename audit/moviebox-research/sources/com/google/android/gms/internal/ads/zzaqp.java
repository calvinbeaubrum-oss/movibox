package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class zzaqp implements zzapt {
    protected final zzaqr zza;

    @Deprecated
    protected final zzaqo zzb;
    private final zzaqo zzc;

    public zzaqp(zzaqo zzaqoVar) {
        zzaqr zzaqrVar = new zzaqr(4096);
        this.zzc = zzaqoVar;
        this.zzb = zzaqoVar;
        this.zza = zzaqrVar;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x02cf  */
    /* JADX WARN: Code duplicated, block: B:146:0x02df  */
    /* JADX WARN: Code duplicated, block: B:148:0x02e3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:149:0x02e5  */
    /* JADX WARN: Code duplicated, block: B:151:0x0300  */
    /* JADX WARN: Code duplicated, block: B:153:0x0319  */
    /* JADX WARN: Code duplicated, block: B:165:0x0340  */
    /* JADX WARN: Code duplicated, block: B:187:0x02c2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:204:0x0399 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:205:0x0393 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzapt
    public zzapw zza(zzaqa zzaqaVar) throws Throwable {
        zzaqy zzaqyVar;
        byte[] bArr;
        int iZzb;
        zzarc zzarcVar;
        zzapw zzapwVar;
        zzarc zzarcVar2;
        int iZzb2;
        Map mapEmptyMap;
        byte[] byteArray;
        byte[] bArrZzb;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            Collections.emptyList();
            boolean z11 = true;
            try {
                zzapj zzapjVarZzd = zzaqaVar.zzd();
                if (zzapjVarZzd == null) {
                    mapEmptyMap = Collections.emptyMap();
                } else {
                    HashMap map = new HashMap();
                    String str = zzapjVarZzd.zzb;
                    if (str != null) {
                        map.put("If-None-Match", str);
                    }
                    long j11 = zzapjVarZzd.zzd;
                    if (j11 > 0) {
                        map.put("If-Modified-Since", zzaqx.zzc(j11));
                    }
                    mapEmptyMap = map;
                }
                String strZzk = zzaqaVar.zzk();
                HashMap map2 = new HashMap();
                map2.putAll(mapEmptyMap);
                map2.putAll(zzaqaVar.zzl());
                URL url = new URL(strZzk);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
                int iZzb3 = zzaqaVar.zzb();
                httpURLConnection.setConnectTimeout(iZzb3);
                httpURLConnection.setReadTimeout(iZzb3);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setDoInput(true);
                "https".equals(url.getProtocol());
                try {
                    for (String str2 : map2.keySet()) {
                        httpURLConnection.setRequestProperty(str2, (String) map2.get(str2));
                    }
                    if (zzaqaVar.zza() != 0) {
                        httpURLConnection.setRequestMethod("POST");
                        byte[] bArrZzx = zzaqaVar.zzx();
                        if (bArrZzx != null) {
                            httpURLConnection.setDoOutput(true);
                            if (!httpURLConnection.getRequestProperties().containsKey(HttpHeaders.CONTENT_TYPE)) {
                                httpURLConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded; charset=UTF-8");
                            }
                            DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                            dataOutputStream.write(bArrZzx);
                            dataOutputStream.close();
                        }
                    } else {
                        httpURLConnection.setRequestMethod("GET");
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode == -1) {
                        try {
                            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
                        } catch (Throwable th2) {
                            th = th2;
                            z11 = false;
                            if (!z11) {
                                httpURLConnection.disconnect();
                            }
                            throw th;
                        }
                    }
                    zzaqaVar.zza();
                    if ((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) {
                        zzaqyVar = new zzaqy(responseCode, zzara.zza(httpURLConnection.getHeaderFields()), -1, null);
                        httpURLConnection.disconnect();
                    } else {
                        try {
                            zzaqyVar = new zzaqy(responseCode, zzara.zza(httpURLConnection.getHeaderFields()), httpURLConnection.getContentLength(), new zzaqz(httpURLConnection));
                        } catch (Throwable th3) {
                            th = th3;
                            if (!z11) {
                                try {
                                    httpURLConnection.disconnect();
                                } catch (IOException e11) {
                                    e = e11;
                                    zzaqyVar = null;
                                    bArr = null;
                                    if (e instanceof SocketTimeoutException) {
                                        zzarcVar = new zzarc("socket", new zzaqi(), null);
                                    } else {
                                        if (e instanceof MalformedURLException) {
                                            throw new RuntimeException("Bad URL ".concat(String.valueOf(zzaqaVar.zzk())), e);
                                        }
                                        if (zzaqyVar == null) {
                                            throw new zzapx(e);
                                        }
                                        iZzb = zzaqyVar.zzb();
                                        zzaqm.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzaqaVar.zzk());
                                        if (bArr != null) {
                                            zzapwVar = new zzapw(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqyVar.zzd());
                                            if (iZzb == 401) {
                                            }
                                            zzarcVar = new zzarc("auth", new zzapi(zzapwVar), null);
                                        } else {
                                            zzarcVar = new zzarc("network", new zzapv(), null);
                                        }
                                    }
                                    zzarcVar2 = zzarcVar;
                                    zzapo zzapoVarZzy = zzaqaVar.zzy();
                                    iZzb2 = zzaqaVar.zzb();
                                    try {
                                        zzapoVarZzy.zzc(zzarcVar2.zzb);
                                        zzaqaVar.zzm(String.format("%s-retry [timeout=%s]", zzarcVar2.zza, Integer.valueOf(iZzb2)));
                                    } catch (zzaqj e12) {
                                        zzaqaVar.zzm(String.format("%s-timeout-giveup [timeout=%s]", zzarcVar2.zza, Integer.valueOf(iZzb2)));
                                        throw e12;
                                    }
                                }
                            }
                            throw th;
                        }
                    }
                    try {
                        int iZzb4 = zzaqyVar.zzb();
                        List listZzd = zzaqyVar.zzd();
                        if (iZzb4 == 304) {
                            long jElapsedRealtime2 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            zzapj zzapjVarZzd2 = zzaqaVar.zzd();
                            if (zzapjVarZzd2 == null) {
                                return new zzapw(304, (byte[]) null, true, jElapsedRealtime2, listZzd);
                            }
                            TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
                            if (!listZzd.isEmpty()) {
                                Iterator it = listZzd.iterator();
                                while (it.hasNext()) {
                                    treeSet.add(((zzaps) it.next()).zza());
                                }
                            }
                            ArrayList arrayList = new ArrayList(listZzd);
                            List list = zzapjVarZzd2.zzh;
                            if (list != null) {
                                if (!list.isEmpty()) {
                                    for (zzaps zzapsVar : zzapjVarZzd2.zzh) {
                                        if (!treeSet.contains(zzapsVar.zza())) {
                                            arrayList.add(zzapsVar);
                                        }
                                    }
                                }
                            } else if (!zzapjVarZzd2.zzg.isEmpty()) {
                                for (Map.Entry entry : zzapjVarZzd2.zzg.entrySet()) {
                                    if (!treeSet.contains(entry.getKey())) {
                                        arrayList.add(new zzaps((String) entry.getKey(), (String) entry.getValue()));
                                    }
                                }
                            }
                            return new zzapw(304, zzapjVarZzd2.zza, true, jElapsedRealtime2, (List) arrayList);
                        }
                        InputStream inputStreamZzc = zzaqyVar.zzc();
                        if (inputStreamZzc != null) {
                            int iZza = zzaqyVar.zza();
                            try {
                                zzaqr zzaqrVar = this.zza;
                                zzard zzardVar = new zzard(zzaqrVar, iZza);
                                try {
                                    bArrZzb = zzaqrVar.zzb(1024);
                                    while (true) {
                                        try {
                                            int i11 = inputStreamZzc.read(bArrZzb);
                                            if (i11 == -1) {
                                                break;
                                            }
                                            zzardVar.write(bArrZzb, 0, i11);
                                        } catch (Throwable th4) {
                                            th = th4;
                                            try {
                                                inputStreamZzc.close();
                                            } catch (IOException unused) {
                                                zzaqm.zzd("Error occurred when closing InputStream", new Object[0]);
                                            }
                                            zzaqrVar.zza(bArrZzb);
                                            zzardVar.close();
                                            throw th;
                                        }
                                    }
                                    byteArray = zzardVar.toByteArray();
                                    try {
                                        inputStreamZzc.close();
                                    } catch (IOException unused2) {
                                        zzaqm.zzd("Error occurred when closing InputStream", new Object[0]);
                                    }
                                    zzaqrVar.zza(bArrZzb);
                                    zzardVar.close();
                                } catch (Throwable th5) {
                                    th = th5;
                                    bArrZzb = null;
                                }
                            } catch (IOException e13) {
                                e = e13;
                                bArr = null;
                                if (e instanceof SocketTimeoutException) {
                                    zzarcVar = new zzarc("socket", new zzaqi(), null);
                                } else {
                                    if (e instanceof MalformedURLException) {
                                        throw new RuntimeException("Bad URL ".concat(String.valueOf(zzaqaVar.zzk())), e);
                                    }
                                    if (zzaqyVar == null) {
                                        throw new zzapx(e);
                                    }
                                    iZzb = zzaqyVar.zzb();
                                    zzaqm.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzaqaVar.zzk());
                                    if (bArr != null) {
                                        zzapwVar = new zzapw(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqyVar.zzd());
                                        if (iZzb == 401) {
                                        }
                                        zzarcVar = new zzarc("auth", new zzapi(zzapwVar), null);
                                    } else {
                                        zzarcVar = new zzarc("network", new zzapv(), null);
                                    }
                                }
                                zzarcVar2 = zzarcVar;
                                zzapo zzapoVarZzy2 = zzaqaVar.zzy();
                                iZzb2 = zzaqaVar.zzb();
                                zzapoVarZzy2.zzc(zzarcVar2.zzb);
                                zzaqaVar.zzm(String.format("%s-retry [timeout=%s]", zzarcVar2.zza, Integer.valueOf(iZzb2)));
                            }
                        } else {
                            byteArray = new byte[0];
                        }
                        try {
                            long jElapsedRealtime3 = SystemClock.elapsedRealtime() - jElapsedRealtime;
                            if (zzaqm.zzb || jElapsedRealtime3 > 3000) {
                                Object[] objArr = new Object[5];
                                objArr[0] = zzaqaVar;
                                objArr[1] = Long.valueOf(jElapsedRealtime3);
                                objArr[2] = byteArray != null ? Integer.valueOf(byteArray.length) : "null";
                                objArr[3] = Integer.valueOf(iZzb4);
                                objArr[4] = Integer.valueOf(zzaqaVar.zzy().zza());
                                zzaqm.zza("HTTP response for request=<%s> [lifetime=%d], [size=%s], [rc=%d], [retryCount=%s]", objArr);
                            }
                            if (iZzb4 < 200 || iZzb4 > 299) {
                                throw new IOException();
                            }
                            return new zzapw(iZzb4, byteArray, false, SystemClock.elapsedRealtime() - jElapsedRealtime, listZzd);
                        } catch (IOException e14) {
                            e = e14;
                            bArr = byteArray;
                            if (e instanceof SocketTimeoutException) {
                                zzarcVar = new zzarc("socket", new zzaqi(), null);
                            } else {
                                if (e instanceof MalformedURLException) {
                                    throw new RuntimeException("Bad URL ".concat(String.valueOf(zzaqaVar.zzk())), e);
                                }
                                if (zzaqyVar == null) {
                                    throw new zzapx(e);
                                }
                                iZzb = zzaqyVar.zzb();
                                zzaqm.zzb("Unexpected response code %d for %s", Integer.valueOf(iZzb), zzaqaVar.zzk());
                                if (bArr != null) {
                                    zzapwVar = new zzapw(iZzb, bArr, false, SystemClock.elapsedRealtime() - jElapsedRealtime, zzaqyVar.zzd());
                                    if (iZzb == 401 && iZzb != 403) {
                                        if (iZzb < 400 || iZzb > 499) {
                                            throw new zzaqh(zzapwVar);
                                        }
                                        throw new zzapn(zzapwVar);
                                    }
                                    zzarcVar = new zzarc("auth", new zzapi(zzapwVar), null);
                                } else {
                                    zzarcVar = new zzarc("network", new zzapv(), null);
                                }
                            }
                            zzarcVar2 = zzarcVar;
                            zzapo zzapoVarZzy3 = zzaqaVar.zzy();
                            iZzb2 = zzaqaVar.zzb();
                            zzapoVarZzy3.zzc(zzarcVar2.zzb);
                            zzaqaVar.zzm(String.format("%s-retry [timeout=%s]", zzarcVar2.zza, Integer.valueOf(iZzb2)));
                        }
                    } catch (IOException e15) {
                        e = e15;
                    }
                } catch (Throwable th6) {
                    th = th6;
                }
            } catch (IOException e16) {
                e = e16;
            }
            zzaqaVar.zzm(String.format("%s-retry [timeout=%s]", zzarcVar2.zza, Integer.valueOf(iZzb2)));
        }
    }
}
