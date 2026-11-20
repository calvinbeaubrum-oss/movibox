package ny;

import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.transfer.androidasync.http.Headers;
import com.transsion.transfer.androidasync.http.Multimap;
import com.transsion.transfer.androidasync.http.server.MalformedRangeException;
import com.transsion.transfer.androidasync.http.server.r;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.server.TransferController;
import java.io.File;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;

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
public final class a implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0773a f72207c = new C0773a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f72208d = "Transfer-" + a.class.getName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.transfer.impl.c f72209a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.transsion.transfer.impl.e f72210b;

    /* JADX INFO: renamed from: ny.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0773a {
        public C0773a() {
        }

        public /* synthetic */ C0773a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return a.f72208d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements fy.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f72212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f72213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f72214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ long f72215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Ref.LongRef f72216f;

        public b(String str, String str2, Ref.LongRef longRef, long j11, Ref.LongRef longRef2) {
            this.f72212b = str;
            this.f72213c = str2;
            this.f72214d = longRef;
            this.f72215e = j11;
            this.f72216f = longRef2;
        }

        @Override // fy.e
        public void a(long j11, long j12) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            Ref.LongRef longRef = this.f72216f;
            if (jCurrentTimeMillis - longRef.element < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                return;
            }
            longRef.element = System.currentTimeMillis();
            com.transsion.transfer.impl.e eVar = a.this.f72210b;
            String str = this.f72212b;
            String str2 = this.f72213c;
            long j13 = this.f72214d.element;
            eVar.i(str, str2, j11 + j13, j12 + j13);
        }

        @Override // fy.e
        public void b(Exception exc) {
            a.f72207c.a();
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("transfer file onComplete: ");
            sb2.append(message);
            com.transsion.transfer.impl.e eVar = a.this.f72210b;
            String str = this.f72212b;
            String str2 = this.f72213c;
            TaskState taskState = exc == null ? TaskState.FINISH : TaskState.ERROR;
            long j11 = this.f72215e;
            eVar.U(str, str2, taskState, j11, j11);
        }
    }

    public a(com.transsion.transfer.impl.c fileHandler, com.transsion.transfer.impl.e listener) {
        Intrinsics.g(fileHandler, "fileHandler");
        Intrinsics.g(listener, "listener");
        this.f72209a = fileHandler;
        this.f72210b = listener;
    }

    @Override // com.transsion.transfer.androidasync.http.server.r
    public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        com.transsion.transfer.androidasync.http.server.d dVarD;
        Multimap multimapJ;
        String string;
        Ref.LongRef longRef = new Ref.LongRef();
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
        String strA = (bVar == null || (multimapJ = bVar.j()) == null || (string = multimapJ.getString("file")) == null) ? null : oy.a.a(string);
        File file = strA != null ? new File(strA) : null;
        long jD = d(bVar);
        long jLongValue = (file != null ? Long.valueOf(file.length()) : Integer.valueOf(Api.BaseClientBuilder.API_PRIORITY_OTHER)).longValue();
        Ref.LongRef longRef2 = new Ref.LongRef();
        longRef2.element = jD;
        if (file != null && file.exists()) {
            if (dVar != null) {
                dVar.z(file, new b(third, strA, longRef2, jLongValue, longRef));
                return;
            }
            return;
        }
        if (strA != null) {
            this.f72210b.U(third, strA, TaskState.NO_FILE, 0L, jLongValue);
        }
        String strA2 = aVar.a(-1, "File not found," + strA, "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("createResponseJsonObj: ");
        sb2.append(strA2);
        if (dVar == null || (dVarD = dVar.d(404)) == null) {
            return;
        }
        dVarD.send(strA2);
    }

    public final long d(com.transsion.transfer.androidasync.http.server.b bVar) {
        List listL;
        List listL2;
        Headers headers;
        String strC = (bVar == null || (headers = bVar.getHeaders()) == null) ? null : headers.c("Range");
        if (strC == null) {
            strC = "";
        }
        if (strC.length() <= 0) {
            return 0L;
        }
        List<String> listSplit = new Regex("=").split(strC, 0);
        if (!listSplit.isEmpty()) {
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
        } else {
            listL = g.l();
            break;
        }
        String[] strArr = (String[]) listL.toArray(new String[0]);
        if (strArr.length != 2 || !Intrinsics.b("bytes", strArr[0])) {
            return 0L;
        }
        List<String> listSplit2 = new Regex("-").split(strArr[1], 0);
        if (!listSplit2.isEmpty()) {
            ListIterator<String> listIterator2 = listSplit2.listIterator(listSplit2.size());
            while (true) {
                if (!listIterator2.hasPrevious()) {
                    listL2 = g.l();
                    break;
                }
                if (listIterator2.previous().length() != 0) {
                    listL2 = CollectionsKt___CollectionsKt.F0(listSplit2, listIterator2.nextIndex() + 1);
                    break;
                }
            }
        } else {
            listL2 = g.l();
            break;
        }
        String[] strArr2 = (String[]) listL2.toArray(new String[0]);
        try {
            if (strArr2.length > 2) {
                throw new MalformedRangeException();
            }
            if (TextUtils.isEmpty(strArr2[0])) {
                return 0L;
            }
            return Long.parseLong(strArr2[0]);
        } catch (Exception unused) {
            return 0L;
        }
    }
}
