package mx.com.rifat.rickandmorty.rickandmorty.ui.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import character.CharacterItemCard
import character.LocationItemCard
import mx.com.rifat.rickandmorty.resource.component.CardComponent
import util.DomainEnums

@Composable
fun HomeScreen() {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        ),
        content = {
            items(100) {
                CardComponent(
                    cardEntity = CharacterItemCard(
                        id = 0,
                        name = "Rick",
                        image = "https://rickandmortyapi.com/api/character/avatar/$it.jpeg",
                        location = LocationItemCard(
                            id = 0,
                            name = "Earth (C-137)",
                            url = "https://rickandmortyapi.com/api/location/1",
                            type = "Planet",
                            dimesion = "Dimension C-137"
                        ),
                        status = DomainEnums.STATUS.ALIVE,
                        gender = DomainEnums.GENDER.MALE,
                        lstEpisodes = mutableListOf(),
                        isAddToFavorite = true
                    )
                )
            }
        })
}

@Preview(showBackground = true)
@Composable
private fun HomePreview() {
    HomeScreen()
}