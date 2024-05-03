package character

import util.DomainEnums

data class CharacterItemCard(
    var id: Int,
    var name: String,
    var image: String,
    var location: LocationItemCard?,
    var status: DomainEnums.STATUS = DomainEnums.STATUS.UNKNOWN,
    var gender: DomainEnums.GENDER = DomainEnums.GENDER.UNKNOWN,
    var lstEpisodes: MutableList<String> = mutableListOf(),
    var isAddToFavorite: Boolean = false
)

data class LocationItemCard(
    var id: Int,
    var name: String,
    var url: String,
    var type: String,
    var dimesion: String
)