package racingcar.domain

import racingcar.domain.RacingCarEngine.FORWARD
import racingcar.domain.RacingCarEngine.NON_FORWARD

private const val MOVE_POS = 1

private const val NAME_MAX_LENGTH = 5

class Car(
    val name: String,
    val pos: Int = 0,
) {

    init {
        require(name.length <= NAME_MAX_LENGTH) {
            "자동차 이름은 5자를 초과할 수 없어요."
        }
    }

    fun race(engine: RacingCarEngine): Car {
        return when (engine) {
            FORWARD -> Car(name, pos + MOVE_POS)
            NON_FORWARD -> this
        }
    }

    fun isWinner(car: Car): Boolean = pos >= car.pos

    fun isDraw(car: Car): Boolean = this.pos == car.pos
}
