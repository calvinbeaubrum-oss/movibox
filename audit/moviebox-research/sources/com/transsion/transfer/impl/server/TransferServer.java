package com.transsion.transfer.impl.server;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.transsion.transfer.androidasync.AsyncServer;
import com.transsion.transfer.androidasync.http.d0;
import com.transsion.transfer.androidasync.http.server.AsyncHttpServer;
import com.transsion.transfer.impl.PingPongHelper;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.d;
import com.transsion.transfer.impl.e;
import com.transsion.transfer.impl.entity.FileData;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class TransferServer implements d {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final a f59075s = new a(null);

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final String f59076t = TransferServer.class.getName();

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static volatile d f59077u;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f59078a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f59079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f59080c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.transfer.impl.c f59081d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f59082e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Handler f59083f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f59084g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AsyncHttpServer f59085h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final CopyOnWriteArrayList<e> f59086i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final CopyOnWriteArrayList<Function4<String, String, Boolean, String, Unit>> f59087j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f59088k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PingPongHelper.a f59089l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Runnable f59090m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final ConcurrentHashMap<String, d0> f59091n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f59092o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final ConcurrentHashMap<d0, PingPongHelper.a> f59093p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final ConcurrentHashMap<d0, PingPongHelper> f59094q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f59095r;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a() {
            d dVar = TransferServer.f59077u;
            if (dVar != null) {
                dVar.d();
            }
            TransferServer.f59077u = null;
        }

        public final d b(Context context) {
            Intrinsics.g(context, "context");
            d transferServer = TransferServer.f59077u;
            if (transferServer == null) {
                synchronized (this) {
                    transferServer = new TransferServer(context, null);
                    TransferServer.f59077u = transferServer;
                }
            }
            return transferServer;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements PingPongHelper.a {
        public b() {
        }

        @Override // com.transsion.transfer.impl.PingPongHelper.a
        public void a(String remoteIp, d0 socket) {
            Intrinsics.g(remoteIp, "remoteIp");
            Intrinsics.g(socket, "socket");
            String unused = TransferServer.f59076t;
            int iHashCode = TransferServer.this.hashCode();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("server detach socket has closed, clientIp: ");
            sb2.append(remoteIp);
            sb2.append(", ");
            sb2.append(iHashCode);
            sb2.append(", delay check again");
            if (TransferServer.this.f59082e) {
                TransferServer.this.f59095r.add(remoteIp);
                TransferServer.this.f59083f.postDelayed(TransferServer.this.f59090m, 3000L);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements com.transsion.transfer.impl.c {
        public c() {
        }

        @Override // com.transsion.transfer.impl.c
        public void a(String clientIp, String clientDeviceName) {
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(clientDeviceName, "clientDeviceName");
            String unused = TransferServer.f59076t;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("notifyClientInfoUpdate:clientIp:");
            sb2.append(clientIp);
            sb2.append(", clientDeviceName:");
            sb2.append(clientDeviceName);
            com.transsion.transfer.impl.c cVar = TransferServer.this.f59081d;
            if (cVar != null) {
                cVar.a(clientIp, clientDeviceName);
            }
        }

        @Override // com.transsion.transfer.impl.c
        public String b() {
            String strB;
            com.transsion.transfer.impl.c cVar = TransferServer.this.f59081d;
            if (cVar != null && (strB = cVar.b()) != null) {
                return strB;
            }
            String MODEL = Build.MODEL;
            Intrinsics.f(MODEL, "MODEL");
            return MODEL;
        }
    }

    public TransferServer(Context context) {
        this.f59078a = context;
        this.f59080c = "";
        this.f59083f = new Handler(Looper.getMainLooper());
        this.f59084g = new c();
        AsyncHttpServer asyncHttpServer = new AsyncHttpServer();
        asyncHttpServer.j("/pingpong*", "socket_connect", new AsyncHttpServer.a() { // from class: com.transsion.transfer.impl.server.a
            @Override // com.transsion.transfer.androidasync.http.server.AsyncHttpServer.a
            public final void a(d0 d0Var, com.transsion.transfer.androidasync.http.server.b bVar) throws UnsupportedEncodingException {
                TransferServer.B(this.f59099a, d0Var, bVar);
            }
        });
        this.f59085h = asyncHttpServer;
        this.f59086i = new CopyOnWriteArrayList<>();
        this.f59087j = new CopyOnWriteArrayList<>();
        this.f59088k = LazyKt__LazyJVMKt.b(new Function0<TransferController>() { // from class: com.transsion.transfer.impl.server.TransferServer$controller$2

            /* JADX INFO: compiled from: source.java */
            @Metadata
            @SourceDebugExtension
            public static final class a implements e {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ TransferServer f59098a;

                public a(TransferServer transferServer) {
                    this.f59098a = transferServer;
                }

                @Override // com.transsion.transfer.impl.e
                public void A(String clientIp) {
                    Intrinsics.g(clientIp, "clientIp");
                    for (FileData fileData : ry.b.f75768a.d()) {
                        if (fileData.getState() != 4 && fileData.getState() != 3 && fileData.getState() != 7) {
                            fileData.setState(5);
                        }
                    }
                    d0 d0Var = (d0) this.f59098a.f59091n.get(clientIp);
                    if (d0Var != null) {
                        d0Var.close();
                    }
                    Iterator it = this.f59098a.f59086i.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).A(clientIp);
                    }
                }

                @Override // com.transsion.transfer.impl.e
                public void U(String clientIp, String remoteFilePath, TaskState state, long j11, long j12) {
                    Object obj;
                    Object next;
                    Intrinsics.g(clientIp, "clientIp");
                    Intrinsics.g(remoteFilePath, "remoteFilePath");
                    Intrinsics.g(state, "state");
                    Iterator<T> it = ry.b.f75768a.d().iterator();
                    do {
                        obj = null;
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(remoteFilePath, ((FileData) next).getFileRemotePath()));
                    FileData fileData = (FileData) next;
                    if (fileData != null) {
                        TransferServer transferServer = this.f59098a;
                        if (fileData.getState() != 5 && fileData.getState() != 6 && fileData.getState() != 3 && fileData.getState() != 4) {
                            fileData.setState(FileData.Companion.a(state));
                            fileData.setDownloadSize(j11);
                            fileData.setFileSize(j12);
                        }
                        Iterator it2 = transferServer.f59086i.iterator();
                        while (it2.hasNext()) {
                            ((e) it2.next()).U(clientIp, remoteFilePath, state, j11, j12);
                        }
                    }
                    for (Object obj2 : ry.b.f75768a.d()) {
                        if (Intrinsics.b(remoteFilePath, ((FileData) obj2).getCoverUrl())) {
                            obj = obj2;
                            break;
                        }
                    }
                    if (((FileData) obj) != null) {
                        Iterator it3 = this.f59098a.f59086i.iterator();
                        while (it3.hasNext()) {
                            ((e) it3.next()).U(clientIp, remoteFilePath, state, j11, j12);
                        }
                    }
                }

                @Override // com.transsion.transfer.impl.e
                public void d(String clientIp) {
                    Intrinsics.g(clientIp, "clientIp");
                    Iterator it = this.f59098a.f59086i.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).d(clientIp);
                    }
                }

                @Override // com.transsion.transfer.impl.e
                public void i(String clientIp, String remoteFilePath, long j11, long j12) {
                    Object next;
                    Intrinsics.g(clientIp, "clientIp");
                    Intrinsics.g(remoteFilePath, "remoteFilePath");
                    Iterator<T> it = ry.b.f75768a.d().iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), remoteFilePath));
                    FileData fileData = (FileData) next;
                    if (fileData != null) {
                        fileData.setState(2);
                        fileData.setDownloadSize(j11);
                        fileData.setFileSize(j12);
                    }
                    Iterator it2 = this.f59098a.f59086i.iterator();
                    while (it2.hasNext()) {
                        ((e) it2.next()).i(clientIp, remoteFilePath, j11, j12);
                    }
                }

                @Override // com.transsion.transfer.impl.e
                public void w(String clientIp) {
                    Object next;
                    Intrinsics.g(clientIp, "clientIp");
                    Iterator it = this.f59098a.f59086i.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).w(clientIp);
                    }
                    Iterator<T> it2 = ry.b.f75768a.d().iterator();
                    do {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                    } while (((FileData) next).getState() != 2);
                    FileData fileData = (FileData) next;
                    if (fileData != null) {
                        fileData.setState(4);
                    }
                }

                @Override // com.transsion.transfer.impl.e
                public void y(String clientIp, List<FileData> files) {
                    Intrinsics.g(clientIp, "clientIp");
                    Intrinsics.g(files, "files");
                    Iterator it = this.f59098a.f59086i.iterator();
                    while (it.hasNext()) {
                        ((e) it.next()).y(clientIp, files);
                    }
                }
            }

            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TransferController invoke() {
                return new TransferController(this.this$0.f59084g, new a(this.this$0));
            }
        });
        this.f59089l = new b();
        this.f59090m = new Runnable() { // from class: com.transsion.transfer.impl.server.b
            @Override // java.lang.Runnable
            public final void run() {
                TransferServer.y(this.f59100a);
            }
        };
        this.f59091n = new ConcurrentHashMap<>();
        this.f59092o = new ConcurrentHashMap<>();
        this.f59093p = new ConcurrentHashMap<>();
        this.f59094q = new ConcurrentHashMap<>();
        this.f59095r = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ TransferServer(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public static final void B(final TransferServer this$0, final d0 webSocket, com.transsion.transfer.androidasync.http.server.b bVar) throws UnsupportedEncodingException {
        d0 d0VarRemove;
        Intrinsics.g(this$0, "this$0");
        final String clientIp = bVar.j().getString("clientIp");
        final String transferId = bVar.j().getString("transferId");
        Intrinsics.f(transferId, "it");
        this$0.f59080c = transferId;
        String string = bVar.j().getString("deviceName");
        Intrinsics.f(string, "request.query.getString(…t.KEY_HEADER_DEVICE_NAME)");
        String strA = oy.a.a(string);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("find client connect, clientIp:");
        sb2.append(clientIp);
        sb2.append(", clientDeviceName");
        sb2.append(strA);
        sb2.append(", transferId:");
        sb2.append(transferId);
        int size = this$0.f59091n.size();
        ConcurrentHashMap<String, d0> concurrentHashMap = this$0.f59091n;
        StringBuilder sb3 = new StringBuilder();
        sb3.append("find client connect, clientSocketMap: ");
        sb3.append(size);
        sb3.append(", ");
        sb3.append(concurrentHashMap);
        this$0.f59095r.remove(clientIp);
        this$0.f59082e = true;
        this$0.f59083f.removeCallbacks(this$0.f59090m);
        if (this$0.f59091n.contains(clientIp) && (d0VarRemove = this$0.f59091n.remove(clientIp)) != null) {
            PingPongHelper.a aVarRemove = this$0.f59093p.remove(d0VarRemove);
            if (aVarRemove != null) {
                Intrinsics.f(clientIp, "clientIp");
                aVarRemove.a(clientIp, d0VarRemove);
            }
            d0VarRemove.close();
        }
        int size2 = this$0.f59087j.size();
        CopyOnWriteArrayList<Function4<String, String, Boolean, String, Unit>> copyOnWriteArrayList = this$0.f59087j;
        StringBuilder sb4 = new StringBuilder();
        sb4.append("find client connect, clientConnectListeners:");
        sb4.append(size2);
        sb4.append(", ");
        sb4.append(copyOnWriteArrayList);
        sb4.append(" , ");
        sb4.append(this$0);
        Iterator<T> it = this$0.f59087j.iterator();
        while (it.hasNext()) {
            Function4 function4 = (Function4) it.next();
            Intrinsics.f(clientIp, "clientIp");
            Intrinsics.f(transferId, "transferId");
            function4.invoke(clientIp, transferId, Boolean.TRUE, null);
        }
        ConcurrentHashMap<String, String> concurrentHashMap2 = this$0.f59092o;
        Intrinsics.f(clientIp, "clientIp");
        concurrentHashMap2.put(clientIp, strA);
        ConcurrentHashMap<String, d0> concurrentHashMap3 = this$0.f59091n;
        Intrinsics.f(webSocket, "webSocket");
        concurrentHashMap3.put(clientIp, webSocket);
        c cVar = this$0.f59084g;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("find client connect, proxyFileHandler:");
        sb5.append(cVar);
        this$0.f59084g.a(clientIp, strA);
        ConcurrentHashMap<d0, PingPongHelper> concurrentHashMap4 = this$0.f59094q;
        PingPongHelper pingPongHelper = new PingPongHelper(clientIp, true, webSocket, this$0.f59089l);
        pingPongHelper.n();
        concurrentHashMap4.put(webSocket, pingPongHelper);
        webSocket.y(new fy.a() { // from class: com.transsion.transfer.impl.server.c
            @Override // fy.a
            public final void i(Exception exc) {
                TransferServer.C(clientIp, this$0, webSocket, transferId, exc);
            }
        });
        this$0.A(clientIp);
        this$0.f59079b = true;
    }

    public static final void C(String clientIp, TransferServer this$0, d0 webSocket, String transferId, Exception exc) {
        Intrinsics.g(this$0, "this$0");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("server socket close callback ip: ");
        sb2.append(clientIp);
        PingPongHelper.a aVar = this$0.f59089l;
        Intrinsics.f(clientIp, "clientIp");
        Intrinsics.f(webSocket, "webSocket");
        aVar.a(clientIp, webSocket);
        Iterator<T> it = this$0.f59087j.iterator();
        while (it.hasNext()) {
            Function4 function4 = (Function4) it.next();
            Intrinsics.f(transferId, "transferId");
            function4.invoke(clientIp, transferId, Boolean.FALSE, "normal");
        }
    }

    public static final void y(TransferServer this$0) {
        Intrinsics.g(this$0, "this$0");
        if (!this$0.f59095r.isEmpty()) {
            for (e eVar : this$0.f59086i) {
                String str = (String) CollectionsKt___CollectionsKt.e0(this$0.f59095r);
                if (str == null) {
                    str = "";
                } else {
                    Intrinsics.f(str, "waitLostMap.first() ?: \"\"");
                }
                eVar.A(str);
            }
            f59075s.a();
            this$0.f59082e = false;
        }
    }

    public final void A(String str) throws UnsupportedEncodingException {
        d0 d0Var = this.f59091n.get(str);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIp:");
        sb2.append(str);
        sb2.append(" , socket:");
        sb2.append(d0Var);
        if (d0Var != null) {
            d0Var.send("cmd=-2?deviceName=" + oy.a.b(this.f59084g.b()));
        }
    }

    @Override // com.transsion.transfer.impl.d
    public void a(e listener) {
        Intrinsics.g(listener, "listener");
        this.f59086i.remove(listener);
        this.f59086i.add(listener);
    }

    @Override // com.transsion.transfer.impl.d
    public void b(Function4<? super String, ? super String, ? super Boolean, ? super String, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f59087j.remove(listener);
        this.f59087j.add(listener);
    }

    @Override // com.transsion.transfer.impl.d
    public List<String> c() {
        Set<String> setKeySet = this.f59091n.keySet();
        Intrinsics.f(setKeySet, "clientSocketMap.keys");
        return CollectionsKt___CollectionsKt.M0(CollectionsKt___CollectionsKt.J0(setKeySet));
    }

    @Override // com.transsion.transfer.impl.d
    public void d() {
        for (Map.Entry<String, d0> entry : this.f59091n.entrySet()) {
            entry.getValue().send("cmd=-1");
            entry.getValue().close();
        }
        this.f59091n.clear();
        this.f59092o.clear();
        this.f59093p.clear();
        for (Map.Entry<d0, PingPongHelper> entry2 : this.f59094q.entrySet()) {
            entry2.getKey().close();
            entry2.getValue().o();
        }
        this.f59094q.clear();
        this.f59087j.clear();
        AsyncServer.r().L();
        this.f59085h.u();
        this.f59079b = false;
    }

    @Override // com.transsion.transfer.impl.d
    public void e(com.transsion.transfer.impl.c cVar) {
        this.f59081d = cVar;
    }

    @Override // com.transsion.transfer.impl.d
    public void f(String clientIp, int i11) {
        Intrinsics.g(clientIp, "clientIp");
        d0 d0Var = this.f59091n.get(clientIp);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("notifyClientCMD: clientIp:");
        sb2.append(clientIp);
        sb2.append(" , socket:");
        sb2.append(d0Var);
        sb2.append(", cmd:");
        sb2.append(i11);
        if (d0Var != null) {
            d0Var.send("cmd=" + i11);
        }
    }

    @Override // com.transsion.transfer.impl.d
    public void g(e listener) {
        Intrinsics.g(listener, "listener");
        this.f59086i.remove(listener);
    }

    @Override // com.transsion.transfer.impl.d
    public void h(Function4<? super String, ? super String, ? super Boolean, ? super String, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f59087j.remove(listener);
    }

    @Override // com.transsion.transfer.impl.d
    public List<String> i() {
        Collection<String> collectionValues = this.f59092o.values();
        Intrinsics.f(collectionValues, "clientInfoMap.values");
        return CollectionsKt___CollectionsKt.M0(CollectionsKt___CollectionsKt.J0(collectionValues));
    }

    @Override // com.transsion.transfer.impl.d
    public boolean isRunning() {
        return this.f59079b;
    }

    @Override // com.transsion.transfer.impl.d
    public String j() {
        return this.f59080c;
    }

    @Override // com.transsion.transfer.impl.d
    public void open() {
        if (this.f59079b) {
            return;
        }
        for (TransferController.b bVar : z().e()) {
            String strA = bVar.a();
            String strB = bVar.b();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("open: ");
            sb2.append(strA);
            sb2.append(", ");
            sb2.append(strB);
            if (Intrinsics.b(bVar.a(), "get")) {
                this.f59085h.f(bVar.b(), bVar.c());
            } else if (Intrinsics.b(bVar.a(), "post")) {
                this.f59085h.i(bVar.b(), bVar.c());
            }
        }
        this.f59085h.o(AsyncServer.r(), 9890);
    }

    public final TransferController z() {
        return (TransferController) this.f59088k.getValue();
    }
}
