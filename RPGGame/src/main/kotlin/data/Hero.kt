package data

import data.heroes.MAX_LEVEL
import data.heroes.NEW_LEVEL
import data.heroes.NEW_LEVEL_EXPERIENCE
import data.heroes.NOT_ENOUGH_MANA

abstract class Hero(

    /**
     * Основной атрибут
     */
    val attribute: Attribute,

    /**
     * Текущий уровень здоровья
     */
    var healthPoint: Int,

    /**
     * Текущий уровень маны
     */
    var manaPoint: Int,

    private val firstSkill: Skill,

    private val secondSkill: Skill,

    private val thirdSkill: Skill,

    private val ult: Skill
) {

    /**
     * Текущее количество опыта
     */
    private var experience: Int = 0

    /**
     * Текущий уровень
     */
    private var level: Int = 1
        private set(value) {
            if (value != field) {
                onNewLevel()
            }

            field = value
        }

    override fun toString(): String {
        return "hp: $healthPoint\n" +
                "mp: $manaPoint\n" +
                "level: $level\n" +
                "exp: $experience"
    }

    /**
     * Первый скилл
     */
    fun firstSkill() = skill(firstSkill)

    /**
     * Второй скилл
     */
    fun secondSkill() = skill(secondSkill)

    /**
     * Третий скилл
     */
    fun thirdSkill() = skill(thirdSkill)

    /**
     * Ульта
     */
    fun ult() = skill(ult)

    private fun skill(skill: Skill) = when (skill.type) {
        is Skill.Type.HEALTH -> {
            println(skill.name)
            if (healthPoint - skill.type.price < 0 && skill.type.canDie) {
                healthPoint = 0
            } else {
                healthPoint -= skill.type.price
            }
        }

        is Skill.Type.MANA -> {
            if (manaPoint - skill.type.price >= 0) {
                manaPoint -= skill.type.price
                println(skill.name)
                checkLevel(skill.type.price)
            } else {
                println(NOT_ENOUGH_MANA)
            }
        }
    }

    /**
     * Бежать
     */
    fun run() = println("Я бегу!")

    /**
     * Прыгать
     */
    fun jump() = println("Я прыгаю!")

    /**
     * Прибавляет используемую ману к опыту, и увеличивает уровень если это необходимо
     *
     * @param usedMana используемая мана
     */
    private fun checkLevel(usedMana: Int) {
        experience += usedMana
        level = if (experience / NEW_LEVEL_EXPERIENCE <= MAX_LEVEL) experience / NEW_LEVEL_EXPERIENCE else MAX_LEVEL
    }

    /**
     * Вызывается когда достигнут новый уровень
     */
    private fun onNewLevel() = println(NEW_LEVEL)

    data class Skill(
        val name: String,
        val type: Type
    ) {
        sealed class Type {

            data class MANA(val price: Int) : Type()

            data class HEALTH(
                val price: Int,
                val canDie: Boolean
            ) : Type()
        }
    }
}