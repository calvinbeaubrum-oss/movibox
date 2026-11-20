package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.download.utils.Utils;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.thrid.okhttp.CacheControl;
import com.mbridge.msdk.thrid.okhttp.Call;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Request;
import com.mbridge.msdk.thrid.okhttp.Response;
import com.mbridge.msdk.thrid.okhttp.ResponseBody;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
class OkHTTPFileDownloadTask implements IDownloadTask {
    private static final String CLOSE = "close";
    private static final String CONNECTION = "Connection";
    private static final String FORMAT_RANGE = "bytes=%d-";
    private static final String RESPONSE_BODY_IS_NULL = "response body is null";
    private static final String RESPONSE_CODE = "responseCode ";
    private static final String RESPONSE_CONTENT_LENGTH_IS_NULL = "response content length is null";
    private static final String RESPONSE_INPUTSTREAM_IS_NULL = "response inputStream is null";
    private static final String RESPONSE_IS_NULL = "response is null";
    private final IDatabaseHelper _databaseHelper;
    private volatile DownloadMessage _downloadMessage;
    private DownloadModel _downloadModel;
    private final DownloadRequest _downloadRequest;
    private DownloadResponse _downloadResponse;
    private DownloaderReporter.Builder _downloaderReporter;
    private String _etag = "";
    private InputStream _inputStream;
    private DownloadFileOutputStream _outputStream;
    private ResponseBody _responseBody;

    private OkHTTPFileDownloadTask(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        this._downloadRequest = downloadRequest;
        this._downloadModel = downloadModel;
        this._databaseHelper = iDatabaseHelper;
        this._downloadMessage = downloadMessage;
        this._downloaderReporter = builder;
    }

    public static IDownloadTask create(DownloadRequest downloadRequest, DownloadModel downloadModel, IDatabaseHelper iDatabaseHelper, DownloadMessage downloadMessage, DownloaderReporter.Builder builder) {
        if (Objects.isNull(builder)) {
            builder = new DownloaderReporter.Builder(DownloadCommon.DOWNLOAD_REPORT_KEY);
        }
        return new OkHTTPFileDownloadTask(downloadRequest, downloadModel, iDatabaseHelper, downloadMessage, builder);
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0126  */
    /* JADX WARN: Code duplicated, block: B:43:0x0193 A[LOOP:0: B:28:0x011d->B:43:0x0193, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:49:0x01b1 A[Catch: all -> 0x01fb, TryCatch #2 {all -> 0x01fb, blocks: (B:46:0x01a0, B:50:0x01b8, B:52:0x01dd, B:54:0x01e3, B:49:0x01b1), top: B:66:0x01a0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x025a  */
    /* JADX WARN: Code duplicated, block: B:66:0x01a0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x018c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:0x019b A[SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v5 */
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
    private DownloadResponse handleInputStream(String str, String str2, String str3, String str4) throws IllegalAccessException, IOException {
        String md5;
        MessageDigest messageDigest;
        String str5;
        boolean z11;
        byte[] bArr;
        int i11;
        String str6;
        DownloadResponse downloadResponse;
        ?? r11;
        DownloadResponse downloadResponse2;
        String strHexEncode;
        DownloadResponse downloadResponse3;
        String str7 = IDownloadTask.TAG;
        DownloadResponse downloadResponse4 = new DownloadResponse();
        if (Objects.isNull(this._downloadModel)) {
            DownloadModel downloadModelCreate = DownloadModel.create(this._downloadRequest.getDownloadId(), this._downloadMessage.getDownloadUrl(), this._downloadMessage.getResourceUrl(), str4, str2, this._downloadMessage.getSaveFileName(), this._downloadRequest.getTotalBytes(), 0L, this._downloadMessage.getDownloadRate(), 1, this._downloadMessage.getDownloadResourceType());
            this._downloadModel = downloadModelCreate;
            this._databaseHelper.insert(downloadModelCreate);
        } else {
            DownloadModel downloadModelCreate2 = DownloadModel.create(this._downloadModel.getDownloadId(), this._downloadModel.getDownloadUrl(), this._downloadMessage.getResourceUrl(), this._downloadModel.getEtag(), this._downloadModel.getSaveDirectorPath(), this._downloadModel.getSaveFileName(), this._downloadRequest.getTotalBytes(), this._downloadModel.getDownloadedBytes(), this._downloadMessage.getDownloadRate(), this._downloadModel.getUsageCounter() + 1, this._downloadMessage.getDownloadResourceType());
            this._downloadModel = downloadModelCreate2;
            this._databaseHelper.update(downloadModelCreate2, str2);
        }
        DownloadFileOutputStream downloadFileOutputStream = MBResourceManager.getInstance().getDownloadFileOutputStream(new File(str2, str));
        this._outputStream = downloadFileOutputStream;
        downloadFileOutputStream.seek(this._downloadRequest.getDownloadedBytes());
        int i12 = 0;
        MessageDigest messageDigest2 = null;
        try {
            if (this._downloadMessage != null && this._downloadMessage.isCheckMD5() && !TextUtils.isEmpty(this._downloadMessage.getMd5())) {
                md5 = this._downloadMessage.getMd5();
                try {
                    messageDigest2 = MessageDigest.getInstance("MD5");
                    if (this._downloadMessage.getDownloadRate() == 100 && !TextUtils.isEmpty(md5)) {
                        z11 = true;
                    }
                    messageDigest = messageDigest2;
                    str5 = md5;
                    while (true) {
                        i11 = this._inputStream.read(bArr);
                        if (i11 != -1) {
                            this._outputStream.write(bArr, i12, i11);
                            DownloadRequest downloadRequest = this._downloadRequest;
                            downloadRequest.setDownloadedBytes(downloadRequest.getDownloadedBytes() + ((long) i11));
                            if (z11 && messageDigest != null) {
                                messageDigest.update(bArr);
                            }
                            this._outputStream.flushAndSync();
                            int downloadRate = Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes());
                            str6 = str7;
                            downloadResponse3 = downloadResponse4;
                            sendProgress(this._downloadRequest, this._downloadMessage, this._downloadRequest.getDownloadedBytes(), this._downloadRequest.getTotalBytes(), downloadRate);
                            if (this._downloadMessage.getDownloadRate() == 100 && downloadRate >= this._downloadMessage.getDownloadRate()) {
                                downloadResponse = downloadResponse3;
                            } else {
                                if (this._downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
                                    DownloadResponse downloadResponse5 = downloadResponse3;
                                    r11 = 1;
                                    downloadResponse5.setCancelled(true);
                                    downloadResponse2 = downloadResponse5;
                                    break;
                                }
                                str7 = str6;
                                downloadResponse4 = downloadResponse3;
                                i12 = 0;
                            }
                        } else {
                            str6 = str7;
                            downloadResponse = downloadResponse4;
                        }
                        r11 = 1;
                        downloadResponse2 = downloadResponse;
                        break;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, th.getMessage());
                    messageDigest = messageDigest2;
                    str5 = md5;
                    z11 = false;
                }
                bArr = new byte[GlobalComponent.getInstance().getByteBufferSize()];
                if (z11) {
                    try {
                        strHexEncode = SameMD5.hexEncode(messageDigest.digest());
                        String lowerCase = TextUtils.isEmpty(str5) ? "" : str5.toLowerCase(Locale.US);
                        GlobalComponent.getInstance().getLogger().log(str6, strHexEncode + " " + lowerCase);
                        if (!TextUtils.isEmpty(strHexEncode) && !strHexEncode.equals(lowerCase)) {
                            this._downloadMessage.setMd5VerifyResult(r11);
                            downloadResponse2.setFailed(r11);
                            downloadResponse2.setError(new DownloadError(new Exception("File MD5 check fail.")));
                            return downloadResponse2;
                        }
                    } catch (Throwable th3) {
                        GlobalComponent.getInstance().getLogger().log(str6, th3.getMessage());
                    }
                }
                GlobalComponent.getInstance().getDatabaseHelper().updateProgress(str3, str2, DownloadModel.create(str3, this._downloadMessage.getDownloadUrl(), this._downloadMessage.getResourceUrl(), str4, str2, this._downloadMessage.getSaveFileName(), this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes(), this._downloadMessage.getDownloadRate(), this._downloadModel.getUsageCounter(), this._downloadMessage.getDownloadResourceType()));
                if (!downloadResponse2.isCancelled()) {
                    downloadResponse2.setSuccessful(r11);
                }
                return downloadResponse2;
            }
            md5 = "";
            z11 = false;
            messageDigest = messageDigest2;
            str5 = md5;
            while (true) {
                i11 = this._inputStream.read(bArr);
                if (i11 != -1) {
                    this._outputStream.write(bArr, i12, i11);
                    DownloadRequest downloadRequest2 = this._downloadRequest;
                    downloadRequest2.setDownloadedBytes(downloadRequest2.getDownloadedBytes() + ((long) i11));
                    if (z11) {
                        messageDigest.update(bArr);
                    }
                    this._outputStream.flushAndSync();
                    int downloadRate2 = Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes());
                    str6 = str7;
                    downloadResponse3 = downloadResponse4;
                    sendProgress(this._downloadRequest, this._downloadMessage, this._downloadRequest.getDownloadedBytes(), this._downloadRequest.getTotalBytes(), downloadRate2);
                    if (this._downloadMessage.getDownloadRate() == 100) {
                    }
                    if (this._downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
                        DownloadResponse downloadResponse6 = downloadResponse3;
                        r11 = 1;
                        downloadResponse6.setCancelled(true);
                        downloadResponse2 = downloadResponse6;
                        break;
                    }
                    str7 = str6;
                    downloadResponse4 = downloadResponse3;
                    i12 = 0;
                } else {
                    str6 = str7;
                    downloadResponse = downloadResponse4;
                }
                r11 = 1;
                downloadResponse2 = downloadResponse;
                break;
            }
        } catch (Throwable th4) {
            th = th4;
            md5 = "";
        }
        bArr = new byte[GlobalComponent.getInstance().getByteBufferSize()];
        if (z11) {
            strHexEncode = SameMD5.hexEncode(messageDigest.digest());
            String lowerCase2 = TextUtils.isEmpty(str5) ? "" : str5.toLowerCase(Locale.US);
            GlobalComponent.getInstance().getLogger().log(str6, strHexEncode + " " + lowerCase2);
            if (!TextUtils.isEmpty(strHexEncode)) {
                this._downloadMessage.setMd5VerifyResult(r11);
                downloadResponse2.setFailed(r11);
                downloadResponse2.setError(new DownloadError(new Exception("File MD5 check fail.")));
                return downloadResponse2;
            }
        }
        GlobalComponent.getInstance().getDatabaseHelper().updateProgress(str3, str2, DownloadModel.create(str3, this._downloadMessage.getDownloadUrl(), this._downloadMessage.getResourceUrl(), str4, str2, this._downloadMessage.getSaveFileName(), this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes(), this._downloadMessage.getDownloadRate(), this._downloadModel.getUsageCounter(), this._downloadMessage.getDownloadResourceType()));
        if (!downloadResponse2.isCancelled()) {
            downloadResponse2.setSuccessful(r11);
        }
        return downloadResponse2;
    }

    private void handlerException(String str, String str2, String str3, Exception exc) {
        try {
            if (Objects.isNotNull(this._databaseHelper) && Objects.isNotNull(this._downloadRequest)) {
                if (!af.a().a("r_f_s_d_e", true)) {
                    this._databaseHelper.remove(str3, str2);
                    MBResourceManager.getInstance().deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
                }
                this._downloadRequest.setDownloadedBytes(0L);
                this._downloadRequest.setTotalBytes(0L);
            }
        } catch (Exception e11) {
            GlobalComponent.getInstance().getLogger().log(IDownloadTask.TAG, e11.getMessage());
        }
        this._downloadResponse.setError(exc);
    }

    private DownloadResponse handlerRequestSuccessful(String str, String str2, String str3, Response response, int i11) throws IllegalAccessException, IOException {
        DownloadResponse downloadResponse = new DownloadResponse();
        boolean z11 = !isSupportResume(i11, this._downloadModel);
        boolean z12 = (response == null || this._downloadRequest == null || i11 != 206 || response.body() == null || this._downloadRequest.getTotalBytes() <= 0 || response.body().contentLength() == this._downloadRequest.getTotalBytes() - this._downloadRequest.getDownloadedBytes()) ? false : true;
        if (z11 && z12) {
            this._downloadRequest.setDownloadedBytes(0L);
            this._downloadRequest.setTotalBytes(0L);
            if (Objects.isNotNull(this._databaseHelper)) {
                this._databaseHelper.remove(str3, str2);
            }
            this._downloadModel = null;
            MBResourceManager.getInstance().deleteFile(new File(this._downloadRequest.getCacheDirectoryPath() + this._downloadMessage.getSaveFileName()));
        }
        ResponseBody responseBodyBody = response.body();
        this._responseBody = responseBodyBody;
        if (Objects.isNull(responseBodyBody)) {
            downloadResponse.setError(new IOException(RESPONSE_BODY_IS_NULL));
            this._downloadRequest.setTotalBytes(0L);
            this._downloadRequest.setDownloadedBytes(0L);
            return downloadResponse;
        }
        long jContentLength = this._responseBody.contentLength();
        if (jContentLength <= 0) {
            downloadResponse.setError(new IOException(RESPONSE_CONTENT_LENGTH_IS_NULL));
            return downloadResponse;
        }
        if (this._downloadRequest.getTotalBytes() == 0) {
            this._downloadRequest.setTotalBytes(jContentLength);
        }
        InputStream inputStreamByteStream = this._responseBody.byteStream();
        this._inputStream = inputStreamByteStream;
        if (!Objects.isNull(inputStreamByteStream)) {
            return handleInputStream(str, str2, str3, this._etag);
        }
        downloadResponse.setError(new IOException(RESPONSE_INPUTSTREAM_IS_NULL));
        return downloadResponse;
    }

    private boolean isSupportResume(int i11, DownloadModel downloadModel) {
        return i11 == 206 && !TextUtils.isEmpty(this._etag) && (downloadModel == null || TextUtils.equals(this._etag, downloadModel.getEtag()));
    }

    private void reportDownloadMessage() {
        boolean zIsSuccessful = this._downloadResponse.isSuccessful();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_SUCCESS, Boolean.toString(zIsSuccessful));
        boolean zIsCancelled = this._downloadResponse.isCancelled();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_CANCEL, Boolean.toString(zIsCancelled));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RATE, String.valueOf(Utils.getDownloadRate(this._downloadRequest.getTotalBytes(), this._downloadRequest.getDownloadedBytes())));
        if (!zIsSuccessful && !zIsCancelled) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_REASON, this._downloadResponse.getErrorMessage());
        }
        this._downloaderReporter.build().report();
    }

    private void sendProgress(DownloadRequest downloadRequest, DownloadMessage downloadMessage, long j11, long j12, int i11) {
        if (downloadRequest.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest.handlerProcessEvent(downloadMessage, new DownloadProgress(j11, j12, i11));
        }
    }

    @Override // com.mbridge.msdk.foundation.download.core.IDownloadTask
    public DownloadResponse run() {
        this._downloadResponse = new DownloadResponse();
        if (this._downloadRequest.getStatus() == DownloadStatus.CANCELLED) {
            this._downloadResponse.setCancelled(true);
            return this._downloadResponse;
        }
        long totalBytes = this._downloadRequest.getTotalBytes();
        long downloadedBytes = this._downloadRequest.getDownloadedBytes();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_CURRENT_RATE, String.valueOf(Utils.getDownloadRate(totalBytes, downloadedBytes)));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_DOWNLOAD_BYTES, String.valueOf(downloadedBytes));
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_TOTAL_BYTES, String.valueOf(totalBytes));
        if (totalBytes != 0 && downloadedBytes != 0 && totalBytes == downloadedBytes) {
            this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR, DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_ERROR_VALUE);
            this._downloaderReporter.build().report();
            this._downloadResponse.setSuccessful(true);
            return this._downloadResponse;
        }
        String saveFileName = this._downloadMessage.getSaveFileName();
        String cacheDirectoryPath = this._downloadRequest.getCacheDirectoryPath();
        String downloadId = this._downloadRequest.getDownloadId();
        String downloadUrl = this._downloadMessage.getDownloadUrl();
        OkHttpClient.Builder builderNewBuilder = GlobalComponent.getInstance().getOkHttpClient().newBuilder();
        long connectTimeout = this._downloadRequest.getConnectTimeout();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        OkHttpClient okHttpClientBuild = builderNewBuilder.connectTimeout(connectTimeout, timeUnit).readTimeout(this._downloadRequest.getReadTimeout(), timeUnit).writeTimeout(this._downloadRequest.getWriteTimeout(), timeUnit).callTimeout(this._downloadRequest.getTimeout(), timeUnit).retryOnConnectionFailure(true).build();
        Request requestBuild = new Request.Builder().url(downloadUrl).cacheControl(new CacheControl.Builder().noCache().build()).addHeader(CONNECTION, "close").addHeader("Range", String.format(Locale.ENGLISH, FORMAT_RANGE, Long.valueOf(downloadedBytes))).removeHeader("User-Agent").addHeader("User-Agent", Command.DEFAULT_USER_AGENT).build();
        this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_HOST, requestBuild.url().host());
        this._downloaderReporter.add("url", downloadUrl);
        Call callNewCall = okHttpClientBuild.newCall(requestBuild);
        try {
            try {
                Response responseExecute = callNewCall.execute();
                if (!Objects.isNull(responseExecute) && !Objects.isNull(responseExecute.body())) {
                    int iCode = responseExecute.code();
                    this._downloaderReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RESPONSE_CODE, String.valueOf(iCode));
                    if (responseExecute.isSuccessful()) {
                        this._etag = responseExecute.header("ETag", "");
                        this._downloadResponse = handlerRequestSuccessful(saveFileName, cacheDirectoryPath, downloadId, responseExecute, iCode);
                        Objects.closeInputStream(this._inputStream);
                        Objects.closeOutputStream(this._outputStream);
                        Objects.closeResponse(responseExecute);
                        Objects.closeResponseBody(this._responseBody);
                        if (!callNewCall.isCanceled()) {
                            callNewCall.cancel();
                        }
                        reportDownloadMessage();
                        return this._downloadResponse;
                    }
                    this._downloadResponse.setError(new IOException(RESPONSE_CODE + iCode + "\n" + responseExecute.body().string()));
                    DownloadResponse downloadResponse = this._downloadResponse;
                    Objects.closeInputStream(this._inputStream);
                    Objects.closeOutputStream(this._outputStream);
                    Objects.closeResponse(responseExecute);
                    Objects.closeResponseBody(this._responseBody);
                    if (!callNewCall.isCanceled()) {
                        callNewCall.cancel();
                    }
                    reportDownloadMessage();
                    return downloadResponse;
                }
                this._downloadResponse.setError(new IOException(RESPONSE_IS_NULL));
                DownloadResponse downloadResponse2 = this._downloadResponse;
                Objects.closeInputStream(this._inputStream);
                Objects.closeOutputStream(this._outputStream);
                Objects.closeResponse(responseExecute);
                Objects.closeResponseBody(this._responseBody);
                if (!callNewCall.isCanceled()) {
                    callNewCall.cancel();
                }
                reportDownloadMessage();
                return downloadResponse2;
            } catch (Exception e11) {
                handlerException(saveFileName, cacheDirectoryPath, downloadId, e11);
                Objects.closeInputStream(this._inputStream);
                Objects.closeOutputStream(this._outputStream);
                Objects.closeResponse(null);
                Objects.closeResponseBody(this._responseBody);
                if (!callNewCall.isCanceled()) {
                }
            }
        } catch (Throwable th2) {
            Objects.closeInputStream(this._inputStream);
            Objects.closeOutputStream(this._outputStream);
            Objects.closeResponse(null);
            Objects.closeResponseBody(this._responseBody);
            if (!callNewCall.isCanceled()) {
                callNewCall.cancel();
            }
            reportDownloadMessage();
            throw th2;
        }
    }
}
