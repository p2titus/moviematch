package films

import common._

import io.circe.generic.semiauto.deriveDecoder
import io.circe.parser
import io.circe.Error

import scala.io.Source.fromURL

class APIException(err: String) extends Exception

trait FilmIt extends Iterator[Film] {
  // modifies the internal state of the film iterator so the previous film is
  // taken as a recommendation
  def recs(x: Film): FilmIt
}

object FilmRecs {
  def getFilmIt: FilmIt = new FilmItImplementation
}

class FilmItImplementation extends FilmIt {
  val x: Iterator[Film] = AccessIMDBApi.getTop250

  override def recs(x: Film): FilmIt = 
    this
  override def hasNext: Boolean = x.hasNext
  override def next(): Film = x.next
}

object AccessIMDBApi {
  private val baseURL: String = "https://imdb-api.com"
  private val lang: String = "en"
  private val fullBase: String = baseURL + "/" + lang +"/API/"
  private val key: String = ""
  def getTop250: Iterator[Film] = {
    val raw: String = getRaw250
    implicit val filmDec = deriveDecoder[Film]
    val decodeResult: Either[Error,List[Film]] = parser.decode[List[Film]](raw)
    detectParseError(decodeResult).iterator
  }

  private def detectParseError[A](x: Either[Error,A]): A = x match {
    case Left(_) => throw new APIException("failed to parse API JSON")
    case Right(e) => e
  }

  private def getRaw250: String = {
    val cat: String = "Top250Movies"
    val get: String = makeGETURL(cat)
    
    fromURL(get).mkString
  }

  private def makeGETURL(cat: String): String = 
    fullBase + cat + key
    
}

