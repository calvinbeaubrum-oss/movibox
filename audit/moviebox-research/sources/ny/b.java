package ny;

import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.entity.FileData;
import com.transsion.transfer.impl.server.TransferController;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
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
public final class b implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f72217c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72218d = "Transfer-" + b.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.transfer.impl.c f72219a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.impl.e f72220b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f72218d;
        }
    }

    public b(com.transsion.transfer.impl.c fileHandler, com.transsion.transfer.impl.e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f72219a = fileHandler;
        this.f72220b = listener;
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
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
        List<FileData> listD = ry.b.f75768a.d();
        String strA = aVar.a(0, "", listD);
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            String fileRemotePath = ((FileData) it.next()).getFileRemotePath();
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onRequest: ");
            sb2.append(fileRemotePath);
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("createResponseJsonObj: ");
        sb3.append(strA);
        if (dVar != null) {
            dVar.send(strA);
        }
        this.f72220b.y(third, listD);
    }
}
