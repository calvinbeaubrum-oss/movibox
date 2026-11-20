package OooO0o0;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.utils.i0;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.resource.IResourceProcessor;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.dialog.BottomActionSheetDialog$ActionItem;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import xb.e;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooO extends com.cloud.tmc.miniapp.ui.adapter.a<BottomActionSheetDialog$ActionItem> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f6p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public String f7q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public String f8r;

    /* JADX INFO: compiled from: source.java */
    public final class OooO00o extends com.cloud.tmc.miniapp.ui.adapter.a<BottomActionSheetDialog$ActionItem>.AbstractC0347a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f9d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Lazy f10f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f11g;

        /* JADX INFO: renamed from: OooO0o0.OooO$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0002OooO00o extends Lambda implements Function0<AppCompatImageView> {
            public C0002OooO00o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatImageView invoke() {
                return (AppCompatImageView) OooO00o.this.findViewById(R$id.iv_icon);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0O0 extends Lambda implements Function0<RelativeLayout> {
            public OooO0O0() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public RelativeLayout invoke() {
                return (RelativeLayout) OooO00o.this.findViewById(R$id.rl_container);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0OO extends Lambda implements Function0<TextView> {
            public OooO0OO() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public TextView invoke() {
                return (TextView) OooO00o.this.findViewById(R$id.tv_name);
            }
        }

        public OooO00o() {
            super(R$layout.mini_item_bottom_action_sheet_dialog);
            this.f9d = LazyKt__LazyJVMKt.b(new OooO0O0());
            this.f10f = LazyKt__LazyJVMKt.b(new C0002OooO00o());
            this.f11g = LazyKt__LazyJVMKt.b(new OooO0OO());
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.a
        public void g(int i11) {
            RelativeLayout relativeLayoutH;
            String icon;
            BottomActionSheetDialog$ActionItem item = OooO.this.getItem(i11);
            boolean z11 = (!Intrinsics.b(OooO.this.f7q, RewardPlus.ICON) || (icon = item.getIcon()) == null || icon.length() == 0) ? false : true;
            boolean z12 = OooO.this.u() - 1 == i11 && Intrinsics.b(item.getId(), "Cancel");
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.f10f.getValue();
            if (appCompatImageView != null) {
                OooO oooO = OooO.this;
                if (z12) {
                    i.c(appCompatImageView);
                } else {
                    i.f(appCompatImageView, z11);
                    if (z11) {
                        String icon2 = item.getIcon();
                        String str = oooO.f8r;
                        OooO0o oooO0o = new OooO0o(appCompatImageView);
                        if (icon2 == null || icon2.length() == 0) {
                            oooO0o.invoke(null);
                        } else if (!i0.b(icon2) || StringsKt__StringsKt.Q(icon2, ".miniapp.transsion.com", false, 2, null)) {
                            Object value = OooO.this.f6p.getValue();
                            Intrinsics.f(value, "<get-processor>(...)");
                            File file = ((IResourceProcessor) value).get(icon2, str);
                            oooO0o.invoke(Drawable.createFromPath(file != null ? file.getAbsolutePath() : null));
                        } else {
                            j.d(l0.a(w0.b()), null, null, new OooOO0(OooO.this, icon2, str, this, oooO0o, null), 3, null);
                        }
                    }
                }
            }
            TextView textView = (TextView) this.f11g.getValue();
            if (textView != null) {
                textView.setText(e.a(item.getText(), ""));
                try {
                    if (item.getEnable()) {
                        String color = item.getColor();
                        if (color != null && color.length() != 0) {
                            textView.setTextColor(Color.parseColor(item.getColor()));
                        }
                    } else if (item.getDisabledColor().length() > 0) {
                        textView.setTextColor(Color.parseColor(item.getDisabledColor()));
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("BottomActionSheetDialog", th2);
                }
            }
            try {
                if (z12) {
                    RelativeLayout relativeLayoutH2 = h();
                    if (relativeLayoutH2 != null) {
                        relativeLayoutH2.setGravity(17);
                    }
                } else {
                    RelativeLayout relativeLayoutH3 = h();
                    if (relativeLayoutH3 != null) {
                        relativeLayoutH3.setGravity(z11 ? GravityCompat.START : 17);
                    }
                }
                if (item.getEnable() && (relativeLayoutH = h()) != null) {
                    StateListDrawable stateListDrawable = new StateListDrawable();
                    stateListDrawable.addState(new int[]{R.attr.state_pressed}, new ColorDrawable(Color.parseColor(e.a(item.getMaskColor(), "#0F191F2B"))));
                    stateListDrawable.addState(new int[]{-16842919}, new ColorDrawable(0));
                    relativeLayoutH.setForeground(stateListDrawable);
                }
            } catch (Throwable th3) {
                TmcLogger.h("BottomActionSheetDialog", th3);
            }
        }

        public final RelativeLayout h() {
            return (RelativeLayout) this.f9d.getValue();
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0O0 extends Lambda implements Function0<IResourceProcessor> {
        public static final OooO0O0 OooO00o = new OooO0O0();

        public OooO0O0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public IResourceProcessor invoke() {
            return (IResourceProcessor) tc.a.a(IResourceProcessor.class);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooO(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f6p = LazyKt__LazyJVMKt.b(OooO0O0.OooO00o);
        this.f7q = MimeTypes.BASE_TYPE_TEXT;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new OooO00o();
    }
}
