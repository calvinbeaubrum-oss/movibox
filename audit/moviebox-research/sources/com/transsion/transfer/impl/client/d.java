package com.transsion.transfer.impl.client;

import com.transsion.transfer.androidasync.http.AsyncHttpClient;
import com.transsion.transfer.androidasync.http.k;
import com.transsion.transfer.impl.entity.FileData;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
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
public final class d {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f59008i = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AsyncHttpClient f59009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f59010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f59011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f59012d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.transsion.transfer.impl.b f59013e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<FileData> f59014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<FileData> f59015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f59016h;

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
        public final /* synthetic */ File f59018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ File f59019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FileData f59020d;

        public b(File file, File file2, FileData fileData) {
            this.f59018b = file;
            this.f59019c = file2;
            this.f59020d = fileData;
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, hy.b
        public void a(k kVar, long j11, long j12) {
            super.a(kVar, j11, j12);
        }

        @Override // com.transsion.transfer.androidasync.http.AsyncHttpClient.i, hy.b
        public void b(k kVar) {
        }

        @Override // fy.g
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void c(Exception exc, k kVar, File file) throws UnsupportedEncodingException {
            Boolean boolValueOf = file != null ? Boolean.valueOf(file.exists()) : null;
            Long lValueOf = file != null ? Long.valueOf(file.length()) : null;
            String message = exc != null ? exc.getMessage() : null;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("onCompleted: exist:");
            sb2.append(boolValueOf);
            sb2.append(" , length:");
            sb2.append(lValueOf);
            sb2.append(" , e:");
            sb2.append(message);
            d.this.f59016h = false;
            if (exc == null) {
                this.f59018b.renameTo(this.f59019c);
                d.this.f59013e.z(this.f59020d.getFileRemotePath());
            }
            d.this.f59015g.remove(this.f59020d);
            d.this.f();
        }
    }

    public d(AsyncHttpClient httpClient, String clientIp, String transferId, String urlPath, com.transsion.transfer.impl.b listener) {
        Intrinsics.g(httpClient, "httpClient");
        Intrinsics.g(clientIp, "clientIp");
        Intrinsics.g(transferId, "transferId");
        Intrinsics.g(urlPath, "urlPath");
        Intrinsics.g(listener, "listener");
        this.f59009a = httpClient;
        this.f59010b = clientIp;
        this.f59011c = transferId;
        this.f59012d = urlPath;
        this.f59013e = listener;
        this.f59014f = new ArrayList();
        this.f59015g = new ArrayList();
    }

    public final synchronized void e(List<FileData> files) {
        Intrinsics.g(files, "files");
        this.f59014f.addAll(files);
        f();
    }

    public final void f() throws UnsupportedEncodingException {
        if (this.f59015g.isEmpty() && (!this.f59014f.isEmpty())) {
            this.f59015g.add((FileData) kotlin.collections.k.H(this.f59014f));
        }
        if (!(!this.f59015g.isEmpty()) || this.f59016h) {
            return;
        }
        g(this.f59015g.get(0));
    }

    public final void g(FileData fileData) throws UnsupportedEncodingException {
        File tempCoverFile = fileData.getTempCoverFile();
        File coverFile = fileData.getCoverFile();
        if (!l.L(fileData.getCoverUrl(), "/", false, 2, null) || coverFile.exists()) {
            this.f59013e.z(fileData.getFileRemotePath());
            this.f59015g.remove(fileData);
            f();
            return;
        }
        this.f59016h = true;
        String coverUrl = fileData.getCoverUrl();
        String absolutePath = tempCoverFile.getAbsolutePath();
        this.f59009a.t(TransferClient.f58969t.a(this.f59012d + "/client/fetchFile?file=" + oy.a.b(coverUrl), this.f59010b, this.f59011c), absolutePath, new b(tempCoverFile, coverFile, fileData));
    }
}
