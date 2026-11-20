package com.transsion.postdetail.util;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import kotlin.Metadata;
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
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f56213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f56214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a f56215c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ViewTreeObserver.OnGlobalLayoutListener f56216d = new b();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface a {
        void a(int i11);

        void b(int i11);
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (h.this.f56213a == null) {
                View view = h.this.f56213a;
                Intrinsics.d(view);
                view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                return;
            }
            Rect rect = new Rect();
            View view2 = h.this.f56213a;
            Intrinsics.d(view2);
            view2.getWindowVisibleDisplayFrame(rect);
            int iHeight = rect.height();
            if (h.this.c() == 0) {
                h.this.e(iHeight);
                return;
            }
            if (h.this.c() == iHeight) {
                return;
            }
            if (h.this.c() - iHeight > 200) {
                if (h.this.f56215c != null) {
                    a aVar = h.this.f56215c;
                    Intrinsics.d(aVar);
                    aVar.b(h.this.c() - iHeight);
                }
                h.this.e(iHeight);
                return;
            }
            if (iHeight - h.this.c() > 200) {
                if (h.this.f56215c != null) {
                    a aVar2 = h.this.f56215c;
                    Intrinsics.d(aVar2);
                    aVar2.a(iHeight - h.this.c());
                }
                h.this.e(iHeight);
            }
        }
    }

    public final int c() {
        return this.f56214b;
    }

    public final void d(Activity activity, a aVar) {
        ViewTreeObserver viewTreeObserver;
        ViewTreeObserver viewTreeObserver2;
        Window window;
        this.f56215c = aVar;
        View decorView = (activity == null || (window = activity.getWindow()) == null) ? null : window.getDecorView();
        this.f56213a = decorView;
        if (aVar == null) {
            if (decorView == null || (viewTreeObserver2 = decorView.getViewTreeObserver()) == null) {
                return;
            }
            viewTreeObserver2.removeOnGlobalLayoutListener(this.f56216d);
            return;
        }
        if (decorView == null || (viewTreeObserver = decorView.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(this.f56216d);
    }

    public final void e(int i11) {
        this.f56214b = i11;
    }
}
