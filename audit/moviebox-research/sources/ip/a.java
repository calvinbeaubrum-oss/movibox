package ip;

import com.tencent.mmkv.MMKV;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0714a f67589a = new C0714a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static MMKV f67590b = rp.a.f75671a.a();

    /* JADX INFO: renamed from: ip.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0714a {
        public C0714a() {
        }

        public /* synthetic */ C0714a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            MMKV mmkvC = c();
            String string = mmkvC != null ? mmkvC.getString("install_ch", "") : null;
            return string == null ? "" : string;
        }

        public final String b() {
            MMKV mmkvC = c();
            String string = mmkvC != null ? mmkvC.getString("install_id", "") : null;
            return string == null ? "" : string;
        }

        public final MMKV c() {
            return a.f67590b;
        }

        public final String d() {
            MMKV mmkvC = c();
            String string = mmkvC != null ? mmkvC.getString("install_share_uid", "") : null;
            return string == null ? "" : string;
        }

        public final void e(String v11) {
            Intrinsics.g(v11, "v");
            MMKV mmkvC = c();
            if (mmkvC != null) {
                mmkvC.putString("install_ch", v11);
            }
        }

        public final void f(String v11) {
            Intrinsics.g(v11, "v");
            MMKV mmkvC = c();
            if (mmkvC != null) {
                mmkvC.putString("install_id", v11);
            }
        }

        public final void g(String uid) {
            Intrinsics.g(uid, "uid");
            MMKV mmkvC = c();
            if (mmkvC != null) {
                mmkvC.putString("install_share_uid", uid);
            }
        }

        public final void h(String userId) {
            Intrinsics.g(userId, "userId");
            MMKV mmkvC = c();
            if (mmkvC != null) {
                mmkvC.putString("myuserid", userId);
            }
        }
    }
}
