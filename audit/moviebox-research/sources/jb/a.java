package jb;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.ArrayList;
import java.util.Iterator;
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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class a implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0728a f67972d = new C0728a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f67973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<nc.a> f67974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f67975c;

    /* JADX INFO: renamed from: jb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0728a {
        public C0728a() {
        }

        public /* synthetic */ C0728a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(TmcFragment tmcFragment) {
        Intrinsics.g(tmcFragment, "tmcFragment");
        this.f67974b = new ArrayList<>();
        this.f67973a = tmcFragment.getView();
    }

    public final void a(nc.a listener) {
        Intrinsics.g(listener, "listener");
        this.f67974b.add(listener);
    }

    public final void b() {
        this.f67974b.clear();
        this.f67973a = null;
    }

    public final void c(nc.a listener) {
        Intrinsics.g(listener, "listener");
        this.f67974b.remove(listener);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        try {
            View view = this.f67973a;
            if (view != null) {
                Rect rect = new Rect();
                view.getWindowVisibleDisplayFrame(rect);
                int height = view.getRootView().getHeight();
                int i11 = height - rect.bottom;
                if (i11 != this.f67975c) {
                    this.f67975c = i11;
                    Iterator<nc.a> it = this.f67974b.iterator();
                    while (it.hasNext()) {
                        it.next().onKeyBoardChanged(i11, height);
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g("RootViewGlobalLayoutLis", "Failed to adjust TabBarView", th2);
        }
    }
}
