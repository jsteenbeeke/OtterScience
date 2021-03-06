package com.jeroensteenbeeke.bukkit.otterscience.generator;

import java.util.List;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.generator.BlockPopulator;
import org.bukkit.generator.ChunkGenerator;

import com.google.common.collect.Lists;
import com.jeroensteenbeeke.bukkit.otterscience.OtterSciencePlugin;

public class OtterLabGenerator extends ChunkGenerator {
	static enum Mode {
		TOP_LEFT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {
					if (xx == 0 || zz == MAX)
						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);

					if (xx == 1 || zz == MAX - 1)
						return id(Material.IRON_BLOCK);
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		TOP {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {
					if (zz == MAX) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 7, 8))
							return id(Material.AIR);

						if (in(yy, FLOOR_HEIGHT, FLOOR_HEIGHT + 3)
								&& in(xx, 6, 7, 8, 9))
							return id(Material.GLOWSTONE);

						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 6, 9))
							return id(Material.GLOWSTONE);

						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);
					} else if (zz == MAX - 1) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 7, 8))
							return id(Material.AIR);

						return id(Material.IRON_BLOCK);
					}
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		TOP_RIGHT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy == 0 || yy == 1)
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {

					if (xx == MAX || zz == MAX)
						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);

					if (xx == MAX - 1 || zz == MAX - 1)
						return id(Material.IRON_BLOCK);
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		LEFT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {

					if (xx == 0) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 7, 8))
							return id(Material.AIR);

						if (in(yy, FLOOR_HEIGHT, FLOOR_HEIGHT + 3)
								&& in(zz, 6, 7, 8, 9))
							return id(Material.GLOWSTONE);

						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 6, 9))
							return id(Material.GLOWSTONE);

						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);
					} else if (xx == 1) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 7, 8))
							return id(Material.AIR);

						return id(Material.IRON_BLOCK);
					}
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		CENTER {
			@Override
			public byte getBlock(int xx, int yy, int zz) {

				if (yy <= (FLOOR_HEIGHT - 8))
					return id(Material.BEDROCK);

				if (yy <= FLOOR_HEIGHT)
					return id(Material.IRON_BLOCK);

				if (yy == GLASS_HEIGHT)
					return id(Material.GLASS);

				return 0;
			}

		},
		RIGHT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {

					if (xx == MAX) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 7, 8))
							return id(Material.AIR);

						if (in(yy, FLOOR_HEIGHT, FLOOR_HEIGHT + 3)
								&& in(zz, 6, 7, 8, 9))
							return id(Material.GLOWSTONE);

						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 6, 9))
							return id(Material.GLOWSTONE);

						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);
					} else if (xx == MAX - 1) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(zz, 7, 8))
							return id(Material.AIR);

						return id(Material.IRON_BLOCK);
					}
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		BOTTOM_LEFT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {

					if (xx == 0 || zz == 0)
						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);

					if (xx == 1 || zz == 1)
						return id(Material.IRON_BLOCK);
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		BOTTOM {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {

					if (zz == 0) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 7, 8))
							return id(Material.AIR);

						if (in(yy, FLOOR_HEIGHT, FLOOR_HEIGHT + 3)
								&& in(xx, 6, 7, 8, 9))
							return id(Material.GLOWSTONE);

						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 6, 9))
							return id(Material.GLOWSTONE);

						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);
					} else if (zz == 1) {
						if (in(yy, FLOOR_HEIGHT + 1, FLOOR_HEIGHT + 2)
								&& in(xx, 7, 8))
							return id(Material.AIR);

						return id(Material.IRON_BLOCK);
					}
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		},
		BOTTOM_RIGHT {
			@Override
			public byte getBlock(int xx, int yy, int zz) {
				if (yy <= (FLOOR_HEIGHT - 1))
					return id(Material.BEDROCK);

				if (yy <= MAX_WALL_HEIGHT) {
					if (xx == MAX || zz == 0)
						if (yy == MAX_WALL_HEIGHT)
							return id(Material.IRON_BLOCK);
						else
							return id(Material.BEDROCK);

					if (xx == MAX - 1 || zz == 1)
						return id(Material.IRON_BLOCK);
				}

				return CENTER.getBlock(xx, yy, zz);
			}

		};

		public static Mode getMode(int x, int z) {
			int modx = formula(x);
			int modz = formula(z);

			switch (modx) {
			case 0:
				switch (modz) {
				case 0:
					return BOTTOM_LEFT;
				case 1:
					return LEFT;
				case 2:
					return LEFT;
				case 3:
					return TOP_LEFT;
				}
			case 1:
			case 2:
				switch (modz) {
				case 0:
					return BOTTOM;
				case 1:
					return CENTER;
				case 2:
					return CENTER;
				case 3:
					return TOP;
				}

			case 3:
				switch (modz) {
				case 0:
					return BOTTOM_RIGHT;
				case 1:
					return RIGHT;
				case 2:
					return RIGHT;
				case 3:
					return TOP_RIGHT;
				}
			}

			return CENTER;
		}

		public abstract byte getBlock(int xx, int yy, int zz);

		protected boolean in(int base, int... values) {
			for (int v : values) {
				if (base == v)
					return true;
			}

			return false;
		}

		protected byte id(Material m) {
			return (byte) m.getId();
		}

		static int formula(int base) {
			return base >= 0 ? base % 4 : fourify(base);
		}

		static int fourify(int base) {
			int rv = base;

			while (rv < 0)
				rv += 4;

			return rv;
		}

	}

	private static final int MAX = 15;

	private static final int MAX_WALL_HEIGHT = 81;

	public static final int GLASS_HEIGHT = 80;

	public static final int FLOOR_HEIGHT = 51;

	private final OtterSciencePlugin plugin;

	public OtterLabGenerator(OtterSciencePlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public List<BlockPopulator> getDefaultPopulators(World world) {

		return Lists.<BlockPopulator> newArrayList(new LabPopulator(plugin));
	}

	@Override
	public byte[][] generateBlockSections(World world, Random random, int x,
			int z, BiomeGrid biomes) {
		int maxY = world.getMaxHeight() / 16;

		byte[][] result = new byte[maxY][];

		Mode mode = Mode.getMode(x, z);

		for (int xx = 0; xx < 16; xx++) {
			for (int zz = 0; zz < 16; zz++) {
				for (int yy = 0; yy < world.getMaxHeight(); yy++) {
					setBlock(result, xx, yy, zz, mode.getBlock(xx, yy, zz));
				}
			}
		}

		return result;

	}

	void setBlock(byte[][] result, int x, int y, int z, byte blkid) {
		if (result[y >> 4] == null) {
			result[y >> 4] = new byte[4096];
		}

		result[y >> 4][((y & 0xF) << 8) | (z << 4) | x] = blkid;
	}

	public Location getFixedSpawnLocation(World world, Random random) {
		return new Location(world, 0, 64, 0);
	}
}
