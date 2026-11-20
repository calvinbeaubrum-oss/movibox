package com.tmc.network;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class ProgressResponseBody extends ResponseBody {
    private BufferedSource bufferedSource;
    private final ProgressListener mListener;
    private final ResponseBody responseBody;

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        Intrinsics.g(responseBody, "responseBody");
        this.responseBody = responseBody;
        this.mListener = progressListener;
    }

    private final Source mySource(Source source) {
        return new ForwardingSource(source) { // from class: com.tmc.network.ProgressResponseBody.mySource.1
            final /* synthetic */ Source $source;
            private long totalBytesRead;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(source);
                this.$source = source;
            }

            public final long getTotalBytesRead() {
                return this.totalBytesRead;
            }

            @Override // okio.ForwardingSource, okio.Source
            public long read(Buffer sink, long j11) throws IOException {
                Intrinsics.g(sink, "sink");
                long j12 = super.read(sink, j11);
                this.totalBytesRead += j12 != -1 ? j12 : 0L;
                ProgressListener progressListener = ProgressResponseBody.this.mListener;
                if (progressListener != null) {
                    progressListener.onProgress(this.totalBytesRead, ProgressResponseBody.this.contentLength(), this.totalBytesRead == ProgressResponseBody.this.contentLength());
                }
                return j12;
            }

            public final void setTotalBytesRead(long j11) {
                this.totalBytesRead = j11;
            }
        };
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.responseBody.contentLength();
    }

    @Override // okhttp3.ResponseBody
    public MediaType contentType() {
        return this.responseBody.contentType();
    }

    @Override // okhttp3.ResponseBody
    public BufferedSource source() {
        if (this.bufferedSource == null) {
            this.bufferedSource = Okio.buffer(mySource(this.responseBody.source()));
        }
        BufferedSource bufferedSource = this.bufferedSource;
        if (bufferedSource != null) {
            return bufferedSource;
        }
        throw new NullPointerException("null cannot be cast to non-null type okio.BufferedSource");
    }
}
