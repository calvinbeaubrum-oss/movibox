package com.transsion.transfer.impl.server.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.transsion.transfer.androidasync.http.server.b;
import com.transsion.transfer.androidasync.http.server.d;
import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.c;
import com.transsion.transfer.impl.e;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.server.TransferController;
import gy.f;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
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
public final class NotifyFileErrorService implements r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f59105d = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f59106e = "Transfer-" + NotifyFileErrorService.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f59107a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f59108b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f59109c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public NotifyFileErrorService(c fileHandler, e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f59107a = fileHandler;
        this.f59108b = listener;
        this.f59109c = LazyKt__LazyJVMKt.b(new Function0<Gson>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileErrorService$gson$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Gson invoke() {
                return new Gson();
            }
        });
    }

    public final Gson a() {
        return (Gson) this.f59109c.getValue();
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
            List<Pair> data = (List) a().fromJson(fVar != null ? fVar.a() : null, new TypeToken<List<Pair<? extends String, ? extends Integer>>>() { // from class: com.transsion.transfer.impl.server.service.NotifyFileErrorService$onRequest$data$1
            }.getType());
            Intrinsics.f(data, "data");
            for (Pair pair : data) {
                this.f59108b.U(third, (String) pair.getFirst(), FileData.Companion.b(((Number) pair.getSecond()).intValue()), 0L, 0L);
            }
            String strA = TransferController.f59065d.a(0, "notify File Task change", "");
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
