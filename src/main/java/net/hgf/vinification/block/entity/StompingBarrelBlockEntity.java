package net.hgf.vinification.block.entity;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.hgf.vinification.recipe.StompingBarrelRecipe;
import net.hgf.vinification.screen.StompingBarrelScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class StompingBarrelBlockEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3, ItemStack.EMPTY);
    private Vec3d previousPlayerPos;
    private boolean isCraftingInProgress;
    private int craftingProgress;
    private int craftingInterval = 2;

    private static final int INPUT_SLOT = 0;
    private static final int BOTTLE_INPUT_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public StompingBarrelBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.STOMPING_BARREL_BE, pos, state);
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> StompingBarrelBlockEntity.this.progress;
                    case 1 -> StompingBarrelBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> StompingBarrelBlockEntity.this.progress = value;
                    case 1 -> StompingBarrelBlockEntity.this.maxProgress = value;
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
        return Text.literal("Stomping Barrel");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StompingBarrelScreenHandler(syncId, playerInventory, this, propertyDelegate);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return this.inventory;
    }

    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("stomping_barrel.progress", progress);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("stomping_barrel.progress");
        super.readNbt(nbt);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        Vec3d blockCenter = new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5);

        for (PlayerEntity player : world.getPlayers()) {
            Vec3d playerPos = player.getPos();

            if (playerPos.distanceTo(blockCenter) < 0.5) {
                if (!playerPos.equals(this.previousPlayerPos)) { // Check if the player's position has changed.
                    // Player is moving, update crafting progress.
                    if (!isCraftingInProgress) {
                        isCraftingInProgress = true; // Start crafting progress.
                    }

                    if (canInsertIntoOutputSlot() && hasRecipe()) {
                        if (world.getTime() % craftingInterval == 0) {
                            increaseCraftingProgress();
                            markDirty(world, pos, state);

                            if (hasCraftingFinished()) {
                                craftItem();
                                resetProgress();
                            }

                        }
                    }
                }
                else {
                    // Player has stopped moving but crafting is still in progress.
                    // No need to reset crafting progress.
                    if (!hasRecipe()) {
                        resetProgress();
                    }
                }

                this.previousPlayerPos = playerPos; // Update the previous player position.
            } else {
                // Player is no longer inside the block but crafting is still in progress
                if (!hasRecipe()) {
                    resetProgress();
                }
            }
        }
    }

    private void craftItem() {
        Optional<StompingBarrelRecipe> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(BOTTLE_INPUT_SLOT, 1);

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().getOutput(null).getItem(),
                this.getStack(OUTPUT_SLOT).getCount() + recipe.get().getOutput(null).getCount()));
    }

    private void resetProgress() {this.progress = 0;}

    private boolean hasCraftingFinished() {return this.progress >= this.maxProgress;}

    private void increaseCraftingProgress() {this.progress++;}

    private boolean hasRecipe() {
        Optional<StompingBarrelRecipe> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().getOutput(null);
        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<StompingBarrelRecipe> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory((this.size()));
        for(int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return  this.getWorld().getRecipeManager().getFirstMatch(StompingBarrelRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }
}