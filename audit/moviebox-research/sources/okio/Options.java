package okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.collections.d;
import kotlin.collections.g;
import kotlin.collections.j;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final ByteString[] byteStrings;
    private final int[] trie;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void buildTrieRecursive(long j11, Buffer buffer, int i11, List<? extends ByteString> list, int i12, int i13, List<Integer> list2) throws IOException {
            int i14;
            int i15;
            int i16;
            int i17 = i11;
            if (!(i12 < i13)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i18 = i12; i18 < i13; i18++) {
                if (!(list.get(i18).size() >= i17)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            ByteString byteString = list.get(i12);
            ByteString byteString2 = list.get(i13 - 1);
            if (i17 == byteString.size()) {
                int iIntValue = list2.get(i12).intValue();
                int i19 = i12 + 1;
                ByteString byteString3 = list.get(i19);
                i14 = i19;
                i15 = iIntValue;
                byteString = byteString3;
            } else {
                i14 = i12;
                i15 = -1;
            }
            if (byteString.getByte(i17) == byteString2.getByte(i17)) {
                int iMin = Math.min(byteString.size(), byteString2.size());
                int i21 = 0;
                for (int i22 = i17; i22 < iMin && byteString.getByte(i22) == byteString2.getByte(i22); i22++) {
                    i21++;
                }
                long intCount = j11 + getIntCount(buffer) + ((long) 2) + ((long) i21) + 1;
                buffer.writeInt(-i21);
                buffer.writeInt(i15);
                int i23 = i17 + i21;
                while (i17 < i23) {
                    buffer.writeInt(byteString.getByte(i17) & 255);
                    i17++;
                }
                if (i14 + 1 == i13) {
                    if (!(i23 == list.get(i14).size())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    buffer.writeInt(list2.get(i14).intValue());
                    return;
                } else {
                    Buffer buffer2 = new Buffer();
                    buffer.writeInt(((int) (getIntCount(buffer2) + intCount)) * (-1));
                    buildTrieRecursive(intCount, buffer2, i23, list, i14, i13, list2);
                    buffer.writeAll(buffer2);
                    return;
                }
            }
            int i24 = 1;
            for (int i25 = i14 + 1; i25 < i13; i25++) {
                if (list.get(i25 - 1).getByte(i17) != list.get(i25).getByte(i17)) {
                    i24++;
                }
            }
            long intCount2 = j11 + getIntCount(buffer) + ((long) 2) + ((long) (i24 * 2));
            buffer.writeInt(i24);
            buffer.writeInt(i15);
            for (int i26 = i14; i26 < i13; i26++) {
                byte b11 = list.get(i26).getByte(i17);
                if (i26 == i14 || b11 != list.get(i26 - 1).getByte(i17)) {
                    buffer.writeInt(b11 & 255);
                }
            }
            Buffer buffer3 = new Buffer();
            while (i14 < i13) {
                byte b12 = list.get(i14).getByte(i17);
                int i27 = i14 + 1;
                int i28 = i27;
                while (true) {
                    if (i28 >= i13) {
                        i16 = i13;
                        break;
                    } else {
                        if (b12 != list.get(i28).getByte(i17)) {
                            i16 = i28;
                            break;
                        }
                        i28++;
                    }
                }
                if (i27 == i16 && i17 + 1 == list.get(i14).size()) {
                    buffer.writeInt(list2.get(i14).intValue());
                } else {
                    buffer.writeInt(((int) (intCount2 + getIntCount(buffer3))) * (-1));
                    buildTrieRecursive(intCount2, buffer3, i17 + 1, list, i14, i16, list2);
                }
                buffer3 = buffer3;
                i14 = i16;
            }
            buffer.writeAll(buffer3);
        }

        public static /* synthetic */ void buildTrieRecursive$default(Companion companion, long j11, Buffer buffer, int i11, List list, int i12, int i13, List list2, int i14, Object obj) throws IOException {
            companion.buildTrieRecursive((i14 & 1) != 0 ? 0L : j11, buffer, (i14 & 4) != 0 ? 0 : i11, list, (i14 & 16) != 0 ? 0 : i12, (i14 & 32) != 0 ? list.size() : i13, list2);
        }

        private final long getIntCount(Buffer buffer) {
            return buffer.size() / ((long) 4);
        }

        @JvmStatic
        public final Options of(ByteString... byteStrings) throws IOException {
            Intrinsics.g(byteStrings, "byteStrings");
            DefaultConstructorMarker defaultConstructorMarker = null;
            int i11 = 0;
            if (byteStrings.length == 0) {
                return new Options(new ByteString[0], new int[]{0, -1}, defaultConstructorMarker);
            }
            List listD0 = d.D0(byteStrings);
            j.y(listD0);
            ArrayList arrayList = new ArrayList(byteStrings.length);
            for (ByteString byteString : byteStrings) {
                arrayList.add(-1);
            }
            Object[] array = arrayList.toArray(new Integer[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            Integer[] numArr = (Integer[]) array;
            List listQ = g.q((Integer[]) Arrays.copyOf(numArr, numArr.length));
            int length = byteStrings.length;
            int i12 = 0;
            int i13 = 0;
            while (i12 < length) {
                listQ.set(g.k(listD0, byteStrings[i12], 0, 0, 6, null), Integer.valueOf(i13));
                i12++;
                i13++;
            }
            if (!(((ByteString) listD0.get(0)).size() > 0)) {
                throw new IllegalArgumentException("the empty byte string is not a supported option".toString());
            }
            int i14 = 0;
            while (i14 < listD0.size()) {
                ByteString byteString2 = (ByteString) listD0.get(i14);
                int i15 = i14 + 1;
                int i16 = i15;
                while (i16 < listD0.size()) {
                    ByteString byteString3 = (ByteString) listD0.get(i16);
                    if (!byteString3.startsWith(byteString2)) {
                        break;
                    }
                    if (!(byteString3.size() != byteString2.size())) {
                        throw new IllegalArgumentException(("duplicate option: " + byteString3).toString());
                    }
                    if (((Number) listQ.get(i16)).intValue() > ((Number) listQ.get(i14)).intValue()) {
                        listD0.remove(i16);
                        listQ.remove(i16);
                    } else {
                        i16++;
                    }
                }
                i14 = i15;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive$default(this, 0L, buffer, 0, listD0, 0, 0, listQ, 53, null);
            int[] iArr = new int[(int) getIntCount(buffer)];
            while (!buffer.exhausted()) {
                iArr[i11] = buffer.readInt();
                i11++;
            }
            Object[] objArrCopyOf = Arrays.copyOf(byteStrings, byteStrings.length);
            Intrinsics.f(objArrCopyOf, "java.util.Arrays.copyOf(this, size)");
            return new Options((ByteString[]) objArrCopyOf, iArr, defaultConstructorMarker);
        }
    }

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public /* synthetic */ Options(ByteString[] byteStringArr, int[] iArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(byteStringArr, iArr);
    }

    @JvmStatic
    public static final Options of(ByteString... byteStringArr) {
        return Companion.of(byteStringArr);
    }

    @Override // kotlin.collections.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof ByteString) {
            return contains((ByteString) obj);
        }
        return false;
    }

    public /* bridge */ boolean contains(ByteString byteString) {
        return super.contains(byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ByteString get(int i11) {
        return this.byteStrings[i11];
    }

    public final ByteString[] getByteStrings$okio() {
        return this.byteStrings;
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.byteStrings.length;
    }

    public final int[] getTrie$okio() {
        return this.trie;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof ByteString) {
            return indexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int indexOf(ByteString byteString) {
        return super.indexOf(byteString);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof ByteString) {
            return lastIndexOf((ByteString) obj);
        }
        return -1;
    }

    public /* bridge */ int lastIndexOf(ByteString byteString) {
        return super.lastIndexOf(byteString);
    }
}
