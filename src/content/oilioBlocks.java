package content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.entities.effect.RadialEffect;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.distribution.*;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.Drill;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.blocks.production.Pump;
import mindustry.world.blocks.storage.CoreBlock;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class oilioBlocks {
    public static Block
            //production
            icp, icd, pumpingunit,
            //power
            ice,
            //crafting
            graphitesolidifier, deoxidizer,
            //distribution
            heavyconveyor, heavyrouter, overflowredirector, heavyjunction, heavybridge, heavysorter,
            //storage
            corebase,
            //turret
            //wall
            //ore
            oresalt
            ;

    public static void load() {
        //production

        icp = new Pump("pie"){{
            requirements(Category.liquid, with(Items.lead, 10, Items.graphite, 16));
            size = 2;
            pumpAmount = 6f / 60f;
            alwaysUnlocked = true;
        }};

        icd = new Drill("die"){{
            requirements(Category.production, with(Items.graphite, 12));
            tier = 3;
            drillTime = 120;
            size = 2;
            alwaysUnlocked = true;
        }};

        pumpingunit = new Pump("pumping-unit"){{
            requirements(Category.liquid, with(Items.lead, 10, Items.graphite, 16));
            size = 2;
            pumpAmount = 6f / 60f;
            researchCost = with(Items.lead, 40, Items.graphite, 64);
        }};

        //power

        ice = new ConsumeGenerator("ice"){{
            requirements(Category.power, with(Items.lead, 20, Items.graphite, 30));
            powerProduction = 2f;
            consumeLiquids(LiquidStack.with(Liquids.oil, 40f / 60f));
            size = 3;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawPistons(){{
                sinMag = 3f;
                sinScl = 5f;
            }}, new DrawRegion("-mid"), new DrawLiquidTile(Liquids.oil, 37f / 4f), new DrawDefault(), new DrawGlowRegion(){{
                alpha = 1f;
                glowScale = 5f;
                color = Color.valueOf("c967b099");
            }});
            generateEffect = Fx.none;
            liquidCapacity = 24f;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.06f;

            researchCost = with(Items.lead, 80, Items.graphite, 120);
        }};

        //crafting

        graphitesolidifier = new GenericCrafter("graphite-solidifier"){{
            requirements(Category.crafting, with(Items.lead, 12, Items.graphite, 40));
            outputItem = new ItemStack(Items.graphite, 1);
            size = 2;
            hasPower = true;
            hasItems = true;
            hasLiquids = true;
            rotate = false;
            solid = true;
            outputsLiquid = true;
            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.oil), new DrawDefault());
            liquidCapacity = 24f;
            craftTime = 180;

            consumePower(1f);
            consumeLiquid(Liquids.water, 12f / 60f);
            alwaysUnlocked = true;
        }};

        deoxidizer = new GenericCrafter("deoxidizer"){{
            requirements(Category.crafting, with(Items.lead, 100, Items.graphite, 80));
            size = 3;
            itemCapacity = 20;
            craftTime = 120;
            liquidCapacity = 80f * 5;
            hasLiquids = true;
            ambientSound = Sounds.smelter;
            ambientSoundVolume = 0.9f;

            outputItem = new ItemStack(Items.tungsten, 1);

            craftEffect = new RadialEffect(Fx.surgeCruciSmoke, 4, 90f, 5f);

            drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawCircles(){{
                color = Color.valueOf("ffc073").a(0.24f);
                strokeMax = 2.5f;
                radius = 10f;
                amount = 3;
            }}, new DrawLiquidRegion(Liquids.slag), new DrawDefault(), new DrawHeatInput(),
                    new DrawHeatRegion(){{
                        color = Color.valueOf("ff6060ff");
                    }},
                    new DrawHeatRegion("-vents"){{
                        color.a = 1f;
                    }});
            consumeLiquid(Liquids.hydrogen, 12f / 60f);
            consumePower(2f);
        }};

        //distribution

        heavyconveyor = new Conveyor("heavy-conveyor"){{
            requirements(Category.distribution, with(Items.lead, 2, Items.graphite, 1));
            health = 100;
            speed = 0.03f;
            displayedSpeed = 4.2f;
            junctionReplacement = heavyjunction;
            bridgeReplacement = heavybridge;
            alwaysUnlocked = true;
        }};
        heavyrouter = new Router("heavy-router"){{
            requirements(Category.distribution, with(Items.lead, 5, Items.graphite, 2));
            buildCostMultiplier = 4f;
            health = 120;
            researchCost = with(Items.lead, 10, Items.graphite, 4);
        }};
        overflowredirector = new OverflowGate("overflow-redirector"){{
            requirements(Category.distribution, with(Items.lead, 6, Items.graphite, 3));
            buildCostMultiplier = 3f;
            health = 140;
            researchCost = with(Items.lead, 12, Items.graphite, 6);
        }};
        heavysorter = new Sorter("heavy-sorter"){{
            requirements(Category.distribution, with(Items.lead, 8, Items.graphite, 2));
            buildCostMultiplier = 3f;
            health = 140;
            researchCost = with(Items.lead, 16, Items.graphite, 4);
        }};
        heavybridge = new BufferedItemBridge("heavy-bridge"){{
            requirements(Category.distribution, with(Items.lead, 5, Items.graphite, 5));
            fadeIn = moveArrows = false;
            range = 4;
            speed = 74f;
            arrowSpacing = 6f;
            bufferCapacity = 14;
            health = 120;
            researchCost = with(Items.lead, 10, Items.graphite, 10);
        }};
        heavyjunction = new Junction("heavy-junction"){{
            requirements(Category.distribution, with(Items.lead, 3, Items.graphite, 2));
            speed = 26;
            capacity = 6;
            health = 30;
            buildCostMultiplier = 6f;
            health = 120;
            researchCost = with(Items.lead, 6, Items.graphite, 4);
        }};

        //storage

        corebase = new CoreBlock("core-base"){{
            requirements(Category.effect, with( Items.copper, 1));
            size = 4;
            alwaysUnlocked = true;
            isFirstTier = true;
            unitType = oilioUnitTypes.hodor;
            health = 2000;
            itemCapacity = 2000;
            unitCapModifier = 10;
            squareSprite = false;
        }};

        //turret
        //ore

        oresalt = new OreBlock(oilioItems.salt) {{
            oreDefault = false;
        }};
}}