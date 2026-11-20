package com.transsion.publish;

import android.text.TextUtils;
import com.transsion.publish.LinkParseManager;
import com.transsion.publish.api.LinkEntity;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.io.IOException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jsoup.nodes.Document;
import uo.b;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class LinkParseManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f56329a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy<LinkParseManager> f56330b = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.SYNCHRONIZED, new Function0<LinkParseManager>() { // from class: com.transsion.publish.LinkParseManager$Companion$INSTANCE$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final LinkParseManager invoke() {
            return new LinkParseManager();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LinkParseManager a() {
            return (LinkParseManager) LinkParseManager.f56330b.getValue();
        }
    }

    public static final void f(LinkParseManager this$0, String str) {
        Intrinsics.g(this$0, "this$0");
        try {
            this$0.d(str == null ? "" : str, "", str == null ? "" : str, false);
            if (str != null) {
                this$0.g(str);
            }
        } catch (Exception e11) {
            String message = e11.getMessage();
            if (message != null) {
                b.a.f(b.f78622a, "LinkParseManager", message, false, 4, null);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            String str2 = str == null ? "" : str;
            if (str == null) {
                str = "";
            }
            this$0.d(str2, "", str, true);
        }
    }

    public final void c(Runnable runnable) {
        ThreadExecute.f56362b.a().b(runnable);
    }

    public final void d(String str, String str2, String str3, boolean z11) {
        LinkEntity linkEntity = new LinkEntity();
        linkEntity.setTitle(str);
        linkEntity.setCover(str2);
        linkEntity.setUrl(str3);
        linkEntity.setType(4);
        linkEntity.setLoading(z11);
        cw.a aVar = new cw.a();
        aVar.o(4);
        aVar.n(1);
        aVar.p(linkEntity);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    public final void e(final String str) {
        if (TextUtils.isEmpty(str)) {
            zp.b.f82110a.e("Not a valid link");
        } else {
            c(new Runnable() { // from class: bw.a
                @Override // java.lang.Runnable
                public final void run() {
                    LinkParseManager.f(this.f14425a, str);
                }
            });
        }
    }

    public final void g(String str) throws IOException {
        Document document = c30.a.a(str).a(true).get();
        Intrinsics.f(document, "con.get()");
        String strM1 = document.m1();
        Intrinsics.f(strM1, "document.title()");
        b.a.f(b.f78622a, "LinkParseManager", "title:" + strM1, false, 4, null);
        d(strM1, "", str, true);
    }
}
