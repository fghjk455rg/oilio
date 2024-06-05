package content;

import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.world.Block;
import mindustry.world.blocks.storage.CoreBlock;

import static mindustry.type.ItemStack.with;

public class liincBlocks {

    public static Block
        coreseeker;

    public static void load() {

        coreseeker = new CoreBlock("coreseeker"){{
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


    }
}
