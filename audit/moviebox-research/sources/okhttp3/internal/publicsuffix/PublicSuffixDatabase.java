package okhttp3.internal.publicsuffix;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.f;
import kotlin.collections.g;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;

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
public final class PublicSuffixDatabase {
    private static final char EXCEPTION_MARKER = '!';
    public static final String PUBLIC_SUFFIX_RESOURCE = "publicsuffixes.gz";
    private byte[] publicSuffixExceptionListBytes;
    private byte[] publicSuffixListBytes;
    public static final Companion Companion = new Companion(null);
    private static final byte[] WILDCARD_LABEL = {(byte) 42};
    private static final List<String> PREVAILING_RULE = f.e("*");
    private static final PublicSuffixDatabase instance = new PublicSuffixDatabase();
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String binarySearch(byte[] bArr, byte[][] bArr2, int i11) {
            int i12;
            int iAnd;
            boolean z11;
            int iAnd2;
            int length = bArr.length;
            int i13 = 0;
            while (i13 < length) {
                int i14 = (i13 + length) / 2;
                while (i14 > -1 && bArr[i14] != ((byte) 10)) {
                    i14--;
                }
                int i15 = i14 + 1;
                int i16 = 1;
                while (true) {
                    i12 = i15 + i16;
                    if (bArr[i12] == ((byte) 10)) {
                        break;
                    }
                    i16++;
                }
                int i17 = i12 - i15;
                int i18 = i11;
                boolean z12 = false;
                int i19 = 0;
                int i21 = 0;
                while (true) {
                    if (z12) {
                        iAnd = 46;
                        z11 = false;
                    } else {
                        boolean z13 = z12;
                        iAnd = Util.and(bArr2[i18][i19], 255);
                        z11 = z13;
                    }
                    iAnd2 = iAnd - Util.and(bArr[i15 + i21], 255);
                    if (iAnd2 != 0) {
                        break;
                    }
                    i21++;
                    i19++;
                    if (i21 == i17) {
                        break;
                    }
                    if (bArr2[i18].length != i19) {
                        z12 = z11;
                    } else {
                        if (i18 == bArr2.length - 1) {
                            break;
                        }
                        i18++;
                        z12 = true;
                        i19 = -1;
                    }
                }
                if (iAnd2 >= 0) {
                    if (iAnd2 <= 0) {
                        int i22 = i17 - i21;
                        int length2 = bArr2[i18].length - i19;
                        int length3 = bArr2.length;
                        for (int i23 = i18 + 1; i23 < length3; i23++) {
                            length2 += bArr2[i23].length;
                        }
                        if (length2 >= i22) {
                            if (length2 <= i22) {
                                Charset UTF_8 = StandardCharsets.UTF_8;
                                Intrinsics.f(UTF_8, "UTF_8");
                                return new String(bArr, i15, i17, UTF_8);
                            }
                        }
                    }
                    i13 = i12 + 1;
                }
                length = i14;
            }
            return null;
        }

        public final PublicSuffixDatabase get() {
            return PublicSuffixDatabase.instance;
        }
    }

    /* JADX INFO: renamed from: okhttp3.internal.publicsuffix.PublicSuffixDatabase$findMatchingRule$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0Impl {
        public AnonymousClass1(PublicSuffixDatabase publicSuffixDatabase) {
            super(publicSuffixDatabase, PublicSuffixDatabase.class, "publicSuffixListBytes", "getPublicSuffixListBytes()[B", 0);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
        public Object get() {
            return PublicSuffixDatabase.access$getPublicSuffixListBytes$p((PublicSuffixDatabase) this.receiver);
        }

        @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.jvm.internal.MutablePropertyReference0
        public void set(Object obj) {
            ((PublicSuffixDatabase) this.receiver).publicSuffixListBytes = (byte[]) obj;
        }
    }

    public static final /* synthetic */ byte[] access$getPublicSuffixListBytes$p(PublicSuffixDatabase publicSuffixDatabase) {
        byte[] bArr = publicSuffixDatabase.publicSuffixListBytes;
        if (bArr == null) {
            Intrinsics.y("publicSuffixListBytes");
        }
        return bArr;
    }

    private final List<String> findMatchingRule(List<String> list) {
        String str;
        String strBinarySearch;
        String str2;
        List<String> listL;
        List<String> listL2;
        if (this.listRead.get() || !this.listRead.compareAndSet(false, true)) {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            readTheListUninterruptibly();
        }
        if (!(this.publicSuffixListBytes != null)) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.".toString());
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i11 = 0; i11 < size; i11++) {
            String str3 = list.get(i11);
            Charset UTF_8 = StandardCharsets.UTF_8;
            Intrinsics.f(UTF_8, "UTF_8");
            if (str3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            byte[] bytes = str3.getBytes(UTF_8);
            Intrinsics.f(bytes, "(this as java.lang.String).getBytes(charset)");
            bArr[i11] = bytes;
        }
        int i12 = 0;
        while (true) {
            str = null;
            if (i12 >= size) {
                strBinarySearch = null;
                break;
            }
            Companion companion = Companion;
            byte[] bArr2 = this.publicSuffixListBytes;
            if (bArr2 == null) {
                Intrinsics.y("publicSuffixListBytes");
            }
            strBinarySearch = companion.binarySearch(bArr2, bArr, i12);
            if (strBinarySearch != null) {
                break;
            }
            i12++;
        }
        if (size <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i13 = 0;
        while (true) {
            if (i13 >= length) {
                str2 = null;
                break;
            }
            bArr3[i13] = WILDCARD_LABEL;
            Companion companion2 = Companion;
            byte[] bArr4 = this.publicSuffixListBytes;
            if (bArr4 == null) {
                Intrinsics.y("publicSuffixListBytes");
            }
            String strBinarySearch2 = companion2.binarySearch(bArr4, bArr3, i13);
            if (strBinarySearch2 != null) {
                str2 = strBinarySearch2;
                break;
            }
            i13++;
        }
        if (str2 != null) {
            int i14 = size - 1;
            for (int i15 = 0; i15 < i14; i15++) {
                Companion companion3 = Companion;
                byte[] bArr5 = this.publicSuffixExceptionListBytes;
                if (bArr5 == null) {
                    Intrinsics.y("publicSuffixExceptionListBytes");
                }
                String strBinarySearch3 = companion3.binarySearch(bArr5, bArr, i15);
                if (strBinarySearch3 != null) {
                    str = strBinarySearch3;
                    break;
                }
            }
        }
        if (str != null) {
            return StringsKt__StringsKt.D0(EXCEPTION_MARKER + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (strBinarySearch == null && str2 == null) {
            return PREVAILING_RULE;
        }
        if (strBinarySearch == null || (listL = StringsKt__StringsKt.D0(strBinarySearch, new char[]{'.'}, false, 0, 6, null)) == null) {
            listL = g.l();
        }
        if (str2 == null || (listL2 = StringsKt__StringsKt.D0(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            listL2 = g.l();
        }
        return listL.size() > listL2.size() ? listL : listL2;
    }

    private final void readTheList() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream != null) {
            BufferedSource bufferedSourceBuffer = Okio.buffer(new GzipSource(Okio.source(resourceAsStream)));
            try {
                byte[] byteArray = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
                byte[] byteArray2 = bufferedSourceBuffer.readByteArray(bufferedSourceBuffer.readInt());
                Unit unit = Unit.f68710a;
                CloseableKt.a(bufferedSourceBuffer, null);
                synchronized (this) {
                    Intrinsics.d(byteArray);
                    this.publicSuffixListBytes = byteArray;
                    Intrinsics.d(byteArray2);
                    this.publicSuffixExceptionListBytes = byteArray2;
                }
                this.readCompleteLatch.countDown();
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(bufferedSourceBuffer, th2);
                    throw th3;
                }
            }
        }
    }

    private final void readTheListUninterruptibly() {
        boolean z11 = false;
        while (true) {
            try {
                try {
                    readTheList();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z11 = true;
                } catch (IOException e11) {
                    Platform.Companion.get().log("Failed to read public suffix list", 5, e11);
                    if (z11) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z11) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    private final List<String> splitDomain(String str) {
        List<String> listD0 = StringsKt__StringsKt.D0(str, new char[]{'.'}, false, 0, 6, null);
        return Intrinsics.b((String) CollectionsKt___CollectionsKt.q0(listD0), "") ? CollectionsKt___CollectionsKt.a0(listD0, 1) : listD0;
    }

    public final String getEffectiveTldPlusOne(String domain) {
        int size;
        int size2;
        Intrinsics.g(domain, "domain");
        String unicodeDomain = IDN.toUnicode(domain);
        Intrinsics.f(unicodeDomain, "unicodeDomain");
        List<String> listSplitDomain = splitDomain(unicodeDomain);
        List<String> listFindMatchingRule = findMatchingRule(listSplitDomain);
        if (listSplitDomain.size() == listFindMatchingRule.size() && listFindMatchingRule.get(0).charAt(0) != '!') {
            return null;
        }
        if (listFindMatchingRule.get(0).charAt(0) == '!') {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size();
        } else {
            size = listSplitDomain.size();
            size2 = listFindMatchingRule.size() + 1;
        }
        return SequencesKt___SequencesKt.p(SequencesKt___SequencesKt.i(CollectionsKt___CollectionsKt.V(splitDomain(domain)), size - size2), InstructionFileId.DOT, null, null, 0, null, null, 62, null);
    }

    public final void setListBytes(byte[] publicSuffixListBytes, byte[] publicSuffixExceptionListBytes) {
        Intrinsics.g(publicSuffixListBytes, "publicSuffixListBytes");
        Intrinsics.g(publicSuffixExceptionListBytes, "publicSuffixExceptionListBytes");
        this.publicSuffixListBytes = publicSuffixListBytes;
        this.publicSuffixExceptionListBytes = publicSuffixExceptionListBytes;
        this.listRead.set(true);
        this.readCompleteLatch.countDown();
    }
}
