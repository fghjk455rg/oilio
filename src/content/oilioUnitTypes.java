package content;

import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.gen.MechUnit;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.ammo.PowerAmmoType;
import mindustry.type.unit.ErekirUnitType;

public class oilioUnitTypes {
    public static UnitType
            hodor;

    public static void load() {
        hodor = new ErekirUnitType("hodor"){{
            constructor = MechUnit::create;
            canBoost = true;
            boostMultiplier = 1.5f;
            speed = 1f;
            hitSize = 7f;
            health = 120f;
            buildSpeed = 0.8f;
            alwaysUnlocked = true;
            mineTier = 2;
            mineSpeed = 2f;

            ammoType = new PowerAmmoType(1000);

            weapons.add(new Weapon("oilio-hodor-weapon"){{
                top = false;
                shootY = 2f;
                reload = 30f;
                x = 4.5f;
                alternate = false;
                ejectEffect = Fx.none;
                recoil = 2f;

                bullet = new BasicBulletType(5f, 20){{
                    width = 6f;
                    height = 8f;
                    lifetime = 40f;
                    shootEffect = Fx.shootSmall;
                    smokeEffect = Fx.shootSmallSmoke;
                    buildingDamageMultiplier = 0.1f;
                    healPercent = 5f;
                    collidesTeam = true;
                }};
            }});

        }};
}
}