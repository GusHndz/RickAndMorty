package util

object DomainUtils {
    fun getStatusCharacter(status: String): DomainEnums.STATUS {
        return when (status.trim().lowercase()) {
            "alive" -> {
                DomainEnums.STATUS.ALIVE
            }

            "dead" -> {
                DomainEnums.STATUS.DEAD
            }

            else -> {
                DomainEnums.STATUS.UNKNOWN
            }
        }
    }

    fun getGenderCharacter(gender: String): DomainEnums.GENDER {
        return when (gender.trim().lowercase()) {
            "male" -> {
                DomainEnums.GENDER.MALE
            }

            "female" -> {
                DomainEnums.GENDER.FEMALE
            }

            else -> {
                DomainEnums.GENDER.UNKNOWN
            }
        }
    }
}