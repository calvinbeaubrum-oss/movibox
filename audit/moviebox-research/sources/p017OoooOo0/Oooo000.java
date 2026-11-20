package p017OoooOo0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import java.util.Objects;
import p0.e;
import p0.f;
import p0.g;
import p0.h;
import p0.i;
import p014OoooO0O.OooOOO0;
import p016OoooOOo.o000O0o;
import p016OoooOOo.o000Oo0;
import s0.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class Oooo000 extends RelativeLayout implements g {
    public View OooO00o;
    public b OooO0O0;
    public g OooO0OO;

    public Oooo000(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Oooo000(@NonNull View view) {
        this(view, view instanceof g ? (g) view : null);
    }

    public Oooo000(@NonNull View view, @Nullable g gVar) {
        super(view.getContext(), null, 0);
        this.OooO00o = view;
        this.OooO0OO = gVar;
        if ((this instanceof o000O0o) && (gVar instanceof f) && gVar.getSpinnerStyle() == b.f75914g) {
            gVar.getView().setScaleY(-1.0f);
            return;
        }
        if (this instanceof o000Oo0) {
            g gVar2 = this.OooO0OO;
            if ((gVar2 instanceof e) && gVar2.getSpinnerStyle() == b.f75914g) {
                gVar.getView().setScaleY(-1.0f);
            }
        }
    }

    public int OooO00o(@NonNull i iVar, boolean z11) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return 0;
        }
        return gVar.OooO00o(iVar, z11);
    }

    public void OooO00o(float f11, int i11, int i12) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        gVar.OooO00o(f11, i11, i12);
    }

    public void OooO00o(@NonNull h hVar, int i11, int i12) {
        g gVar = this.OooO0OO;
        if (gVar != null && gVar != this) {
            gVar.OooO00o(hVar, i11, i12);
            return;
        }
        View view = this.OooO00o;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof OooOOO0.f) {
                ((OooOOO0.g) hVar).e(this, ((OooOOO0.f) layoutParams).f318a);
            }
        }
    }

    public void OooO00o(@NonNull i iVar, int i11, int i12) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        gVar.OooO00o(iVar, i11, i12);
    }

    public void OooO00o(@NonNull i iVar, @NonNull MiniRefreshState miniRefreshState, @NonNull MiniRefreshState miniRefreshState2) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        if ((this instanceof o000O0o) && (gVar instanceof f)) {
            if (miniRefreshState.isFooter) {
                miniRefreshState = miniRefreshState.toHeader();
            }
            if (miniRefreshState2.isFooter) {
                miniRefreshState2 = miniRefreshState2.toHeader();
            }
        } else if ((this instanceof o000Oo0) && (gVar instanceof e)) {
            if (miniRefreshState.isHeader) {
                miniRefreshState = miniRefreshState.toFooter();
            }
            if (miniRefreshState2.isHeader) {
                miniRefreshState2 = miniRefreshState2.toFooter();
            }
        }
        g gVar2 = this.OooO0OO;
        if (gVar2 != null) {
            gVar2.OooO00o(iVar, miniRefreshState, miniRefreshState2);
        }
    }

    public void OooO00o(boolean z11, float f11, int i11, int i12, int i13) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        gVar.OooO00o(z11, f11, i11, i12, i13);
    }

    public boolean OooO00o() {
        g gVar = this.OooO0OO;
        return (gVar == null || gVar == this || !gVar.OooO00o()) ? false : true;
    }

    @SuppressLint({"RestrictedApi"})
    public boolean OooO00o(boolean z11) {
        g gVar = this.OooO0OO;
        return (gVar instanceof e) && ((e) gVar).OooO00o(z11);
    }

    public void OooO0O0(@NonNull i iVar, int i11, int i12) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        gVar.OooO0O0(iVar, i11, i12);
    }

    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }
        return (obj instanceof g) && getView() == ((g) obj).getView();
    }

    @Override // p0.g
    @NonNull
    public b getSpinnerStyle() {
        int i11;
        b bVar = this.OooO0O0;
        if (bVar != null) {
            return bVar;
        }
        g gVar = this.OooO0OO;
        if (gVar != null && gVar != this) {
            return gVar.getSpinnerStyle();
        }
        View view = this.OooO00o;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof OooOOO0.f) {
                b bVar2 = ((OooOOO0.f) layoutParams).f319b;
                this.OooO0O0 = bVar2;
                if (bVar2 != null) {
                    return bVar2;
                }
            }
            if (layoutParams != null && ((i11 = layoutParams.height) == 0 || i11 == -1)) {
                for (b bVar3 : b.f75915h) {
                    if (bVar3.f75918c) {
                        this.OooO0O0 = bVar3;
                        return bVar3;
                    }
                }
            }
        }
        b bVar4 = b.f75911d;
        this.OooO0O0 = bVar4;
        return bVar4;
    }

    @Override // p0.g
    @NonNull
    public View getView() {
        View view = this.OooO00o;
        return view == null ? this : view;
    }

    public int hashCode() {
        return Objects.hash(this.OooO00o, this.OooO0O0, this.OooO0OO);
    }

    public void setPrimaryColors(int... iArr) {
        g gVar = this.OooO0OO;
        if (gVar == null || gVar == this) {
            return;
        }
        gVar.setPrimaryColors(iArr);
    }
}
