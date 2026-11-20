package com.cloud.tmc.miniapp.defaultimpl;

import OooO0o0.OooO;
import OooO0o0.OooOO0O;
import OooO0o0.OooOo;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.applovin.sdk.AppLovinEventTypes;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.TmcGsonUtils;
import com.cloud.tmc.kernel.utils.o;
import com.cloud.tmc.miniapp.R$string;
import com.cloud.tmc.miniapp.dialog.BottomActionSheetDialog$ActionItem;
import com.cloud.tmc.miniutils.util.y;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import j.l;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import n0.j;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@SourceDebugExtension
public final class ToastImp implements ToastProxy {
    public static final a Companion = new a();

    /* JADX INFO: compiled from: source.java */
    public static final class a {
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements j.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31529a;

        public b(bc.a aVar) {
            this.f31529a = aVar;
        }

        @Override // j.f
        public void a(int i11, BottomActionSheetDialog$ActionItem data) {
            Intrinsics.g(data, "data");
            TmcLogger.c("ToastImp", "showActionSheet: " + data);
            bc.a aVar = this.f31529a;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("tapIndex", Integer.valueOf(i11));
                jsonObject.addProperty(AppLovinEventTypes.USER_VIEWED_CONTENT, data.getText());
                aVar.d(jsonObject);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ua.a f31530a;

        public c(ua.a aVar) {
            this.f31530a = aVar;
        }

        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
            ua.a aVar = this.f31530a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // j.l
        public void b(View view) {
            Intrinsics.g(view, "view");
            ua.a aVar = this.f31530a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class d implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ua.a f31531a;

        public d(ua.a aVar) {
            this.f31531a = aVar;
        }

        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
            ua.a aVar = this.f31531a;
            if (aVar != null) {
                aVar.b();
            }
        }

        @Override // j.l
        public void b(View view) {
            Intrinsics.g(view, "view");
            ua.a aVar = this.f31531a;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class e implements ua.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OooOo f31532a;

        public e(OooOo oooOo) {
            this.f31532a = oooOo;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class f implements l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bc.a f31533a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f31534b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ OooOo f31535c;

        public f(bc.a aVar, boolean z11, OooOo oooOo) {
            this.f31533a = aVar;
            this.f31534b = z11;
            this.f31535c = oooOo;
        }

        @Override // j.l
        public void a(View view) {
            Intrinsics.g(view, "view");
            bc.a aVar = this.f31533a;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("cancel", Boolean.TRUE);
                jsonObject.addProperty("confirm", Boolean.FALSE);
                aVar.d(jsonObject);
            }
        }

        @Override // j.l
        public void b(View view) {
            Intrinsics.g(view, "view");
            bc.a aVar = this.f31533a;
            if (aVar != null) {
                JsonObject jsonObject = new JsonObject();
                boolean z11 = this.f31534b;
                OooOo oooOo = this.f31535c;
                jsonObject.addProperty("cancel", Boolean.FALSE);
                jsonObject.addProperty("confirm", Boolean.TRUE);
                if (z11) {
                    TextView textViewQ = oooOo.Q();
                    jsonObject.addProperty(AppLovinEventTypes.USER_VIEWED_CONTENT, textViewQ != null ? textViewQ.getText().toString() : null);
                }
                aVar.d(jsonObject);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:74:0x0174  */
    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void showActionSheet(JsonArray actions, String showType, String str, String str2, String str3, boolean z11, String str4, String cancelColor, Context context, String str5, bc.a aVar) {
        ArrayList arrayList;
        ArrayList data;
        boolean z12;
        String str6;
        String cancelText = str4;
        Intrinsics.g(actions, "actions");
        Intrinsics.g(showType, "type");
        Intrinsics.g(cancelText, "cancelText");
        Intrinsics.g(cancelColor, "cancelColor");
        Intrinsics.g(context, "context");
        try {
            int size = actions.size();
            if (1 > size || size >= 11) {
                if (aVar != null) {
                    JsonObject jsonObject = new JsonObject();
                    jsonObject.addProperty("errMsg", "Invalid " + size + ", must be between 1 and 10 : AS10003");
                    aVar.e(jsonObject);
                    return;
                }
                return;
            }
            try {
                String strA = o.a(actions);
                Type type = new TypeToken<ArrayList<String>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.ToastImp$showActionSheet$data$itemList$1
                }.getType();
                Intrinsics.f(type, "object : TypeToken<ArrayList<String>>() {}.type");
                arrayList = (ArrayList) TmcGsonUtils.e(strA, type);
            } catch (Throwable th2) {
                TmcLogger.g("ToastImp", "itemList parse error!", th2);
                arrayList = null;
            }
            if (arrayList != null) {
                data = new ArrayList();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    data.add(new BottomActionSheetDialog$ActionItem(null, (String) it.next(), str3, null, false, null, null, 121, null));
                }
            } else {
                String strA2 = o.a(actions);
                Type type2 = new TypeToken<ArrayList<BottomActionSheetDialog$ActionItem>>() { // from class: com.cloud.tmc.miniapp.defaultimpl.ToastImp$showActionSheet$data$3
                }.getType();
                Intrinsics.f(type2, "object :\n               …og.ActionItem>>() {}.type");
                Iterable iterable = (Iterable) TmcGsonUtils.e(strA2, type2);
                Iterator it2 = iterable.iterator();
                while (it2.hasNext()) {
                    String text = ((BottomActionSheetDialog$ActionItem) it2.next()).getText();
                    if (text == null || text.length() == 0) {
                        throw new IllegalArgumentException("Action's text is null or empty");
                    }
                }
                data = (ArrayList) iterable;
            }
            OooOO0O oooOO0O = new OooOO0O(context);
            if (str2 != null && str2.length() != 0) {
                AppCompatTextView appCompatTextViewY = oooOO0O.y();
                if (appCompatTextViewY != null) {
                    i.f(appCompatTextViewY, !(str == null || str.length() == 0));
                }
                AppCompatTextView appCompatTextViewY2 = oooOO0O.y();
                if (appCompatTextViewY2 != null) {
                    appCompatTextViewY2.setText(str);
                }
                AppCompatTextView appCompatTextViewX = oooOO0O.x();
                if (appCompatTextViewX != null) {
                    i.f(appCompatTextViewX, !(str2 == null || str2.length() == 0));
                }
                AppCompatTextView appCompatTextViewX2 = oooOO0O.x();
                if (appCompatTextViewX2 != null) {
                    appCompatTextViewX2.setText(str2);
                }
            }
            Intrinsics.g(showType, "showType");
            OooO oooO = oooOO0O.f58z;
            oooO.getClass();
            Intrinsics.g(showType, "showType");
            oooO.f7q = showType;
            oooOO0O.f58z.f8r = str5;
            Intrinsics.g(data, "data");
            int size2 = data.size();
            if (1 > size2 || size2 >= 11) {
                TmcLogger.c("BottomActionSheetDialog", "Invalid " + size2 + ", must be between 1 and 10");
            } else {
                oooOO0O.f58z.x(data);
            }
            if (z11) {
                OooO oooO2 = oooOO0O.f58z;
                if (cancelText == null) {
                    str6 = "Cancel";
                } else {
                    if (str4.length() <= 0) {
                        cancelText = null;
                    }
                    if (cancelText == null) {
                        str6 = "Cancel";
                    } else {
                        str6 = cancelText;
                    }
                }
                z12 = true;
                oooO2.t(new BottomActionSheetDialog$ActionItem("Cancel", str6, cancelColor, "#4D191F2B", true, null, "#0F191F2B", 32, null));
            } else {
                z12 = true;
            }
            oooOO0O.A = new b(aVar);
            oooOO0O.k(z12).n(z12).q();
        } catch (Throwable th3) {
            TmcLogger.h("ToastImp", th3);
            if (aVar != null) {
                f.a.a("errMsg", "Parameter error: AS10001", aVar);
            }
        }
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void showAddHomeSuccessfulToast() {
        String strC = y.c(R$string.mini_add_home_successful_toast);
        Intrinsics.f(strC, "getString(R.string.mini_add_home_successful_toast)");
        j.e(new n0.d(strC, 0, 0L, false, null, 0, new f0.a(), null, null, null, 958));
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void showCommonDialog(String str, String str2, int i11, Boolean bool, String str3, String str4, String str5, String str6, Context context, ua.a aVar) {
        TextView textViewV;
        Intrinsics.g(context, "context");
        OooOo oooOo = new OooOo(context, true);
        if (str != null && str.length() != 0) {
            oooOo.G(str);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo.x(str2);
        }
        if (i11 > 0) {
            oooOo.F(i11);
        } else {
            oooOo.H(true);
        }
        if (Intrinsics.b(bool, Boolean.TRUE)) {
            if (str3 != null && str3.length() != 0 && (textViewV = oooOo.v()) != null) {
                textViewV.setText(oooOo.y(str3, 12));
            }
            oooOo.L(true);
        }
        if (str5 != null && str5.length() != 0) {
            oooOo.E(str5);
        }
        if (str4 != null) {
            try {
                if (str4.length() != 0) {
                    oooOo.K(Color.parseColor(str4));
                }
            } catch (Exception e11) {
                TmcLogger.h("[ToastImp]: set common dialog cancel button color error", e11);
                toast("cancel button color error");
            }
        }
        if (str6 != null) {
            try {
                if (str6.length() != 0) {
                    oooOo.I(Color.parseColor(str6));
                }
            } catch (Exception e12) {
                TmcLogger.h("[ToastImp]: set common dialog confirm button color error", e12);
                toast("confirm button color error");
            }
        }
        oooOo.w(new c(aVar)).n(false).q();
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public ua.b showCommonDialogWithOperate(String str, String str2, int i11, Boolean bool, String str3, String str4, String str5, String str6, Context context, ua.a aVar) {
        TextView textViewV;
        Intrinsics.g(context, "context");
        OooOo oooOo = new OooOo(context, true);
        if (str != null && str.length() != 0) {
            oooOo.G(str);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo.x(str2);
        }
        if (i11 > 0) {
            oooOo.F(i11);
        } else {
            oooOo.H(true);
        }
        if (Intrinsics.b(bool, Boolean.TRUE)) {
            if (str3 != null && str3.length() != 0 && (textViewV = oooOo.v()) != null) {
                textViewV.setText(oooOo.y(str3, 12));
            }
            oooOo.L(true);
        }
        if (str5 != null && str5.length() != 0) {
            oooOo.E(str5);
        }
        if (str4 != null) {
            try {
                if (str4.length() != 0) {
                    oooOo.K(Color.parseColor(str4));
                }
            } catch (Exception e11) {
                TmcLogger.h("[ToastImp]: set common dialog cancel button color error", e11);
                toast("cancel button color error");
            }
        }
        if (str6 != null) {
            try {
                if (str6.length() != 0) {
                    oooOo.I(Color.parseColor(str6));
                }
            } catch (Exception e12) {
                TmcLogger.h("[ToastImp]: set common dialog confirm button color error", e12);
                toast("confirm button color error");
            }
        }
        oooOo.w(new d(aVar)).n(false).q();
        return new e(oooOo);
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void showModal(String str, String str2, boolean z11, boolean z12, String str3, String str4, String str5, String str6, String str7, Context context, bc.a aVar) {
        TextView textViewV;
        TextView textViewQ;
        Intrinsics.g(context, "context");
        OooOo oooOo = new OooOo(context, false);
        if (str != null && str.length() != 0) {
            oooOo.G(str);
        }
        FrameLayout frameLayout = (FrameLayout) oooOo.f79w.getValue();
        if (frameLayout != null) {
            i.f(frameLayout, !z12);
        }
        FrameLayout frameLayout2 = (FrameLayout) oooOo.f80x.getValue();
        if (frameLayout2 != null) {
            i.f(frameLayout2, z12);
        }
        if (str3 != null && str3.length() != 0 && str3 != null && str3.length() != 0 && (textViewQ = oooOo.Q()) != null) {
            textViewQ.setHint(str3);
        }
        if (str2 != null && str2.length() != 0) {
            oooOo.x(str2);
        }
        if (z11) {
            if (str4 != null && str4.length() != 0 && (textViewV = oooOo.v()) != null) {
                textViewV.setText(oooOo.y(str4, 12));
            }
            oooOo.L(true);
        }
        if (str6 != null && str6.length() != 0) {
            oooOo.E(str6);
        }
        if (str5 != null) {
            try {
                if (str5.length() != 0) {
                    oooOo.K(Color.parseColor(str5));
                }
            } catch (Exception e11) {
                TmcLogger.h("[ToastImp]: set common dialog cancel button color error", e11);
                toast("cancel button color error");
            }
        }
        if (str7 != null) {
            try {
                if (str7.length() != 0) {
                    oooOo.I(Color.parseColor(str7));
                }
            } catch (Exception e12) {
                TmcLogger.h("[ToastImp]: set common dialog confirm button color error", e12);
                toast("confirm button color error");
            }
        }
        oooOo.w(new f(aVar, z12, oooOo)).H(true).n(false).q();
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void toast(int i11) {
        j.b(i11, 0, 0L, false, 14);
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void toast(String str) {
        j.c(xb.e.a(str, ""), 0, 0L, false, null, 30);
    }

    @Override // com.cloud.tmc.integration.proxy.ToastProxy
    public void toast(String str, int i11) {
        j.c(xb.e.a(str, ""), i11, 0L, false, null, 28);
    }
}
