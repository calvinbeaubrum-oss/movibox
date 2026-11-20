package mb;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;

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
public final class a extends RequestBody {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestBody f70940a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f70941b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public BufferedSink f70942c;

    /* JADX INFO: renamed from: mb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0758a extends ForwardingSink {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f70943a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f70944b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ a f70945c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0758a(Sink sink, a aVar) {
            super(sink);
            this.f70945c = aVar;
        }

        @Override // okio.ForwardingSink, okio.Sink
        public void write(Buffer source, long j11) throws IOException {
            Intrinsics.g(source, "source");
            try {
                super.write(source, j11);
                if (this.f70944b == 0) {
                    this.f70944b = this.f70945c.contentLength();
                }
                this.f70943a += j11;
                b bVar = this.f70945c.f70941b;
                if (bVar != null) {
                    long j12 = this.f70943a;
                    long j13 = this.f70944b;
                    bVar.a(j12, j13, j12 == j13);
                }
            } catch (Throwable unused) {
                throw new IOException();
            }
        }
    }

    public a(RequestBody requestBody, b bVar) {
        this.f70940a = requestBody;
        this.f70941b = bVar;
    }

    public final Sink b(Sink sink) {
        return new C0758a(sink, this);
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        RequestBody requestBody = this.f70940a;
        if (requestBody != null) {
            return requestBody.contentLength();
        }
        return 0L;
    }

    @Override // okhttp3.RequestBody
    public MediaType contentType() {
        RequestBody requestBody = this.f70940a;
        if (requestBody != null) {
            return requestBody.contentType();
        }
        return null;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(BufferedSink sink) throws IOException {
        Intrinsics.g(sink, "sink");
        if (this.f70942c == null) {
            this.f70942c = Okio.buffer(b(sink));
        }
        BufferedSink bufferedSink = this.f70942c;
        if (bufferedSink != null) {
            RequestBody requestBody = this.f70940a;
            if (requestBody != null) {
                requestBody.writeTo(bufferedSink);
            }
            bufferedSink.flush();
        }
    }
}
