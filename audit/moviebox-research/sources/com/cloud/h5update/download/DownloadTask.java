package com.cloud.h5update.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.cloud.h5update.TH5Update;
import com.cloud.h5update.bean.DownloadEntity;
import com.cloud.h5update.utils.h;
import com.cloud.h5update.utils.l;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import po.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class DownloadTask implements Runnable {
    private final DownloadEntity downloadEntity;
    private final Handler handler = new a(Looper.getMainLooper());
    private OkHttpClient mClient;
    private l9.a mListener;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            Intrinsics.g(msg, "msg");
            switch (msg.what) {
                case 1:
                    l9.a aVar = DownloadTask.this.mListener;
                    if (aVar != null) {
                        aVar.c(DownloadTask.this);
                    }
                    break;
                case 2:
                    l9.a aVar2 = DownloadTask.this.mListener;
                    if (aVar2 != null) {
                        aVar2.b(DownloadTask.this);
                    }
                    break;
                case 3:
                    l9.a aVar3 = DownloadTask.this.mListener;
                    if (aVar3 != null) {
                        aVar3.a(DownloadTask.this);
                    }
                    break;
                case 4:
                    l9.a aVar4 = DownloadTask.this.mListener;
                    if (aVar4 != null) {
                        aVar4.d(DownloadTask.this, 4);
                    }
                    break;
                case 5:
                    l9.a aVar5 = DownloadTask.this.mListener;
                    if (aVar5 != null) {
                        aVar5.d(DownloadTask.this, 5);
                    }
                    break;
                case 6:
                    l9.a aVar6 = DownloadTask.this.mListener;
                    if (aVar6 != null) {
                        aVar6.e(DownloadTask.this);
                    }
                    break;
            }
        }
    }

    public DownloadTask(DownloadEntity downloadEntity) {
        this.downloadEntity = downloadEntity;
    }

    public final void cancel() {
        DownloadEntity downloadEntity = this.downloadEntity;
        if (downloadEntity != null) {
            downloadEntity.setTaskStatus(3);
        }
        l lVar = l.f28923a;
        DownloadEntity downloadEntity2 = this.downloadEntity;
        lVar.c(downloadEntity2 != null ? downloadEntity2.getTaskId() : null);
        this.handler.sendEmptyMessage(3);
    }

    public final DownloadEntity getDownloadEntity() {
        return this.downloadEntity;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        RandomAccessFile randomAccessFile;
        InputStream inputStreamByteStream;
        String fileName;
        String strF;
        int i11 = 3;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                DownloadEntity downloadEntity = this.downloadEntity;
                if (TextUtils.isEmpty(downloadEntity != null ? downloadEntity.getFileName() : null)) {
                    l lVar = l.f28923a;
                    DownloadEntity downloadEntity2 = this.downloadEntity;
                    String url = downloadEntity2 != null ? downloadEntity2.getUrl() : null;
                    Intrinsics.d(url);
                    fileName = lVar.k(url);
                } else {
                    DownloadEntity downloadEntity3 = this.downloadEntity;
                    fileName = downloadEntity3 != null ? downloadEntity3.getFileName() : null;
                    Intrinsics.d(fileName);
                }
                TH5Update.a aVar = TH5Update.f28868c;
                if (aVar.g()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(aVar.f());
                    sb2.append(File.separator);
                    DownloadEntity downloadEntity4 = this.downloadEntity;
                    sb2.append(downloadEntity4 != null ? downloadEntity4.getTitle() : null);
                    strF = sb2.toString();
                } else {
                    strF = aVar.f();
                }
                if (!TextUtils.isEmpty(this.downloadEntity.getFilePath())) {
                    strF = this.downloadEntity.getFilePath();
                    Intrinsics.d(strF);
                }
                this.downloadEntity.setFileName(fileName);
                this.downloadEntity.setFilePath(strF);
                File file = new File(strF);
                if (!file.exists()) {
                    file.mkdirs();
                }
                l lVar2 = l.f28923a;
                DownloadEntity downloadEntityH = lVar2.h(this.downloadEntity.getTaskId());
                File file2 = new File(strF, fileName);
                if (downloadEntityH == null && file2.exists() && !file2.delete()) {
                    b.f73956a.b("failed to delete file:" + file2.getAbsolutePath());
                }
                randomAccessFile = new RandomAccessFile(file2, "rwd");
                try {
                    try {
                        this.downloadEntity.setTaskStatus(1);
                        this.handler.sendEmptyMessage(1);
                        if (downloadEntityH != null) {
                            lVar2.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                        }
                        long completedSize = this.downloadEntity.getCompletedSize();
                        try {
                            String url2 = this.downloadEntity.getUrl();
                            if (url2 != null && !kotlin.text.l.y(url2)) {
                                Request.Builder builder = new Request.Builder();
                                String url3 = this.downloadEntity.getUrl();
                                Intrinsics.d(url3);
                                Request requestBuild = builder.url(url3).header("RANGE", "bytes=" + completedSize + '-').build();
                                Intrinsics.f(requestBuild, "Builder().url(downloadEn…=$completeSize-\").build()");
                                if (randomAccessFile.length() == 0) {
                                    completedSize = 0;
                                }
                                randomAccessFile.seek(completedSize);
                                OkHttpClient okHttpClient = this.mClient;
                                Intrinsics.d(okHttpClient);
                                Response responseExecute = FirebasePerfOkHttpClient.execute(okHttpClient.newCall(requestBuild));
                                if (responseExecute.isSuccessful()) {
                                    ResponseBody responseBodyBody = responseExecute.body();
                                    if (responseBodyBody != null) {
                                        if (lVar2.h(this.downloadEntity.getTaskId()) == null) {
                                            lVar2.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                            this.downloadEntity.setTotalSize(responseBodyBody.contentLength());
                                        }
                                        this.downloadEntity.setTaskStatus(2);
                                        double totalSize = this.downloadEntity.getTotalSize() / ((long) 100);
                                        inputStreamByteStream = responseBodyBody.byteStream();
                                        try {
                                            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(inputStreamByteStream);
                                            try {
                                                byte[] bArr = new byte[1024];
                                                int i12 = 0;
                                                while (true) {
                                                    int i13 = bufferedInputStream2.read(bArr);
                                                    Unit unit = Unit.f68710a;
                                                    if (i13 <= 0 || this.downloadEntity.getTaskStatus() == i11) {
                                                        break;
                                                    }
                                                    randomAccessFile.write(bArr, 0, i13);
                                                    completedSize += (long) i13;
                                                    i12 += i13;
                                                    this.downloadEntity.setCompletedSize(completedSize);
                                                    if (i12 >= totalSize) {
                                                        l.f28923a.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                                        this.handler.sendEmptyMessage(2);
                                                        i12 = 0;
                                                    }
                                                    if (completedSize == this.downloadEntity.getTotalSize()) {
                                                        this.handler.sendEmptyMessage(2);
                                                        this.downloadEntity.setTaskStatus(6);
                                                        this.handler.sendEmptyMessage(6);
                                                        l.f28923a.t(this.downloadEntity.getTaskId(), this.downloadEntity);
                                                    }
                                                    i11 = 3;
                                                }
                                                bufferedInputStream = bufferedInputStream2;
                                            } catch (FileNotFoundException unused) {
                                                bufferedInputStream = bufferedInputStream2;
                                                DownloadEntity downloadEntity5 = this.downloadEntity;
                                                if (downloadEntity5 != null) {
                                                    downloadEntity5.setTaskStatus(5);
                                                }
                                                this.handler.sendEmptyMessage(5);
                                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                                return;
                                            } catch (ConnectException unused2) {
                                                bufferedInputStream = bufferedInputStream2;
                                                DownloadEntity downloadEntity6 = this.downloadEntity;
                                                if (downloadEntity6 != null) {
                                                    downloadEntity6.setTaskStatus(4);
                                                }
                                                this.handler.sendEmptyMessage(4);
                                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                                return;
                                            } catch (SocketTimeoutException unused3) {
                                                bufferedInputStream = bufferedInputStream2;
                                                DownloadEntity downloadEntity7 = this.downloadEntity;
                                                if (downloadEntity7 != null) {
                                                    downloadEntity7.setTaskStatus(4);
                                                }
                                                this.handler.sendEmptyMessage(4);
                                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                                return;
                                            } catch (IOException e11) {
                                                e = e11;
                                                bufferedInputStream = bufferedInputStream2;
                                                e.printStackTrace();
                                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                                return;
                                            } catch (Throwable th2) {
                                                th = th2;
                                                bufferedInputStream = bufferedInputStream2;
                                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                                throw th;
                                            }
                                        } catch (FileNotFoundException unused4) {
                                        } catch (ConnectException unused5) {
                                        } catch (SocketTimeoutException unused6) {
                                        } catch (IOException e12) {
                                            e = e12;
                                        }
                                    }
                                    h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                    return;
                                }
                                this.downloadEntity.setTaskStatus(4);
                                this.handler.sendEmptyMessage(4);
                                inputStreamByteStream = null;
                                h.f28910a.e(bufferedInputStream, inputStreamByteStream, randomAccessFile);
                                return;
                            }
                            h.f28910a.e(null, null, randomAccessFile);
                        } catch (Exception e13) {
                            e13.printStackTrace();
                            this.downloadEntity.setTaskStatus(4);
                            this.handler.sendEmptyMessage(4);
                            Intrinsics.d(e13.getMessage());
                            h.f28910a.e(null, null, randomAccessFile);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        inputStreamByteStream = null;
                    }
                } catch (FileNotFoundException unused7) {
                    inputStreamByteStream = null;
                } catch (ConnectException unused8) {
                    inputStreamByteStream = null;
                } catch (SocketTimeoutException unused9) {
                    inputStreamByteStream = null;
                } catch (IOException e14) {
                    e = e14;
                    inputStreamByteStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (FileNotFoundException unused10) {
            randomAccessFile = null;
            inputStreamByteStream = null;
        } catch (ConnectException unused11) {
            randomAccessFile = null;
            inputStreamByteStream = null;
        } catch (SocketTimeoutException unused12) {
            randomAccessFile = null;
            inputStreamByteStream = null;
        } catch (IOException e15) {
            e = e15;
            randomAccessFile = null;
            inputStreamByteStream = null;
        } catch (Throwable th5) {
            th = th5;
            randomAccessFile = null;
            inputStreamByteStream = null;
        }
    }

    public final void setClient(OkHttpClient okHttpClient) {
        this.mClient = okHttpClient;
    }

    public final void setListener(l9.a aVar) {
        this.mListener = aVar;
    }
}
