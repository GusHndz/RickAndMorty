package character

import util.DomainUtils

fun Character.toCharacterDomain(): CharacterItemCard = CharacterItemCard(
    id = this.id ?: 0,
    name = this.name?.trimEnd() ?: "",
    image = this.image ?: "",
    location = this.location?.toLocationCardDomain(),
    status = DomainUtils.getStatusCharacter(this.status ?: ""),
    gender = DomainUtils.getGenderCharacter(this.gender ?: ""),
    lstEpisodes = this.episode.toMutableList()
)

fun Location.toLocationCardDomain(): LocationItemCard = LocationItemCard(
    id = 0,
    name = this.name?.trimEnd() ?: "",
    url = this.url ?: "",
    type = "",
    dimesion = ""
)