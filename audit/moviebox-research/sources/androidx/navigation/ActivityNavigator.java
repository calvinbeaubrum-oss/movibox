package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.CallSuper;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.mvel2.ast.ASTNode;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@Navigator.b("activity")
public class ActivityNavigator extends Navigator<b> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12132e = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f12133c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f12134d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static class b extends NavDestination {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Intent f12135m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public String f12136n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Navigator<? extends b> activityNavigator) {
            super(activityNavigator);
            Intrinsics.g(activityNavigator, "activityNavigator");
        }

        @Override // androidx.navigation.NavDestination
        public boolean F() {
            return false;
        }

        public final String G() {
            Intent intent = this.f12135m;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        public final ComponentName H() {
            Intent intent = this.f12135m;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        public final String I() {
            return this.f12136n;
        }

        public final Intent J() {
            return this.f12135m;
        }

        public final b K(String str) {
            if (this.f12135m == null) {
                this.f12135m = new Intent();
            }
            Intent intent = this.f12135m;
            Intrinsics.d(intent);
            intent.setAction(str);
            return this;
        }

        public final b L(ComponentName componentName) {
            if (this.f12135m == null) {
                this.f12135m = new Intent();
            }
            Intent intent = this.f12135m;
            Intrinsics.d(intent);
            intent.setComponent(componentName);
            return this;
        }

        public final b M(Uri uri) {
            if (this.f12135m == null) {
                this.f12135m = new Intent();
            }
            Intent intent = this.f12135m;
            Intrinsics.d(intent);
            intent.setData(uri);
            return this;
        }

        public final b N(String str) {
            this.f12136n = str;
            return this;
        }

        public final b O(String str) {
            if (this.f12135m == null) {
                this.f12135m = new Intent();
            }
            Intent intent = this.f12135m;
            Intrinsics.d(intent);
            intent.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.NavDestination
        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b) || !super.equals(obj)) {
                return false;
            }
            Intent intent = this.f12135m;
            Boolean boolValueOf = intent == null ? null : Boolean.valueOf(intent.filterEquals(((b) obj).f12135m));
            if (boolValueOf == null) {
                if (((b) obj).f12135m != null) {
                    return false;
                }
            } else if (!boolValueOf.booleanValue()) {
                return false;
            }
            return Intrinsics.b(this.f12136n, ((b) obj).f12136n);
        }

        @Override // androidx.navigation.NavDestination
        public int hashCode() {
            int iHashCode = super.hashCode() * 31;
            Intent intent = this.f12135m;
            int iFilterHashCode = (iHashCode + (intent == null ? 0 : intent.filterHashCode())) * 31;
            String str = this.f12136n;
            return iFilterHashCode + (str != null ? str.hashCode() : 0);
        }

        @Override // androidx.navigation.NavDestination
        public String toString() {
            ComponentName componentNameH = H();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(super.toString());
            if (componentNameH != null) {
                sb2.append(" class=");
                sb2.append(componentNameH.getClassName());
            } else {
                String strG = G();
                if (strG != null) {
                    sb2.append(" action=");
                    sb2.append(strG);
                }
            }
            String string = sb2.toString();
            Intrinsics.f(string, "sb.toString()");
            return string;
        }

        @Override // androidx.navigation.NavDestination
        @CallSuper
        public void z(Context context, AttributeSet attrs) {
            Intrinsics.g(context, "context");
            Intrinsics.g(attrs, "attrs");
            super.z(context, attrs);
            TypedArray typedArrayObtainAttributes = context.getResources().obtainAttributes(attrs, R$styleable.ActivityNavigator);
            Intrinsics.f(typedArrayObtainAttributes, "context.resources.obtain…tyNavigator\n            )");
            String string = typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_targetPackage);
            if (string != null) {
                String packageName = context.getPackageName();
                Intrinsics.f(packageName, "context.packageName");
                string = kotlin.text.l.F(string, "${applicationId}", packageName, false, 4, null);
            }
            O(string);
            String string2 = typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_android_name);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = Intrinsics.p(context.getPackageName(), string2);
                }
                L(new ComponentName(context, string2));
            }
            K(typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_action));
            String string3 = typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_data);
            if (string3 != null) {
                M(Uri.parse(string3));
            }
            N(typedArrayObtainAttributes.getString(R$styleable.ActivityNavigator_dataPattern));
            typedArrayObtainAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    public static final class c implements Navigator.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f12137a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final androidx.core.app.b f12138b;

        public final androidx.core.app.b a() {
            return this.f12138b;
        }

        public final int b() {
            return this.f12137a;
        }
    }

    public ActivityNavigator(Context context) {
        Intrinsics.g(context, "context");
        this.f12133c = context;
        for (Object obj : SequencesKt__SequencesKt.f(context, new Function1<Context, Context>() { // from class: androidx.navigation.ActivityNavigator$hostActivity$1
            @Override // kotlin.jvm.functions.Function1
            public final Context invoke(Context it) {
                Intrinsics.g(it, "it");
                if (it instanceof ContextWrapper) {
                    return ((ContextWrapper) it).getBaseContext();
                }
                return null;
            }
        })) {
            if (((Context) obj) instanceof Activity) {
                this.f12134d = (Activity) obj;
            }
        }
        obj = null;
        this.f12134d = (Activity) obj;
    }

    @Override // androidx.navigation.Navigator
    public boolean k() {
        Activity activity = this.f12134d;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public b a() {
        return new b(this);
    }

    @Override // androidx.navigation.Navigator
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public NavDestination d(b destination, Bundle bundle, l lVar, Navigator.a aVar) {
        androidx.core.app.b bVarA;
        Intent intent;
        int intExtra;
        Intrinsics.g(destination, "destination");
        if (destination.J() == null) {
            throw new IllegalStateException(("Destination " + destination.u() + " does not have an Intent set.").toString());
        }
        Intent intent2 = new Intent(destination.J());
        if (bundle != null) {
            intent2.putExtras(bundle);
            String strI = destination.I();
            if (strI != null && strI.length() != 0) {
                StringBuffer stringBuffer = new StringBuffer();
                Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(strI);
                while (matcher.find()) {
                    String strGroup = matcher.group(1);
                    if (!bundle.containsKey(strGroup)) {
                        throw new IllegalArgumentException("Could not find " + ((Object) strGroup) + " in " + bundle + " to fill data pattern " + ((Object) strI));
                    }
                    matcher.appendReplacement(stringBuffer, "");
                    stringBuffer.append(Uri.encode(String.valueOf(bundle.get(strGroup))));
                }
                matcher.appendTail(stringBuffer);
                intent2.setData(Uri.parse(stringBuffer.toString()));
            }
        }
        boolean z11 = aVar instanceof c;
        if (z11) {
            intent2.addFlags(((c) aVar).b());
        }
        if (this.f12134d == null) {
            intent2.addFlags(ASTNode.DEOP);
        }
        if (lVar != null && lVar.g()) {
            intent2.addFlags(ASTNode.DISCARD);
        }
        Activity activity = this.f12134d;
        if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
            intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
        }
        intent2.putExtra("android-support-navigation:ActivityNavigator:current", destination.u());
        Resources resources = this.f12133c.getResources();
        if (lVar != null) {
            int iC = lVar.c();
            int iD = lVar.d();
            if ((iC <= 0 || !Intrinsics.b(resources.getResourceTypeName(iC), "animator")) && (iD <= 0 || !Intrinsics.b(resources.getResourceTypeName(iD), "animator"))) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", iC);
                intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", iD);
            } else {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + ((Object) resources.getResourceName(iC)) + " and popExit resource " + ((Object) resources.getResourceName(iD)) + " when launching " + destination);
            }
        }
        if (!z11 || (bVarA = ((c) aVar).a()) == null) {
            this.f12133c.startActivity(intent2);
        } else {
            z2.a.startActivity(this.f12133c, intent2, bVarA.b());
        }
        if (lVar == null || this.f12134d == null) {
            return null;
        }
        int iA = lVar.a();
        int iB = lVar.b();
        if ((iA <= 0 || !Intrinsics.b(resources.getResourceTypeName(iA), "animator")) && (iB <= 0 || !Intrinsics.b(resources.getResourceTypeName(iB), "animator"))) {
            if (iA < 0 && iB < 0) {
                return null;
            }
            this.f12134d.overridePendingTransition(kotlin.ranges.a.d(iA, 0), kotlin.ranges.a.d(iB, 0));
            return null;
        }
        Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + ((Object) resources.getResourceName(iA)) + " and exit resource " + ((Object) resources.getResourceName(iB)) + "when launching " + destination);
        return null;
    }
}
