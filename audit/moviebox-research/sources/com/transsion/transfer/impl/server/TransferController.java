package com.transsion.transfer.impl.server;

import com.google.gson.Gson;
import com.hisavana.common.tracking.TrackingKey;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.e;
import com.transsion.transfer.impl.server.service.NotifyFileErrorService;
import com.transsion.transfer.impl.server.service.NotifyFileFinishService;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ny.d;

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
public final class TransferController {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59065d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f59066e = TransferController.class.getName();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<Gson> f59067f = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: com.transsion.transfer.impl.server.TransferController$Companion$gson$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Gson invoke() {
            return new Gson();
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.transfer.impl.c f59068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f59069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59070c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T> String a(int i11, String errorMsg, T t11) {
            Intrinsics.g(errorMsg, "errorMsg");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(TrackingKey.CODE, Integer.valueOf(i11));
            linkedHashMap.put("errorMsg", errorMsg);
            if (t11 == null) {
                linkedHashMap.put("data", "");
            } else {
                linkedHashMap.put("data", t11);
            }
            String res = b().toJson(linkedHashMap);
            Intrinsics.f(res, "res");
            return res;
        }

        public final Gson b() {
            return (Gson) TransferController.f59067f.getValue();
        }

        public final Triple<String, Integer, String> c(Headers headers) {
            String strC;
            String strC2 = headers != null ? headers.c("transferId") : null;
            if (strC2 == null) {
                strC2 = "";
            }
            int i11 = (headers == null || (strC = headers.c("transferProtocolVersion")) == null) ? 1 : Integer.parseInt(strC);
            String strC3 = headers != null ? headers.c("clientIp") : null;
            return new Triple<>(strC2, Integer.valueOf(i11), strC3 != null ? strC3 : "");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f59071d = new a(null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f59072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f59073b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r f59074c;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        public static final class a {
            public a() {
            }

            public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public b(String method, String path, r requestCallback) {
            Intrinsics.g(method, "method");
            Intrinsics.g(path, "path");
            Intrinsics.g(requestCallback, "requestCallback");
            this.f59072a = method;
            this.f59073b = path;
            this.f59074c = requestCallback;
        }

        public final String a() {
            return this.f59072a;
        }

        public final String b() {
            return this.f59073b;
        }

        public final r c() {
            return this.f59074c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.b(this.f59072a, bVar.f59072a) && Intrinsics.b(this.f59073b, bVar.f59073b) && Intrinsics.b(this.f59074c, bVar.f59074c);
        }

        public int hashCode() {
            return (((this.f59072a.hashCode() * 31) + this.f59073b.hashCode()) * 31) + this.f59074c.hashCode();
        }

        public String toString() {
            return "Service(method=" + this.f59072a + ", path=" + this.f59073b + ", requestCallback=" + this.f59074c + ")";
        }
    }

    public TransferController(com.transsion.transfer.impl.c fileHandler, e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f59068a = fileHandler;
        this.f59069b = listener;
        this.f59070c = LazyKt__LazyJVMKt.b(new Function0<List<b>>() { // from class: com.transsion.transfer.impl.server.TransferController$serverDispatcher$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<TransferController.b> invoke() {
                ArrayList arrayList = new ArrayList();
                TransferController transferController = this.this$0;
                arrayList.add(new TransferController.b("get", "/client/getTransferFilesList", new ny.b(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("get", "/client/fetchFile*", new ny.a(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("get", "/client/notifyServerCreate", new d(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("get", "/client/notifyClientClose", new ny.c(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("get", "/client/notifyServerSendComplete", new ny.e(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("post", "/client/notifyFileTaskFinish", new NotifyFileFinishService(transferController.f59068a, transferController.f59069b)));
                arrayList.add(new TransferController.b("post", "/client/notifyFileTaskError", new NotifyFileErrorService(transferController.f59068a, transferController.f59069b)));
                return arrayList;
            }
        });
    }

    public final List<b> d() {
        return (List) this.f59070c.getValue();
    }

    public final List<b> e() {
        return d();
    }
}
