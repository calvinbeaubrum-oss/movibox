package okhttp3.internal.http2;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
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
public final class Hpack {
    public static final Hpack INSTANCE;
    private static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
    private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
    private static final Header[] STATIC_HEADER_TABLE;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Reader {

        @JvmField
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;

        @JvmField
        public int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final BufferedSource source;

        @JvmOverloads
        public Reader(Source source, int i11) {
            this(source, i11, 0, 4, null);
        }

        @JvmOverloads
        public Reader(Source source, int i11, int i12) {
            Intrinsics.g(source, "source");
            this.headerTableSizeSetting = i11;
            this.maxDynamicTableByteCount = i12;
            this.headerList = new ArrayList();
            this.source = Okio.buffer(source);
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public /* synthetic */ Reader(Source source, int i11, int i12, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(source, i11, (i13 & 4) != 0 ? i11 : i12);
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 < i12) {
                if (i11 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i12 - i11);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.x(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int dynamicTableIndex(int i11) {
            return this.nextHeaderIndex + 1 + i11;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.d(header);
                    int i14 = header.hpackSize;
                    i11 -= i14;
                    this.dynamicTableByteCount -= i14;
                    this.headerCount--;
                    i13++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final ByteString getName(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                return Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    Header header = headerArr[iDynamicTableIndex];
                    Intrinsics.d(header);
                    return header.name;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private final void insertIntoDynamicTable(int i11, Header header) {
            this.headerList.add(header);
            int i12 = header.hpackSize;
            if (i11 != -1) {
                Header header2 = this.dynamicTable[dynamicTableIndex(i11)];
                Intrinsics.d(header2);
                i12 -= header2.hpackSize;
            }
            int i13 = this.maxDynamicTableByteCount;
            if (i12 > i13) {
                clearDynamicTable();
                return;
            }
            int iEvictToRecoverBytes = evictToRecoverBytes((this.dynamicTableByteCount + i12) - i13);
            if (i11 == -1) {
                int i14 = this.headerCount + 1;
                Header[] headerArr = this.dynamicTable;
                if (i14 > headerArr.length) {
                    Header[] headerArr2 = new Header[headerArr.length * 2];
                    System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                    this.nextHeaderIndex = this.dynamicTable.length - 1;
                    this.dynamicTable = headerArr2;
                }
                int i15 = this.nextHeaderIndex;
                this.nextHeaderIndex = i15 - 1;
                this.dynamicTable[i15] = header;
                this.headerCount++;
            } else {
                this.dynamicTable[i11 + dynamicTableIndex(i11) + iEvictToRecoverBytes] = header;
            }
            this.dynamicTableByteCount += i12;
        }

        private final boolean isStaticHeader(int i11) {
            return i11 >= 0 && i11 <= Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length - 1;
        }

        private final int readByte() throws IOException {
            return Util.and(this.source.readByte(), 255);
        }

        private final void readIndexedHeader(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                this.headerList.add(Hpack.INSTANCE.getSTATIC_HEADER_TABLE()[i11]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i11 - Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    List<Header> list = this.headerList;
                    Header header = headerArr[iDynamicTableIndex];
                    Intrinsics.d(header);
                    list.add(header);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private final void readLiteralHeaderWithIncrementalIndexingIndexedName(int i11) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingIndexedName(int i11) throws IOException {
            this.headerList.add(new Header(getName(i11), readByteString()));
        }

        private final void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.INSTANCE.checkLowercase(readByteString()), readByteString()));
        }

        public final List<Header> getAndResetHeaderList() {
            List<Header> listJ0 = CollectionsKt___CollectionsKt.J0(this.headerList);
            this.headerList.clear();
            return listJ0;
        }

        public final int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public final ByteString readByteString() throws IOException {
            int i11 = readByte();
            boolean z11 = (i11 & 128) == 128;
            long j11 = readInt(i11, 127);
            if (!z11) {
                return this.source.readByteString(j11);
            }
            Buffer buffer = new Buffer();
            Huffman.INSTANCE.decode(this.source, j11, buffer);
            return buffer.readByteString();
        }

        public final void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                int iAnd = Util.and(this.source.readByte(), 255);
                if (iAnd == 128) {
                    throw new IOException("index == 0");
                }
                if ((iAnd & 128) == 128) {
                    readIndexedHeader(readInt(iAnd, 127) - 1);
                } else if (iAnd == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((iAnd & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(iAnd, Hpack.PREFIX_6_BITS) - 1);
                } else if ((iAnd & 32) == 32) {
                    int i11 = readInt(iAnd, 31);
                    this.maxDynamicTableByteCount = i11;
                    if (i11 < 0 || i11 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (iAnd == 16 || iAnd == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(iAnd, 15) - 1);
                }
            }
        }

        public final int readInt(int i11, int i12) throws IOException {
            int i13 = i11 & i12;
            if (i13 < i12) {
                return i13;
            }
            int i14 = 0;
            while (true) {
                int i15 = readByte();
                if ((i15 & 128) == 0) {
                    return i12 + (i15 << i14);
                }
                i12 += (i15 & 127) << i14;
                i14 += 7;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Writer {

        @JvmField
        public Header[] dynamicTable;

        @JvmField
        public int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;

        @JvmField
        public int headerCount;

        @JvmField
        public int headerTableSizeSetting;

        @JvmField
        public int maxDynamicTableByteCount;
        private int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        @JvmOverloads
        public Writer(int i11, Buffer buffer) {
            this(i11, false, buffer, 2, null);
        }

        @JvmOverloads
        public Writer(int i11, boolean z11, Buffer out) {
            Intrinsics.g(out, "out");
            this.headerTableSizeSetting = i11;
            this.useCompression = z11;
            this.out = out;
            this.smallestHeaderTableSizeSetting = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.maxDynamicTableByteCount = i11;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
        }

        public /* synthetic */ Writer(int i11, boolean z11, Buffer buffer, int i12, DefaultConstructorMarker defaultConstructorMarker) {
            this((i12 & 1) != 0 ? 4096 : i11, (i12 & 2) != 0 ? true : z11, buffer);
        }

        @JvmOverloads
        public Writer(Buffer buffer) {
            this(0, false, buffer, 3, null);
        }

        private final void adjustDynamicTableByteCount() {
            int i11 = this.maxDynamicTableByteCount;
            int i12 = this.dynamicTableByteCount;
            if (i11 < i12) {
                if (i11 == 0) {
                    clearDynamicTable();
                } else {
                    evictToRecoverBytes(i12 - i11);
                }
            }
        }

        private final void clearDynamicTable() {
            ArraysKt___ArraysJvmKt.x(this.dynamicTable, null, 0, 0, 6, null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private final int evictToRecoverBytes(int i11) {
            int i12;
            int i13 = 0;
            if (i11 > 0) {
                int length = this.dynamicTable.length;
                while (true) {
                    length--;
                    i12 = this.nextHeaderIndex;
                    if (length < i12 || i11 <= 0) {
                        break;
                    }
                    Header header = this.dynamicTable[length];
                    Intrinsics.d(header);
                    i11 -= header.hpackSize;
                    int i14 = this.dynamicTableByteCount;
                    Header header2 = this.dynamicTable[length];
                    Intrinsics.d(header2);
                    this.dynamicTableByteCount = i14 - header2.hpackSize;
                    this.headerCount--;
                    i13++;
                }
                Header[] headerArr = this.dynamicTable;
                System.arraycopy(headerArr, i12 + 1, headerArr, i12 + 1 + i13, this.headerCount);
                Header[] headerArr2 = this.dynamicTable;
                int i15 = this.nextHeaderIndex;
                Arrays.fill(headerArr2, i15 + 1, i15 + 1 + i13, (Object) null);
                this.nextHeaderIndex += i13;
            }
            return i13;
        }

        private final void insertIntoDynamicTable(Header header) {
            int i11 = header.hpackSize;
            int i12 = this.maxDynamicTableByteCount;
            if (i11 > i12) {
                clearDynamicTable();
                return;
            }
            evictToRecoverBytes((this.dynamicTableByteCount + i11) - i12);
            int i13 = this.headerCount + 1;
            Header[] headerArr = this.dynamicTable;
            if (i13 > headerArr.length) {
                Header[] headerArr2 = new Header[headerArr.length * 2];
                System.arraycopy(headerArr, 0, headerArr2, headerArr.length, headerArr.length);
                this.nextHeaderIndex = this.dynamicTable.length - 1;
                this.dynamicTable = headerArr2;
            }
            int i14 = this.nextHeaderIndex;
            this.nextHeaderIndex = i14 - 1;
            this.dynamicTable[i14] = header;
            this.headerCount++;
            this.dynamicTableByteCount += i11;
        }

        public final void resizeHeaderTable(int i11) {
            this.headerTableSizeSetting = i11;
            int iMin = Math.min(i11, 16384);
            int i12 = this.maxDynamicTableByteCount;
            if (i12 == iMin) {
                return;
            }
            if (iMin < i12) {
                this.smallestHeaderTableSizeSetting = Math.min(this.smallestHeaderTableSizeSetting, iMin);
            }
            this.emitDynamicTableSizeUpdate = true;
            this.maxDynamicTableByteCount = iMin;
            adjustDynamicTableByteCount();
        }

        public final void writeByteString(ByteString data) throws IOException {
            Intrinsics.g(data, "data");
            if (this.useCompression) {
                Huffman huffman = Huffman.INSTANCE;
                if (huffman.encodedLength(data) < data.size()) {
                    Buffer buffer = new Buffer();
                    huffman.encode(data, buffer);
                    ByteString byteString = buffer.readByteString();
                    writeInt(byteString.size(), 127, 128);
                    this.out.write(byteString);
                    return;
                }
            }
            writeInt(data.size(), 127, 0);
            this.out.write(data);
        }

        /* JADX WARN: Code duplicated, block: B:27:0x007e  */
        /* JADX WARN: Code duplicated, block: B:29:0x0087  */
        /* JADX WARN: Code duplicated, block: B:31:0x0096  */
        /* JADX WARN: Code duplicated, block: B:34:0x00b1 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:35:0x00b3  */
        /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
        /* JADX WARN: Code duplicated, block: B:39:0x00cc  */
        /* JADX WARN: Code duplicated, block: B:41:0x00d0  */
        /* JADX WARN: Code duplicated, block: B:42:0x00df  */
        /* JADX WARN: Code duplicated, block: B:47:0x00fa  */
        /* JADX WARN: Code duplicated, block: B:55:0x00a5 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00bf A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:59:0x00bf A[SYNTHETIC] */
        public final void writeHeaders(List<Header> headerBlock) throws IOException {
            int length;
            int length2;
            int i11;
            int length3;
            Header header;
            Header header2;
            Intrinsics.g(headerBlock, "headerBlock");
            if (this.emitDynamicTableSizeUpdate) {
                int i12 = this.smallestHeaderTableSizeSetting;
                if (i12 < this.maxDynamicTableByteCount) {
                    writeInt(i12, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = headerBlock.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header3 = headerBlock.get(i13);
                ByteString asciiLowercase = header3.name.toAsciiLowercase();
                ByteString byteString = header3.value;
                Hpack hpack = Hpack.INSTANCE;
                Integer num = hpack.getNAME_TO_FIRST_INDEX().get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 <= length2 && 7 >= length2) {
                        if (Intrinsics.b(hpack.getSTATIC_HEADER_TABLE()[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (Intrinsics.b(hpack.getSTATIC_HEADER_TABLE()[length2].value, byteString)) {
                            length = length2;
                            length2 = iIntValue + 2;
                        }
                        if (length2 == -1) {
                            length3 = this.dynamicTable.length;
                            for (i11 = this.nextHeaderIndex + 1; i11 < length3; i11++) {
                                header = this.dynamicTable[i11];
                                Intrinsics.d(header);
                                if (Intrinsics.b(header.name, asciiLowercase)) {
                                    header2 = this.dynamicTable[i11];
                                    Intrinsics.d(header2);
                                    if (Intrinsics.b(header2.value, byteString)) {
                                        length2 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i11 - this.nextHeaderIndex);
                                        break;
                                    } else if (length == -1) {
                                        length = (i11 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                                    }
                                }
                            }
                        }
                        if (length2 != -1) {
                            writeInt(length2, 127, 128);
                        } else if (length == -1) {
                            this.out.writeByte(64);
                            writeByteString(asciiLowercase);
                            writeByteString(byteString);
                            insertIntoDynamicTable(header3);
                        } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || !(!Intrinsics.b(Header.TARGET_AUTHORITY, asciiLowercase))) {
                            writeInt(length, Hpack.PREFIX_6_BITS, 64);
                            writeByteString(byteString);
                            insertIntoDynamicTable(header3);
                        } else {
                            writeInt(length, 15, 0);
                            writeByteString(byteString);
                        }
                    }
                    length = length2;
                } else {
                    length = -1;
                }
                length2 = -1;
                if (length2 == -1) {
                    length3 = this.dynamicTable.length;
                    while (i11 < length3) {
                        header = this.dynamicTable[i11];
                        Intrinsics.d(header);
                        if (Intrinsics.b(header.name, asciiLowercase)) {
                            header2 = this.dynamicTable[i11];
                            Intrinsics.d(header2);
                            if (Intrinsics.b(header2.value, byteString)) {
                                length2 = Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length + (i11 - this.nextHeaderIndex);
                                break;
                            } else if (length == -1) {
                                length = (i11 - this.nextHeaderIndex) + Hpack.INSTANCE.getSTATIC_HEADER_TABLE().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    writeInt(length2, 127, 128);
                } else if (length == -1) {
                    this.out.writeByte(64);
                    writeByteString(asciiLowercase);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header3);
                } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX)) {
                    writeInt(length, Hpack.PREFIX_6_BITS, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header3);
                } else {
                    writeInt(length, Hpack.PREFIX_6_BITS, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header3);
                }
            }
        }

        public final void writeInt(int i11, int i12, int i13) {
            if (i11 < i12) {
                this.out.writeByte(i11 | i13);
                return;
            }
            this.out.writeByte(i13 | i12);
            int i14 = i11 - i12;
            while (i14 >= 128) {
                this.out.writeByte(128 | (i14 & 127));
                i14 >>>= 7;
            }
            this.out.writeByte(i14);
        }
    }

    static {
        Hpack hpack = new Hpack();
        INSTANCE = hpack;
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, HttpHost.DEFAULT_SCHEME_NAME), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header(BufferQueue.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header(BufferQueue.CONTENT_LENGTH, ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(RequestParameters.SUBRESOURCE_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header(RequestParameters.SUBRESOURCE_REFERER, ""), new Header(ToolBar.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = hpack.nameToFirstIndex();
    }

    private Hpack() {
    }

    private final Map<ByteString, Integer> nameToFirstIndex() {
        Header[] headerArr = STATIC_HEADER_TABLE;
        LinkedHashMap linkedHashMap = new LinkedHashMap(headerArr.length);
        int length = headerArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            Header[] headerArr2 = STATIC_HEADER_TABLE;
            if (!linkedHashMap.containsKey(headerArr2[i11].name)) {
                linkedHashMap.put(headerArr2[i11].name, Integer.valueOf(i11));
            }
        }
        Map<ByteString, Integer> mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        Intrinsics.f(mapUnmodifiableMap, "Collections.unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final ByteString checkLowercase(ByteString name) throws IOException {
        Intrinsics.g(name, "name");
        int size = name.size();
        for (int i11 = 0; i11 < size; i11++) {
            byte b11 = (byte) 65;
            byte b12 = (byte) 90;
            byte b13 = name.getByte(i11);
            if (b11 <= b13 && b12 >= b13) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + name.utf8());
            }
        }
        return name;
    }

    public final Map<ByteString, Integer> getNAME_TO_FIRST_INDEX() {
        return NAME_TO_FIRST_INDEX;
    }

    public final Header[] getSTATIC_HEADER_TABLE() {
        return STATIC_HEADER_TABLE;
    }
}
