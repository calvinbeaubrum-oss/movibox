package com.transsion.transfer.impl.client;

import android.os.Build;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.androidasync.http.d0;
import com.transsion.transfer.androidasync.http.h;
import com.transsion.transfer.androidasync.http.i;
import com.transsion.transfer.androidasync.http.k;
import com.transsion.transfer.impl.PingPongHelper;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.entity.TransferResponse;
import com.transsion.transfer.impl.util.StringExtKt;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.l;

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
public final class TransferClient implements com.transsion.transfer.impl.a {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final Companion f58969t = new Companion(null);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final String f58970u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static volatile com.transsion.transfer.impl.a f58971v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static String f58972w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static String f58973x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static String f58974y;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f58975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f58976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f58977c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f58978d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f58979e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f58980f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f58981g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile d0 f58982h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f58983i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f58984j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PingPongHelper f58985k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f58986l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f58987m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Function3<? super String, ? super Boolean, ? super String, Unit> f58988n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f58989o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final PingPongHelper.a f58990p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final a f58991q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final CopyOnWriteArrayList<com.transsion.transfer.impl.b> f58992r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final f f58993s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void j(Companion companion, String str, String str2, String str3, Function0 function0, int i11, Object obj) {
            if ((i11 & 4) != 0) {
                str3 = companion.e();
            }
            companion.i(str, str2, str3, function0);
        }

        public final h a(String url, String clientIp, String transferId) {
            Intrinsics.g(url, "url");
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(transferId, "transferId");
            h hVar = new h(url);
            hVar.c("clientIp", clientIp);
            hVar.c("transferId", transferId);
            hVar.c("transferProtocolVersion", "1");
            hVar.y(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            return hVar;
        }

        public final i b(String url, String clientIp, String transferId) {
            Intrinsics.g(url, "url");
            Intrinsics.g(clientIp, "clientIp");
            Intrinsics.g(transferId, "transferId");
            i iVar = new i(url);
            iVar.c("clientIp", clientIp);
            iVar.c("transferId", transferId);
            iVar.c("transferProtocolVersion", "1");
            iVar.y(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
            return iVar;
        }

        public final void c(final Function0<Unit> function0) {
            TransferClient.f58972w = null;
            TransferClient.f58973x = null;
            TransferClient.f58974y = null;
            ry.a.f75766a.b();
            if (TransferClient.f58971v == null) {
                if (function0 != null) {
                    function0.invoke();
                }
            } else {
                com.transsion.transfer.impl.a aVar = TransferClient.f58971v;
                if (aVar != null) {
                    aVar.c(new Function0<Unit>() { // from class: com.transsion.transfer.impl.client.TransferClient$Companion$destroy$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.f68710a;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            Function0<Unit> function1 = function0;
                            if (function1 != null) {
                                function1.invoke();
                            }
                        }
                    });
                }
                TransferClient.f58971v = null;
            }
        }

        public final boolean d() {
            String str;
            String str2;
            String str3 = TransferClient.f58972w;
            if (str3 == null) {
                return false;
            }
            if (!(!(str3.length() == 0)) || (str = TransferClient.f58973x) == null) {
                return false;
            }
            if (!(!(str.length() == 0)) || (str2 = TransferClient.f58974y) == null) {
                return false;
            }
            return (str2.length() == 0) ^ true;
        }

        public final String e() {
            return StringExtKt.a(System.currentTimeMillis() + "&1000&" + Build.BRAND + "&" + Build.MODEL + "&" + Build.PRODUCT);
        }

        public final com.transsion.transfer.impl.a f() {
            com.transsion.transfer.impl.a transferClient = TransferClient.f58971v;
            if (transferClient == null) {
                synchronized (this) {
                    String str = TransferClient.f58972w;
                    Intrinsics.d(str);
                    String str2 = TransferClient.f58973x;
                    Intrinsics.d(str2);
                    String str3 = TransferClient.f58974y;
                    Intrinsics.d(str3);
                    transferClient = new TransferClient(str, str2, str3, null);
                    TransferClient.f58971v = transferClient;
                }
            }
            return transferClient;
        }

        public final String g() {
            return TransferClient.f58970u;
        }

        public final String h() {
            return TransferClient.f58974y;
        }

        public final void i(String serverIpNew, String clientIpNew, String transferIdNew, final Function0<Unit> callback) {
            Intrinsics.g(serverIpNew, "serverIpNew");
            Intrinsics.g(clientIpNew, "clientIpNew");
            Intrinsics.g(transferIdNew, "transferIdNew");
            Intrinsics.g(callback, "callback");
            TransferClient.f58972w = serverIpNew;
            TransferClient.f58973x = clientIpNew;
            TransferClient.f58974y = transferIdNew;
            if (TransferClient.f58971v == null) {
                callback.invoke();
                return;
            }
            com.transsion.transfer.impl.a aVar = TransferClient.f58971v;
            if (aVar != null) {
                aVar.c(new Function0<Unit>() { // from class: com.transsion.transfer.impl.client.TransferClient$Companion$initConnectInfo$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.f68710a;
                    }

                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        callback.invoke();
                        TransferClient.f58971v = null;
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements Function2<List<String>, Boolean, Unit> {
        public a() {
        }

        public void a(List<String> list, boolean z11) {
            Intrinsics.g(list, "list");
            TransferClient.this.g0(list);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(List<String> list, Boolean bool) {
            a(list, bool.booleanValue());
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends AsyncHttpClient.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f58995a;

        public b(Function0<Unit> function0) {
            this.f58995a = function0;
        }

        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, String str) {
            this.f58995a.invoke();
            TransferClient.f58969t.g();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerClientClose ,");
            sb2.append(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends AsyncHttpClient.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<Exception, Unit> f58996a;

        /* JADX WARN: Multi-variable type inference failed */
        public c(Function1<? super Exception, Unit> function1) {
            this.f58996a = function1;
        }

        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, String str) {
            TransferClient.f58969t.g();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: sendServerCreateNotify , e:");
            sb2.append(message);
            this.f58996a.invoke(exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d extends AsyncHttpClient.j {
        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, String str) {
            TransferClient.f58969t.g();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerClientSpaceLimit ,");
            sb2.append(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e extends AsyncHttpClient.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List<String> f58997a;

        public e(List<String> list) {
            this.f58997a = list;
        }

        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, String str) {
            TransferClient.f58969t.g();
            List<String> list = this.f58997a;
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: notifyServerTaskFinish:");
            sb2.append(list);
            sb2.append(" ,");
            sb2.append(message);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class f implements com.transsion.transfer.impl.b {
        public f() {
        }

        @Override // com.transsion.transfer.impl.b
        public void L(String remoteFilePath, long j11, long j12) {
            Object next;
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            Iterator<T> it = ry.a.f75766a.d().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(remoteFilePath, ((FileData) next).getFileRemotePath()));
            FileData fileData = (FileData) next;
            if (fileData != null) {
                fileData.setState(2);
                fileData.setDownloadSize(j11);
                fileData.setFileSize(j12);
            }
            Iterator it2 = TransferClient.this.f58992r.iterator();
            while (it2.hasNext()) {
                ((com.transsion.transfer.impl.b) it2.next()).L(remoteFilePath, j11, j12);
            }
        }

        @Override // com.transsion.transfer.impl.b
        public void R(String remoteFilePath, TaskState state, long j11, long j12, long j13, String str) {
            Object next;
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            Intrinsics.g(state, "state");
            Iterator<T> it = ry.a.f75766a.d().iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(remoteFilePath, ((FileData) next).getFileRemotePath()));
            FileData fileData = (FileData) next;
            if (fileData != null && fileData.getState() != 5 && fileData.getState() != 6 && fileData.getState() != 3 && fileData.getState() != 4 && fileData.getState() != 7) {
                fileData.setState(FileData.Companion.a(state));
                fileData.setDownloadSize(j11);
                fileData.setFileSize(j12);
            }
            Iterator it2 = TransferClient.this.f58992r.iterator();
            while (it2.hasNext()) {
                ((com.transsion.transfer.impl.b) it2.next()).R(remoteFilePath, state, j11, j12, j13, str);
            }
            if (state == TaskState.SPACE_LIMIT) {
                TransferClient.this.f0(remoteFilePath, 7);
            }
        }

        @Override // com.transsion.transfer.impl.b
        public void Y() {
            for (FileData fileData : ry.a.f75766a.d()) {
                if (fileData.getState() != 4 && fileData.getState() != 3 && fileData.getState() != 7) {
                    fileData.setState(5);
                }
            }
            Iterator it = TransferClient.this.f58992r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.b) it.next()).Y();
            }
        }

        @Override // com.transsion.transfer.impl.b
        public void l(int i11) {
            Iterator it = TransferClient.this.f58992r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.b) it.next()).l(i11);
            }
        }

        @Override // com.transsion.transfer.impl.b
        public void z(String remoteFilePath) {
            Intrinsics.g(remoteFilePath, "remoteFilePath");
            Iterator it = TransferClient.this.f58992r.iterator();
            while (it.hasNext()) {
                ((com.transsion.transfer.impl.b) it.next()).z(remoteFilePath);
            }
        }
    }

    static {
        String name = TransferClient.class.getName();
        Intrinsics.f(name, "TransferClient::class.java.name");
        f58970u = name;
    }

    public TransferClient(String str, String str2, String str3) {
        this.f58975a = str;
        this.f58976b = str2;
        this.f58977c = str3;
        this.f58978d = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.transfer.impl.client.TransferClient$deviceName$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return Build.MODEL;
            }
        });
        this.f58979e = LazyKt__LazyJVMKt.b(new Function0<AsyncHttpClient>() { // from class: com.transsion.transfer.impl.client.TransferClient$client$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final AsyncHttpClient invoke() {
                return AsyncHttpClient.w();
            }
        });
        this.f58980f = LazyKt__LazyJVMKt.b(new Function0<com.transsion.transfer.impl.client.e>() { // from class: com.transsion.transfer.impl.client.TransferClient$fileReceiver$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final e invoke() {
                AsyncHttpClient client = this.this$0.V();
                Intrinsics.f(client, "client");
                return new e(client, this.this$0.f58976b, this.this$0.f58977c, this.this$0.a0(), this.this$0.f58993s, this.this$0.f58991q);
            }
        });
        this.f58981g = LazyKt__LazyJVMKt.b(new Function0<com.transsion.transfer.impl.client.d>() { // from class: com.transsion.transfer.impl.client.TransferClient$coverReceiver$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final d invoke() {
                AsyncHttpClient client = this.this$0.V();
                Intrinsics.f(client, "client");
                return new d(client, this.this$0.f58976b, this.this$0.f58977c, this.this$0.a0(), this.this$0.f58993s);
            }
        });
        this.f58984j = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: com.transsion.transfer.impl.client.TransferClient$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new Gson();
            }
        });
        this.f58986l = LazyKt__LazyJVMKt.b(new Function0<String>() { // from class: com.transsion.transfer.impl.client.TransferClient$host$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return "http://" + this.this$0.f58975a + ":9890";
            }
        });
        this.f58990p = new PingPongHelper.a() { // from class: com.transsion.transfer.impl.client.TransferClient$pingPongListener$1
            @Override // com.transsion.transfer.impl.PingPongHelper.a
            public void a(String remoteIp, d0 socket) throws UnsupportedEncodingException {
                Intrinsics.g(remoteIp, "remoteIp");
                Intrinsics.g(socket, "socket");
                TransferClient.f58969t.g();
                boolean z11 = this.f59002a.f58989o;
                String str4 = this.f59002a.f58975a;
                String str5 = this.f59002a.f58976b;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("client detach socket has closed, disconnectByUser:");
                sb2.append(z11);
                sb2.append(", serverIp: ");
                sb2.append(str4);
                sb2.append(", clientIp: ");
                sb2.append(str5);
                sb2.append(", start auto connect");
                socket.close();
                PingPongHelper pingPongHelper = this.f59002a.f58985k;
                if (pingPongHelper != null) {
                    pingPongHelper.o();
                }
                this.f59002a.f58985k = null;
                if (this.f59002a.f58989o) {
                    return;
                }
                final TransferClient transferClient = this.f59002a;
                transferClient.R(new Function2<Boolean, String, Unit>() { // from class: com.transsion.transfer.impl.client.TransferClient$pingPongListener$1$onDetachDisconnect$1
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str6) {
                        invoke(bool.booleanValue(), str6);
                        return Unit.f68710a;
                    }

                    public final void invoke(boolean z12, String error) {
                        Intrinsics.g(error, "error");
                        if (z12) {
                            TransferClient.f58969t.g();
                            return;
                        }
                        TransferClient.f58969t.g();
                        transferClient.f58982h = null;
                        transferClient.f58993s.Y();
                        transferClient.Y().q();
                        transferClient.f58987m = null;
                    }
                });
            }
        };
        this.f58991q = new a();
        this.f58992r = new CopyOnWriteArrayList<>();
        this.f58993s = new f();
    }

    public /* synthetic */ TransferClient(String str, String str2, String str3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3);
    }

    public static final void S(final TransferClient this$0, Function2 listener, Exception exc, final d0 webSocket) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(listener, "$listener");
        boolean z11 = false;
        this$0.f58983i = false;
        if (exc == null) {
            this$0.f58982h = webSocket;
            d0 d0Var = this$0.f58982h;
            if (d0Var != null) {
                d0Var.I(new d0.c() { // from class: com.transsion.transfer.impl.client.b
                    @Override // com.transsion.transfer.androidasync.http.d0.c
                    public final void a(String str) {
                        TransferClient.T(this.f59005a, str);
                    }
                });
            }
            d0 d0Var2 = this$0.f58982h;
            if (d0Var2 != null) {
                d0Var2.y(new fy.a() { // from class: com.transsion.transfer.impl.client.c
                    @Override // fy.a
                    public final void i(Exception exc2) {
                        TransferClient.U(this.f59006a, webSocket, exc2);
                    }
                });
            }
            String str = this$0.f58975a;
            Intrinsics.f(webSocket, "webSocket");
            PingPongHelper pingPongHelper = new PingPongHelper(str, false, webSocket, this$0.f58990p);
            pingPongHelper.n();
            this$0.f58985k = pingPongHelper;
        } else {
            exc.printStackTrace();
            String str2 = this$0.f58975a;
            String message = exc.getMessage();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("serverIP:");
            sb2.append(str2);
            sb2.append(" connect error: ");
            sb2.append(message);
            sb2.append(" ");
        }
        if (exc == null && webSocket != null) {
            z11 = true;
        }
        Boolean boolValueOf = Boolean.valueOf(z11);
        String message2 = exc.getMessage();
        if (message2 == null) {
            message2 = "";
        }
        listener.invoke(boolValueOf, message2);
    }

    public static final void T(TransferClient this$0, String it) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.f(it, "it");
        this$0.c0(it);
    }

    public static final void U(TransferClient this$0, d0 webSocket, Exception exc) {
        Intrinsics.g(this$0, "this$0");
        PingPongHelper pingPongHelper = this$0.f58985k;
        if (pingPongHelper != null) {
            pingPongHelper.o();
        }
        PingPongHelper.a aVar = this$0.f58990p;
        String str = this$0.f58975a;
        Intrinsics.f(webSocket, "webSocket");
        aVar.a(str, webSocket);
    }

    public final void R(final Function2<? super Boolean, ? super String, Unit> function2) throws UnsupportedEncodingException {
        this.f58989o = false;
        AsyncHttpClient asyncHttpClientV = V();
        String str = this.f58976b;
        String str2 = this.f58977c;
        String deviceName = X();
        Intrinsics.f(deviceName, "deviceName");
        asyncHttpClientV.L(b0("/pingpong?clientIp=" + str + "&transferId=" + str2 + "&deviceName=" + oy.a.b(deviceName)), "socket_connect", new AsyncHttpClient.k() { // from class: com.transsion.transfer.impl.client.a
            @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.k
            public final void a(Exception exc, d0 d0Var) {
                TransferClient.S(this.f59003a, function2, exc, d0Var);
            }
        });
    }

    public final AsyncHttpClient V() {
        return (AsyncHttpClient) this.f58979e.getValue();
    }

    public final com.transsion.transfer.impl.client.d W() {
        return (com.transsion.transfer.impl.client.d) this.f58981g.getValue();
    }

    public final String X() {
        return (String) this.f58978d.getValue();
    }

    public final com.transsion.transfer.impl.client.e Y() {
        return (com.transsion.transfer.impl.client.e) this.f58980f.getValue();
    }

    public final Gson Z() {
        return (Gson) this.f58984j.getValue();
    }

    @Override // com.transsion.transfer.impl.a
    public void a(Function1<? super Exception, Unit> callback) {
        Intrinsics.g(callback, "callback");
        V().v(f58969t.a(b0("/client/notifyServerCreate"), this.f58976b, this.f58977c), new c(callback));
    }

    public final String a0() {
        return (String) this.f58986l.getValue();
    }

    @Override // com.transsion.transfer.impl.a
    public void b(Function3<? super String, ? super Boolean, ? super String, Unit> function3) {
        this.f58988n = function3;
    }

    public final String b0(String str) {
        String str2 = a0() + str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("getUrl baseUrl: ");
        sb2.append(str2);
        return str2;
    }

    @Override // com.transsion.transfer.impl.a
    public void c(final Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f58989o = true;
        e0(new Function0<Unit>() { // from class: com.transsion.transfer.impl.client.TransferClient$disConnect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                d0 d0Var = this.this$0.f58982h;
                if (d0Var != null) {
                    d0Var.close();
                }
                this.this$0.f58983i = false;
                PingPongHelper pingPongHelper = this.this$0.f58985k;
                if (pingPongHelper != null) {
                    pingPongHelper.o();
                }
                callback.invoke();
                this.this$0.Y().q();
            }
        });
        this.f58992r.clear();
    }

    public final boolean c0(String str) {
        if (!l.L(str, "cmd", false, 2, null)) {
            return false;
        }
        try {
            List listE0 = StringsKt__StringsKt.E0(str, new String[]{"?"}, false, 0, 6, null);
            int i11 = Integer.parseInt((String) StringsKt__StringsKt.E0((CharSequence) listE0.get(0), new String[]{"="}, false, 0, 6, null).get(1));
            List<String> listE1 = listE0.size() > 1 ? StringsKt__StringsKt.E0((CharSequence) listE0.get(1), new String[]{"&"}, false, 0, 6, null) : new ArrayList<>();
            if (i11 < 0) {
                d0(i11, listE1);
            } else {
                this.f58993s.l(i11);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return true;
    }

    @Override // com.transsion.transfer.impl.a
    public void d(Function2<? super Boolean, ? super String, Unit> listener) throws UnsupportedEncodingException {
        d0 d0Var;
        d0 d0Var2;
        Intrinsics.g(listener, "listener");
        if ((this.f58982h == null || (d0Var2 = this.f58982h) == null || !d0Var2.isOpen()) && !this.f58983i) {
            this.f58983i = true;
            R(listener);
            return;
        }
        d0 d0Var3 = this.f58982h;
        d0 d0Var4 = this.f58982h;
        Boolean boolValueOf = d0Var4 != null ? Boolean.valueOf(d0Var4.isOpen()) : null;
        boolean z11 = this.f58983i;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("connect: socket:");
        sb2.append(d0Var3);
        sb2.append(", socket#isOpen:");
        sb2.append(boolValueOf);
        sb2.append(", socketConnecting:");
        sb2.append(z11);
        listener.invoke(Boolean.valueOf((this.f58982h == null || (d0Var = this.f58982h) == null || !d0Var.isOpen()) ? false : true), "connect is process");
    }

    public final void d0(int i11, List<String> list) {
        d0 d0Var;
        if (i11 != -2) {
            if (i11 == -1 && (d0Var = this.f58982h) != null) {
                d0Var.close();
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List listE0 = StringsKt__StringsKt.E0((String) it.next(), new String[]{"="}, false, 0, 6, null);
            linkedHashMap.put(listE0.get(0), oy.a.a((String) listE0.get(1)));
        }
        String str = (String) linkedHashMap.get("deviceName");
        this.f58987m = str;
        Function3<? super String, ? super Boolean, ? super String, Unit> function3 = this.f58988n;
        if (function3 != null) {
            function3.invoke(str, Boolean.TRUE, "client");
        }
    }

    @Override // com.transsion.transfer.impl.a
    public void e(final String root, final Function2<? super List<FileData>, ? super Exception, Unit> callback) {
        Intrinsics.g(root, "root");
        Intrinsics.g(callback, "callback");
        V().v(f58969t.a(b0("/client/getTransferFilesList"), this.f58976b, this.f58977c), new AsyncHttpClient.j() { // from class: com.transsion.transfer.impl.client.TransferClient$fetchList$1
            @Override // fy.g
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void c(Exception exc, k kVar, String str) {
                TransferClient.f58969t.g();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("fetchList onCompleted: result:");
                sb2.append(str);
                sb2.append(" and e:");
                sb2.append(exc);
                if (exc != null) {
                    callback.invoke(null, exc);
                    return;
                }
                TransferClient transferClient = this;
                Function2<List<FileData>, Exception, Unit> function2 = callback;
                String str2 = root;
                try {
                    Result.Companion companion = Result.Companion;
                    TransferResponse transferResponse = (TransferResponse) transferClient.Z().fromJson(str, new TypeToken<TransferResponse<List<FileData>>>() { // from class: com.transsion.transfer.impl.client.TransferClient$fetchList$1$onCompleted$1$data$1
                    }.getType());
                    if (transferResponse.getCode() == 0) {
                        for (FileData fileData : (Iterable) transferResponse.getData()) {
                            ny.b.f72217c.a();
                            String fileRemotePath = fileData.getFileRemotePath();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("fetchList#onCompleted: ");
                            sb3.append(fileRemotePath);
                            if (fileData.getFileReceiveCachePath().length() == 0 || new File(fileData.getFileReceiveCachePath()).isDirectory()) {
                                String absolutePath = new File(str2, fileData.getFileName()).getAbsolutePath();
                                Intrinsics.f(absolutePath, "File(root, it.fileName).absolutePath");
                                fileData.setFileReceiveCachePath(absolutePath);
                            }
                        }
                        ry.a.f75766a.a((List) transferResponse.getData());
                        function2.invoke((List<FileData>) transferResponse.getData(), null);
                    } else {
                        function2.invoke(null, null);
                    }
                    Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    Result.m163constructorimpl(ResultKt.a(th2));
                }
            }
        });
    }

    public final void e0(Function0<Unit> function0) {
        V().v(f58969t.a(b0("/client/notifyClientClose"), this.f58976b, this.f58977c), new b(function0));
    }

    @Override // com.transsion.transfer.impl.a
    public void f(FileData fileData) {
        Intrinsics.g(fileData, "fileData");
        Y().t(fileData);
    }

    public final void f0(String str, int i11) {
        AsyncHttpClient asyncHttpClientV = V();
        i iVarB = f58969t.b(b0("/client/notifyFileTaskError"), this.f58976b, this.f58977c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(str, Integer.valueOf(i11)));
        iVarB.w(new gy.f(Z().toJson(arrayList)));
        asyncHttpClientV.v(iVarB, new d());
    }

    @Override // com.transsion.transfer.impl.a
    public void g(com.transsion.transfer.impl.b listener) {
        Intrinsics.g(listener, "listener");
        this.f58992r.remove(listener);
    }

    public final void g0(List<String> list) {
        if (list.isEmpty()) {
            return;
        }
        AsyncHttpClient asyncHttpClientV = V();
        i iVarB = f58969t.b(b0("/client/notifyFileTaskFinish"), this.f58976b, this.f58977c);
        iVarB.w(new gy.f(Z().toJson(list)));
        asyncHttpClientV.v(iVarB, new e(list));
    }

    @Override // com.transsion.transfer.impl.a
    public boolean h() {
        d0 d0Var = this.f58982h;
        return d0Var != null && d0Var.isOpen();
    }

    @Override // com.transsion.transfer.impl.a
    public void i(String root, List<FileData> files, Function1<? super List<String>, Unit> notifyFileListener) {
        Intrinsics.g(root, "root");
        Intrinsics.g(files, "files");
        Intrinsics.g(notifyFileListener, "notifyFileListener");
        ArrayList arrayList = new ArrayList();
        W().e(files);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : files) {
            FileData fileData = (FileData) obj;
            boolean zVerifyFile = fileData.verifyFile();
            if (zVerifyFile) {
                this.f58993s.R(fileData.getFileRemotePath(), TaskState.FINISH, fileData.getFileSize(), fileData.getFileSize(), -1L, null);
                arrayList.add(fileData.getFileRemotePath());
            }
            if (!zVerifyFile) {
                arrayList2.add(obj);
            }
        }
        List<FileData> listM0 = CollectionsKt___CollectionsKt.M0(arrayList2);
        notifyFileListener.invoke(CollectionsKt___CollectionsKt.M0(arrayList));
        g0(arrayList);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("transferFiles: ");
        sb2.append(listM0);
        Y().p(listM0);
    }

    @Override // com.transsion.transfer.impl.a
    public String j() {
        return this.f58987m;
    }

    @Override // com.transsion.transfer.impl.a
    public void k(com.transsion.transfer.impl.b listener) {
        Intrinsics.g(listener, "listener");
        this.f58992r.remove(listener);
        this.f58992r.add(listener);
    }
}
