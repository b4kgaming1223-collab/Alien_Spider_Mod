package com.b4kgaming.alienspidermod;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

@Mod(AlienSpiderMod.MODID)
public class AlienSpiderMod {
    public static final String MODID = "alienspidermod";
    
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MODID);
    
    public static final RegistryObject<EntityType<AlienSpiderEntity>> ALIEN_SPIDER = ENTITIES.register("alien_spider",
            () -> EntityType.Builder.of(AlienSpiderEntity::new, MobCategory.MONSTER)
                    .sized(1.4F, 0.9F)
                    .build(new ResourceLocation(MODID, "alien_spider").toString()));

    public AlienSpiderMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ENTITIES.register(modEventBus);
        modEventBus.addListener(this::registerAttributes);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ALIEN_SPIDER.get(), AlienSpiderEntity.createAttributes().build());
    }

    // --- ENTITY CLASS ---
    public static class AlienSpiderEntity extends Monster {
        public AlienSpiderEntity(EntityType<? extends Monster> type, Level level) {
            super(type, level);
        }

        public static AttributeSupplier.Builder createAttributes() {
            return Monster.createMonsterAttributes()
                    .add(Attributes.MAX_HEALTH, 40.0D)
                    .add(Attributes.ATTACK_DAMAGE, 5.0D)
                    .add(Attributes.MOVEMENT_SPEED, 0.3D);
        }
    }

    // --- BLOCKBENCH MODEL CLASS ---
    public static class CustomModel<T extends AlienSpiderEntity> extends EntityModel<T> {
        public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(MODID, "custommodel"), "main");
        private final ModelPart head;
        private final ModelPart body0;
        private final ModelPart body1;
        private final ModelPart leg0;
        private final ModelPart leg1;
        private final ModelPart leg2;
        private final ModelPart leg3;
        private final ModelPart leg4;
        private final ModelPart leg5;
        private final ModelPart leg6;
        private final ModelPart leg7;

        public CustomModel(ModelPart root) {
            this.head = root.getChild("head");
            this.body0 = root.getChild("body0");
            this.body1 = root.getChild("body1");
            this.leg0 = root.getChild("leg0");
            this.leg1 = root.getChild("leg1");
            this.leg2 = root.getChild("leg2");
            this.leg3 = root.getChild("leg3");
            this.leg4 = root.getChild("leg4");
            this.leg5 = root.getChild("leg5");
            this.leg6 = root.getChild("leg6");
            this.leg7 = root.getChild("leg7");
        }

        public static LayerDefinition createLayer() {
            MeshDefinition meshdefinition = new MeshDefinition();
            PartDefinition partdefinition = meshdefinition.getRoot();

            partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 4).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offset(0.0F, 15.0F, -3.0F));
            partdefinition.addOrReplaceChild("body0", CubeListBuilder.create().texOffs(0, 0).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offset(0.0F, 15.0F, 0.0F));
            partdefinition.addOrReplaceChild("body1", CubeListBuilder.create().texOffs(0, 12).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offset(0.0F, 15.0F, 9.0F));
            
            // Legs mappings from CustomModel.java
            partdefinition.addOrReplaceChild("leg0", CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(-4.0F, 15.0F, 2.0F, 0.0F, 0.7854F, -0.7854F));
            partdefinition.addOrReplaceChild("leg1", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(4.0F, 15.0F, 2.0F, 0.0F, -0.7854F, 0.7854F));
            partdefinition.addOrReplaceChild("leg2", CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(-4.0F, 15.0F, 1.0F, 0.0F, 0.2618F, -0.6109F));
            partdefinition.addOrReplaceChild("leg3", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(4.0F, 15.0F, 1.0F, 0.0F, -0.2618F, 0.6109F));
            partdefinition.addOrReplaceChild("leg4", CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(-4.0F, 15.0F, 0.0F, 0.0F, -0.2618F, -0.6109F));
            partdefinition.addOrReplaceChild("leg5", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(4.0F, 15.0F, 0.0F, 0.0F, 0.2618F, 0.6109F));
            partdefinition.addOrReplaceChild("leg6", CubeListBuilder.create().texOffs(18, 0).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(-4.0F, 15.0F, -1.0F, 0.0F, -0.7854F, -0.7854F));
            partdefinition.addOrReplaceChild("leg7", CubeListBuilder.create().texOffs(18, 0).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), net.minecraft.client.model.geom.builders.PartPose.offsetAndRotation(4.0F, 15.0F, -1.0F, 0.0F, 0.7854F, 0.7854F));

            return LayerDefinition.create(meshdefinition, 128, 128);
        }

        @Override
        public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            body0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            body1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg0.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg1.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg2.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg3.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg4.render(poseStack, consumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg5.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg6.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            leg7.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }
}
