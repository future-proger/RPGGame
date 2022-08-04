import data.Attribute
import data.heroes.FacelessVoid
import data.heroes.Pudge

fun main() {
    val heroes = arrayOf(Pudge(), FacelessVoid())

    heroes.forEach { hero ->
        hero.firstSkill()
        hero.secondSkill()
        hero.thirdSkill()
        hero.ult()

        println(hero)
        println()
    }
}