package data.heroes

import data.Attribute
import data.Hero

class Pudge : Hero(
    attribute = Attribute.STRENGTH,
    healthPoint = 700,
    manaPoint = 267,
    firstSkill = Skill(name = "MEAT HOOK", type = Skill.Type.MANA(price = MEAT_HOOK_MANA)),
    secondSkill = Skill(name = "ROT", type = Skill.Type.HEALTH(price = ROT_HEALTH, canDie = false)),
    thirdSkill = Skill(name = "FLESH HEAP", type = Skill.Type.MANA(price = FLESH_HEAP_MANA)),
    ult = Skill(name = "DISMEMBER", type = Skill.Type.MANA(price = DISMEMBER_MANA))
) {

    companion object {

        private const val MEAT_HOOK_MANA = 110
        private const val ROT_HEALTH = 30
        private const val FLESH_HEAP_MANA = 35
        private const val DISMEMBER_MANA = 100
    }
}