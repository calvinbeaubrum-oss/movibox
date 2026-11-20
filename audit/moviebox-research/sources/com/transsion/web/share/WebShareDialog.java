package com.transsion.web.share;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.i;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baselib.report.h;
import com.transsion.baselib.report.m;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.R$style;
import com.transsion.baseui.dialog.BaseDialog;
import com.transsion.baseui.util.n;
import com.transsion.web.R$id;
import com.transsion.web.R$layout;
import com.transsion.web.R$string;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

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
public final class WebShareDialog extends BaseDialog {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a f60210h = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f60211c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f60212d = "web_share_panel";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f60213f = true;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function3<? super String, ? super String, ? super String, Unit> f60214g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final WebShareDialog a(String jsonObject) {
            Intrinsics.g(jsonObject, "jsonObject");
            WebShareDialog webShareDialog = new WebShareDialog();
            Bundle bundle = new Bundle();
            bundle.putString("json", jsonObject);
            webShareDialog.setArguments(bundle);
            return webShareDialog;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends BaseQuickAdapter<c, BaseViewHolder> {
        public b() {
            super(R$layout.item_share, null, 2, null);
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, c item) {
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            TextView textView = (TextView) holder.getView(R$id.tv_share);
            textView.setText(item.a());
            textView.setCompoundDrawablesWithIntrinsicBounds(0, item.c(), 0, 0);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f60215a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f60216b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f60217c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f60218d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f60219e;

        public c(int i11, @StringRes int i12, String txt, String packageName, String str) {
            Intrinsics.g(txt, "txt");
            Intrinsics.g(packageName, "packageName");
            this.f60215a = i11;
            this.f60216b = i12;
            this.f60217c = txt;
            this.f60218d = packageName;
            this.f60219e = str;
        }

        public /* synthetic */ c(int i11, int i12, String str, String str2, String str3, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this(i11, i12, str, str2, (i13 & 16) != 0 ? null : str3);
        }

        public final int a() {
            return this.f60216b;
        }

        public final String b() {
            return this.f60219e;
        }

        public final int c() {
            return this.f60215a;
        }

        public final String d() {
            return this.f60218d;
        }

        public final String e() {
            return this.f60217c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f60215a == cVar.f60215a && this.f60216b == cVar.f60216b && Intrinsics.b(this.f60217c, cVar.f60217c) && Intrinsics.b(this.f60218d, cVar.f60218d) && Intrinsics.b(this.f60219e, cVar.f60219e);
        }

        public int hashCode() {
            int iHashCode = ((((((this.f60215a * 31) + this.f60216b) * 31) + this.f60217c.hashCode()) * 31) + this.f60218d.hashCode()) * 31;
            String str = this.f60219e;
            return iHashCode + (str == null ? 0 : str.hashCode());
        }

        public String toString() {
            return "ShareItem(iconRes=" + this.f60215a + ", appNameRes=" + this.f60216b + ", txt=" + this.f60217c + ", packageName=" + this.f60218d + ", backPackageName=" + this.f60219e + ")";
        }
    }

    public static final void o0(WebShareDialog this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        this$0.dismiss();
    }

    public static final void p0(List list, WebShareDialog this$0, b this_apply, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(list, "$list");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(this_apply, "$this_apply");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        c cVar = (c) list.get(i11);
        Function3<? super String, ? super String, ? super String, Unit> function3 = this$0.f60214g;
        if (function3 != null) {
            function3.invoke(cVar.d(), cVar.b(), cVar.e());
        }
        HashMap map = new HashMap();
        String string = this_apply.getContext().getString(cVar.a());
        Intrinsics.f(string, "context.getString(item.appNameRes)");
        map.put("module_name", string);
        String str = this$0.f60211c;
        if (str == null) {
            str = "";
        }
        map.put("source", str);
        map.put("dialog_name", this$0.f60212d);
        m.f51277a.m("MbShareDialog", "click", map);
        this$0.dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R$style.BottomDialogTheme);
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        com.google.android.material.bottomsheet.b bVar = new com.google.android.material.bottomsheet.b(contextRequireContext);
        Window window = bVar.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setDimAmount(0.5f);
            WindowManager.LayoutParams attributes = window.getAttributes();
            if (attributes == null) {
                attributes = new WindowManager.LayoutParams();
            } else {
                Intrinsics.f(attributes, "it.attributes ?: WindowManager.LayoutParams()");
            }
            attributes.width = com.transsion.baseui.util.a.f51450a.b(contextRequireContext);
            attributes.height = -2;
            window.setBackgroundDrawable(null);
            window.setAttributes(attributes);
        }
        return bVar;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.g(inflater, "inflater");
        return inflater.inflate(R$layout.dialog_share, viewGroup, false);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        View viewFindViewById;
        HashMap<String, String> mapG;
        Intrinsics.g(view, "view");
        super.onViewCreated(view, bundle);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("json") : null;
        if (TextUtils.isEmpty(string)) {
            string = "{}";
        }
        JSONObject jSONObject = new JSONObject(string);
        String strOptString = jSONObject.optString(CampaignEx.JSON_KEY_TITLE);
        this.f60211c = jSONObject.optString("H5Source");
        h logViewConfig = getLogViewConfig();
        if (logViewConfig != null && (mapG = logViewConfig.g()) != null) {
            String str = this.f60211c;
            if (str == null) {
                str = "";
            }
            mapG.put("source", str);
        }
        if (!this.f60213f && (viewFindViewById = view.findViewById(R$id.ll_title)) != null) {
            viewFindViewById.setVisibility(8);
        }
        TextView textView = (TextView) view.findViewById(R$id.tv_title);
        if (textView != null) {
            textView.setText(strOptString);
        }
        final ArrayList arrayList = new ArrayList();
        String whatsApp = jSONObject.optString("WhatsApp");
        Intrinsics.f(whatsApp, "whatsApp");
        if (whatsApp.length() > 0) {
            arrayList.add(new c(R$mipmap.player_ic_whatsapp, R$string.whatsapp, whatsApp, "com.whatsapp", null, 16, null));
        }
        String telegram = jSONObject.optString("Telegram");
        Intrinsics.f(telegram, "telegram");
        if (telegram.length() > 0) {
            arrayList.add(new c(R$mipmap.player_ic_telegram, R$string.telegram, telegram, "org.telegram.messenger", "org.telegram.messenger.web"));
        }
        String copyLink = jSONObject.optString("CopyLink");
        Intrinsics.f(copyLink, "copyLink");
        if (copyLink.length() > 0) {
            arrayList.add(new c(R$mipmap.player_ic_copy_link, R$string.copy_link, copyLink, "", null, 16, null));
        }
        View viewFindViewById2 = view.findViewById(R$id.ll_title);
        if (viewFindViewById2 != null) {
            n.a(viewFindViewById2, i.e(6.0f));
        }
        View viewFindViewById3 = view.findViewById(R$id.iv_close);
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.web.share.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WebShareDialog.o0(this.f60235a, view2);
                }
            });
        }
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R$id.share_list);
        if (recyclerView != null) {
            recyclerView.addItemDecoration(new ro.c(f0.a(16.0f)));
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 0, false));
            final b bVar = new b();
            bVar.x0(arrayList);
            bVar.B0(new f9.d() { // from class: com.transsion.web.share.d
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view2, int i11) {
                    WebShareDialog.p0(arrayList, this, bVar, baseQuickAdapter, view2, i11);
                }
            });
            recyclerView.setAdapter(bVar);
        }
        HashMap map = new HashMap();
        map.put("dialog_name", this.f60212d);
        m.f51277a.t("MbShareDialog", "dialog_show", map);
    }

    public final void q0(Function3<? super String, ? super String, ? super String, Unit> function3) {
        this.f60214g = function3;
    }

    public final void r0(String name) {
        Intrinsics.g(name, "name");
        this.f60212d = name;
    }

    public final void s0(boolean z11) {
        this.f60213f = z11;
    }
}
