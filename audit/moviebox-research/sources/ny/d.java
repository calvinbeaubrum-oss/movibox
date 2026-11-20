package ny;

import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.server.TransferController;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class d implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f72225c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72226d = "Transfer-" + d.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.transfer.impl.c f72227a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.impl.e f72228b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public d(com.transsion.transfer.impl.c fileHandler, com.transsion.transfer.impl.e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f72227a = fileHandler;
        this.f72228b = listener;
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
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
            this.f72228b.d(third);
            String strA = aVar.a(0, "noitfy cliente server create success", "");
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
