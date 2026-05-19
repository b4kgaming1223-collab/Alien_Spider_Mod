package com.b4kgaming.alienspidermod;

import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.PartPose;
import net.minecraftforge.fml.common.Mod;

@Mod(AlienSpiderMod.MOD_ID)
public class AlienSpiderMod {
    public static final String MOD_ID = "alienspidermod";

    public static MeshDefinition createMesh() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        // Head
        partdefinition.addOrReplaceChild("head", 
            CubeListBuilder.create().texOffs(0, 20).addBox(-4.0F, -4.0F, -8.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 15.0F, -3.0F));

        // Body0
        partdefinition.addOrReplaceChild("body0", 
            CubeListBuilder.create().texOffs(32, 24).addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 15.0F, 0.0F));

        // Body1
        partdefinition.addOrReplaceChild("body1", 
            CubeListBuilder.create().texOffs(0, 0).addBox(-5.0F, -4.0F, -6.0F, 10.0F, 8.0F, 12.0F, new CubeDeformation(0.0F)), 
            PartPose.offset(0.0F, 15.0F, 9.0F));

        // Leg0
        partdefinition.addOrReplaceChild("leg0", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(-4.0F, 15.0F, 2.0F, 0.0F, 0.7854F, -0.7854F));

        // Leg1
        partdefinition.addOrReplaceChild("leg1", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(4.0F, 15.0F, 2.0F, 0.0F, -0.7854F, 0.7854F));

        // Leg2
        partdefinition.addOrReplaceChild("leg2", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(-4.0F, 15.0F, 1.0F, 0.0F, 0.2618F, -0.6109F));

        // Leg3
        partdefinition.addOrReplaceChild("leg3", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(4.0F, 15.0F, 1.0F, 0.0F, -0.2618F, 0.6109F));

        // Leg4
        partdefinition.addOrReplaceChild("leg4", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(-4.0F, 15.0F, 0.0F, 0.0F, -0.2618F, -0.6109F));

        // Leg5
        partdefinition.addOrReplaceChild("leg5", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(4.0F, 15.0F, 0.0F, 0.0F, 0.2618F, 0.6109F));

        // Leg6
        partdefinition.addOrReplaceChild("leg6", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-15.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(-4.0F, 15.0F, -1.0F, 0.0F, -0.7854F, -0.7854F));

        // Leg7
        partdefinition.addOrReplaceChild("leg7", 
            CubeListBuilder.create().texOffs(32, 20).addBox(-1.0F, -1.0F, -1.0F, 16.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), 
            PartPose.offsetAndRotation(4.0F, 15.0F, -1.0F, 0.0F, 0.7854F, 0.7854F));

        return meshdefinition;
    }
}
