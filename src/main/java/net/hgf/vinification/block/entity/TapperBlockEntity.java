package net.hgf.vinification.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.hgf.vinification.item.ModItems;
import net.hgf.vinification.screen.TapperScreenHandler;
import net.hgf.vinification.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static net.hgf.vinification.block.custom.Tapper.FACING;

public class TapperBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);



    private static final int OUTPUT_SLOT = 0;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 60;

    public TapperBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TAPPER_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> TapperBlockEntity.this.progress;
                    case 1 -> TapperBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0:
                        TapperBlockEntity.this.progress = value;
                    case 1:
                        TapperBlockEntity.this.maxProgress = value;
                }

            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);

    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Tapper");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new TapperScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("tapper.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("tapper.progress");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos) {
        BlockState state = world.getBlockState(pos);
        Direction facing = state.get(FACING);
        BlockPos blockBehindPos = pos.offset(facing.getOpposite());

        if (isVerticalLog(world, pos) || isVerticalLog(world, blockBehindPos)) {

            if (canInsertIntoOutPutSlot()) {
                increaseCraftingProgress();
                markDirty(world, pos, state);

                if (hasCraftingFinished()) {
                    craftItem();
                    resetProgress();
                }
            }

        } else {
            resetProgress();
        }
    }


    private void craftItem() {
        this.setStack(OUTPUT_SLOT, new ItemStack(ModItems.SAP,
                this.getStack(OUTPUT_SLOT).getCount() + 1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean canInsertIntoOutPutSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
    private boolean isVerticalLog(World world, BlockPos pos) {
    Block block = world.getBlockState(pos).getBlock();
    Block blockAbove = world.getBlockState(pos.up()).getBlock();
    Block blockBelow = world.getBlockState(pos.down()).getBlock();

    // Check if the block and at least one adjacent block is a log
    return (block == Blocks.ACACIA_LOG || block == Blocks.BIRCH_LOG || block == Blocks.CHERRY_LOG ||
            block == Blocks.DARK_OAK_LOG || block == Blocks.JUNGLE_LOG || block == Blocks.MANGROVE_LOG ||
            block == Blocks.OAK_LOG || block == Blocks.SPRUCE_LOG) &&
           (blockAbove == Blocks.ACACIA_LOG || blockAbove == Blocks.BIRCH_LOG || blockAbove == Blocks.CHERRY_LOG ||
            blockAbove == Blocks.DARK_OAK_LOG || blockAbove == Blocks.JUNGLE_LOG || blockAbove == Blocks.MANGROVE_LOG ||
            blockAbove == Blocks.OAK_LOG || blockAbove == Blocks.SPRUCE_LOG ||
            blockBelow == Blocks.ACACIA_LOG || blockBelow == Blocks.BIRCH_LOG || blockBelow == Blocks.CHERRY_LOG ||
            blockBelow == Blocks.DARK_OAK_LOG || blockBelow == Blocks.JUNGLE_LOG || blockBelow == Blocks.MANGROVE_LOG ||
            blockBelow == Blocks.OAK_LOG || blockBelow == Blocks.SPRUCE_LOG);
}
}