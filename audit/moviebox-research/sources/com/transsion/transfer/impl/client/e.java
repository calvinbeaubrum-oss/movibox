package com.transsion.transfer.impl.client;

import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.transsion.transfer.androidasync.future.f;
import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.androidasync.http.k;
import com.transsion.transfer.impl.TaskState;
import com.transsion.transfer.impl.entity.FileData;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.h;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.IntRange;

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
public final class e {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final a f59021r = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncHttpClient f59022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.transsion.transfer.impl.b f59026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function2<List<String>, Boolean, Unit> f59027f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f59028g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f<File> f59029h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f59030i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final List<FileData> f59031j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<FileData> f59032k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final List<FileData> f59033l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final List<FileData> f59034m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Integer> f59035n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f59036o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Long f59037p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final c f59038q;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends AsyncHttpClient.g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FileData f59040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f59041c;

        public b(FileData fileData, long j11) {
            this.f59040b = fileData;
            this.f59041c = j11;
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, hy.b
        public void a(k kVar, long j11, long j12) {
            if (e.this.f59028g && kVar != null) {
                kVar.close();
            }
            super.a(kVar, j11, j12);
            if (System.currentTimeMillis() - e.this.f59030i < AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) {
                return;
            }
            e.this.f59030i = System.currentTimeMillis();
            com.transsion.transfer.impl.b bVar = e.this.f59026e;
            String fileRemotePath = this.f59040b.getFileRemotePath();
            long j13 = this.f59041c;
            bVar.L(fileRemotePath, j11 + j13, j12 + j13);
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, hy.b
        public void b(k kVar) {
            e.this.f59026e.R(this.f59040b.getFileRemotePath(), TaskState.TRANSFERRING, this.f59041c, this.f59040b.getFileSize(), 0L, null);
        }

        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, File file) throws UnsupportedEncodingException {
            e.this.f59036o = false;
            e.this.f59038q.a(this.f59040b, kVar != null ? Integer.valueOf(kVar.b()) : null, exc);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class c implements Function3<FileData, Integer, Exception, Unit> {
        public c() {
        }

        /* JADX WARN: Code duplicated, block: B:35:0x017c  */
        /* JADX WARN: Code duplicated, block: B:38:0x018e  */
        /* JADX WARN: Code duplicated, block: B:44:0x01a9  */
        /* JADX WARN: Code duplicated, block: B:51:0x01d0  */
        /* JADX WARN: Code duplicated, block: B:54:0x01e6  */
        /* JADX WARN: Code duplicated, block: B:55:0x01eb  */
        /* JADX WARN: Code duplicated, block: B:58:0x020a  */
        /* JADX WARN: Code duplicated, block: B:60:0x020f  */
        /* JADX WARN: Code duplicated, block: B:68:0x01a4 A[SYNTHETIC] */
        public void a(FileData data, Integer num, Exception exc) throws UnsupportedEncodingException {
            Iterator it;
            Object next;
            FileData fileData;
            TaskState taskState;
            String message;
            Intrinsics.g(data, "data");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Long l11 = e.this.f59037p;
            long jLongValue = jCurrentTimeMillis - (l11 != null ? l11.longValue() : 0L);
            Object obj = null;
            e.this.f59037p = null;
            if (exc == null) {
                IntRange intRange = new IntRange(200, 299);
                if (num == null || !intRange.v(num.intValue())) {
                    it = e.this.f59032k.iterator();
                    do {
                        if (it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), data.getFileRemotePath()));
                    fileData = (FileData) next;
                    if (fileData != null) {
                        e eVar = e.this;
                        eVar.f59032k.remove(fileData);
                        eVar.f59033l.add(fileData);
                        com.transsion.transfer.impl.b bVar = eVar.f59026e;
                        String fileRemotePath = fileData.getFileRemotePath();
                        if (num == null && num.intValue() == 404) {
                            taskState = TaskState.NO_FILE;
                        } else {
                            taskState = TaskState.ERROR;
                        }
                        TaskState taskState2 = taskState;
                        long length = new File(fileData.getFileReceiveCachePath()).length();
                        long fileSize = fileData.getFileSize();
                        if (exc != null) {
                            message = exc.getMessage();
                        } else {
                            message = null;
                        }
                        bVar.R(fileRemotePath, taskState2, length, fileSize, jLongValue, "errorCode:" + num + ", errorMsg:" + message);
                    }
                    if (exc != null) {
                        exc.printStackTrace();
                    }
                    String message2 = exc != null ? exc.getMessage() : null;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("invoke: send file error:");
                    sb2.append(message2);
                    sb2.append(", skip it and send next");
                } else {
                    for (Object obj2 : e.this.f59032k) {
                        if (Intrinsics.b(((FileData) obj2).getFileRemotePath(), data.getFileRemotePath())) {
                            obj = obj2;
                            break;
                        }
                    }
                    FileData fileData2 = (FileData) obj;
                    if (fileData2 != null) {
                        File finalFile = fileData2.getFinalFile();
                        e.this.f59032k.remove(fileData2);
                        if (fileData2.verifyFile()) {
                            oy.c cVar = new oy.c(fileData2);
                            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
                            String name = oy.c.class.getName();
                            Intrinsics.f(name, "T::class.java.name");
                            flowEventBus.postEvent(name, cVar, 0L);
                            e.this.f59034m.add(fileData2);
                            e.this.f59026e.R(fileData2.getFileRemotePath(), TaskState.FINISH, finalFile.length(), fileData2.getFileSize(), jLongValue, null);
                            Function2 function2 = e.this.f59027f;
                            List list = e.this.f59034m;
                            ArrayList arrayList = new ArrayList(h.v(list, 10));
                            Iterator it2 = list.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(((FileData) it2.next()).getFileRemotePath());
                            }
                            function2.invoke(CollectionsKt___CollectionsKt.M0(arrayList), Boolean.valueOf(e.this.f59031j.isEmpty()));
                        } else {
                            Integer num2 = (Integer) e.this.f59035n.get(fileData2.getFileRemotePath());
                            int iIntValue = num2 != null ? num2.intValue() : 0;
                            if (iIntValue > 1) {
                                e.this.f59026e.R(fileData2.getFileRemotePath(), TaskState.ERROR, fileData2.getDownloadedSize(), fileData2.getFileSize(), jLongValue, "verify file failed");
                                long fileSize2 = fileData2.getFileSize();
                                long length2 = finalFile.length();
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("invoke: verify file fail，fileSize:");
                                sb3.append(fileSize2);
                                sb3.append(", saveFile.size:");
                                sb3.append(length2);
                                sb3.append(", and delete cache file ,and retry");
                                fileData2.clearFile();
                            } else {
                                e.this.f59035n.put(fileData2.getFileRemotePath(), Integer.valueOf(iIntValue + 1));
                                e.this.f59032k.add(fileData2);
                            }
                        }
                    }
                }
            } else {
                it = e.this.f59032k.iterator();
                do {
                    if (it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), data.getFileRemotePath()));
                fileData = (FileData) next;
                if (fileData != null) {
                    e eVar2 = e.this;
                    eVar2.f59032k.remove(fileData);
                    eVar2.f59033l.add(fileData);
                    com.transsion.transfer.impl.b bVar2 = eVar2.f59026e;
                    String fileRemotePath2 = fileData.getFileRemotePath();
                    if (num == null) {
                        taskState = TaskState.ERROR;
                    } else {
                        taskState = TaskState.NO_FILE;
                    }
                    TaskState taskState3 = taskState;
                    long length3 = new File(fileData.getFileReceiveCachePath()).length();
                    long fileSize3 = fileData.getFileSize();
                    if (exc != null) {
                        message = exc.getMessage();
                    } else {
                        message = null;
                    }
                    bVar2.R(fileRemotePath2, taskState3, length3, fileSize3, jLongValue, "errorCode:" + num + ", errorMsg:" + message);
                }
                if (exc != null) {
                    exc.printStackTrace();
                }
                if (exc != null) {
                }
                StringBuilder sb4 = new StringBuilder();
                sb4.append("invoke: send file error:");
                sb4.append(message2);
                sb4.append(", skip it and send next");
            }
            e.this.r();
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(FileData fileData, Integer num, Exception exc) throws UnsupportedEncodingException {
            a(fileData, num, exc);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(AsyncHttpClient httpClient, String clientIp, String transferId, String urlPath, com.transsion.transfer.impl.b listener, Function2<? super List<String>, ? super Boolean, Unit> completeListener) {
        Intrinsics.g(httpClient, "httpClient");
        Intrinsics.g(clientIp, "clientIp");
        Intrinsics.g(transferId, "transferId");
        Intrinsics.g(urlPath, "urlPath");
        Intrinsics.g(listener, "listener");
        Intrinsics.g(completeListener, "completeListener");
        this.f59022a = httpClient;
        this.f59023b = clientIp;
        this.f59024c = transferId;
        this.f59025d = urlPath;
        this.f59026e = listener;
        this.f59027f = completeListener;
        this.f59031j = new ArrayList();
        this.f59032k = new ArrayList();
        this.f59033l = new ArrayList();
        this.f59034m = new ArrayList();
        this.f59035n = new LinkedHashMap();
        this.f59037p = 0L;
        this.f59038q = new c();
    }

    public final void p(List<FileData> files) {
        Object obj;
        Object next;
        Intrinsics.g(files, "files");
        this.f59028g = false;
        ArrayList arrayList = new ArrayList();
        List<FileData> list = files;
        for (FileData fileData : list) {
            Iterator<T> it = this.f59032k.iterator();
            do {
                obj = null;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(fileData.getFileRemotePath(), ((FileData) next).getFileRemotePath()));
            if (next == null) {
                for (Object obj2 : this.f59031j) {
                    if (Intrinsics.b(fileData.getFileRemotePath(), ((FileData) obj2).getFileRemotePath())) {
                        obj = obj2;
                        break;
                    }
                }
                if (obj != null) {
                }
            }
            arrayList.add(fileData);
        }
        if (!arrayList.isEmpty()) {
            files.removeAll(arrayList);
        }
        List<FileData> list2 = this.f59031j;
        LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(r.e(h.v(list2, 10)), 16));
        for (Object obj3 : list2) {
            linkedHashMap.put(((FileData) obj3).getFileRemotePath(), obj3);
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.ranges.a.d(r.e(h.v(list, 10)), 16));
        for (Object obj4 : list) {
            linkedHashMap2.put(((FileData) obj4).getFileRemotePath(), obj4);
        }
        List listJ0 = CollectionsKt___CollectionsKt.J0(s.n(linkedHashMap, linkedHashMap2).values());
        this.f59031j.clear();
        this.f59031j.addAll(listJ0);
        r();
    }

    public final void q() {
        f<File> fVar = this.f59029h;
        if (fVar != null) {
            fVar.cancel(true);
        }
        this.f59028g = true;
        this.f59032k.clear();
        this.f59031j.clear();
        this.f59034m.clear();
        this.f59033l.clear();
        this.f59035n.clear();
    }

    public final void r() throws UnsupportedEncodingException {
        if (this.f59028g) {
            return;
        }
        if (this.f59032k.isEmpty() && (!this.f59031j.isEmpty())) {
            this.f59032k.add((FileData) kotlin.collections.k.H(this.f59031j));
        }
        if (!(!this.f59032k.isEmpty()) || this.f59036o) {
            return;
        }
        s(this.f59032k.get(0));
    }

    public final void s(FileData fileData) throws UnsupportedEncodingException {
        File parentFile = new File(fileData.getFileReceiveCachePath()).getParentFile();
        if ((parentFile != null ? parentFile.getFreeSpace() : 0L) < fileData.getFileSize()) {
            this.f59026e.R(fileData.getFileRemotePath(), TaskState.SPACE_LIMIT, 0L, fileData.getFileSize(), 0L, null);
            this.f59032k.remove(fileData);
            r();
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("receiveFile:start:");
        sb2.append(fileData);
        sb2.append(" ");
        this.f59036o = true;
        FileData.a aVar = FileData.Companion;
        TaskState taskState = TaskState.CONNECTING;
        fileData.setState(aVar.a(taskState));
        fileData.filePrepare();
        File tempFile = fileData.getTempFile();
        File tempBackFile = tempFile.exists() ? fileData.getTempBackFile() : tempFile;
        long length = tempFile.exists() ? tempFile.length() : 0L;
        this.f59037p = Long.valueOf(System.currentTimeMillis());
        this.f59026e.R(fileData.getFileRemotePath(), taskState, length, fileData.getFileSize(), 0L, null);
        AsyncHttpClient asyncHttpClient = this.f59022a;
        com.transsion.transfer.androidasync.http.h hVarA = TransferClient.f58969t.a(this.f59025d + "/client/fetchFile?file=" + oy.a.b(fileData.getFileRemotePath()), this.f59023b, this.f59024c);
        StringBuilder sb3 = new StringBuilder();
        sb3.append("transferFile: bytes=");
        sb3.append(length);
        sb3.append("-");
        StringBuilder sb4 = new StringBuilder();
        sb4.append("transferFile: fileData=");
        sb4.append(fileData);
        hVarA.h().a("Range", "bytes=" + length + "-");
        Unit unit = Unit.f68710a;
        this.f59029h = asyncHttpClient.t(hVarA, tempBackFile.getAbsolutePath(), new b(fileData, length));
    }

    public final void t(FileData fileData) {
        if (fileData != null) {
            if (!this.f59032k.contains(fileData)) {
                this.f59031j.remove(fileData);
            }
            this.f59032k.remove(fileData);
            this.f59032k.add(0, fileData);
        }
        r();
    }
}
