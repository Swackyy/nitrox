package com.swacky.nitrox.multiblock;

import com.swacky.nitrox.blocks.ElectrolyticController;
import com.swacky.nitrox.multiblock.electrolysis.BaseElectrolysisBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class PatternedMultiblock {
    public static class Electrolysis {
        public static boolean wallsValid(BlockPos _pos, Level level) {
            pos = _pos;
            boolean output = firstWallsCheck(level) && secondWallsCheck(level) && thirdWallsCheck(level) && fourthWallsCheck(level) && level.getBlockState(pos).getBlock() instanceof ElectrolyticController;
            System.out.println(firstWallsCheck(level) + "1\n" + secondWallsCheck(level)+ "2\n" + thirdWallsCheck(level)+ "3\n" + fourthWallsCheck(level) + "4\n");
            return output;
        }

        private static BlockPos pos;
        private static boolean firstWallsCheck(Level level) {
            // first check - north
            int length = 0;
            if (connectedNorth(pos, level)) {
                while (connectedNorth(pos, level) && !(level.getBlockState(pos).getBlock() instanceof ElectrolyticController)) {
                    pos = pos.north();
                    length++;
                }
                return length > 1;
            } else if (diagonalNE(pos, level)) {
                while (diagonalNE(pos, level)) {
                    pos = pos.north().east();
                    length++;
                }
                return length > 1;
            }
            else return false;
        }
        private static boolean secondWallsCheck(Level level) {
            // second check - e, w, nw, ne
            BlockPos ogPos = pos;
            int length = 0;
            if (connectedEast(pos, level)) {
                while (connectedEast(pos, level)) {
                    pos = pos.east();
                    length++;
                }
                return length > 1;
            } else if (connectedWest(pos, level)) {
                while (connectedWest(pos, level)) {
                    pos = pos.west();
                    length++;
                }
                return length > 1;
            } else if (diagonalNW(pos, level)) {
                while (diagonalNW(pos, level)) {
                    pos = pos.north().west();
                    length++;
                }
                return length > 1;
            } else if (diagonalNE(pos, level)) {
                while (diagonalNE(pos, level)) {
                    pos = pos.north().east();
                    length++;
                }
                return length > 1;
            }
            else return false;
        }
        private static boolean thirdWallsCheck(Level level) {
            // third check - s, n, sw, nw
            int length = 0;
            if (connectedSouth(pos, level)) {
                while (connectedSouth(pos, level)) {
                    pos = pos.south();
                    length++;
                }
                return length > 1;
            } else if (connectedNorth(pos, level)) {
                while (connectedNorth(pos, level)) {
                    pos = pos.north();
                    length++;
                }
                return length > 1;
            } else if (diagonalSW(pos, level)) {
                while (diagonalSW(pos, level)) {
                    pos = pos.south().west();
                    length++;
                }
                return length > 1;
            } else if (diagonalNW(pos, level)) {
                while (diagonalNW(pos, level)) {
                    pos = pos.north().west();
                    length++;
                }
                return length > 1;
            }
            else return false;
        }
        private static boolean fourthWallsCheck(Level level) {
            // fourth check - e, w, se, sw
            int length = 0;
            if (connectedEast(pos, level)) {
                while (connectedEast(pos, level)) {
                    pos = pos.east();
                    length++;
                }
                return length > 1;
            } else if (connectedWest(pos, level)) {
                while (connectedWest(pos, level)) {
                    pos = pos.west();
                    length++;
                }
                return length > 1;
            } else if (diagonalSE(pos, level)) {
                while (diagonalSE(pos, level)) {
                    pos = pos.south().east();
                    length++;
                }
                return length > 1;
            } else if (diagonalSW(pos, level)) {
                while (diagonalSW(pos, level)) {
                    pos = pos.south().west();
                    length++;
                }
                return length > 1;
            }
            else return false;
        }
        public static int getHeight(Level level) {
            int height = 0;
            while(level.getBlockState(pos).getBlock() instanceof BaseElectrolysisBlock) {
                pos = pos.above();
                height++;
            }
            return height;
        }

        public static class Test {
            public static void printDirectConnections(BlockPos pos, Level level) {
                System.out.println(connectedUp(pos, level));
                System.out.println(connectedDown(pos, level));
                System.out.println(connectedNorth(pos, level));
                System.out.println(connectedEast(pos, level));
                System.out.println(connectedSouth(pos, level));
                System.out.println(connectedWest(pos, level));
            }

            public static void printSameYDiagonals(BlockPos pos, Level level) {
                System.out.println(diagonalNE(pos, level));
                System.out.println(diagonalSE(pos, level));
                System.out.println(diagonalSW(pos, level));
                System.out.println(diagonalNW(pos, level));
            }

            public static void printAltYConnections(BlockPos pos, Level level) {
                System.out.println(diagonalUN(pos, level));
                System.out.println(diagonalUE(pos, level));
                System.out.println(diagonalUS(pos, level));
                System.out.println(diagonalUW(pos, level));
                System.out.println(diagonalDN(pos, level));
                System.out.println(diagonalDE(pos, level));
                System.out.println(diagonalDS(pos, level));
                System.out.println(diagonalDW(pos, level));
            }
        }

        // Direct
        private static boolean connectedUp(BlockPos pos, Level level) {
            return level.getBlockState(pos.above()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean connectedDown(BlockPos pos, Level level) {
            return level.getBlockState(pos.below()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean connectedNorth(BlockPos pos, Level level) {
            return level.getBlockState(pos.north()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean connectedEast(BlockPos pos, Level level) {
            return level.getBlockState(pos.east()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean connectedSouth(BlockPos pos, Level level) {
            return level.getBlockState(pos.south()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean connectedWest(BlockPos pos, Level level) {
            return level.getBlockState(pos.west()).getBlock() instanceof BaseElectrolysisBlock;
        }

        // Same Y Diagonals (Top-down view)
        private static boolean diagonalNE(BlockPos pos, Level level) {
            return level.getBlockState(pos.north().east()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalSE(BlockPos pos, Level level) {
            return level.getBlockState(pos.south().east()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalSW(BlockPos pos, Level level) {
            return level.getBlockState(pos.south().west()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalNW(BlockPos pos, Level level) {
            return level.getBlockState(pos.north().west()).getBlock() instanceof BaseElectrolysisBlock;
        }

        // Alternate Y diagonals
        private static boolean diagonalUN(BlockPos pos, Level level) {
            return level.getBlockState(pos.above().north()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalUE(BlockPos pos, Level level) {
            return level.getBlockState(pos.above().east()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalUS(BlockPos pos, Level level) {
            return level.getBlockState(pos.above().south()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalUW(BlockPos pos, Level level) {
            return level.getBlockState(pos.above().west()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalDN(BlockPos pos, Level level) {
            return level.getBlockState(pos.below().north()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalDE(BlockPos pos, Level level) {
            return level.getBlockState(pos.below().east()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalDS(BlockPos pos, Level level) {
            return level.getBlockState(pos.below().south()).getBlock() instanceof BaseElectrolysisBlock;
        }
        private static boolean diagonalDW(BlockPos pos, Level level) {
            return level.getBlockState(pos.below().west()).getBlock() instanceof BaseElectrolysisBlock;
        }
    }
}
