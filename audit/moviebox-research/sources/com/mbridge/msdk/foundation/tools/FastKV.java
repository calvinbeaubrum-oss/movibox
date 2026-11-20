package com.mbridge.msdk.foundation.tools;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okio.Utf8;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE;
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private int dataEnd;
    private final Map<String, a> encoderMap;
    private p fastBuffer;
    private int invalidBytes;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;
    private final Map<String, f.b> data = new HashMap();
    private final Executor executor = new s();
    private final ArrayList<c> invalids = new ArrayList<>();
    private final b logger = q.f45084b;
    private boolean autoCommit = true;

    /* JADX INFO: compiled from: source.java */
    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            }
            if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            if (!str.endsWith("/")) {
                str = str + '/';
            }
            this.path = str;
            this.name = str2;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    try {
                        fastKV = map.get(str);
                        if (fastKV == null) {
                            fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                            map.put(str, fastKV);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
            return fastKV;
        }

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T a(byte[] bArr, int i11, int i12);

        String a();

        byte[] a(T t11);
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Comparable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f44925a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f44926b;

        public c(int i11, int i12) {
            this.f44926b = i11;
            this.f44925a = i12;
        }

        @Override // java.lang.Comparable
        public final /* bridge */ /* synthetic */ int compareTo(c cVar) {
            return this.f44926b - cVar.f44926b;
        }
    }

    static {
        int iA = ap.a();
        PAGE_SIZE = iA;
        int iMax = Math.max(iA << 1, 16384);
        DOUBLE_LIMIT = iMax;
        TRUNCATE_THRESHOLD = iMax << 1;
        TYPE_SIZE = new int[]{0, 1, 4, 4, 8, 8};
    }

    public FastKV(String str, String str2, a[] aVarArr, int i11) {
        this.path = str;
        this.name = str2;
        this.writingMode = i11;
        HashMap map = new HashMap();
        map.put("StringSet", am.f45015a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String strA = aVar.a();
                if (map.containsKey(strA)) {
                    error("duplicate encoder tag:" + strA);
                } else {
                    map.put(strA, aVar);
                }
            }
        }
        this.encoderMap = map;
        loadData();
    }

    private void addObject(String str, Object obj, byte[] bArr, byte b11) {
        Object obj2;
        int length;
        f.b aVar;
        int iSaveArray = saveArray(str, bArr, b11);
        if (iSaveArray != 0) {
            String str2 = this.tempExternalName;
            boolean z11 = str2 != null;
            if (z11) {
                this.tempExternalName = null;
                obj2 = str2;
                length = 32;
            } else {
                obj2 = obj;
                length = bArr.length;
            }
            if (b11 == 6) {
                aVar = new f.i(this.updateStart, iSaveArray, (String) obj2, length, z11);
            } else {
                aVar = b11 == 7 ? new f.a(this.updateStart, iSaveArray, obj2, length, z11) : new f.h(this.updateStart, iSaveArray, obj2, length, z11);
            }
            this.data.put(str, aVar);
            updateChange();
        }
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, f.j jVar, byte b11) {
        if (jVar == null) {
            addObject(str, obj, bArr, b11);
        } else if (jVar.f45063b || jVar.f45066e != bArr.length) {
            updateObject(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.f45057a, bArr);
            jVar.f45065d = obj;
        }
        checkIfCommit();
    }

    private int bytesThreshold() {
        int i11 = this.dataEnd;
        if (i11 <= 16384) {
            return 4096;
        }
        return i11 <= 65536 ? 8192 : 16384;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void checkIfCommit() {
        if (this.writingMode == 0 || !this.autoCommit) {
            return;
        }
        commitToCFile();
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i11) {
        if (i11 > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void checkValueSize(int i11, boolean z11) {
        if (z11) {
            if (i11 != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i11 < 0 || i11 >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0L;
        clearInvalid();
        this.data.clear();
        p pVar = this.fastBuffer;
        if (pVar == null || pVar.f45080a.length != PAGE_SIZE) {
            this.fastBuffer = new p(PAGE_SIZE);
        } else {
            pVar.b(0, 0);
            this.fastBuffer.a(4, 0L);
        }
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private boolean commitToCFile() {
        int i11 = this.writingMode;
        if (i11 == 1) {
            this.executor.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.FastKV.1
                @Override // java.lang.Runnable
                public final void run() {
                    FastKV.this.writeToCFile();
                }
            });
        } else if (i11 == 2) {
            return writeToCFile();
        }
        return true;
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i11) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0L, mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e11) {
                error(e11);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i11);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private void countInvalid(int i11, int i12) {
        this.invalidBytes += i12 - i11;
        this.invalids.add(new c(i11, i12));
    }

    private void deleteCFiles() {
        try {
            ap.a(new File(this.path, this.name + C_SUFFIX));
            ap.a(new File(this.path, this.name + TEMP_SUFFIX));
        } catch (Exception e11) {
            error(e11);
        }
    }

    private void ensureSize(int i11) {
        int length = this.fastBuffer.f45080a.length;
        int i12 = this.dataEnd + i11;
        if (i12 >= length) {
            int i13 = this.invalidBytes;
            if (i13 > i11 && i13 > bytesThreshold()) {
                gc(i11);
                return;
            }
            int newCapacity = getNewCapacity(length, i12);
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.f45080a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.f45080a = bArr;
            if (this.writingMode == 0) {
                try {
                    FileChannel fileChannel = this.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    long j11 = newCapacity;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
                    this.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
                    this.bBuffer = map2;
                    map2.order(byteOrder);
                } catch (IOException e11) {
                    error(new Exception(MAP_FAILED, e11));
                    this.fastBuffer.b(0, this.dataEnd - 12);
                    this.fastBuffer.a(4, this.checksum);
                    toBlockingMode();
                }
            }
        }
    }

    private void error(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, new Exception(str));
        }
    }

    private void fastPutString(String str, String str2, f.i iVar) {
        int iA = p.a(str2);
        if (iVar == null) {
            int iA2 = p.a(str);
            checkKeySize(iA2);
            int i11 = iA2 + 4;
            this.updateSize = i11 + iA;
            preparePutBytes();
            this.fastBuffer.a((byte) 6);
            putKey(str, iA2);
            putStringValue(str2, iA);
            Map<String, f.b> map = this.data;
            int i12 = this.updateStart;
            map.put(str, new f.i(i12, i12 + i11, str2, iA, false));
            updateChange();
        } else {
            int i13 = iVar.f45057a;
            int i14 = i13 - iVar.f45064c;
            int i15 = iVar.f45066e;
            boolean z11 = false;
            String str3 = null;
            if (i15 == iA) {
                this.checksum ^= this.fastBuffer.a(i13, i15);
                if (iA == str2.length()) {
                    str2.getBytes(0, iA, this.fastBuffer.f45080a, iVar.f45057a);
                } else {
                    p pVar = this.fastBuffer;
                    pVar.f45081b = iVar.f45057a;
                    pVar.b(str2);
                }
                this.updateStart = iVar.f45057a;
                this.updateSize = iA;
            } else {
                this.updateSize = i14 + iA;
                preparePutBytes();
                this.fastBuffer.a((byte) 6);
                int i16 = i14 - 3;
                p pVar2 = this.fastBuffer;
                byte[] bArr = pVar2.f45080a;
                System.arraycopy(bArr, iVar.f45064c + 1, bArr, pVar2.f45081b, i16);
                this.fastBuffer.f45081b += i16;
                putStringValue(str2, iA);
                remove((byte) 6, iVar.f45064c, iVar.f45057a + iVar.f45066e);
                str3 = iVar.f45063b ? (String) iVar.f45065d : null;
                iVar.f45063b = false;
                int i17 = this.updateStart;
                iVar.f45064c = i17;
                iVar.f45057a = i17 + i14;
                iVar.f45066e = iA;
                z11 = true;
            }
            iVar.f45065d = str2;
            updateChange();
            if (z11) {
                checkGC();
            }
            if (str3 != null) {
                ap.a(new File(this.path + this.name, str3));
            }
        }
        checkIfCommit();
    }

    private byte[] getArrayFromFile(f.a aVar) {
        try {
            byte[] bArrB = ap.b(new File(this.path + this.name, (String) aVar.f45065d));
            return bArrB != null ? bArrB : EMPTY_ARRAY;
        } catch (Exception e11) {
            error(e11);
            return EMPTY_ARRAY;
        }
    }

    private int getNewCapacity(int i11, int i12) {
        if (i12 > 536870912) {
            throw new IllegalStateException("data size out of limit");
        }
        int i13 = PAGE_SIZE;
        if (i12 <= i13) {
            return i13;
        }
        while (i11 < i12) {
            int i14 = DOUBLE_LIMIT;
            i11 = i11 <= i14 ? i11 << 1 : i11 + i14;
        }
        return i11;
    }

    private Object getObjectFromFile(f.h hVar) {
        try {
            byte[] bArrB = ap.b(new File(this.path + this.name, (String) hVar.f45065d));
            if (bArrB == null) {
                warning(new Exception("Read object data failed"));
                return null;
            }
            int i11 = bArrB[0] & 255;
            String str = new String(bArrB, 1, i11, StandardCharsets.UTF_8);
            a aVar = this.encoderMap.get(str);
            if (aVar != null) {
                int i12 = i11 + 1;
                return aVar.a(bArrB, i12, bArrB.length - i12);
            }
            warning(new Exception("No encoder for tag:" + str));
            return null;
        } catch (Exception e11) {
            error(e11);
            return null;
        }
    }

    private String getStringFromFile(f.i iVar) {
        try {
            byte[] bArrB = ap.b(new File(this.path + this.name, (String) iVar.f45065d));
            if (bArrB != null && bArrB.length != 0) {
                return new String(bArrB, StandardCharsets.UTF_8);
            }
            return "";
        } catch (Exception e11) {
            error(e11);
        }
        return "";
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    private boolean isABFileEqual() {
        p pVar = new p(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(pVar.f45080a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.f45080a;
        byte[] bArr2 = pVar.f45080a;
        for (int i11 = 0; i11 < this.dataEnd; i11++) {
            if (bArr[i11] != bArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    private synchronized void loadData() {
        try {
            long jNanoTime = System.nanoTime();
            if (!loadFromCFile() && this.writingMode == 0) {
                loadFromABFile();
            }
            if (this.fastBuffer == null) {
                this.fastBuffer = new p(PAGE_SIZE);
            }
            if (this.logger != null) {
                info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - jNanoTime) / 1000000) + " ms");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private void loadFromABFile() {
        FastKV fastKV = this;
        File file = new File(fastKV.path, fastKV.name + A_SUFFIX);
        File file2 = new File(fastKV.path, fastKV.name + B_SUFFIX);
        try {
            if (ap.c(file) && ap.c(file2)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
                long length = randomAccessFile.length();
                long length2 = randomAccessFile2.length();
                fastKV.aChannel = randomAccessFile.getChannel();
                fastKV.bChannel = randomAccessFile2.getChannel();
                try {
                    FileChannel fileChannel = fastKV.aChannel;
                    FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                    MappedByteBuffer map = fileChannel.map(mapMode, 0L, length > 0 ? length : PAGE_SIZE);
                    fastKV.aBuffer = map;
                    ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                    map.order(byteOrder);
                    MappedByteBuffer map2 = fastKV.bChannel.map(mapMode, 0L, length2 > 0 ? length2 : PAGE_SIZE);
                    fastKV.bBuffer = map2;
                    map2.order(byteOrder);
                    fastKV.fastBuffer = new p(fastKV.aBuffer.capacity());
                    if (length == 0 && length2 == 0) {
                        fastKV.dataEnd = 12;
                        return;
                    }
                    int i11 = fastKV.aBuffer.getInt();
                    long j11 = fastKV.aBuffer.getLong();
                    int i12 = fastKV.bBuffer.getInt();
                    long j12 = fastKV.bBuffer.getLong();
                    if (i11 >= 0) {
                        if (i11 <= length - 12) {
                            fastKV = this;
                            fastKV.dataEnd = i11 + 12;
                            fastKV.aBuffer.rewind();
                            fastKV.aBuffer.get(fastKV.fastBuffer.f45080a, 0, fastKV.dataEnd);
                            if (j11 == fastKV.fastBuffer.a(12, i11) && parseData() == 0) {
                                fastKV.checksum = j11;
                                if (length == length2 && isABFileEqual()) {
                                    return;
                                }
                                fastKV.warning(new Exception("B file error"));
                                fastKV.copyBuffer(fastKV.aBuffer, fastKV.bBuffer, fastKV.dataEnd);
                                return;
                            }
                        } else {
                            fastKV = this;
                        }
                    }
                    if (i12 >= 0 && i12 <= length2 - 12) {
                        fastKV.data.clear();
                        clearInvalid();
                        fastKV.dataEnd = i12 + 12;
                        if (fastKV.fastBuffer.f45080a.length != fastKV.bBuffer.capacity()) {
                            fastKV.fastBuffer = new p(fastKV.bBuffer.capacity());
                        }
                        fastKV.bBuffer.rewind();
                        fastKV.bBuffer.get(fastKV.fastBuffer.f45080a, 0, fastKV.dataEnd);
                        if (j12 == fastKV.fastBuffer.a(12, i12) && parseData() == 0) {
                            fastKV.warning(new Exception("A file error"));
                            fastKV.copyBuffer(fastKV.bBuffer, fastKV.aBuffer, fastKV.dataEnd);
                            fastKV.checksum = j12;
                            return;
                        }
                    }
                    fastKV.error(BOTH_FILES_ERROR);
                    resetData();
                    return;
                } catch (IOException e11) {
                    fastKV.error(e11);
                    toBlockingMode();
                    fastKV.tryBlockingIO(file, file2);
                    return;
                }
            }
            fastKV.error(new Exception(OPEN_FILE_FAILED));
            toBlockingMode();
        } catch (Exception e12) {
            fastKV.error(e12);
            clearData();
            toBlockingMode();
        }
    }

    private boolean loadFromCFile() {
        File file = new File(this.path, this.name + C_SUFFIX);
        File file2 = new File(this.path, this.name + TEMP_SUFFIX);
        boolean z11 = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                }
                if (this.writingMode != 0) {
                    return false;
                }
                if (!writeToABFile(this.fastBuffer)) {
                    this.writingMode = 1;
                    return false;
                }
                info("recover from c file");
                try {
                    deleteCFiles();
                    return true;
                } catch (Exception e11) {
                    e = e11;
                    z11 = true;
                    error(e);
                    return z11;
                }
            }
            if (this.writingMode == 0) {
                return false;
            }
            File file3 = new File(this.path, this.name + A_SUFFIX);
            File file4 = new File(this.path, this.name + B_SUFFIX);
            if (!file3.exists() || !file4.exists()) {
                return false;
            }
            tryBlockingIO(file3, file4);
            return false;
        } catch (Exception e12) {
            e = e12;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i11 = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i11);
            p pVar = this.fastBuffer;
            if (pVar == null || pVar.f45080a.length != newCapacity) {
                pVar = new p(new byte[newCapacity]);
                this.fastBuffer = pVar;
            } else {
                pVar.f45081b = 0;
            }
            ap.a(file, pVar.f45080a, i11);
            int iC = pVar.c();
            long jB = pVar.b();
            this.dataEnd = iC + 12;
            if (iC >= 0 && iC <= i11 - 12 && jB == pVar.a(12, iC) && parseData() == 0) {
                this.checksum = jB;
                return true;
            }
        }
        return false;
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            int i11 = size - 1;
            c cVar2 = this.invalids.get(i11);
            if (cVar.f44926b == cVar2.f44925a) {
                cVar2.f44925a = cVar.f44925a;
                this.invalids.remove(size);
            }
            cVar = cVar2;
            size = i11;
        }
    }

    private int parseData() {
        Object objA;
        p pVar = this.fastBuffer;
        pVar.f45081b = 12;
        while (true) {
            try {
                int i11 = pVar.f45081b;
                int i12 = this.dataEnd;
                if (i11 >= i12) {
                    if (i11 == i12) {
                        return 0;
                    }
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
                byte bA = pVar.a();
                byte b11 = (byte) (bA & Utf8.REPLACEMENT_BYTE);
                boolean z11 = true;
                if (b11 < 1 || b11 > 8) {
                    throw new Exception(PARSE_DATA_FAILED);
                }
                int iA = pVar.a() & 255;
                if (bA < 0) {
                    pVar.f45081b += iA;
                    int iD = b11 <= 5 ? TYPE_SIZE[b11] : pVar.d() & 65535;
                    p pVar2 = this.fastBuffer;
                    int i13 = pVar2.f45081b + iD;
                    pVar2.f45081b = i13;
                    countInvalid(i11, i13);
                } else {
                    String strA = pVar.a(iA);
                    int i14 = pVar.f45081b;
                    if (b11 > 5) {
                        int iD2 = 65535 & pVar.d();
                        if ((bA & 64) == 0) {
                            z11 = false;
                        }
                        checkValueSize(iD2, z11);
                        if (b11 == 6) {
                            this.data.put(strA, new f.i(i11, i14 + 2, pVar.a(iD2), iD2, z11));
                        } else if (b11 == 7) {
                            if (z11) {
                                objA = pVar.a(iD2);
                            } else {
                                objA = new byte[iD2];
                                System.arraycopy(pVar.f45080a, pVar.f45081b, objA, 0, iD2);
                                pVar.f45081b += iD2;
                            }
                            this.data.put(strA, new f.a(i11, i14 + 2, objA, iD2, z11));
                        } else if (z11) {
                            this.data.put(strA, new f.h(i11, i14 + 2, pVar.a(iD2), iD2, true));
                        } else {
                            int iA2 = pVar.a() & 255;
                            String strA2 = pVar.a(iA2);
                            a aVar = this.encoderMap.get(strA2);
                            int i15 = iD2 - (iA2 + 1);
                            if (i15 < 0) {
                                throw new Exception(PARSE_DATA_FAILED);
                            }
                            if (aVar != null) {
                                try {
                                    Object objA2 = aVar.a(pVar.f45080a, pVar.f45081b, i15);
                                    if (objA2 != null) {
                                        this.data.put(strA, new f.h(i11, i14 + 2, objA2, iD2, false));
                                    }
                                } catch (Exception e11) {
                                    error(e11);
                                }
                            } else {
                                error("object with tag: " + strA2 + " without encoder");
                            }
                            pVar.f45081b += i15;
                        }
                    } else if (b11 == 1) {
                        this.data.put(strA, new f.c(i14, pVar.a() == 1));
                    } else if (b11 == 2) {
                        this.data.put(strA, new f.C0495f(i14, pVar.c()));
                    } else if (b11 == 3) {
                        this.data.put(strA, new f.e(i14, Float.intBitsToFloat(pVar.c())));
                    } else if (b11 != 4) {
                        this.data.put(strA, new f.d(i14, Double.longBitsToDouble(pVar.b())));
                    } else {
                        this.data.put(strA, new f.g(i14, pVar.b()));
                    }
                }
            } catch (Exception e12) {
                warning(e12);
                return -1;
            }
        }
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i11 = this.dataEnd;
        this.updateStart = i11;
        this.dataEnd = this.updateSize + i11;
        this.fastBuffer.f45081b = i11;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i11) {
        this.fastBuffer.a((byte) i11);
        if (i11 != str.length()) {
            this.fastBuffer.b(str);
            return;
        }
        p pVar = this.fastBuffer;
        str.getBytes(0, i11, pVar.f45080a, pVar.f45081b);
        this.fastBuffer.f45081b += i11;
    }

    private void putStringValue(String str, int i11) {
        this.fastBuffer.a((short) i11);
        if (i11 != str.length()) {
            this.fastBuffer.b(str);
        } else {
            p pVar = this.fastBuffer;
            str.getBytes(0, i11, pVar.f45080a, pVar.f45081b);
        }
    }

    private void remove(byte b11, int i11, int i12) {
        countInvalid(i11, i12);
        byte b12 = (byte) (b11 | (-128));
        byte[] bArr = this.fastBuffer.f45080a;
        this.checksum = ((((long) (bArr[i11] ^ b12)) & 255) << ((i11 & 7) << 3)) ^ this.checksum;
        bArr[i11] = b12;
        this.removeStart = i11;
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int iCapacity = mappedByteBuffer.capacity();
        int i11 = PAGE_SIZE;
        if (iCapacity != i11) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate(i11);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, i11);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0L);
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        ap.a(new File(this.path + this.name));
    }

    private int saveArray(String str, byte[] bArr, byte b11) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b11);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String strB = ap.b();
        if (!ap.a(new File(this.path + this.name, strB), bArr)) {
            error("save large value failed");
            return 0;
        }
        this.tempExternalName = strB;
        byte[] bArr2 = new byte[32];
        strB.getBytes(0, 32, bArr2, 0);
        return wrapArray(str, bArr2, (byte) (b11 | 64));
    }

    private long shiftCheckSum(long j11, int i11) {
        int i12 = (i11 & 7) << 3;
        return (j11 >>> (64 - i12)) | (j11 << i12);
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i11 = this.removeStart;
        if (i11 != 0) {
            mappedByteBuffer.put(i11, this.fastBuffer.f45080a[i11]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.f45080a, this.updateStart, this.updateSize);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        ap.a(this.aChannel);
        ap.a(this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void truncate(int i11) {
        int i12 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i12, i11 + i12);
        byte[] bArr = this.fastBuffer.f45080a;
        if (newCapacity >= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[newCapacity];
        System.arraycopy(bArr, 0, bArr2, 0, this.dataEnd);
        this.fastBuffer.f45080a = bArr2;
        if (this.writingMode == 0) {
            try {
                long j11 = newCapacity;
                this.aChannel.truncate(j11);
                FileChannel fileChannel = this.aChannel;
                FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
                MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
                this.aBuffer = map;
                ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
                map.order(byteOrder);
                this.bChannel.truncate(j11);
                MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
                this.bBuffer = map2;
                map2.order(byteOrder);
            } catch (IOException e11) {
                error(new Exception(MAP_FAILED, e11));
                toBlockingMode();
            }
        }
        info(TRUNCATE_FINISH);
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e11) {
            warning(e11);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e12) {
            warning(e12);
        }
        clearData();
    }

    private void updateBoolean(byte b11, int i11) {
        long jShiftCheckSum = this.checksum ^ shiftCheckSum(1L, i11);
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.put(i11, b11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i11, b11);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.f45080a[i11] = b11;
    }

    private void updateBytes(int i11, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.a(i11, length);
        p pVar = this.fastBuffer;
        pVar.f45081b = i11;
        pVar.a(bArr);
        long jA = this.checksum ^ this.fastBuffer.a(i11, length);
        this.checksum = jA;
        if (this.writingMode != 0) {
            this.fastBuffer.a(4, jA);
            return;
        }
        this.aBuffer.putInt(0, -1);
        this.aBuffer.putLong(4, this.checksum);
        this.aBuffer.position(i11);
        this.aBuffer.put(bArr);
        this.aBuffer.putInt(0, this.dataEnd - 12);
        this.bBuffer.putLong(4, this.checksum);
        this.bBuffer.position(i11);
        this.bBuffer.put(bArr);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.a(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.b(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void updateInt32(int i11, long j11, int i12) {
        long jShiftCheckSum = shiftCheckSum(j11, i12) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putInt(i12, i11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i12, i11);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.b(i12, i11);
    }

    private void updateInt64(long j11, long j12, int i11) {
        long jShiftCheckSum = shiftCheckSum(j12, i11) ^ this.checksum;
        this.checksum = jShiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, jShiftCheckSum);
            this.aBuffer.putLong(i11, j11);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i11, j11);
        } else {
            this.fastBuffer.a(4, jShiftCheckSum);
        }
        this.fastBuffer.a(i11, j11);
    }

    private void updateObject(String str, Object obj, byte[] bArr, f.j jVar) {
        int iSaveArray = saveArray(str, bArr, jVar.a());
        if (iSaveArray != 0) {
            String str2 = jVar.f45063b ? (String) jVar.f45065d : null;
            remove(jVar.a(), jVar.f45064c, jVar.f45057a + jVar.f45066e);
            String str3 = this.tempExternalName;
            boolean z11 = str3 != null;
            jVar.f45064c = this.updateStart;
            jVar.f45057a = iSaveArray;
            jVar.f45063b = z11;
            if (z11) {
                jVar.f45065d = str3;
                jVar.f45066e = 32;
                this.tempExternalName = null;
            } else {
                jVar.f45065d = obj;
                jVar.f45066e = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                ap.a(new File(this.path + this.name, str2));
            }
        }
    }

    private void updateOffset(int i11, int[] iArr) {
        for (f.b bVar : this.data.values()) {
            int i12 = bVar.f45057a;
            if (i12 > i11) {
                int length = (iArr.length >> 1) - 1;
                int i13 = 0;
                while (i13 <= length) {
                    int i14 = (i13 + length) >>> 1;
                    int i15 = iArr[i14 << 1];
                    if (i15 >= i12) {
                        if (i15 <= i12) {
                            length = i14;
                            break;
                        }
                        length = i14 - 1;
                    } else {
                        i13 = i14 + 1;
                    }
                }
                int i16 = iArr[(length << 1) + 1];
                bVar.f45057a -= i16;
                if (bVar.a() >= 6) {
                    ((f.j) bVar).f45064c -= i16;
                }
            }
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    private int wrapArray(String str, byte[] bArr, byte b11) {
        wrapHeader(str, b11, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        p pVar = this.fastBuffer;
        int i11 = pVar.f45081b;
        pVar.a(bArr);
        return i11;
    }

    private void wrapHeader(String str, byte b11) {
        wrapHeader(str, b11, TYPE_SIZE[b11]);
    }

    private void wrapHeader(String str, byte b11, int i11) {
        int iA = p.a(str);
        checkKeySize(iA);
        this.updateSize = iA + 2 + i11;
        preparePutBytes();
        this.fastBuffer.a(b11);
        putKey(str, iA);
    }

    private boolean writeToABFile(p pVar) {
        int length = pVar.f45080a.length;
        File file = new File(this.path, this.name + A_SUFFIX);
        File file2 = new File(this.path, this.name + B_SUFFIX);
        try {
            if (!ap.c(file) || !ap.c(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j11 = length;
            randomAccessFile.setLength(j11);
            randomAccessFile2.setLength(j11);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            FileChannel fileChannel = this.aChannel;
            FileChannel.MapMode mapMode = FileChannel.MapMode.READ_WRITE;
            MappedByteBuffer map = fileChannel.map(mapMode, 0L, j11);
            this.aBuffer = map;
            ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
            map.order(byteOrder);
            MappedByteBuffer map2 = this.bChannel.map(mapMode, 0L, j11);
            this.bBuffer = map2;
            map2.order(byteOrder);
            this.aBuffer.put(pVar.f45080a, 0, this.dataEnd);
            this.bBuffer.put(pVar.f45080a, 0, this.dataEnd);
            return true;
        } catch (Exception e11) {
            error(e11);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            try {
                File file = new File(this.path, this.name + TEMP_SUFFIX);
                if (ap.c(file)) {
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.setLength(this.dataEnd);
                    randomAccessFile.write(this.fastBuffer.f45080a, 0, this.dataEnd);
                    randomAccessFile.close();
                    File file2 = new File(this.path, this.name + C_SUFFIX);
                    if (!file2.exists() || file2.delete()) {
                        if (file.renameTo(file2)) {
                            return true;
                        }
                        warning(new Exception("rename failed"));
                    }
                }
            } catch (Exception e11) {
                error(e11);
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    public void gc(int i11) {
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i12 = cVar.f44926b;
        int i13 = this.dataEnd;
        int i14 = i13 - this.invalidBytes;
        int i15 = i14 - 12;
        int i16 = i14 - i12;
        int i17 = i13 - i12;
        boolean z11 = i15 < i17 + i16;
        if (!z11) {
            this.checksum ^= this.fastBuffer.a(i12, i17);
        }
        int size = this.invalids.size();
        int i18 = size - 1;
        int i19 = this.dataEnd - this.invalids.get(i18).f44925a;
        int[] iArr = new int[(i19 > 0 ? size : i18) << 1];
        int i21 = cVar.f44926b;
        int i22 = cVar.f44925a;
        for (int i23 = 1; i23 < size; i23++) {
            c cVar2 = this.invalids.get(i23);
            int i24 = cVar2.f44926b - i22;
            byte[] bArr = this.fastBuffer.f45080a;
            System.arraycopy(bArr, i22, bArr, i21, i24);
            int i25 = (i23 - 1) << 1;
            iArr[i25] = i22;
            iArr[i25 + 1] = i22 - i21;
            i21 += i24;
            i22 = cVar2.f44925a;
        }
        if (i19 > 0) {
            byte[] bArr2 = this.fastBuffer.f45080a;
            System.arraycopy(bArr2, i22, bArr2, i21, i19);
            int i26 = i18 << 1;
            iArr[i26] = i22;
            iArr[i26 + 1] = i22 - i21;
        }
        clearInvalid();
        if (z11) {
            this.checksum = this.fastBuffer.a(12, i15);
        } else {
            this.checksum ^= this.fastBuffer.a(i12, i16);
        }
        this.dataEnd = i14;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i12);
            this.aBuffer.put(this.fastBuffer.f45080a, i12, i16);
            this.aBuffer.putInt(0, i15);
            this.bBuffer.putInt(0, i15);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i12);
            this.bBuffer.put(this.fastBuffer.f45080a, i12, i16);
        } else {
            this.fastBuffer.b(0, i15);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i12, iArr);
        int i27 = i14 + i11;
        if (this.fastBuffer.f45080a.length - i27 > TRUNCATE_THRESHOLD) {
            truncate(i27);
        }
        info(GC_FINISH);
    }

    public synchronized Map<String, Object> getAll() {
        Object objValueOf;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap map = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry<String, f.b> entry : this.data.entrySet()) {
            String key = entry.getKey();
            f.b value = entry.getValue();
            switch (value.a()) {
                case 1:
                    objValueOf = Boolean.valueOf(((f.c) value).f45058b);
                    break;
                case 2:
                    objValueOf = Integer.valueOf(((f.C0495f) value).f45061b);
                    break;
                case 3:
                    objValueOf = Float.valueOf(((f.e) value).f45060b);
                    break;
                case 4:
                    objValueOf = Long.valueOf(((f.g) value).f45062b);
                    break;
                case 5:
                    objValueOf = Double.valueOf(((f.d) value).f45059b);
                    break;
                case 6:
                    f.i iVar = (f.i) value;
                    objValueOf = iVar.f45063b ? getStringFromFile(iVar) : iVar.f45065d;
                    break;
                case 7:
                    f.a aVar = (f.a) value;
                    objValueOf = aVar.f45063b ? getArrayFromFile(aVar) : aVar.f45065d;
                    break;
                case 8:
                    f.h hVar = (f.h) value;
                    objValueOf = hVar.f45063b ? getObjectFromFile(hVar) : ((f.h) value).f45065d;
                    break;
                default:
                    objValueOf = null;
                    break;
            }
            map.put(key, objValueOf);
        }
        return map;
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    public synchronized byte[] getArray(String str, byte[] bArr) {
        try {
            f.a aVar = (f.a) this.data.get(str);
            if (aVar != null) {
                return aVar.f45063b ? getArrayFromFile(aVar) : (byte[]) aVar.f45065d;
            }
            return bArr;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public synchronized boolean getBoolean(String str, boolean z11) {
        f.c cVar = (f.c) this.data.get(str);
        if (cVar != null) {
            z11 = cVar.f45058b;
        }
        return z11;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public synchronized double getDouble(String str, double d11) {
        f.d dVar = (f.d) this.data.get(str);
        if (dVar != null) {
            d11 = dVar.f45059b;
        }
        return d11;
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public synchronized float getFloat(String str, float f11) {
        f.e eVar = (f.e) this.data.get(str);
        if (eVar != null) {
            f11 = eVar.f45060b;
        }
        return f11;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized int getInt(String str, int i11) {
        f.C0495f c0495f = (f.C0495f) this.data.get(str);
        if (c0495f != null) {
            i11 = c0495f.f45061b;
        }
        return i11;
    }

    public synchronized long getLong(String str) {
        f.g gVar;
        gVar = (f.g) this.data.get(str);
        return gVar == null ? 0L : gVar.f45062b;
    }

    public synchronized long getLong(String str, long j11) {
        f.g gVar = (f.g) this.data.get(str);
        if (gVar != null) {
            j11 = gVar.f45062b;
        }
        return j11;
    }

    public synchronized <T> T getObject(String str) {
        try {
            f.h hVar = (f.h) this.data.get(str);
            if (hVar != null) {
                return hVar.f45063b ? (T) getObjectFromFile(hVar) : (T) hVar.f45065d;
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public String getString(String str) {
        return getString(str, "");
    }

    public synchronized String getString(String str, String str2) {
        try {
            f.i iVar = (f.i) this.data.get(str);
            if (iVar != null) {
                return iVar.f45063b ? getStringFromFile(iVar) : (String) iVar.f45065d;
            }
            return str2;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, null);
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && !key.isEmpty()) {
                    if (value instanceof String) {
                        putString(key, (String) value);
                    } else if (value instanceof Boolean) {
                        putBoolean(key, ((Boolean) value).booleanValue());
                    } else if (value instanceof Integer) {
                        putInt(key, ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        putLong(key, ((Long) value).longValue());
                    } else if (value instanceof Float) {
                        putFloat(key, ((Float) value).floatValue());
                    } else if (value instanceof Double) {
                        putDouble(key, ((Double) value).doubleValue());
                    } else if (value instanceof Set) {
                        Set set = (Set) value;
                        if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                            putStringSet(key, (Set) value);
                        }
                    } else if (value instanceof byte[]) {
                        putArray(key, (byte[]) value);
                    } else if (map2 != null) {
                        a aVar = map2.get(value.getClass());
                        if (aVar != null) {
                            putObject(key, value, aVar);
                        } else {
                            warning(new Exception("missing encoder for type:" + value.getClass()));
                        }
                    } else {
                        warning(new Exception("missing encoders"));
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putArray(String str, byte[] bArr) {
        try {
            checkKey(str);
            if (bArr == null) {
                remove(str);
            } else {
                addOrUpdate(str, bArr, bArr, (f.a) this.data.get(str), (byte) 7);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putBoolean(String str, boolean z11) {
        try {
            checkKey(str);
            f.c cVar = (f.c) this.data.get(str);
            if (cVar == null) {
                wrapHeader(str, (byte) 1);
                p pVar = this.fastBuffer;
                int i11 = pVar.f45081b;
                pVar.a(z11 ? (byte) 1 : (byte) 0);
                updateChange();
                this.data.put(str, new f.c(i11, z11));
                checkIfCommit();
            } else if (cVar.f45058b != z11) {
                cVar.f45058b = z11;
                updateBoolean(z11 ? (byte) 1 : (byte) 0, cVar.f45057a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putDouble(String str, double d11) {
        try {
            checkKey(str);
            f.d dVar = (f.d) this.data.get(str);
            if (dVar == null) {
                wrapHeader(str, (byte) 5);
                p pVar = this.fastBuffer;
                int i11 = pVar.f45081b;
                pVar.a(Double.doubleToRawLongBits(d11));
                updateChange();
                this.data.put(str, new f.d(i11, d11));
                checkIfCommit();
            } else if (dVar.f45059b != d11) {
                long jDoubleToRawLongBits = Double.doubleToRawLongBits(d11);
                long jDoubleToRawLongBits2 = Double.doubleToRawLongBits(dVar.f45059b) ^ jDoubleToRawLongBits;
                dVar.f45059b = d11;
                updateInt64(jDoubleToRawLongBits, jDoubleToRawLongBits2, dVar.f45057a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putFloat(String str, float f11) {
        try {
            checkKey(str);
            f.e eVar = (f.e) this.data.get(str);
            if (eVar == null) {
                wrapHeader(str, (byte) 3);
                p pVar = this.fastBuffer;
                int i11 = pVar.f45081b;
                pVar.b(Float.floatToRawIntBits(f11));
                updateChange();
                this.data.put(str, new f.e(i11, f11));
                checkIfCommit();
            } else if (eVar.f45060b != f11) {
                int iFloatToRawIntBits = Float.floatToRawIntBits(f11);
                long jFloatToRawIntBits = ((long) (Float.floatToRawIntBits(eVar.f45060b) ^ iFloatToRawIntBits)) & 4294967295L;
                eVar.f45060b = f11;
                updateInt32(iFloatToRawIntBits, jFloatToRawIntBits, eVar.f45057a);
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putInt(String str, int i11) {
        try {
            checkKey(str);
            f.C0495f c0495f = (f.C0495f) this.data.get(str);
            if (c0495f == null) {
                wrapHeader(str, (byte) 2);
                p pVar = this.fastBuffer;
                int i12 = pVar.f45081b;
                pVar.b(i11);
                updateChange();
                this.data.put(str, new f.C0495f(i12, i11));
                checkIfCommit();
            } else {
                int i13 = c0495f.f45061b;
                if (i13 != i11) {
                    c0495f.f45061b = i11;
                    updateInt32(i11, ((long) (i13 ^ i11)) & 4294967295L, c0495f.f45057a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putLong(String str, long j11) {
        try {
            checkKey(str);
            f.g gVar = (f.g) this.data.get(str);
            if (gVar == null) {
                wrapHeader(str, (byte) 4);
                p pVar = this.fastBuffer;
                int i11 = pVar.f45081b;
                pVar.a(j11);
                updateChange();
                this.data.put(str, new f.g(i11, j11));
                checkIfCommit();
            } else {
                long j12 = gVar.f45062b;
                if (j12 != j11) {
                    gVar.f45062b = j11;
                    updateInt64(j11, j11 ^ j12, gVar.f45057a);
                    checkIfCommit();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized <T> void putObject(String str, T t11, a<T> aVar) {
        byte[] bArrA;
        checkKey(str);
        if (aVar == null) {
            throw new IllegalArgumentException("Encoder is null");
        }
        String strA = aVar.a();
        if (strA == null || strA.isEmpty() || strA.length() > 50) {
            throw new IllegalArgumentException("Invalid encoder tag:" + strA);
        }
        if (!this.encoderMap.containsKey(strA)) {
            throw new IllegalArgumentException("Encoder hasn't been registered");
        }
        if (t11 == null) {
            remove(str);
            return;
        }
        try {
            bArrA = aVar.a(t11);
        } catch (Exception e11) {
            error(e11);
            bArrA = null;
        }
        if (bArrA == null) {
            remove(str);
            return;
        }
        int iA = p.a(strA);
        p pVar = new p(iA + 1 + bArrA.length);
        pVar.a((byte) iA);
        pVar.b(strA);
        pVar.a(bArrA);
        addOrUpdate(str, t11, pVar.f45080a, (f.h) this.data.get(str), (byte) 8);
    }

    public synchronized void putString(String str, String str2) {
        try {
            checkKey(str);
            if (str2 == null) {
                remove(str);
            } else {
                f.i iVar = (f.i) this.data.get(str);
                if (str2.length() * 3 < 2048) {
                    fastPutString(str, str2, iVar);
                } else {
                    addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), iVar, (byte) 6);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        try {
            if (set == null) {
                remove(str);
            } else {
                putObject(str, set, am.f45015a);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized void remove(String str) {
        try {
            f.b bVar = this.data.get(str);
            if (bVar != null) {
                this.data.remove(str);
                byte bA = bVar.a();
                String str2 = null;
                if (bA <= 5) {
                    int iA = p.a(str);
                    int i11 = bVar.f45057a;
                    remove(bA, i11 - (iA + 2), i11 + TYPE_SIZE[bA]);
                } else {
                    f.j jVar = (f.j) bVar;
                    remove(bA, jVar.f45064c, jVar.f45057a + jVar.f45066e);
                    if (jVar.f45063b) {
                        str2 = (String) jVar.f45065d;
                    }
                }
                byte b11 = (byte) (bA | (-128));
                if (this.writingMode == 0) {
                    this.aBuffer.putLong(4, this.checksum);
                    this.aBuffer.put(this.removeStart, b11);
                    this.bBuffer.putLong(4, this.checksum);
                    this.bBuffer.put(this.removeStart, b11);
                } else {
                    this.fastBuffer.a(4, this.checksum);
                }
                this.removeStart = 0;
                if (str2 != null) {
                    ap.a(new File(this.path + this.name, str2));
                }
                checkGC();
                checkIfCommit();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }
}
