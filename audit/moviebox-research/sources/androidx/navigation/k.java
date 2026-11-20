package androidx.navigation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParserException;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12282c = new a(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f12283d = new ThreadLocal<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f12284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f12285b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o<?> a(TypedValue value, o<?> oVar, o<?> expectedNavType, String str, String foundType) throws XmlPullParserException {
            Intrinsics.g(value, "value");
            Intrinsics.g(expectedNavType, "expectedNavType");
            Intrinsics.g(foundType, "foundType");
            if (oVar == null || oVar == expectedNavType) {
                return oVar == null ? expectedNavType : oVar;
            }
            throw new XmlPullParserException("Type is " + ((Object) str) + " but found " + foundType + ": " + value.data);
        }
    }

    public k(Context context, q navigatorProvider) {
        Intrinsics.g(context, "context");
        Intrinsics.g(navigatorProvider, "navigatorProvider");
        this.f12284a = context;
        this.f12285b = navigatorProvider;
    }

    public final NavDestination a(Resources resources, XmlResourceParser xmlResourceParser, AttributeSet attributeSet, int i11) throws XmlPullParserException, IOException {
        int depth;
        q qVar = this.f12285b;
        String name = xmlResourceParser.getName();
        Intrinsics.f(name, "parser.name");
        NavDestination navDestinationA = qVar.d(name).a();
        navDestinationA.z(this.f12284a, attributeSet);
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2) {
                String name2 = xmlResourceParser.getName();
                if (Intrinsics.b("argument", name2)) {
                    f(resources, navDestinationA, attributeSet, i11);
                } else if (Intrinsics.b("deepLink", name2)) {
                    g(resources, navDestinationA, attributeSet);
                } else if (Intrinsics.b("action", name2)) {
                    c(resources, navDestinationA, attributeSet, xmlResourceParser, i11);
                } else if (Intrinsics.b("include", name2) && (navDestinationA instanceof NavGraph)) {
                    TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, R$styleable.NavInclude);
                    Intrinsics.f(typedArrayObtainAttributes, "res.obtainAttributes(att…n.R.styleable.NavInclude)");
                    ((NavGraph) navDestinationA).G(b(typedArrayObtainAttributes.getResourceId(R$styleable.NavInclude_graph, 0)));
                    Unit unit = Unit.f68710a;
                    typedArrayObtainAttributes.recycle();
                } else if (navDestinationA instanceof NavGraph) {
                    ((NavGraph) navDestinationA).G(a(resources, xmlResourceParser, attributeSet, i11));
                }
            }
        }
        return navDestinationA;
    }

    @SuppressLint({"ResourceType"})
    public final NavGraph b(int i11) {
        int next;
        Resources res = this.f12284a.getResources();
        XmlResourceParser xml = res.getXml(i11);
        Intrinsics.f(xml, "res.getXml(graphResId)");
        AttributeSet attrs = Xml.asAttributeSet(xml);
        do {
            try {
                try {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } catch (Exception e11) {
                    throw new RuntimeException("Exception inflating " + ((Object) res.getResourceName(i11)) + " line " + xml.getLineNumber(), e11);
                }
            } catch (Throwable th2) {
                xml.close();
                throw th2;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        String name = xml.getName();
        Intrinsics.f(res, "res");
        Intrinsics.f(attrs, "attrs");
        NavDestination navDestinationA = a(res, xml, attrs, i11);
        if (navDestinationA instanceof NavGraph) {
            NavGraph navGraph = (NavGraph) navDestinationA;
            xml.close();
            return navGraph;
        }
        throw new IllegalArgumentException(("Root element <" + ((Object) name) + "> did not inflate into a NavGraph").toString());
    }

    public final void c(Resources resources, NavDestination navDestination, AttributeSet attributeSet, XmlResourceParser xmlResourceParser, int i11) throws XmlPullParserException, IOException {
        int depth;
        Context context = this.f12284a;
        int[] NavAction = androidx.navigation.common.R$styleable.NavAction;
        Intrinsics.f(NavAction, "NavAction");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, NavAction, 0, 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_android_id, 0);
        c cVar = new c(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_destination, 0), null, null, 6, null);
        l.a aVar = new l.a();
        aVar.d(typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_launchSingleTop, false));
        aVar.j(typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_restoreState, false));
        aVar.g(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popUpTo, -1), typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToInclusive, false), typedArrayObtainStyledAttributes.getBoolean(androidx.navigation.common.R$styleable.NavAction_popUpToSaveState, false));
        aVar.b(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_enterAnim, -1));
        aVar.c(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_exitAnim, -1));
        aVar.e(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popEnterAnim, -1));
        aVar.f(typedArrayObtainStyledAttributes.getResourceId(androidx.navigation.common.R$styleable.NavAction_popExitAnim, -1));
        cVar.e(aVar.a());
        Bundle bundle = new Bundle();
        int depth2 = xmlResourceParser.getDepth() + 1;
        while (true) {
            int next = xmlResourceParser.next();
            if (next == 1 || ((depth = xmlResourceParser.getDepth()) < depth2 && next == 3)) {
                break;
            }
            if (next == 2 && depth <= depth2 && Intrinsics.b("argument", xmlResourceParser.getName())) {
                e(resources, bundle, attributeSet, i11);
            }
        }
        if (!bundle.isEmpty()) {
            cVar.d(bundle);
        }
        navDestination.A(resourceId, cVar);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final d d(TypedArray typedArray, Resources resources, int i11) throws XmlPullParserException {
        d.a aVar = new d.a();
        int i12 = 0;
        aVar.c(typedArray.getBoolean(androidx.navigation.common.R$styleable.NavArgument_nullable, false));
        ThreadLocal<TypedValue> threadLocal = f12283d;
        TypedValue typedValue = threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        String string = typedArray.getString(androidx.navigation.common.R$styleable.NavArgument_argType);
        Object objH = null;
        o<Object> oVarA = string != null ? o.f12313c.a(string, resources.getResourcePackageName(i11)) : null;
        if (typedArray.getValue(androidx.navigation.common.R$styleable.NavArgument_android_defaultValue, typedValue)) {
            o<Object> oVar = o.f12315e;
            if (oVarA == oVar) {
                int i13 = typedValue.resourceId;
                if (i13 != 0) {
                    i12 = i13;
                } else if (typedValue.type != 16 || typedValue.data != 0) {
                    throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + oVarA.b() + ". Must be a reference to a resource.");
                }
                objH = Integer.valueOf(i12);
            } else {
                int i14 = typedValue.resourceId;
                if (i14 != 0) {
                    if (oVarA != null) {
                        throw new XmlPullParserException("unsupported value '" + ((Object) typedValue.string) + "' for " + oVarA.b() + ". You must use a \"" + oVar.b() + "\" type to reference other resources.");
                    }
                    objH = Integer.valueOf(i14);
                    oVarA = oVar;
                } else if (oVarA == o.f12323m) {
                    objH = typedArray.getString(androidx.navigation.common.R$styleable.NavArgument_android_defaultValue);
                } else {
                    int i15 = typedValue.type;
                    if (i15 == 3) {
                        String string2 = typedValue.string.toString();
                        if (oVarA == null) {
                            oVarA = o.f12313c.b(string2);
                        }
                        objH = oVarA.h(string2);
                    } else if (i15 == 4) {
                        oVarA = f12282c.a(typedValue, oVarA, o.f12319i, string, "float");
                        objH = Float.valueOf(typedValue.getFloat());
                    } else if (i15 == 5) {
                        oVarA = f12282c.a(typedValue, oVarA, o.f12314d, string, "dimension");
                        objH = Integer.valueOf((int) typedValue.getDimension(resources.getDisplayMetrics()));
                    } else if (i15 == 18) {
                        oVarA = f12282c.a(typedValue, oVarA, o.f12321k, string, "boolean");
                        objH = Boolean.valueOf(typedValue.data != 0);
                    } else {
                        if (i15 < 16 || i15 > 31) {
                            throw new XmlPullParserException(Intrinsics.p("unsupported argument type ", Integer.valueOf(typedValue.type)));
                        }
                        o<Object> oVar2 = o.f12319i;
                        if (oVarA == oVar2) {
                            oVarA = f12282c.a(typedValue, oVarA, oVar2, string, "float");
                            objH = Float.valueOf(typedValue.data);
                        } else {
                            oVarA = f12282c.a(typedValue, oVarA, o.f12314d, string, "integer");
                            objH = Integer.valueOf(typedValue.data);
                        }
                    }
                }
            }
        }
        if (objH != null) {
            aVar.b(objH);
        }
        if (oVarA != null) {
            aVar.d(oVarA);
        }
        return aVar.a();
    }

    public final void e(Resources resources, Bundle bundle, AttributeSet attributeSet, int i11) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavArgument);
        Intrinsics.f(typedArrayObtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        d dVarD = d(typedArrayObtainAttributes, resources, i11);
        if (dVarD.b()) {
            dVarD.d(string, bundle);
        }
        Unit unit = Unit.f68710a;
        typedArrayObtainAttributes.recycle();
    }

    public final void f(Resources resources, NavDestination navDestination, AttributeSet attributeSet, int i11) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavArgument);
        Intrinsics.f(typedArrayObtainAttributes, "res.obtainAttributes(att… R.styleable.NavArgument)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.NavArgument_android_name);
        if (string == null) {
            throw new XmlPullParserException("Arguments must have a name");
        }
        navDestination.a(string, d(typedArrayObtainAttributes, resources, i11));
        Unit unit = Unit.f68710a;
        typedArrayObtainAttributes.recycle();
    }

    public final void g(Resources resources, NavDestination navDestination, AttributeSet attributeSet) throws XmlPullParserException {
        TypedArray typedArrayObtainAttributes = resources.obtainAttributes(attributeSet, androidx.navigation.common.R$styleable.NavDeepLink);
        Intrinsics.f(typedArrayObtainAttributes, "res.obtainAttributes(att… R.styleable.NavDeepLink)");
        String string = typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_uri);
        String string2 = typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_action);
        String string3 = typedArrayObtainAttributes.getString(androidx.navigation.common.R$styleable.NavDeepLink_mimeType);
        if ((string == null || string.length() == 0) && ((string2 == null || string2.length() == 0) && (string3 == null || string3.length() == 0))) {
            throw new XmlPullParserException("Every <deepLink> must include at least one of app:uri, app:action, or app:mimeType");
        }
        NavDeepLink.a aVar = new NavDeepLink.a();
        if (string != null) {
            String packageName = this.f12284a.getPackageName();
            Intrinsics.f(packageName, "context.packageName");
            aVar.d(kotlin.text.l.F(string, "${applicationId}", packageName, false, 4, null));
        }
        if (string2 != null && string2.length() != 0) {
            String packageName2 = this.f12284a.getPackageName();
            Intrinsics.f(packageName2, "context.packageName");
            aVar.b(kotlin.text.l.F(string2, "${applicationId}", packageName2, false, 4, null));
        }
        if (string3 != null) {
            String packageName3 = this.f12284a.getPackageName();
            Intrinsics.f(packageName3, "context.packageName");
            aVar.c(kotlin.text.l.F(string3, "${applicationId}", packageName3, false, 4, null));
        }
        navDestination.e(aVar.a());
        Unit unit = Unit.f68710a;
        typedArrayObtainAttributes.recycle();
    }
}
