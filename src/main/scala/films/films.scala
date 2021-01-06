package films

import common._

trait FilmIt extends Iterator[Film] {
  // modifies the internal state of the film iterator so the previous film is
  // taken as a recommendation
  def recs(x: Film): FilmIt
}

object FilmRecs {
  def getFilmIt: FilmIt = new FilmItImplementation
}

class FilmItImplementation extends FilmIt {

  override def recs(x: Film): FilmIt = 
    this
  override def hasNext: Boolean = true
  override def next(): Film = ???
}

object AccessIMDBApi {
  private val key: String = ""
  def getTop250: Iterator[Film] =

    
}

