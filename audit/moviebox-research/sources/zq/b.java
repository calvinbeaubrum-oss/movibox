package zq;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.Utils;
import com.hisavana.common.bean.TAdNativeInfo;
import com.hisavana.mediation.ad.ViewBinder;
import com.transsion.ad.view.AdTagView;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f82113a;

    public b(Context context) {
        Intrinsics.g(context, "context");
        this.f82113a = context;
    }

    public static final void r(AppCompatTextView this_apply) {
        Intrinsics.g(this_apply, "$this_apply");
        try {
            Result.Companion companion = Result.Companion;
            String lowerCase = this_apply.getText().toString().toLowerCase(Locale.ROOT);
            Intrinsics.f(lowerCase, "toLowerCase(...)");
            if (xq.c.f80663a.c(lowerCase)) {
                this_apply.setText(l.p(lowerCase));
            }
            Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public boolean A() {
        return true;
    }

    public final void B(ViewBinder viewBinder) {
        xq.c cVar = xq.c.f80663a;
        View view = viewBinder.layout;
        Intrinsics.f(view, "viewBinder.layout");
        cVar.k(view, viewBinder.callToActionId);
    }

    public Integer b() {
        return null;
    }

    public abstract Integer c();

    public Integer d() {
        return null;
    }

    public Integer e() {
        return null;
    }

    public final View f(Context context) {
        if (context == null) {
            context = Utils.a();
        }
        View viewInflate = LayoutInflater.from(context).inflate(t(), (ViewGroup) null);
        Intrinsics.f(viewInflate, "from(viewContext ?: Util…late(getLayoutId(), null)");
        return viewInflate;
    }

    public final d g() {
        int iT = t();
        View viewF = f(this.f82113a);
        Integer numV = v();
        Integer numZ = z();
        Integer numS = s();
        Integer numL = l();
        Integer numM = m();
        Integer numC = c();
        Integer numH = h();
        Integer numD = d();
        return new d(Integer.valueOf(iT), viewF, numZ, numS, numL, numV, numM, x(), w(), y(), u(), o(), e(), b(), numC, numD, numH, n(), p(), j(), k(), i());
    }

    public abstract Integer h();

    public abstract Integer i();

    public Integer j() {
        return null;
    }

    public Integer k() {
        return null;
    }

    public abstract Integer l();

    public abstract Integer m();

    public Integer n() {
        return null;
    }

    public Integer o() {
        return null;
    }

    public Integer p() {
        return null;
    }

    public ViewBinder q(d adLayoutProvider, TAdNativeInfo tAdNativeInfo) {
        Intrinsics.g(adLayoutProvider, "adLayoutProvider");
        ViewBinder.Builder builder = new ViewBinder.Builder(adLayoutProvider.h());
        builder.contextMode(1);
        Integer numJ = adLayoutProvider.j();
        if (numJ != null) {
            builder.titleId(numJ.intValue());
        }
        Integer numF = adLayoutProvider.f();
        if (numF != null) {
            builder.descriptionId(numF.intValue());
        }
        Integer numI = adLayoutProvider.i();
        if (numI != null) {
            builder.mediaId(numI.intValue());
        }
        Integer numG = adLayoutProvider.g();
        if (numG != null) {
            builder.iconId(numG.intValue());
        }
        Integer numE = adLayoutProvider.e();
        if (numE != null) {
            int iIntValue = numE.intValue();
            builder.callToActionId(iIntValue);
            final AppCompatTextView appCompatTextView = (AppCompatTextView) adLayoutProvider.h().findViewById(iIntValue);
            if (appCompatTextView != null) {
                Intrinsics.f(appCompatTextView, "findViewById<AppCompatTextView>(it)");
                appCompatTextView.post(new Runnable() { // from class: zq.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.r(appCompatTextView);
                    }
                });
            }
        }
        Integer numA = adLayoutProvider.a();
        if (numA != null) {
            builder.adChoicesView(numA.intValue());
        }
        Integer numB = adLayoutProvider.b();
        if (numB != null) {
            builder.storeMarkView(numB.intValue());
        }
        Integer numC = adLayoutProvider.c();
        if (numC != null) {
            ((AdTagView) adLayoutProvider.h().findViewById(numC.intValue())).setVisibility(8);
        }
        ViewBinder viewBinderBuild = builder.build();
        Intrinsics.f(viewBinderBuild, "builder.build()");
        B(viewBinderBuild);
        return viewBinderBuild;
    }

    public abstract Integer s();

    public abstract int t();

    public Integer u() {
        return null;
    }

    public abstract Integer v();

    public Integer w() {
        return null;
    }

    public Integer x() {
        return null;
    }

    public Integer y() {
        return null;
    }

    public abstract Integer z();
}
