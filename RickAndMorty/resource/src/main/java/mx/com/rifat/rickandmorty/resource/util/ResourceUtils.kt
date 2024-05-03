package mx.com.rifat.rickandmorty.resource.util

import mx.com.rifat.rickandmorty.resource.R
import util.DomainEnums

object ResourceUtils {
    fun getStatusCharacter(enumStatus: DomainEnums.STATUS): Int {
        return when (enumStatus) {
            DomainEnums.STATUS.DEAD -> {
                R.drawable.ic_dead
            }

            DomainEnums.STATUS.ALIVE -> {
                R.drawable.ic_alive
            }

            else -> {
                R.drawable.ic_alive_or_dead
            }
        }
    }

    fun getGenderCharacter(enumGender: DomainEnums.GENDER): Int {
        return when (enumGender) {
            DomainEnums.GENDER.MALE -> {
                R.drawable.ic_male
            }

            DomainEnums.GENDER.FEMALE -> {
                R.drawable.ic_female
            }

            else -> {
                R.drawable.ic_unknow
            }
        }
    }
}