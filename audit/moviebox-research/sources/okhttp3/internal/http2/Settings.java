package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class Settings {
    public static final int COUNT = 10;
    public static final Companion Companion = new Companion(null);
    public static final int DEFAULT_INITIAL_WINDOW_SIZE = 65535;
    public static final int ENABLE_PUSH = 2;
    public static final int HEADER_TABLE_SIZE = 1;
    public static final int INITIAL_WINDOW_SIZE = 7;
    public static final int MAX_CONCURRENT_STREAMS = 4;
    public static final int MAX_FRAME_SIZE = 5;
    public static final int MAX_HEADER_LIST_SIZE = 6;
    private int set;
    private final int[] values = new int[10];

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void clear() {
        this.set = 0;
        ArraysKt___ArraysJvmKt.v(this.values, 0, 0, 0, 6, null);
    }

    public final int get(int i11) {
        return this.values[i11];
    }

    public final boolean getEnablePush(boolean z11) {
        if ((this.set & 4) != 0) {
            return this.values[2] == 1;
        }
        return z11;
    }

    public final int getHeaderTableSize() {
        if ((this.set & 2) != 0) {
            return this.values[1];
        }
        return -1;
    }

    public final int getInitialWindowSize() {
        return (this.set & 128) != 0 ? this.values[7] : DEFAULT_INITIAL_WINDOW_SIZE;
    }

    public final int getMaxConcurrentStreams() {
        return (this.set & 16) != 0 ? this.values[4] : Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    public final int getMaxFrameSize(int i11) {
        return (this.set & 32) != 0 ? this.values[5] : i11;
    }

    public final int getMaxHeaderListSize(int i11) {
        return (this.set & 64) != 0 ? this.values[6] : i11;
    }

    public final boolean isSet(int i11) {
        return ((1 << i11) & this.set) != 0;
    }

    public final void merge(Settings other) {
        Intrinsics.g(other, "other");
        for (int i11 = 0; i11 < 10; i11++) {
            if (other.isSet(i11)) {
                set(i11, other.get(i11));
            }
        }
    }

    public final Settings set(int i11, int i12) {
        if (i11 >= 0) {
            int[] iArr = this.values;
            if (i11 < iArr.length) {
                this.set = (1 << i11) | this.set;
                iArr[i11] = i12;
            }
        }
        return this;
    }

    public final int size() {
        return Integer.bitCount(this.set);
    }
}
