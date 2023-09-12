package net.hgf.vinification.util;

import net.hgf.vinification.Vinification;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> KEG_BLOCKS =
                createBlockTag("keg_blocks");
        public static final TagKey<Block> LOG_BLOCKS =
                createBlockTag("log_blocks.json");

        private static TagKey<Block> createBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(Vinification.MOD_ID, name));
        }

        private static TagKey<Block> createCommonBlockTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier("c", name));
        }

        public static class Items {

            private static TagKey<Item> createItemTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, new Identifier(Vinification.MOD_ID, name));
            }

            private static TagKey<Item> createCommonItemTag(String name) {
                return TagKey.of(RegistryKeys.ITEM, new Identifier("c", name));
            }
        }
    }
}
