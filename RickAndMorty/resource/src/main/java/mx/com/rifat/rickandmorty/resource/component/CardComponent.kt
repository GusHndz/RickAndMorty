package mx.com.rifat.rickandmorty.resource.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgeDefaults
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import character.CharacterItemCard
import character.LocationItemCard
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import mx.com.rifat.rickandmorty.resource.R
import mx.com.rifat.rickandmorty.resource.component.common.SpannableText
import mx.com.rifat.rickandmorty.resource.util.ResourceUtils
import util.DomainEnums

@Composable
fun CardComponent(
    modifier: Modifier = Modifier,
    cardEntity: CharacterItemCard
) {
    Card(
        modifier = modifier
            .padding(8.dp)
            .size(128.dp),
        onClick = {

        }
    ) {
        Column(
            modifier = Modifier
                .background(Color.Black),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
            ) {
//                .transformations(CircleCropTransformation())
                AsyncImage(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(cardEntity.image)
                        .crossfade(enable = true)
                        .build(),
                    contentDescription = "",
                    contentScale = ContentScale.Crop
                )

                Icon(
                    modifier = Modifier
                        .size(25.dp)
                        .padding(
                            top = 8.dp,
                            end = 8.dp
                        )
                        .align(Alignment.TopEnd),
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "",
                    tint = if (cardEntity.isAddToFavorite) Color.Red else Color.White
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.Green
                    )
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    ),
                horizontalAlignment = Alignment.Start
            ) {
                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )

                SpannableText(
                    spanText = "Nombre: ",
                    compText = cardEntity.name,
                    colorSpan = Color.Black
                )

                Spacer(
                    modifier = Modifier
                        .height(5.dp)
                )
            }

            Row(
                modifier = Modifier
                    .weight(.4f)
                    .padding(
                        start = 8.dp,
                        end = 8.dp
                    ),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Image(
                    modifier = Modifier
                        .weight(1f),
                    painter = painterResource(
                        id = ResourceUtils.getStatusCharacter(
                            enumStatus = cardEntity.status
                        )
                    ),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .weight(1f),
                    painter = painterResource(
                        id = ResourceUtils.getGenderCharacter(
                            enumGender = cardEntity.gender
                        )
                    ),
                    contentDescription = ""
                )

                Image(
                    modifier = Modifier
                        .weight(1f),
                    painter = painterResource(id = R.drawable.ic_location),
                    contentDescription = ""
                )

                BadgedBox(
                    modifier = Modifier
                        .weight(1f),
                    badge = {
                        Badge {
                            Text(
                                text = "${cardEntity.lstEpisodes.size}"
                            )
                        }
                    }
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_tv),
                        contentDescription = ""
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardPreview() {
    CardComponent(
        cardEntity = CharacterItemCard(
            id = 0,
            name = "Rick",
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
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
