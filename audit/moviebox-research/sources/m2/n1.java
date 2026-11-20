package m2;

import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.Log;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

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
public final class n1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f70628a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f70629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Constructor<StaticLayout> f70630c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Constructor<StaticLayout> b() {
            if (n1.f70629b) {
                return n1.f70630c;
            }
            n1.f70629b = true;
            try {
                Class cls = Integer.TYPE;
                Class cls2 = Float.TYPE;
                n1.f70630c = StaticLayout.class.getConstructor(CharSequence.class, cls, cls, TextPaint.class, cls, Layout.Alignment.class, TextDirectionHeuristic.class, cls2, cls2, Boolean.TYPE, TextUtils.TruncateAt.class, cls, cls);
            } catch (NoSuchMethodException unused) {
                n1.f70630c = null;
                Log.e("StaticLayoutFactory", "unable to collect necessary constructor.");
            }
            return n1.f70630c;
        }
    }

    @Override // m2.o1
    public StaticLayout a(p1 p1Var) {
        Constructor constructorB = f70628a.b();
        StaticLayout staticLayout = null;
        if (constructorB != null) {
            try {
                staticLayout = (StaticLayout) constructorB.newInstance(p1Var.r(), Integer.valueOf(p1Var.q()), Integer.valueOf(p1Var.e()), p1Var.o(), Integer.valueOf(p1Var.u()), p1Var.a(), p1Var.s(), Float.valueOf(p1Var.m()), Float.valueOf(p1Var.l()), Boolean.valueOf(p1Var.g()), p1Var.c(), Integer.valueOf(p1Var.d()), Integer.valueOf(p1Var.n()));
            } catch (IllegalAccessException unused) {
                f70630c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InstantiationException unused2) {
                f70630c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            } catch (InvocationTargetException unused3) {
                f70630c = null;
                Log.e("StaticLayoutFactory", "unable to call constructor");
            }
        }
        return staticLayout != null ? staticLayout : new StaticLayout(p1Var.r(), p1Var.q(), p1Var.e(), p1Var.o(), p1Var.u(), p1Var.a(), p1Var.m(), p1Var.l(), p1Var.g(), p1Var.c(), p1Var.d());
    }

    @Override // m2.o1
    public boolean b(StaticLayout staticLayout, boolean z11) {
        return false;
    }
}
