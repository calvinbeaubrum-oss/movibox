package com.transsion.publish.adapter;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.hisavana.sdk.internal.agentpage.AgentPageJsBridge;
import com.google.android.material.imageview.ShapeableImageView;
import com.permissionx.guolindev.PermissionX;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.R$mipmap;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.publish.R$drawable;
import com.transsion.publish.R$layout;
import com.transsion.publish.api.AudioEntity;
import com.transsion.publish.api.GroupBean;
import com.transsion.publish.api.LinkEntity;
import com.transsion.publish.ui.SelectLocationActivity;
import com.transsion.room.api.bean.LocationPlace;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import org.mvel2.ast.ASTNode;

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
@SourceDebugExtension
public final class r extends RecyclerView.Adapter<RecyclerView.a0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<xu.a> f56459i = new ArrayList();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public iw.c f56460j;

    public static final void A(r this$0, Ref.ObjectRef info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        this$0.f56459i.remove(info.element);
        this$0.notifyDataSetChanged();
        List<xu.a> list = this$0.f56459i;
        if (list == null || list.isEmpty()) {
            cw.a aVar = new cw.a();
            aVar.o(4);
            aVar.n(2);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = cw.a.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, aVar, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void C(r this$0, Ref.ObjectRef holder, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Context context = ((z) holder.element).itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        this$0.J(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void D(Ref.ObjectRef info, View view) {
        Intrinsics.g(info, "$info");
        cw.a aVar = new cw.a();
        aVar.o(8);
        aVar.n(2);
        aVar.q((LocationPlace) info.element);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    private final void I(Context context) {
        com.alibaba.android.arouter.launcher.a.d().b("/room/list").withBoolean("is_select_room", true).withInt("index", 1).navigation();
    }

    private final void J(Context context) {
        if (PermissionX.f48641a.e(context, "android.permission.ACCESS_FINE_LOCATION")) {
            Intent intent = new Intent(context, (Class<?>) SelectLocationActivity.class);
            intent.setFlags(ASTNode.DEOP);
            context.startActivity(intent);
        }
    }

    private final void K(Context context) {
        es.b bVar = (es.b) es.a.f64348a.a(es.b.class);
        if (bVar != null) {
            bVar.d(context);
        }
    }

    public static final void M(r this$0, Ref.ObjectRef info, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(info, "$info");
        this$0.f56459i.remove(info.element);
        this$0.notifyDataSetChanged();
        if (this$0.f56459i.isEmpty()) {
            cw.a aVar = new cw.a();
            aVar.o(3);
            aVar.n(2);
            FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
            String name = cw.a.class.getName();
            Intrinsics.f(name, "T::class.java.name");
            flowEventBus.postEvent(name, aVar, 0L);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void N(r this$0, Ref.ObjectRef holder, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Context context = ((i0) holder.element).itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        this$0.K(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void p(r this$0, final Ref.ObjectRef holder, Ref.ObjectRef info, View view) {
        iw.c cVar;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(info, "$info");
        try {
            if (this$0.f56460j == null) {
                this$0.f56460j = new iw.c();
            }
            iw.c cVar2 = this$0.f56460j;
            if (cVar2 != null && cVar2.b()) {
                ((b) holder.element).e().setImageResource(R$drawable.ic_audio_pause);
                iw.c cVar3 = this$0.f56460j;
                if (cVar3 != null) {
                    cVar3.c();
                    return;
                }
                return;
            }
            ((b) holder.element).e().setImageResource(R$drawable.ic_audio_play);
            String localPath = ((AudioEntity) info.element).getLocalPath();
            if (localPath != null && (cVar = this$0.f56460j) != null) {
                Context context = ((b) holder.element).itemView.getContext();
                Intrinsics.f(context, "holder.itemView.context");
                cVar.d(context, localPath, false, new MediaPlayer.OnCompletionListener() { // from class: com.transsion.publish.adapter.q
                    @Override // android.media.MediaPlayer.OnCompletionListener
                    public final void onCompletion(MediaPlayer mediaPlayer) {
                        r.q(holder, mediaPlayer);
                    }
                });
            }
            ((b) holder.element).e().setImageResource(R$drawable.ic_audio_pause);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void q(Ref.ObjectRef holder, MediaPlayer mediaPlayer) {
        Intrinsics.g(holder, "$holder");
        ((b) holder.element).e().setImageResource(R$drawable.ic_audio_play);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(Ref.ObjectRef info, View view) {
        Intrinsics.g(info, "$info");
        cw.a aVar = new cw.a();
        aVar.o(2);
        aVar.n(2);
        aVar.k((AudioEntity) info.element);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(r this$0, Ref.ObjectRef holder, View view) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(holder, "$holder");
        Context context = ((w) holder.element).itemView.getContext();
        Intrinsics.f(context, "holder.itemView.context");
        this$0.I(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void w(Ref.ObjectRef info, View view) {
        Intrinsics.g(info, "$info");
        cw.a aVar = new cw.a();
        aVar.o(6);
        aVar.n(2);
        aVar.m((GroupBean) info.element);
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = cw.a.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.postEvent(name, aVar, 0L);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.transsion.publish.adapter.z] */
    /* JADX WARN: Type inference failed for: r6v1, types: [T, com.transsion.room.api.bean.LocationPlace] */
    public final void B(RecyclerView.a0 a0Var, int i11, xu.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.e(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectLocationHolder");
        objectRef.element = (z) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.room.api.bean.LocationPlace");
        objectRef2.element = (LocationPlace) aVar;
        ((z) objectRef.element).f().setText(((LocationPlace) objectRef2.element).getName() + " " + ((LocationPlace) objectRef2.element).getDistance());
        ((z) objectRef.element).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.C(this.f56453a, objectRef, view);
            }
        });
        ((z) objectRef.element).e().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.D(objectRef2, view);
            }
        });
    }

    public final void E() {
        Iterator<T> it = this.f56459i.iterator();
        while (it.hasNext()) {
            if (((xu.a) it.next()).getType() == 2) {
                iw.c cVar = this.f56460j;
                if (cVar != null) {
                    cVar.c();
                }
                notifyDataSetChanged();
            }
        }
    }

    public final void F(xu.a entity) {
        Intrinsics.g(entity, "entity");
        this.f56459i.remove(entity);
        notifyDataSetChanged();
    }

    public final void G(xu.a aVar) {
        int i11;
        if (aVar == null) {
            return;
        }
        int type = aVar.getType();
        int i12 = 0;
        if (type == 2) {
            i11 = -1;
            for (Object obj : this.f56459i) {
                int i13 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (((xu.a) obj) instanceof AudioEntity) {
                    i11 = i12;
                }
                i12 = i13;
            }
            iw.c cVar = this.f56460j;
            if (cVar != null) {
                cVar.f();
            }
            this.f56460j = null;
        } else if (type == 3) {
            i11 = -1;
            for (Object obj2 : this.f56459i) {
                int i14 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (((xu.a) obj2) instanceof Subject) {
                    i11 = i12;
                }
                i12 = i14;
            }
        } else if (type == 4) {
            i11 = -1;
            for (Object obj3 : this.f56459i) {
                int i15 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (((xu.a) obj3) instanceof LinkEntity) {
                    i11 = i12;
                }
                i12 = i15;
            }
        } else if (type == 6) {
            i11 = -1;
            for (Object obj4 : this.f56459i) {
                int i16 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (((xu.a) obj4) instanceof GroupBean) {
                    i11 = i12;
                }
                i12 = i16;
            }
        } else if (type != 8) {
            i11 = -1;
        } else {
            i11 = -1;
            for (Object obj5 : this.f56459i) {
                int i17 = i12 + 1;
                if (i12 < 0) {
                    kotlin.collections.g.u();
                }
                if (((xu.a) obj5) instanceof LocationPlace) {
                    i11 = i12;
                }
                i12 = i17;
            }
        }
        if (i11 == -1) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(aVar);
            n(arrayList);
        } else {
            this.f56459i.set(i11, aVar);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(this.f56459i);
            H(arrayList2);
        }
    }

    public final void H(List<xu.a> data) {
        Intrinsics.g(data, "data");
        this.f56459i.clear();
        this.f56459i.addAll(data);
        notifyDataSetChanged();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.transsion.publish.adapter.i0] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, com.transsion.moviedetailapi.bean.Subject, xu.a] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void L(RecyclerView.a0 a0Var, int i11, xu.a aVar) {
        String url;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.e(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectWorkHolder");
        objectRef.element = (i0) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
        ?? r11 = (Subject) aVar;
        objectRef2.element = r11;
        ShapeableImageView shapeableImageViewE = ((i0) objectRef.element).e();
        int iA = com.blankj.utilcode.util.f0.a(42.0f);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = shapeableImageViewE.getContext();
        Intrinsics.f(context, "context");
        Cover cover = r11.getCover();
        if (cover == null || (url = cover.getUrl()) == null) {
            url = "";
        }
        companion.o(context, shapeableImageViewE, url, (32704 & 8) != 0 ? R$color.skeleton : R$mipmap.home_ic_default_res, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        ((i0) objectRef.element).h().setText(r11.getTitle());
        try {
            Result.Companion companion2 = Result.Companion;
            AppCompatTextView appCompatTextViewG = ((i0) objectRef.element).g();
            com.transsion.moviedetailapi.helper.a aVar2 = com.transsion.moviedetailapi.helper.a.f53896a;
            CharSequence charSequenceE = aVar2.e(r11);
            if (charSequenceE.length() == 0) {
                charSequenceE = aVar2.g(Integer.valueOf(r11.getType()));
            }
            appCompatTextViewG.setText(charSequenceE);
            appCompatTextViewG.setCompoundDrawablesWithIntrinsicBounds(com.transsion.moviedetailapi.a.a(r11.getSubjectType()), 0, 0, 0);
            Result.m163constructorimpl(appCompatTextViewG);
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (((Subject) objectRef2.element).getCorrelation()) {
            ((i0) objectRef.element).f().setVisibility(4);
        } else {
            ((i0) objectRef.element).f().setVisibility(0);
            ((i0) objectRef.element).f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    r.M(this.f56444a, objectRef2, view);
                }
            });
        }
        ((i0) objectRef.element).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.N(this.f56448a, objectRef, view);
            }
        });
    }

    public final void destroy() {
        iw.c cVar = this.f56460j;
        if (cVar != null) {
            cVar.f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f56459i.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        int type = this.f56459i.get(i11).getType();
        int i12 = 2;
        if (type != 2) {
            i12 = 3;
            if (type != 3) {
                i12 = 4;
                if (type != 4) {
                    i12 = 6;
                    if (type != 6) {
                        i12 = 8;
                        if (type != 8) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i12;
    }

    public final void n(List<xu.a> data) {
        Intrinsics.g(data, "data");
        int size = this.f56459i.size();
        this.f56459i.addAll(data);
        notifyItemRangeInserted(size, data.size());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v1, types: [T, com.transsion.publish.adapter.b] */
    /* JADX WARN: Type inference failed for: r7v1, types: [T, com.transsion.publish.api.AudioEntity] */
    public final void o(RecyclerView.a0 a0Var, int i11, xu.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.e(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectAudioHolder");
        objectRef.element = (b) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.publish.api.AudioEntity");
        objectRef2.element = (AudioEntity) aVar;
        ((b) objectRef.element).h().setText(((AudioEntity) objectRef2.element).getImageTitle());
        TextView textViewG = ((b) objectRef.element).g();
        Long duration = ((AudioEntity) objectRef2.element).getDuration();
        textViewG.setText(duration != null ? TimeUtilKt.j(duration.longValue() / ((long) 1000)) : null);
        iw.c cVar = this.f56460j;
        if (cVar == null || !cVar.b()) {
            ((b) objectRef.element).e().setImageResource(R$drawable.ic_audio_play);
        } else {
            ((b) objectRef.element).e().setImageResource(R$drawable.ic_audio_pause);
        }
        ((b) objectRef.element).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.p(this.f56431a, objectRef, objectRef2, view);
            }
        });
        ((b) objectRef.element).f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.r(objectRef2, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.a0 holder, int i11) {
        Intrinsics.g(holder, "holder");
        xu.a aVar = this.f56459i.get(i11);
        int type = aVar.getType();
        if (type == 2) {
            o(holder, i11, aVar);
            return;
        }
        if (type == 3) {
            L(holder, i11, aVar);
            return;
        }
        if (type == 4) {
            z(holder, i11, aVar);
        } else if (type == 6) {
            u(holder, i11, aVar);
        } else {
            if (type != 8) {
                return;
            }
            B(holder, i11, aVar);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 == 2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_music, parent, false);
            Intrinsics.f(view, "view");
            return new b(view);
        }
        if (i11 == 3) {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_work, parent, false);
            Intrinsics.f(view2, "view");
            return new i0(view2);
        }
        if (i11 == 4) {
            View view3 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_link, parent, false);
            Intrinsics.f(view3, "view");
            return new y(view3);
        }
        if (i11 == 6) {
            View view4 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_group, parent, false);
            Intrinsics.f(view4, "view");
            return new w(view4);
        }
        if (i11 != 8) {
            return new c(null);
        }
        View view5 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_publish_location, parent, false);
        Intrinsics.f(view5, "view");
        return new z(view5);
    }

    public final List<xu.a> s() {
        return this.f56459i;
    }

    public final String t() {
        String strValueOf = "";
        for (xu.a aVar : this.f56459i) {
            if (aVar.getType() == 3) {
                Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.Subject");
                strValueOf = String.valueOf(((Subject) aVar).getSubjectId());
            }
        }
        return strValueOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, com.transsion.publish.adapter.w] */
    /* JADX WARN: Type inference failed for: r4v1, types: [T, com.transsion.publish.api.GroupBean] */
    public final void u(RecyclerView.a0 a0Var, int i11, xu.a aVar) {
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.e(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectGroupHolder");
        objectRef.element = (w) a0Var;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.publish.api.GroupBean");
        objectRef2.element = (GroupBean) aVar;
        ((w) objectRef.element).f().setText(((GroupBean) objectRef2.element).getName());
        ((w) objectRef.element).itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.v(this.f56450a, objectRef, view);
            }
        });
        ((w) objectRef.element).e().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.w(objectRef2, view);
            }
        });
    }

    public final boolean x() {
        List<xu.a> list = this.f56459i;
        return list == null || list.isEmpty();
    }

    public final boolean y() {
        List<xu.a> list = this.f56459i;
        if (list == null || list.isEmpty()) {
            return false;
        }
        List<xu.a> list2 = this.f56459i;
        if (list2 == null || list2.size() != 1 || this.f56459i.get(0).getType() == 3) {
            return this.f56459i.size() == 1 && this.f56459i.get(0).getType() == 3;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r10v1, types: [T, com.transsion.publish.api.LinkEntity] */
    public final void z(RecyclerView.a0 a0Var, int i11, xu.a aVar) {
        Intrinsics.e(a0Var, "null cannot be cast to non-null type com.transsion.publish.adapter.SelectLinksHolder");
        y yVar = (y) a0Var;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Intrinsics.e(aVar, "null cannot be cast to non-null type com.transsion.publish.api.LinkEntity");
        ?? r11 = (LinkEntity) aVar;
        objectRef.element = r11;
        String url = r11.getUrl();
        String strH = url != null ? kotlin.text.l.H(url, "https://www.", "", false, 4, null) : null;
        String strH2 = strH != null ? kotlin.text.l.H(strH, "http://www.", "", false, 4, null) : null;
        String strH3 = strH2 != null ? kotlin.text.l.H(strH2, "www.", "", false, 4, null) : null;
        String strH4 = strH3 != null ? kotlin.text.l.H(strH3, AgentPageJsBridge.HTTPS, "", false, 4, null) : null;
        yVar.f().setText(strH4 != null ? kotlin.text.l.H(strH4, "http://", "", false, 4, null) : null);
        yVar.e().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.publish.adapter.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                r.A(this.f56456a, objectRef, view);
            }
        });
    }
}
