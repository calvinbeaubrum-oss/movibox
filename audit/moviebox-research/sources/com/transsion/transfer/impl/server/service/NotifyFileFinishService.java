package com.transsion.transfer.impl.server.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.server.b;
import com.transsion.transfer.androidasync.http.server.d;
import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.c;
import com.transsion.transfer.impl.e;
import com.transsion.transfer.impl.server.TransferController;
import gy.f;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
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
public final class NotifyFileFinishService implements r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59110d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f59111e = "Transfer-" + NotifyFileFinishService.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f59112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f59113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59114c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NotifyFileFinishService(c fileHandler, e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f59112a = fileHandler;
        this.f59113b = listener;
        this.f59114c = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileFinishService$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new Gson();
            }
        });
    }

    private final Gson a() {
        return (Gson) this.f59114c.getValue();
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public void b(b bVar, d dVar) {
        try {
            TransferController.a aVar = TransferController.f59065d;
            Triple<String, Integer, String> tripleC = aVar.c(bVar != null ? bVar.getHeaders() : null);
            tripleC.getFirst();
            int iIntValue = tripleC.getSecond().intValue();
            String third = tripleC.getThird();
            if (iIntValue < 1) {
                if (dVar != null) {
                    dVar.send(aVar.a(-1, "protocol version compatible error", ""));
                    return;
                }
                return;
            }
            gy.a body = bVar == null ? null : bVar.getBody();
            f fVar = body instanceof f ? (f) body : null;
            List list = (List) a().fromJson(fVar != null ? fVar.a() : null, new TypeToken<List<String>>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileFinishService$onRequest$array$1
            }.getType());
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    File file = new File((String) it.next());
                    if (file.exists()) {
                        e eVar = this.f59113b;
                        String absolutePath = file.getAbsolutePath();
                        Intrinsics.f(absolutePath, "file.absolutePath");
                        eVar.U(third, absolutePath, TaskState.FINISH, file.length(), file.length());
                    }
                }
            }
            String strA = TransferController.f59065d.a(0, "noitfy server success", "");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("createResponseJsonObj: ");
            sb2.append(strA);
            if (dVar != null) {
                dVar.send(strA);
            }
        } catch (Exception e11) {
            if (dVar != null) {
                dVar.send(TransferController.f59065d.a(500, "server error:" + e11.getMessage(), ""));
            }
        }
    }
}
