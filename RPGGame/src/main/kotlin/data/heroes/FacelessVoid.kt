package data.heroes

import data.Attribute
import data.Hero

class FacelessVoid : Hero(
    attribute = Attribute.AGILITY,
    healthPoint = 600,
    manaPoint = 600,
    firstSkill = Skill(name = "TIME WALK", type = Skill.Type.MANA(price = TIME_WALK_MANA)),
    secondSkill = Skill(name = "TIME DILATION", type = Skill.Type.MANA(price = TIME_DILATION_MANA)),
    thirdSkill = Skill(name ="TIME LOCK", type = Skill.Type.MANA(price = 0)),
    ult = Skill(name = "CHRONOSPHERE", type = Skill.Type.MANA(price = CHRONOSPHERE_MANA))
) {

    companion object {

        private const val TIME_WALK_MANA = 40
        private const val TIME_DILATION_MANA = 60
        private const val CHRONOSPHERE_MANA = 150
    }
}