package androidx.privacysandbox.ads.adservices.java.topics;

import android.content.Context;
import androidx.annotation.RequiresPermission;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.privacysandbox.ads.adservices.topics.b;
import androidx.privacysandbox.ads.adservices.topics.d;
import com.google.common.util.concurrent.s;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public abstract class TopicsManagerFutures {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12347a = new a(null);

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class Api33Ext4JavaImpl extends TopicsManagerFutures {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final d f12348b;

        public Api33Ext4JavaImpl(d mTopicsManager) {
            Intrinsics.g(mTopicsManager, "mTopicsManager");
            this.f12348b = mTopicsManager;
        }

        @Override // androidx.privacysandbox.ads.adservices.java.topics.TopicsManagerFutures
        @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
        public s<b> b(androidx.privacysandbox.ads.adservices.topics.a request) {
            Intrinsics.g(request, "request");
            return CoroutineAdapterKt.c(j.b(l0.a(w0.c()), null, null, new TopicsManagerFutures$Api33Ext4JavaImpl$getTopicsAsync$1(this, request, null), 3, null), null, 1, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TopicsManagerFutures a(Context context) {
            Intrinsics.g(context, "context");
            d dVarA = d.f12358a.a(context);
            if (dVarA != null) {
                return new Api33Ext4JavaImpl(dVarA);
            }
            return null;
        }
    }

    @JvmStatic
    public static final TopicsManagerFutures a(Context context) {
        return f12347a.a(context);
    }

    @RequiresPermission("android.permission.ACCESS_ADSERVICES_TOPICS")
    public abstract s<b> b(androidx.privacysandbox.ads.adservices.topics.a aVar);
}
