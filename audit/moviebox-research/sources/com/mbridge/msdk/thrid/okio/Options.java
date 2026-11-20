package com.mbridge.msdk.thrid.okio;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j11, Buffer buffer, int i11, List<ByteString> list, int i12, int i13, List<Integer> list2) {
        int iIntValue;
        int i14;
        int i15;
        int i16;
        if (i12 >= i13) {
            throw new AssertionError();
        }
        for (int i17 = i12; i17 < i13; i17++) {
            if (list.get(i17).size() < i11) {
                throw new AssertionError();
            }
        }
        ByteString byteString = list.get(i12);
        ByteString byteString2 = list.get(i13 - 1);
        if (i11 == byteString.size()) {
            int i18 = i12 + 1;
            i14 = i18;
            iIntValue = list2.get(i12).intValue();
            byteString = list.get(i18);
        } else {
            iIntValue = -1;
            i14 = i12;
        }
        if (byteString.getByte(i11) == byteString2.getByte(i11)) {
            int iMin = Math.min(byteString.size(), byteString2.size());
            int i19 = 0;
            for (int i21 = i11; i21 < iMin && byteString.getByte(i21) == byteString2.getByte(i21); i21++) {
                i19++;
            }
            long jIntCount = 1 + j11 + ((long) intCount(buffer)) + 2 + ((long) i19);
            buffer.writeInt(-i19);
            buffer.writeInt(iIntValue);
            int i22 = i11;
            while (true) {
                i15 = i11 + i19;
                if (i22 >= i15) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i22) & 255);
                i22++;
            }
            if (i14 + 1 == i13) {
                if (i15 != list.get(i14).size()) {
                    throw new AssertionError();
                }
                buffer.writeInt(list2.get(i14).intValue());
                return;
            } else {
                Buffer buffer2 = new Buffer();
                buffer.writeInt((int) ((((long) intCount(buffer2)) + jIntCount) * (-1)));
                buildTrieRecursive(jIntCount, buffer2, i15, list, i14, i13, list2);
                buffer.write(buffer2, buffer2.size());
                return;
            }
        }
        int i23 = 1;
        for (int i24 = i14 + 1; i24 < i13; i24++) {
            if (list.get(i24 - 1).getByte(i11) != list.get(i24).getByte(i11)) {
                i23++;
            }
        }
        long jIntCount2 = j11 + ((long) intCount(buffer)) + 2 + ((long) (i23 * 2));
        buffer.writeInt(i23);
        buffer.writeInt(iIntValue);
        for (int i25 = i14; i25 < i13; i25++) {
            byte b11 = list.get(i25).getByte(i11);
            if (i25 == i14 || b11 != list.get(i25 - 1).getByte(i11)) {
                buffer.writeInt(b11 & 255);
            }
        }
        Buffer buffer3 = new Buffer();
        int i26 = i14;
        while (i26 < i13) {
            byte b12 = list.get(i26).getByte(i11);
            int i27 = i26 + 1;
            int i28 = i27;
            while (true) {
                if (i28 >= i13) {
                    i16 = i13;
                    break;
                } else {
                    if (b12 != list.get(i28).getByte(i11)) {
                        i16 = i28;
                        break;
                    }
                    i28++;
                }
            }
            if (i27 == i16 && i11 + 1 == list.get(i26).size()) {
                buffer.writeInt(list2.get(i26).intValue());
            } else {
                buffer.writeInt((int) ((((long) intCount(buffer3)) + jIntCount2) * (-1)));
                buildTrieRecursive(jIntCount2, buffer3, i11 + 1, list, i26, i16, list2);
            }
            buffer3 = buffer3;
            i26 = i16;
        }
        Buffer buffer4 = buffer3;
        buffer.write(buffer4, buffer4.size());
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            arrayList2.add(-1);
        }
        for (int i12 = 0; i12 < arrayList.size(); i12++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i12]), Integer.valueOf(i12));
        }
        if (((ByteString) arrayList.get(0)).size() == 0) {
            throw new IllegalArgumentException("the empty byte string is not a supported option");
        }
        int i13 = 0;
        while (i13 < arrayList.size()) {
            ByteString byteString = (ByteString) arrayList.get(i13);
            int i14 = i13 + 1;
            int i15 = i14;
            while (i15 < arrayList.size()) {
                ByteString byteString2 = (ByteString) arrayList.get(i15);
                if (!byteString2.startsWith(byteString)) {
                    break;
                }
                if (byteString2.size() == byteString.size()) {
                    throw new IllegalArgumentException("duplicate option: " + byteString2);
                }
                if (((Integer) arrayList2.get(i15)).intValue() > ((Integer) arrayList2.get(i13)).intValue()) {
                    arrayList.remove(i15);
                    arrayList2.remove(i15);
                } else {
                    i15++;
                }
            }
            i13 = i14;
        }
        Buffer buffer = new Buffer();
        buildTrieRecursive(0L, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
        int iIntCount = intCount(buffer);
        int[] iArr = new int[iIntCount];
        for (int i16 = 0; i16 < iIntCount; i16++) {
            iArr[i16] = buffer.readInt();
        }
        if (buffer.exhausted()) {
            return new Options((ByteString[]) byteStringArr.clone(), iArr);
        }
        throw new AssertionError();
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i11) {
        return this.byteStrings[i11];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }
}
