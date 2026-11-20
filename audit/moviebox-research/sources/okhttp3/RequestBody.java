package okhttp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.Util;
import okio.BufferedSink;
import okio.ByteString;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i11, int i12, int i13, Object obj) {
            if ((i13 & 4) != 0) {
                i11 = 0;
            }
            if ((i13 & 8) != 0) {
                i12 = bArr.length;
            }
            return companion.create(mediaType, bArr, i11, i12);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i11, int i12, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                mediaType = null;
            }
            if ((i13 & 2) != 0) {
                i11 = 0;
            }
            if ((i13 & 4) != 0) {
                i12 = bArr.length;
            }
            return companion.create(bArr, mediaType, i11, i12);
        }

        @JvmStatic
        @JvmName
        public final RequestBody create(final File asRequestBody, final MediaType mediaType) {
            Intrinsics.g(asRequestBody, "$this$asRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return asRequestBody.length();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) throws FileNotFoundException {
                    Intrinsics.g(sink, "sink");
                    Source source = Okio.source(asRequestBody);
                    try {
                        sink.writeAll(source);
                        CloseableKt.a(source, null);
                    } catch (Throwable th2) {
                        try {
                            throw th2;
                        } catch (Throwable th3) {
                            CloseableKt.a(source, th2);
                            throw th3;
                        }
                    }
                }
            };
        }

        @JvmStatic
        @JvmName
        public final RequestBody create(String toRequestBody, MediaType mediaType) {
            Intrinsics.g(toRequestBody, "$this$toRequestBody");
            Charset charset = Charsets.f69091b;
            if (mediaType != null) {
                Charset charsetCharset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charsetCharset$default == null) {
                    mediaType = MediaType.Companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charsetCharset$default;
                }
            }
            byte[] bytes = toRequestBody.getBytes(charset);
            Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
            return create(bytes, mediaType, 0, bytes.length);
        }

        @Deprecated
        @JvmStatic
        public final RequestBody create(MediaType mediaType, File file) {
            Intrinsics.g(file, "file");
            return create(file, mediaType);
        }

        @Deprecated
        @JvmStatic
        public final RequestBody create(MediaType mediaType, String content) {
            Intrinsics.g(content, "content");
            return create(content, mediaType);
        }

        @Deprecated
        @JvmStatic
        public final RequestBody create(MediaType mediaType, ByteString content) {
            Intrinsics.g(content, "content");
            return create(content, mediaType);
        }

        @Deprecated
        @JvmStatic
        @JvmOverloads
        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        @Deprecated
        @JvmStatic
        @JvmOverloads
        public final RequestBody create(MediaType mediaType, byte[] bArr, int i11) {
            return create$default(this, mediaType, bArr, i11, 0, 8, (Object) null);
        }

        @Deprecated
        @JvmStatic
        @JvmOverloads
        public final RequestBody create(MediaType mediaType, byte[] content, int i11, int i12) {
            Intrinsics.g(content, "content");
            return create(content, mediaType, i11, i12);
        }

        @JvmStatic
        @JvmName
        public final RequestBody create(final ByteString toRequestBody, final MediaType mediaType) {
            Intrinsics.g(toRequestBody, "$this$toRequestBody");
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return toRequestBody.size();
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.g(sink, "sink");
                    sink.write(toRequestBody);
                }
            };
        }

        @JvmStatic
        @JvmOverloads
        @JvmName
        public final RequestBody create(byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName
        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName
        public final RequestBody create(byte[] bArr, MediaType mediaType, int i11) {
            return create$default(this, bArr, mediaType, i11, 0, 4, (Object) null);
        }

        @JvmStatic
        @JvmOverloads
        @JvmName
        public final RequestBody create(final byte[] toRequestBody, final MediaType mediaType, final int i11, final int i12) {
            Intrinsics.g(toRequestBody, "$this$toRequestBody");
            Util.checkOffsetAndCount(toRequestBody.length, i11, i12);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i12;
                }

                @Override // okhttp3.RequestBody
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.g(sink, "sink");
                    sink.write(toRequestBody, i11, i12);
                }
            };
        }
    }

    @JvmStatic
    @JvmName
    public static final RequestBody create(File file, MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    @JvmStatic
    @JvmName
    public static final RequestBody create(String str, MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @Deprecated
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, File file) {
        return Companion.create(mediaType, file);
    }

    @Deprecated
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, String str) {
        return Companion.create(mediaType, str);
    }

    @Deprecated
    @JvmStatic
    public static final RequestBody create(MediaType mediaType, ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @Deprecated
    @JvmStatic
    @JvmOverloads
    public static final RequestBody create(MediaType mediaType, byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    @Deprecated
    @JvmStatic
    @JvmOverloads
    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i11) {
        return Companion.create$default(Companion, mediaType, bArr, i11, 0, 8, (Object) null);
    }

    @Deprecated
    @JvmStatic
    @JvmOverloads
    public static final RequestBody create(MediaType mediaType, byte[] bArr, int i11, int i12) {
        return Companion.create(mediaType, bArr, i11, i12);
    }

    @JvmStatic
    @JvmName
    public static final RequestBody create(ByteString byteString, MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName
    public static final RequestBody create(byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName
    public static final RequestBody create(byte[] bArr, MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName
    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i11) {
        return Companion.create$default(Companion, bArr, mediaType, i11, 0, 4, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    @JvmName
    public static final RequestBody create(byte[] bArr, MediaType mediaType, int i11, int i12) {
        return Companion.create(bArr, mediaType, i11, i12);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;
}
