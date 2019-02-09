package kotlin.com.br.jeferson.breeds.connection

import kotlin.com.br.jeferson.breeds.model.Breed

interface BreedDataSource {

    fun listAll(success : (List<Breed>) -> Unit, failure: () -> Unit)
}
