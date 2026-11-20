package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.bumptech.glide.integration.cronet.BufferQueue;
import com.google.android.gms.common.api.Api;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.mbsignalcommon.commonwebview.ToolBar;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.BufferedSource;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Okio;
import com.mbridge.msdk.thrid.okio.Source;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
final class Hpack {
    static final Map<ByteString, Integer> NAME_TO_FIRST_INDEX;
    private static final int PREFIX_4_BITS = 15;
    private static final int PREFIX_5_BITS = 31;
    private static final int PREFIX_6_BITS = 63;
    private static final int PREFIX_7_BITS = 127;
    static final Header[] STATIC_HEADER_TABLE;

    /* JADX INFO: compiled from: source.java */
    public static final class Reader {
        Header[] dynamicTable;
        int dynamicTableByteCount;
        int headerCount;
        private final List<Header> headerList;
        private final int headerTableSizeSetting;
        private int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final BufferedSource source;

        public Reader(int i11, int i12, Source source) {
            this.headerList = new ArrayList();
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i11;
            this.maxDynamicTableByteCount = i12;
            this.source = Okio.buffer(source);
        }

        public Reader(int i11, Source source) {
            this(i11, i11, source);
        }

        private void adjustDynamicTableByteCount() {
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

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int dynamicTableIndex(int i11) {
            return this.nextHeaderIndex + 1 + i11;
        }

        private int evictToRecoverBytes(int i11) {
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
                    int i14 = this.dynamicTable[length].hpackSize;
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

        private ByteString getName(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                return Hpack.STATIC_HEADER_TABLE[i11].name;
            }
            int iDynamicTableIndex = dynamicTableIndex(i11 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    return headerArr[iDynamicTableIndex].name;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private void insertIntoDynamicTable(int i11, Header header) {
            this.headerList.add(header);
            int i12 = header.hpackSize;
            if (i11 != -1) {
                i12 -= this.dynamicTable[dynamicTableIndex(i11)].hpackSize;
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

        private boolean isStaticHeader(int i11) {
            return i11 >= 0 && i11 <= Hpack.STATIC_HEADER_TABLE.length - 1;
        }

        private int readByte() throws IOException {
            return this.source.readByte() & 255;
        }

        private void readIndexedHeader(int i11) throws IOException {
            if (isStaticHeader(i11)) {
                this.headerList.add(Hpack.STATIC_HEADER_TABLE[i11]);
                return;
            }
            int iDynamicTableIndex = dynamicTableIndex(i11 - Hpack.STATIC_HEADER_TABLE.length);
            if (iDynamicTableIndex >= 0) {
                Header[] headerArr = this.dynamicTable;
                if (iDynamicTableIndex < headerArr.length) {
                    this.headerList.add(headerArr[iDynamicTableIndex]);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i11 + 1));
        }

        private void readLiteralHeaderWithIncrementalIndexingIndexedName(int i11) throws IOException {
            insertIntoDynamicTable(-1, new Header(getName(i11), readByteString()));
        }

        private void readLiteralHeaderWithIncrementalIndexingNewName() throws IOException {
            insertIntoDynamicTable(-1, new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingIndexedName(int i11) throws IOException {
            this.headerList.add(new Header(getName(i11), readByteString()));
        }

        private void readLiteralHeaderWithoutIndexingNewName() throws IOException {
            this.headerList.add(new Header(Hpack.checkLowercase(readByteString()), readByteString()));
        }

        public List<Header> getAndResetHeaderList() {
            ArrayList arrayList = new ArrayList(this.headerList);
            this.headerList.clear();
            return arrayList;
        }

        public int maxDynamicTableByteCount() {
            return this.maxDynamicTableByteCount;
        }

        public ByteString readByteString() throws IOException {
            int i11 = readByte();
            boolean z11 = (i11 & 128) == 128;
            int i12 = readInt(i11, 127);
            return z11 ? ByteString.of(Huffman.get().decode(this.source.readByteArray(i12))) : this.source.readByteString(i12);
        }

        public void readHeaders() throws IOException {
            while (!this.source.exhausted()) {
                byte b11 = this.source.readByte();
                int i11 = b11 & 255;
                if (i11 == 128) {
                    throw new IOException("index == 0");
                }
                if ((b11 & 128) == 128) {
                    readIndexedHeader(readInt(i11, 127) - 1);
                } else if (i11 == 64) {
                    readLiteralHeaderWithIncrementalIndexingNewName();
                } else if ((b11 & 64) == 64) {
                    readLiteralHeaderWithIncrementalIndexingIndexedName(readInt(i11, Hpack.PREFIX_6_BITS) - 1);
                } else if ((b11 & 32) == 32) {
                    int i12 = readInt(i11, 31);
                    this.maxDynamicTableByteCount = i12;
                    if (i12 < 0 || i12 > this.headerTableSizeSetting) {
                        throw new IOException("Invalid dynamic table size update " + this.maxDynamicTableByteCount);
                    }
                    adjustDynamicTableByteCount();
                } else if (i11 == 16 || i11 == 0) {
                    readLiteralHeaderWithoutIndexingNewName();
                } else {
                    readLiteralHeaderWithoutIndexingIndexedName(readInt(i11, 15) - 1);
                }
            }
        }

        public int readInt(int i11, int i12) throws IOException {
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
    public static final class Writer {
        private static final int SETTINGS_HEADER_TABLE_SIZE = 4096;
        private static final int SETTINGS_HEADER_TABLE_SIZE_LIMIT = 16384;
        Header[] dynamicTable;
        int dynamicTableByteCount;
        private boolean emitDynamicTableSizeUpdate;
        int headerCount;
        int headerTableSizeSetting;
        int maxDynamicTableByteCount;
        int nextHeaderIndex;
        private final Buffer out;
        private int smallestHeaderTableSizeSetting;
        private final boolean useCompression;

        public Writer(int i11, boolean z11, Buffer buffer) {
            this.smallestHeaderTableSizeSetting = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            Header[] headerArr = new Header[8];
            this.dynamicTable = headerArr;
            this.nextHeaderIndex = headerArr.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
            this.headerTableSizeSetting = i11;
            this.maxDynamicTableByteCount = i11;
            this.useCompression = z11;
            this.out = buffer;
        }

        public Writer(Buffer buffer) {
            this(4096, true, buffer);
        }

        private void adjustDynamicTableByteCount() {
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

        private void clearDynamicTable() {
            Arrays.fill(this.dynamicTable, (Object) null);
            this.nextHeaderIndex = this.dynamicTable.length - 1;
            this.headerCount = 0;
            this.dynamicTableByteCount = 0;
        }

        private int evictToRecoverBytes(int i11) {
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
                    int i14 = this.dynamicTable[length].hpackSize;
                    i11 -= i14;
                    this.dynamicTableByteCount -= i14;
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

        private void insertIntoDynamicTable(Header header) {
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

        public void setHeaderTableSizeSetting(int i11) {
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

        public void writeByteString(ByteString byteString) throws IOException {
            if (!this.useCompression || Huffman.get().encodedLength(byteString) >= byteString.size()) {
                writeInt(byteString.size(), 127, 0);
                this.out.write(byteString);
                return;
            }
            Buffer buffer = new Buffer();
            Huffman.get().encode(byteString, buffer);
            ByteString byteString2 = buffer.readByteString();
            writeInt(byteString2.size(), 127, 128);
            this.out.write(byteString2);
        }

        /* JADX WARN: Code duplicated, block: B:26:0x0070  */
        /* JADX WARN: Code duplicated, block: B:28:0x0078  */
        /* JADX WARN: Code duplicated, block: B:30:0x0084  */
        /* JADX WARN: Code duplicated, block: B:33:0x0099 A[DONT_INVERT] */
        /* JADX WARN: Code duplicated, block: B:34:0x009b  */
        /* JADX WARN: Code duplicated, block: B:37:0x00a8  */
        /* JADX WARN: Code duplicated, block: B:38:0x00b0  */
        /* JADX WARN: Code duplicated, block: B:40:0x00b4  */
        /* JADX WARN: Code duplicated, block: B:41:0x00c3  */
        /* JADX WARN: Code duplicated, block: B:46:0x00dc  */
        /* JADX WARN: Code duplicated, block: B:55:0x0090 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:57:0x00a3 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:58:0x00a3 A[SYNTHETIC] */
        public void writeHeaders(List<Header> list) throws IOException {
            int length;
            int length2;
            int i11;
            int length3;
            if (this.emitDynamicTableSizeUpdate) {
                int i12 = this.smallestHeaderTableSizeSetting;
                if (i12 < this.maxDynamicTableByteCount) {
                    writeInt(i12, 31, 32);
                }
                this.emitDynamicTableSizeUpdate = false;
                this.smallestHeaderTableSizeSetting = Api.BaseClientBuilder.API_PRIORITY_OTHER;
                writeInt(this.maxDynamicTableByteCount, 31, 32);
            }
            int size = list.size();
            for (int i13 = 0; i13 < size; i13++) {
                Header header = list.get(i13);
                ByteString asciiLowercase = header.name.toAsciiLowercase();
                ByteString byteString = header.value;
                Integer num = Hpack.NAME_TO_FIRST_INDEX.get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (length2 > 1 && length2 < 8) {
                        Header[] headerArr = Hpack.STATIC_HEADER_TABLE;
                        if (Util.equal(headerArr[iIntValue].value, byteString)) {
                            length = length2;
                        } else if (Util.equal(headerArr[length2].value, byteString)) {
                            length2 = iIntValue + 2;
                            length = length2;
                        }
                        if (length2 == -1) {
                            length3 = this.dynamicTable.length;
                            for (i11 = this.nextHeaderIndex + 1; i11 < length3; i11++) {
                                if (!Util.equal(this.dynamicTable[i11].name, asciiLowercase)) {
                                    if (Util.equal(this.dynamicTable[i11].value, byteString)) {
                                        length2 = (i11 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                        break;
                                    } else if (length == -1) {
                                        length = (i11 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
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
                            insertIntoDynamicTable(header);
                        } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX) || Header.TARGET_AUTHORITY.equals(asciiLowercase)) {
                            writeInt(length, Hpack.PREFIX_6_BITS, 64);
                            writeByteString(byteString);
                            insertIntoDynamicTable(header);
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
                        if (!Util.equal(this.dynamicTable[i11].name, asciiLowercase)) {
                            if (Util.equal(this.dynamicTable[i11].value, byteString)) {
                                length2 = (i11 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
                                break;
                            } else if (length == -1) {
                                length = (i11 - this.nextHeaderIndex) + Hpack.STATIC_HEADER_TABLE.length;
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
                    insertIntoDynamicTable(header);
                } else if (asciiLowercase.startsWith(Header.PSEUDO_PREFIX)) {
                    writeInt(length, Hpack.PREFIX_6_BITS, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                } else {
                    writeInt(length, Hpack.PREFIX_6_BITS, 64);
                    writeByteString(byteString);
                    insertIntoDynamicTable(header);
                }
            }
        }

        public void writeInt(int i11, int i12, int i13) {
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
        ByteString byteString = Header.TARGET_METHOD;
        ByteString byteString2 = Header.TARGET_PATH;
        ByteString byteString3 = Header.TARGET_SCHEME;
        ByteString byteString4 = Header.RESPONSE_STATUS;
        STATIC_HEADER_TABLE = new Header[]{new Header(Header.TARGET_AUTHORITY, ""), new Header(byteString, "GET"), new Header(byteString, "POST"), new Header(byteString2, "/"), new Header(byteString2, "/index.html"), new Header(byteString3, HttpHost.DEFAULT_SCHEME_NAME), new Header(byteString3, "https"), new Header(byteString4, "200"), new Header(byteString4, "204"), new Header(byteString4, "206"), new Header(byteString4, "304"), new Header(byteString4, "400"), new Header(byteString4, "404"), new Header(byteString4, "500"), new Header("accept-charset", ""), new Header("accept-encoding", "gzip, deflate"), new Header("accept-language", ""), new Header("accept-ranges", ""), new Header("accept", ""), new Header("access-control-allow-origin", ""), new Header("age", ""), new Header("allow", ""), new Header("authorization", ""), new Header("cache-control", ""), new Header("content-disposition", ""), new Header(BufferQueue.CONTENT_ENCODING, ""), new Header("content-language", ""), new Header(BufferQueue.CONTENT_LENGTH, ""), new Header("content-location", ""), new Header("content-range", ""), new Header("content-type", ""), new Header("cookie", ""), new Header("date", ""), new Header(DownloadModel.ETAG, ""), new Header("expect", ""), new Header("expires", ""), new Header("from", ""), new Header("host", ""), new Header("if-match", ""), new Header("if-modified-since", ""), new Header("if-none-match", ""), new Header("if-range", ""), new Header("if-unmodified-since", ""), new Header("last-modified", ""), new Header("link", ""), new Header(RequestParameters.SUBRESOURCE_LOCATION, ""), new Header("max-forwards", ""), new Header("proxy-authenticate", ""), new Header("proxy-authorization", ""), new Header("range", ""), new Header(RequestParameters.SUBRESOURCE_REFERER, ""), new Header(ToolBar.REFRESH, ""), new Header("retry-after", ""), new Header("server", ""), new Header("set-cookie", ""), new Header("strict-transport-security", ""), new Header("transfer-encoding", ""), new Header("user-agent", ""), new Header("vary", ""), new Header("via", ""), new Header("www-authenticate", "")};
        NAME_TO_FIRST_INDEX = nameToFirstIndex();
    }

    private Hpack() {
    }

    public static ByteString checkLowercase(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i11 = 0; i11 < size; i11++) {
            byte b11 = byteString.getByte(i11);
            if (b11 >= 65 && b11 <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    private static Map<ByteString, Integer> nameToFirstIndex() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(STATIC_HEADER_TABLE.length);
        int i11 = 0;
        while (true) {
            Header[] headerArr = STATIC_HEADER_TABLE;
            if (i11 >= headerArr.length) {
                return Collections.unmodifiableMap(linkedHashMap);
            }
            if (!linkedHashMap.containsKey(headerArr[i11].name)) {
                linkedHashMap.put(headerArr[i11].name, Integer.valueOf(i11));
            }
            i11++;
        }
    }
}
