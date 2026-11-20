package ho;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.common.util.concurrent.Futures;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class j extends p007do.n {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final int f66682q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final int f66683r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final int f66684s;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f66685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f66686d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f66687e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f66688f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f66689g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f66690h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ReadWriteLock f66691i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f66692j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SparseArray f66693k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final LinkedTransferQueue f66694l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.google.common.util.concurrent.s f66695m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f66696n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f66697o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f66698p;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends do.n.a<j> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f66699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f66700c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f66701d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f66702e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f66703f;

        public a() {
            super(j.class);
            this.f66699b = j.f66682q;
            this.f66700c = j.f66683r;
            this.f66701d = j.f66684s;
            this.f66702e = 64;
        }

        public /* synthetic */ a(int i11) {
            this();
        }

        @Override // do.n.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public j b(p007do.m mVar, Context context) {
            if (Build.VERSION.SDK_INT >= 34) {
                try {
                    return new m0(mVar, context, this);
                } catch (Throwable unused) {
                    int i11 = j.f66682q;
                }
            }
            return new j(mVar, this);
        }

        public a i(@Nullable String str) {
            this.f66703f = str;
            return this;
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f66682q = (int) timeUnit.toMillis(30L);
        f66683r = (int) timeUnit.toMillis(30L);
        f66684s = (int) timeUnit.toMillis(15L);
    }

    public j(p007do.m mVar, a aVar) {
        super("remote-service", mVar);
        this.f66685c = (d) mVar.A(d.class);
        this.f66686d = aVar.f66703f == null;
        this.f66687e = aVar.f66699b;
        this.f66688f = aVar.f66700c;
        this.f66689g = aVar.f66701d;
        this.f66690h = aVar.f66702e;
        this.f66691i = io.d0.d();
        this.f66692j = aVar.f66703f;
        this.f66693k = new SparseArray();
        this.f66694l = new LinkedTransferQueue();
    }

    public static Pair j(List list) {
        ArrayList arrayList = new ArrayList(list.size());
        io.r rVar = new io.r();
        for (int i11 = 0; i11 < list.size(); i11++) {
            p007do.f0 f0Var = (p007do.f0) list.get(i11);
            if (!f0Var.f63451a.isDone()) {
                arrayList.add(f0Var);
                final p007do.f0 f0Var2 = (p007do.f0) list.get(i11);
                Objects.requireNonNull(f0Var2);
                rVar.p(i11 + 1, new androidx.core.util.a() { // from class: ho.g
                    @Override // androidx.core.util.a
                    public final void accept(Object obj) {
                        f0Var2.b((io.r) obj);
                    }
                });
            }
        }
        return new Pair(arrayList, rVar.f());
    }

    public static a ofProvider() {
        return new a(0);
    }

    @Override // p007do.n
    public void a() {
        Lock lockWriteLock = this.f66691i.writeLock();
        lockWriteLock.lock();
        try {
            if (this.f66696n) {
                lockWriteLock.unlock();
                return;
            }
            this.f66696n = true;
            com.google.common.util.concurrent.s sVar = this.f66695m;
            lockWriteLock.unlock();
            if (sVar != null) {
                try {
                    sVar.get(30L, TimeUnit.SECONDS);
                } catch (Throwable unused) {
                    sVar.cancel(false);
                }
            }
            while (true) {
                p007do.f0 f0Var = (p007do.f0) this.f66694l.poll();
                if (f0Var == null) {
                    return;
                } else {
                    f0Var.f63451a.setException(new IllegalStateException("module destroyed"));
                }
            }
        } catch (Throwable th2) {
            lockWriteLock.unlock();
            throw th2;
        }
    }

    @Override // p007do.n
    public void e(Context context) {
        boolean zS;
        Lock lockWriteLock = this.f66691i.writeLock();
        lockWriteLock.lock();
        try {
            zS = s();
        } catch (Throwable unused) {
            zS = false;
        }
        try {
            this.f66697o = zS;
        } finally {
            lockWriteLock.unlock();
        }
    }

    public final /* synthetic */ Boolean k(Pair pair) {
        return Boolean.valueOf(q((String) pair.first, (List) pair.second));
    }

    public final String l(String str) throws ProtocolException {
        p007do.f0 f0Var = new p007do.f0(false, 1869374824L, null, null);
        o(str, Collections.singletonList(f0Var));
        io.o oVar = new io.o((ByteBuffer) Futures.e(f0Var.f63451a));
        SparseArray sparseArray = this.f66693k;
        sparseArray.clear();
        this.f66698p = false;
        while (true) {
            String strQ = str;
            while (oVar.b()) {
                int iN = oVar.n();
                if (iN == 1) {
                    strQ = oVar.q();
                    if (strQ.isEmpty()) {
                    }
                } else if (iN == 2) {
                    io.o oVar2 = new io.o(oVar.f());
                    int iO = -1;
                    String strQ2 = "";
                    while (oVar2.b()) {
                        int iN2 = oVar2.n();
                        if (iN2 == 1) {
                            iO = oVar2.o();
                        } else if (iN2 != 2) {
                            oVar2.c();
                        } else {
                            strQ2 = oVar2.q();
                        }
                    }
                    sparseArray.put(iO, strQ2);
                } else if (iN != 3) {
                    oVar.c();
                } else {
                    this.f66698p = oVar.d();
                }
            }
            return strQ;
        }
    }

    public HttpURLConnection m(URL url) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(url.openConnection()));
        httpURLConnection.setConnectTimeout(this.f66687e);
        httpURLConnection.setReadTimeout(this.f66688f);
        return httpURLConnection;
    }

    public final void n(p007do.f0 f0Var) {
        if (f0Var.f63451a.isDone()) {
            return;
        }
        Lock lock = this.f66691i.readLock();
        lock.lock();
        try {
            if (this.f66696n) {
                f0Var.f63451a.setException(new IllegalStateException("module destroyed"));
                lock.unlock();
                return;
            }
            this.f66694l.add(f0Var);
            if (this.f66695m != null) {
                lock.unlock();
                return;
            }
            lock.unlock();
            Lock lockWriteLock = this.f66691i.writeLock();
            lockWriteLock.lock();
            try {
                if (!this.f66696n && this.f66695m == null) {
                    try {
                        this.f66695m = d().n().submit((Runnable) new h(this));
                    } catch (RejectedExecutionException unused) {
                    }
                }
            } finally {
                lockWriteLock.unlock();
            }
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    public final void o(String str, List list) throws ProtocolException {
        Pair pairJ = j(list);
        List list2 = (List) pairJ.first;
        if (list2.isEmpty()) {
            return;
        }
        URL url = new URL(AgentPageJsBridge.HTTPS + str);
        HttpURLConnection httpURLConnectionM = m(url);
        httpURLConnectionM.setDoOutput(true);
        httpURLConnectionM.setChunkedStreamingMode(0);
        httpURLConnectionM.setRequestMethod("POST");
        httpURLConnectionM.setRequestProperty(HttpHeaders.CONTENT_TYPE, OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        httpURLConnectionM.setRequestProperty(HttpHeaders.HOST, url.getHost());
        httpURLConnectionM.setRequestProperty("x-ogm-sid", d().K().toString());
        httpURLConnectionM.setRequestProperty("x-ogm-sdy", "com.polygamma.ogm");
        httpURLConnectionM.setRequestProperty("x-ogm-svr", p007do.m.f63464o);
        httpURLConnectionM.setRequestProperty("x-ogm-app", d().i().c());
        httpURLConnectionM.setRequestProperty("x-ogm-os", "Android");
        httpURLConnectionM.setRequestProperty("x-requested-with", d().i().c());
        try {
            OutputStream outputStream = httpURLConnectionM.getOutputStream();
            try {
                ByteBuffer byteBuffer = (ByteBuffer) pairJ.second;
                outputStream.write(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
                byteBuffer.remaining();
                list2.size();
                outputStream.close();
                if (httpURLConnectionM.getResponseCode() != 200) {
                    Locale locale = Locale.ROOT;
                    throw new IOException("invalid response code " + httpURLConnectionM.getResponseCode() + ": " + httpURLConnectionM.getResponseMessage());
                }
                InputStream inputStream = httpURLConnectionM.getInputStream();
                try {
                    ByteBuffer byteBufferWrap = ByteBuffer.wrap(Build.VERSION.SDK_INT >= 33 ? inputStream.readAllBytes() : hj.b.b(inputStream));
                    io.o oVar = new io.o(byteBufferWrap);
                    byteBufferWrap.remaining();
                    while (oVar.b()) {
                        ((p007do.f0) list2.get(oVar.n() - 1)).a(new io.o(oVar.f()));
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    httpURLConnectionM.disconnect();
                } catch (Throwable th2) {
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th5) {
                        th4.addSuppressed(th5);
                    }
                }
                throw th4;
            }
        } catch (Throwable th6) {
            httpURLConnectionM.disconnect();
            throw th6;
        }
    }

    public final boolean q(String str, List list) {
        try {
            o(str, list);
            return false;
        } catch (IOException unused) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                n((p007do.f0) it.next());
            }
            return true;
        } catch (Throwable th2) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((p007do.f0) it2.next()).f63451a.setException(th2);
            }
            return false;
        }
    }

    public final boolean s() {
        JSONObject jSONObjectY = d().y("ogm_remotesvc", new JSONObject());
        String strOptString = jSONObjectY.optString("0", "");
        JSONObject jSONObjectOptJSONObject = jSONObjectY.optJSONObject("1");
        if (strOptString.isEmpty() || jSONObjectOptJSONObject == null || !(this.f66686d || strOptString.equals(this.f66692j))) {
            return false;
        }
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f66693k.put(Integer.parseInt(next), jSONObjectOptJSONObject.getString(next));
        }
        this.f66692j = strOptString;
        this.f66698p = jSONObjectY.optBoolean("2", false);
        String.format("Loaded settings: %s", jSONObjectY);
        return true;
    }

    public final void t() throws JSONException {
        if (this.f66692j == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (int i11 = 0; i11 < this.f66693k.size(); i11++) {
            jSONObject2.put(Integer.toString(this.f66693k.keyAt(i11)), this.f66693k.valueAt(i11));
        }
        jSONObject.put("0", this.f66692j).put("1", jSONObject2).put("2", this.f66698p);
        d().D("ogm_remotesvc", jSONObject);
        String.format("Saved settings: %s", jSONObject);
    }

    public final boolean u() {
        ArrayList arrayList = new ArrayList(3);
        k kVarD = this.f66685c.o().d();
        if (!this.f66686d) {
            arrayList.add(this.f66692j);
        } else if (kVarD == null || !("cn".equalsIgnoreCase(kVarD.i()) || "cn".equalsIgnoreCase(kVarD.f()))) {
            arrayList.add("ogsvc.pg-adtech.cn");
            arrayList.add("ogsvc.pgoriginad.com");
        } else {
            arrayList.add("ogsvc.pgoriginad.com");
            arrayList.add("ogsvc.pg-adtech.cn");
        }
        while (!arrayList.isEmpty()) {
            String str = (String) arrayList.remove(arrayList.size() - 1);
            try {
                String strL = l(str);
                if (strL.equals(str)) {
                    if (this.f66686d) {
                        this.f66692j = str;
                    } else if (!str.equals(this.f66692j)) {
                        this.f66693k.put(0, str);
                    }
                    this.f66697o = true;
                    try {
                        t();
                    } catch (Throwable unused) {
                    }
                    return true;
                }
                arrayList.add(strL);
            } catch (Throwable unused2) {
            }
        }
        this.f66693k.clear();
        this.f66697o = false;
        if (this.f66686d) {
            this.f66692j = null;
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0120 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:103:0x0138 A[EDGE_INSN: B:103:0x0138->B:67:0x0138 BREAK  A[LOOP:5: B:64:0x0120->B:66:0x0128], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x003a  */
    /* JADX WARN: Code duplicated, block: B:30:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x008a  */
    /* JADX WARN: Code duplicated, block: B:38:0x0093 A[LOOP:2: B:36:0x008d->B:38:0x0093, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:41:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:62:0x010c  */
    /* JADX WARN: Code duplicated, block: B:66:0x0128 A[LOOP:5: B:64:0x0120->B:66:0x0128, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:68:0x013a A[LOOP:4: B:60:0x0106->B:68:0x013a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x0147  */
    /* JADX WARN: Code duplicated, block: B:89:0x0158 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:97:0x006b A[SYNTHETIC] */
    public final void v() {
        SparseArray sparseArray;
        int i11;
        int i12;
        ArrayList arrayList;
        String str;
        int i13;
        int size;
        Iterator it;
        Pair pair;
        Lock lockWriteLock;
        p007do.f0 f0Var;
        ArrayList arrayList2;
        String str2 = this.f66697o ? this.f66692j : null;
        ArrayList arrayList3 = new ArrayList();
        do {
            Lock lock = this.f66691i.readLock();
            lock.lock();
            try {
                if (this.f66696n) {
                    this.f66695m = null;
                } else {
                    if (str2 != null || u()) {
                        str2 = this.f66692j;
                        lock.unlock();
                    } else {
                        w();
                    }
                    if (str2 == null) {
                        return;
                    }
                    sparseArray = new SparseArray();
                    i11 = 0;
                    for (i12 = 0; i12 < this.f66690h && (f0Var = (p007do.f0) this.f66694l.poll()) != null; i12++) {
                        arrayList2 = (ArrayList) sparseArray.get((int) (f0Var.f63453c >>> 32));
                        if (arrayList2 == null) {
                            arrayList2 = new ArrayList();
                            sparseArray.put((int) (f0Var.f63453c >>> 32), arrayList2);
                        }
                        arrayList2.add(f0Var);
                    }
                    arrayList = new ArrayList(sparseArray.size());
                    str = (String) this.f66693k.get(0, this.f66692j);
                    if (com.google.common.base.p.b(str)) {
                        str = this.f66692j;
                    }
                    for (i13 = 0; i13 < sparseArray.size(); i13++) {
                        arrayList.add(new Pair((String) this.f66693k.get(sparseArray.keyAt(i13), str), (ArrayList) sparseArray.valueAt(i13)));
                    }
                    if (arrayList.isEmpty()) {
                        lockWriteLock = this.f66691i.writeLock();
                        lockWriteLock.lock();
                        try {
                            if (!this.f66696n || this.f66694l.isEmpty()) {
                                this.f66695m = null;
                                lockWriteLock.unlock();
                                return;
                            }
                            lockWriteLock.unlock();
                        } catch (Throwable th2) {
                            lockWriteLock.unlock();
                            throw th2;
                        }
                    }
                    for (size = arrayList.size() - 1; size >= 1; size--) {
                        final Pair pair2 = (Pair) arrayList.get(size);
                        try {
                            arrayList3.add(d().n().submit(new Callable() { // from class: ho.i
                                @Override // java.util.concurrent.Callable
                                public final Object call() {
                                    return this.f66680a.k(pair2);
                                }
                            }));
                            arrayList.remove(size);
                        } catch (RejectedExecutionException unused) {
                        }
                    }
                    while (i11 < arrayList.size()) {
                        pair = (Pair) arrayList.get(i11);
                        if (q((String) pair.first, (List) pair.second)) {
                            while (true) {
                                i11++;
                                if (i11 < arrayList.size()) {
                                    break;
                                } else {
                                    this.f66694l.addAll((Collection) ((Pair) arrayList.get(i11)).second);
                                }
                            }
                            str2 = null;
                            break;
                        }
                        i11++;
                    }
                    it = arrayList3.iterator();
                    while (it.hasNext()) {
                        try {
                            Futures.e((Future) it.next());
                        } catch (Throwable unused2) {
                        }
                    }
                }
                lock.unlock();
                str2 = null;
                if (str2 == null) {
                    return;
                }
                sparseArray = new SparseArray();
                i11 = 0;
                while (i12 < this.f66690h) {
                    arrayList2 = (ArrayList) sparseArray.get((int) (f0Var.f63453c >>> 32));
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        sparseArray.put((int) (f0Var.f63453c >>> 32), arrayList2);
                    }
                    arrayList2.add(f0Var);
                }
                arrayList = new ArrayList(sparseArray.size());
                str = (String) this.f66693k.get(0, this.f66692j);
                if (com.google.common.base.p.b(str)) {
                    str = this.f66692j;
                }
                while (i13 < sparseArray.size()) {
                    arrayList.add(new Pair((String) this.f66693k.get(sparseArray.keyAt(i13), str), (ArrayList) sparseArray.valueAt(i13)));
                }
                if (arrayList.isEmpty()) {
                    lockWriteLock = this.f66691i.writeLock();
                    lockWriteLock.lock();
                    if (this.f66696n) {
                    }
                    this.f66695m = null;
                    lockWriteLock.unlock();
                    return;
                }
                while (size >= 1) {
                    final Pair pair3 = (Pair) arrayList.get(size);
                    arrayList3.add(d().n().submit(new Callable() { // from class: ho.i
                        @Override // java.util.concurrent.Callable
                        public final Object call() {
                            return this.f66680a.k(pair3);
                        }
                    }));
                    arrayList.remove(size);
                }
                while (i11 < arrayList.size()) {
                    pair = (Pair) arrayList.get(i11);
                    if (q((String) pair.first, (List) pair.second)) {
                        while (true) {
                            i11++;
                            if (i11 < arrayList.size()) {
                                break;
                                break;
                            }
                            this.f66694l.addAll((Collection) ((Pair) arrayList.get(i11)).second);
                        }
                        str2 = null;
                        break;
                    }
                    i11++;
                }
                it = arrayList3.iterator();
                while (it.hasNext()) {
                    Futures.e((Future) it.next());
                }
            } catch (Throwable th3) {
                lock.unlock();
                throw th3;
            }
        } while (str2 != null);
        w();
    }

    public final void w() {
        this.f66695m = d().n().schedule((Runnable) new h(this), this.f66689g, TimeUnit.MILLISECONDS);
    }

    public com.google.common.util.concurrent.s<ByteBuffer> x(long j11, @Nullable ByteBuffer byteBuffer) {
        p007do.f0 f0Var = new p007do.f0(this.f66698p, j11, byteBuffer, null);
        n(f0Var);
        return f0Var.f63451a;
    }
}
