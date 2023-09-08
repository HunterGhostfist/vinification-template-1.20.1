package net.hgf.vinification.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;

public class Tapper extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    private static final VoxelShape SHAPE_NORTH = Block.createCuboidShape(3, 0, 6, 13, 11, 16);
    private static final VoxelShape SHAPE_EAST = Block.createCuboidShape(0, 0, 3, 10, 11, 13);
    private static final VoxelShape SHAPE_SOUTH = Block.createCuboidShape(3, 0, 0, 13, 11, 10);
    private static final VoxelShape SHAPE_WEST = Block.createCuboidShape(6, 0, 3, 16, 11, 13);

    public Tapper(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);

    switch (direction) {
        case NORTH:
            return SHAPE_NORTH;
        case SOUTH:
            return SHAPE_SOUTH;
        case EAST:
            return SHAPE_EAST;
        case WEST:
            return SHAPE_WEST;
        default:
            return super.getOutlineShape(state, world, pos, context);
    }
}

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
