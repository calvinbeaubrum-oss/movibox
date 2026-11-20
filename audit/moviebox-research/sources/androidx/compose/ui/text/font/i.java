package androidx.compose.ui.text.font;

import androidx.compose.runtime.a3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f5821b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j0 f5822c = new f();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final x f5823d = new x(C.SANS_SERIF_NAME, "FontFamily.SansSerif");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x f5824f = new x(C.SERIF_NAME, "FontFamily.Serif");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final x f5825g = new x("monospace", "FontFamily.Monospace");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final x f5826h = new x("cursive", "FontFamily.Cursive");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f5827a;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final j0 a() {
            return i.f5822c;
        }

        public final x b() {
            return i.f5823d;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        a3<Object> a(i iVar, u uVar, int i11, int i12);
    }

    public i(boolean z11) {
        this.f5827a = z11;
    }

    public /* synthetic */ i(boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(z11);
    }
}
