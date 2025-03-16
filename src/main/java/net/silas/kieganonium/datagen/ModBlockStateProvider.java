package net.silas.kieganonium.datagen;

import net.silas.kieganonium.Kieganonium;
import net.silas.kieganonium.block.ModBlocks;
import net.silas.kieganonium.block.custom.KieganoniumLampBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Kieganonium.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.KIEGANONIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_KIEGANONIUM_BLOCK);

        blockWithItem(ModBlocks.KIEGANONIUM_ORE);
        blockWithItem(ModBlocks.KIEGANONIUM_DEEPSLATE_ORE);

        blockWithItem(ModBlocks.MAGIC_BLOCK);

        stairsBlock(ModBlocks.KIEGANONIUM_STAIRS.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));
        slabBlock(ModBlocks.KIEGANONIUM_SLAB.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));

        buttonBlock(ModBlocks.KIEGANONIUM_BUTTON.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));
        pressurePlateBlock(ModBlocks.KIEGANONIUM_PRESSURE_PLATE.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));

        fenceBlock(ModBlocks.KIEGANONIUM_FENCE.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));
        fenceGateBlock(ModBlocks.KIEGANONIUM_FENCE_GATE.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));
        wallBlock(ModBlocks.KIEGANONIUM_WALL.get(), blockTexture(ModBlocks.KIEGANONIUM_BLOCK.get()));

        doorBlockWithRenderType(ModBlocks.KIEGANONIUM_DOOR.get(), modLoc("block/kieganonium_door_bottom"), modLoc("block/kieganonium_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.KIEGANONIUM_TRAPDOOR.get(), modLoc("block/kieganonium_trapdoor"), true, "cutout");

        blockItem(ModBlocks.KIEGANONIUM_STAIRS);
        blockItem(ModBlocks.KIEGANONIUM_SLAB);
        blockItem(ModBlocks.KIEGANONIUM_PRESSURE_PLATE);
        blockItem(ModBlocks.KIEGANONIUM_FENCE_GATE);
        blockItem(ModBlocks.KIEGANONIUM_TRAPDOOR, "_bottom");

        customLamp();
    }

    private void customLamp() {
        getVariantBuilder(ModBlocks.KIEGANONIUM_LAMP.get()).forAllStates(state -> {
            if (state.getValue(KieganoniumLampBlock.CLICKED)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("kieganonium_lamp_on",
                        ResourceLocation.fromNamespaceAndPath(Kieganonium.MOD_ID, "block/" + "kieganonium_lamp_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll("kieganonium_lamp_off",
                        ResourceLocation.fromNamespaceAndPath(Kieganonium.MOD_ID, "block/" + "kieganonium_lamp_off")))};
            }
        });
        simpleBlockItem(ModBlocks.KIEGANONIUM_LAMP.get(), models().cubeAll("kieganonium_lamp_on",
                ResourceLocation.fromNamespaceAndPath(Kieganonium.MOD_ID, "block/" + "kieganonium_lamp_on")));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("kieganonium:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("kieganonium:block/" +
                ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath() + appendix));
    }
}