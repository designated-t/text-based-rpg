package stats.weapon

class WeaponModifiers {


    // TODO: Define a structure for item equipping and where these modifiers are stored and calculated exactly.
    // Maybe differenciate between ACTIVE and PASSIVE boons, since passives are static and items can change,
    // or dont because the passive tree can change too.
    enum class MultiplierType(val baseMulti: Float) {
        LOCAL(0f),
        GLOBAL(1f)

        ;
    }
}