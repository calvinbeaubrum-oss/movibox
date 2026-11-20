package com.transsnet.downloader.widget;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.noober.background.view.BLView;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$drawable;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import h00.b1;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class FileManagerTabTitleView extends FrameLayout implements h20.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b1 f61351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f61352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f61353c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileManagerTabTitleView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public FileManagerTabTitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileManagerTabTitleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_download_top_tab, this);
        b1 b1VarA = b1.a(this);
        Intrinsics.f(b1VarA, "bind(this)");
        this.f61351a = b1VarA;
        this.f61352b = z2.a.getColor(getContext(), R$color.white_80);
        this.f61353c = z2.a.getColor(getContext(), R$color.new_text_05);
    }

    @Override // h20.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f61351a.f65748b.getPaint().getFontMetrics();
        Intrinsics.f(fontMetrics, "viewBinding.tvTitle.paint.getFontMetrics()");
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.b
    public int getContentLeft() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(this.f61351a.f65748b.getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(this.f61351a.f65748b.getText().toString(), 0);
            if (listSplit.isEmpty()) {
                listL = kotlin.collections.g.l();
                break;
            }
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = kotlin.collections.g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            string = "";
            for (String str : (String[]) listL.toArray(new String[0])) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = this.f61351a.f65748b.getText().toString();
        }
        this.f61351a.f65748b.getPaint().getTextBounds(string, 0, string.length(), rect);
        return (getLeft() + (getWidth() / 2)) - (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentRight() {
        String string;
        List listL;
        Rect rect = new Rect();
        if (StringsKt__StringsKt.Q(this.f61351a.f65748b.getText().toString(), "\n", false, 2, null)) {
            List<String> listSplit = new Regex("\\n").split(this.f61351a.f65748b.getText().toString(), 0);
            if (listSplit.isEmpty()) {
                listL = kotlin.collections.g.l();
                break;
            }
            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    listL = kotlin.collections.g.l();
                    break;
                }
                if (listIterator.previous().length() != 0) {
                    listL = CollectionsKt___CollectionsKt.F0(listSplit, listIterator.nextIndex() + 1);
                    break;
                }
            }
            string = "";
            for (String str : (String[]) listL.toArray(new String[0])) {
                if (str.length() > string.length()) {
                    string = str;
                }
            }
        } else {
            string = this.f61351a.f65748b.getText().toString();
        }
        this.f61351a.f65748b.getPaint().getTextBounds(string, 0, string.length(), rect);
        return getLeft() + (getWidth() / 2) + (rect.width() / 2);
    }

    @Override // h20.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f61351a.f65748b.getPaint().getFontMetrics();
        Intrinsics.f(fontMetrics, "viewBinding.tvTitle.paint.getFontMetrics()");
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2));
    }

    @Override // h20.d
    public void onDeselected(int i11, int i12) {
        this.f61351a.f65748b.setTextColor(this.f61352b);
        this.f61351a.f65748b.setBackgroundResource(R$drawable.bg_shape_download_tab_unselected);
        TnTextView tnTextView = this.f61351a.f65748b;
        Context context = getContext();
        Intrinsics.f(context, "context");
        tnTextView.setTypeface(so.a.d(context));
    }

    @Override // h20.d
    public void onEnter(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onLeave(int i11, int i12, float f11, boolean z11) {
    }

    @Override // h20.d
    public void onSelected(int i11, int i12) {
        this.f61351a.f65748b.setTextColor(this.f61353c);
        this.f61351a.f65748b.setBackgroundResource(R$drawable.bg_shape_download_tab_selected);
        TnTextView tnTextView = this.f61351a.f65748b;
        Context context = getContext();
        Intrinsics.f(context, "context");
        tnTextView.setTypeface(so.a.a(context));
    }

    public final void setDotVisibility(boolean z11) {
        BLView bLView = this.f61351a.f65749c;
        Intrinsics.f(bLView, "viewBinding.vDot");
        bLView.setVisibility(z11 ? 0 : 8);
    }

    public final void setTitle(final String title) {
        Intrinsics.g(title, "title");
        this.f61351a.f65748b.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.widget.FileManagerTabTitleView.setTitle.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CharSequence invoke() {
                return title;
            }
        });
    }

    public final void setTitle(final String title, int i11, int i12) {
        final String str;
        Intrinsics.g(title, "title");
        if (i11 > 0) {
            str = " " + i11;
        } else {
            str = "";
        }
        if (i12 == 1) {
            this.f61351a.f65748b.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.widget.FileManagerTabTitleView.setTitle.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return FileManagerTabTitleView.this.getContext().getString(R$string.downloading_Local_files) + str;
                }
            });
        } else if (i12 != 2) {
            this.f61351a.f65748b.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.widget.FileManagerTabTitleView.setTitle.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return title;
                }
            });
        } else {
            this.f61351a.f65748b.setTextAction(new Function0<CharSequence>() { // from class: com.transsnet.downloader.widget.FileManagerTabTitleView.setTitle.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final CharSequence invoke() {
                    return FileManagerTabTitleView.this.getContext().getString(R$string.download_transfer_tab_received) + str;
                }
            });
        }
    }
}
