package com.animals.safety.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.animals.safety.R
import com.animals.safety.data.Animal
import com.animals.safety.data.AnimalData
import com.animals.safety.data.Breed
import com.animals.safety.ui.theme.AimantsDanimauxTheme
import java.util.UUID

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
  modifier: Modifier = Modifier,
  animals: List<Animal> = AnimalData.animals,
  onAnimalClick: (Animal?) -> Unit = {},
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = {
          Text(stringResource(id = R.string.home_fragment_label))
        }
      )
    },
    floatingActionButtonPosition = FabPosition.End,
    floatingActionButton = {
      FloatingActionButton(
        onClick = {
          //TODO
        }
      ) {
        Icon(
          imageVector = Icons.Filled.Add,
          contentDescription = "Add an animal"
        )
      }
    }
  ) { contentPadding ->
    HomeListScreen(
      modifier = modifier.padding(contentPadding),
      animals = animals,
      onAnimalClick = onAnimalClick
    )
  }
}

@Composable
private fun HomeListScreen(
  modifier: Modifier = Modifier,
  animals: List<Animal>,
  onAnimalClick: (Animal?) -> Unit,
) {
  LazyColumn(modifier) {
    items(animals) { animal ->
      HomeCellScreen(
        animal = animal,
        onAnimalClick = onAnimalClick
      )
      HorizontalDivider()
    }
  }
}

@Composable
private fun HomeCellScreen(
  animal: Animal,
  onAnimalClick: (Animal?) -> Unit,
) {
  //TODO
  Box(
    modifier = Modifier
      .fillMaxWidth()
      .height(20.dp)
      .clickable {
        onAnimalClick
      }
  )
}

@Preview(showBackground = true)
@Composable
private fun HomeCellScreenPreview() {
  AimantsDanimauxTheme(dynamicColor = false) {
    HomeCellScreen(
      animal = Animal(UUID.randomUUID(),"Milou", Breed.DOG, 6, 23.2f, 42.4f),
      onAnimalClick = {}
    )
  }
}
